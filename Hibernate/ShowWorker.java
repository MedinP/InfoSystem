import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ShowWorker extends JFrame {
    JPanel panel = new JPanel();
    JButton showWorker = new JButton("SHOW WROKER (ID)");
    JButton backB = new JButton();
    JTextArea tf1 = new JTextArea();
    JTextField ta1 = new JTextField();
    JLabel lb1 = new JLabel("E N T E R  ID: ");
    int number;

    Session sess = HibernateUtil.createSessionFactory().openSession();
    Transaction ts = sess.beginTransaction();

    public ShowWorker() {

        try {
            Image img = ImageIO.read(getClass().getResource("back.png"));
            backB.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        URL image = getClass().getResource("icon.png");
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());

        setContentPane(panel);
        setSize(600, 340);
        setTitle("Welcome to Hibernate Info-System");
        setLocationRelativeTo(null);
        addComponents();
        addEvents();
        setVisible(true);
    }

    private void addEvents() {

        showWorker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Workers w =  new UserInterface().showbyID(sess,ts,Integer.parseInt(ta1.getText()));
                tf1.setText(String.valueOf(w));
            }
        });
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FinalApp();
            }
        });
    }

    private void addComponents(){
        SpringLayout sl = new SpringLayout();
        setLayout(sl);

        panel.setBackground(Color.GRAY);
        lb1.setForeground(Color.ORANGE);

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Show Workers", TitledBorder.CENTER,
                TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.ORANGE));


        tf1.setPreferredSize(new Dimension(540, 200));
        sl.putConstraint(SpringLayout.WEST, tf1, 10, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, tf1, 35, SpringLayout.NORTH, panel);
        tf1.setBackground(Color.ORANGE);
        tf1.setForeground(Color.GRAY);
        tf1.setFont(tf1.getFont().deriveFont(Font.BOLD, 14f));
        panel.add(tf1);


        showWorker.setPreferredSize(new Dimension(250, 40));
        sl.putConstraint(SpringLayout.WEST, showWorker, 300, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, showWorker, 250, SpringLayout.NORTH, panel);
        showWorker.setBackground(Color.ORANGE);
        showWorker.setForeground(Color.GRAY);
        showWorker.setFont(showWorker.getFont().deriveFont(Font.BOLD, 18f));
        panel.add(showWorker);


        ta1.setPreferredSize(new Dimension(120, 40));
        sl.putConstraint(SpringLayout.WEST, ta1, 135, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, ta1, 250, SpringLayout.NORTH, panel);
        sl.putConstraint(SpringLayout.WEST, lb1, 40, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, lb1, 260, SpringLayout.NORTH, panel);
        ta1.setBackground(Color.ORANGE);
        ta1.setForeground(Color.GRAY);
        ta1.setFont(ta1.getFont().deriveFont(Font.BOLD, 16f));
        panel.add(ta1);
        panel.add(lb1);

        backB.setPreferredSize(new Dimension(30,30));
        sl.putConstraint(SpringLayout.WEST, backB,0,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, backB,0,SpringLayout.NORTH, panel);
        panel.add(backB);
    }
}

