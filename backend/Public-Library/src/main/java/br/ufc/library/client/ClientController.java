package br.ufc.library.client;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    
    @Autowired
    EntityManager entityManager;

    @GetMapping(value = "/test")
    public String test() {
        return "Deu bom - Client";
    }

    @PostMapping(value = "/signup")
    @Transactional
    public String addClient(@RequestBody @Valid ClientDTO clientdto) {
        System.out.println("id: "+clientdto.getId());
        System.out.println("name: "+clientdto.getName());

        Client client = clientdto.toModel();
        entityManager.persist(client);
        return "Client registration success.";
    }
}
