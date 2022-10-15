package jogando;

public class Cronometro extends Thread{

	private int segundos;
	private int minutos;
	private String relogio;
	private TelaJogo telaJogo;
	
	public Cronometro(TelaJogo telaJogo) {
		this.telaJogo = telaJogo;
	}
	
	
	public void run() {
		this.segundos = 0;
		this.minutos = 0;
		
		while(true) {
			try {
				Thread.sleep(1000);
			}
			catch (Exception e) {
			}
			this.segundos++;
			telaJogo.setTempoJogador(this.segundos);
			this.relogio = this.segundos+" s";
			
			telaJogo.setMostrarTempo(this.relogio);
		}
	}
}
