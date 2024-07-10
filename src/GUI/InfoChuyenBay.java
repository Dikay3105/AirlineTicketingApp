/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ChuyenBayBUS;
import BUS.MayBayBUS;
import BUS.VeBayBUS;
import DTO.ChuyenBayDTO;
import DTO.MayBayDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duyli
 */
public class InfoChuyenBay {

    private JFrame frBackground = new JFrame();

    private JLabel lbMaCB, lbMaDB, lbMaMB, lbGioBay, lbNgayDi, lbGate;
    private JTextField jtfMaCB, jtfMaDB, jtfNgayDi, jtfMayBay;
    private JComboBox cbGate;

    private JButton jbDELETE, jbEDIT, jbCANCEL;
    private JLabel lbTitle = new JLabel("Chuyến Bay");
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

    public InfoChuyenBay(String maChuyenBay, String maDuongBay, String maMayBay, String gioBay, String ngayDi, String gate, JTable tablePANEL, int SelectRow) throws ParseException {
        table = tablePANEL;
        initComponents(maChuyenBay, maDuongBay, maMayBay, gioBay, ngayDi, gate, tablePANEL, SelectRow);
    }

    public void initComponents(String maChuyenBay, String maDuongBay, String maMayBay, String gioBay, String ngayDi, String gate, JTable tablePANEL, int SelectRow) throws ParseException {
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
        jtfMaCB.setText(maChuyenBay);
        jtfMaCB.setEnabled(false);

        lbMaDB = new JLabel("Mã đường bay:");
        lbMaDB.setFont(sgUI15b);
        lbMaDB.setBounds(50, 120, 150, 50);
        jtfMaDB = new JTextField();
        jtfMaDB.setBounds(160, 125, 230, 40);
        jtfMaDB.setFont(sgUI15);
        jtfMaDB.setText(maDuongBay);
        jtfMaDB.setEnabled(false);

        lbMaMB = new JLabel("Mã máy bay: ");
        lbMaMB.setFont(sgUI15b);
        lbMaMB.setBounds(50, 190, 100, 50);
        jtfMayBay = new JTextField(maMayBay);
        jtfMayBay.setEnabled(false);
        jtfMayBay.setBounds(160, 195, 230, 40);
        jtfMayBay.setFont(sgUI15);
        MayBayDTO mbdto = null;
        try {
            mbdto = MayBayBUS.loadMB(maMayBay);
        } catch (SQLException ex) {
            Logger.getLogger(InfoChuyenBay.class.getName()).log(Level.SEVERE, null, ex);
        }

        Time time = new Time();
        time.setBounds(140, 270, 230, 40);

        int gio1 = Integer.parseInt(gioBay.substring(0, 2));
        int phut1 = Integer.parseInt(gioBay.substring(3, 5));
        time.addtime(gio1, phut1);

        lbGioBay = new JLabel("Giờ bay: ");
        lbGioBay.setFont(sgUI15b);
        lbGioBay.setBounds(50, 260, 100, 50);

        lbNgayDi = new JLabel("Ngày đi: ");
        lbNgayDi.setFont(sgUI15b);
        lbNgayDi.setBounds(50, 320, 100, 50);
        jtfNgayDi = new JTextField();
        jtfNgayDi.setBounds(160, 325, 230, 40);
        jtfNgayDi.setFont(sgUI15);
        jtfNgayDi.setText(ngayDi);
        jtfNgayDi.setEnabled(false);

        lbGate = new JLabel("Gate : ");
        lbGate.setFont(sgUI15b);
        lbGate.setBounds(50, 390, 100, 50);
        cbGate = new JComboBox();

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date inputDate = inputDateFormat.parse(ngayDi);

        String outputDateString = outputDateFormat.format(inputDate);
        inputDate = inputDateFormat.parse(ngayDi);

        outputDateString = outputDateFormat.format(inputDate);

        ArrayList<String> tmpArrayList = ChuyenBayBUS.gateNotAvailable(time.gioSpinner.getValue(), time.phutSpinner.getValue(), outputDateString, maChuyenBay);
        if (tmpArrayList.isEmpty()) {
            for (int i = 1; i <= 20; i++) {
                cbGate.addItem(i);
            }
        } else {
            for (int i = 1; i <= 20; i++) {
                cbGate.addItem(i);
            }

            for (String gateString : tmpArrayList) {

                cbGate.removeItem(Integer.parseInt(gateString.trim()));

            }

        }

        cbGate.setSelectedItem(Integer.parseInt(gate.trim()));

        cbGate.setBounds(160, 395, 230, 40);
        cbGate.setFont(sgUI15);

        jbDELETE = new JButton("Hủy");
        jbDELETE.setBounds(30, 535, 100, 40);
        jbDELETE.setFont(sgUI15b);
        jbDELETE.setBackground(Color.decode("#388E3C"));
        jbDELETE.setForeground(Color.white);

        jbEDIT = new JButton("Sửa");
        jbEDIT.setBounds(160, 535, 100, 40);
        jbEDIT.setFont(sgUI15b);
        jbEDIT.setBackground(Color.decode("#FF3D00"));
        jbEDIT.setForeground(Color.white);

        jbCANCEL = new JButton("Thoát");
        jbCANCEL.setBounds(290, 535, 100, 40);
        jbCANCEL.setFont(sgUI15b);
        jbCANCEL.setBackground(Color.decode("#FF3D00"));
        jbCANCEL.setForeground(Color.white);
        jbCANCEL.addActionListener((ActionEvent e) -> {
            frBackground.setVisible(false);
        });

        pnContent.add(lbMaCB);
        pnContent.add(jtfMaCB);
        pnContent.add(lbMaDB);
        pnContent.add(jtfMaDB);
        pnContent.add(lbMaMB);
        pnContent.add(jtfMayBay);
        pnContent.add(lbGioBay);

        pnContent.add(time);

        time.gioSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    loadGate(time, ngayDi, gate, maChuyenBay);
                } catch (ParseException ex) {
                    Logger.getLogger(InfoChuyenBay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        time.phutSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    loadGate(time, ngayDi, gate, maChuyenBay);
                } catch (ParseException ex) {
                    Logger.getLogger(InfoChuyenBay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        pnContent.add(lbNgayDi);
        pnContent.add(jtfNgayDi);
        pnContent.add(lbGate);
        pnContent.add(cbGate);
        pnContent.add(jbDELETE);
        pnContent.add(jbEDIT);
        pnContent.add(jbCANCEL);

        jbDELETE.addActionListener((ActionEvent e) -> {
            int lick = JOptionPane.showConfirmDialog(null, "Xác nhận hủy chuyến bay " + jtfMaCB.getText() + " sẽ hủy các vé của chuyến bay?", "Thông Báo", 2);
            if (lick == JOptionPane.OK_OPTION) {
                ChuyenBayDTO KHtemp = new ChuyenBayDTO();
                KHtemp.setXuLy(0);
                KHtemp.setMaChuyenBay(jtfMaCB.getText());
                try {
                    new ChuyenBayBUS().delChuyenBay(KHtemp.getMaChuyenBay());
                    VeBayBUS.delAllVeBay(KHtemp.getMaChuyenBay());
                } catch (SQLException ex) {
                    Logger.getLogger(InfoChuyenBay.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(InfoChuyenBay.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Hủy chuyến bay thành công");
                PanelChuyenBay2.loaddata(table);
                frBackground.setVisible(false);
            } else {
                if (lick == JOptionPane.CANCEL_OPTION) {
                    //setVisible(false);
                }
            }

        });

        jbEDIT.addActionListener((ActionEvent e) -> {

            if (jtfMayBay.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Vui lòng không để trống thông tin");
            } else if(!time.gioSpinner.getValue().toString().trim().matches("\\d+") || !time.phutSpinner.getValue().toString().trim().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Vui lòng không nhập chữ vào vùng giờ bay");
            }
            else {
                ChuyenBayDTO KH = ChuyenBayBUS.loadCB(jtfMaCB.getText().trim());
                KH.setXuLy(1);
                KH.setMaChuyenBay(jtfMaCB.getText());
                KH.setMaDuongBay(jtfMaDB.getText());
                KH.setMaMayBay(jtfMayBay.getText().toString().trim());
                KH.setGioDelay(time.gioSpinner.getValue() + ":" + time.phutSpinner.getValue() + ":" + "00");
                // System.out.println( time.gioSpinner.getValue() + ":" +  time.phutSpinner.getValue() + ":"+"00");

//                if((int) time.gioSpinner.getValue()==gio1 && (int) time.phutSpinner.getValue()==phut1){
//                    KH.setGioDelay("00:00:00");
//                   
//                }
//                else {
//                    String giosuaString=String.format("%02d:%02d:00", time.gioSpinner.getValue(),  time.phutSpinner.getValue());
//                             
//                    String giogocString= gioBay;
//                   
//                    LocalTime giosuaTime = LocalTime.parse(giosuaString);
//                    LocalTime giogocTime = LocalTime.parse(giogocString);
//                    Duration delay = Duration.between(giogocTime, giosuaTime);
//                    String delayString = String.format("%02d:%02d:%02d",
//                delay.toHours(), delay.toMinutesPart(), delay.toSecondsPart());
//                    KH.setGioDelay(delayString);
//                }
                if ((int) time.gioSpinner.getValue() < gio1) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate date = LocalDate.parse(ngayDi, formatter);
                    LocalDate date1 = date.plusDays(1);
                    String DateString = date1.format(formatter);
                    jtfNgayDi.setText(DateString);
                }

                KH.setNgayDi(jtfNgayDi.getText());
                KH.setGate(cbGate.getSelectedItem().toString().trim());
                try {
                    new ChuyenBayBUS().updateChuyenBay(KH);
                } catch (SQLException ex) {
                    Logger.getLogger(InfoChuyenBay.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(InfoChuyenBay.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                PanelChuyenBay2.loaddata(table);
                frBackground.setVisible(false);
            }

        });

    }

    public boolean find(String a) {
        ArrayList<ChuyenBayDTO> KHList = new ArrayList<>(); //xóa arraylist để update cái mới

        KHList = new ChuyenBayBUS().load();

        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getMaChuyenBay().equals(a) && KHList.get(i).getXuLy() == 0) {

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

    public void loadGate(Time time, String ngayDi, String gate, String maChuyenBay) throws ParseException {
        cbGate.removeAllItems();
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date inputDate = inputDateFormat.parse(ngayDi);

        String outputDateString = outputDateFormat.format(inputDate);
        inputDate = inputDateFormat.parse(ngayDi);

        outputDateString = outputDateFormat.format(inputDate);

        ArrayList<String> tmpArrayList = ChuyenBayBUS.gateNotAvailable(time.gioSpinner.getValue(), time.phutSpinner.getValue(), outputDateString, maChuyenBay);
        if (tmpArrayList.isEmpty()) {
            for (int i = 1; i <= 20; i++) {
                cbGate.addItem(i);
            }
        } else {
            for (int i = 1; i <= 20; i++) {
                cbGate.addItem(i);
            }

            for (String gateString : tmpArrayList) {

                cbGate.removeItem(Integer.parseInt(gateString.trim()));

            }

        }

        cbGate.setSelectedItem(gate);
    }

}
