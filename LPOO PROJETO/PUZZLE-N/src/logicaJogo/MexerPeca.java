package logicaJogo;

import java.util.Random;

public class MexerPeca  <T> extends TabNumero{
	
	private String vazio;
	private String numero;
	private String[][] matrizPecas;
	private int linha;
	private int coluna;
	
	
	public MexerPeca(int matriz) {
		super(matriz);
	}
	
	
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	
	public int getColuna() {
		return this.coluna;
	}
	
	
	public void setLinha(int linha) {
		this.linha = linha;
	}
	
	
	public int getLinha() {
		return this.linha;
	}
	
	
	public void achaVazio() { //método para achar o espaço vazio e usá-lo na movimentação
		this.matrizPecas = super.getTabuleiro();
		int linha = 0;
		int coluna = 0;
		for(int i = 0; i != this.matrizPecas.length; i++) {
			for(int k = 0; k != this.matrizPecas.length; k++) {
				if(this.matrizPecas[i][k] == "  ") {
					linha = i;
					coluna = k;
				}
			}
		}
		this.linha = linha;
		this.coluna = coluna;
	}
	
	
	public void mexeDireita() {
		achaVazio();
		
		if(coluna != 0) {
			this.vazio = this.matrizPecas[linha][coluna];
			this.numero = this.matrizPecas[linha][coluna - 1];
			this.matrizPecas[linha][coluna] = this.numero;
			this.matrizPecas[linha][coluna - 1] = this.vazio;
		}
		super.setTabuleiro(this.matrizPecas);
		super.setListaPecas(matrizPecas);
	}
	
	
	public void mexeEsquerda() {
		achaVazio();
		
		if(coluna != super.getMatriz() - 1) {
			this.vazio = this.matrizPecas[linha][coluna];
			this.numero = this.matrizPecas[linha][coluna + 1];
			this.matrizPecas[linha][coluna] = this.numero;
			this.matrizPecas[linha][coluna + 1] = this.vazio;
		}
		super.setTabuleiro(this.matrizPecas);
		super.setListaPecas(matrizPecas);
	}
	
	
	public void mexeBaixo() {
		achaVazio();

		if(linha != 0) {
			this.vazio = this.matrizPecas[linha][coluna];
			this.numero = this.matrizPecas[linha - 1][coluna];
			this.matrizPecas[linha][coluna] = this.numero;
			this.matrizPecas[linha - 1][coluna] = this.vazio;
		}
		super.setTabuleiro(this.matrizPecas);
		super.setListaPecas(matrizPecas);
	}
	
	
	public void mexeCima() {
		achaVazio();
		
		if(linha != super.getMatriz() - 1) {
			this.vazio = this.matrizPecas[linha][coluna];
			this.numero = this.matrizPecas[linha + 1][coluna];
			this.matrizPecas[linha][coluna] = this.numero;
			this.matrizPecas[linha + 1][coluna] = this.vazio;
		}
		super.setTabuleiro(this.matrizPecas);
		super.setListaPecas(matrizPecas);
	}
	
	
	public boolean terminaJogo() {
		int contador = 0;
		String[][] matrizCorreta = super.getMatrizCorreta();
		for(int i = 0; i < super.getMatriz(); i++) {
			for(int k = 0; k < super.getMatriz(); k++) {
				if(this.matrizPecas != null) {
					if(this.matrizPecas[i][k].equals(matrizCorreta[i][k])) {
						contador++;
					}
				}
			}
		}
		if(contador == super.getMatriz()*super.getMatriz()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String[][] getMatrizPecas() {
		return this.matrizPecas;
	}
	
	
		
}
