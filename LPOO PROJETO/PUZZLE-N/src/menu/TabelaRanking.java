package menu;

import static menu.ConstantesGraficas.corBotoes;
import static menu.ConstantesGraficas.corPlanoFundo;
import static menu.ConstantesGraficas.corTexto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fonte.Fonte;
import jogando.acoes.Ranking;

public class TabelaRanking extends JFrame implements ActionListener{
	
	int difRanking;
	private MenuPrincipal menu;
	private JButton voltar = new JButton("Voltar");
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont();
	private Ranking ranking;
	
	public TabelaRanking(MenuPrincipal menu, int difRanking){
		
		this.menu = menu;
		this.difRanking = difRanking;
		
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
		
		this.ranking = new Ranking();
		this.ranking.ordenaRanking(this.difRanking);
		
		JPanel meio = new JPanel();
		this.ranking.showTable(meio, this.difRanking);
        meio.setLayout(new GridLayout(1,1));
        meio.setBackground(new Color(0, 0, 0));
        
        
        add(meio);
		
		add(voltar);
		voltar.setBounds(160,480,250,50);
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
