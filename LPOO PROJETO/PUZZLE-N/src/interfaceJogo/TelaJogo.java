package interfaceJogo;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import interfaceJogo.GerarTabuleiro;
import jogo.MexerPeca;

public class TelaJogo {
	public static void main(String[] args) {  
	  	MexerPeca tabuleiro = new MexerPeca(3);
	    SwingUtilities.invokeLater(() -> {
	      JFrame frame = new JFrame();
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setTitle("PUZZLE-N");
	      frame.setResizable(false);
	      frame.add(new GerarTabuleiro(tabuleiro.getMatriz(), 600, 60, tabuleiro), BorderLayout.CENTER);
	      frame.pack();
	      // posição no centro da tela
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);
	    });
	  }
}
