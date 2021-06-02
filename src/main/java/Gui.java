import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Gui extends JFrame {
    private final Parser parser = new Parser();
    private final String[] fullStrList;
    private final DefaultListModel<String> defaultListModel;
    private final JList<String> mainList;
    private HashMap<Integer, ArrayList<String>> countMemory;
    private final StringBuilder message = new StringBuilder();
    private final JTextField search;

    public Gui() {
        super("Монитор эпидемиологической обстановки в регионах России");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel contents = new JPanel();
        JPanel dop = new JPanel();
        dop.setLayout(new FlowLayout());

        fullStrList = parser.splitter(parser.toString());
        defaultListModel = creatingModel(fullStrList);
        mainList = new JList<>(defaultListModel);
        mainList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        search = new JTextField(20);
        JTextArea content = new JTextArea(20, 25);
        JLabel label = new JLabel("Поиск:");
        content.setLineWrap(true);
        content.setEditable(false);
        content.setWrapStyleWord(true);
        mainList.setPrototypeCellValue("000000000000000000000000000000000000");
        mainList.addListSelectionListener(new Listener());

        mainList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 1) {
                    int selected = mainList.locationToIndex(mouseEvent.getPoint());
                    String txt;
                    txt = parser.info(fullStrList[selected]);
                    content.setText(txt);
                }
            }
        });

        search.addKeyListener(new MultiKeyListener(this));

        dop.add(label);
        dop.add(search);
        contents.setLayout(new BorderLayout());
        contents.add(new JScrollPane(mainList), BorderLayout.WEST);
        contents.add(new JScrollPane(content), BorderLayout.CENTER);
        contents.add(dop, BorderLayout.NORTH);
        setLayout(new BoxLayout(contents, BoxLayout.X_AXIS));
        setContentPane(contents);
        setSize(550, 400);
        setResizable(false);
        setVisible(true);

    }

    public void UpdateSearch(KeyEvent event) {
        countMemory = new HashMap<>();
        if ((event.getKeyChar() != '\b' && event.getKeyChar() >= 1040 && event.getKeyChar() <= 1103) || event.getKeyChar() == 45) {
            message.append(event.getKeyChar());
            System.out.println(message);
        }

        int c = event.getKeyChar();
        System.out.println(c);

        if (event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            try {
                message.setLength(0);
                search.setText("");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Все ок, работай дальше");
            }
        }

        for (String str : fullStrList) {
            int count = 0;
            if (message.length() <= str.length()) {
                for (int i = 0; i < message.length(); i++) {
                    String char1 = String.valueOf(message.charAt(i));
                    String char2 = String.valueOf(str.charAt(i));
                    if (char1.equalsIgnoreCase(char2)) {
                        count++;
                    } else break;
                }


            } else {
                for (int i = 0; i < str.length(); i++) {
                    String char1 = String.valueOf(message.charAt(i));
                    String char2 = String.valueOf(str.charAt(i));
                    if (char1.equalsIgnoreCase(char2)) {
                        count++;
                    } else break;
                }
            }
            addMap(countMemory, count, str);
        }

        int max = 0;
        Set<Integer> keys = countMemory.keySet();
        for (int a : keys) {
            max = Math.max(max, a);
        }

        defaultListModel.removeAllElements();
        for (int a : keys) {
            if (a == max) {
                addModel(countMemory.get(a), defaultListModel);
            }
        }
        validate();
    }

    private DefaultListModel<String> creatingModel(String[] strings) {
        DefaultListModel<String> dlm = new DefaultListModel<>();
        for (int i = 0; i < strings.length; i++) {
            dlm.add(i, strings[i]);
        }
        return dlm;
    }

    public void addMap(HashMap<Integer, ArrayList<String>> container, int key, String value) {
        ArrayList<String> values = container.get(key);
        if (values == null) {
            values = new ArrayList<>();
        }
        values.add(value);
        container.put(key, values);
    }

    public void addModel(ArrayList<String> arrayList, DefaultListModel<String> dlm) {
        for (String str : arrayList) {
            dlm.addElement(str);
        }
    }


}
