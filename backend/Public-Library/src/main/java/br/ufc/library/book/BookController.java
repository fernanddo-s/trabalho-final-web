package br.ufc.library.book;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @GetMapping(value = "/test")
    public String test() {
        return "Deu bom";
    }

    @PostMapping(value = "/register")
    public String addBook(@RequestBody @Valid BookDTO bookdto) {
        System.out.println("id: "+bookdto.getId());
        System.out.println("title: "+bookdto.getTitle());
        System.out.println("Abstract: "+bookdto.getAbstractBook());
        System.out.println("Author: "+bookdto.getAuthor());
        return "Registered book.";
    }
}
