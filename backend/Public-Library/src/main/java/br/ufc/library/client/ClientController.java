package br.ufc.library.client;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.catalina.connector.Response;
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

import br.ufc.library.book.BookRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    
    @Autowired
    ClientRepository clientRepository;
    
    @Autowired
    BookRepository bookRepository;

    @PostMapping(value = "/signup")
    @Transactional
    public ResponseEntity<Object> addClient(@RequestBody @Valid ClientDTO clientdto) {
        boolean existsEmail;
        existsEmail = clientRepository.existsByEmail(clientdto.getEmail());
        
        if(existsEmail){
            return ResponseEntity.badRequest().body("Error registering client. E-mail already registered.");
        }

        Client client = clientdto.toModel();
        clientRepository.save(client);
        
        return ResponseEntity.created(null).body("Client registration success.") ;
    }

    @PutMapping(value = "/update/{id}")
    @Transactional
    public ResponseEntity<Object> updateClient(@RequestBody Client client, @PathVariable long id){
    	Optional<Client> clientOptional = Optional.ofNullable(clientRepository.findById(id));

	    if (!clientOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    client.setId(id);
	
	    clientRepository.save(client);
	
	    return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/profile/{id}")
    @Transactional
    public ResponseEntity<Client> getProfile(@PathVariable long id){
        Optional<Client> clientOptional = Optional.ofNullable(clientRepository.findById(id));

        if(clientOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Client client = clientRepository.findById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping(value = "/signin/{email}/{password}")
    @Transactional
    public ResponseEntity<Object> login(@PathVariable String email, @PathVariable String password){
        boolean existsEmail = clientRepository.existsByEmail(email);
        
        if(!existsEmail){
            return ResponseEntity.badRequest().body("Unregistered e-mail.");
        }
        Client client = clientRepository.findByEmail(email);
        
        if(!client.getPassword().equals(password)){
            return ResponseEntity.badRequest().body("Incorrect password.");
        }

        return ResponseEntity.ok("Login successfully.");
    }
}
