import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class FileHandler {

    private PasswordHandler passwordHandler;
    Scanner userInput = new Scanner(System.in);


    public FileHandler() throws NoSuchPaddingException, NoSuchAlgorithmException {

        this.passwordHandler = new PasswordHandler();
    }

    boolean saveInfo() throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        System.out.print("Enter the name of the account: ");
        // userInput.nextLine();
        String accountName = userInput.nextLine();

        System.out.print("Enter the password: ");
        String password = userInput.nextLine();

        byte[] encryptedPassword = passwordHandler.encrypt(password);

        try {
            File file = new File(accountName);
            Path path = Paths.get(accountName);
            Files.write(path, encryptedPassword);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    String retrieveInfo() {
        System.out.print("Enter the name of the account: ");
        String accountName = userInput.nextLine();

        try {
            Path path = Paths.get(accountName);
            byte[] encryptedPassword = Files.readAllBytes(path);
            String decryptedPassword = passwordHandler.decrypt(encryptedPassword);
            return decryptedPassword;
        } catch (Exception e){
            return "Failed to decrypt password";
        }

    }
}
