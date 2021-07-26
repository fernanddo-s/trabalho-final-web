package br.ufc.library.book;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
    @PostMapping(value = "/register")
    @Transactional
    public ResponseEntity<Object> addBook(@RequestBody @Valid BookDTO bookdto) {
        Book book = bookdto.toModel();
        bookRepository.save(book);

        return ResponseEntity.ok("Registered book.");
    }
    
    @GetMapping(value = "/list")
    public List<Book> getAllBooks(){
    	return bookRepository.findAll();
    }
    
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable long id){
    	Optional<Book> BookRepository = Optional.ofNullable(bookRepository.findById(id));

	    if (!BookRepository.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    book.setId(id);
	
	    bookRepository.save(book);
	
	    return ResponseEntity.noContent().build();
    }

    
}




