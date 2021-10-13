import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class EnterWorker extends JFrame {
    JPanel panel = new JPanel();
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf3 = new JTextField();
    JTextField tf4 = new JTextField();
    JTextField tf5 = new JTextField();



    Session session = HibernateUtil.createSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    JLabel lb1 = new JLabel("WORKER ID: " );
    JLabel lb2 = new JLabel("WORKER AGE: ");
    JLabel lb3 = new JLabel("WORKER ADDRESS: ");
    JLabel lb4 = new JLabel("WORKER SELLERY: ");
    JLabel lb5 = new JLabel("WORKER NAME: ");


    JButton enterWo = new JButton("E N T E R    W O R K E R");
    JButton backB = new JButton();
    public EnterWorker(){
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
        setSize(600,400);
        setTitle("Welcome to Hibernate Info-System");
        setLocationRelativeTo(null);
        addComponents();
        addEvents();
        setVisible(true);
    }

    private void addEvents() {

        enterWo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Workers workers = new Workers(tf5.getText(),Integer.parseInt(tf2.getText()),tf3.getText(),Double.parseDouble(tf4.getText()));
                new UserInterface().enterWorkers(session,transaction,workers);
            }
        });
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FinalApp();
            }
        });

    }


    private void addComponents() {
        SpringLayout sl = new SpringLayout();
        setLayout(sl);

        panel.setBackground(Color.GRAY);
        lb1.setForeground(Color.ORANGE);
        lb2.setForeground(Color.ORANGE);
        lb3.setForeground(Color.ORANGE);
        lb4.setForeground(Color.ORANGE);
        lb5.setForeground(Color.ORANGE);

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Enter workers:", TitledBorder.CENTER,
                TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.ORANGE));

        tf1.setPreferredSize(new Dimension(400,25));
        sl.putConstraint(SpringLayout.WEST, tf1,140,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, tf1,40,SpringLayout.NORTH, panel);
        sl.putConstraint(SpringLayout.WEST,lb1,10,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH,lb1,45,SpringLayout.NORTH, panel);
        tf1.setBackground(Color.ORANGE);
        tf1.setForeground(Color.GRAY);
        tf1.setFont(tf1.getFont().deriveFont(Font.BOLD, 16f));
        panel.add(tf1);
        panel.add(lb1);

        tf2.setPreferredSize(new Dimension(400,25));
        sl.putConstraint(SpringLayout.WEST,tf2,140,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH,tf2,120,SpringLayout.NORTH, panel);
        sl.putConstraint(SpringLayout.WEST,lb2,10,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH,lb2,125,SpringLayout.NORTH, panel);
        tf2.setBackground(Color.ORANGE);
        tf2.setForeground(Color.GRAY);
        tf2.setFont(tf2.getFont().deriveFont(Font.BOLD, 16f));
        panel.add(tf2);
        panel.add(lb2);

        tf3.setPreferredSize(new Dimension(400,25));
        sl.putConstraint(SpringLayout.WEST,tf3,140,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH,tf3,160,SpringLayout.NORTH, panel);
        sl.putConstraint(SpringLayout.WEST,lb3,10,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH,lb3,165,SpringLayout.NORTH, panel);
        tf3.setBackground(Color.ORANGE);
        tf3.setForeground(Color.GRAY);
        tf3.setFont(tf3.getFont().deriveFont(Font.BOLD, 16f));
        panel.add(tf3);
        panel.add(lb3);


        tf4.setPreferredSize(new Dimension(400,25));
        sl.putConstraint(SpringLayout.WEST,tf4,140,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH,tf4,200,SpringLayout.NORTH, panel);
        sl.putConstraint(SpringLayout.WEST,lb4,10,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH,lb4,205,SpringLayout.NORTH, panel);
        tf4.setBackground(Color.ORANGE);
        tf4.setForeground(Color.GRAY);
        tf4.setFont(tf4.getFont().deriveFont(Font.BOLD, 16f));
        panel.add(tf4);
        panel.add(lb4);

        tf5.setPreferredSize(new Dimension(400,25));
        sl.putConstraint(SpringLayout.WEST, tf5,140,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, tf5,80,SpringLayout.NORTH, panel);
        sl.putConstraint(SpringLayout.WEST,lb5,10,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH,lb5,85,SpringLayout.NORTH, panel);
        tf5.setBackground(Color.ORANGE);
        tf5.setForeground(Color.GRAY);
        tf5.setFont(tf5.getFont().deriveFont(Font.BOLD, 16f));
        panel.add(tf5);
        panel.add(lb5);

        enterWo.setPreferredSize(new Dimension(400,50));
        sl.putConstraint(SpringLayout.WEST, enterWo,140,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, enterWo,260,SpringLayout.NORTH, panel);
        enterWo.setBackground(Color.ORANGE);
        enterWo.setForeground(Color.GRAY);
        enterWo.setFont(enterWo.getFont().deriveFont(Font.BOLD, 18f));
        panel.add(enterWo);

        backB.setPreferredSize(new Dimension(30,30));
        sl.putConstraint(SpringLayout.WEST, backB,0,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, backB,0,SpringLayout.NORTH, panel);
        panel.add(backB);
    }
}

