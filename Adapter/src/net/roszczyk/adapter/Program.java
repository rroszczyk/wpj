package net.roszczyk.adapter;

public class Program {
    public static void main(String[] args)
    {
        CreditCard targetInterface = new BankCustomer();

        targetInterface.giveBankDetails();

        System.out.print(targetInterface.getCreditCard());
    }
}