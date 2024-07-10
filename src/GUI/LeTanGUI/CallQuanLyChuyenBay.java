package GUI.LeTanGUI;

import GUI.PanelChuyenBay2;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class CallQuanLyChuyenBay extends JFrame{
    public CallQuanLyChuyenBay(){
        initComponents();
    }
    public void initComponents(){
        setSize(1300, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));
        PanelChuyenBay2 pncb=new PanelChuyenBay2(1);
        add(pncb);
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
