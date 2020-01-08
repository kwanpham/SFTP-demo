import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class FileWorker2 extends SwingWorker<Void, PropertyChangeEvent> {

    public static final String FILE_DELETED = ENTRY_DELETE.name();
    public static final String FILE_CREATED = ENTRY_CREATE.name();
    public static final String FILE_MODIFIED = ENTRY_MODIFY.name();

    // final version will keep a map of keys/directories (just as in the tutorial example)
    private Path directory;
    private WatchService watcher;
    private long fileCount;


    public FileWorker2(File file , long fileCount) throws IOException {
        this.fileCount = fileCount;
        directory = file.toPath();
        watcher = FileSystems.getDefault().newWatchService();
        directory.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (;;) {
            // wait for key to be signalled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return null;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                // TBD - provide example of how OVERFLOW event is handled
                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    fileCount++;
                   // System.out.printf("A new file %s was created.%n", fileName.getFileName());
                } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    // System.out.printf("A file %s was modified.%n", fileName.getFileName());
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    fileCount--;
                    //System.out.printf("A file %s was deleted.%n", fileName.getFileName());
                } else if (kind == StandardWatchEventKinds.OVERFLOW) {
                    //ystem.out.printf("A file %s was overflow.%n", fileName.getFileName());
                    continue;
                }
                publish(createChangeEvent(fileCount, key));
            }

            // reset key return if directory no longer accessible
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
        return null;
    }

    /**
     * Creates and returns the change notification. This method is called from the
     * worker thread while looping through the events as received from the Watchkey.
     *
     * @param event
     * @param key
     */
    protected PropertyChangeEvent createChangeEvent(long fileCount, WatchKey key) {

        PropertyChangeEvent e = new PropertyChangeEvent(this, "count", null, fileCount);
        return e;
    }

    @Override
    protected void process(List<PropertyChangeEvent> chunks) {
        super.process(chunks);
        for (PropertyChangeEvent event : chunks) {
            getPropertyChangeSupport().firePropertyChange(event);
        }
    }
}