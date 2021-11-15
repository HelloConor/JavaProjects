import java.awt.*;
public class ListFontsTest {

	public static void main(String[] args) {
		// this lists out what fonts you have avaliable to use
		String[] fontNames = GraphicsEnvironment
				.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();
			for (String fontName : fontNames)
				System.out.println(fontName);

	}

}
