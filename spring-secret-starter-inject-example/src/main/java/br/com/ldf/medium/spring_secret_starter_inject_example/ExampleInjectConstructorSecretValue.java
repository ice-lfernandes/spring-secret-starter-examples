package br.com.ldf.medium.spring_secret_starter_inject_example;

import io.github.open_source_lfernandes.spring_secret_starter.annotations.SecretValue;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Getter
@Slf4j
@Component
public class ExampleInjectConstructorSecretValue {

    private final String username;
    private final String password;

    public ExampleInjectConstructorSecretValue(
            @SecretValue(value = "${h2.username}") String username,
            @SecretValue(value = "${h2.password}") String password
    ) {
        this.username = username;
        this.password = password;
        log.info("h2 username: {}", username);
        log.info("h2 password: {}", password);
    }
}
