package br.ufc.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.library.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
