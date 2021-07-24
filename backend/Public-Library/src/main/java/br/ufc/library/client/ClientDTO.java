package br.ufc.library.client;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDTO implements Serializable{
    private static final long serialVersionUID = 1L;

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

    public Client toModel(){
        return new Client(this.id, this.name, this.cpf, this.endereco, this.email, this.password, null);
    }


}
