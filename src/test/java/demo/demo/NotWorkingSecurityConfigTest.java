package demo.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(NotWorkingSecurityConfig.class)
class NotWorkingSecurityConfigTest {
    
    @Autowired
    private TestRestTemplate template;

    @Test
    void test() throws Exception {
        ResponseEntity<String> forEntity = template.withBasicAuth("user", "password")
                .getForEntity("/demo", String.class);
        Assertions.assertEquals("password", forEntity.getBody());
    }
}
