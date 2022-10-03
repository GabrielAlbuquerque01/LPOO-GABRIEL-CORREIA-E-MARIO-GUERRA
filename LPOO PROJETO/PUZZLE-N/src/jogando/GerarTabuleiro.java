package jogando;

import static menu.ConstantesGraficas.corPlanoFundo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logicaJogo.*;

public class GerarTabuleiro extends JPanel{
	
	private MexerPeca tabuleiro;
	private static final Color COR_PECA = new Color(50, 0, 50);
	private static final Color COR_PECA_CORRETA = new Color(25, 150, 25);
	private int tamanho;
	private int tamanhoPeca;
	private int margem;
	private int tamanhoMatriz; 
	private int dimensao;
	private boolean fimDeJogo;
	
	
	public GerarTabuleiro(int tam, int dim, int mar, MexerPeca tab) {
		
		this.tamanho = tam;
		this.margem = mar;
		this.dimensao = dim;
		this.tabuleiro = tab;
	
		
	    this.tamanhoMatriz = (dim - 2 * this.margem);
	    this.tamanhoPeca = this.tamanhoMatriz / this.tamanho;
	    
	    setPreferredSize(new Dimension(dimensao, dimensao + margem));
	    setBackground(Color.BLACK);
	    setForeground(COR_PECA);
	    setFont(new Font("SansSerif", Font.BOLD, 60));
	    
	    fimDeJogo = false;
	    
	 
	    //comunicação com os cliques do usuário
	    addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
	        	
	          if (fimDeJogo) {
	            novoJogo();
	            
	          } else {
	        	tabuleiro.trocaLugar();
	            // posição do clique
	            int ex = e.getX() - margem;
	            int ey = e.getY() - margem;
	            
	            // descobre se foi clicado
	            if (ex < 0 || ex > tamanhoMatriz  || ey < 0  || ey > tamanhoMatriz)
	              return;
	            
	            // posição da peça clicada
	            int yClique = ex / tamanhoPeca;
	            int xClique = ey / tamanhoPeca;
	            
	            // posição da célula vazia
	            int yVazio = tabuleiro.getVazio() % tamanho;
	            int xVazio = tabuleiro.getVazio() / tamanho;
	            
	            
	            if(xClique == xVazio - 1 && yClique == yVazio) {
	            	tabuleiro.mexeBaixo();
	            }
	            else if(xClique == xVazio + 1 && yClique == yVazio) {
	            	tabuleiro.mexeCima();
	            }
	            else if(xClique == xVazio && yClique == yVazio - 1) {
	            	tabuleiro.mexeDireita();
	            }
	            else if(xClique == xVazio && yClique == yVazio + 1) {
	            	tabuleiro.mexeEsquerda();
	            }
	            
	            fimDeJogo = tabuleiro.terminaJogo();
	            
	          }
	          
	          // recoloca o painel na tela
	          repaint();
	        }
	      });
	    novoJogo();
	}
	
	
	private void novoJogo() {
		fimDeJogo = false;
		tabuleiro.preencheArray();
		tabuleiro.embaralhaArray();
		tabuleiro.preencheMatriz();
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
	    	  g.setColor(getForeground());
	      }
	      g.fillRoundRect(x, y, tamanhoPeca, tamanhoPeca, 80, 80);
	      g.setColor(Color.BLACK);
	      g.drawRoundRect(x, y, tamanhoPeca, tamanhoPeca, 80, 80);
	      g.setColor(Color.WHITE);
	      
	      desenhaNumeros(g, String.valueOf(tabuleiro.getListaPecas()[i]), x , y);
	    }
	  }

	
	  private void mensagemFimJogo(Graphics2D g) {
	    if (fimDeJogo) {
	    	/*new FimDeJogo();
	      g.setFont(getFont().deriveFont(Font.BOLD, 18));
	      g.setColor(Color.WHITE);
	      String s = "PARABÉNSS VC GANHOU O JOGO";
	      g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) / 2,
	          getHeight() - margem); */
	    }
	  }
	  
	  
	  private void desenhaNumeros(Graphics2D g, String s, int x, int y) {
	    FontMetrics fm = g.getFontMetrics();
	    int ascendente = fm.getAscent();
	    int descendente = fm.getDescent();
	    g.drawString(s,  x + (tamanhoPeca - fm.stringWidth(s)) / 2, 
	        y + (ascendente + (tamanhoPeca - (ascendente + descendente)) / 2));
	  }
	  
	  
	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2D = (Graphics2D) g;
	    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    desenhaMatriz(g2D);
	    mensagemFimJogo(g2D);
	  }
}
