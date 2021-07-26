package br.ufc.library.client;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ClientRepository extends JpaRepository<Client, Long>{
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    Client findById(long id);
}
