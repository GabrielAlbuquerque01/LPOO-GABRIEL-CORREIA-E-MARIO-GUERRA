package jogando;

import static menu.ConstantesGraficas.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import fonte.Fonte;
import logicaJogo.*;
import menu.Jogador;
import saves.Ranking;


public class GerarImg extends JPanel implements ActionListener{
	
	private MexerPeca tabuleiro;
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
	private JButton ajuda = new JButton("AJUDA");
	private boolean Ajuda;
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont();
	
	
	public GerarImg(int tam, int dim, int mar, MexerPeca tab,TelaJogo tela, Jogador jogador) {
		
		this.Ajuda = false;
		this.fimDeJogo = false;
		this.jogador = jogador;
		this.tela = tela;
		this.tamanho = tam;
		this.margem = mar;
		this.dimensao = dim;
		this.tabuleiro = tab;
		
		add(ajuda);
		ajuda.setBounds(0,30,100,50);
		ajuda.setFont(fonteGeral);
		ajuda.setForeground(corTexto);
		ajuda.setBackground(corBotoes);
		ajuda.addActionListener(this);
		
	    this.tamanhoMatriz = (dim - 2 * this.margem);
	    this.tamanhoPeca = this.tamanhoMatriz / this.tamanho;
	    
	    setPreferredSize(new Dimension(dimensao, dimensao + margem));
	    setBackground(Color.BLACK);
	    setForeground(COR_PECA);
	    setFont(new Font("SansSerif", Font.BOLD, 60));
	    
	    fimDeJogo = false;
	    	    
	    addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
	        	
	          if (fimDeJogo) {
	            novoJogo();
	            
	          } else {
	            
	            int ex = e.getX() - margem;
	            int ey = e.getY() - margem;
	            	            
	            if (ex < 0 || ex > tamanhoMatriz  || ey < 0  || ey > tamanhoMatriz)
	              return;
	            	            
	            int yClique = ex / tamanhoPeca;
	            int xClique = ey / tamanhoPeca;
	            	            
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
	          repaint();
	        }
	      });
	    novoJogo();
	}

	
	private void novoJogo() {
		fimDeJogo = false;
		if(tabuleiro.getListaPecas() == null) {
			tabuleiro.preencheArray();
			tabuleiro.embaralhaArray();
		}
		tabuleiro.preencheMatriz();
	}
	
	public void desenhaMatriz(Graphics2D g) {
		
		BufferedImage imagem = null;
		String numImg;
		String pasta;
		
		if(tabuleiro.getMatriz() == 2) {
			pasta = "imagens2x2";
			numImg = "_2";
		}
		else if (tabuleiro.getMatriz() == 3){
			pasta = "imagens3x3";
			numImg = "_3";
		}
		else {
			pasta = "imagens4x4";
			numImg = "_4";
		}
		
	    for (int i = 0; i < tabuleiro.getListaPecas().length; i++) {
	      
	      int r = i / tamanho;
	      int c = i % tamanho;	      
	      int x = margem + c * tamanhoPeca;
	      int y = margem + r * tamanhoPeca;
	      	   
	      if(tabuleiro.getListaPecas()[i].equals("  ")) {
	        if (fimDeJogo) { 
	          g.setColor(Color.white);
	          desenhaNumeros(g, "\u2715", x, y);
	        }
	        continue;
	      }
	      	      
	      if(tabuleiro.getListaPecas()[i].equals(tabuleiro.getListaCorreta()[i])) {
	    	  g.setColor(COR_PECA_CORRETA); 
	      }
	      else {
	    	  g.setColor(getForeground());
	      }
	      g.fillRoundRect(x, y, tamanhoPeca, tamanhoPeca, 80, 80);
	      g.setColor(Color.BLACK);
	      g.drawRoundRect(x, y, tamanhoPeca, tamanhoPeca, 80, 80);
	      g.setColor(Color.WHITE);
	      try {
	    	  	String path = pasta + "/" + tabuleiro.getListaPecas()[i]+ numImg + ".jpg";
			    imagem = ImageIO.read(getClass().getResourceAsStream(path));
			} catch (IOException e) {
			}
	      
	      g.drawImage(imagem, x, y, tamanhoPeca, tamanhoPeca, null);
	      
	      if(this.Ajuda == true) {
	    	  desenhaNumeros(g, String.valueOf(tabuleiro.getListaPecas()[i]), x , y);
	      }
	    }
	  }
	
	  private void mensagemFimJogo() {
	    if (fimDeJogo) {
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
	  
	  public void setAjuda(boolean ajuda) {
		  this.Ajuda = ajuda;
	  }
	  
	  
	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2D = (Graphics2D) g;
	    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    desenhaMatriz(g2D);
	    mensagemFimJogo();
	  }

	  
	  public boolean getAjuda() {
		  return this.Ajuda;
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==ajuda) {
			
			if(this.getAjuda()==false) {
				this.setAjuda(true);
				repaint();
			}
			else if(this.getAjuda()==true) {
					this.setAjuda(false);
					repaint();
			}
		}
	}
	
}