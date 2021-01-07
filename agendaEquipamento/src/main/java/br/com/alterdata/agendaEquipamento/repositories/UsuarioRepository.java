package br.com.alterdata.agendaEquipamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alterdata.agendaEquipamento.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value="SELECT * FROM usuario WHERE login = :login",
			nativeQuery=true)
	Usuario getWithLogin(String login);

}
