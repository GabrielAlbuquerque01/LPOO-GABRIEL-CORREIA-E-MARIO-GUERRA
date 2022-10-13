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

import fonte.Fonte;
import jogando.TelaJogo;

public class Ranking extends JFrame implements ActionListener{
	
	private JLabel descricao = new JLabel("RANKING DE JOGADORES");
	private JButton voltar = new JButton("Voltar");
	private MenuPrincipal menu;
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont();
	
	public Ranking(MenuPrincipal menu) {
		
		this.menu = menu;
		
		setTitle("Menu principal");
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
		descricao.setBounds(140,80,400,100);
		descricao.setFont(fonteGeral);
		descricao.setForeground(corTexto);
		
		add(voltar);
		voltar.setBounds(160,350,250,50);
		voltar.setFont(fonteGeral);
		voltar.setForeground(corTexto);
		voltar.setBackground(corBotoes);
		
		voltar.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==voltar) {
			this.dispose();
			new MenuPrincipal(menu.getJogador());
		}
	}
}
		
		