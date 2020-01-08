import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileWorker extends SwingWorker<List<Long> ,Long> {

    JLabel label;

    CheckFolderDoc checkFolderDoc;

    long fileCount;

    public FileWorker(JLabel label , long fileCount) {
        this.label = label;
        checkFolderDoc = new CheckFolderDoc();
        this.fileCount = fileCount;
    }

    @Override
    protected List<Long> doInBackground() throws Exception {
        List<Long> numbers = new ArrayList<>();
        checkFolderDoc.checkDocPath(fileCount);
        numbers.add(fileCount);
        publish(fileCount);
        System.out.println(fileCount);
        return numbers;
    }

    @Override
    protected void process(List<Long> chunks) {
        for (Long number : chunks) {
            label.setText(number.toString());
        }
    }

//    @Override
//    protected void done() {
//        super.done();
//        label.setText(String.valueOf(fileCount));
//        System.out.println(fileCount);
//    }
}
