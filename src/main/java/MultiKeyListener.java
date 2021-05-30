
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MultiKeyListener implements KeyListener {

    private final Gui gui;

    MultiKeyListener(Gui gui) {
        this.gui = gui;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            gui.UpdateSearch(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            gui.UpdateSearch(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
