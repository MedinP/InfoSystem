import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class DeleteWorker extends JFrame {
    JPanel panel = new JPanel();
    JTextField tf1 = new JTextField();
    JLabel lb1 = new JLabel("WORKER ID: ");
    JButton deleteWo = new JButton("DELETE WORKER");
    JButton backB = new JButton();

    Session session = HibernateUtil.createSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    public DeleteWorker() {
        try {
            Image img = ImageIO.read(getClass().getResource("Hibernate/back.png"));
            backB.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        URL image = getClass().getResource("icon.png");
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());

        setContentPane(panel);
        setTitle("Welcome to Hibernate Info-System");
        setSize(230, 200);
        setLocationRelativeTo(null);
        addComponents();
        addEvents();
        setVisible(true);
    }

    private void addEvents() {

        deleteWo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tf1.getText());
                UserInterface.deleteWorkers(session, transaction, id);
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

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Delete workers:", TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.ORANGE));

        panel.setBackground(Color.GRAY);
        lb1.setForeground(Color.ORANGE);


        tf1.setPreferredSize(new Dimension(50, 30));
        sl.putConstraint(SpringLayout.WEST, tf1, 100, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, tf1, 50, SpringLayout.NORTH, panel);
        sl.putConstraint(SpringLayout.WEST, lb1, 10, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, lb1, 55, SpringLayout.NORTH, panel);
        tf1.setBackground(Color.ORANGE);
        tf1.setForeground(Color.GRAY);
        tf1.setFont(tf1.getFont().deriveFont(Font.BOLD, 16f));
        panel.add(tf1);
        panel.add(lb1);


        deleteWo.setPreferredSize(new Dimension(200, 30));
        sl.putConstraint(SpringLayout.WEST, deleteWo, 0, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, deleteWo, 100, SpringLayout.NORTH, panel);
        deleteWo.setBackground(Color.ORANGE);
        deleteWo.setForeground(Color.GRAY);
        deleteWo.setFont(deleteWo.getFont().deriveFont(Font.BOLD, 18f));
        panel.add(deleteWo);

        backB.setPreferredSize(new Dimension(30,30));
        sl.putConstraint(SpringLayout.WEST, backB,0,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, backB,0,SpringLayout.NORTH, panel);
        panel.add(backB);
    }
}


