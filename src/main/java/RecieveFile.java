import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntrySelector;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import java.util.Vector;

public class RecieveFile {

    public long recieve() throws Exception {

        ChannelSftp channelSftp = Connection.getChanelSftp();
        Vector<String> filelist=new Vector<String>();

        LsEntrySelector selector = new LsEntrySelector() {
            public int select(LsEntry entry)  {
                final String filename = entry.getFilename();
                if (filename.equals(".") || filename.equals("..")) {
                    return CONTINUE;
                }
                if (entry.getAttrs().isLink()) {
                    //filelist.addElement(filename);
                }
                else if (entry.getAttrs().isDir()) {
                    //if (keepDirectory(filename)) {
                    //filelist.addElement(entry.getFilename());
                    //}
                }
                else {
                    //if (keepFile(filename)) {
                    filelist.addElement(entry.getFilename());
                    //}
                }
                return CONTINUE;
            }
        };
        channelSftp.ls(Constant.SFTP_REPORT_DIR,selector);

        if (filelist.size()<1) {
            return 0;
        }

        for(String fileName : filelist){
            channelSftp.get(Constant.SFTP_REPORT_DIR+fileName, Constant.REPORT_DIR);
            channelSftp.rm(Constant.SFTP_REPORT_DIR+fileName);
        }

        long count = filelist.size();


        Connection.closeAllConnection();
        return count;
    }
}
