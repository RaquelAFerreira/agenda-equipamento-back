package br.com.alterdata.agendaEquipamento.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.alterdata.agendaEquipamento.models.Solicitacao;
import br.com.alterdata.agendaEquipamento.repositories.SolicitacaoRepository;
import br.com.alterdata.agendaEquipamento.services.validations.ValidarSolicitacao;

@Service
public class SolicitacaoService {

	@Autowired
	SolicitacaoRepository solicitacaoRepository;
	
	@Autowired
	ValidarSolicitacao validarSolicitacao;
	
	@Transactional
	public Solicitacao create(Solicitacao solicitacao) throws Exception{		
		validarSolicitacao.validar(solicitacao);
		return solicitacaoRepository.save(solicitacao);			
	}
	
	@Transactional
	public List<Solicitacao> getBySituacao(String situacao){
		return solicitacaoRepository.getBySituacao(situacao);
	}
	
	@Transactional
	public Solicitacao getByDataHora(LocalDate data, String hora){
		return solicitacaoRepository.getByDataHora(data, hora);
	}
	
	@Transactional
	public Solicitacao getByCodigoSolicitacao(String codigoSolicitacao){
		return solicitacaoRepository.getByCodigoSolicitacao(codigoSolicitacao);
	}

	@Transactional
	public List<Solicitacao> getAll(){
		return solicitacaoRepository.findAll();
	}
	
	@Transactional
	public List<Solicitacao> getBySolicitante(Integer solicitante){
		return solicitacaoRepository.getBySolicitante(solicitante);
	}
	
	@Transactional
	public Optional<Solicitacao> getbyId(Integer id){
		return solicitacaoRepository.findById(id);
	}
	
	@Transactional
	public boolean delete(Integer id){
		Optional<Solicitacao> solicitacao = solicitacaoRepository.findById(id);
		if (solicitacao.isPresent()) {
			solicitacaoRepository.delete(solicitacao.get());
			return true; 
		} else {
			return false;
		}
	}
	
	@Transactional
	public Solicitacao update(Integer id, Solicitacao solicitacao) {
		Optional<Solicitacao> solicitacaoSelecionado = solicitacaoRepository.findById(id);
		Solicitacao solicitacaoAtualizado = solicitacaoSelecionado.get();
		
		if(solicitacao.getCodigoSolicitacao() != null) {
			solicitacaoAtualizado.setCodigoSolicitacao(solicitacao.getCodigoSolicitacao());
		}
		
		if(solicitacao.getSituacao() != null) {
			solicitacaoAtualizado.setSituacao(solicitacao.getSituacao());
		}
		
		return solicitacaoRepository.save(solicitacaoAtualizado);
	}	
	
}
