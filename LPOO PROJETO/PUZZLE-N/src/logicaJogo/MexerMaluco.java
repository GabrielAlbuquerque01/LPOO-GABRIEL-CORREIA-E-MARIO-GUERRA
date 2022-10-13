package logicaJogo;

import java.util.Random;

public class MexerMaluco extends MexerPeca {

	private int tipoMaluco;//1 - maluquinho, 2 - insano, 3 - hosipicio
	
	public MexerMaluco(int matriz,int tipo) {
		super(matriz);
		this.tipoMaluco = tipo;
	}
	
public void trocaLugar() { //método para trocar peças de lugar. Lógica tá certa, se colocar em MexerPeca pega, mas falta implementar)
		
		Random rand = new Random();
		int prob = rand.nextInt(10);
		int l1 = rand.nextInt(getMatriz());
		int c1 = rand.nextInt(getMatriz());
		int l2 = rand.nextInt(getMatriz());
		int c2 = rand.nextInt(getMatriz());
		
		if(getMatrizPecas() != null) {
			if((this.tipoMaluco == 1 && prob > 8) || (this.tipoMaluco == 2 && prob >5) || (this.tipoMaluco == 3 && prob >3)) {
				if((getMatrizPecas()[l1][c1] != "  ") && (getMatrizPecas()[l2][c2] != "  ")) {
					String aux = getMatrizPecas()[l1][c1];
					getMatrizPecas()[l1][c1] = getMatrizPecas()[l2][c2];
					getMatrizPecas()[l2][c2] = aux;
					super.setTabuleiro(getMatrizPecas());
				}
			}
		}
}
}
