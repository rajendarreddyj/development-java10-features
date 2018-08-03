package com.rajendarreddyj.java10;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocalVariableTypeReferenceTest {

	@Test
	public void whenVarInitWithString_thenGetStringTypeVar() {
		var message = "Hello, Java 10";
		assertTrue(message instanceof String);
	}

	@Test
	public void whenVarInitWithAnonymous_thenGetAnonymousType() {
		var obj = new Object() {
		};
		assertFalse(obj.getClass().equals(Object.class));
	}
}
