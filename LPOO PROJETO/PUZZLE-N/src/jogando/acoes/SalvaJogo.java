package jogando.acoes;

import static menu.ConstantesGraficas.corPlanoFundo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import menu.Jogador;

public class SalvaJogo {
	
	private Jogador jogador;
	private int difJogo;
	private int modoJogo;
	private Object[] listaPecas;
	
	public SalvaJogo(Jogador jogador, int dif, int modo, Object[] listaPecas) {
		this.jogador = jogador;
		this.difJogo = dif;
		this.modoJogo = modo;
		this.listaPecas = listaPecas;
		
		BufferedWriter writer = null;
	    File diretorio = new File("./src/JogosSalvos");
	    if (!diretorio.isDirectory()) {
	            diretorio.mkdirs();
	        }
	    try {
	         writer = new BufferedWriter(new FileWriter("./src/JogosSalvos/JogoSalvo.txt", false));
	         writer.write(this.jogador.getNome() + "," + this.difJogo + "," + this.modoJogo);
	         for(int i = 0; i < this.listaPecas.length;i++) {
	        	 writer.write("," +this.listaPecas[i]);
	         }
	         writer.close();
	     } catch (IOException e) {
	     }
	}
}

