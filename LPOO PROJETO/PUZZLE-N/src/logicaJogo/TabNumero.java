package logicaJogo;
import java.util.*;

public abstract class TabNumero implements Tabuleiro{
	private int matriz;
	private String[] listaPecas;
	private String[][] matrizPecas;
	
	
	public TabNumero(int matriz){
		setMatriz(matriz);
	}
	
	
	public void setMatriz(int matriz) { //armazena o valor da dimensao da matriz (se é 2x2, 3x3 ou 4x4)
		if(matriz == 2 ||matriz == 3 || matriz == 4) {
			this.matriz = matriz;
		}
	}
	
	
	public int getMatriz() {//retorna o valor da dimensao da matriz
		return this.matriz;
	}
	
	
	public void setTabuleiro(String[][] tabuleiro) { //seta a matriz de peças do jogo
		this.matrizPecas = tabuleiro;
	}
	
	
	public String[][] getTabuleiro() { //retorna a matriz de peças do jogo
		return this.matrizPecas;
	}
	
	
	public void preencheArray() { //cria uma lista com os valores das pecas
		String[] tempArray = new String[this.matriz*this.matriz]; //array temporário que armazena a ordem das pecas
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			tempArray[i] = String.valueOf(i + 1);
		}
		this.listaPecas = tempArray; 
		listaPecas[listaPecas.length - 1] = "  ";
	}
	
	
	public void embaralhaArray() { //transforma o array de pecas em lista, embaralha e depois retransforma em array
        List<String> list =Arrays.asList(this.listaPecas); 
        Collections.shuffle(list);
        list.toArray(this.listaPecas);
	}
	
	
	public void setListaPecas(String[][] matriz) {//recebe uma matriz como parametro e preenche o array com seus elementos
		int contador = 0;
		for(int i = 0; i < this.matriz; i++) {
			for(int k = 0; k < this.matriz; k++) {
				this.listaPecas[contador] = matriz[i][k];
				contador++;
			}
		}
	}
	
	
	public String[] getListaPecas() {//retorna o array de pecas
		return this.listaPecas;
	}
	
	
	public String[] getListaCorreta() { //retorna um array com pecas na ordem correta
		String[] listaPecas = new String[this.matriz*this.matriz];
		
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			listaPecas[i] = String.valueOf(i + 1);
		}
		listaPecas[listaPecas.length - 1] = "  ";
		return listaPecas;
	}
	
	
	public int getVazio() { //retornar a posição do espaço em branco no array de pecas
		int pos = 0;
		for(int i = 0; i < this.listaPecas.length; i++) {
			if(listaPecas[i].equals("  ")) {
				pos = i;
			}
		}
		return pos;
	}
	
	
	public void preencheMatriz() { //preenche a matriz de pecas com os valores do array(passa para duas dimensoes)
		int contador = 0;
		String[][] matrizTemp = new String[this.matriz][this.matriz];
        for(int i = 0; i < this.matriz; i++) {
            for(int k = 0; k < this.matriz; k++) {
                matrizTemp[i][k] = this.listaPecas[contador]; 
                contador++;
            }
        }
        this.matrizPecas = matrizTemp;
	}
	
	
	public String[][] getMatrizCorreta(){ //retorna uma matriz com as pecas na ordem correta
		String[][] matrizCorreta = new String[this.matriz][this.matriz];
		String[] listaPecas = new String[this.matriz*this.matriz];
		int contador = 0;
		
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			listaPecas[i] = String.valueOf(i + 1);
		}
		listaPecas[listaPecas.length - 1] = "  ";
		
		for(int i = 0; i < this.matriz; i++) {
            for(int k = 0; k < this.matriz; k++) {
                matrizCorreta[i][k] = listaPecas[contador]; 
                contador++;
            }
        }
		return matrizCorreta;
	}
	

}

