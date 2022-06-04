import javax.crypto.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {

        Scanner userInput = new Scanner(System.in);

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Welcome, what would you like to do (Enter number option)?: " +
                    "\n 1. Save password" +
                    "\n 2. Get password" +
                    "\n 3. Exit.");

            String option = userInput.next();

            if (!option.equals("1") && !option.equals("2") && !option.equals("3")){
                System.out.println("Not a valid option, try again.");
                System.out.println();
            }
            else {
                FileHandler fileHandler = new FileHandler();
                if (option.equals("1")) {
                    boolean passwordSaved = fileHandler.saveInfo();

                    if (passwordSaved) {
                        System.out.println("Password saved.");
                    } else {
                        System.out.println("Error.");
                    }
                } else if (option.equals("2")) {
                    String retrievedPassword = fileHandler.retrieveInfo();
                    System.out.println(retrievedPassword);

                } else{
                    keepRunning = false;
                }
            }
        }
    }

}
