package menu;

import static menu.ConstantesGraficas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import jogando.TelaJogo;

public class MenuPrincipal extends JFrame implements ActionListener {
	
		private int dif;
		private int modo;
		private JLabel nomeDoJogo = new JLabel("PUZZLE-N");
		private JLabel difAtual = new JLabel();
		private JLabel modoAtual = new JLabel();
		private JButton jogar = new JButton("Jogar");
		private JButton alterarDif = new JButton("Alterar dificuldade");
		private JButton ranking = new JButton("Ranking");
		private JButton sair = new JButton("Sair");
		private JButton alterarModo = new JButton("Alterar modo");
		
		
	public MenuPrincipal() {
		
		this.dif = 3; //inicialização padrão
		this.modo = 1;
		
		setTitle("Menu principal");
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(corPlanoFundo);
		
		add(nomeDoJogo);
		nomeDoJogo.setBounds(120,60,400,100);
		nomeDoJogo.setFont(titulo);
		nomeDoJogo.setForeground(corTexto);
		
		add(difAtual);
		difAtual.setText("Dificuldade atual: Médio");
		difAtual.setBounds(10,480,250,50);
		difAtual.setFont(fonteGeral);
		difAtual.setForeground(corTexto);
		
		add(modoAtual);
		modoAtual.setText("Modo atual: Número");
		modoAtual.setBounds(10,510,250,50);
		modoAtual.setFont(fonteGeral);
		modoAtual.setForeground(corTexto);
		
		
		add(jogar);
		jogar.setBounds(170,200,250,50);
		jogar.setFont(fonteGeral);
		jogar.setForeground(corTexto);
		jogar.setBackground(corBotoes);
		
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
	
	
	public void setDif(int dif) {
		this.dif = dif;
	}
	
	
	public void setModo(int modo) {
		this.modo = modo;
	}
	
	
	public void mostrarDif() {
		
		if (this.dif == 2) {
			difAtual.setText("Dificuldade atual: Fácil");
		}
		else if (this.dif == 3) {
			difAtual.setText("Dificuldade atual: Médio");
		}
		else {
			difAtual.setText("Dificuldade atual: Difícil");
		}	
	}
	
	
	public void mostrarModo() {
		
		if (this.modo == 1) {
			modoAtual.setText("Modo Atual: Número");
		}
		else if (this.modo == 2) {
			modoAtual.setText("Modo Atual: Caractere");
		}
		else if (this.modo == 3) {
			modoAtual.setText("Modo Atual: Path");
		}
		else {
			modoAtual.setText("Modo Atual: Maluco");
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jogar) {
			this.dispose();
			TelaJogo jogando = new TelaJogo(this.dif, this.modo);
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
			
		}
		
		else if(e.getSource()==sair) {
			System.exit(0);
		}
		
	}
	
	
	public static void main (String[] args) {
		new MenuPrincipal();
	}
	
	
}
