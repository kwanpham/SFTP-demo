import com.jcraft.jsch.*;

public class Connection {

    public static final String SFTPHOST = "10.10.4.2";
    public static final int SFTPPORT = 22;
    public static final String SFTPUSER = "mk_ibk";
    public static final String SFTPASSWORD = "Mksmart@2020";


    private static Session session = null;
    private static Channel channel  = null;
    private static ChannelSftp channelSftp = null;

    public static ChannelSftp getChanelSftp() throws JSchException {



        JSch jSch = new JSch();
        jSch.addIdentity(Constant.privKeyFile);
        session = jSch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
        System.out.println("session created.");

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setPassword(SFTPASSWORD);
        session.connect();
        channel = session.openChannel("sftp");
        channel.connect();
        System.out.println("shell channel connected....");
        channelSftp = (ChannelSftp)channel;
        return channelSftp;
    }

    public static void closeAllConnection() {
        if(channelSftp!=null){
            channelSftp.disconnect();
            channelSftp.exit();
        }

        if(session!=null) session.disconnect();
    }
}
