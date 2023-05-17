package net.roszczyk.java.di.injector;

import net.roszczyk.java.di.consumer.Consumer;
import net.roszczyk.java.di.consumer.MyDIApplication;
import net.roszczyk.java.di.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector
{
	@Override
	public Consumer getConsumer() {
		MyDIApplication app = new MyDIApplication();
		app.setService(new EmailServiceImpl());
		return app;
	}
}
