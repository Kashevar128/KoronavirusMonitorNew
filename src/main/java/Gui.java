import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;

public class Gui extends JFrame {
    private Parser parser;
    private JTextArea content;

    public Gui() {
        super("Монитор эпидемиологической обстановки в регионах России");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel contents = new JPanel();
        parser = new Parser();
        Set<String> keys = parser.map.keySet();
    }
}
