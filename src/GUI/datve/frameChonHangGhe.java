

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.datve;


import BUS.ChuyenBayBUS;
import DTO.ChuyenBayDTO;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static GUI.datve.MenuDatVe.pn_View;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ANH KHOA
 */
public class frameChonHangGhe extends javax.swing.JFrame  {
    
    String Noidi, Noiden;
    String ngaydi, ngayve;
    String giaE,giaB;
    String gioDi, gioDen;
    String time;
    PanelChonChuyenBay PNCCB= new PanelChonChuyenBay(Panel_TrangChu.tcb);

    private JTable table;
    private JLabel label, lb_Count;
    private boolean checkDong, check2c;
    ArrayList<ChuyenBayDTO> ListChuyenBay = new ChuyenBayBUS().load();
    String type="";
    //ChuyenManHinhController controller; 
    
    public static String ma/*,ma1c, ma2c*/;
    public frameChonHangGhe(String noidi, String noiden, String gioDi, String gioDen, String giaPT, String giaTG, String time,JTable tablePANEL, boolean check, boolean check2C, JLabel labelPANEL, String machuyenbay,JLabel lb_CountChuyen) throws InterruptedException, ParseException {
        table = tablePANEL;
        label = labelPANEL;
        checkDong = check;
        check2c = check2C;
        giaE = giaPT;
        giaB = giaTG;
        Noidi = noidi;
        Noiden = noiden;
        lb_Count = lb_CountChuyen;
        ma=machuyenbay;
        //ListChuyenBay=PanelChonChuyenBay.listChuyenBay;
        initComponents();
        
        init(noidi,noiden,gioDi,gioDen,giaPT,giaTG,time,machuyenbay); 
        int sum = Panel_TrangChu.tcb.getLonhon12() + Panel_TrangChu.tcb.getTu2den12();
        for (ChuyenBayDTO z : ListChuyenBay) {
            if(z.getSLEco()<sum && z.getMaChuyenBay().equals(ma)){
//                System.out.println("nho");
//                JOptionPane.showConfirmDialog(this, "Số lượng hành khách quá số lượng ghế Economy của chuyến("+z.getSLEco()+") ", "Thông báo", JOptionPane.OK_OPTION);
//                break;
                btn_PT.setEnabled(false);
            }
            if(z.getSLBus()<sum && z.getMaChuyenBay().equals(ma)){
//                System.out.println("nho");
//                JOptionPane.showConfirmDialog(this, "Số lượng hành khách quá số lượng ghế Economy của chuyến("+z.getSLEco()+") ", "Thông báo", JOptionPane.OK_OPTION);
//                break;
                btn_TG.setEnabled(false);
            }
        }
        
        
    }
    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_title = new javax.swing.JPanel();
        pn_ChiTietKhungGio = new javax.swing.JPanel();
        lb_GioUocTinh = new javax.swing.JLabel();
        pn_Container = new javax.swing.JPanel();
        lb_GioDi = new javax.swing.JLabel();
        lb_GioDen = new javax.swing.JLabel();
        lb_DiaDiemDi = new javax.swing.JLabel();
        lb_DiaDiemDen = new javax.swing.JLabel();
        pn_titleChitiet = new javax.swing.JPanel();
        lb_titleChonHangGhe = new javax.swing.JLabel();
        pn_Content = new javax.swing.JPanel();
        pn_PhoThong = new javax.swing.JPanel();
        Center_PT = new javax.swing.JPanel();
        lb_PT = new javax.swing.JLabel();
        btn_PT = new javax.swing.JButton();
        pn_ThuongGia = new javax.swing.JPanel();
        Center_TG = new javax.swing.JPanel();
        lb_TG = new javax.swing.JLabel();
        btn_TG = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chọn hạng vé");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        pn_title.setBackground(new java.awt.Color(255, 255, 255));
        pn_title.setPreferredSize(new java.awt.Dimension(500, 300));
        pn_title.setLayout(new java.awt.BorderLayout());

