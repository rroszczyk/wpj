package net.roszczyk.observer;
public class Program {
    public static void main(String[] args)
    {
        System.out.println("Enter Text >");

        final EventSource eventSource = new EventSource();

        final ResponseHandler1 responseHandler1 = new ResponseHandler1();

        eventSource.addObserver(responseHandler1);

        final ResponseHandler2 responseHandler2 = new ResponseHandler2();

        eventSource.addObserver(responseHandler2);

        Thread thread = new Thread(eventSource);
        thread.start();    }
}