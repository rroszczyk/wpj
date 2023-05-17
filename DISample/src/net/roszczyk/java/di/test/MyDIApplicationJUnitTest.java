package net.roszczyk.java.di.test;

import net.roszczyk.java.di.consumer.Consumer;
import net.roszczyk.java.di.consumer.MyDIApplication;
import net.roszczyk.java.di.injector.MessageServiceInjector;
import net.roszczyk.java.di.service.MessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyDIApplicationJUnitTest {

	private MessageServiceInjector injector;
	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {
			
			@Override
			public Consumer getConsumer() {
				//mock the message service
				return new MyDIApplication(new MessageService() {
					
					@Override
					public void sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");
						
					}
				});
			}
		};
	}
	
	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Radosław", "radoslaw.roszczyk@wsb.waw.pl");
	}

	@Test
	public void test1() throws Exception {
		throw new Exception();
	}

	@Test
	public void test2() {
		System.out.println("Komunikat");
		assert 5 == 10;
	}

	@After
	public void tear(){
		injector = null;
	}

}
