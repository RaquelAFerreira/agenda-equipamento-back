package br.com.alterdata.agendaEquipamento.exceptions;

import java.time.LocalDate;

public class HorarioOcupadoException extends Exception{
	
private static final long serialVersionUID = -6840138218861403331L;
	
	private String msg = "O código de equipamento informado já existe";
	private LocalDate data;
	private String hora;
	
	public HorarioOcupadoException(){
		super();
	}

	public HorarioOcupadoException(LocalDate data, String hora) {
		super();
		this.data = data;
		this.hora = hora;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
