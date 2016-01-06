package com.ferguson.clock;

import javax.enterprise.inject.Produces;

/**
 * Real Clock implementation of Clock interface. This is the defaul implementation.
 * @author E Dyke (AAI6838)
 *
 */
public class RealClock  {

	@Produces
	public Clock getRealClock() {
		return new Clock() {

			public long getTime() {
				return System.currentTimeMillis();
			}
		};
	}

}
