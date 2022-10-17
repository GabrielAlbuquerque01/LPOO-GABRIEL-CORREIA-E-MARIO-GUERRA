package jogando;

import static menu.ConstantesGraficas.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fonte.Fonte;
import jogando.acoes.Cronometro;
import jogando.acoes.SalvaJogo;
import menu.Jogador;
import menu.MenuPrincipal;
import logicaJogo.MexerChar;
import logicaJogo.MexerMaluco;
import logicaJogo.MexerPeca;

public class TelaJogo extends JFrame implements ActionListener{
	
	private int tamanhoMatriz;
	private int modoDeJogo;
	private Cronometro cronometro;
	private JPanel info = new JPanel();
	private JLabel mostrarTempo = new JLabel("  tempo - 0 s");
	private Jogador jogador;
	private JLabel mostrarJogador = new JLabel();
	private JButton voltar;
	private JPanel tela;
	private GerarImg telaImg;
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont();
	private boolean salvo;
	private Object[] listaPecas;
	private String[] listaSalva;
	private Character[] listaChar;
	
	public TelaJogo(int tamanhoMatriz, int modoDeJogo, Jogador jogador, boolean save, String[] listaSalva, Character[] listaChar) {
		
		this.listaChar = listaChar;
		this.listaSalva = listaSalva;
		this.salvo = save;
		this.cronometro = new Cronometro(this);
		this.jogador = jogador;
		this.modoDeJogo = modoDeJogo;
		this.tamanhoMatriz = tamanhoMatriz;
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
		  	if(this.salvo == true) {
		  		tabuleiro.setLista(this.listaSalva);
		  	}
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarTabuleiro(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		    listaPecas = tabuleiro.getListaPecas();
		}
		
		else if (modoDeJogo == 2) {
			
			MexerChar tabuleiro = new MexerChar(this.tamanhoMatriz);
			if(this.salvo == true) {
		  		tabuleiro.setLista(this.listaChar);
		  	}
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarChar(tabuleiro.getMatriz(), 600, 50, tabuleiro,this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		    listaPecas = tabuleiro.getListaPecas();
			
			
		}
		
		else if (modoDeJogo == 3) {
			
			MexerPeca tabuleiro = new MexerPeca(this.tamanhoMatriz);
			if(this.salvo == true) {
		  		tabuleiro.setLista(this.listaSalva);
		  	}
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("PUZZLE-N");
			setResizable(false);
			this.telaImg = new GerarImg(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(telaImg, BorderLayout.CENTER);
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
			listaPecas = tabuleiro.getListaPecas();
			
			JPanel botoes = new JPanel();
		    add(botoes,BorderLayout.SOUTH);
		    botoes.setLayout(new BorderLayout());
		    botoes.setBackground(corPlanoFundo);
		    botoes.add(voltar,BorderLayout.SOUTH);		    
		}
		
		if (modoDeJogo == 4) {
			
		  	MexerMaluco tabuleiro = new MexerMaluco(this.tamanhoMatriz,1);
		  	if(this.salvo == true) {
		  		tabuleiro.setLista(this.listaSalva);
		  	}
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarTabuleiro(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		    listaPecas = tabuleiro.getListaPecas();
		    
			}
		
		if (modoDeJogo == 5) {
			
			MexerMaluco tabuleiro = new MexerMaluco(this.tamanhoMatriz,2);
			if(this.salvo == true) {
				tabuleiro.setLista(this.listaSalva);
		  	}
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarTabuleiro(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		    listaPecas = tabuleiro.getListaPecas();
		}
		if (modoDeJogo == 6) {
			
			MexerMaluco tabuleiro = new MexerMaluco(this.tamanhoMatriz,3);
			if(this.salvo == true) {
				tabuleiro.setLista(this.listaSalva);
		  	}
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    this.tela = new GerarTabuleiro(tabuleiro.getMatriz(), 600, 50, tabuleiro, this, this.jogador);
		    add(tela, BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		    listaPecas = tabuleiro.getListaPecas();
		    
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
		if(e.getSource() == voltar) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja salvar o jogo?", "AVISO", JOptionPane.YES_NO_OPTION);
			if(resposta == 0) {
				new SalvaJogo(this.jogador,this.tamanhoMatriz - 1, this.modoDeJogo, this.listaPecas);
			}
			this.dispose();
			new MenuPrincipal(this.jogador.getNome());
		}
	}
	
}
