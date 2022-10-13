package jogando;

import static menu.ConstantesGraficas.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import menu.Logar;
import menu.MenuPrincipal;

public class FimDeJogo extends JFrame implements ActionListener{
	
	private String nomeRanking;
	private int tempoRanking;
	private MenuPrincipal menu;
	private JLabel mensagem = new JLabel("Fim de jogo");
	private JLabel mostrarTempo = new JLabel("Seu tempo:");
	private JButton voltar = new JButton("início");
	private JButton sair = new JButton("Sair");
	
	public FimDeJogo(String nome, int tempo) {
		
	this.nomeRanking = nome;
	this.tempoRanking = tempo;
	
	setSize(600,300);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);
	setLayout(new BorderLayout());
	getContentPane().setBackground(corPlanoFundo);
	
	add(mensagem,BorderLayout.NORTH);
	mensagem.setHorizontalAlignment(SwingConstants.CENTER);
	mensagem.setText("Game Over! Parabéns, "+this.getNomeRanking()+".");
	mensagem.setFont(fonteGeral);
	mensagem.setBackground(corPlanoFundo);
	mensagem.setForeground(corTexto);
	
	add(mostrarTempo,BorderLayout.CENTER);
	mostrarTempo.setVerticalAlignment(SwingConstants.CENTER);
	mostrarTempo.setHorizontalAlignment(SwingConstants.CENTER);
	mostrarTempo.setText("Seu tempo: "+this.getTempoRanking()+" segundos");
	mostrarTempo.setFont(fonteGeral);
	mostrarTempo.setBackground(corPlanoFundo);
	mostrarTempo.setForeground(corTexto);
	
	JPanel pButoes = new JPanel();
	pButoes.setLayout(new BorderLayout());
	pButoes.setBackground(corPlanoFundo);
	add(pButoes,BorderLayout.SOUTH);
	
	pButoes.add(voltar,BorderLayout.NORTH);
	voltar.setFont(fonteGeral);
	voltar.setBackground(corBotoes);
	voltar.setForeground(corTexto);
	
	pButoes.add(sair,BorderLayout.SOUTH);
	sair.setFont(fonteGeral);
	sair.setBackground(corBotoes);
	sair.setForeground(corTexto);
	
	
	
	voltar.addActionListener(this);
	sair.addActionListener(this);
	
	}
	
	public String getNomeRanking() {
		return this.nomeRanking;
	}
	
	public int getTempoRanking() {
		return this.tempoRanking;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==voltar) {
			this.dispose();
			new Logar();
		}
		else if(e.getSource()==sair) {
			System.exit(0);
		}
		
	}
	
}
