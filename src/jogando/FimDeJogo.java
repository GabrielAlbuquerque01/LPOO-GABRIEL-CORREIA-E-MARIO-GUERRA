package jogando;

import static menu.ConstantesGraficas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import menu.MenuPrincipal;

public class FimDeJogo extends JFrame implements ActionListener{

	private JLabel mensagem = new JLabel("Fim de jogo");
	private JButton voltar = new JButton("voltar para o menu");
	private JButton sair = new JButton("Sair");
	
	public FimDeJogo() {
	
	setSize(300,300);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);
	setLayout(null);
	getContentPane().setBackground(corPlanoFundo);
	
	add(mensagem);
	mensagem.setText("Game Over!");
	mensagem.setBounds(90,50,200,50);
	mensagem.setFont(fonteGeral);
	mensagem.setBackground(corPlanoFundo);
	mensagem.setForeground(corTexto);
	
	add(voltar);
	voltar.setBounds(17,150,250,30);
	voltar.setFont(fonteGeral);
	voltar.setBackground(corBotoes);
	voltar.setForeground(corTexto);
	
	add(sair);
	sair.setBounds(47,200,200,30);
	sair.setFont(fonteGeral);
	sair.setBackground(corBotoes);
	sair.setForeground(corTexto);
	
	voltar.addActionListener(this);
	sair.addActionListener(this);
	
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==voltar) {
			this.dispose();
			new MenuPrincipal();
		}
		else if(e.getSource()==sair) {
			System.exit(0);
		}
		
	}
	
}
