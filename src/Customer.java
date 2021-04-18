/*
 *author: Guruprem Rajpal
 *date: 13 March 2021
 *Description: ATM Extra Credit
 */

public class Customer {


    String firstName;
    int accountPin;
    double customerBalance;
    String customerBank;


    public Customer() {
        firstName="Guruprem";
        accountPin=5101;
        customerBalance=8000.00;
        customerBank="Chase";
    }


    public Customer(String firstName, int accountPin, double customerBalance, String customerBank) {
        this.firstName=firstName;
        this.accountPin=accountPin;
        this.customerBalance=customerBalance;
        this.customerBank=customerBank;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin=accountPin;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance=customerBalance;
    }

    public String getCustomerBank() {
        return customerBank;
    }

    public void setCustomerBank(String customerBank) {
        this.customerBank=customerBank;
    }

    public String toString() {
        return (firstName +
                ": Balance $" + customerBalance );
    }

    public static void main(String[] args){

    }

}
