import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class CheckFolderDoc {



    public static long fileCount() throws IOException {
        File folder = new File(Constant.docPath);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles==null)
            return 0;
        return Arrays.stream(listOfFiles).filter(File::isFile).count();

    }

    public static void listRecursive(File dir) {
        if (dir.isDirectory()) {
            File[] items = dir.listFiles();
            for (File item : items) {
                System.out.println(item.getAbsoluteFile());
                if (item.isDirectory()) listRecursive(item);
            }
        }
    }

    public long checkDocPath(long fileCount) throws IOException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get(Constant.docPath);
        dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY ,  StandardWatchEventKinds.OVERFLOW);

        System.out.println("Watch Service registered for dir: " + dir.getFileName());

        WatchKey key = null;
        while (true) {
            try {
                // System.out.println("Waiting for key to be signalled...");
                key = watcher.take();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException: " + ex.getMessage());
                return fileCount;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                // Retrieve the type of event by using the kind() method.
                WatchEvent.Kind<?> kind = event.kind();
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path fileName = ev.context();
                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    fileCount++;
                    System.out.printf("A new file %s was created.%n", fileName.getFileName());
                } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                   // System.out.printf("A file %s was modified.%n", fileName.getFileName());
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    fileCount--;
                    System.out.printf("A file %s was deleted.%n", fileName.getFileName());
                } else if (kind == StandardWatchEventKinds.OVERFLOW) {
                    System.out.printf("A file %s was overflow.%n", fileName.getFileName());
                }
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
        return fileCount;
    }

}
