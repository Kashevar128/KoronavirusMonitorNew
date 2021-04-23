import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui extends JFrame {
    private final Parser parser;
    private final JTextArea content;

    public Gui() {
        super("Монитор эпидемиологической обстановки в регионах России");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel contents = new JPanel();
        parser = new Parser();
        String[] listStr = parser.splitter(parser.toString());
        final JList<String> list = new JList<>(listStr);
        list.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        list.setPrototypeCellValue("Республика Северная Осетия-Алания");
        list.setVisibleRowCount(18);
        content = new JTextArea(20, 25);
        content.setLineWrap(true);
        content.setWrapStyleWord(true);
        list.addListSelectionListener(new Listener());
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int selected = list.locationToIndex(e.getPoint());
                    String txt;
                    txt = parser.info(listStr[selected]);
                    content.setText(txt);
                }
            }
        });

        contents.add(new JLabel("Список регионов"));
        contents.add(new JScrollPane(list));
        contents.add(new JLabel("Статистика"));
        contents.add(new JScrollPane(content));
        setContentPane(contents);
        setSize(760, 400);
        setResizable(false);
        setVisible(true);
    }
}
