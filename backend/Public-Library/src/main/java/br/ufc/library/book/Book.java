package br.ufc.library.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data = toString, equals and hashCode, getter, setter, requieredArgsConstructor.
@Data
@AllArgsConstructor
@Entity
@Table(name = "tb_books")
public class Book {
    
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
	
	public Book(Long id, @NotBlank String title, String abstractBook, @NotBlank String category,
			@NotBlank String author) {
		super();
		this.id = id;
		this.title = title;
		this.abstractBook = abstractBook;
		this.category = category;
		this.author = author;
	}
	
	//Construtor vazio para ecitar erro: No default constructor for entity
	public Book() {
	}
	
	
}
