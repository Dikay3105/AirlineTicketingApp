/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.DuongBayBUS;
import BUS.ImportExcel;
import static DAO.DBConnect.getConnection;
import DTO.DuongBayDTO;
import DAO.DuongBayDAO;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Anh Huy
 */
public class DuongBayGUI extends javax.swing.JPanel {
    DuongBayDAO dao = new DuongBayDAO();
    String noiDi="";
    String noiDen="";
    
    String find="";
    /**
     * Creates new form DuongBayGUI
     */
    public DuongBayGUI() {
        initComponents();
        tbl_DuongBay.getColumnModel().getColumn(0).setPreferredWidth(1);
        tbl_DuongBay.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbl_DuongBay.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbl_DuongBay.getColumnModel().getColumn(3).setPreferredWidth(200);
        tbl_DuongBay.getColumnModel().getColumn(4).setPreferredWidth(100);
        fillTable();
        ArrayList<String> tp = getThanhPho();
        ArrayList<String> tp1 = getThanhPho1();
        for (String i : tp){
            cbo_noiDi.addItem(i);
        }
        for (String i : tp1){
            cbo_noiDen.addItem(i);
        }
        cbo_tim.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String selectedStatus = cbo_tim.getSelectedItem().toString();
        if (selectedStatus.equals("Đang hoạt động")) {
            //fillTable1();
        } else if (selectedStatus.equals("Ngừng hoạt động")) {
            //fillTable2();
        }
    }
});
        cbo_noiDi.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String noiDi = cbo_noiDi.getSelectedItem().toString();
        String noiDen = cbo_noiDen.getSelectedItem().toString();
        //fillTable6(noiDi,noiDen);
    }
});
        cbo_noiDen.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String noiDi = cbo_noiDi.getSelectedItem().toString();
        String noiDen = cbo_noiDen.getSelectedItem().toString();
        //fillTable6(noiDi,noiDen);
    }
});
//         cbo_noiDen.addActionListener(new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String noiDi = cbo_noiDi.getSelectedItem().toString();
//        String noiDen = cbo_noiDen.getSelectedItem().toString();
//        //fillTable4(noiDi, noiDen);
//    }
//});
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txt_maDB = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        cbo_tim = new javax.swing.JComboBox<>();
        btn_tim = new javax.swing.JButton();
        spn_thoiGian = new javax.swing.JSpinner();
        spn_thoiGian1 = new javax.swing.JSpinner();
        cbo_noiDi = new javax.swing.JComboBox<>();
        cbo_noiDen = new javax.swing.JComboBox<>();
        spn_thoiGianphut = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spn_thoiGian1phut = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DuongBay = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH MỤC ĐƯỜNG BAY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 204, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Xuất File");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 204, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Chọn File");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txt_maDB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_maDB.setForeground(new java.awt.Color(102, 102, 102));
        txt_maDB.setText("Mã đường bay...");
        txt_maDB.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_maDBCaretUpdate(evt);
            }
        });
        txt_maDB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_maDBFocusGained(evt);
            }
        });

        jButton3.setText("Thoát tìm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbo_tim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trạng thái", "Đang hoạt động", "Ngừng hoạt động", " " }));

        btn_tim.setText("Tìm");
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });

        spn_thoiGian.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        spn_thoiGian1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        jLabel1.setText("h:");

        jLabel2.setText("h:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(txt_maDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbo_noiDi, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cbo_noiDen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spn_thoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spn_thoiGianphut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(spn_thoiGian1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spn_thoiGian1phut, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_tim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(31, 31, 31)
                        .addComponent(jButton5)))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maDB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tim)
                    .addComponent(spn_thoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_thoiGian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_noiDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_noiDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_thoiGianphut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(spn_thoiGian1phut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(33, 33, 33))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN ĐƯỜNG BAY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tbl_DuongBay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Đường bay", "Nơi Đi", "Nơi Đến", "Thời Gian Ước Tính", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_DuongBay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DuongBayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DuongBay);
        if (tbl_DuongBay.getColumnModel().getColumnCount() > 0) {
            tbl_DuongBay.getColumnModel().getColumn(0).setResizable(false);
            tbl_DuongBay.getColumnModel().getColumn(1).setResizable(false);
            tbl_DuongBay.getColumnModel().getColumn(2).setResizable(false);
            tbl_DuongBay.getColumnModel().getColumn(3).setResizable(false);
            tbl_DuongBay.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_DuongBayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DuongBayMouseClicked
//    int stt = tbl_DuongBay.rowAtPoint(evt.getPoint());
//    if(evt.getClickCount()==2){
//    DuongBayDTO duongBay = dao.getALL().get(stt); // Lấy thông tin hàng được chọn
//    SuaDuongBayGUI sua = new SuaDuongBayGUI(duongBay);
//    sua.setVisible(true);
//    }

    int stt = tbl_DuongBay.rowAtPoint(evt.getPoint());
    
    if (evt.getClickCount() == 2) {
        DuongBayDTO duongBay = dao.getALL().get(stt); 
        if (String.valueOf(duongBay.getXuLy()).equals("0")) {
                SuaDuongBayGUI1 gui = new SuaDuongBayGUI1(duongBay);
                gui.setVisible(true);
        } else {
            SuaDuongBayGUI sua = new SuaDuongBayGUI(duongBay);
            sua.setVisible(true);
        }
    }
    }//GEN-LAST:event_tbl_DuongBayMouseClicked
            
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*  DuongBayDTO db = getModel();
        if (dao.insert(db)>0){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillTable();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }*/
       ThemDuongBayGUI them = new ThemDuongBayGUI();
       them.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_maDBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_maDBFocusGained
       txt_maDB.setText("");
       txt_maDB.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_txt_maDBFocusGained

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn đường dẫn và tên file lưu");

                // Thiết lập bộ lọc cho file Excel
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
                fileChooser.setFileFilter(filter);

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    // Lấy đường dẫn và tên file được chọn bởi người dùng
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                    // Kiểm tra nếu tệp đã tồn tại
                    if (new File(filePath).exists()) {
                        int option = JOptionPane.showConfirmDialog(null, "Tệp đã tồn tại. Bạn có muốn ghi đè lên nó?", "Xác nhận ghi đè", JOptionPane.YES_NO_OPTION);
                        if (option != JOptionPane.YES_OPTION) {
                            return; // Người dùng không muốn ghi đè, thoát khỏi phương thức
                        }
                    }
                    JOptionPane.showMessageDialog(null, DuongBayBUS.xuatExcel(filePath+".xlsx"), "Thông báo", 1);
                try {
                    Desktop.getDesktop().open(new File(DuongBayBUS.pathExcel));
                } catch (IOException ex) {
                    Logger.getLogger(PanelVeBay.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       txt_maDB.setText("Mã đường bay...");
       //txt_noiDi.setText("Nơi đi...");
       cbo_noiDi.setSelectedItem("Chọn tỉnh đi");
       cbo_noiDen.setSelectedItem("Chọn tỉnh đến");
       cbo_tim.setSelectedItem("Trạng thái");
       //txt_noiDen.setText("Nơi đến...");
       spn_thoiGian.setValue(0);
       spn_thoiGian1.setValue(0);
       txt_maDB.setForeground(new Color(102, 102, 102));
       fillTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed
//       int gioBatDau = (int) spn_thoiGian.getValue();
//       int phutBatDau = (int) spn_thoiGianphut.getValue();
//       int gioSau = (int) spn_thoiGian1.getValue();
//       int phutSau = (int) spn_thoiGian1phut.getValue();
//        fillTable3(gioBatDau, phutBatDau, gioSau, phutSau);
//        String noiDi = cbo_noiDi.getSelectedItem().toString();
//        String noiDen = cbo_noiDen.getSelectedItem().toString();
//        String trangThai= cbo_tim.getSelectedItem().toString();
//        String selectedStatus = cbo_tim.getSelectedItem().toString();
//        int gioBatDau = (int) spn_thoiGian.getValue();
//        int phutBatDau = (int) spn_thoiGianphut.getValue();
//        int gioSau = (int) spn_thoiGian1.getValue();
//        int phutSau = (int) spn_thoiGian1phut.getValue();
//
//        if (!noiDi.isEmpty() && !noiDen.isEmpty()) {
//            // Tìm kiếm theo cả hai trường hợp nơi đi và nơi đến
//            fillTable8(noiDi, noiDen);
//        } else if (!noiDi.isEmpty()) {
//            // Tìm kiếm theo nơi đi
//            fillTable6(noiDi, "");
//        } else if (!noiDen.isEmpty()) {
//            // Tìm kiếm theo nơi đến
//            fillTable6("", noiDen);
//        }
//
//        // Kiểm tra trạng thái đã chọn
//        if (selectedStatus.equals("Đang hoạt động")) {
//            // Tìm kiếm với trạng thái là "Đang hoạt động"
//            fillTable1();
//        } else if (selectedStatus.equals("Ngừng hoạt động")) {
//            // Tìm kiếm với trạng thái là "Ngừng hoạt động"
//            fillTable2();
//        }
//        if (!noiDi.isEmpty() && !noiDen.isEmpty() && (selectedStatus.equals("Đang hoạt động") || selectedStatus.equals("Ngừng hoạt động"))) {
//            // Tìm kiếm với cả nơi đi, nơi đến, và trạng thái
//            fillTable9(noiDi, noiDen, trangThai); // Cập nhật fillTable6 để xử lý truy vấn cả nơi đi và nơi đến
//        }
//
//        // Kiểm tra giờ bắt đầu và giờ sau đã chọn
//        if (gioBatDau != 0 || phutBatDau != 0 || gioSau != 0 || phutSau != 0) {
//            // Tìm kiếm với thời gian được chọn
//            fillTable3(gioBatDau, phutBatDau, gioSau, phutSau);
//        }
String noiDi = cbo_noiDi.getSelectedItem().toString();
String noiDen = cbo_noiDen.getSelectedItem().toString();
String selectedStatus = cbo_tim.getSelectedItem().toString();
int gioBatDau = (int) spn_thoiGian.getValue();
int phutBatDau = (int) spn_thoiGianphut.getValue();
int gioSau = (int) spn_thoiGian1.getValue();
int phutSau = (int) spn_thoiGian1phut.getValue();
if (noiDi.equals("Chọn tỉnh đi")) {
    noiDi = "";
}
if (noiDen.equals("Chọn tỉnh đến")) {
    noiDen = "";
}
if (noiDi.isEmpty() && noiDen.isEmpty() && (selectedStatus.equals("Đang hoạt động") || selectedStatus.equals("Ngừng hoạt động"))) {
    // Nếu không chọn Nơi đi và Nơi đến, chỉ tìm kiếm theo Trạng thái
    if (selectedStatus.equals("Đang hoạt động")) {
        fillTable1();
    } else if (selectedStatus.equals("Ngừng hoạt động")) {
        fillTable2();
    }
} else {
    if (!noiDi.isEmpty() && !noiDen.isEmpty()) {
    
        fillTable8(noiDi, noiDen);
    } else if (!noiDi.isEmpty()) {
    
        fillTable6(noiDi, "");
    } else if (!noiDen.isEmpty()) {
        // Tìm kiếm theo nơi đến
        fillTable6("", noiDen);
    }

    if (!noiDi.isEmpty() && !noiDen.isEmpty() && selectedStatus.equals("Ngừng hoạt động")) {
        fillTable9(noiDi, noiDen);
    }
    if (!noiDi.isEmpty() && !noiDen.isEmpty() && selectedStatus.equals("Đang hoạt động")) {
        fillTable10(noiDi, noiDen);
    }
}

if (gioBatDau != 0 || phutBatDau != 0 || gioSau != 0 || phutSau != 0) {
    // Tìm kiếm với thời gian được chọn
    fillTable3(gioBatDau, phutBatDau, gioSau, phutSau);
}

    }//GEN-LAST:event_btn_timActionPerformed

    private void txt_maDBCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_maDBCaretUpdate
        find = txt_maDB.getText();
        fillTable7();
    }//GEN-LAST:event_txt_maDBCaretUpdate

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn đường dẫn và tên file lưu");

                // Thiết lập bộ lọc cho file Excel
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
                fileChooser.setFileFilter(filter);

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    // Lấy đường dẫn và tên file được chọn bởi người dùng
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                    new ImportExcel().ImportExcel_DuongBay(filePath);
                    fillTable();
                }
    }//GEN-LAST:event_jButton5ActionPerformed
