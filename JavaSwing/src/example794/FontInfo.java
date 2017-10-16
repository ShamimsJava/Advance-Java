package example794;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

public class FontInfo {
    public static void main(String[] args) {
        Toolkit theKit = Toolkit.getDefaultToolkit();
        
        System.out.println("Screen Resolution: "
                            + theKit.getScreenResolution()
                            + " dots per inch");
        
        Dimension screenDim = theKit.getScreenSize();
        
        System.out.println("Screen size: " + screenDim.width + " by " + screenDim.height + " pixels");
        
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        String[] fontNames = e.getAvailableFontFamilyNames();
        
        System.out.println("Font available on this platform: ");
        int count = 0;
        for(String fontName : fontNames){
            System.out.printf("%-30s", fontName);
            if(++count % 4 == 0){
                System.out.println();
            }
        }
        return;
    }
}
