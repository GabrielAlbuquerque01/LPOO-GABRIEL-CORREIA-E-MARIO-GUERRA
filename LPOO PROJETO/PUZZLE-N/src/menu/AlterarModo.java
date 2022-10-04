package menu;

import static menu.ConstantesGraficas.corBotoes;
import static menu.ConstantesGraficas.corPlanoFundo;
import static menu.ConstantesGraficas.corTexto;
import static menu.ConstantesGraficas.fonteGeral;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import fonte.Fonte;

public class AlterarModo extends JFrame implements ActionListener{
	
	private JButton numero = new JButton("Numero");
	private JButton caractere = new JButton("Caractere");
	private JButton path = new JButton("Path");
	private JButton maluco = new JButton("Maluco");
	private JButton voltar = new JButton("Voltar");
	private MenuPrincipal menu;
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont();
	
	public AlterarModo(MenuPrincipal menu) {
		
		this.menu = menu;
		
		setTitle("Alterar modo");
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(corPlanoFundo);
		
		add(numero);
		numero.setBounds(160,150,250,50);
		numero.setFont(fonteGeral);
		numero.setForeground(corTexto);
		numero.setBackground(corBotoes);
		
		add(caractere);
		caractere.setBounds(160,200,250,50);
		caractere.setFont(fonteGeral);
		caractere.setForeground(corTexto);
		caractere.setBackground(corBotoes);
		
		add(path);
		path.setBounds(160,250,250,50);
		path.setFont(fonteGeral);
		path.setForeground(corTexto);
		path.setBackground(corBotoes);
		
		add(maluco);
		maluco.setBounds(160,300,250,50);
		maluco.setFont(fonteGeral);
		maluco.setForeground(corTexto);
		maluco.setBackground(corBotoes);
		
		add(voltar);
		voltar.setBounds(160,350,250,50);
		voltar.setFont(fonteGeral);
		voltar.setForeground(corTexto);
		voltar.setBackground(corBotoes);
		
		
		numero.addActionListener(this);
		caractere.addActionListener(this);
		path.addActionListener(this);
		maluco.addActionListener(this);
		voltar.addActionListener(this);
			
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==numero) {
			this.menu.setModo(1);
			menu.setVisible(true);
			menu.mostrarModo();
			this.dispose();
		}
		else if (e.getSource()==caractere) {
			this.menu.setModo(2);
			menu.setVisible(true);
			menu.mostrarModo();
			this.dispose();
		}
		else if (e.getSource()==path) {
			this.menu.setModo(3);
			menu.setVisible(true);
			menu.mostrarModo();
			this.dispose();
		}
		else if (e.getSource()==maluco) {
			this.menu.setModo(4);
			menu.setVisible(true);
			menu.mostrarModo();
			this.dispose();
		}
		else if (e.getSource()==voltar) {
			this.dispose();
			new MenuPrincipal();
		}
	}

	
}
