package test;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class GenKey {


    private boolean isArmored = false;
    private String id = "damico";
    private String passwd = "******";
    private boolean integrityCheck = true;


    private String pubKeyFile = "tmp/pub.ppk";
    private String privKeyFile = "tmp/secret.ppk";

    private String plainTextFile = "tmp/plain-text.txt"; //create a text file to be encripted, before run the tests
    private String cipherTextFile = "tmp/cypher-text.dat";
    private String decPlainTextFile = "tmp/dec-plain-text.txt";

    @Test
    public void genKey() throws InvalidKeyException, NoSuchProviderException, SignatureException, IOException, PGPException, NoSuchAlgorithmException {

        RSAKeyPairGenerator rkpg = new RSAKeyPairGenerator();

        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator    kpg = KeyPairGenerator.getInstance("RSA", "BC");

        kpg.initialize(2048);

        KeyPair                    kp = kpg.generateKeyPair();

        FileOutputStream    out1 = new FileOutputStream(privKeyFile);
        FileOutputStream    out2 = new FileOutputStream(pubKeyFile);

        rkpg.exportKeyPair(out1, out2, kp.getPublic(), kp.getPrivate(), id, passwd.toCharArray(), isArmored);


    }

}
