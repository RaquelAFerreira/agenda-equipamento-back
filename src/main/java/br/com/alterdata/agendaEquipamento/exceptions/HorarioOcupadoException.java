package br.com.alterdata.agendaEquipamento.exceptions;

import java.time.LocalDate;

public class HorarioOcupadoExcepetion extends Exception{
	
private static final long serialVersionUID = -6840138218861403331L;
	
	private String msg = "O código de equipamento informado já existe";
	private LocalDate data;
	private String hora;
	
	public HorarioOcupadoExcepetion(){
		super();
	}

	public HorarioOcupadoExcepetion(String msg, LocalDate data, String hora) {
		super();
		this.msg = msg;
		this.data = data;
		this.hora = hora;
	}



}
