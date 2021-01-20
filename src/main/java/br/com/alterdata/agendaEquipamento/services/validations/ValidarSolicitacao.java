package br.com.alterdata.agendaEquipamento.services.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alterdata.agendaEquipamento.exceptions.SolicitacaoDuplicadaException;
import br.com.alterdata.agendaEquipamento.models.Solicitacao;
import br.com.alterdata.agendaEquipamento.repositories.SolicitacaoRepository;

@Component
public class ValidarSolicitacao {
	
	@Autowired
	SolicitacaoRepository solicitacaoRepository;
	
	public void validar(Solicitacao solicitacao) throws SolicitacaoDuplicadaException  {
		Solicitacao solicitacaoEncontrada = solicitacaoRepository.getByCodigoSolicitacao(solicitacao.getCodigoSolicitacao());
		if(solicitacaoEncontrada != null) {
			throw new SolicitacaoDuplicadaException(solicitacao.getCodigoSolicitacao());
		}
		//testar se horário já cadastrado 
	}

}
