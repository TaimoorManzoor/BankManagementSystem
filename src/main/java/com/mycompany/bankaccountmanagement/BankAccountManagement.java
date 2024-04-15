/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bankaccountmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BankAccountManagement {

    ArrayList<String> Firstname = new ArrayList();
    ArrayList<String> Lastname = new ArrayList();
    ArrayList<String> Account_No = new ArrayList();
    ArrayList<String> CNIC = new ArrayList();
    ArrayList<String> Email = new ArrayList();
    ArrayList<String> Password = new ArrayList();
    ArrayList<Integer> Total = new ArrayList();
    ArrayList<String> Mobile = new ArrayList();

    HashMap<String, String> a = new HashMap();

    Map<String, HashMap> map_email = new HashMap();
    Map<String, HashMap> map_mobile = new HashMap();
    Map<String, HashMap> map_cnic = new HashMap();
    Map<String, HashMap> map_account = new HashMap();

    Scanner inputs = new Scanner(System.in);

    public void Welcome() {
        int n = 1;
        while (n != 0) {
            System.out.println("===Welcome to MyBank===");
            System.out.println("Enter  1 : Open Account");
            System.out.println("Enter  2 : Search Account");
            System.out.println("Enter  3 : Edit Account");
            System.out.println("Enter  4 : Delete Account ");
            System.out.println("Enter  5 : View All Account");
            System.out.println("Enter  6 : Login");
            Scanner inputs = new Scanner(System.in);
            n = inputs.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.println("Open Account");
                    openAccount();
                }
                case 2 -> {
                    System.out.println("Search");
                    Search();
                }

                case 3 -> {
                    System.out.println("Edit Account");
                    updateAccount_No();
                }

                case 4 ->
                    DeleteAccount_No();

                case 5 -> {
                    System.out.println("View All Account");
                    ViewAllAccount();
                }
                case 6 -> {

                    login();
                }
                default ->
                    System.out.println("Incorrect Option");
            }

        }
    }

    public static void main(String[] args) {
        BankAccountManagement obj = new BankAccountManagement();
        obj.Welcome();
    }

    public void openAccount() {
        System.out.print("Let's Open Your Account in MyBank\n");

        System.out.print("Enter your First Name: ");
        String temp_firstname = inputs.next();
        Firstname.add(temp_firstname);
        a.put("First_Name", temp_firstname);

        System.out.print("Enter your Last Name: ");
        String temp_lastname = inputs.next();
        Lastname.add(temp_lastname);
        a.put("Last_name", temp_lastname);

        System.out.print("Enter your Account Number: ");
        String temp_account_no = inputs.next();
        Account_No.add(temp_account_no);
        a.put("Account_No", temp_account_no);

        System.out.print("Enter your CNIC: ");
        String temp_CNIC = inputs.next();
        CNIC.add(temp_CNIC);
        a.put("CNIC", temp_CNIC);

        System.out.print("Enter your Email: ");
        String temp_Email = inputs.next();
        Email.add(temp_Email);
        a.put("Email", temp_Email);

        System.out.print("Enter your Password: ");
        String temp_Password = inputs.next();
        Password.add(temp_Password);
        a.put("Password", temp_Password);

        System.out.print("Enter your Phone number: ");
        String temp_mobile = inputs.next();
        Mobile.add(temp_mobile);
        a.put("Mobile", temp_mobile);

        System.out.print("Enter your First Amount: ");
        int temp_total = inputs.nextInt();
        Total.add(temp_total);
        a.put("Total", Integer.toString(temp_total));

        map_email.put(temp_Email, new HashMap<>(a));
        map_mobile.put(temp_mobile, new HashMap<>(a));
        map_cnic.put(temp_CNIC, new HashMap<>(a));
        map_account.put(temp_account_no, new HashMap<>(a));
    }

    // Search Property
    public void Search() {
        System.out.println("Select the Method From which are you want to search");
        System.out.println("Enter 1 From Mobile");
        System.out.println("Enter 2 From CNIC");
        System.out.println("Enter 3 From Account_No");
        System.out.println("Enter 4 From Email");

        int n = inputs.nextInt();

        switch (n) {
            case 1 -> {

                SearchMobile();
                break;
            }
            case 2 -> {

                SearchCNIC();
                break;
            }
            case 3 -> {

                SearchAccount_No();
                break;
            }
            case 4 -> {

                SearchEmail();
                break;
            }

        }

    }

    public void SearchMobile() {
        System.out.println("Enter the Cell Phone ");
        String search_mobile = inputs.next();
        int count = 0;

        System.out.println("Mobile Number | First Name | Last Name | CNIC        | Account No | Email  ");

        Set<Map.Entry<String, HashMap>> entrySet = map_mobile.entrySet();
        Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashMap> entry = iterator.next();
            String phoneNumber = entry.getKey();
            HashMap<String, String> studentData = entry.getValue();

            if (phoneNumber.equals(search_mobile)) {
                System.out.printf("%-12s| %-11s| %-10s| %-12s| %-14s| %s%n",
                        phoneNumber,
                        studentData.get("First_Name"),
                        studentData.get("Last_name"),
                        studentData.get("CNIC"),
                        studentData.get("Account_No"),
                        studentData.get("Email")
                );
                count++;
            }

        }
        if (count < 1) {
            System.out.println("Data is Not Found");
        }

    }

    public void SearchCNIC() {
        System.out.println("Enter the CNIC ");
        String search_mobile = inputs.next();
        int count = 0;

        System.out.println("CNIC| First Name | Last Name | Mobile Number         | Account No | Email  ");

        Set<Map.Entry<String, HashMap>> entrySet = map_cnic.entrySet();
        Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashMap> entry = iterator.next();
            String phoneNumber = entry.getKey();
            HashMap<String, String> studentData = entry.getValue();

            if (phoneNumber.equals(search_mobile)) {
                System.out.printf("%-12s| %-11s| %-10s| %-12s| %-14s| %s%n",
                        phoneNumber,
                        studentData.get("First_Name"),
                        studentData.get("Last_name"),
                        studentData.get("Mobile"),
                        studentData.get("Account_No"),
                        studentData.get("Email")
                );
                count++;
            }

        }
        if (count < 1) {
            System.out.println("Data is Not Found");
        }
    }

    public void SearchAccount_No() {
        System.out.println("Enter the Account NUMBER ");
        String search_mobile = inputs.next();
        int count = 0;

        System.out.println(" Account No| First Name | Last Name | Mobile Number         | CNIC | Email  ");

        Set<Map.Entry<String, HashMap>> entrySet = map_account.entrySet();
        Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashMap> entry = iterator.next();
            String phoneNumber = entry.getKey();
            HashMap<String, String> studentData = entry.getValue();

            if (phoneNumber.equals(search_mobile)) {
                System.out.printf("%-12s| %-11s| %-10s| %-12s| %-14s| %s%n",
                        phoneNumber,
                        studentData.get("First_Name"),
                        studentData.get("Last_name"),
                        studentData.get("CNIC"),
                        studentData.get("Mobile"),
                        studentData.get("Email")
                );
                count++;
            }

        }
        if (count < 1) {
            System.out.println("Data is Not Found");
        }
    }

    public void SearchEmail() {
        System.out.println("Enter the Email ");
        String search_mobile = inputs.next();
        int count = 0;

        System.out.println("Email | First Name | Last Name | Mobile Number         | CNIC | Account No  ");

        Set<Map.Entry<String, HashMap>> entrySet = map_email.entrySet();
        Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashMap> entry = iterator.next();
            String phoneNumber = entry.getKey();
            HashMap<String, String> studentData = entry.getValue();

            if (phoneNumber.equals(search_mobile)) {
                System.out.printf("%-12s| %-11s| %-10s| %-12s| %-14s| %s%n",
                        phoneNumber,
                        studentData.get("First_Name"),
                        studentData.get("Last_name"),
                        studentData.get("Mobile"),
                        studentData.get("CNIC"),
                        studentData.get("Account_No")
                );
                count++;
            }

        }
        if (count < 1) {
            System.out.println("Data is Not Found");
        }
    }

    public void ViewAllAccount() {

        int count = 0;

        System.out.println("Account Number | First Name | Last Name | CNIC        | Mobile No | Email  ");

        Set<Map.Entry<String, HashMap>> entrySet = map_account.entrySet();
        Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashMap> entry = iterator.next();
            String phoneNumber = entry.getKey();
            HashMap<String, String> studentData = entry.getValue();

            System.out.printf("%-12s| %-11s| %-10s| %-12s| %-14s| %s%n",
                    phoneNumber,
                    studentData.get("First_Name"),
                    studentData.get("Last_name"),
                    studentData.get("CNIC"),
                    studentData.get("Mobile"),
                    studentData.get("Email")
            );
            count++;

        }
        if (count < 1) {
            System.out.println("Data is Not Found");
        }
    }

    public void updateAccount_No() {
        String accountUpdate;
        String temp_firstname = null;
        String temp_lastname = null;
        String temp_CNIC = null;
        String temp_Email = null;
        String temp_Password = null;
        String temp_mobile = null;
        int temp_total = 0;
        System.out.println("In Which Account are you want to update\n Write the account no: ");
        accountUpdate = inputs.next();

        // Check if the key exists in map_email
        if (map_account.containsKey(accountUpdate)) {
            // Retrieve the inner HashMap

            Set<Map.Entry<String, HashMap>> entrySet = map_account.entrySet();
            Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, HashMap> entry = iterator.next();
                String phoneNumber = entry.getKey();
                HashMap<String, String> studentData = entry.getValue();

                if (phoneNumber.equals(accountUpdate)) {

                    phoneNumber = studentData.get("Account_No");
                    temp_firstname = studentData.get("First_Name");
                    temp_lastname = studentData.get("Last_name");
                    temp_mobile = studentData.get("Mobile");
                    temp_Email = studentData.get("Email");
                    a.put("Account_No", phoneNumber);

                }
            }

            HashMap<String, String> innerMap = map_account.get(accountUpdate);
//------------------------------------------------------------------------------------------------
            int n;
            System.out.println("Do you Want to update First Name : ");
            System.out.println("Press 1 For Yes \nPress 2 For No");

            n = inputs.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter the First Name");
                    temp_firstname = inputs.next();
                    Firstname.add(temp_firstname);
                    a.put("First_Name", temp_firstname);
                    break;
                case 2:
                    Firstname.add(temp_firstname);
                    a.put("First_Name", temp_firstname);
                    break;

                default:
                    Firstname.add(temp_firstname);
                    a.put("First_Name", temp_firstname);
                    break;
            }
