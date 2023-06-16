package email_app;

import java.util.Scanner;

public class Email {
    public String firstName;
    public String lastName;
    public String department;
    public String email;

    private String password;

    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "company.com";

//    constructor that collects first name and last name
    public Email(String firstName, String lastName) {


    this.firstName = firstName;
    this.lastName = lastName;
    this.department = setDepartment();
    this.password = randomPassword(defaultPasswordLength);
    this.email = this.firstName.toLowerCase()+ "."+ this.lastName.toLowerCase()+ "@" + this.department + "." + companySuffix;

    }

// Asking user for their department
    private String setDepartment() {

        System.out.println("Hi "+ this.firstName +" " + this.lastName + ", \nDepartment codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter your department's code");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        while (depChoice < 0 || depChoice > 3) {
            System.out.println("Error: Please enter a valid answer, try again\n Department codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter your department's code");
            depChoice = scanner.nextInt();
        }
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }


    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!.?@£$#&*,";
        char[] password = new char[length];
for (int i = 0; i<length; i++){
    int rand = (int) (Math.random() * passwordSet.length());
    password[i] = passwordSet.charAt(rand);
}
        return new String(password);
    }

//    setting Mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

//    Change generated password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo() {
        return "Display name: " + firstName + " " + lastName +
               "\nCompany email:" + email +
                "\nMailbox capacity: " + mailBoxCapacity;
    }


}
