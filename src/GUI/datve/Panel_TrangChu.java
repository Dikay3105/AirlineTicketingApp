/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.datve;

import BUS.ChuyenBayBUS;
import DTO.ChuyenBayDTO;
import DTO.TimChuyenBayDTO;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import static GUI.datve.MenuDatVe.pn_View;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANH KHOA
 */
public class Panel_TrangChu extends javax.swing.JPanel {

    //ChuyenManHinhController controller;
    java.util.Date dateDi, dateDenDate;
    SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1); // Giới hạn từ 0 trở lên;
    SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1); // Giới hạn từ 0 trở lên;
    SpinnerNumberModel model3 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1); // Giới hạn từ 0 trở lên;
    boolean check_btn2;
    /**
     * Creates new form Panel_DatVe1
     */
    public static TimChuyenBayDTO tcb;

    public Panel_TrangChu() {
        if (check_btn2 == true) {
            check_btn2 = false;
        }
        MenuDatVe.hangghe1C = "";
        MenuDatVe.hangghe2C = "";
        MenuDatVe.Gia1C = "";
        MenuDatVe.Gia2C = "";
        MenuDatVe.ma1c = "";
        MenuDatVe.ma2c = "";
        if (!MenuDatVe.MaGheList.isEmpty()) {
            MenuDatVe.MaGheList.clear();
        }
        if (!MenuDatVe.MaGheListVe.isEmpty()) {
            MenuDatVe.MaGheListVe.clear();
        }
        initComponents();
        if (jdc_NgayDi.getDate() != null) {
            jdc_NgayDi.setDate(null);
        }
        if (jdc_NgayVe.getDate() != null) {
            jdc_NgayVe.setDate(null);
        }
        jcb_NoiDen.setBackground(Color.white);
        jcb_NoiDi.setBackground(Color.white);
        jcbHangbay.setBackground(Color.white);
        jcbHangbayve.setBackground(Color.white);
        lb_NgayVe.setVisible(false);
        jdc_NgayVe.setVisible(false);
        jLabel1.setVisible(false);
        jcbHangbayve.setVisible(false);
//        lb_te2.setVisible(false);
//        spn_te2.setVisible(false);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(Color.decode("#00CCCC"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(Color.decode("#00F5E1"));
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_Content = new javax.swing.JPanel();
        pn_ContentTop = new javax.swing.JPanel();
        pn_ContentCb = new javax.swing.JPanel();
        pn_NoiDi = new javax.swing.JPanel();
        jcb_NoiDi = new javax.swing.JComboBox<>();
        lb_NoiDi = new javax.swing.JLabel();
        pn_NoiDen = new javax.swing.JPanel();
        jcb_NoiDen = new javax.swing.JComboBox<>();
        lb_NoiDen = new javax.swing.JLabel();
        pn_NgayDi = new javax.swing.JPanel();
        lb_NgayDi = new javax.swing.JLabel();
        jdc_NgayDi = new com.toedter.calendar.JDateChooser();
        pn_NgayVe = new javax.swing.JPanel();
        lb_NgayVe = new javax.swing.JLabel();
        jdc_NgayVe = new com.toedter.calendar.JDateChooser();
        pn_ContentSec = new javax.swing.JPanel();
        btn_1Chieu = new javax.swing.JButton();
        btn_2chieu = new javax.swing.JButton();
        pn_PickSLHanhKhach = new javax.swing.JPanel();
        spn_ngl12 = new javax.swing.JSpinner();
        lb_nl12 = new javax.swing.JLabel();
        lb_titileHK = new javax.swing.JLabel();
        lb_te212 = new javax.swing.JLabel();
        spn_te212 = new javax.swing.JSpinner();
        btn = new javax.swing.JButton();
        jcbHangbay = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbHangbayve = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1300, 700));
        setLayout(new java.awt.BorderLayout());

        pn_Content.setLayout(new java.awt.BorderLayout());

        pn_ContentTop.setBackground(new java.awt.Color(248, 249, 209));
        pn_ContentTop.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 0, 10, new java.awt.Color(255, 255, 255)));
        pn_ContentTop.setPreferredSize(new java.awt.Dimension(1200, 180));
        pn_ContentTop.setLayout(new java.awt.BorderLayout());

        pn_ContentCb.setBackground(new java.awt.Color(248, 249, 209));
        pn_ContentCb.setPreferredSize(new java.awt.Dimension(1200, 30));
        pn_ContentCb.setLayout(new java.awt.GridLayout(1, 4));

        pn_NoiDi.setBackground(new java.awt.Color(248, 255, 235));
        pn_NoiDi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 255, 235), 20));
        pn_NoiDi.setLayout(new java.awt.BorderLayout());

        jcb_NoiDi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Thành phố Hồ Chí Minh", "Đà Nẵng", "Quảng Ninh", "Hải Phòng", "Nghệ An", "Huế", "Khánh Hòa", "Lâm Đồng", "Bình Định", "Cần Thơ", "Kiên Giang" }));
        jcb_NoiDi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jcb_NoiDi.setPreferredSize(new java.awt.Dimension(134, 20));
        jcb_NoiDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_NoiDiActionPerformed(evt);
            }
        });
        pn_NoiDi.add(jcb_NoiDi, java.awt.BorderLayout.CENTER);

        lb_NoiDi.setBackground(new java.awt.Color(248, 255, 235));
        lb_NoiDi.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lb_NoiDi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_NoiDi.setText("Từ");
        lb_NoiDi.setPreferredSize(new java.awt.Dimension(14, 20));
        pn_NoiDi.add(lb_NoiDi, java.awt.BorderLayout.NORTH);

        pn_ContentCb.add(pn_NoiDi);

        pn_NoiDen.setBackground(new java.awt.Color(248, 255, 235));
        pn_NoiDen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 255, 235), 20));
        pn_NoiDen.setLayout(new java.awt.BorderLayout());

        jcb_NoiDen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Thành phố Hồ Chí Minh", "Đà Nẵng", "Quảng Ninh", "Hải Phòng", "Nghệ An", "Huế", "Khánh Hòa", "Lâm Đồng", "Bình Định", "Cần Thơ", "Kiên Giang" }));
        jcb_NoiDen.setBorder(null);
        pn_NoiDen.add(jcb_NoiDen, java.awt.BorderLayout.CENTER);

        lb_NoiDen.setBackground(new java.awt.Color(248, 249, 209));
        lb_NoiDen.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lb_NoiDen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_NoiDen.setText("Đến");
        lb_NoiDen.setPreferredSize(new java.awt.Dimension(22, 20));
        pn_NoiDen.add(lb_NoiDen, java.awt.BorderLayout.NORTH);

        pn_ContentCb.add(pn_NoiDen);

        pn_NgayDi.setBackground(new java.awt.Color(248, 255, 235));
        pn_NgayDi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 255, 235), 20));
        pn_NgayDi.setLayout(new java.awt.BorderLayout());

        lb_NgayDi.setBackground(new java.awt.Color(248, 249, 209));
        lb_NgayDi.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lb_NgayDi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_NgayDi.setText("Ngày đi");
        lb_NgayDi.setPreferredSize(new java.awt.Dimension(38, 20));
        pn_NgayDi.add(lb_NgayDi, java.awt.BorderLayout.NORTH);

        LocalDate dateDefault = java.time.LocalDate.now();
        Date date = java.sql.Date.valueOf(dateDefault);
        jdc_NgayDi.setDate(date);
        jdc_NgayDi.setDateFormatString("dd-MM-yyyy");
        jdc_NgayDi.setBackground(new java.awt.Color(248, 255, 235));
        jdc_NgayDi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pn_NgayDi.add(jdc_NgayDi, java.awt.BorderLayout.CENTER);

        pn_ContentCb.add(pn_NgayDi);

        pn_NgayVe.setBackground(new java.awt.Color(248, 255, 235));
        pn_NgayVe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 255, 235), 20));
        pn_NgayVe.setLayout(new java.awt.BorderLayout());

        lb_NgayVe.setBackground(new java.awt.Color(248, 249, 209));
        lb_NgayVe.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lb_NgayVe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_NgayVe.setText("Ngày về");
        lb_NgayVe.setPreferredSize(new java.awt.Dimension(38, 20));
        pn_NgayVe.add(lb_NgayVe, java.awt.BorderLayout.NORTH);

        jdc_NgayVe.setDate(date);
        jdc_NgayVe.setDateFormatString("dd-MM-yyyy");
        jdc_NgayVe.setBackground(new java.awt.Color(248, 255, 235));
        jdc_NgayVe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pn_NgayVe.add(jdc_NgayVe, java.awt.BorderLayout.CENTER);

        pn_ContentCb.add(pn_NgayVe);

        pn_ContentTop.add(pn_ContentCb, java.awt.BorderLayout.CENTER);

        pn_ContentSec.setBackground(new java.awt.Color(248, 255, 235));
        pn_ContentSec.setForeground(new java.awt.Color(255, 255, 255));
        pn_ContentSec.setPreferredSize(new java.awt.Dimension(1200, 70));

        btn_1Chieu.setBackground(new java.awt.Color(0, 204, 204));
        btn_1Chieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_1Chieu.setForeground(new java.awt.Color(255, 255, 255));
        btn_1Chieu.setText("Một chiều");
        btn_1Chieu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_1Chieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ChieuActionPerformed(evt);
            }
        });

        btn_2chieu.setBackground(new java.awt.Color(228, 228, 228));
        btn_2chieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_2chieu.setText("Khứ hồi");
        btn_2chieu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(255, 255, 255)));
        btn_2chieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2chieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ContentSecLayout = new javax.swing.GroupLayout(pn_ContentSec);
        pn_ContentSec.setLayout(pn_ContentSecLayout);
        pn_ContentSecLayout.setHorizontalGroup(
            pn_ContentSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ContentSecLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_1Chieu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_2chieu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1246, Short.MAX_VALUE))
        );
        pn_ContentSecLayout.setVerticalGroup(
            pn_ContentSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ContentSecLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pn_ContentSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_1Chieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_2chieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pn_ContentTop.add(pn_ContentSec, java.awt.BorderLayout.NORTH);

        pn_Content.add(pn_ContentTop, java.awt.BorderLayout.NORTH);

        pn_PickSLHanhKhach.setBackground(new java.awt.Color(248, 255, 235));
        pn_PickSLHanhKhach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 10));

        spn_ngl12.setModel(model1);
        spn_ngl12.setInheritsPopupMenu(true);
        spn_ngl12.setPreferredSize(new java.awt.Dimension(70, 25));

        lb_nl12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_nl12.setText("Người lớn (từ 13 tuổi)");

        lb_titileHK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_titileHK.setText("Hành khách:");

        lb_te212.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_te212.setText("Trẻ em (2-12 tuổi )");
        lb_te212.setPreferredSize(new java.awt.Dimension(150, 20));

        spn_te212.setModel(model2);
        spn_te212.setInheritsPopupMenu(true);

        btn.setBackground(new java.awt.Color(0, 245, 225));
        btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn.setForeground(new java.awt.Color(255, 255, 255));
        btn.setText("TÌM CHUYẾN BAY");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        jcbHangbay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vietjet Air", "Vietnam Airlines", "Bamboo", "Jetstar Pacific" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Hãng bay về: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Hãng bay đi: ");

        jcbHangbayve.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vietjet Air", "Vietnam Airlines", "Bamboo", "Jetstar Pacific" }));

        javax.swing.GroupLayout pn_PickSLHanhKhachLayout = new javax.swing.GroupLayout(pn_PickSLHanhKhach);
        pn_PickSLHanhKhach.setLayout(pn_PickSLHanhKhachLayout);
        pn_PickSLHanhKhachLayout.setHorizontalGroup(
            pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_PickSLHanhKhachLayout.createSequentialGroup()
                .addGroup(pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_PickSLHanhKhachLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_PickSLHanhKhachLayout.createSequentialGroup()
                                .addGroup(pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lb_te212, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_nl12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spn_te212, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spn_ngl12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pn_PickSLHanhKhachLayout.createSequentialGroup()
                                .addGroup(pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_titileHK, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pn_PickSLHanhKhachLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbHangbay, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel1)))
                                .addGap(18, 18, 18)
                                .addComponent(jcbHangbayve, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pn_PickSLHanhKhachLayout.createSequentialGroup()
                        .addGap(538, 538, 538)
                        .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(808, Short.MAX_VALUE))
        );
        pn_PickSLHanhKhachLayout.setVerticalGroup(
            pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_PickSLHanhKhachLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbHangbay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbHangbayve, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_titileHK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nl12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_ngl12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pn_PickSLHanhKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_te212, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_te212, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pn_Content.add(pn_PickSLHanhKhach, java.awt.BorderLayout.CENTER);

        add(pn_Content, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jcb_NoiDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_NoiDiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_NoiDiActionPerformed

    private void btn_1ChieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ChieuActionPerformed
        btn_2chieu.setBackground(Color.decode("#E4E4E4"));
        btn_2chieu.setForeground(Color.BLACK);
        btn_1Chieu.setBackground(Color.decode("#00CCCC"));
        btn_1Chieu.setForeground(Color.WHITE);
        lb_NgayVe.setVisible(false);
        jdc_NgayVe.setVisible(false);
        jLabel1.setVisible(false);
        jcbHangbayve.setVisible(false);
        check_btn2 = false;
        //MenuDatVe.khuhoi=0;
    }//GEN-LAST:event_btn_1ChieuActionPerformed

    private void btn_2chieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2chieuActionPerformed
        btn_1Chieu.setBackground(Color.decode("#E4E4E4"));
        btn_1Chieu.setForeground(Color.BLACK);
        btn_2chieu.setBackground(Color.decode("#00CCCC"));
        btn_2chieu.setForeground(Color.WHITE);
        lb_NgayVe.setVisible(true);
        jdc_NgayVe.setVisible(true);
        jLabel1.setVisible(true);
        jcbHangbayve.setVisible(true);
        check_btn2 = true;
        //MenuDatVe.khuhoi=1;
    }//GEN-LAST:event_btn_2chieuActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        boolean c1 = true;
        boolean c2 = true;
        tcb = new TimChuyenBayDTO();

        tcb.setNoidi(jcb_NoiDi.getSelectedItem().toString());
        tcb.setNoiden(jcb_NoiDen.getSelectedItem().toString());
        tcb.setHangBaydi(jcbHangbay.getSelectedItem().toString());
        tcb.setLonhon12(Integer.parseInt(spn_ngl12.getValue() + ""));
        tcb.setTu2den12(Integer.parseInt(spn_te212.getValue() + ""));
        dateDi = jdc_NgayDi.getDate();
        if (dateDi != null) {
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
            tcb.setNgaydi(formatter1.format(dateDi));
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
            c1 = checkCountChuyenBayisnull(tcb, 1);
            if (check_btn2 == true && jdc_NgayVe != null) {
                dateDenDate = jdc_NgayVe.getDate();
                tcb.setNgayve(formatter2.format(dateDenDate));
                tcb.setHangBayve(jcbHangbayve.getSelectedItem().toString());
                c2 = checkCountChuyenBayisnull(tcb, 2);
            }

            try {
                //            tcb.setNhohon2(Integer.parseInt(spn_te2.getValue()+""));
//            System.out.println(""+tcb.getLonhon12());
//            System.out.println(""+tcb.getTu2den12());
//            System.out.println(""+tcb.getNhohon2());
if (checkInput(tcb) == true) {
    if (c1 == false) {
        JOptionPane.showMessageDialog(null, "Không có chuyến bay hoặc không đủ chỗ cho chuyến bay chiều đi như bạn mong muốn\nVui lòng chọn ngày đi khác", "Thông báo", JOptionPane.OK_OPTION);
    } else if (c2 == false) {
        JOptionPane.showMessageDialog(null, "Không có chuyến bay hoặc không đủ chỗ cho chuyến bay chiều về như bạn mong muốn\nVui lòng chọn ngày đi khác", "Thông báo", JOptionPane.OK_OPTION);
    } else {
        try {
            PanelChonChuyenBay pnCB = new PanelChonChuyenBay(tcb);
            pn_View.add(pnCB, "page2");
            jdc_NgayDi.setDate(null);
            jdc_NgayVe.setDate(null);
            MenuDatVe.cardLayout.show(pn_View, "page2");
        } catch (ParseException ex) {
            Logger.getLogger(Panel_TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
            } catch (ParseException ex) {
                Logger.getLogger(Panel_TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
            JOptionPane.showMessageDialog(null, "HÃY NHẬP ĐÚNG ĐỊNH DẠNG NGÀY SINH: dd-MM-yyyy", "Thông Báo", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_btnActionPerformed
    public boolean checkTrungNoi_DI_DEN(TimChuyenBayDTO tcb) {
        //Check noi di noi den
        if (tcb.getNoidi().equals(tcb.getNoiden())) {
            JOptionPane.showMessageDialog(null, "Nơi đi và nơi đến bị trùng", "Thông Báo", JOptionPane.YES_NO_OPTION);
            return false;
        }
        return true;
    }

    public boolean checkTrungNgay_DI_DEN(TimChuyenBayDTO tcb) {
        //Check noi di noi den
        if (tcb.getNgaydi().equals(tcb.getNgayve())) {
            JOptionPane.showMessageDialog(null, "Ngày đi và ngày về bị trùng", "Thông Báo", JOptionPane.YES_NO_OPTION);
            return false;
        }
        return true;
    }

    public boolean checkSL_HanhKhach(TimChuyenBayDTO tcb) {
//        int Lonhon12 = tcb.getLonhon12();
//        int Tu2den12 = tcb.getTu2den12();
//        int Nhohon2 = tcb.getNhohon2();
        int sum = tcb.getLonhon12() + tcb.getTu2den12() /*+tcb.getNhohon2()*/;
        if (sum <= 0) {
            JOptionPane.showMessageDialog(null, "Chưa thêm số lượng hành khách", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        } else if (sum > 9) {
            JOptionPane.showMessageDialog(null, "Vượt số lượng đặt tối đa (tôi đa 9 hành khách) ", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        } //        else if((tcb.getLonhon12()+tcb.getTu2den12())!=tcb.getNhohon2() && tcb.getNhohon2()>0){
        //            JOptionPane.showMessageDialog(null, "Mỗi trẻ em dưới 2 tuổi phải phải đi cùng 1 người lớn", "Thông Báo", JOptionPane.OK_OPTION);
        //            return false;
        //        }
        else if (Integer.parseInt(spn_te212.getValue().toString()) != 0 && Integer.parseInt(spn_ngl12.getValue().toString()) == 0) {
            JOptionPane.showMessageDialog(null, "Trẻ em dưới 12 tuổi cần ít nhất 1 người lớn đi kèm", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        } else if (tcb.getTu2den12() > 2 * tcb.getLonhon12()) {
            JOptionPane.showMessageDialog(null, "Mỗi người lớn chỉ đi cùng 2 trẻ em từ 2 tuổi đến 12 tuổi", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        return true;
    }

    public boolean checkDate(String dateStr) {
        if (isDateValid(dateStr) == false || isStringDateInPast(dateStr) == true) {
            System.out.println("" + dateStr);
            JOptionPane.showMessageDialog(null, "Nhập/chọn đúng định dạng ngày đi-đến \nKhông chọn ngày đã qua", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        return true;
    }

    public static boolean isDateValid(String dateStr) {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false); // Tắt tính linh hoạt để kiểm tra chính xác ngày tháng

        try {
            Date date = sdf.parse(dateStr);
            // Nếu ngày tháng được phân tích thành công, thì chuỗi đúng định dạng
            return true;
        } catch (ParseException e) {
            // Nếu có lỗi ParseException, chuỗi không đúng định dạng
            JOptionPane.showMessageDialog(null, "Nhập/chọn đúng định dạng ngày đi-đến", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
    }

    public boolean isStringDateInPast(String dateString) {
        try {
            // Định dạng chuỗi ngày tháng đầu vào
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Chuyển đổi chuỗi thành LocalDate
            LocalDate inputDate = LocalDate.parse(dateString, formatter);

            // Lấy ngày hiện tại
            LocalDate currentDate = LocalDate.now();

            // So sánh
            return inputDate.isBefore(currentDate);
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu chuỗi không hợp lệ hoặc không thể chuyển đổi thành LocalDate
            JOptionPane.showMessageDialog(null, "Không chọn ngày đã qua", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
    }
    
    
    public boolean checkNgay_DI_DEN(TimChuyenBayDTO tcb) throws ParseException{
        //Check noi di noi den
        // Chuyển đổi chuỗi thành đối tượng ngày
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date departureDate = sdf.parse(tcb.getNgaydi());
                Date returnDate = sdf.parse(tcb.getNgayve());
        // Kiểm tra xem ngày về có sau hoặc bằng ngày đến không
        if(!returnDate.before(departureDate)==false){
            JOptionPane.showMessageDialog(null, "Ngày đến đi không sau ngày về", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
            
        }
            
        return true;
    }
    
    

    public boolean checkInput(TimChuyenBayDTO tcb) throws ParseException {
        if (!checkTrungNoi_DI_DEN(tcb)) {
            return false;
        } else if (!checkTrungNgay_DI_DEN(tcb)) {
            return false;
        } else if (checkSL_HanhKhach(tcb) == false) {
            return false;
        } else if (tcb.getNgayve() == null) {
            if (!checkDate(tcb.getNgaydi())) {
                return false;
            }
           
        } else if (!checkDate(tcb.getNgaydi()) || !checkDate(tcb.getNgayve())) {
            return false;
        }

        return true;
    }

    public boolean checkCountChuyenBayisnull(TimChuyenBayDTO tcb, int check) {
        ArrayList<ChuyenBayDTO> listChuyenBay = new ArrayList<>();;
        ArrayList<String> tgd = new ArrayList<>();
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        int sum = tcb.getLonhon12() + tcb.getTu2den12();
        if (check == 1) {
            try {
                date = inputDateFormat.parse(tcb.getNgaydi());
            } catch (ParseException ex) {
                Logger.getLogger(Panel_TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
            String outputDateStr = outputDateFormat.format(date);
            System.out.println("" + tcb.getNoidi() + "  " + tcb.getNoiden() + "  " + tcb.getNgaydi());
            if (!listChuyenBay.isEmpty()) {
                listChuyenBay.clear();
            }
            listChuyenBay = ChuyenBayBUS.loadCBtheoDB(tcb.getNoidi(), tcb.getNoiden(), outputDateStr, tgd, tcb.getHangBaydi(), sum);
            System.out.println("Size " + listChuyenBay.size());
        } else {
            try {
                date = inputDateFormat.parse(tcb.getNgayve());
            } catch (ParseException ex) {
                Logger.getLogger(Panel_TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
            String outputDateStr = outputDateFormat.format(date);
            System.out.println("" + tcb.getNoidi() + "  " + tcb.getNoiden() + "  " + tcb.getNgayve());
            if (!listChuyenBay.isEmpty()) {
                listChuyenBay.clear();
            }
            listChuyenBay = ChuyenBayBUS.loadCBtheoDB(tcb.getNoiden(), tcb.getNoidi(), outputDateStr, tgd, tcb.getHangBayve(), sum);
            System.out.println("Size " + listChuyenBay.size());
        }
        if (listChuyenBay.isEmpty()) {
            listChuyenBay.clear();
            return false;
        }
        listChuyenBay.clear();
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JButton btn_1Chieu;
    private javax.swing.JButton btn_2chieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jcbHangbay;
    private javax.swing.JComboBox<String> jcbHangbayve;
    private javax.swing.JComboBox<String> jcb_NoiDen;
    private javax.swing.JComboBox<String> jcb_NoiDi;
    private com.toedter.calendar.JDateChooser jdc_NgayDi;
    private com.toedter.calendar.JDateChooser jdc_NgayVe;
    private javax.swing.JLabel lb_NgayDi;
    private javax.swing.JLabel lb_NgayVe;
    private javax.swing.JLabel lb_NoiDen;
    private javax.swing.JLabel lb_NoiDi;
    private javax.swing.JLabel lb_nl12;
    private javax.swing.JLabel lb_te212;
    private javax.swing.JLabel lb_titileHK;
    private javax.swing.JPanel pn_Content;
    private javax.swing.JPanel pn_ContentCb;
    private javax.swing.JPanel pn_ContentSec;
    private javax.swing.JPanel pn_ContentTop;
    private javax.swing.JPanel pn_NgayDi;
    private javax.swing.JPanel pn_NgayVe;
    private javax.swing.JPanel pn_NoiDen;
    private javax.swing.JPanel pn_NoiDi;
    private javax.swing.JPanel pn_PickSLHanhKhach;
    private javax.swing.JSpinner spn_ngl12;
    private javax.swing.JSpinner spn_te212;
    // End of variables declaration//GEN-END:variables
}
