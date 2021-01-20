package br.com.alterdata.agendaEquipamento.utils;

public class GeradorCodigo {
	
	public static Integer geraIntAleatorio(Integer menor, Integer maior){
		return (int) (Math.floor(Math.random() * (maior - menor + 1)) + menor);
	}
		 
	public static Character geraCaracterAleatoria(String base){
	    return base.charAt(geraIntAleatorio(0, base.length() - 1));
	}
	 
	public static String geraSequenciaAleatoria(Integer tamanho, String base){
	    String sequencia = "";
	    for (int i = 1; i <= tamanho; i = i + 1){
	        sequencia += geraCaracterAleatoria(base);
	    }
	    return sequencia;
	}
}