//------------------------------------------------------------------------------------------------
            System.out.println("Do you Want to update Last Name : ");
            System.out.println("Press 1 For Yes \nPress 2 For No");

            n = inputs.nextInt();
            switch (n) {
                case 1:

                    System.out.print("Enter your lastname: ");
                    temp_lastname = inputs.next();
                    Lastname.add(temp_lastname);
                    a.put("Last_name", temp_lastname);
                    break;
                case 2:

                    Lastname.add(temp_lastname);
                    a.put("Last_name", temp_lastname);
                    break;
                default:
                    Lastname.add(temp_lastname);
                    a.put("Last_name", temp_lastname);
                    break;

            }
//------------------------------------------------------------------------------------------------
            System.out.println("Do you Want to update CNIC NO : ");
            System.out.println("Press 1 For Yes \nPress 2 For No");

            n = inputs.nextInt();
            switch (n) {
                case 1:

                    System.out.print("Enter your CNIC: ");
                    temp_CNIC = inputs.next();
                    CNIC.add(temp_CNIC);
                    a.put("CNIC", temp_CNIC);
                    break;
                case 2:

                    CNIC.add(temp_CNIC);
                    a.put("Last_name", temp_CNIC);
                    break;
                default:

                    CNIC.add(temp_CNIC);
                    a.put("Last_name", temp_CNIC);
                    break;
            }
