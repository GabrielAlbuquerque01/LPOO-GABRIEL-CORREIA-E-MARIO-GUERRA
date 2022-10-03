package logicaJogo;

public class TabPath implements Tabuleiro{
	
	private int matriz;
	
	public TabPath(int matriz){
		setMatriz(matriz);
	}
	
	public void setMatriz(int matriz) {
		this.matriz = matriz;
	}
	
	@Override
	public void preencheArray() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void embaralhaArray() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] getListaCorreta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getVazio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void preencheMatriz() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[][] getMatrizCorreta() {
		// TODO Auto-generated method stub
		return null;
	}

}
