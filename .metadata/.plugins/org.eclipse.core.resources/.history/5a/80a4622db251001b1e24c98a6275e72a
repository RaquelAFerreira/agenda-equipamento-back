package br.com.alterdata.agendaEquipamento.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import br.com.alterdata.agendaEquipamento.enums.CategoriaEquipamento;

@Entity
@Table(name = "equipamento")
public class Equipamento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idEquipamento")
	private Integer idEquipamento;
	
	@NotNull
	@Column(name = "codigoEquipamento", unique = true)
	private String codigoEquipamento;
	
	@NotNull
	@Column(name = "categoria")
	private CategoriaEquipamento categoria;
	
	@NotNull
	@Column(name = "descricao")
	@Size(min = 0, max = 75)
	private String descricao;
	
	@NotNull
	@Column(name = "disponivel")
	boolean disponivel;

	public String getCodigoEquipamento() {
		return codigoEquipamento;
	}

	public void setCodigo(String codigoEquipamento) {
		this.codigoEquipamento = codigoEquipamento;
	}

	public CategoriaEquipamento getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEquipamento categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Integer getIdEquipamento() {
		return idEquipamento;
	}

}
