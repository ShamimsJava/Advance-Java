package page794;

import java.awt.*;

public class FontInfo {

    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        System.out.println("\nScreen Resolution: " + toolkit.getScreenResolution() + " dots per inch.");
        Dimension dimension = toolkit.getScreenSize();
        System.out.println("Screen Size: " + dimension.width + " by " + dimension.height + " pixels");
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontnames = graphicsEnvironment.getAvailableFontFamilyNames();
        System.out.println("\nFonts available on this platform: ");
        int count = 0;
        for (String fontname : fontnames) {
            System.out.printf("%-30s", fontname);
            if (++count % 4 == 0) {
                System.out.println();
            }
        }
    }
}

/*
Toolkit.getDefaultToolkit()
getScreenResolution()
GraphicsEnvironment
getLocalGraphicsEnvironment()
getAvailableFontFamilyNames()
*/
