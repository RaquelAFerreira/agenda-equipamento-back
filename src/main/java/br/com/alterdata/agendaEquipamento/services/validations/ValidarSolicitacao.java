package br.com.alterdata.agendaEquipamento.services.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alterdata.agendaEquipamento.exceptions.HorarioOcupadoException;
import br.com.alterdata.agendaEquipamento.exceptions.SolicitacaoDuplicadaException;
import br.com.alterdata.agendaEquipamento.models.Solicitacao;
import br.com.alterdata.agendaEquipamento.repositories.SolicitacaoRepository;

@Component
public class ValidarSolicitacao {
	
	@Autowired
	SolicitacaoRepository solicitacaoRepository;
	
	public void validar(Solicitacao solicitacao) throws Exception  {
		validarCodigo(solicitacao);
		validarDataHora(solicitacao);
	}
	
	private void validarCodigo(Solicitacao solicitacao) throws SolicitacaoDuplicadaException {
		Solicitacao solicitacaoEncontrada = solicitacaoRepository.getByCodigoSolicitacao(solicitacao.getCodigoSolicitacao());
		if(solicitacaoEncontrada != null) {
			throw new SolicitacaoDuplicadaException(solicitacao.getCodigoSolicitacao());
		}
	}
	
	private void validarDataHora(Solicitacao solicitacao) throws HorarioOcupadoException{
		Solicitacao solicitacaoEncontrada = solicitacaoRepository.getByDataHora(solicitacao.getData(), solicitacao.getHora());
		if(solicitacaoEncontrada != null) {
			throw new HorarioOcupadoException(solicitacao.getData(), solicitacao.getHora());
		}
	}

}