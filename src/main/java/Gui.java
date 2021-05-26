import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui extends JFrame {
    private final Parser parser;
    private final JTextArea content;

    public Gui() {
        super("Монитор эпидемиологической обстановки в регионах России");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel contents = new JPanel();
        JPanel dop = new JPanel();
        dop.setLayout(new FlowLayout());
        parser = new Parser();
        String[] listStr = parser.splitter(parser.toString());
        final JList<String> list = new JList<>(listStr);
        list.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        JTextField search = new JTextField(null, 20);
        JLabel label = new JLabel("Поиск:");
        JButton button = new JButton("Найти");
        content = new JTextArea(20, 25);
        content.setLineWrap(true);
        content.setEditable(false);
        content.setWrapStyleWord(true);
        list.addListSelectionListener(new Listener());
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1) {
                    int selected = list.locationToIndex(e.getPoint());
                    String txt;
                    txt = parser.info(listStr[selected]);
                    content.setText(txt);
                }
            }
        });
        dop.add(label);
        dop.add(search);
        contents.setLayout(new BorderLayout());
        contents.add(new JScrollPane(list), BorderLayout.WEST);
        contents.add(new JScrollPane(content), BorderLayout.CENTER);
        contents.add(dop, BorderLayout.NORTH);
        setLayout(new BoxLayout(contents, BoxLayout.X_AXIS));
        setContentPane(contents);
        setSize(550, 400);
        setResizable(false);
        setVisible(true);
    }
}
