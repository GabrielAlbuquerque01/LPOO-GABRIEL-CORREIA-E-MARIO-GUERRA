package jogando;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import jogando.acoes.FimDeJogo;
import jogando.acoes.Ranking;
import logicaJogo.MexerChar;
import logicaJogo.MexerPeca;
import menu.Jogador;

public class GerarChar extends JPanel{
	
	private MexerChar tabuleiro;
	private static final Color COR_PECA = new Color(50, 0, 50);
	private static final Color COR_PECA_CORRETA = new Color(25, 150, 25);
	private int tamanho;
	private int tamanhoPeca;
	private int margem;
	private int tamanhoMatriz; 
	private int dimensao;
	private boolean fimDeJogo;
	private Jogador jogador;
	private TelaJogo tela;
	
	
	public GerarChar(int tam, int dim, int mar, MexerChar tab, TelaJogo tela, Jogador jogador) {
		
		this.fimDeJogo = false;
		this.jogador = jogador;
		this.tela = tela;
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
	  
	    
	 
	    //comunicação com os cliques do usuário
	    addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
	        	
	          if (fimDeJogo) {
	            novoJogo();
	            
	          } else {
	        	  
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
	
	public boolean getFimDeJogo() {
		return this.fimDeJogo;
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
	      if(tabuleiro.getListaPecas()[i].equals(' ')) {
	        if (tabuleiro.terminaJogo()) { 
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

	
	  private void mensagemFimJogo() {
	    if (tabuleiro.terminaJogo()) {
	    	this.tela.dispose();
	    	FimDeJogo fimJogo = new FimDeJogo(this.tela.getNomeJogador(),this.tela.getTempoJogador(), this.tela.getDificuldade());
	    	new Ranking(fimJogo);
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
	    mensagemFimJogo();
	  }

	
	
}
