package br.ufc.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.library.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
    
}
