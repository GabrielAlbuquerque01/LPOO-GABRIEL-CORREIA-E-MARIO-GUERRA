package jogo;

public class Jogando {
	
	private final MexerPeca tab = new MexerPeca(3);

	public void jogo() {
		putDados();
		tab.mexeBaixo();
		System.out.println("    ");
		tab.exibeMatriz();
	}
	
	
	public void putDados(){
		tab.preencheArray();
		tab.embaralhaArray();
		tab.preencheMatriz();
		tab.exibeMatriz();
	}
	
}
