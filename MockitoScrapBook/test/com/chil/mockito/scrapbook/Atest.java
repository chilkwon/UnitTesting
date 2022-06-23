package com.chil.mockito.scrapbook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class Atest {
	
	@Mock
	B b;
	private A a;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
		
	}
	@Test
	public void usesVoidMethodShouldCallTheVoidMethod() throws Exception {
	//	a.usesVoidMethod();
		doNothing().when(b).voidMethod();
		assertEquals(1,a.usesVoidMethod());
		verify(b).voidMethod();
	
	}
	
	@Test(expected=RuntimeException.class)
	public void usesVoidMethodShouldThrowRuntimeException() throws Exception {

		doThrow(Exception.class).when(b).voidMethod();
		a.usesVoidMethod();	
			
	}
	@Test(expected=RuntimeException.class)
	public void testConsecutiveCalls() throws Exception {

		doNothing().doThrow(Exception.class).when(b).voidMethod();
		a.usesVoidMethod();	
		verify(b).voidMethod();
		a.usesVoidMethod();
			
	}
	
	
	

}
