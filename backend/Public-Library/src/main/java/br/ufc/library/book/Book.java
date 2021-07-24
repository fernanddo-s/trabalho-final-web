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
	
	public Book() {
	}
	
}
