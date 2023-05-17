package net.roszczyk.java.di.injector;

import net.roszczyk.java.di.consumer.Consumer;
import net.roszczyk.java.di.consumer.MyDIApplication;
import net.roszczyk.java.di.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector
{
	@Override
	public Consumer getConsumer()
	{
		return new MyDIApplication(new SMSServiceImpl());
	}

}
