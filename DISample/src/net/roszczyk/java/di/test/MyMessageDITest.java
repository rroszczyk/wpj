package net.roszczyk.java.di.test;

import net.roszczyk.java.di.consumer.Consumer;
import net.roszczyk.java.di.injector.EmailServiceInjector;
import net.roszczyk.java.di.injector.MessageServiceInjector;
import net.roszczyk.java.di.injector.SMSServiceInjector;

public class MyMessageDITest {

	public static void main(String[] args) {
		String msg = "Hi Radosław";
		String email = "radoslaw.roszczyk@wsb.waw.pl";
		String phone = "225433333";

		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}

}
