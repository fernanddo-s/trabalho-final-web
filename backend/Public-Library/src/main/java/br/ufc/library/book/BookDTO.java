package br.ufc.library.book;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
	private String title;

    private String abstractBook;
    
    @NotBlank
	private String category;
    
    @NotBlank
	private String author;

    public BookDTO(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.abstractBook = book.getAbstractBook();
        this.category = book.getCategory();
        this.author = book.getAuthor();
    }

	public Book toModel(){
        return new Book(this.id, this.title, this.abstractBook, this.category, this.author);
    }
    
}
