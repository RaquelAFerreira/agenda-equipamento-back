package br.com.alterdata.agendaEquipamento.controllers;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.alterdata.agendaEquipamento.exceptions.DiaReservadoDuplicadoException;
import br.com.alterdata.agendaEquipamento.models.DiaReservado;
import br.com.alterdata.agendaEquipamento.services.DiaReservadoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({ "/diaReservado" })
public class DiaReservadoController {
	
	@Autowired
	DiaReservadoService diaReservadoService;

	@ApiOperation("Retorna uma lista com todos os dia reservados cadastrados")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<List<DiaReservado>> getAll(){
		return ResponseEntity.ok(diaReservadoService.getAll());
	}

	@ApiOperation("Retorna um dia reservado de acordo com o id")
	@GetMapping(path="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<DiaReservado> get(@PathVariable Integer id){
		DiaReservado diaReservado = diaReservadoService.getbyId(id).get();
		return ResponseEntity.ok(diaReservado);
	}
	
	@ApiOperation("Retorna um dia reservado baseado em sua data")
	@GetMapping(path="data/{data}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DiaReservado> getByData(@PathVariable LocalDate data){
		return ResponseEntity.ok(diaReservadoService.getByData(data));
	}

	@ApiOperation("Cadastra um novo dia reservado")
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DiaReservado> create(@Valid @RequestBody DiaReservado diaReservado) throws DiaReservadoDuplicadoException{
		return ResponseEntity.status(HttpStatus.CREATED).body(diaReservadoService.create(diaReservado));
	}

	@ApiOperation("Atualiza um dia reservado de acordo com o id")
	@PutMapping(path="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DiaReservado> put(@PathVariable Integer id, @RequestBody DiaReservado diaReservado){
		DiaReservado diaReservadoAtualizado = diaReservadoService.update(id, diaReservado);
		return ResponseEntity.ok(diaReservadoAtualizado);
	}

	@ApiOperation("Apaga um dia reservado de acordo com o id")
	@DeleteMapping(path="/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		boolean response = diaReservadoService.delete(id);
		
		if(response) {		
			return ResponseEntity.ok("Dia reservado apagado com sucesso.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dia reservado não encontrado");
		}
	}

}