        pn_ChiTietKhungGio.setBackground(new java.awt.Color(248, 255, 235));
        pn_ChiTietKhungGio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(0, 204, 204)));
        pn_ChiTietKhungGio.setForeground(new java.awt.Color(255, 255, 255));
        pn_ChiTietKhungGio.setLayout(new java.awt.BorderLayout());

        lb_GioUocTinh.setBackground(new java.awt.Color(248, 255, 235));
        lb_GioUocTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_GioUocTinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_GioUocTinh.setText("Thời gian bay dự kiến: 2 tiếng 15 phút");
        lb_GioUocTinh.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 204, 204)), javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 204, 204))));
        lb_GioUocTinh.setPreferredSize(new java.awt.Dimension(38, 50));
        pn_ChiTietKhungGio.add(lb_GioUocTinh, java.awt.BorderLayout.SOUTH);

        pn_Container.setBackground(new java.awt.Color(255, 255, 255));
        pn_Container.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(0, 204, 204)));
        pn_Container.setLayout(new java.awt.GridLayout(2, 2));

        lb_GioDi.setBackground(new java.awt.Color(248, 255, 235));
        lb_GioDi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_GioDi.setForeground(new java.awt.Color(0, 204, 204));
        lb_GioDi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_GioDi.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 0, 0, 1, new java.awt.Color(0, 204, 204)));
        pn_Container.add(lb_GioDi);

        lb_GioDen.setBackground(new java.awt.Color(248, 255, 235));
        lb_GioDen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_GioDen.setForeground(new java.awt.Color(0, 204, 204));
        lb_GioDen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_GioDen.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 0, 0, 1, new java.awt.Color(0, 204, 204)));
        pn_Container.add(lb_GioDen);

        lb_DiaDiemDi.setBackground(new java.awt.Color(248, 255, 235));
        lb_DiaDiemDi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_DiaDiemDi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_DiaDiemDi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 204, 204)));
        lb_DiaDiemDi.setText(setDiadiemdi()+"");
        pn_Container.add(lb_DiaDiemDi);

        lb_DiaDiemDen.setBackground(new java.awt.Color(248, 255, 235));
        lb_DiaDiemDen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_DiaDiemDen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_DiaDiemDen.setText(setDiadiemden()+"");
        pn_Container.add(lb_DiaDiemDen);

        pn_ChiTietKhungGio.add(pn_Container, java.awt.BorderLayout.CENTER);

        pn_title.add(pn_ChiTietKhungGio, java.awt.BorderLayout.CENTER);

        pn_titleChitiet.setBackground(new java.awt.Color(248, 255, 235));
        pn_titleChitiet.setLayout(new java.awt.BorderLayout());

        lb_titleChonHangGhe.setBackground(new java.awt.Color(248, 255, 235));
        lb_titleChonHangGhe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_titleChonHangGhe.setForeground(new java.awt.Color(0, 204, 204));
        lb_titleChonHangGhe.setText("Chọn hạng ghế chuyến");
        lb_titleChonHangGhe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(255, 255, 255)));
        lb_titleChonHangGhe.setPreferredSize(new java.awt.Dimension(80, 25));
        pn_titleChitiet.add(lb_titleChonHangGhe, java.awt.BorderLayout.CENTER);

        pn_title.add(pn_titleChitiet, java.awt.BorderLayout.NORTH);

        getContentPane().add(pn_title, java.awt.BorderLayout.NORTH);
        pn_title.getAccessibleContext().setAccessibleName("    ");

        pn_Content.setBackground(new java.awt.Color(255, 255, 255));
        pn_Content.setPreferredSize(new java.awt.Dimension(90, 300));
        pn_Content.setLayout(new java.awt.GridLayout(1, 0));

        pn_PhoThong.setLayout(new java.awt.BorderLayout());

        Center_PT.setBackground(new java.awt.Color(0, 153, 153));
        Center_PT.setBorder(javax.swing.BorderFactory.createMatteBorder(25, 25, 25, 100, new java.awt.Color(255, 255, 255)));
        Center_PT.setPreferredSize(new java.awt.Dimension(450, 250));
        Center_PT.setLayout(new java.awt.GridLayout(2, 1));

        lb_PT.setBackground(new java.awt.Color(0, 153, 153));
        lb_PT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_PT.setForeground(new java.awt.Color(255, 255, 255));
        lb_PT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_PT.setText("Hạng Phổ Thông ");
        lb_PT.setPreferredSize(new java.awt.Dimension(250, 100));
        Center_PT.add(lb_PT);

        btn_PT.setBackground(new java.awt.Color(204, 255, 255));
        btn_PT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_PT.setPreferredSize(new java.awt.Dimension(250, 100));
        btn_PT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PTActionPerformed(evt);
            }
        });
        Center_PT.add(btn_PT);

        pn_PhoThong.add(Center_PT, java.awt.BorderLayout.CENTER);

        pn_Content.add(pn_PhoThong);

        pn_ThuongGia.setLayout(new java.awt.BorderLayout());

        Center_TG.setBackground(new java.awt.Color(255, 204, 0));
        Center_TG.setBorder(javax.swing.BorderFactory.createMatteBorder(25, 100, 25, 25, new java.awt.Color(255, 255, 255)));
        Center_TG.setPreferredSize(new java.awt.Dimension(450, 104));
        Center_TG.setLayout(new java.awt.GridLayout(2, 1));

        lb_TG.setBackground(new java.awt.Color(255, 204, 51));
        lb_TG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_TG.setForeground(new java.awt.Color(255, 255, 255));
        lb_TG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TG.setText("Hạng Thương Gia");
        lb_TG.setPreferredSize(new java.awt.Dimension(250, 100));
        Center_TG.add(lb_TG);

        btn_TG.setBackground(new java.awt.Color(255, 255, 204));
        btn_TG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_TG.setText("xxx VNĐ");
        btn_TG.setPreferredSize(new java.awt.Dimension(250, 100));
        btn_TG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TGActionPerformed(evt);
            }
        });
        Center_TG.add(btn_TG);

        pn_ThuongGia.add(Center_TG, java.awt.BorderLayout.CENTER);

        pn_Content.add(pn_ThuongGia);

        getContentPane().add(pn_Content, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PTActionPerformed

        if(check2c==false){
            MenuDatVe.ma1c = ma;///mã chuyến bay chiều đi 
            MenuDatVe.hangghe1C="Economy";

            MenuDatVe.Gia1C=giaE;
            setVisible(false);
        }
        else{
            if(check2c==true && checkDong==false){ 
                System.out.println(""+check2c+ checkDong);
                MenuDatVe.ma1c = ma;
                MenuDatVe.hangghe1C="Economy";
                MenuDatVe.Gia1C=giaE;
                setVisible(false);
                try {
                    PanelChonChuyenBay.loadTable(Panel_TrangChu.tcb,table,label,lb_Count);
                } catch (ParseException ex) {
                    Logger.getLogger(frameChonHangGhe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                setVisible(false);  
            }   
        }
        if(checkDong==true){
            MenuDatVe.ma2c=ma;//mã chiều về
            MenuDatVe.hangghe2C="Economy";
            MenuDatVe.Gia2C=giaE;
        }
        if(checkDong==true || check2c==false){    
            Panel_ThongTinKH pnTTKH = new Panel_ThongTinKH(Panel_TrangChu.tcb);
            MenuDatVe.btn_TTKH.setEnabled(true);
            pn_View.add(pnTTKH, "page3");
            MenuDatVe.cardLayout.show(pn_View, "page3");                   
        }
  
    }//GEN-LAST:event_btn_PTActionPerformed

    private void btn_TGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TGActionPerformed
        
        type="PT";
        if(check2c==false){
//                                   System.out.println("1 chieu vs dong");
            MenuDatVe.ma1c = ma;
            MenuDatVe.hangghe1C="Bussiness";
            MenuDatVe.Gia1C=giaB;
            setVisible(false);
        }
        else{
            if(check2c==true && checkDong==false){
                System.out.println(""+check2c+ checkDong);
                MenuDatVe.ma1c = ma;
                MenuDatVe.hangghe1C="Bussiness";
                MenuDatVe.Gia1C=giaB;
                setVisible(false);
                try {
                    PanelChonChuyenBay.loadTable(Panel_TrangChu.tcb,table,label,lb_Count);
                } catch (ParseException ex) {
                    Logger.getLogger(frameChonHangGhe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
//                                close=true;
                setVisible(false);  

            }   
        } 
        if(checkDong==true){
            MenuDatVe.ma2c=ma;
            MenuDatVe.hangghe2C="Bussiness";
            MenuDatVe.Gia2C=giaB;
        }
        if(checkDong==true || check2c==false){    
            Panel_ThongTinKH pnTTKH = new Panel_ThongTinKH(Panel_TrangChu.tcb);
            MenuDatVe.btn_TTKH.setEnabled(true);
            pn_View.add(pnTTKH, "page3");
            MenuDatVe.cardLayout.show(pn_View, "page3");                   
        }    
   
    }//GEN-LAST:event_btn_TGActionPerformed
                
    public void init(String noidi, String noiden, String gioDi, String gioDen, String giaPT, String giaTG, String time, String machuyenbay) throws InterruptedException {
//        lb_DiaDiemDi.setText(Noidi);
//        lb_DiaDiemDen.setText(Noiden);
        lb_GioDi.setText(gioDi);
        lb_GioDen.setText(gioDen);
        lb_GioUocTinh.setText(time);
        btn_PT.setText(giaPT);
        btn_TG.setText(giaTG);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                
            }
        });
          
        setLocationRelativeTo(null);
        setVisible(true);         
    }
    public static String getMaChuyenBay(String ma){
        return ma;
    }
    public String setDiadiemdi(){
        return Noidi;
    }
    public String setDiadiemden(){
        return Noiden;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Center_PT;
    private javax.swing.JPanel Center_TG;
    private javax.swing.JButton btn_PT;
    private javax.swing.JButton btn_TG;
    private javax.swing.JLabel lb_DiaDiemDen;
    private javax.swing.JLabel lb_DiaDiemDi;
    private javax.swing.JLabel lb_GioDen;
    private javax.swing.JLabel lb_GioDi;
    private javax.swing.JLabel lb_GioUocTinh;
    private javax.swing.JLabel lb_PT;
    private javax.swing.JLabel lb_TG;
    private javax.swing.JLabel lb_titleChonHangGhe;
    private javax.swing.JPanel pn_ChiTietKhungGio;
    private javax.swing.JPanel pn_Container;
    private javax.swing.JPanel pn_Content;
    private javax.swing.JPanel pn_PhoThong;
    private javax.swing.JPanel pn_ThuongGia;
    private javax.swing.JPanel pn_title;
    private javax.swing.JPanel pn_titleChitiet;
    // End of variables declaration//GEN-END:variables
}
