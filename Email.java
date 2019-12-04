package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companyName = "companyname.com";

    // Constructor to receive the first name and last name
    public Email () {
        System.out.print("***Email Application***");

     // Get user first name
        Scanner scannerFirstName = new Scanner (System.in);
        System.out.print("\nEnter your name: ");
        this.firstName = scannerFirstName.next();

     //Get user last name
        Scanner scannerLastName = new Scanner (System.in);
        System.out.print("Enter your last name: ");
        this.lastName = scannerLastName.next();


     // Call a method asking for the department - return the department
        this.department = setDepartment();

     // Call a method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

     // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyName;
    }
    // Ask for the department
    private String setDepartment() {
     System.out.println("\nNew worker: " + firstName + "\nEnter your department code:\n1 for Sales \n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
     Scanner in = new Scanner(System.in);
    int depChoise = in.nextInt();
    if (depChoise == 1) { return "sales"; }
    else if (depChoise == 2) { return "dev"; }
    else if (depChoise == 3) { return "accounting"; }
    else { return ""; }
    }

    // Generate random password
    private String randomPassword (int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@%&";
        char [] password = new char [length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
            }
        return new String (password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) { this.mailboxCapacity = capacity; }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) { this.alternateEmail = altEmail; }

    // Change the password
    public void changePassword (String password) { this.password = password; }

    public int getMailboxCapacity() { return mailboxCapacity;}
    public String getAlternateEmail() { return alternateEmail;}
    public String getPassword() { return password;}

    public String showInfo() {
        return "\nYour name: " + firstName + " " + lastName +
                "\nCompany email: " + email +
                "\nMailbox capacity: " + mailboxCapacity + "mb";
    }

}
