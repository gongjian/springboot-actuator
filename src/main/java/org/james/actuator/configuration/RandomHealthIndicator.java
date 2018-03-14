package org.james.actuator.configuration;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		Random random = new Random();
		int i = random.nextInt(100);
		
		if(i < 60) {
			return Health.down().withDetail("Random", "< 60").build();
		} else {
			return Health.up().withDetail("Random", ">= 60").build();
		}
	}

}
