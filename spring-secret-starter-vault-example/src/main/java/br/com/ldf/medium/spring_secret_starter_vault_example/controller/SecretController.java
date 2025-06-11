package br.com.ldf.medium.spring_secret_starter_vault_example.controller;

import br.com.ldf.medium.spring_secret_starter_vault_example.dto.CredentialDTO;
import io.github.open_source_lfernandes.spring_secret_starter.enums.Origin;
import io.github.open_source_lfernandes.spring_secret_starter.exceptions.SecretNotFoundException;
import io.github.open_source_lfernandes.spring_secret_starter.service.SecretsManagerService;
import io.github.open_source_lfernandes.spring_secret_starter.service.providers.SecretsProviderVault;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/secrets/vault")
@RequiredArgsConstructor
public class SecretController {

    private final SecretsManagerService service;
    private final SecretsProviderVault secretsProviderVault;

    @GetMapping("/simple/{secretKey}")
    public ResponseEntity<String> getSecret(@PathVariable String secretKey) {
        return service.get(Origin.VAULT, secretKey)
                .map(secretDTO -> ResponseEntity.ok(secretDTO.value()))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/cast/{secretKey}")
    public ResponseEntity<CredentialDTO> getSecretAsObject(@PathVariable String secretKey) {
        try {
            return ResponseEntity.ok(service.get(Origin.VAULT, secretKey, CredentialDTO.class));
        } catch (SecretNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/update-path")
    public ResponseEntity<?> updateVaultPath(@RequestParam String newPath) {
        secretsProviderVault.updatePath(newPath);
        return ResponseEntity.noContent().build();
    }
}
