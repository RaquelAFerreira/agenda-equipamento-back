package br.com.alterdata.agendaEquipamento.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.alterdata.agendaEquipamento.models.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer> {
	
	@Query(value="SELECT * FROM solicitacao WHERE codigoSolicitacao = :codigoSolicitacao",
			nativeQuery=true)
	Solicitacao getWithCodigoSolicitacao(String codigoSolicitacao);

}
