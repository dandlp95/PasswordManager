import java.util.Scanner;

public class UserInfo {
    private String userName;
    private String password;
    private Scanner input = new Scanner(System.in);

    public String getUserName(){
        return userName;
    }

    public void setUserName(){
        System.out.print("Enter the account's username: ");
        String userName = input.nextLine();

        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(){
        System.out.print("Enter the account's password: ");
        String password = input.nextLine();
        this.password = password;
    }
}
