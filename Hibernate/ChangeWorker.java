import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ChangeWorker extends JFrame {
    JPanel panel3 = new JPanel();
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf3 = new JTextField();
    JTextField tf4 = new JTextField();

    Session session = HibernateUtil.createSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    JLabel lb1 = new JLabel("WORKER ID: " );
    JLabel lb2 = new JLabel("WORKER AGE: ");
    JLabel lb3 = new JLabel("WORKER ADDRESS: ");
    JLabel lb4 = new JLabel("WORKER SELLERY: ");

    JButton changeB = new JButton("CHANGE WORKER");
    JButton backB = new JButton();
    public ChangeWorker(){
        try {
            Image img = ImageIO.read(getClass().getResource("back.png"));
            backB.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        URL image = getClass().getResource("icon.png");
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());

        setContentPane(panel3);
        setTitle("Welcome to Hibernate Info-System");
        setSize(600,400);
        setLocationRelativeTo(null);
        addComponents();
        addEvents();
        setVisible(true);
    }

    private void addEvents() {
        changeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tf1.getText());
                Workers w = new Workers(Integer.parseInt(tf2.getText()),tf3.getText(),Double.parseDouble(tf4.getText()));
                UserInterface.updateWorkers(session,transaction,id,w);
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

        panel3.setBackground(Color.GRAY);

        lb1.setForeground(Color.ORANGE);
        lb2.setForeground(Color.ORANGE);
        lb3.setForeground(Color.ORANGE);
        lb4.setForeground(Color.ORANGE);

        panel3.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Change workers:", TitledBorder.CENTER,
                TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.ORANGE));

        tf1.setPreferredSize(new Dimension(400,30));
        sl.putConstraint(SpringLayout.WEST, tf1,140,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH, tf1,40,SpringLayout.NORTH,panel3);
        sl.putConstraint(SpringLayout.WEST,lb1,10,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH,lb1,45,SpringLayout.NORTH,panel3);
        tf1.setBackground(Color.ORANGE);
        tf1.setForeground(Color.GRAY);
        tf1.setFont(tf1.getFont().deriveFont(Font.BOLD, 16f));
        panel3.add(tf1);
        panel3.add(lb1);

        tf2.setPreferredSize(new Dimension(400,30));
        sl.putConstraint(SpringLayout.WEST,tf2,140,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH,tf2,80,SpringLayout.NORTH,panel3);
        sl.putConstraint(SpringLayout.WEST,lb2,10,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH,lb2,85,SpringLayout.NORTH,panel3);
        tf2.setBackground(Color.ORANGE);
        tf2.setForeground(Color.GRAY);
        tf2.setFont(tf2.getFont().deriveFont(Font.BOLD, 16f));
        panel3.add(tf2);
        panel3.add(lb2);

        tf3.setPreferredSize(new Dimension(400,30));
        sl.putConstraint(SpringLayout.WEST,tf3,140,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH,tf3,120,SpringLayout.NORTH,panel3);
        sl.putConstraint(SpringLayout.WEST,lb3,10,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH,lb3,125,SpringLayout.NORTH,panel3);
        tf3.setBackground(Color.ORANGE);
        tf3.setForeground(Color.GRAY);
        tf3.setFont(tf3.getFont().deriveFont(Font.BOLD, 16f));
        panel3.add(tf3);
        panel3.add(lb3);


        tf4.setPreferredSize(new Dimension(400,30));
        sl.putConstraint(SpringLayout.WEST,tf4,140,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH,tf4,160,SpringLayout.NORTH,panel3);
        sl.putConstraint(SpringLayout.WEST,lb4,10,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH,lb4,165,SpringLayout.NORTH,panel3);
        tf4.setBackground(Color.ORANGE);
        tf4.setForeground(Color.GRAY);
        tf4.setFont(tf4.getFont().deriveFont(Font.BOLD, 16f));
        panel3.add(tf4);
        panel3.add(lb4);

        changeB.setPreferredSize(new Dimension(400,50));
        sl.putConstraint(SpringLayout.WEST, changeB,140,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH, changeB,260,SpringLayout.NORTH,panel3);
        changeB.setBackground(Color.ORANGE);
        changeB.setForeground(Color.GRAY);
        changeB.setFont(changeB.getFont().deriveFont(Font.BOLD, 18f));
        panel3.add(changeB);

        backB.setPreferredSize(new Dimension(30,30));
        sl.putConstraint(SpringLayout.WEST, backB,0,SpringLayout.WEST,panel3);
        sl.putConstraint(SpringLayout.NORTH, backB,0,SpringLayout.NORTH,panel3);
        panel3.add(backB);
    }
}