public DuongBayDTO getModel(){
       
        DuongBayDTO db = new DuongBayDTO();
        db.setMaDuongBay("DB"+txt_maDB.getText());
        db.setNoiDi(cbo_noiDi.getSelectedItem().toString());
         db.setNoiDen(cbo_noiDen.getSelectedItem().toString());
        //db.setNoiDen(txt_noiDen.getText());
        //db.setThoiGianBay(txt_thoiGian.getText());
        db.setNoiNgoai(1);
        db.setXuLy(1);
        return db;
    }
public DuongBayDTO getModelUpdate(){
        
        DuongBayDTO db = new DuongBayDTO();
        db.setMaDuongBay(txt_maDB.getText());
        //db.setNoiDi(txt_noiDi.getText());
        //db.setNoiDen(txt_noiDen.getText());
        //db.setThoiGianBay(txt_thoiGian.getText());
        db.setNoiNgoai(1);
        db.setXuLy(1);
        return db;
    }
    public void setModel(DuongBayDTO db){
       txt_maDB.setText(db.getMaDuongBay());
      
    }
    public void fillTable(){
        DefaultTableModel tblmodel = (DefaultTableModel)tbl_DuongBay.getModel();
        tblmodel.setRowCount(0);
        int stt=1;
        for(DuongBayDTO db : dao.getALL()){
            Object data [] = new Object[6];
            data[0]=stt++;
            data[1]=db.getMaDuongBay();
            data[2]=db.getNoiDi();
            data[3]=db.getNoiDen();
            data[4]=db.getThoiGianBay();
            if (db.getXuLy() == 1) {
            data[5] = "Đang hoạt động";
            } else {
            data[5] = "Ngừng hoạt động";}
            tblmodel.addRow(data);
        }
    }
