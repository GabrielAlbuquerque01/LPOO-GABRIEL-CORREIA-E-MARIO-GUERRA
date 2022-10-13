package logicaJogo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TabChar implements Tabuleiro {
	
	private Integer[] tempArray;
	private int matriz;
	private Character[] listaPecas;
	private Character[][] matrizPecas;
	
	
	public TabChar(int matriz) {
		this.matriz = matriz;
	}
	
	
	public void setMatriz(int matriz) {
		if(matriz == 2 ||matriz == 3 || matriz == 4) {
			this.matriz = matriz;
		}
		
	}
	
	
	public int getMatriz() {
		return this.matriz;
	}
	
	
	public void setTabuleiro(Character[][] tabuleiro) {
		this.matrizPecas = tabuleiro;
	}
	
	
	public Character[][] getTabuleiro() {
		return this.matrizPecas;
	}
	
	
	public Character[] getListaPecas() {
		return this.listaPecas;
	}
	
	@Override
	public void preencheArray() {
		this.tempArray = new Integer[this.matriz*this.matriz];//array temporário que armazena a ordem das pecas
		int contador = 97;
		
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			tempArray[i] = contador;
			contador++;
		}
		tempArray[tempArray.length - 1] = 0;
		/*Character[] tempArray = new Character[this.matriz*this.matriz];
		int contador = 97;
		
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			tempArray[i] = (char)contador;
			contador++;
		}
		
		this.listaPecas = tempArray;
		listaPecas[listaPecas.length - 1] = ' ';
		*/
	}

	
	@Override
	public void embaralhaArray() {
		
		this.listaPecas = new Character[this.matriz*this.matriz];
		
		
        List<Integer> list =Arrays.asList(this.tempArray); 
        Collections.shuffle(list);
        list.toArray(this.tempArray);
       
       Integer aux = 0;
        for(int i = 0; i<this.tempArray.length;i++) {
        	if(this.tempArray[i]==0) {
        		aux = tempArray[i];
        		tempArray[i] = tempArray[tempArray.length-1];
        		tempArray[listaPecas.length-1] = aux;
        		break;
        	}
        }
        
         
        int contadorInv = 0;
        for(int i=0;i<tempArray.length-1;i++) {
        	for(int j=0;j<tempArray.length-1;j++) {
        	if(j>i && (tempArray[i]!=0) && (tempArray[j] !=0)) {	
        	if(tempArray[i]>tempArray[j]) {
        		contadorInv++;
        	}
        	}
        }
        	
        }
        if(contadorInv%2 !=0 || contadorInv ==0) {
        	this.preencheArray();
        	this.embaralhaArray();
        }
        else{
        
        int x = 0;
        for(int i=0;i<tempArray.length;i++) {
        	if(this.tempArray[i]==0) {
        		this.listaPecas[i] =' ';
        	}else
        	x = tempArray[i];
        	this.listaPecas[i]= (char)x;
        	
        }
        this.listaPecas[listaPecas.length-1]=' '; //???????
        }
		
		
		/*List<Character> list = Arrays.asList(this.listaPecas); 
        Collections.shuffle(list);
        list.toArray(this.listaPecas);
		*/
	}


	public void setListaPecas(Character[][]matriz) {
		int contador = 0;
		for(int i = 0; i < this.matriz; i++) {
			for(int k = 0; k < this.matriz; k++) {
				this.listaPecas[contador] = matriz[i][k];
				contador++;
			}
		}
		
	}

	
	@Override
	public Character[] getListaCorreta() {
		
		Character[] listaPecas = new Character[this.matriz*this.matriz];
		int contador = 97;
		
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			listaPecas[i] = (char)contador;
			contador++;
		}
		
		listaPecas[listaPecas.length - 1] = ' ';
		return listaPecas;
	}
	

	@Override
	public int getVazio() {
		int pos = 0;
		for(int i = 0; i < this.listaPecas.length; i++) {
			if(listaPecas[i].equals(' ')) {
				pos = i;
			}
		}
		return pos;
	}

	
	@Override
	public void preencheMatriz() {
		int contador = 0;
		Character[][] matrizTemp = new Character[this.matriz][this.matriz];
        for(int i = 0; i < this.matriz; i++) {
            for(int k = 0; k < this.matriz; k++) {
                matrizTemp[i][k] = this.listaPecas[contador]; 
                contador++;
            }
        }
        this.matrizPecas = matrizTemp;
		
	}

	
	@Override
	public Character[][] getMatrizCorreta() {
		Character[][] matrizCorreta = new Character[this.matriz][this.matriz];
		Character[] listaPecas = new Character[this.matriz*this.matriz];
		int contador = 0;
		int contadorChar = 97;
		
		for(int i = 0; i < this.matriz*this.matriz; i++) {
			listaPecas[i] = (char)contadorChar;
		}
		listaPecas[listaPecas.length - 1] = ' ';
		
		for(int i = 0; i < this.matriz; i++) {
            for(int k = 0; k < this.matriz; k++) {
                matrizCorreta[i][k] = listaPecas[contador]; 
                contador++;
            }
        }
		return matrizCorreta;
	}

}
