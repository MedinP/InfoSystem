import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowAllWorkers extends JFrame {
    UserInterface userInterface;
    JPanel panel = new JPanel();
    JButton showAll = new JButton("SHOW ALL WORKERS");
    JButton backB = new JButton();
    JTextArea ta1 = new JTextArea();

    Session sess = HibernateUtil.createSessionFactory().openSession();
    Transaction ts = sess.beginTransaction();

    public ShowAllWorkers() {
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
        setSize(600, 400);
        setTitle("Welcome to Hibernate Info-System");
        setLocationRelativeTo(null);
        addComponents();
        addEvents();
        setVisible(true);
    }

    private void addEvents() {

        JScrollPane scb = new JScrollPane(ta1);
        scb.setPreferredSize(new Dimension(580,170));
        scb.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scb.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scb);

        showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Workers> workers = new UserInterface().showAll(sess,ts);
                ta1.setText(String.valueOf(workers));

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
                BorderFactory.createEtchedBorder(), "Show All Workers", TitledBorder.CENTER,
                TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.ORANGE));

        panel.setBackground(Color.GRAY);

        ta1.setPreferredSize(new Dimension(450, 200));
        ta1.setBounds(0,150, 180, 60);
        ta1.setBackground(Color.ORANGE);
        ta1.setForeground(Color.GRAY);
        ta1.setFont(ta1.getFont().deriveFont(Font.BOLD, 14f));
        panel.add(ta1);


        showAll.setPreferredSize(new Dimension(400, 50));
        sl.putConstraint(SpringLayout.WEST, showAll, 0, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, showAll, 220, SpringLayout.NORTH, panel);
        showAll.setBackground(Color.ORANGE);
        showAll.setForeground(Color.GRAY);
        showAll.setFont(showAll.getFont().deriveFont(Font.BOLD, 18f));
        panel.add(showAll);

        backB.setPreferredSize(new Dimension(30,30));
        sl.putConstraint(SpringLayout.WEST, backB,0,SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, backB,300,SpringLayout.NORTH, panel);
        panel.add(backB);
    }
}

