package menu;

import static menu.ConstantesGraficas.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fonte.Fonte;

public class Creditos extends JFrame implements ActionListener {

	private JLabel titulo;
	private JLabel criadores;
	private JButton voltar;
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont();
	
	public Creditos() {
		
		this.titulo = new JLabel();
		this.criadores = new JLabel();
		this.voltar = new JButton();
		
		setTitle("Créditos");
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(corPlanoFundo);
		
		add(titulo);
		titulo.setBounds(240,80,400,100);
		titulo.setFont(fonteGeral);
		titulo.setForeground(corTexto);
		titulo.setText("CRÉDITOS");
		
		add(criadores);
		criadores.setBounds(75,200,500,30);
		criadores.setFont(fonteGeral);
		criadores.setText("CRIADORES: Gabriel Correia e Mário Guerra.");
		criadores.setForeground(corTexto);
		
		add(voltar);
		voltar.setBounds(160,350,250,50);
		voltar.setFont(fonteGeral);
		voltar.setText("Voltar");
		voltar.setForeground(corTexto);
		voltar.setBackground(corBotoes);
		voltar.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==voltar) {
			
			this.dispose();
			new MenuPrincipal();
	
		}
	}
	
	
}
