package com.sena.sistema_credenciales.repository;

import com.sena.sistema_credenciales.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential,Integer> {

}