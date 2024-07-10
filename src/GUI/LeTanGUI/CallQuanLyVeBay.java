/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.LeTanGUI;


import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author ANH KHOA
 */
public class CallQuanLyVeBay extends JFrame{
    public CallQuanLyVeBay(){
        initComponents();
    }
    public void initComponents(){
        setSize(1300, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));
        add(ReceptionistGUI.pnveBay);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Quay lại JFrame trước đó
                new ReceptionistGUI().setVisible(true);
                dispose(); // Đóng JFrame hiện tại
            }
        });
        setVisible(true);
    }
}
