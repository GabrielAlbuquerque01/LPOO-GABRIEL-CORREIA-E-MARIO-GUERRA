package menu;

import static menu.ConstantesGraficas.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Logar extends JFrame implements ActionListener{
	
	private JLabel texto = new JLabel("Bem-vindo ao Puzzle-N! Como deveremos lhe chamar?");
	private JTextField inserirNome = new JTextField();
	public JButton confirmar = new JButton("confirmar");
	private String nome;
	
	
	public Logar() {
		
		setTitle("Logar");
		setSize(600,300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(corPlanoFundo);
		
		add(texto);
		texto.setBounds(32,30,600,40);
		texto.setFont(fonteGeral);
		texto.setForeground(corTexto);
		texto.setVisible(true);
		
		add(inserirNome);
		inserirNome.setBounds(225,100,150,30);
		inserirNome.setToolTipText("Insira seu nome. Máximo de 10 caracteres.");
		
		
		add(confirmar);
		confirmar.setBounds(225,200,150,40);
		confirmar.setFont(fonteGeral);
		confirmar.setForeground(corTexto);
		confirmar.setBackground(corBotoes);
			
		confirmar.addActionListener(this);
		
		
	}
	
	public static void main (String[]args) {
		new Logar();
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==confirmar) {
			
			this.nome = inserirNome.getText();	
			
			if((this.nome.equals("")) || nome.length()>10) {
				inserirNome.setText("nome inválido!");
			}
			
			else {
				this.nome = inserirNome.getText();
				new MenuPrincipal(this.nome);
				this.dispose();
			}
		}
		
		
		
		
	}
	
	

}
