import com.jcraft.jsch.ChannelSftp;
import org.apache.commons.io.FilenameUtils;
import org.bouncycastle.openpgp.PGPException;
import org.junit.Test;
import test.PgpHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class SendFile {

    public long send() throws Exception {

        File folder = new File(Constant.docPath);
        File[] listOfFiles = folder.listFiles();


        if (isDirHasNoFile(listOfFiles)) {
            return 0;
        }

    /*Below we have declared and defined the SFTP HOST, PORT, USER
            and Local private key from where you will make connection */
        ChannelSftp channelSftp = Connection.getChanelSftp();
        long count = 0;
        for (File file : listOfFiles) {
            if (file.isFile() && (FilenameUtils.getExtension(file.getName()).equals("txt"))) {
                String cipherTextFile = encryptFile(file);
                channelSftp.put(Constant.backupEncryptPath + cipherTextFile, Constant.SFTP_ENCRYPT_DIR + cipherTextFile);
                count++;
            }
        }

        moveFileAfterEncrypt();

        Connection.closeAllConnection();
        return count;

    }


    public boolean isDirHasNoFile(File[] listOfFiles) throws IOException {
        long count = Arrays.stream(listOfFiles).filter(File::isFile).count();
        return count < 1;
    }

    private String encryptFile(File file) throws IOException, PGPException {
        FileInputStream pubKeyIs = new FileInputStream(Constant.pubKeyFile);
        String cipherFileName = file.getName().replaceFirst("[.][^.]+$", "") + ".pgp";
        FileOutputStream cipheredFileIs = new FileOutputStream(Constant.backupEncryptPath + cipherFileName);
        PgpHelper.getInstance().encryptFile(cipheredFileIs, file.getPath(), PgpHelper.getInstance().readPublicKey(pubKeyIs), isArmored, integrityCheck);
        cipheredFileIs.close();
        pubKeyIs.close();
        return cipherFileName;
    }

    private void moveFileAfterEncrypt() throws IOException {
        File folder = new File(Constant.docPath);
        File[] listOfFiles = folder.listFiles();


        for (File file : listOfFiles) {

            if (file.isFile() && (FilenameUtils.getExtension(file.getName()).equals("txt"))) {
                Path sourcepath = Paths.get(file.getPath());
                Path destinationepath = Paths.get(Constant.backupOriginalPath + file.getName());
                Files.move(sourcepath, destinationepath, StandardCopyOption.REPLACE_EXISTING);
            } else if (file.isFile() && (!FilenameUtils.getExtension(file.getName()).equals("txt"))){
                Path sourcepath = Paths.get(file.getPath());
                Path destinationepath = Paths.get(Constant.OTHER_DIR + file.getName());
                Files.move(sourcepath, destinationepath, StandardCopyOption.REPLACE_EXISTING);
            }
        }

//        folder = new File(Constant.ENCRYPT_DIR);
//        listOfFiles = folder.listFiles();
//
//        for (File file : listOfFiles) {
//            if(file.isFile()) {
//                Path sourcepath = Paths.get(file.getPath());
//                Path destinationepath = Paths.get(Constant.backupEncryptPath + file.getName());
//                Files.move(sourcepath, destinationepath, StandardCopyOption.ATOMIC_MOVE);
//            }
//        }
    }

    @Test
    public void test() throws IOException {
        File file = new File("tmp/plain-text.txt");
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParentFile());
        System.out.println(file.getName().replaceFirst("[.][^.]+$", "") + ".pgp");
    }


    private static boolean isArmored = false;
    private static boolean integrityCheck = true;


}
