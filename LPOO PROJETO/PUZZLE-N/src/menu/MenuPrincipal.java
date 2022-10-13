package menu;

import static menu.ConstantesGraficas.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fonte.Fonte;
import jogando.TelaJogo;

public class MenuPrincipal extends JFrame implements ActionListener {

		private int dif;
		private int modo;
		private boolean maluco;
		private Jogador jogador = new Jogador("");
		private JLabel nomeDoJogo = new JLabel("PUZZLE-N");
		private JLabel difAtual = new JLabel();
		private JLabel modoAtual = new JLabel();
		private JButton jogar = new JButton("Jogar");
		private JButton alterarDif = new JButton("dificuldade");
		private JButton ranking = new JButton("Ranking");
		private JButton sair = new JButton("Sair");
		private JButton alterarModo = new JButton("modo");
		private Fonte fonte = new Fonte();
		private Font fonteGeral = fonte.getFont();
		
	public MenuPrincipal(String NomeJogador) {
		
		this.jogador.setNome(NomeJogador);
		
		this.dif = 3; //inicialização padrão
		this.modo = 1;
		this.maluco = false;
		

		setTitle("Menu principal");
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(corPlanoFundo);
		
		try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("backgrounds/inicio.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		add(nomeDoJogo);
		nomeDoJogo.setBounds(120,60,400,100);
		nomeDoJogo.setFont(titulo);
		nomeDoJogo.setForeground(corTexto);
		nomeDoJogo.setVisible(true);
		
		add(difAtual);
		difAtual.setText("Dificuldade: Médio");
		difAtual.setBounds(10,480,250,50);
		difAtual.setFont(fonteGeral);
		difAtual.setForeground(corTexto);
		
		add(modoAtual);
		modoAtual.setText("Modo: Número");
		modoAtual.setBounds(10,510,250,50);
		modoAtual.setFont(fonteGeral);
		modoAtual.setForeground(corTexto);
		
		
		add(jogar);
		jogar.setBounds(170,200,250,50);
		jogar.setFont(fonteGeral);
		jogar.setForeground(corTexto);
		jogar.setBackground(corBotoes);
		jogar.setVisible(true);
		
		add(alterarModo);
		alterarModo.setBounds(170,250,250,50);
		alterarModo.setFont(fonteGeral);
		alterarModo.setForeground(corTexto);
		alterarModo.setBackground(corBotoes);
		
		add(alterarDif);
		alterarDif.setBounds(170,300,250,50);
		alterarDif.setFont(fonteGeral);
		alterarDif.setForeground(corTexto);
		alterarDif.setBackground(corBotoes);
		
		add(ranking);
		ranking.setBounds(170,350,250,50);
		ranking.setFont(fonteGeral);
		ranking.setForeground(corTexto);
		ranking.setBackground(corBotoes);
		
		add(sair);
		sair.setBounds(170,400,250,50);
		sair.setFont(fonteGeral);
		sair.setForeground(corTexto);
		sair.setBackground(corBotoes);
		
		jogar.addActionListener(this);
		alterarDif.addActionListener(this);
		alterarModo.addActionListener(this);
		ranking.addActionListener(this);
		sair.addActionListener(this);
		

	}
	
	public boolean getMaluco() {
		return this.maluco;
	}
	
	public void setMaluco(boolean maluco) {
		this.maluco = maluco;
	}
	
	public String getJogador() {
		return jogador.getNome();
		
	}
	
	public void setJogador(String nome) {
		this.jogador.setNome(nome);
	}
	
	public void setDif(int dif) {
		this.dif = dif;
	}
	
	
	public void setModo(int modo) {
		this.modo = modo;
	}
	
	
	public void mostrarDif() {
		
		if (this.dif == 2) {
			difAtual.setText("Dificuldade: Fácil");
		}
		else if (this.dif == 3) {
			difAtual.setText("Dificuldade: Médio");
		}
		else {
			difAtual.setText("Dificuldade: Difícil");
		}	
	}
	
	
	public void mostrarModo() {
		
		if (this.modo == 1) {
			modoAtual.setText("Modo: Número");
		}
		else if (this.modo == 2) {
			modoAtual.setText("Modo: Caractere");
		}
		else if (this.modo == 3) {
			modoAtual.setText("Modo: Path");
		}
		else if (this.modo == 4)  {
			modoAtual.setText("Modo: Maluquinho");
		}
		else if (this.modo == 5)  {
			modoAtual.setText("Modo: Insano");
		}
		else if (this.modo == 6)  {
			modoAtual.setText("Modo: Hospício");
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jogar) {
			this.dispose();
			TelaJogo jogando = new TelaJogo(this.dif, this.modo,this.jogador);
			jogando.jogando();
		}
		
		else if(e.getSource()==alterarDif) {
			this.setVisible(false);
			new AlterarDif(this);
			
		}	
		
		else if(e.getSource()==alterarModo) {
			this.setVisible(false);
			new AlterarModo(this);
			
		}
		
		else if(e.getSource()==ranking) {
			this.setVisible(false);
			new Ranking(this);
		}
		
		else if(e.getSource()==sair) {
			System.exit(0);
		}
		
	}
	
	
	/*public static void main (String[] args) {
		new MenuPrincipal();
	}*/
	
	
}
