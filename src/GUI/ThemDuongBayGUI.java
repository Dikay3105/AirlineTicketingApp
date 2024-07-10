/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import DAO.DuongBayDAO;
import DTO.DuongBayDTO;
import GUI.DuongBayGUI;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author Anh Huy
 */
public class ThemDuongBayGUI extends javax.swing.JFrame {
    DuongBayDAO dao = new DuongBayDAO();
    /**
     * Creates new form ThemDuongBayGUI
     */
    public ThemDuongBayGUI() {
        initComponents();
        this.setLocationRelativeTo(this);
        ArrayList<String> tp = getThanhPho();
        ArrayList<String> tp1= getThanhPho1();
        for (String i : tp){
            cbo_noiDi.addItem(i);
        }
        for (String i : tp1){
            cbo_noiDen.addItem(i);
        }
        DuongBayDAO dao = new DuongBayDAO();
        int stt = dao.getSLDuongbay()+1;
        txt_maDB1.setEditable(false);
        txt_maDB1.setText("DB"+stt);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_maDB1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbo_noiDi = new javax.swing.JComboBox<>();
        cbo_noiDen = new javax.swing.JComboBox<>();
        spn_gio = new javax.swing.JSpinner();
        spn_phut = new javax.swing.JSpinner();
        spn_giay = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã đường bay");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nơi đi");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nơi đến");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Thời gian ước tính");

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Trở về");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        spn_gio.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        spn_phut.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        spn_giay.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_maDB1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbo_noiDen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_noiDi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spn_gio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spn_phut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spn_giay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(113, 113, 113))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maDB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbo_noiDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbo_noiDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spn_gio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_phut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_giay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Thêm đường bay");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(106, 106, 106))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        if(validateForm()){
//        DuongBayDTO db = getModel();
//        if (dao.insert(db)>0){
//            JOptionPane.showMessageDialog(this, "Thêm thành công");
//            fillTable();
//            this.dispose();
//        }else{
//            JOptionPane.showMessageDialog(this, "Thêm thất bại");
//        }}
//        cbo_noiDi.setSelectedItem("Hà Giang");
//        cbo_noiDen.setSelectedItem("Hà Giang");
//        txt_thoiGian1.setText("");
    // Lưu các giá trị ban đầu
String noiDiBanDau = cbo_noiDi.getSelectedItem().toString();
String noiDenBanDau = cbo_noiDen.getSelectedItem().toString();
int gioBanDau = (int) spn_gio.getValue();
int phutBanDau = (int) spn_phut.getValue();
int giayBanDau = (int) spn_giay.getValue();
String thoiGianBanDau = String.format("%02d:%02d:%02d", gioBanDau, phutBanDau, giayBanDau);

if (validateForm()) {
    // Tạo nội dung thông báo xác nhận dữ liệu đã nhập
    String message = "Dữ liệu đã được nhập:\n\n";
    message += "Nơi đi: " + noiDiBanDau + "\n";
    message += "Nơi đến: " + noiDenBanDau + "\n";
    message += "Thời gian: " + thoiGianBanDau + "\n";

    // Hiển thị thông báo xác nhận
    int confirmResult = JOptionPane.showConfirmDialog(this, message, "Xác nhận", JOptionPane.YES_NO_OPTION);
    if (confirmResult == JOptionPane.YES_OPTION) {
        DuongBayDTO db = getModel();
        if (dao.insert(db) > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillTable();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    } else {
        // Cho phép người dùng chỉnh sửa thông tin
        cbo_noiDi.setSelectedItem(noiDiBanDau);
        cbo_noiDen.setSelectedItem(noiDenBanDau);
        spn_gio.setValue(gioBanDau);
        spn_phut.setValue(phutBanDau);
        spn_giay.setValue(giayBanDau);
    }
    cbo_noiDi.setSelectedItem(noiDiBanDau);
    cbo_noiDen.setSelectedItem(noiDenBanDau);
    spn_gio.setValue(gioBanDau);
    spn_phut.setValue(phutBanDau);
    spn_giay.setValue(giayBanDau);
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

        public DuongBayDTO getModel(){
            DuongBayDTO db = new DuongBayDTO();
            DuongBayDAO dao = new DuongBayDAO();
            int stt=dao.getSLDuongbay();
            stt++;
            db.setMaDuongBay("DB"+stt);
            String noidi = cbo_noiDi.getSelectedItem().toString();
            db.setNoiDi(noidi);
            String noiden = cbo_noiDen.getSelectedItem().toString();
            db.setNoiDen(noiden);
            int gio = (int) spn_gio.getValue();
            int phut = (int) spn_phut.getValue();
            int giay = (int) spn_giay.getValue();
            String thoiGian = String.format("%02d:%02d:%02d", gio, phut, giay);
            db.setThoiGianBay(thoiGian);
            db.setNoiNgoai(1);
            db.setXuLy(1);
            return db;
        }
/*public DuongBayDTO getModelUpdate(){
        DuongBayDTO db = new DuongBayDTO();
        db.setMaDuongBay(txt_maDB1.getText());
        db.setNoiDi(txt_noiDi1.getText());
        db.setNoiDen(txt_noiDen1.getText());
        db.setThoiGianBay(txt_thoiGian1.getText());
        db.setNoiNgoai(1);
        db.setXuLy(1);
        return db;
    }*/
    public void setModel(DuongBayDTO db){
        txt_maDB1.setText(db.getMaDuongBay());
        //txt_noiDi1.setText(db.getNoiDi());
        //txt_noiDen1.setText(db.getNoiDen());
        String thoiGian = db.getThoiGianBay();
        String[] parts = thoiGian.split(":");
    if (parts.length == 3) {
        try {
            int gio = Integer.parseInt(parts[0]);
            int phut = Integer.parseInt(parts[1]);
            int giay = Integer.parseInt(parts[2]);
            spn_gio.setValue(gio);
            spn_phut.setValue(phut);
            spn_giay.setValue(giay);
        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
        }
    }
    }
    public void fillTable(){
        DuongBayGUI gui = new DuongBayGUI();
        DefaultTableModel tblmodel = (DefaultTableModel)gui.tbl_DuongBay.getModel();
        tblmodel.setRowCount(0);
        int stt=1;
        for(DuongBayDTO db : dao.getALL()){
            Object data [] = new Object[5];
            data[0]=stt++;
            data[1]=db.getMaDuongBay();
            data[2]=db.getNoiDi();
            data[3]=db.getNoiDen();
            data[4]=db.getThoiGianBay();
            tblmodel.addRow(data);
        }
    }
    public boolean validateForm(){
        /*if(txt_maDB1.getText().isEmpty()|| txt_noiDen1.getText().isEmpty()|| 
                txt_noiDi1.getText().isEmpty()||
                txt_thoiGian1.getText().isEmpty()
                )
            return false;*/
    // Kiểm tra định dạng chữ cho trường nơi đi và đến
    //if (!txt_noiDi.getText().matches("^[a-zA-Z ]*$")||!txt_noiDen.getText().matches("^[a-zA-Z ]*$")) {
    //    JOptionPane.showMessageDialog(this, "Nơi đi hoặc nơi đến chỉ được chứa chữ cái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    //    return false;
    //}
    // Kiểm tra định dạng số cho trường thời gian ước tính
    int gio = (int) spn_gio.getValue();
    int phut = (int) spn_phut.getValue();
    int giay = (int) spn_giay.getValue();
    String noiDi = cbo_noiDi.getSelectedItem().toString();
    String noiDen = cbo_noiDen.getSelectedItem().toString();
    if (noiDi.equals("Chọn tỉnh đi") || noiDen.equals("Chọn tỉnh đến")) {
            JOptionPane.showMessageDialog(null, "Mời bạn chọn đường bay.");
            return false;
        }
    if (noiDi.equals(noiDen)) {
       JOptionPane.showMessageDialog(this, "Nơi đi và nơi đến không thể giống nhau. Vui lòng chọn lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    if (isDuplicateRoute(noiDi, noiDen)) {
        JOptionPane.showMessageDialog(this, "Đường bay này đã tồn tại!");
        return false;
    }
     if (gio == 0 && phut == 0 && giay == 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập thời gian hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
        return true;
    }
    public boolean isDuplicateRoute(String noiDi, String noiDen) {
    List<DuongBayDTO> existingRoutes = dao.getRoutesByNoiDiNoiDen(noiDi, noiDen);
    return !existingRoutes.isEmpty();
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
    private javax.swing.JComboBox<String> cbo_noiDen;
    private javax.swing.JComboBox<String> cbo_noiDi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner spn_giay;
    private javax.swing.JSpinner spn_gio;
    private javax.swing.JSpinner spn_phut;
    public javax.swing.JTextField txt_maDB1;
    // End of variables declaration//GEN-END:variables
}
