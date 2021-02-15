package Views.UI;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements IPanel {

    public MainPanel(){
        setBackground(Color.red);
        setSize(900, 900);
    }

    @Override
    public void Activate(){ this.setVisible(true);}

    @Override
    public void Deactivate(){ this.setVisible(false);}

}
