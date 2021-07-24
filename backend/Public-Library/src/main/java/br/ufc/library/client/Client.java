package br.ufc.library.client;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.ufc.library.book.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

//@Data = toString, equals and hashCode, getter, setter, requieredArgsConstructor.
@Data
@AllArgsConstructor
@Entity
@Table(name = "tb_clients")
public class Client {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;
	
	@NotBlank
	private String cpf;

	@NotBlank
	private String endereco;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	private ArrayList<Book> listBooks;

}
