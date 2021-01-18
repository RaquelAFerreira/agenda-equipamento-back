package br.com.alterdata.agendaEquipamento.enums;

public enum Situacao {
	
	ANALISE("Em Análise"), 
	AGENDADA("Agendada"), 
	RECUSADA("Recusada"), 
	CONCLUIDA("Concluída"), 
	INCONCLUSA("Inconclusa");
	
	private String descricao;

    Situacao(String descricao) {
        this.descricao = descricao;
    }

	public String getDescricao() {
		return descricao;
	}
}
