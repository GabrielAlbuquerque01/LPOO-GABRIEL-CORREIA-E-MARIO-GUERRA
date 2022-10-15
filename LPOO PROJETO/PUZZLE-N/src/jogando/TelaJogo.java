package jogando;

import static menu.ConstantesGraficas.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fonte.Fonte;
import jogando.acoes.Cronometro;
import menu.Jogador;
import menu.MenuPrincipal;
import logicaJogo.MexerChar;
import logicaJogo.MexerMaluco;
import logicaJogo.MexerPeca;

public class TelaJogo extends JFrame implements ActionListener{
	
	private int tamanhoMatriz;
	private int modoDeJogo;
	private boolean maluco;
	private Cronometro cronometro;
	private JPanel info = new JPanel();
	private JLabel mostrarTempo = new JLabel("  tempo - 0 s");
	private Jogador jogador;
	private JLabel mostrarJogador = new JLabel();
	private JButton botaoAjuda;
	private JButton voltar;
	private JButton salvar;
	private JPanel tela;
	private GerarImg telaImg;
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont();
	
	public TelaJogo(int tamanhoMatriz, int modoDeJogo, Jogador jogador) {
		
		this.cronometro = new Cronometro(this);
		this.jogador = jogador;
		this.modoDeJogo = modoDeJogo;
		this.tamanhoMatriz = tamanhoMatriz;
		this.botaoAjuda = new JButton("Ajuda");
		this.voltar = new JButton("Voltar para o menu");
		
		
		add(info,BorderLayout.NORTH);
	    info.setLayout(new BorderLayout());
	    info.setBackground(corPlanoFundo);
	    
	    info.add(mostrarJogador,BorderLayout.NORTH);
		mostrarJogador.setFont(fonteGeral);
		mostrarJogador.setForeground(corTexto);
		mostrarJogador.setText("  jogador - "+this.jogador.getNome());
		mostrarJogador.setVisible(true);
		
	    
	    info.add(mostrarTempo,BorderLayout.SOUTH);
		mostrarTempo.setFont(fonteGeral);
		mostrarTempo.setForeground(corTexto);
		mostrarTempo.setVisible(true);

	    
		add(voltar, BorderLayout.SOUTH);
		voltar.setFont(fonteGeral);
		voltar.setForeground(corTexto);
		voltar.setBackground(corBotoes);
	    
		voltar.addActionListener(this);
		
		cronometro.start();
		
		pack();
		
		
	}
	
	public void jogando(){
		
		if (modoDeJogo == 1) {
		
		  	MexerPeca tabuleiro = new MexerPeca(this.tamanhoMatriz);
		  
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarTabuleiro(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		
		}
		
		else if (modoDeJogo == 2) {
			
			MexerChar tabuleiro = new MexerChar(this.tamanhoMatriz);
			  
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarChar(tabuleiro.getMatriz(), 600, 50, tabuleiro,this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
			
			
		}
		
		else if (modoDeJogo == 3) {
			
			MexerPeca tabuleiro = new MexerPeca(this.tamanhoMatriz);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("PUZZLE-N");
			setResizable(false);
			this.telaImg = new GerarImg(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(telaImg, BorderLayout.CENTER);
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
			
			JPanel botoes = new JPanel();
		    add(botoes,BorderLayout.SOUTH);
		    botoes.setLayout(new BorderLayout());
		    botoes.setBackground(corPlanoFundo);
		    botoes.add(voltar,BorderLayout.SOUTH);		    
		}
		
		if (modoDeJogo == 4) {
			
		  	MexerMaluco tabuleiro = new MexerMaluco(this.tamanhoMatriz,1);
		  
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarTabuleiro(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		    
			}
		
		if (modoDeJogo == 5) {
			
			MexerMaluco tabuleiro = new MexerMaluco(this.tamanhoMatriz,2);
			  
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarTabuleiro(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
			
			
			
			
			
		}
		if (modoDeJogo == 6) {
			
			MexerMaluco tabuleiro = new MexerMaluco(this.tamanhoMatriz,3);
			  
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarTabuleiro(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		    
		}
		
	}
	
	public int getTempoJogador() {
		return jogador.getTempo();
	}
	
	public int getDificuldade() {
		return this.tamanhoMatriz - 1;
	}
	
	public void setTempoJogador(int tempo) {
		jogador.setTempo(tempo);
	}
	
	public String getNomeJogador() {
		return jogador.getNome();
	}
	
	public void setMostrarTempo(String relogio) {
		this.mostrarTempo.setText("  tempo - "+relogio);
	}
	
	public String getMostrarTempo() {
		return this.mostrarTempo.getText();
	}
	
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == botaoAjuda) {

		}
		
		else if(e.getSource() == voltar) {
			this.dispose();
			new MenuPrincipal(this.jogador.getNome());
			
		}
	}
	
}
