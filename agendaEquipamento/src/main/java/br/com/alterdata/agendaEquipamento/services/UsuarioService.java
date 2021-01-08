package br.com.alterdata.agendaEquipamento.services;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.alterdata.agendaEquipamento.exceptions.LoginDuplicadoException;
import br.com.alterdata.agendaEquipamento.models.Usuario;
import br.com.alterdata.agendaEquipamento.repositories.UsuarioRepository;

@Service
public class UsuarioService{
	
	UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario create(Usuario usuario) throws LoginDuplicadoException{
		Usuario usuarioEncontrado = usuarioRepository.getWithLogin(usuario.getLogin());
		if (usuarioEncontrado == null) {
			return usuarioRepository.save(usuario);	
		} else {
			throw new LoginDuplicadoException(usuario.getLogin());
		}
	}
	
	@Transactional
	public Usuario getByLogin(String login){
		return usuarioRepository.getByLogin(login);
	}

	@Transactional
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
	
	@Transactional
	public Optional<Usuario> getbyId(Integer id){
		return usuarioRepository.findById(id);
	}
	
	@Transactional
	public boolean delete(Integer id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if (usuario.isPresent()) {
			usuarioRepository.delete(usuario.get());
			return true; 
		} else {
			return false;
		}
		
	}
	
	@Transactional
	public Usuario update(Integer id, Usuario usuario){
		Optional<Usuario> usuarioSelecionado = usuarioRepository.findById(id);
		Usuario usuarioAtualizado = usuarioSelecionado.get();
		
		if (usuario.getCpf().equals("") == false && usuario.getCpf() != null) {
			usuarioAtualizado.setCpf(usuario.getCpf());
		}
		
		if (usuario.getNome().equals("") == false && usuario.getNome() != null) {
			usuarioAtualizado.setNome(usuario.getNome());
		}
		
		if (usuario.getLogin().equals("") == false && usuario.getLogin() != null) {
			usuarioAtualizado.setLogin(usuario.getLogin());
		}
		
		if (usuario.getSenha().equals("") == false && usuario.getSenha() != null) {
			usuarioAtualizado.setSenha(usuario.getSenha());
		}
		
		return usuarioRepository.save(usuarioAtualizado);
	}
}
