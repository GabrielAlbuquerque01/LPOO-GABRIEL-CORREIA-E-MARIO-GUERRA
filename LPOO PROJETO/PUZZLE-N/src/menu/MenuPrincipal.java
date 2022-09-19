package menu;

import static menu.ConstantesGraficas.*;
import interfaceJogo.TelaJogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPrincipal extends JFrame implements ActionListener {
	
		private JLabel nomeDoJogo = new JLabel("PUZZLE-N");
		private JButton jogar = new JButton("Jogar");
		private JButton alterarDif = new JButton("Alterar dificuldade");
		private JButton creditos = new JButton("Créditos");
		private JButton sair = new JButton("Sair");
		
		
	public MenuPrincipal() {
		
		setTitle("Menu principal");
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(corPlanoFundo);
		
		add(nomeDoJogo);
		nomeDoJogo.setBounds(120,80,400,100);
		nomeDoJogo.setFont(titulo);
		nomeDoJogo.setForeground(corTexto);
		
		add(jogar);
		jogar.setBounds(170,250,250,50);
		jogar.setFont(fonteGeral);
		jogar.setForeground(corTexto);
		jogar.setBackground(corBotoes);
		
		add(alterarDif);
		alterarDif.setBounds(170,300,250,50);
		alterarDif.setFont(fonteGeral);
		alterarDif.setForeground(corTexto);
		alterarDif.setBackground(corBotoes);
		
		add(creditos);
		creditos.setBounds(170,350,250,50);
		creditos.setFont(fonteGeral);
		creditos.setForeground(corTexto);
		creditos.setBackground(corBotoes);
		
		add(sair);
		sair.setBounds(170,400,250,50);
		sair.setFont(fonteGeral);
		sair.setForeground(corTexto);
		sair.setBackground(corBotoes);
		
		
		jogar.addActionListener(this);
		alterarDif.addActionListener(this);
		creditos.addActionListener(this);
		sair.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jogar) {
			this.dispose();
			TelaJogo jogando = new TelaJogo();
			jogando.jogando(3);
		}
		
		else if(e.getSource()==alterarDif) {
			this.dispose();
			new Configurar();
		}
		
		else if(e.getSource()==creditos) {
			this.dispose();
			new Creditos();
		}
		
		else if(e.getSource()==sair) {
			System.exit(0);
		}
		
	}
	
	public static void main (String[] args) {
		new MenuPrincipal();
	}
	
}
