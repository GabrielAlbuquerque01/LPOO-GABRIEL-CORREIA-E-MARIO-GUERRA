package fonte;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

public class Fonte {
	
	private Font font;
	
	public Font getFont() {
		if (font == null) {
			try {
				InputStream arquivoTTF = getClass().getResourceAsStream("Skygraze.otf");
				font = Font.createFont(Font.TRUETYPE_FONT, arquivoTTF).deriveFont(22f);
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(font);
			} catch(Exception e) {
				e.printStackTrace();
				System.err.println("fonte não carregada. Usando fonte serif.");
				font = new Font("serif", Font.PLAIN, 24);
			}
		}
		return font;
	}
	
}