//------------------------------------------------------------------------------------------------

            System.out.println("Do you Want to update Email : ");
            System.out.println("Press 1 For Yes \nPress 2 For No");

            n = inputs.nextInt();
            switch (n) {
                case 1:

                    System.out.print("Enter your Email: ");
                    temp_Email = inputs.next();
                    Email.add(temp_Email);
                    a.put("Email", temp_Email);
                    break;
                case 2:
                    Email.add(temp_Email);
                    a.put("Email", temp_Email);
                    break;
                default:
                    Email.add(temp_Email);
                    a.put("Email", temp_Email);
                    break;
            }
//------------------------------------------------------------------------------------------------
            System.out.println("Do you Want to update Password : ");
            System.out.println("Press 1 For Yes \nPress 2 For No");

            n = inputs.nextInt();
            switch (n) {
                case 1:

                    System.out.print("Enter your Password: ");
                    temp_Password = inputs.next();
                    Password.add(temp_Password);
                    a.put("Password", temp_Password);
                    break;
                case 2:

                    Password.add(temp_Password);
                    a.put("Password", temp_Password);
                    break;
                default:
                    Password.add(temp_Password);
                    a.put("Password", temp_Password);
                    break;
            }
//------------------------------------------------------------------------------------------------
            System.out.println("Do you Want to update mOBILE : ");
            System.out.println("Press 1 For Yes \nPress 2 For No");

            n = inputs.nextInt();
            switch (n) {
                case 1:

                    System.out.print("Enter your Phone number: ");
                    temp_mobile = inputs.next();
                    Mobile.add(temp_mobile);
                    a.put("Mobile", temp_mobile);
                    break;
                case 2:

                    Mobile.add(temp_mobile);
                    a.put("Mobile", temp_mobile);
                    break;
                default:

                    Mobile.add(temp_mobile);
                    a.put("Mobile", temp_mobile);
                    break;
            }

            //------------------------------------------------------------------------------------------------        
            System.out.println("Do you Want to update First Amount : ");
            System.out.println("Press 1 For Yes \nPress 2 For No");
            int in = inputs.nextInt();
            switch (in) {
                case 1:

                    System.out.print("Enter your First Amount: ");
                    temp_total = inputs.nextInt();
                    Total.add(temp_total);
                    a.put("Total", Integer.toString(temp_total));
                    break;
                case 2:
                    Total.add(temp_total);
                    a.put("Total", Integer.toString(temp_total));
                    break;
                default:
                    Total.add(temp_total);
                    a.put("Total", Integer.toString(temp_total));
                    break;
            }
