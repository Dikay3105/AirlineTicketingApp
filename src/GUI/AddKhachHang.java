/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duyli
 */
public class AddKhachHang {
    
    String gt[] = {"Giới Tính","Nam", "Nữ"};
    
    private JFrame frBackground = new JFrame();
   
    private JLabel lbMaKH, lbHoTen, lbCmnd, lbGTinh, lbSdt,lbMail;
    private JTextField jtfMaKH, jtfHoTen, jtfCmnd, jtfSdt,jtfMail;
    private JComboBox cbGioiTinh;

    private JButton jbTHEM, jbCANCEL;
    private JLabel lbTitle = new JLabel("THÊM KHÁCH HÀNG");
    private JPanel pnContent = new JPanel();
    private Font sgUI25b = new Font("Segoe UI", Font.BOLD, 25);
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15 = new Font("Segoe UI", Font.PLAIN, 15);
    static KhachHangBUS kh = new KhachHangBUS();
    private ArrayList<KhachHangDTO> KHList;
    DefaultTableModel model;
    PanelKhachHang PNKH= new PanelKhachHang();
    private JTable table;
    public AddKhachHang(JTable tablePANEL){
        table = tablePANEL;
        initComponents(tablePANEL);
    }
    public void initComponents(JTable tablePANEL){
            
        
        KHList=new KhachHangBUS().load();
        
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
        
        lbMaKH = new JLabel("Mã khách hàng: ");
        lbMaKH.setFont(sgUI15b);
        lbMaKH.setBounds(50, 50, 150, 50);
        jtfMaKH = new JTextField();
        jtfMaKH.setBounds(160, 55, 230, 40);
        jtfMaKH.setFont(sgUI15b);
        jtfMaKH.setText("KH"+count());
        jtfMaKH.setEnabled(false);             
        


        lbHoTen = new JLabel("Họ & Tên: ");
        lbHoTen.setFont(sgUI15b);
        lbHoTen.setBounds(50, 120, 100, 50);
        jtfHoTen = new JTextField();
        jtfHoTen.setBounds(160, 125, 230, 40); 
        jtfHoTen.setFont(sgUI15);

        
        lbCmnd = new JLabel("CCCD: ");
        lbCmnd.setFont(sgUI15b);
        lbCmnd.setBounds(50, 190, 100, 50);
        jtfCmnd = new JTextField();
        jtfCmnd.setBounds(160, 195, 230, 40);      
        jtfCmnd.setFont(sgUI15);

        
        lbGTinh = new JLabel("Giới Tính: ");
        lbGTinh.setFont(sgUI15b);
        lbGTinh.setBounds(50, 260, 100, 50);
        cbGioiTinh = new JComboBox(gt);
        cbGioiTinh.setBackground(Color.decode("#FAFAFA"));
        cbGioiTinh.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        cbGioiTinh.setBounds(160, 265, 230, 40);
        cbGioiTinh.setFont(sgUI15);
        
         
        lbSdt = new JLabel("SĐT: ");
        lbSdt.setFont(sgUI15b);
        lbSdt.setBounds(50,320 , 100, 50);
        jtfSdt = new JTextField();
        jtfSdt.setBounds(160, 325, 230, 40);       
        jtfSdt.setFont(sgUI15);
        
        lbMail = new JLabel("Mail: ");
        lbMail.setFont(sgUI15b);
        lbMail.setBounds(50,380 , 100, 50);
        jtfMail = new JTextField();
        jtfMail.setBounds(160, 380, 230, 40);       
        jtfMail.setFont(sgUI15);
        
        jbTHEM = new JButton("Thêm");
        jbTHEM.setBounds(100, 535, 100, 40);
        jbTHEM.setFont(sgUI15b);
        jbTHEM.setBackground(Color.decode("#388E3C"));
        jbTHEM.setForeground(Color.white);
        
        
        jbCANCEL = new JButton("Cancel");
        jbCANCEL.setBounds(240, 535, 100, 40);
        jbCANCEL.setFont(sgUI15b);
        jbCANCEL.setBackground(Color.decode("#FF3D00"));
        jbCANCEL.setForeground(Color.white);
        
        
        pnContent.add(lbMaKH);
        pnContent.add(jtfMaKH); 
        pnContent.add(lbHoTen);
        pnContent.add(jtfHoTen);
        pnContent.add(lbCmnd);
        pnContent.add(jtfCmnd);
        pnContent.add(lbGTinh);
        pnContent.add(cbGioiTinh);
        pnContent.add(lbSdt);
        pnContent.add(jtfSdt);
        pnContent.add(lbMail);
        pnContent.add(jtfMail);
        pnContent.add(jbTHEM);
        pnContent.add(jbCANCEL);
        jbCANCEL.addActionListener((ActionEvent e) -> {
            frBackground.setVisible(false);
        });
        jbTHEM.addActionListener((ActionEvent e) -> {
            if ( jtfHoTen.getText().isEmpty() || jtfCmnd.getText().isEmpty() || jtfSdt.getText().isEmpty()||jtfMail.getText().isEmpty() || cbGioiTinh.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(null, "CHƯA NHẬP ĐỦ THÔNG TIN", "Thông Báo", JOptionPane.OK_OPTION);
            } 
              else if(checknonNum(jtfCmnd.getText())){
                JOptionPane.showMessageDialog(null, "CCCD phải là chữ số");
                        
            } else if (jtfCmnd.getText().length() < 10 ||jtfCmnd.getText().length() > 12) {
                JOptionPane.showMessageDialog(null, "CCCD phải từ 10 đến 12 chữ số");
            }
              else if (jtfCmnd.getText().charAt(0)!='0') {
                JOptionPane.showMessageDialog(null, "CCCD không hợp lệ ");
            } else if (jtfSdt.getText().charAt(0)!='0') {
                JOptionPane.showMessageDialog(null, "SỐ điện thoại không hợp lệ ");
            }
              
              else if(checknonNum(jtfSdt.getText())){
                JOptionPane.showMessageDialog(null, "Số điện thoại phải là chữ số");
            }else if ( jtfSdt.getText().length() != 10) {
                JOptionPane.showMessageDialog(null, "Số điện thoại phải gồm 10 chữ số");
            }  else if ( sdtIsExist(jtfSdt.getText())) {
                JOptionPane.showMessageDialog(null, "Số điện thoại đã được sử dụng");
            } else if ( mailIsExist(jtfMail.getText())) {
                JOptionPane.showMessageDialog(null, "Mail đã được sử dụng");
            } else if ( cccdIsExist(jtfCmnd.getText())) {
                JOptionPane.showMessageDialog(null, "CCCD đã được sử dụng");
            } 
                
            
            else if(isGmailAddress(jtfMail.getText())==false){
                JOptionPane.showMessageDialog(null, "Mail không hợp lệ");
            }
            
                else {
                KhachHangDTO KH = new KhachHangDTO();
                KH.setMaKH(jtfMaKH.getText());
                KH.setTenKH(jtfHoTen.getText());
                KH.setCccd(jtfCmnd.getText());
                KH.setSdt(jtfSdt.getText());
                KH.setMail(jtfMail.getText());
                
                if(cbGioiTinh.getSelectedIndex()==1)
                    KH.setGioiTinh(1);
                else if(cbGioiTinh.getSelectedIndex()==2)
                    KH.setGioiTinh(0);
                try {
                    new KhachHangBUS().insertKhachHang(KH);
                } catch (SQLException ex) {
                    Logger.getLogger(AddKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AddKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                frBackground.setVisible(false);
            }
            
        });
}
    public  int count() {
        int count = 0;
        ArrayList<KhachHangDTO> list = new KhachHangDAO().LoadData();
        count += list.size();
        return count + 1;
    }
    
    public boolean find(String a) {
        ArrayList<KhachHangDTO> KHList=new ArrayList<>(); //xóa arraylist để update cái mới
            
                KHList=new KhachHangBUS().load();
            
        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getMaKH().equals(a) && KHList.get(i).getXuLy() == 1) {

                return true;
            }
        }
        return false;
    }
    public boolean sdtIsExist(String a) {
        ArrayList<KhachHangDTO> KHList=new ArrayList<>(); //xóa arraylist để update cái mới
            
                KHList=new KhachHangBUS().load();
            
        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getSdt().equals(a) && KHList.get(i).getXuLy() == 1) {

                return true;
            }
        }
        return false;
    }
    public boolean mailIsExist(String a) {
        ArrayList<KhachHangDTO> KHList=new ArrayList<>(); //xóa arraylist để update cái mới
            
                KHList=new KhachHangBUS().load();
            
        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getMail().equals(a) && KHList.get(i).getXuLy() == 1) {

                return true;
            }
        }
        return false;
    }
    public boolean cccdIsExist(String a) {
        ArrayList<KhachHangDTO> KHList=new ArrayList<>(); //xóa arraylist để update cái mới
            
                KHList=new KhachHangBUS().load();
            
        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getCccd().equals(a) && KHList.get(i).getXuLy() == 1) {

                return true;
            }
        }
        return false;
    }
    
    
    public boolean checknonNum(String a){
        try {
        double d = Double.parseDouble(a);
    } catch (NumberFormatException nfe) {
        return true;
    }
    return false;
    }
    
    
    public static boolean isGmailAddress(String email) {
        // Biểu thức chính quy kiểm tra địa chỉ email Gmail
        String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
