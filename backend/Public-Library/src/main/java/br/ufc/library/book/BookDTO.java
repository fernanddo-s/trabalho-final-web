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

    public BookDTO() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Long getId() {
		return id;
	}



	public String getTitle() {
		return title;
	}



	public String getAbstractBook() {
		return abstractBook;
	}



	public String getCategory() {
		return category;
	}



	public String getAuthor() {
		return author;
	}



	public Book toModel(){
        return new Book(this.id, this.title, this.abstractBook, this.category, this.author);
    }
    
}
