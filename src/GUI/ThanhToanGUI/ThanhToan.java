/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThanhToanGUI;
import BUS.VeBayBUS;
import DTO.ChiTietSuDungDV;
import DTO.KhachHangDTO;
import DTO.VeBayDTO;
import GUI.datve.MenuDatVe;
import GUI.datve.Pn_SelectDichVu;
import GUI.mainGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author Thanh Tran
 */
public class ThanhToan extends javax.swing.JFrame {
    public static ArrayList<ChiTietSuDungDV> listCT;
    private JTable jtb;
    int closeWin;
    private JScrollPane jScrollPane1 = new JScrollPane();
    /**
     * Creates new form ThanhToan
     */
   public ThanhToan(ArrayList<ChiTietSuDungDV> list, int close) {
        listCT = new ArrayList<>();
        closeWin=close;
        if(!listCT.isEmpty()){
            listCT.clear();
        }
        listCT=list;
        initComponents();
        init(listCT);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
        
       
    }

//    private void oneWay(){
//        OneWay a = new OneWay();
//        jPanel4.setLayout(new java.awt.BorderLayout());
//        jPanel4.removeAll();
//        jPanel4.add(a);
//        jPanel4.repaint();
//        jPanel4.revalidate();    }
//    
//    private void twoWay(){
//        TwoWay b = new TwoWay();
//        jPanel4.setLayout(new java.awt.BorderLayout());
//        jPanel4.removeAll();
//        jPanel4.add(b);
//        jPanel4.repaint();
//        jPanel4.revalidate();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        pn_table = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pn_ThanhToan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnVisa = new javax.swing.JButton();
        btnBank = new javax.swing.JButton();
        btnMomo = new javax.swing.JButton();
        btnCash = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMakh = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTenkh = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSex = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtTotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnDong = new javax.swing.JButton();
        btnTroVe = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pn_table.setBackground(new java.awt.Color(205, 228, 225));
        pn_table.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 0, 0, 0, new java.awt.Color(0, 204, 204)));
        pn_table.setPreferredSize(new java.awt.Dimension(550, 700));
        pn_table.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(205, 228, 225));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 95, 110));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Danh sách vé");
        jLabel2.setPreferredSize(new java.awt.Dimension(38, 104));
        pn_table.add(jLabel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(pn_table, java.awt.BorderLayout.WEST);

        pn_ThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        pn_ThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 0, 0, new java.awt.Color(0, 204, 204)));
        pn_ThanhToan.setPreferredSize(new java.awt.Dimension(900, 700));
        pn_ThanhToan.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 700));

        jPanel3.setBackground(new java.awt.Color(205, 228, 225));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 95, 110));
        jLabel1.setText("Chọn Hình Thức Thanh Toán");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Quý khách lựa chọn hình thức thanh toán dưới đây ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Thẻ tín dụng/Thẻ");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ghi nợ quốc tế");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ngân hàng nội địa");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ví điện tử");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Tiền mặt");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 95, 110)));
        mainPanel.setPreferredSize(new java.awt.Dimension(500, 321));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 16, new java.awt.Color(255, 255, 255)));
        jPanel5.setPreferredSize(new java.awt.Dimension(550, 100));
        jPanel5.setLayout(new java.awt.GridLayout(1, 4, 20, 20));

        btnVisa.setBackground(new java.awt.Color(255, 255, 204));
        btnVisa.setForeground(new java.awt.Color(255, 255, 255));
        btnVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/asset/Designbolts-Credit-Card-Payment-Visa.256.png"))); // NOI18N
        btnVisa.setBorder(null);
        btnVisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaActionPerformed(evt);
            }
        });
        jPanel5.add(btnVisa);

        btnBank.setBackground(new java.awt.Color(255, 255, 204));
        btnBank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/asset/15039800793398_napas_logo1.png"))); // NOI18N
        btnBank.setBorder(null);
        btnBank.setPreferredSize(new java.awt.Dimension(104, 78));
        btnBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBankActionPerformed(evt);
            }
        });
        jPanel5.add(btnBank);

        btnMomo.setBackground(new java.awt.Color(255, 255, 204));
        btnMomo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/asset/momo3.png"))); // NOI18N
        btnMomo.setBorder(null);
        btnMomo.setPreferredSize(new java.awt.Dimension(104, 97));
        btnMomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMomoActionPerformed(evt);
            }
        });
        jPanel5.add(btnMomo);

        btnCash.setBackground(new java.awt.Color(255, 255, 204));
        btnCash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/asset/Custom2-Icon-Design-Flatastic-11-Cash.512.png"))); // NOI18N
        btnCash.setBorder(null);
        btnCash.setPreferredSize(new java.awt.Dimension(104, 97));
        btnCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCashActionPerformed(evt);
            }
        });
        jPanel5.add(btnCash);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel19)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(49, 49, 49)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
        );

        pn_ThanhToan.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(0, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 820));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 95, 110));
        jLabel13.setText("Mã Khách Hàng");

        txtMakh.setEditable(false);
        txtMakh.setBackground(new java.awt.Color(255, 255, 255));
        txtMakh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMakh.setForeground(new java.awt.Color(255, 0, 0));
        txtMakh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMakh.setText("KH001");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 95, 110));
        jLabel14.setText("Họ và Tên");

        txtTenkh.setEditable(false);
        txtTenkh.setBackground(new java.awt.Color(255, 255, 255));
        txtTenkh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenkh.setForeground(new java.awt.Color(255, 0, 51));
        txtTenkh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTenkh.setText("Trần Đức Thanh");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 95, 110));
        jLabel15.setText("Giới Tính");

        txtSex.setEditable(false);
        txtSex.setBackground(new java.awt.Color(255, 255, 255));
        txtSex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSex.setForeground(new java.awt.Color(255, 0, 51));
        txtSex.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSex.setText("Nam");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 95, 110));
        jLabel16.setText("CMND/CCCD");

        txtCMND.setEditable(false);
        txtCMND.setBackground(new java.awt.Color(255, 255, 255));
        txtCMND.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCMND.setForeground(new java.awt.Color(255, 0, 51));
        txtCMND.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCMND.setText("060203000811");

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 95, 110));
        jLabel17.setText("Tổng Tiền");

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("3,456,000");
        txtTotal.setBorder(null);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("VND");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addGap(31, 31, 31)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnTroVe.setText("Trở về");
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(205, 228, 225));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel3.setBackground(new java.awt.Color(205, 228, 225));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 95, 110));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông Tin Thanh Toán");
        jPanel4.add(jLabel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenkh, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtMakh)
                            .addComponent(txtSex))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtMakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(161, 161, 161))
        );

        pn_ThanhToan.add(jPanel2, java.awt.BorderLayout.EAST);

        getContentPane().add(pn_ThanhToan, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaActionPerformed
        Visa visaPanel = new Visa();

        showForm(visaPanel);

    }//GEN-LAST:event_btnVisaActionPerformed

    private void btnBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBankActionPerformed
        Bank bankPanel = new Bank();
        showForm(bankPanel);
    }//GEN-LAST:event_btnBankActionPerformed

    private void btnMomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMomoActionPerformed
        Momo momoPanel = new Momo();
        showForm(momoPanel);
    }//GEN-LAST:event_btnMomoActionPerformed

    private void btnCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashActionPerformed
        Cash CashPanel = new Cash();
        showForm(CashPanel);
    }//GEN-LAST:event_btnCashActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed

        
        dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        Pn_SelectDichVu.lhd.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTroVeActionPerformed
    private void showForm(Component com) {
        mainPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    public static ArrayList<VeBayDTO> listVeBay;
    public static ArrayList<VeBayDTO> listVeBaydi;
    public static ArrayList<VeBayDTO> listVeBayve;
    public void init(ArrayList<ChiTietSuDungDV> listCT){
        btnDong.setBackground(Color.gray);
        btnTroVe.setBackground(Color.white);
        btnDong.setEnabled(false);
        jtb = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        listVeBay = new ArrayList<>();
        listVeBaydi = new ArrayList<>();
        listVeBayve = new ArrayList<>();
        tinhTong(listCT);
        if(!listVeBaydi.isEmpty()){
            listVeBaydi.clear();
        }
        
        if(!listVeBay.isEmpty()){
            listVeBay.clear();
        }
        listVeBaydi = createVeBaydi(listCT);
        listVeBay.addAll(listVeBaydi);
        if(!MenuDatVe.ma2c.equals("")){
            if(!listVeBayve.isEmpty()){
                listVeBayve.clear();
            }
            listVeBayve = createVeBayve(listCT);
            listVeBay.addAll(listVeBayve);
        }
        
        DefaultTableModel dm = (DefaultTableModel) jtb.getModel();
        dm.setColumnIdentifiers(new Object[]{
            "Mã vé", "Mã khách hàng", "Tên khách hàng", "Tiền vé", "Tiền dịch vụ", "Tổng tiền"
        });
        
        for (ChiTietSuDungDV x1 : listCT) {
            for(VeBayDTO y : listVeBaydi) {
                if(x1.getMaKH().equals(y.getMaKhachHang())){
                    Object[] data = { y.getMaVe(),x1.getMaKH(), x1.getTenKH(), x1.getTienVedi(), x1.getTienDVdi(), x1.getTongtiendi()};
                    dm.addRow(data);
                    
                }
            }
        }

        if(!MenuDatVe.ma2c.equals("")){
            for (ChiTietSuDungDV x2 : listCT) {
                for(VeBayDTO y : listVeBayve) {
                    if(x2.getMaKH().equals(y.getMaKhachHang())){
                        Object[] data = { y.getMaVe(),x2.getMaKH(), x2.getTenKH(), x2.getTienVeve() , x2.getTienDVve(), x2.getTongtienve()};
                        dm.addRow(data);
                    }            
                }       
            }
        }
        
        TableColumn columnDV0 = jtb.getColumnModel().getColumn(0);
        columnDV0.setPreferredWidth(10);
        TableColumn columnDV1 = jtb.getColumnModel().getColumn(1);
        columnDV1.setPreferredWidth(40);
        TableColumn columnDV2 = jtb.getColumnModel().getColumn(2);
        columnDV2.setPreferredWidth(50);
        TableColumn columnDV3 = jtb.getColumnModel().getColumn(3);
        columnDV3.setPreferredWidth(25);
        TableColumn columnDV4 = jtb.getColumnModel().getColumn(4);
        columnDV4.setPreferredWidth(25);
        TableColumn columnDV5 = jtb.getColumnModel().getColumn(5);
        columnDV5.setPreferredWidth(35);
        jScrollPane1.setViewportView(jtb);
        jScrollPane1.setPreferredSize(new Dimension(550,850));
        pn_table.add(jScrollPane1,BorderLayout.CENTER);    
        KhachHangDTO nv = MenuDatVe.KHlList.get(0);
        txtTotal.setText(totalThanhToan(listCT)+"");
        txtMakh.setText(nv.getMaKH());
        txtTenkh.setText(nv.getTenKH());
        txtCMND.setText(nv.getCccd());
//        txtNoidi.setText(Panel_TrangChu.tcb.getNoidi());
//        txtNoiden.setText(Panel_TrangChu.tcb.getNoiden());
        if(nv.getGioiTinh()==1){
            txtSex.setText("Nam");
        }else txtSex.setText("Nữ");
        
        
        
}
    public void tinhTong(ArrayList<ChiTietSuDungDV> list){
        for(ChiTietSuDungDV x :list){
            long tongdi = x.getTienDVdi()+x.getTienVedi();
            x.setTongtiendi(tongdi);
            long tongve = x.getTienDVve()+x.getTienVeve();
            x.setTongtienve(tongve);
        }
    }
    public long totalThanhToan(ArrayList<ChiTietSuDungDV> list){
        long result=0;
        for(ChiTietSuDungDV x :list){
           result+=(x.getTongtiendi()+x.getTongtienve());
        }
        return result;
    }
    public int countVe(){
        ArrayList<VeBayDTO> listVe = VeBayBUS.load();
        return listVe.size();
    }
    public ArrayList<VeBayDTO> createVeBaydi(ArrayList<ChiTietSuDungDV> list){
        ArrayList<VeBayDTO> listVeBay = new ArrayList<>();
        int count = list.size();
        int i=countVe();
        for(ChiTietSuDungDV x :list){
            if(i<=count+countVe()){
                i++;
                VeBayDTO vb = new VeBayDTO();
                vb.setMaVe("MV"+i);
                vb.setMaNhanVien(mainGUI.taiKhoan);
                vb.setMaKhachHang(x.getMaKH());
                vb.setMaChuyenBay(x.getMaChuyenBaydi());
                vb.setMaghe(x.getMaGhedi());
                vb.setXuLy(1);
                vb.setDoiGhe(1);
                vb.setGiaVe(x.getTienVedi());
                listVeBay.add(vb);
            }else break;
        }
        return listVeBay;
    }
    public ArrayList<VeBayDTO> createVeBayve (ArrayList<ChiTietSuDungDV> list){
        ArrayList<VeBayDTO> listVeBay = new ArrayList<>();
        int count = list.size();
        int j=countVe()+count;
        if(!MenuDatVe.ma2c.equals("")){
            for(ChiTietSuDungDV x :list){
                if(j<=2*count+countVe()){
                        j++;
                        VeBayDTO vb = new VeBayDTO();
                        vb.setMaVe("MV"+j);
                        vb.setMaNhanVien(mainGUI.taiKhoan);
                        vb.setMaKhachHang(x.getMaKH());
                        vb.setMaChuyenBay(x.getMaChuyenBayve());
                        vb.setMaghe(x.getMaGheve());
                        vb.setXuLy(1);
                        vb.setDoiGhe(1);
                        vb.setGiaVe(x.getTienVeve());
                        listVeBay.add(vb);
                }else break;
            }
        }
        return listVeBay;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBank;
    public static javax.swing.JButton btnCash;
    public static javax.swing.JButton btnDong;
    public static javax.swing.JButton btnMomo;
    public static javax.swing.JButton btnTroVe;
    public static javax.swing.JButton btnVisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pn_ThanhToan;
    private javax.swing.JPanel pn_table;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtMakh;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtTenkh;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    
}
