package com.ethanco81.jenkins.testers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ethanco81.jenkins.test.TestClass;

public class TestClassTester {

	@Test
	public void test1() {
		assertEquals("Should return true", true, (new TestClass().check()));
	}
}