//------------------------------------------------------------------------------------------------
            // Update the inner HashMap back in map_email
            map_account.put(accountUpdate, a);
            map_cnic.put(temp_CNIC, a);
            map_email.put(temp_Email, a);
            map_mobile.put(temp_mobile, a);

            // Display the updated map_email
            System.out.println("The Account is updated Sucessfully ");
        } else {
            System.out.println("Data is not exist");
        }
    }

    public void login() {
        System.out.println("" + map_email);
        String email;
        System.out.println("Enter your Email");
        email = inputs.next();

        String Password;
        System.out.println("Enter your Password");
        Password = inputs.next();

        Set<Map.Entry<String, HashMap>> entrySet = map_email.entrySet();
        Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashMap> entry = iterator.next();
            String phoneNumber = entry.getKey();
            HashMap<String, String> studentData = entry.getValue();

            System.out.println("  Email: " + phoneNumber + "  Password: " + studentData.get("Password"));
            if (phoneNumber.equals(email) && studentData.get("Password").equals(Password)) {
                System.out.println("You are Login Sucessfully");
                dashboad(email);
            } else {
                System.out.println("You Have Not Account");
            }

        }

    }

    public void dashboad(String email) {
        System.out.println("Welcome TO Dashboad");

        Set<Map.Entry<String, HashMap>> entrySet = map_email.entrySet();
        Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashMap> entry = iterator.next();
            String phoneNumber = entry.getKey();
            HashMap<String, String> studentData = entry.getValue();

            if (phoneNumber.equals(email)) {
                System.out.println("Name: " + studentData.get("First_Name"));
                System.out.println("Account No : " + studentData.get("Account_No"));

                int n = 1;
                while (n != 0) {
                    System.out.println("-------Welcome to MybANK-------");
                    System.out.println("Enter  1 : Balance Enquiry");
                    System.out.println("Enter  2 : Cash Transfer");
                    System.out.println("Enter  3 : Withdraw Cash");
                    System.out.println("Enter  4 : Deposit Cash");
                    System.out.println("Enter  5 : LogOut");

                    Scanner inputs = new Scanner(System.in);
                    n = inputs.nextInt();
                    switch (n) {
                        case 1:
                            System.out.println("Welcome to Balance Enquiry");
                            Balance_Inquiry(studentData.get("Total"), studentData.get("Account_No"), studentData.get("Mobile"), phoneNumber, studentData.get("CNIC"));
                            break;
                        case 2:
                            System.out.println("Welcome to Cash Transfer");
                            CashTransfer(studentData.get("Total"), studentData.get("Account_No"), studentData.get("Mobile"), phoneNumber, studentData.get("CNIC"));
                            break;

                        case 3:
                            System.out.println("Welcome to Withdraw Cash");
                            Withdraw(studentData.get("Total"), studentData.get("Account_No"), studentData.get("Mobile"), phoneNumber, studentData.get("CNIC"));
                            break;

                        case 4:
                            System.out.println("Welcome to Deposit Cash");
                            Deposit(studentData.get("Total"), studentData.get("Account_No"), studentData.get("Mobile"), phoneNumber, studentData.get("CNIC"));
                            break;

                        case 5:

                            System.out.println("LogOut Sucessfully");
                            Welcome();
                            break;
                        default:
                            System.out.println("Incorrect Option");
                            break;
                    }

                }

            }

        }

    }

    public void Balance_Inquiry(String total_amount, String Account_no, String phone_no, String email, String cnic) {
        System.out.println("Your Current Amount: " + total_amount + " Rs");
    }

    public void CashTransfer(String total_amount, String Account_no, String phone_no, String email, String cnic) {
        float CashTransfer;
        int total = Integer.parseInt(total_amount);
        System.out.println("How much money do you wanted to Cash Transfer?");
        Scanner inputs = new Scanner(System.in);
        CashTransfer = inputs.nextFloat();
        if (CashTransfer < 0) {
            System.out.println("Alert: Negative value is not Allow");
        } else {
            if (CashTransfer > total) {
                System.out.println("Insufficient Balance. Unable to complete CashTransfer");
            } else {
                total -= CashTransfer;
                System.out.println("Money has transferred successfully");

                // Update the "Total" value in the map_email map
                HashMap<String, String> updatedData = map_email.get(email);

                if (updatedData != null) {
                    updatedData.put("Total", String.valueOf(total));
                    map_email.put(email, updatedData);
                }

                // Update the "Total" value in the map_email map
                HashMap<String, String> updatedDatacnic = map_cnic.get(cnic);

                if (updatedDatacnic != null) {
                    updatedDatacnic.put("Total", String.valueOf(total));
                    map_email.put(cnic, updatedDatacnic);
                }
                // Update the "Total" value in the map_email map
                HashMap<String, String> updatedDataphone = map_mobile.get(phone_no);

                if (updatedDataphone != null) {
                    updatedDataphone.put("Total", String.valueOf(total));
                    map_mobile.put(phone_no, updatedDataphone);
                }

                // Update the "Total" value in the map_email map
                HashMap<String, String> updatedDataaccount = map_account.get(Account_no);

                if (updatedDataaccount != null) {
                    updatedDataaccount.put("Total", String.valueOf(total));
                    map_mobile.put(Account_no, updatedDataaccount);

                }
            }
        }
    }

    public void Withdraw(String total_amount, String Account_no, String phone_no, String email, String cnic) {
        float withdraw;
        int total = Integer.parseInt(total_amount);
        System.out.println("How much money do you wanted to withdraw?");
        Scanner inputs = new Scanner(System.in);
        withdraw = inputs.nextFloat();
        if (withdraw < 0) {
            System.out.println("Alert: Negative value is not Allow");
        } else {
            if (withdraw > total) {
                System.out.println("Insufficient Balance. Unable to complete withdraw");
            } else {
                total -= withdraw;
                System.out.println("Money has transferred successfully");

                // Update the "Total" value in the map_email map
                HashMap<String, String> updatedData = map_email.get(email);

                if (updatedData != null) {
                    updatedData.put("Total", String.valueOf(total));
                    map_email.put(email, updatedData);

                }

                // Update the "Total" value in the map_email map
                HashMap<String, String> updatedDatacnic = map_cnic.get(cnic);

                if (updatedDatacnic != null) {
                    updatedDatacnic.put("Total", String.valueOf(total));
                    map_email.put(cnic, updatedDatacnic);

                }
                // Update the "Total" value in the map_email map
                HashMap<String, String> updatedDataphone = map_mobile.get(phone_no);

                if (updatedDataphone != null) {
                    updatedDataphone.put("Total", String.valueOf(total));
                    map_mobile.put(phone_no, updatedDataphone);

                }

                // Update the "Total" value in the map_email map
                HashMap<String, String> updatedDataaccount = map_account.get(Account_no);

                if (updatedDataaccount != null) {
                    updatedDataaccount.put("Total", String.valueOf(total));
                    map_mobile.put(Account_no, updatedDataaccount);

                }
            }
        }
    }

    public void Deposit(String total_amount, String Account_no, String phone_no, String email, String cnic) {
        float deposit;
        int total = Integer.parseInt(total_amount);
        System.out.println("How much money do you wanted to deposit?");
        Scanner inputs = new Scanner(System.in);
        deposit = inputs.nextFloat();
        if (deposit < 0) {
            System.out.println("Alert: Negative value is not Allow");
        } else {

            total += deposit;
            System.out.println("Money has deposit successfully");

            // Update the "Total" value in the map_email map
            HashMap<String, String> updatedData = map_email.get(email);

            if (updatedData != null) {
                updatedData.put("Total", String.valueOf(total));
                map_email.put(email, updatedData);
            }

            // Update the "Total" value in the map_email map
            HashMap<String, String> updatedDatacnic = map_cnic.get(cnic);

            if (updatedDatacnic != null) {
                updatedDatacnic.put("Total", String.valueOf(total));
                map_email.put(cnic, updatedDatacnic);

            }
            // Update the "Total" value in the map_email map
            HashMap<String, String> updatedDataphone = map_mobile.get(phone_no);

            if (updatedDataphone != null) {
                updatedDataphone.put("Total", String.valueOf(total));
                map_mobile.put(phone_no, updatedDataphone);

            }

            // Update the "Total" value in the map_email map
            HashMap<String, String> updatedDataaccount = map_account.get(Account_no);

            if (updatedDataaccount != null) {
                updatedDataaccount.put("Total", String.valueOf(total));
                map_mobile.put(Account_no, updatedDataaccount);

            }
        }
    }

    public void DeleteAccount_No() {
        System.out.println("Enter the Account NUMBER ");
        String search_mobile = inputs.next();
        int count = 0;

        System.out.println(" Account No| First Name | Last Name | Mobile Number         | CNIC | Email  ");

        Iterator<Map.Entry<String, HashMap>> iterator = map_account.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashMap> entry = iterator.next();
            String phoneNumber = entry.getKey();
            HashMap<String, String> studentData = entry.getValue();
            String temp_cnic = studentData.get("CNIC");
            String temp_mobile = studentData.get("Mobile");
            String temp_email = studentData.get("Email");

            if (phoneNumber.equals(search_mobile)) {
                System.out.printf("%-12s| %-11s| %-10s| %-12s| %-14s| %s%n",
                        phoneNumber,
                        studentData.get("First_Name"),
                        studentData.get("Last_name"),
                        studentData.get("CNIC"),
                        studentData.get("Mobile"),
                        studentData.get("Email")
                );
                count++;

                System.out.println("Are You sure ?\nFor Yes Enter 1 and\nFor NO Enter 0");
                int select = inputs.nextInt();
                switch (select) {
                    case 1:
                        iterator.remove(); // Safe removal while iterating
                        map_cnic.remove(temp_cnic);
                        map_email.remove(temp_email);
                        map_mobile.remove(temp_mobile);
                        break;
                    case 0:
                        System.out.println("Good Decision");
                        break;
                    default:
                        System.out.println("Incorrect Option");
                }
            }
        }

        if (count < 1) {
            System.out.println("Data is Not Found");
        }
    }

}

