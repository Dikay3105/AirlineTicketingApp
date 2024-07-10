/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ChuyenBayBUS;
import BUS.DuongBayBUS;
import BUS.MayBayBUS;
import DAO.ChuyenBayDAO;
import DTO.ChuyenBayDTO;
import DTO.DuongBayDTO;
import DTO.MayBayDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duyli
 */
public class AddChuyenBay {
    private JFrame frBackground = new JFrame();

    private JLabel lbMaCB, lbMaDB, lbMaMB, lbGioBay, lbNgayDi, lbGate;
    private JTextField jtfMaCB, jtfMaDB, jtfMaMB, jtfGate;
    private JDateChooser jtfNgayDi;
    

    private JButton jbThem, jbCancel;
    private JLabel lbTitle = new JLabel("Thêm Chuyến Bay");
    private JPanel pnContent = new JPanel();
    private Font sgUI25b = new Font("Segoe UI", Font.BOLD, 25);
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15 = new Font("Segoe UI", Font.PLAIN, 15);
    static ChuyenBayBUS kh = new ChuyenBayBUS();
    private ArrayList<ChuyenBayDTO> KHList;
    DefaultTableModel model;
    //   PanelKhachHang PNKH = new PanelKhachHang();
    private JTable table;
    
    public class Time extends JPanel {

        JSpinner gioSpinner;
        JSpinner phutSpinner;

        public void init() {
            //spinner giờ
            
            SpinnerNumberModel gioModel = new SpinnerNumberModel(0, 0, 23, 1);
            gioSpinner = new JSpinner(gioModel);

            //spinner phút
            SpinnerNumberModel phutModel = new SpinnerNumberModel(0, 0, 59, 1);
            phutSpinner = new JSpinner(phutModel);
            setBackground(Color.WHITE);
            add(gioSpinner);
            add(new JLabel("h:"));
            add(phutSpinner);
            add(new JLabel("p"));

        }

        public void setSee(int i) {
            if (i == 0) {
                gioSpinner.setEnabled(false);
                phutSpinner.setEnabled(false);
            }
            if (i == 1) {
                gioSpinner.setEnabled(true);
                phutSpinner.setEnabled(true);
            }
        }
        
        public void reset() {
            gioSpinner.setValue(0);
            phutSpinner.setValue(0);
        }
        public void addtime(int a, int b) {
            gioSpinner.setValue(a);
            phutSpinner.setValue(b);
        }

        public Time() {
            init();
        }

    }


    public AddChuyenBay(JTable tablePANEL) throws ParseException {
        table = tablePANEL;
        initComponents( tablePANEL);
    }