//    public boolean validateForm(){
//        if(txt_maDB.getText().isEmpty()|| txt_noiDen.getText().isEmpty()|| 
//                txt_noiDi.getText().isEmpty()
//                )
//            return false;
//          try {
//        int maDB = Integer.parseInt(txt_maDB.getText().trim());
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(this, "Mã đường bay phải là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        return false;
//    }
//    // Kiểm tra định dạng chữ cho trường nơi đi và đến
//    //if (!txt_noiDi.getText().matches("^[a-zA-Z ]*$")||!txt_noiDen.getText().matches("^[a-zA-Z ]*$")) {
//    //    JOptionPane.showMessageDialog(this, "Nơi đi hoặc nơi đến chỉ được chứa chữ cái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//    //    return false;
//    //}
//    // Kiểm tra định dạng số cho trường thời gian ước tính
//        return true;
//    }
    public void showComfirmRemove(){
        int selectedRow = tbl_DuongBay.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl_DuongBay.getModel();
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chứ?", "Question", 2) == 0) {
            String maDB = (String) model.getValueAt(selectedRow, 1);
            if(dao.del(maDB)>1){
                JOptionPane.showMessageDialog(this, "Xoá thành công");
            }
            model.removeRow(selectedRow);
            fillTable1();
        }
    }
   public void fillTable1(){
        DefaultTableModel tblmodel = (DefaultTableModel)tbl_DuongBay.getModel();
        tblmodel.setRowCount(0);
        int stt=1;
        for(DuongBayDTO db : dao.getAllActive()){
            Object data [] = new Object[6];
            data[0]=stt++;
            data[1]=db.getMaDuongBay();
            data[2]=db.getNoiDi();
            data[3]=db.getNoiDen();
            data[4]=db.getThoiGianBay();
            if (db.getXuLy() == 1) {
            data[5] = "Đang hoạt động";
            } else {
            data[5] = "Ngừng hoạt động";}
            tblmodel.addRow(data);
        }
    }
   
    public void fillTable2(){
        DefaultTableModel tblmodel = (DefaultTableModel)tbl_DuongBay.getModel();
        tblmodel.setRowCount(0);
        int stt=1;
        for(DuongBayDTO db : dao.getAllUnActive()){
            Object data [] = new Object[6]; 
            data[0]=stt++;
            data[1]=db.getMaDuongBay();
            data[2]=db.getNoiDi();
            data[3]=db.getNoiDen();
            data[4]=db.getThoiGianBay();
            if (db.getXuLy() == 1) {
            data[5] = "Đang hoạt động";
            } else {
            data[5] = "Ngừng hoạt động";}
            tblmodel.addRow(data);
        }
    }

    public void fillTable3(int gioBatDau, int phutBatDau, int gioKetThuc, int phutKetThuc) {
    DefaultTableModel tblmodel = (DefaultTableModel) tbl_DuongBay.getModel();
    tblmodel.setRowCount(0);
    int stt = 1;
    
    for (DuongBayDTO db : dao.getALL()) {
        Object data[] = new Object[6];
        data[0] = stt++;
        data[1] = db.getMaDuongBay();
        data[2] = db.getNoiDi();
        data[3] = db.getNoiDen();
        data[4] = db.getThoiGianBay();
        
        String[] parts = db.getThoiGianBay().split(":");
        int gio = Integer.parseInt(parts[0]);
        int phut = Integer.parseInt(parts[1]);
     
        if ((gio > gioBatDau || (gio == gioBatDau && phut >= phutBatDau)) &&
            (gio < gioKetThuc || (gio == gioKetThuc && phut <= phutKetThuc))) {
            if (db.getXuLy() == 1) {
                data[5] = "Đang hoạt động";
            } else {
                data[5] = "Ngừng hoạt động";
            }
            tblmodel.addRow(data);
        }
    }
}

    public void fillTable4(String noiDi) {
    DefaultTableModel tblmodel = (DefaultTableModel) tbl_DuongBay.getModel();
    tblmodel.setRowCount(0);
    int stt = 1;
    for (DuongBayDTO db : dao.getNoiDi(noiDi)) {
            Object data[] = new Object[6];
            data[0] = stt++;
            data[1] = db.getMaDuongBay();
            data[2] = db.getNoiDi();
            data[3] = db.getNoiDen();
            data[4] = db.getThoiGianBay();
            if (db.getXuLy() == 1) {
                data[5] = "Đang hoạt động";
            } else {
                data[5] = "Ngừng hoạt động";
            }
            tblmodel.addRow(data);
        }
    }
       public void fillTable5(String noiDen) {
    DefaultTableModel tblmodel = (DefaultTableModel) tbl_DuongBay.getModel();
    tblmodel.setRowCount(0);
    int stt = 1;
    for (DuongBayDTO db : dao.getNoiDen(noiDen)) {
        Object data[] = new Object[6];
        data[0] = stt++;
        data[1] = db.getMaDuongBay();
        data[2] = db.getNoiDi();
        data[3] = db.getNoiDen();
        data[4] = db.getThoiGianBay();
        if (db.getXuLy() == 1) {
            data[5] = "Đang hoạt động";
        } else {
            data[5] = "Ngừng hoạt động";
        }
        tblmodel.addRow(data);
         
    }
}
       public void fillTable6(String noiDi, String noiDen) {
    DefaultTableModel tblmodel = (DefaultTableModel) tbl_DuongBay.getModel();
    tblmodel.setRowCount(0);
    int stt = 1;
    List<DuongBayDTO> duongBays = dao.getDuongBayByNoiDiNoiDen(noiDi, noiDen); 
    for (DuongBayDTO db : duongBays) {
        Object data[] = new Object[6];
        data[0] = stt++;
        data[1] = db.getMaDuongBay();
        data[2] = db.getNoiDi();
        data[3] = db.getNoiDen();
        data[4] = db.getThoiGianBay();
        if (db.getXuLy() == 1) {
            data[5] = "Đang hoạt động";
        } else {
            data[5] = "Ngừng hoạt động";
        }
        tblmodel.addRow(data);
    }
}
     public void fillTable7(){
        DefaultTableModel tblmodel = (DefaultTableModel)tbl_DuongBay.getModel();
        tblmodel.setRowCount(0);
        int stt=1;
        for(DuongBayDTO db : dao.findDuongBayByID(find)){
            Object data [] = new Object[6];
            data[0]=stt++;
            data[1]=db.getMaDuongBay();
            data[2]=db.getNoiDi();
            data[3]=db.getNoiDen();
            data[4]=db.getThoiGianBay();
            if (db.getXuLy() == 1) {
            data[5] = "Đang hoạt động";
            } else {
            data[5] = "Ngừng hoạt động";}
            tblmodel.addRow(data);
        }
    }
     public void fillTable8(String noiDi, String noiDen) {
    DefaultTableModel tblmodel = (DefaultTableModel) tbl_DuongBay.getModel();
    tblmodel.setRowCount(0);
    int stt = 1;
    List<DuongBayDTO> duongBays = dao.getDuongBayByNoiDiNoiDen1(noiDi, noiDen); 
    for (DuongBayDTO db : duongBays) {
        Object data[] = new Object[6];
        data[0] = stt++;
        data[1] = db.getMaDuongBay();
        data[2] = db.getNoiDi();
        data[3] = db.getNoiDen();
        data[4] = db.getThoiGianBay();
        if (db.getXuLy() == 1) {
            data[5] = "Đang hoạt động";
        } else {
            data[5] = "Ngừng hoạt động";
        }
        tblmodel.addRow(data);
    }
}
    public void fillTable9(String noiDi, String noiDen){
        DefaultTableModel tblmodel = (DefaultTableModel)tbl_DuongBay.getModel();
        tblmodel.setRowCount(0);
        int stt=1;
        for(DuongBayDTO db : dao.getAllUnActiveByNoiDiNoiDen(noiDi, noiDen)){
            Object data [] = new Object[6]; 
            data[0]=stt++;
            data[1]=db.getMaDuongBay();
            data[2]=db.getNoiDi();
            data[3]=db.getNoiDen();
            data[4]=db.getThoiGianBay();
            if (db.getXuLy() == 1) {
            data[5] = "Đang hoạt động";
            } else {
            data[5] = "Ngừng hoạt động";}
            tblmodel.addRow(data);
        }
    }
    public void fillTable10(String noiDi, String noiDen){
        DefaultTableModel tblmodel = (DefaultTableModel)tbl_DuongBay.getModel();
        tblmodel.setRowCount(0);
        int stt=1;
        for(DuongBayDTO db : dao.getAllActiveByNoiDiNoiDen(noiDi, noiDen)){
            Object data [] = new Object[6]; 
            data[0]=stt++;
            data[1]=db.getMaDuongBay();
            data[2]=db.getNoiDi();
            data[3]=db.getNoiDen();
            data[4]=db.getThoiGianBay();
            if (db.getXuLy() == 1) {
            data[5] = "Đang hoạt động";
            } else {
            data[5] = "Ngừng hoạt động";}
            tblmodel.addRow(data);
        }
    }
    public ArrayList<String> getThanhPho(){
        ArrayList<String> tp = new ArrayList<>();
        String[] tp1={"Chọn tỉnh đi","Hà Giang","Cao Bằng","Lào Cai","Sơn La","Lai Châu","Bắc Kạn","Lạng Sơn","Tuyên Quang","Yên Bái","Thái Nguyên","Điện Biên","Phú Thọ","Vĩnh Phúc","Bắc Giang","Bắc Ninh","Hà Nội","Quảng Ninh","Hải Dương","Hải Phòng","Hòa Bình","Hưng Yên","Hà Nam","Thái Bình","Nam Định","Ninh Bình","Thanh Hóa","Nghệ An","Hà Tĩnh","Quảng Bình","Quảng Trị","Thừa Thiên Huế","Đà Nẵng","Quảng Nam","Quảng Ngãi","Kon Tum","Gia Lai","Bình Định","Phú Yên","Đắk Lắk","Khánh Hòa","Đắk Nông",	"Lâm Đồng",	"Ninh Thuận",	"Bình Phước",	"Tây Ninh",	"Bình Dương",	"Đồng Nai",	"Bình Thuận",	"Thành phố Hồ Chí Minh",	"Long An",	"Bà Rịa – Vũng Tàu",	"Đồng Tháp",	"An Giang",	"Tiền Giang",	"Vĩnh Long",	"Bến Tre",	"Cần Thơ",	"Kiên Giang",	"Trà Vinh",	"Hậu Giang",	"Sóc Trăng",	"Bạc Liêu",	"Cà Mau",
};
        for (String y: tp1){
            tp.add(y);
        }
         return tp;  
    }
    public ArrayList<String> getThanhPho1(){
        ArrayList<String> tp = new ArrayList<>();
        String[] tp1={"Chọn tỉnh đến","Hà Giang","Cao Bằng","Lào Cai","Sơn La","Lai Châu","Bắc Kạn","Lạng Sơn","Tuyên Quang","Yên Bái","Thái Nguyên","Điện Biên","Phú Thọ","Vĩnh Phúc","Bắc Giang","Bắc Ninh","Hà Nội","Quảng Ninh","Hải Dương","Hải Phòng","Hòa Bình","Hưng Yên","Hà Nam","Thái Bình","Nam Định","Ninh Bình","Thanh Hóa","Nghệ An","Hà Tĩnh","Quảng Bình","Quảng Trị","Thừa Thiên Huế","Đà Nẵng","Quảng Nam","Quảng Ngãi","Kon Tum","Gia Lai","Bình Định","Phú Yên","Đắk Lắk","Khánh Hòa","Đắk Nông",	"Lâm Đồng",	"Ninh Thuận",	"Bình Phước",	"Tây Ninh",	"Bình Dương",	"Đồng Nai",	"Bình Thuận",	"Thành phố Hồ Chí Minh",	"Long An",	"Bà Rịa – Vũng Tàu",	"Đồng Tháp",	"An Giang",	"Tiền Giang",	"Vĩnh Long",	"Bến Tre",	"Cần Thơ",	"Kiên Giang",	"Trà Vinh",	"Hậu Giang",	"Sóc Trăng",	"Bạc Liêu",	"Cà Mau",
};
        for (String y: tp1){
            tp.add(y);
        }
         return tp;  
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tim;
    private javax.swing.JComboBox<String> cbo_noiDen;
    private javax.swing.JComboBox<String> cbo_noiDi;
    private javax.swing.JComboBox<String> cbo_tim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spn_thoiGian;
    private javax.swing.JSpinner spn_thoiGian1;
    private javax.swing.JSpinner spn_thoiGian1phut;
    private javax.swing.JSpinner spn_thoiGianphut;
    public javax.swing.JTable tbl_DuongBay;
    public javax.swing.JTextField txt_maDB;
    // End of variables declaration//GEN-END:variables
}
