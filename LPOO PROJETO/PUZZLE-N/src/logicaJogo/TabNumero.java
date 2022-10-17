package logicaJogo;
import java.util.*;

public abstract class TabNumero implements Tabuleiro{
	
	private Integer[] tempArray;
	private int matriz;
	private String[] listaPecas;
	private String[][] matrizPecas;
	
	
	public TabNumero(int matriz){
		setMatriz(matriz);
	}
	
	public void setLista(String[] lista) {
		this.listaPecas = lista;
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
	
	
	public void preencheArray() {//cria uma lista com os valores das pecas
		
		this.tempArray = new Integer[this.matriz*this.matriz]; //array que armazena inteiros correspondentes aos valores das pecas
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			tempArray[i] = (i + 1);
		}
		tempArray[tempArray.length - 1] = 0;
			
	}
	
	
	public void embaralhaArray() { //transforma o array de inteiros em lista, embaralha e depois retransforma em array
	
		this.listaPecas = new String[this.matriz*this.matriz];
		
       List<Integer> list =Arrays.asList(this.tempArray); 
       Collections.shuffle(list); //embaralha tempArray
       list.toArray(this.tempArray);
       
       Integer aux = 0; //o 0 representa o espaço em branco
        for(int i = 0; i<this.tempArray.length;i++) {//coloca o zero na ultima posicao
        	if(this.tempArray[i]==0) {
        		aux = tempArray[i];
        		tempArray[i] = tempArray[tempArray.length-1];
        		tempArray[listaPecas.length-1] = aux;
        		break;
        	}
        }
         
        int contadorInv = 0;//inversoes sao necessarias quando um numero maior vem antes de um menor na lista
        for(int i=0;i<tempArray.length-1;i++) {//conta o numero de inversoes
        	for(int j=0;j<tempArray.length-1;j++) {
        		if(j>i && (tempArray[i]!=0) && (tempArray[j] !=0)) {//ignora o 0, que representa o blankspace	
        			if(tempArray[i]>tempArray[j]) {
        				contadorInv++;
        			}
        		}
        	}	
        }
        
        if(contadorInv%2 !=0 || (contadorInv == 0)) {//se o numero de inversoes for par ou diferente de 0(que é quando a matriz ja vem em ordem pronta),embaralha de novo
        	this.preencheArray();
        	this.embaralhaArray();
        } else{
        	
        	for(int i=0;i<tempArray.length;i++) {//preenche o array de string que sera usado para representar as pecas
        		if(this.tempArray[i]==0) {
        			this.listaPecas[i] ="  ";
        		}else {
        			this.listaPecas[i]=String.valueOf(tempArray[i]);
        		}
        }
        }
           
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