    public void initComponents( JTable tablePANEL) throws ParseException {
        KHList = new ArrayList<>();
        
        KHList = new ChuyenBayBUS().load();
        frBackground.setVisible(true);
        frBackground.setSize(450, 700);
        frBackground.setLocationRelativeTo(null);
        frBackground.setLayout(new BorderLayout());
        frBackground.setResizable(false);
        frBackground.add(lbTitle, BorderLayout.NORTH);
        lbTitle.setPreferredSize(new Dimension(frBackground.getWidth(), 50));
        lbTitle.setOpaque(true);
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        lbTitle.setFont(sgUI25b);

        frBackground.add(pnContent);
        pnContent.setBackground(Color.white);
        pnContent.setLayout(null);
        frBackground.add(pnContent, BorderLayout.CENTER);

        lbMaCB = new JLabel("Mã chuyến bay: ");
        lbMaCB.setFont(sgUI15b);
        lbMaCB.setBounds(50, 50, 150, 50);
        jtfMaCB = new JTextField();
        jtfMaCB.setBounds(160, 55, 230, 40);
        jtfMaCB.setFont(sgUI15b);
        jtfMaCB.setText("VN"+count());
        jtfMaCB.setEnabled(false);

        lbMaDB = new JLabel("Mã đường bay: ");
        lbMaDB.setFont(sgUI15b);
        lbMaDB.setBounds(50, 120, 150, 50);
        jtfMaDB = new JTextField();
        jtfMaDB.setBounds(160, 125, 230, 40);
        jtfMaDB.setFont(sgUI15);
        //jtfMaDB.setEnabled(false);
        
        lbMaMB = new JLabel("Mã máy bay: ");
        lbMaMB.setFont(sgUI15b);
        lbMaMB.setBounds(50, 190, 100, 50);
        jtfMaMB = new JTextField();
        jtfMaMB.setBounds(160, 195, 230, 40);
        jtfMaMB.setFont(sgUI15);
        

        lbGioBay = new JLabel("Giờ bay: ");
        lbGioBay.setFont(sgUI15b);
        lbGioBay.setBounds(50, 260, 100, 50);
        
        Time time=new Time();
        time.setBounds(140, 270, 230, 40);
        
//        int gio1= Integer.parseInt(gioBay.substring(0,2));
//        int phut1= Integer.parseInt(gioBay.substring(3,5));
//        time.addtime(gio1, phut1);
        

        lbNgayDi = new JLabel("Ngày đi: ");
        lbNgayDi.setFont(sgUI15b);
        lbNgayDi.setBounds(50, 320, 100, 50);
        jtfNgayDi = new JDateChooser();
        jtfNgayDi.setBounds(160, 325, 230, 40);
        jtfNgayDi.setFont(sgUI15);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jtfNgayDi.getDateEditor();
        editor.setEditable(false);
        
        lbGate = new JLabel("Gate : ");
        lbGate.setFont(sgUI15b);
        lbGate.setBounds(50, 390, 100, 50);
        jtfGate = new JTextField();
        jtfGate.setBounds(160, 395, 230, 40);
        jtfGate.setFont(sgUI15);
        
        
        
        jbThem = new JButton("Thêm");
        jbThem.setBounds(30, 535, 100, 40);
        jbThem.setFont(sgUI15b);
        jbThem.setBackground(Color.GREEN);
        jbThem.setForeground(Color.white);

//        jbEDIT = new JButton("Sửa");
//        jbEDIT.setBounds(160, 535, 100, 40);
//        jbEDIT.setFont(sgUI15b);
//        jbEDIT.setBackground(Color.decode("#FF3D00"));
//        jbEDIT.setForeground(Color.white);

        jbCancel = new JButton("Thoát");
        jbCancel.setBounds(290, 535, 100, 40);
        jbCancel.setFont(sgUI15b);
        jbCancel.setBackground(Color.decode("#FF3D00"));
        jbCancel.setForeground(Color.white);
        jbCancel.addActionListener((ActionEvent e) -> {
            frBackground.setVisible(false);
        });

        pnContent.add(lbMaCB);
        pnContent.add(jtfMaCB);
        pnContent.add(lbMaDB);
        pnContent.add(jtfMaDB);
        pnContent.add(lbMaMB);
        pnContent.add(jtfMaMB);
        pnContent.add(lbGioBay);
        
        pnContent.add(time);
        pnContent.add(lbNgayDi);
        pnContent.add(jtfNgayDi);
        pnContent.add(lbGate);
        pnContent.add(jtfGate);
        pnContent.add(jbThem);
        pnContent.add(jbCancel);
        
        Date currentDate = new Date(); //ngày hiện tại
        jbThem.addActionListener((ActionEvent e) -> {
            if ( jtfMaDB.getText().isEmpty() || jtfMaMB.getText().isEmpty() || jtfNgayDi.getDate()==null||jtfGate.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chưa nhập đủ thông tin", "Thông Báo", JOptionPane.OK_OPTION);
            } 
              else if(maDBisEmpty(jtfMaDB.getText())==false){
                JOptionPane.showMessageDialog(null, "Mã đường bay không tồn tại");
                        
            } else if(maMBisEmpty(jtfMaMB.getText())==false){
                JOptionPane.showMessageDialog(null, "Mã máy bay không tồn tại");
            }
                else if(jtfNgayDi.getDate().before(currentDate)){
                JOptionPane.showMessageDialog(null, "Ngày đi phải bằng hoặc lớn hơn ngày hiện tại");
            }
            
                else {
                ChuyenBayDTO KH = new ChuyenBayDTO();
                KH.setMaChuyenBay(jtfMaCB.getText());
                KH.setMaDuongBay(jtfMaDB.getText());
                KH.setMaMayBay(jtfMaMB.getText());
                KH.setGate(jtfGate.getText());
                KH.setGioDelay("00:00:00");
                KH.setGioBay(time.gioSpinner.getValue() + ":" +  time.phutSpinner.getValue() + ":"+"00");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String NgayDi = dateFormat.format(jtfNgayDi.getDate());

                KH.setNgayDi(NgayDi);
                try {
                    new ChuyenBayBUS().insertChuyenBay(KH);
                } catch (SQLException ex) {
                    Logger.getLogger(AddChuyenBay.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AddChuyenBay.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                frBackground.setVisible(false);
            }
            
        });
        


        
    }
    public boolean maDBisEmpty(String a){
        ArrayList<DuongBayDTO> KHList = new ArrayList<>(); //xóa arraylist để update cái mới
      
            KHList = new DuongBayBUS().load();
            
        
        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getMaDuongBay().trim().equals(a)==true && KHList.get(i).getXuLy() == 1) {
                
                return true;
            }
        }
        return false;
    }
    public boolean maMBisEmpty(String a){
        ArrayList<MayBayDTO> KHList = new ArrayList<>(); //xóa arraylist để update cái mới
      
            KHList = new MayBayBUS().load();
        
        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getMaMayBay().trim().equals(a)==true && KHList.get(i).getXuLy() == 1) {

                return true;
            }
        }
        return false;
    }
    public  int count() {
        int count = 0;
        ArrayList<ChuyenBayDTO> list = new ChuyenBayDAO().LoadData();
        count += list.size();
        return count + 1;
    }
    public boolean find(String a) {
        ArrayList<ChuyenBayDTO> KHList = new ArrayList<>(); //xóa arraylist để update cái mới
      
            KHList = new ChuyenBayBUS().load();
        
        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getMaChuyenBay().equals(a) && KHList.get(i).getXuLy() == 1) {

                return true;
            }
        }
        return false;
    }

    public boolean checknonNum(String a) {
        try {
            double d = Double.parseDouble(a);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
