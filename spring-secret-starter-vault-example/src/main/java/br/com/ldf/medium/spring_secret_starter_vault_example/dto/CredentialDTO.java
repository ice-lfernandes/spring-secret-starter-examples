package br.com.ldf.medium.spring_secret_starter_vault_example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialDTO implements Serializable {
    String username;
    String password;
}