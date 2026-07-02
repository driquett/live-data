package com.sena.sistema_credenciales.service;

import com.sena.sistema_credenciales.entity.Credential;
import com.sena.sistema_credenciales.repository.CredentialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la lógica de negocio
 * para la gestión de credenciales.
 */
@Service
public class CredentialService {

    private final CredentialRepository credentialRepository;

    /**
     * Constructor con inyección de dependencias.
     */
    public CredentialService(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    /**
     * Obtiene todas las credenciales.
     */
    public List<Credential> getAllCredentials() {
        return credentialRepository.findAll();
    }

    /**
     * Obtiene una credencial por su ID.
     */
    public Credential getCredentialById(Integer id) {
        return credentialRepository.findById(id).orElse(null);
    }

    /**
     * Guarda una nueva credencial o actualiza una existente.
     */
    public Credential saveCredential(Credential credential) {
        return credentialRepository.save(credential);
    }

    /**
     * Elimina una credencial por su ID.
     */
    public void deleteCredential(Integer id) {
        credentialRepository.deleteById(id);
    }
}