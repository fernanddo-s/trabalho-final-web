package br.ufc.library.client;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    
    @Autowired
    ClientRepository clientRepository;

    @PostMapping(value = "/signup")
    @Transactional
    public ResponseEntity<Object> addClient(@RequestBody @Valid ClientDTO clientdto) {
        boolean existsCpf, existsEmail;
        existsCpf = clientRepository.existsByCpf(clientdto.getCpf());
        existsEmail = clientRepository.existsByEmail(clientdto.getEmail());
        if(existsCpf || existsEmail){
            return ResponseEntity.badRequest().body("Error registering client.");
        }

        Client client = clientdto.toModel();
        clientRepository.save(client);
        
        return ResponseEntity.created(null).body("Client registration success.") ;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateClient(@RequestBody Client client, @PathVariable long id){
    	Optional<Client> clientOptional = Optional.ofNullable(clientRepository.findById(id));

	    if (!clientOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    client.setId(id);
	
	    clientRepository.save(client);
	
	    return ResponseEntity.noContent().build();
    }
}
