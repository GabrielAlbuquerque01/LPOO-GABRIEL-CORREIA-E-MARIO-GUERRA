package logicaJogo;

public interface Tabuleiro {
	
	public void preencheArray();
	
	public void embaralhaArray();

	public Object[] getListaCorreta();
	
	public int getVazio();
	
	public void preencheMatriz();
	
	public Object[][] getMatrizCorreta();
	
}
