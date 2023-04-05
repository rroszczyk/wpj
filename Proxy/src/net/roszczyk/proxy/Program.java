package net.roszczyk.proxy;
public class Program {
    public static void main(String[] args) {
        OfficeInternetAccess access = new ProxyInternetAccess("Radosław Roszczyk");
        access.grantInternetAccess();
    }
}