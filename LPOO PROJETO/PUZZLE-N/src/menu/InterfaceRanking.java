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

public class InterfaceRanking extends JFrame implements ActionListener{
	
	private JLabel descricao = new JLabel("RANKING DE JOGADORES");
	private JButton voltar = new JButton("Voltar");
	private JButton dif1 = new JButton("Fácil");
	private JButton dif2 = new JButton("Médio");
	private JButton dif3 = new JButton("Difícil");
	private int difRanking;
	private MenuPrincipal menu;
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont();
	
	public InterfaceRanking(MenuPrincipal menu) {
		
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
		
		add(dif1);
		dif1.setBounds(160,200,250,50);
		dif1.setFont(fonteGeral);
		dif1.setForeground(corTexto);
		dif1.setBackground(corBotoes);
		
		add(dif2);
		dif2.setBounds(160,250,250,50);
		dif2.setFont(fonteGeral);
		dif2.setForeground(corTexto);
		dif2.setBackground(corBotoes);
		
		add(dif3);
		dif3.setBounds(160,300,250,50);
		dif3.setFont(fonteGeral);
		dif3.setForeground(corTexto);
		dif3.setBackground(corBotoes);
		
		
		add(voltar);
		voltar.setBounds(160,450,250,50);
		voltar.setFont(fonteGeral);
		voltar.setForeground(corTexto);
		voltar.setBackground(corBotoes);
		
		dif1.addActionListener(this);
		dif2.addActionListener(this);
		dif3.addActionListener(this);
		voltar.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==dif1) {
                this.difRanking = 1;
                this.dispose();
                new TabelaRanking(this.menu,this.difRanking);
		}
		else if(e.getSource()==dif2) {
			this.difRanking = 2;
			this.dispose();
            new TabelaRanking(this.menu,this.difRanking);
		}
		
		else if(e.getSource()==dif3) {
			this.difRanking = 3;
			this.dispose();
            new TabelaRanking(this.menu,this.difRanking);
			
		}
	
		else if(e.getSource()==voltar) {
			this.dispose();
			new MenuPrincipal(menu.getJogador());
		}
	}
}
		
		