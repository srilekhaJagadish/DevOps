package com.qa.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	
	@Test
	public void sum(){
		System.out.println("***************** App Test **********************");
		System.out.println("SUM value:");
		int a = 20;
		int b = 30;
		assertEquals(50, a+b);
	}
	
    
}
