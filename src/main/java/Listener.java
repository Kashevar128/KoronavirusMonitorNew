import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Listener implements ListSelectionListener {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selected = ((JList<?>) e.getSource()).
                getSelectedIndex();
        System.out.println("Выделенная строка : " + selected);
    }
}
