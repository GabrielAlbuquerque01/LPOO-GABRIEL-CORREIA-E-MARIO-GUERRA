package saves;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import jogando.TelaJogo;
import menu.Jogador;

public class AbreSave {

	
	private Jogador jogador;
	private int difJogo;
	private int modoJogo;
	private Character[] listaChar;
	
	public AbreSave(Jogador jogador){
		this.jogador = jogador;
		ProcuraDados();
		TelaJogo jogando = new TelaJogo(this.difJogo + 1, this.modoJogo,this.jogador, true, this.listaChar);
		jogando.jogando();
	}
	
	public void ProcuraDados(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("./src/JogosSalvos/JogoSalvo.txt"));
			String linhaAtual = reader.readLine();
			while(linhaAtual != null) {
				String[] dadosJogador = linhaAtual.split(",");
				this.jogador.setNome(dadosJogador[0]);
				this.difJogo = Integer.parseInt(dadosJogador[1]);
				this.modoJogo = Integer.parseInt(dadosJogador[2]);
				this.listaChar = new Character[(this.difJogo + 1) * (this.difJogo + 1)];
				int cont = 0;
				
				if(this.modoJogo == 2) {
				
					for(int i = 3; i < dadosJogador.length; i++) {
						listaChar[cont] = dadosJogador[i].charAt(0);
						cont++;
					}
				}

				linhaAtual = reader.readLine();
			}
			reader.close();
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}
	}
}
