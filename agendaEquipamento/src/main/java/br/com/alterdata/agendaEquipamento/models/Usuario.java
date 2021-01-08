package br.com.alterdata.agendaEquipamento.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;
	
	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "cpf", length = 11, unique = true)
	private String cpf;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "nome", length = 100)
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 35)
	@Column(name = "login", unique = true)
	private String login;
	
	@NotNull
	@Size(min = 5, max = 30)
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "admin")
	private boolean admin;

	public String getCpf(){
		return cpf;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getLogin(){
		return login;
	}

	public void setLogin(String login){
		this.login = login;
	}
	
	public String getSenha(){
		return senha;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}

	public boolean isAdmin(){
		return admin;
	}

	public void setAdmin(boolean admin){
		this.admin = admin;
	}

	public Integer getIdUsuario(){
		return idUsuario;
	}
	
}
