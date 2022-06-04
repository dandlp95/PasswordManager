import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHandler {
    public static final String CRYPTO_KEY = "ASD123ASD123ASD2";
    private static final String UNICODE_FORMAT = "UTF-8";
    private SecretKeySpec key;
    private Cipher cipher;


    public PasswordHandler() throws NoSuchPaddingException, NoSuchAlgorithmException {
         byte [] keyByte = CRYPTO_KEY.getBytes();
         this.key = new SecretKeySpec(keyByte, "AES");
         this.cipher = Cipher.getInstance("AES");
    }

    public byte[] encrypt(String password) throws UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] text = password.getBytes(UNICODE_FORMAT);
        this.cipher.init(Cipher.ENCRYPT_MODE, this.key);
        byte[] textEncrypted = this.cipher.doFinal(text);

        return textEncrypted;
    }
    public String decrypt(byte[] password) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        this.cipher.init(Cipher.DECRYPT_MODE, this.key);
        byte[] textDecrypted = this.cipher.doFinal(password);
        String result = new String(textDecrypted);

        return result;
    }

}