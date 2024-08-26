package demo.demo;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/demo")
    public String get(Authentication authentication) {
        return authentication.getCredentials() == null ? "no credentials" : authentication.getCredentials().toString();
    }
}
