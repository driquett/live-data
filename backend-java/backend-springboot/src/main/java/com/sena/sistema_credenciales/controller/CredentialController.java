package com.sena.sistema_credenciales.controller;

import com.sena.sistema_credenciales.entity.Credential;
import com.sena.sistema_credenciales.service.CredentialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialController {

    private final CredentialService credentialService;

    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    // Listar todas las credenciales
    @GetMapping
    public List<Credential> getAllCredentials() {
        return credentialService.getAllCredentials();
    }

    // Buscar una credencial por ID
    @GetMapping("/{id}")
    public Credential getCredentialById(@PathVariable Integer id) {
        return credentialService.getCredentialById(id);
    }

    // Crear una credencial
    @PostMapping
    public Credential saveCredential(@RequestBody Credential credential) {
        return credentialService.saveCredential(credential);
    }

    // Actualizar una credencial
    @PutMapping("/{id}")
    public Credential updateCredential(@PathVariable Integer id,
                                       @RequestBody Credential credential) {

        credential.setId(id);

        return credentialService.saveCredential(credential);
    }

    // Eliminar una credencial
    @DeleteMapping("/{id}")
    public void deleteCredential(@PathVariable Integer id) {
        credentialService.deleteCredential(id);
    }
}