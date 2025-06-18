package br.com.ldf.medium.spring_secret_starter_inject_example;

import io.github.open_source_lfernandes.spring_secret_starter.annotations.SecretValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExampleInjectFieldSecretValue implements CommandLineRunner {

    public record Credential(
        String username,
        String password
    ) {}

    @SecretValue(value = "${h2.username}")
    private String username;

    @SecretValue(value = "${h2.password}")
    private String password;

//    @SecretValue(value = "${h2.credential}", type = Credential.class)
//    private Credential credential;

    @Override
    public void run(String... args) throws Exception {
        log.info("h2 username: {}", username);
        log.info("h2 password: {}", password);

//        log.info("credential: {}", credential);
    }
}
