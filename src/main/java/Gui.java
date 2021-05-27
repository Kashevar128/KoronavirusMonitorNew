import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
        JList<String> list = new JList<>(listStr);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 1) {
                    int selected = list.locationToIndex(mouseEvent.getPoint());
                    String txt;
                    txt = parser.info(listStr[selected]);
                    content.setText(txt);
                }
            }
        });
        list.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                ArrayList<Integer> countMemory = new ArrayList<>();
                String message = search.getText();
                if(message != null) {
                    for(String s: listStr) {
                        Integer count = 0;
                        if(message.length() <= s.length()) {
                            for (int i = 0; i < message.length(); i++) {
                                if(message.charAt(i) == s.charAt(i)) {
                                    count++;
                                } else break;
                            }
                        } else {
                            for (int i = 0; i < s.length(); i++) {
                                if(message.charAt(i) == s.charAt(i)) {
                                    count++;
                                } else break;
                            }
                        }
                        countMemory.add(count);
                    }

                    int max = 0;
                    for (int a : countMemory) {
                        max = Math.max(max, a);
                    }

                    if(max != 0) {
                        DefaultListModel model = (DefaultListModel) list.getModel();
                        for (int i = 0; i < model.size(); i++) {
                            if(countMemory.get(i) != max) {
                                model.remove(i);
                            }
                        }
                    }
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
