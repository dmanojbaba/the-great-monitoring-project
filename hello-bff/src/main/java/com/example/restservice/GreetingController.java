package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class GreetingController {

	@Value("${BACKEND_URL:http://localhost:9002}")
	private String backend_url;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	private final MeterRegistry registry;

	public GreetingController(MeterRegistry registry) {
		this.registry = registry;
	}

	@RequestMapping("/")
	public String home() {
		return "Hello BFF";
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), System.currentTimeMillis(), String.format(template, name));
	}

	@GetMapping("/hello")
	@Timed(value = "hello_bff_time", description = "Time taken to return hello", percentiles = { 0.5, 0.90 })
	public Greeting hello(@RequestParam(value = "name", defaultValue = "") String name) {
		registry.counter("hello_bff_counter").increment();

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(backend_url + "/hello?name=" + name, String.class);

		return new Greeting(counter.incrementAndGet(), System.currentTimeMillis(), result);
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
