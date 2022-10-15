package jogando.acoes;

import static menu.ConstantesGraficas.corPlanoFundo;

import javax.swing.JFrame;
import javax.swing.JPanel;

import menu.Jogador;

public class SalvaJogo {
	
	private Jogador jogador;
	private int difJogo;
	private int modoJogo;
	
	public SalvaJogo(Jogador jogador, int dif, int modo) {
		this.jogador = jogador;
		this.difJogo = dif;
		this.modoJogo = modo;
	}
}

