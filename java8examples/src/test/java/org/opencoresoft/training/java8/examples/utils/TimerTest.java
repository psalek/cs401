package org.opencoresoft.training.java8.examples.utils;

import org.junit.Assert;
import org.junit.Test;

import edu.mum.cs.cs401.examples.java8.utils.Timer;
import junit.framework.TestCase;

public class TimerTest extends TestCase {

	@Test
	public void testStartStopSequenceHappyPath() {
		Timer.start();
		Timer.stop();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testStopSequenceErrorPath() {
		Timer.stop();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testStartSequenceErrorPath() {
		Timer.start();
	}

	@Test
	public void testGetDuration() {
		Timer.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Timer.stop();

		System.out.println(Timer.getDuration());

		Assert.assertTrue(Timer.getDuration() >= 999);
	}

}
