package br.com.alterdata.agendaEquipamento.models;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import br.com.alterdata.agendaEquipamento.enums.Situacao;
import br.com.alterdata.agendaEquipamento.utils.GeradorCodigo;

@Entity
@Table(name = "solicitacao")
public class Solicitacao{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_solicitacao")
	private Integer idSolicitacao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario solicitante;
	
	@NotNull
	@Enumerated(value = EnumType.STRING)
	@Column(name = "situacao")
	private Situacao situacao;
	
	@Column(name = "codigo_solicitacao", unique = true)
	private String codigoSolicitacao;
	
	@NotNull
	@Column(name = "data")
	private LocalDate data;
	
	@NotNull
	@Column(name = "hora", length = 5)
	@Size(min = 5, max = 5)
	private String hora;
	
	@ManyToMany
	@JoinTable (name = "equipamentos_solicitacao",
			joinColumns = @JoinColumn(name = "id_solicitacao"),
			inverseJoinColumns = @JoinColumn(name = "id_equipamento"))
	private List<Equipamento> equipamentos;

//	public Solicitacao(@NotNull Usuario solicitante, @NotNull Situacao situacao, 
//					@NotNull LocalDate data, @NotNull @Size(min = 5, max = 5) String hora, 
//					List<Equipamento> equipamentos){
//		super();
//		this.solicitante = solicitante;
//		this.situacao = situacao;
//		this.codigoSolicitacao = GeradorCodigo.geraSequenciaAleatoria(5, "0123456789");
//		this.data = data;
//		this.hora = hora;
//		this.equipamentos = equipamentos;
//	}

	public Solicitacao() {
		super();
		this.codigoSolicitacao = GeradorCodigo.geraSequenciaAleatoria(5, "0123456789");
	}

	public Usuario getSolicitante(){
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante){
		this.solicitante = solicitante;
	}

	public Situacao getSituacao(){
		return situacao;
	}

	public void setSituacao(Situacao situacao){
		this.situacao = situacao;
	}

	public List<Equipamento> getEquipamentos(){
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos){
		this.equipamentos = equipamentos;
	}

	public String getCodigoSolicitacao() {
		return codigoSolicitacao;
	}

	public void setCodigoSolicitacao(String codigoSolicitacao) {
		this.codigoSolicitacao = codigoSolicitacao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getIdSolicitacao(){
		return idSolicitacao;
	}
	
}
