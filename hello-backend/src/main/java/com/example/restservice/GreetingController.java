package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	private final MeterRegistry registry;

	public GreetingController(MeterRegistry registry) {
		this.registry = registry;
	}

	@RequestMapping("/")
	public String home() {
		return "Hello Backend";
	}

	@GetMapping("/greeting")
	@Timed(value = "greeting.time", description = "Time taken to return greeting", percentiles = { 0.5, 0.90 })
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		registry.counter("greetings.counter").increment();
		return new Greeting(counter.incrementAndGet(), System.currentTimeMillis(), String.format(template, name));
	}

	@GetMapping("/time")
	public long time() {
		return System.currentTimeMillis();
	}

	@GetMapping("/status")
	public String status() {
		return "OK";
	}

}
