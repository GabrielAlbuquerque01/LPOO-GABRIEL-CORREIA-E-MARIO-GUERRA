package jogo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Testando {
	public static void main(String[] args){
		Jogando jogo = new Jogando();
		jogo.jogo();
	}
	
}

/*
public String[][] getMatrizCorreta(){
	String[][] matrizCorreta = new String[this.matriz][this.matriz];
	String[] listaPecas = new String[this.matriz*this.matriz];
	int contador = 0;
	
	for(int i = 0; i < this.matriz*this.matriz; i++) {
		listaPecas[i] = String.valueOf(i + 1);
	}
	listaPecas[listaPecas.length - 1] = "  ";
	
	for(int i = 0; i < this.matriz; i++) {
        for(int k = 0; k < this.matriz; k++) {
            matrizCorreta[i][k] = listaPecas[contador]; //escreve no console enquanto não há interface
            contador++;
        }
    }
	return matrizCorreta;
}



private void desenhaMatriz(Graphics2D g) {
	
    for (int i = 0; i < tabuleiro.getListaPecas().length; i++) {
      // conversao do array 1d em 2d
      int r = i / tamanho;
      int c = i % tamanho;
      // conversao realizada na interface
      int x = margem + c * tamanhoPeca;
      int y = margem + r * tamanhoPeca;
      
   // checa a peça vazia para determinar se o jogo terminou
      if(tabuleiro.getListaPecas()[i].equals("  ")) {
        if (fimDeJogo) { 
          g.setColor(Color.white);
          desenhaNumeros(g, "\u2715", x, y);
        }
        continue;
      }
      
      // colocação das pecas
      if(tabuleiro.getListaPecas()[i].equals(tabuleiro.getListaCorreta()[i])) {
    	  g.setColor(COR_PECA_CORRETA); //destaca as pecas na posição correta
      }
      else {
    	  tabuleiro.getListaPecas()[i] = tabuleiro.getListaCorreta()[i];
    	  g.setColor(Color.blue);
      }
      g.fillRoundRect(x, y, tamanhoPeca, tamanhoPeca, 80, 80);
      g.setColor(Color.BLACK);
      g.drawRoundRect(x, y, tamanhoPeca, tamanhoPeca, 80, 80);
      g.setColor(Color.WHITE);
      
      desenhaNumeros(g, String.valueOf(tabuleiro.getListaPecas()[i]), x , y);
    }
  }
*/
		
