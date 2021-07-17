package br.ufc.library.book;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO implements Serializable{
    private static final long serialVersionUID = 1L;
   
    private Long id;
	private String title;
    private String abstractBook;
	private String category;
	private String author;

    public BookDTO(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.abstractBook = book.getAbstractBook();
        this.category = book.getCategory();
        this.author = book.getAuthor();
    }
    
}
