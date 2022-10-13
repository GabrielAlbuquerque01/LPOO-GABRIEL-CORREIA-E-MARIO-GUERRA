package menu;

import static menu.ConstantesGraficas.corBotoes;
import static menu.ConstantesGraficas.corPlanoFundo;
import static menu.ConstantesGraficas.corTexto;
import static menu.ConstantesGraficas.fonteGeral;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fonte.Fonte;

public class AlterarModo extends JFrame implements ActionListener{
	
	private JLabel descricao = new JLabel("Escolha o modo de jogo!");
	private JButton numero = new JButton("Número");
	private JButton caractere = new JButton("Caractere");
	private JButton path = new JButton("Path");
	private JButton maluco1 = new JButton("maluquinho");
	private JButton maluco2 = new JButton("insano");
	private JButton maluco3 = new JButton("hospício");
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
		
		try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("backgrounds/background.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		add(descricao);
		descricao.setBounds(130,30,400,100);
		descricao.setFont(fonteGeral);
		descricao.setForeground(corTexto);
		
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
		
		add(maluco1);
		maluco1.setBounds(160,300,250,50);
		maluco1.setFont(fonteGeral);
		maluco1.setForeground(corTexto);
		maluco1.setBackground(corBotoes);
		
		add(maluco2);
		maluco2.setBounds(160,350,250,50);
		maluco2.setFont(fonteGeral);
		maluco2.setForeground(corTexto);
		maluco2.setBackground(corBotoes);
		
		add(maluco3);
		maluco3.setBounds(160,400,250,50);
		maluco3.setFont(fonteGeral);
		maluco3.setForeground(corTexto);
		maluco3.setBackground(corBotoes);
		
		add(voltar);
		voltar.setBounds(160,480,250,50);
		voltar.setFont(fonteGeral);
		voltar.setForeground(corTexto);
		voltar.setBackground(corBotoes);
		
		
		numero.addActionListener(this);
		caractere.addActionListener(this);
		path.addActionListener(this);
		maluco1.addActionListener(this);
		maluco2.addActionListener(this);
		maluco3.addActionListener(this);
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
		else if (e.getSource()==maluco1) {
			this.menu.setMaluco(true);
			this.menu.setModo(4);
			menu.setVisible(true);
			menu.mostrarModo();
			this.dispose();
		}
		else if (e.getSource()==maluco2) {
			this.menu.setMaluco(true);
			this.menu.setModo(5);
			menu.setVisible(true);
			menu.mostrarModo();
			this.dispose();
		}	
		else if (e.getSource()==maluco3) {
			this.menu.setMaluco(true);
			this.menu.setModo(6);
			menu.setVisible(true);
			menu.mostrarModo();
			this.dispose();
		}
		else if (e.getSource()==voltar) {
			this.dispose();
			new MenuPrincipal(menu.getJogador());
		}
	}

	
}
