package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String home() {
	return "Hello Backend!";
    }

    @GetMapping("/hello")
    public HelloWorld api(@RequestParam(value="name", defaultValue="World") String name) {
        return new HelloWorld(counter.incrementAndGet(), System.currentTimeMillis(),
                            String.format(template, name));
    }

    @GetMapping("/time")
    public long time() {
	return System.currentTimeMillis();
    }

    @GetMapping("/status")
    public String status() {
	return new String("OK");
    }

}
