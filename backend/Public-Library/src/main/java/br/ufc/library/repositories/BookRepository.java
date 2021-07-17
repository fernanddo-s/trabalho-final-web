package br.ufc.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long{
    
}
