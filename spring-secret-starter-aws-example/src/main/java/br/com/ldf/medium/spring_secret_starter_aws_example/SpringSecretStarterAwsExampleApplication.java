package br.com.ldf.medium.spring_secret_starter_aws_example;

import io.github.open_source_lfernandes.spring_secret_starter.annotations.SecretValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecretStarterAwsExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecretStarterAwsExampleApplication.class, args);
    }

}
