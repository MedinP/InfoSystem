import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class FinalApp extends JFrame {
    JPanel panel = new JPanel();
    JButton enter = new JButton();
    JButton change = new JButton();
    JButton delete = new JButton();
    JButton show_all = new JButton();
    JButton show_wor = new JButton();



    JLabel lb1 = new JLabel("ENTER WORKER");
    JLabel lb2 = new JLabel("CHANGE WORKER");
    JLabel lb3 = new JLabel("DELETE WORKER");
    JLabel lb4 = new JLabel("SHOW ALL WORKERS");
    JLabel lb5 = new JLabel("SHOW WORKER");


    public FinalApp() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("enter.png")));
            enter.setIcon(new ImageIcon(img));
        }catch (IOException ex){
            System.out.println(ex);
        }

        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("change.png")));
            change.setIcon(new ImageIcon(img));
        }catch (IOException ex){
            System.out.println(ex);
        }

        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("sea.png")));
            show_all.setIcon(new ImageIcon(img));
        }catch (IOException ex){
            System.out.println(ex);
        }

        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("delete.png")));
            delete.setIcon(new ImageIcon(img));
        }catch (IOException ex){
            System.out.println(ex);
        }

        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("all1.png")));
            show_wor.setIcon(new ImageIcon(img));
        }catch (IOException ex){
            System.out.println(ex);
        }



        URL image = getClass().getResource("icon.png");
        assert image != null;
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());




        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome to Hibernate Info-System");

        setSize(600,400);
        setLocationRelativeTo(null);
        addComponents();
        addEvents();
        setVisible(true);
    }



    private void addEvents() {
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnterWorker();

            }
        });
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChangeWorker();

            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new DeleteWorker();
            }
        });
        show_all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ShowAllWorkers();
            }
        });
        show_wor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ShowWorker();
            }
        });
    }

    private void addComponents() {
        SpringLayout sl = new SpringLayout();
        setLayout(sl);

        lb1.setForeground(Color.ORANGE);
        lb2.setForeground(Color.ORANGE);
        lb3.setForeground(Color.ORANGE);
        lb4.setForeground(Color.ORANGE);
        lb5.setForeground(Color.ORANGE);


        panel.setBackground(Color.GRAY);

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Welcome to Info-System database for workers!",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.ORANGE));

        enter.setPreferredSize(new Dimension(150,130));
        sl.putConstraint(SpringLayout.WEST, enter,0,SpringLayout.WEST,panel);
        sl.putConstraint(SpringLayout.NORTH, enter,0,SpringLayout.NORTH,panel);
        sl.putConstraint(SpringLayout.WEST, lb1,30,SpringLayout.WEST,panel);
        sl.putConstraint(SpringLayout.NORTH, lb1,140,SpringLayout.NORTH,panel);
        enter.setBackground(Color.ORANGE);
        enter.setForeground(Color.GRAY);
        enter.setFont(enter.getFont().deriveFont(Font.BOLD, 13f));
        panel.add(enter);
        panel.add(lb1);

        change.setPreferredSize(new Dimension(150,130));
        sl.putConstraint(SpringLayout.EAST, change,0,SpringLayout.EAST,panel);
        sl.putConstraint(SpringLayout.NORTH, change,0,SpringLayout.NORTH,panel);
        sl.putConstraint(SpringLayout.EAST, lb2,-30,SpringLayout.EAST,panel);
        sl.putConstraint(SpringLayout.NORTH, lb2,140,SpringLayout.NORTH,panel);
        change.setForeground(Color.GRAY);
        change.setBackground(Color.ORANGE);
        change.setFont(change.getFont().deriveFont(Font.BOLD, 13f));
        panel.add(change);
        panel.add(lb2);



        delete.setPreferredSize(new Dimension(150,130));
        sl.putConstraint(SpringLayout.WEST, delete,0,SpringLayout.WEST,panel);
        sl.putConstraint(SpringLayout.NORTH, delete,180,SpringLayout.NORTH,panel);
        sl.putConstraint(SpringLayout.WEST, lb3,30,SpringLayout.WEST,panel);
        sl.putConstraint(SpringLayout.NORTH, lb3,315,SpringLayout.NORTH,panel);
        delete.setBackground(Color.ORANGE);
        delete.setForeground(Color.GRAY);
        delete.setFont(delete.getFont().deriveFont(Font.BOLD, 13f));
        panel.add(delete);
        panel.add(lb3);

        show_all.setPreferredSize(new Dimension(150,130));
        sl.putConstraint(SpringLayout.EAST, show_all,0,SpringLayout.EAST,panel);
        sl.putConstraint(SpringLayout.NORTH, show_all,180,SpringLayout.NORTH,panel);
        sl.putConstraint(SpringLayout.EAST, lb4,-15,SpringLayout.EAST,panel);
        sl.putConstraint(SpringLayout.NORTH, lb4,315,SpringLayout.NORTH,panel);
        show_all.setForeground(Color.GRAY);
        show_all.setBackground(Color.ORANGE);
        show_all.setFont(show_all.getFont().deriveFont(Font.BOLD, 13f));
        panel.add(show_all);
        panel.add(lb4);

        show_wor.setPreferredSize(new Dimension(150,130));
        sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, show_wor,0,SpringLayout.HORIZONTAL_CENTER,panel);
        sl.putConstraint(SpringLayout.VERTICAL_CENTER, show_wor,-23,SpringLayout.VERTICAL_CENTER,panel);
        sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, lb5,0,SpringLayout.HORIZONTAL_CENTER,panel);
        sl.putConstraint(SpringLayout.VERTICAL_CENTER, lb5,55,SpringLayout.VERTICAL_CENTER,panel);
        show_wor.setBackground(Color.ORANGE);
        show_wor.setForeground(Color.GRAY);
        show_wor.setFont(show_wor.getFont().deriveFont(Font.BOLD, 13f));
        panel.add(show_wor);
        panel.add(lb5);
    }
}
