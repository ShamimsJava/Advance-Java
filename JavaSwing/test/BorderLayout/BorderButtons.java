package BorderLayout;

import java.applet.*;    
import java.awt.*;

public class BorderButtons extends Applet {

  @Override
  public void init() {
  
    this.setLayout(new BorderLayout(20, 10));

    this.add(new Button("North"),  BorderLayout.NORTH);
    this.add(new Button("South"),  BorderLayout.SOUTH);
    this.add(new Button("Center"), BorderLayout.CENTER);
    this.add(new Button("East"),   BorderLayout.EAST);
    this.add(new Button("West"),   BorderLayout.WEST);
    
  }

}