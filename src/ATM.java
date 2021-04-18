/*
 *author: Guruprem Rajpal
 *date: 13 March 2021
 *Description: ATM Extra Credit
 */

import java.util.ArrayList;
import java.util.List;


public class ATM {

    private List<Customer> customers=new ArrayList<>( 10 );

    public int pin = 0;
    public String bankName = "UNKNOWN";
    public String ATMLocation= "UNKNOWN";
    public double funds= 100.00;
    public int transactions;
    public int withTransaction;
    public int Success;
    public int Fail;
    public int deposit;
    public int depositSuccess;
    public int depositFail;
    public int Transactiontransfer;
    public int transactionSuccess;
    public int transactionFail;

    public ATM(int pin, String bankName, String ATMLocation, double funds) {
        this.pin = pin;
        this.bankName = bankName;
        this.ATMLocation = ATMLocation;
        this.funds = funds;
    }

    public ATM(String bankName) {
        addCustomerData();
        this.bankName=bankName;
        this.ATMLocation="UNKNONW";
        funds=100.00;
    }

    public ATM(int pin, String bankName, String ATMLocation) {
        this.pin=pin;
        this.bankName=bankName;
        this.ATMLocation=ATMLocation;
        funds=100.00;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin=pin;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName=bankName;
    }

    public String getATMLocation() {
        return ATMLocation;
    }

    public void setATMLocation(String ATMLocation) {
        this.ATMLocation=ATMLocation;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds=funds;
    }

    public void setATM(int pin, String ATMLocation) {
        this.pin=pin;
        this.ATMLocation=ATMLocation;
    }

    private void addCustomerData() {
        customers.add( new Customer( "Alice", 1234, 5000.00, "OtterUnion" ) );
        customers.add( new Customer( "Tom", 2000, 200.00, "OtterUnion" ) );
        customers.add( new Customer( "Monica", 3000, 50.00, "OtterUnion" ) );
        customers.add( new Customer( "Michael", 7777, 0.00, "OtterUnion" ) );
        customers.add( new Customer( "John", 8000, 500.00, "OtterUnion" ) );
        customers.add( new Customer( "Jane", 2222, 500.00, "OtterUnion" ) );
        customers.add( new Customer( "Robert", 2323, 200.00, "BOA" ) );
        customers.add( new Customer( "Owen", 4455, 50.00, "BOA" ) );
        customers.add( new Customer( "Chris", 8787, 10.00, "BOA" ) );
        customers.add( new Customer( "Rebecca", 8080, 555.55, "BOA" ) );
    }

