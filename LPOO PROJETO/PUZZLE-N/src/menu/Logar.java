package menu;

import static menu.ConstantesGraficas.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import fonte.Fonte;

public class Logar extends JFrame implements ActionListener{
	
	private JLabel texto = new JLabel("Bem-vindo ao Puzzle-N! DIGITE SEU NOME!");
	private JTextField inserirNome = new JTextField();
	public JButton confirmar = new JButton("confirmar");
	private String nome;
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont();
	
	
	public Logar() {
		
		setTitle("Logar");
		setSize(600,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(corPlanoFundo);
		
		try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("backgrounds/background.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		add(texto);
		texto.setBounds(32,30,600,40);
		texto.setFont(fonteGeral);
		texto.setForeground(corTexto);
		texto.setVisible(true);
		
		add(inserirNome);
		inserirNome.setBounds(220,150,150,30);
		inserirNome.setToolTipText("Insira seu nome. Máximo de 10 caracteres.");
		
		
		add(confirmar);
		confirmar.setBounds(195,250,200,40);
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