//    public void DeleteAccount_No() 
//    {
//        System.out.println("Enter the Account NUMBER ");
//        String search_mobile = inputs.next();
//        int count = 0;
//
//        System.out.println(" Account No| First Name | Last Name | Mobile Number         | CNIC | Email  ");
//
//        Set<Map.Entry<String, HashMap>> entrySet = map_account.entrySet();
//        Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();
//        String temp_email;
//        String temp_mobile;
//        String temp_cnic;
//        while (iterator.hasNext()) {
//            Map.Entry<String, HashMap> entry = iterator.next();
//            String phoneNumber = entry.getKey();
//            HashMap<String, String> studentData = entry.getValue();
//            temp_cnic = studentData.get("CNIC");
//            temp_mobile = studentData.get("Mobile");
//            temp_email = studentData.get("Email");
//            if (phoneNumber.equals(search_mobile)) {
//                System.out.printf("%-12s| %-11s| %-10s| %-12s| %-14s| %s%n",
//                        phoneNumber,
//                        studentData.get("First_Name"),
//                        studentData.get("Last_name"),
//                        studentData.get("CNIC"),
//                        studentData.get("Mobile"),
//                        studentData.get("Email")
//                );
//                count++;
//
//                System.out.println("Are You sure ?\nFor Yes Enter 1 and\nFor NO Enter 0");
//                int select = inputs.nextInt();
//                switch (select) {
//                    case 1:
//                        map_account.remove(phoneNumber);
//                        map_cnic.remove(temp_cnic);
//                        map_email.remove(temp_email);
//                        map_mobile.remove(temp_mobile);
//
//                        break;
//                    case 0:
//                        System.out.println("Good Decisioion");
//                        break;
//                    default:
//                        System.out.println("Incorrect Option");
//                }
//            }
//
//        }
//        if (count < 1) {
//            System.out.println("Data is Not Found");
//        }
//    }
