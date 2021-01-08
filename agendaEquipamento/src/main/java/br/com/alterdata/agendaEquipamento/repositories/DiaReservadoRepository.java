package br.com.alterdata.agendaEquipamento.repositories;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.alterdata.agendaEquipamento.models.DiaReservado;

public interface DiaReservadoRepository extends JpaRepository<DiaReservado, Integer> {
	
	@Query(value="SELECT * FROM dia_reservado WHERE data = :data",
			nativeQuery=true)
	DiaReservado getByData(LocalDate data);

}
