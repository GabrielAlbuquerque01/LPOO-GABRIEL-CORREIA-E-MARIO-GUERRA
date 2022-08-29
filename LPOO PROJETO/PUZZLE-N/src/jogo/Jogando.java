package jogo;

public class Jogando {

	 private final Tabuleiro tab = new Tabuleiro(3);
	    private String vazio;
	    private String numero;
	    private String[][] matrizPecas;

	    
	    public void jogo() {
	        putDados();
	        mexeDireita();
	        System.out.println("    ");
	        tab.exibeMatriz();
	    }
	    
	    
	    public void putDados(){
	        tab.preencheArray();
	        tab.embaralhaArray();
	        tab.preencheMatriz();
	        tab.exibeMatriz();
	    }
	    
	    
	    public void mexeDireita() {
	        int[] posicao = this.achaVazio();
	        int linha = posicao[0];
	        int coluna = posicao[1];
	        
	        if(coluna != 0) {
	            this.vazio = this.matrizPecas[linha][coluna];
	            this.numero = this.matrizPecas[linha][coluna - 1];
	            this.matrizPecas[linha][coluna] = this.numero;
	            this.matrizPecas[linha][coluna - 1] = this.vazio;
	        }
	        tab.setTabuleiro(this.matrizPecas);
	    }
	    
	    public int[] achaVazio() { //método para achar o espaço vazio e usá-lo na movimentação
	        this.matrizPecas = tab.getTabuleiro();
	        int linha = 0;
	        int coluna = 0;
	        for(int i = 0; i != this.matrizPecas.length; i++) {
	            for(int k = 0; k != this.matrizPecas.length; k++) {
	                if(this.matrizPecas[i][k] == "[ ]") {
	                    linha = i;
	                    coluna = k;
	                }
	            }
	        }
	        int[] pos = {linha, coluna};
	        return pos;
	    }
	}