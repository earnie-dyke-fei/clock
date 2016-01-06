package com.ferguson.clock.test;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;

import com.ferguson.clock.Clock;

/**
 * Fake implemenation of Clock interface. This implementation should only be
 * used for testing by specifying as an "alternative" in beans.xml
 * 
 * @author E Dyke (AAI6838)
 *
 */
public class FakeClock {
	private static Clock FAKE_CLOCK = new FakeClockImpl();

	@Produces
	@Alternative
	public Clock getFakeClock() {
		return FAKE_CLOCK;
	}

	/**
	 * Fake implementation. Expects a system property "fake.time" that sets the
	 * initial time for this clock.
	 * 
	 * @author E Dyke (AAI6838)
	 *
	 */
	public static class FakeClockImpl implements Clock {
		private static long initialTime;
		private static long startTime;
		static {
			initialTime = Long.parseLong(System.getProperty("fake.time"));
			startTime = System.currentTimeMillis();
		}

		/**
		 * Calculate "current" time by adding the delta between the real time this
		 * class was instantiated and now and adding that to the initial time
		 * supplied via system property "fake.time"
		 */
		public long getTime() {
			return initialTime + (System.currentTimeMillis() - startTime);
		}

	}

}
