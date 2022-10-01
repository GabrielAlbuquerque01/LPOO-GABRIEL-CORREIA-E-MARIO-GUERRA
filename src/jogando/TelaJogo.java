package jogando;

import static menu.ConstantesGraficas.corBotoes;
import static menu.ConstantesGraficas.corTexto;
import static menu.ConstantesGraficas.fonteGeral;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import menu.MenuPrincipal;
import logicaJogo.MexerChar;
import logicaJogo.MexerPeca;

public class TelaJogo extends JFrame implements ActionListener{
	
	private JButton botaoAjuda;
	private JButton voltar;
	private int tamanhoMatriz;
	private int modoDeJogo;
	
	public TelaJogo(int tamanhoMatriz, int modoDeJogo) {
		
		this.modoDeJogo = modoDeJogo;
		this.tamanhoMatriz = tamanhoMatriz;
		this.botaoAjuda = new JButton("Ajuda");
		this.voltar = new JButton("Voltar para o menu");
		
	}
	
	public void jogando(){
		
		if (modoDeJogo == 1) {
		
	  	MexerPeca tabuleiro = new MexerPeca(this.tamanhoMatriz);
	  
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("PUZZLE-N");
	    setResizable(false);
	    add(new GerarTabuleiro(tabuleiro.getMatriz(), 600, 80, tabuleiro), BorderLayout.CENTER);
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	    add(botaoAjuda, BorderLayout.NORTH);
		botaoAjuda.setFont(fonteGeral);
		botaoAjuda.setForeground(corTexto);
		botaoAjuda.setBackground(corBotoes);
		
		add(voltar, BorderLayout.SOUTH);
		voltar.setFont(fonteGeral);
		voltar.setForeground(corTexto);
		voltar.setBackground(corBotoes);
	    
	    botaoAjuda.addActionListener(this);
		voltar.addActionListener(this);
		}
		
		else if (modoDeJogo == 2) {
			
			MexerChar tabuleiro = new MexerChar(this.tamanhoMatriz);
			  
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("PUZZLE-N");
		    setResizable(false);
		    add(new GerarChar(tabuleiro.getMatriz(), 600, 80, tabuleiro), BorderLayout.CENTER);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		    
		    add(botaoAjuda, BorderLayout.NORTH);
			botaoAjuda.setFont(fonteGeral);
			botaoAjuda.setForeground(corTexto);
			botaoAjuda.setBackground(corBotoes);
			
			add(voltar, BorderLayout.SOUTH);
			voltar.setFont(fonteGeral);
			voltar.setForeground(corTexto);
			voltar.setBackground(corBotoes);
		    
		    botaoAjuda.addActionListener(this);
			voltar.addActionListener(this);
			
		}
		
		
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == botaoAjuda) {
			
		}
		
		else if(e.getSource() == voltar) {
			this.dispose();
			new MenuPrincipal();
			
		}
	}
	
}