    private int findCustomer(String firstName) {
        for (int i=0; i < customers.size(); i++) {
            if (customers.get( i ).getFirstName() == firstName) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {

        return ("Serial Number: " + pin + "\n") +
                ("Bank Name: " + bankName + "\n") +
                ("Location: " + ATMLocation + "\n") +
                ("Balance: $" +  funds  + "\n");

    }

    public boolean equals(ATM obj) {
        return (this.pin == obj.pin)
                && (this.ATMLocation.equals(obj.ATMLocation));
    }



    public void addFund(double funds) {
        this.funds+=funds;
    }

    public void displayMenu() {
        System.out.println( "===== ATM Transaction Menu ====" );
        System.out.println( "    1.Withdrawal" );
        System.out.println( "    2.Deposit" );
        System.out.println( "    3.Transfer" );
    }

    public void status() {
        System.out.println( "Serial Number: " + pin );
        System.out.println( "Bank Name: " + bankName );
        System.out.println( "Location: " + ATMLocation );
        System.out.println( "Balance: " + funds  );
        System.out.println( transactions + " transactions so far: " );
        System.out.println( "  " + "Withdrawal: " + withTransaction + " (" + Success + " success, " + Fail + " fail)" );
        System.out.println( "  " + "Deposit: " + deposit + " (" + depositSuccess + " success, " + depositFail + " fail)" );
        System.out.println( "  " + "Transfer: " + Transactiontransfer + " (" + transactionSuccess + " success, " + transactionFail + " fail)" );
    }

    public boolean isCustomer(String firstName) {
        int i=findCustomer( firstName );

        if (i == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Customer getCustomer(String firstName) {
        return (Customer) customers.get( findCustomer( firstName ) );
    }


    public void withdrawal(String customerName, int accountPin, double amount) {
        transactions++;
        withTransaction++;
        int i=findCustomer( customerName );

        if (i == -1) {
            System.out.println( "Fail - Withdrawal" );
            Fail++;
            return;
        } else {
            if (bankName.equals( customers.get( i ).getCustomerBank() )) {
                if (accountPinCheck( i, accountPin )) {
                    if (amountCheck( i, amount ) && funds >= amount) {
                        System.out.println( "Succeed - Withdrawal" );
                        withdrawalMoney( i, amount );
                        Success++;
                        return;
                    }
                }
            }

        }
        System.out.println( "Fail - Withdrawal" );
        Fail++;
    }


    public void deposit(String firstName, int accountPin, double newBalance) {
        transactions++;
        deposit++;
        int i=findCustomer( firstName );

        if (i == -1) {
            System.out.println( "Fail - Deposit" );
            depositFail++;
            return;
        } else {
            if (bankName.equals( customers.get( i ).getCustomerBank() )) {
                if (accountPinCheck( i, accountPin )) {
                    System.out.println( "Succeed - Deposit" );
                    depositSuccess++;
                    depositMoney( i, newBalance );
                    return;
                }
            }
        }
        System.out.println( "Fail - Deposit" );
        depositFail++;
    }

    public boolean transfer(String sourceName, int sourcePin, double balance, String name, int pin) {
        transactions=transactions+1;
        Transactiontransfer=Transactiontransfer+1;
        int machine1=findCustomer( sourceName );
        int machine2=findCustomer( name );

        if (machine1 == -1 || machine2 == -1) {
            System.out.println( "Fail - Transfer" );
            transactionFail=transactionFail-1;
            return false;
        } else {
            if (bankName.equals( customers.get( machine1 ).getCustomerBank() ) && bankName.equals( customers.get( machine2 ).getCustomerBank() )) {
                if (accountPinCheck( machine1, sourcePin ) && accountPinCheck( machine2, pin )) {
                    if (amountCheck( machine1, balance )) {
                        moneyTransfer( machine1, machine2, balance );
                        System.out.println( "Success - Transfer" );
                        transactionSuccess=transactionSuccess+1;
                        return true;
                    }
                }
            }
        }
        System.out.println( "Failed - Transfer" );
        transactionFail=transactionFail+1;
        return false;
    }

    public boolean accountPinCheck(int index, int accountPin) {
        if (customers.get( index ).getAccountPin() == accountPin) {
            return true;
        } else {
            return false;
        }
    }

    public boolean amountCheck(int index, double amount) {
        double customerBalance=customers.get( index ).getCustomerBalance();
        if (customerBalance >= amount) {
            return true;
        } else {
            return false;
        }
    }

    public void withdrawalMoney(int index, double amount) {
        double customerBalance=customers.get( index ).getCustomerBalance();
        customerBalance-=amount;
        funds-=amount;
        setFunds( funds );
        customers.get( index ).setCustomerBalance( customerBalance );
    }

    public void moneyTransfer(int index, int index2, double balance) {
        double sourceBalance=customers.get( index ).getCustomerBalance();
        double destBalance=customers.get( index2 ).getCustomerBalance();
        sourceBalance=sourceBalance-balance;
        destBalance=destBalance+balance;
        customers.get( index ).setCustomerBalance( sourceBalance );
        customers.get( index ).setCustomerBalance( destBalance );
    }

    public void depositMoney(int index, double addedMoney) {
        double customerBalance=customers.get( index ).getCustomerBalance();
        customerBalance=customerBalance+addedMoney;
        funds=funds+addedMoney;
        customers.get( index ).setCustomerBalance( customerBalance );
        setFunds( funds );
    }

    public static void main(String[] args){

    }
}