package jogo;
import java.util.*;

public abstract class Tabuleiro {
	private int matriz;
	private String[] listaPecas;
	private String[][] matrizPecas;
	
	
	public Tabuleiro(int matriz){
		setMatriz(matriz);
	}
	
	
	public void setMatriz(int matriz) { //armazena o valor da matriz
		if(matriz == 3 || matriz == 4) {
			this.matriz = matriz;
		}
	}
	
	public int getMatriz() {
		return this.matriz;
	}
	
	
	public String[][] getTabuleiro() { //retorna a matriz de peças do jogo
		return this.matrizPecas;
	}
	
	
	public void setTabuleiro(String[][] tabuleiro) { //seta a matriz de peças do jogo
		this.matrizPecas = tabuleiro;
	}
	
	
	public void preencheArray() { //cria uma lista coms os valores
		String[] tempArray = new String[this.matriz*this.matriz]; //array temporário que armazena a ordem
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			tempArray[i] = "[" + String.valueOf(i + 1) + "]";
		}
		this.listaPecas = tempArray; 
		listaPecas[listaPecas.length - 1] = "[ ]";
	}
	
	
	public void preencheMatriz() { //tranforma a lista em um array 2d
		int contador = 0;
		String[][] matrizTemp = new String[this.matriz][this.matriz];
        for(int i = 0; i < this.matriz; i++) {
            for(int k = 0; k < this.matriz; k++) {
                matrizTemp[i][k] = this.listaPecas[contador]; //escreve no console enquanto não há interface
                contador++;
            }
        }
        this.matrizPecas = matrizTemp;
	}
	
	
	public void embaralhaArray() { //embaralha a lista 
        List<String> list =Arrays.asList(this.listaPecas); //embaralha o array que contém as pecas
        Collections.shuffle(list);
        list.toArray(this.listaPecas);
	}
	
	
	public void exibeMatriz() { //printa os numeros do array de pecas em forma de matriz
        for(int i = 0; i < this.matriz; i++) {
            for(int k = 0; k < this.matriz; k++) {
                System.out.print(this.matrizPecas[i][k] + "\t"); //escreve no console enquanto não há interface
            }
            System.out.println();
        }
	}
	 
	public String[][] getMatrizCorreta(){
		String[][] matrizCorreta = new String[this.matriz][this.matriz];
		String[] listaPecas = new String[this.matriz*this.matriz];
		int contador = 0;
		
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			listaPecas[i] = "[" + String.valueOf(i + 1) + "]";
		}
		listaPecas[listaPecas.length - 1] = "[ ]";
		
		for(int i = 0; i < this.matriz; i++) {
            for(int k = 0; k < this.matriz; k++) {
                matrizCorreta[i][k] = listaPecas[contador]; //escreve no console enquanto não há interface
                contador++;
            }
        }
		return matrizCorreta;
	}
	
}

