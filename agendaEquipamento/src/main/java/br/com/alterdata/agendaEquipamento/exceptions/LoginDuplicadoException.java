package br.com.alterdata.agendaEquipamento.exceptions;

public class LoginDuplicadoException extends Exception {
	
private static final long serialVersionUID = -6840138218861403331L;
	
	private String msg = "O login informado já existe";
	private String login;
	
	public LoginDuplicadoException() {
		super();
	}
	public LoginDuplicadoException(String login) {
		super();
		this.login = login;
	}
	public String getMsg() {
		return msg;
	}
	public String getLogin() {
		return login;
	}

}
