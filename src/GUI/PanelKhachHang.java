package GUI;

import BUS.ImportExcel;
import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
//import BUS.BackUpData;
//import BUS.ImportExcel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;

/**
 *
 * @author duyli
 */
public class PanelKhachHang extends JPanel {
    
    private JPanel pnTitle = new JPanel();
    
    private JPanel pnMidContent = new JPanel();
    private JPanel pnMidContent2 = new JPanel();
    //private JPanel pnLeft = new JPanel();
    private JPanel pnBottomContent = new JPanel();
    private ArrayList<JTextField> txtList = new ArrayList<>();
    private static Font sgUI18 = new Font("Segoe UI", Font.BOLD, 15);
    private static Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private static Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
    //private ArrayList<KhachHangDTO> KHList;
    JLabel lbTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG");
    
    JTextField txt_maKH = new JTextField("Mã khách hàng...");
    JTextField txt_tenKH = new JTextField("Tên khách hàng...");
    JTextField txt_cmnd = new JTextField("CCCD...");
    JTextField txt_mail = new JTextField("Mail...");
    JTextField txt_sdt = new JTextField("Số điện thoại...");
    private JPanel pnMaKH = new JPanel();
    private JPanel pnTenKH = new JPanel();
    private JPanel pnCmnd = new JPanel();
    private JPanel pnGt = new JPanel();
    private JPanel pnTim = new JPanel();
    private JPanel pnMail = new JPanel();
    private JPanel pnSdt = new JPanel();
    
    JButton btn_tim = new JButton("Tìm Kiếm");
    JButton btn_thoattim = new JButton("Thoát Tìm");
    JButton btn_them= new JButton("THÊM");
    JComboBox gioitinh;
    String gt[] = {"Giới tính", "Nam", "Nữ"};
    private JTable jt;
    private JScrollPane scpn = new JScrollPane();
    JButton btnXuatFile = new JButton("Xuất File");
    JButton btnImport = new JButton("Chọn File");
    
    public PanelKhachHang() {
        
        initComponents();
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    int SelectRow = jt.getSelectedRow();
                    String maKH = jt.getValueAt(jt.getSelectedRow(), 1).toString();
                    String nameKH = jt.getValueAt(jt.getSelectedRow(), 2).toString();
                    String cmnd = jt.getValueAt(jt.getSelectedRow(), 3).toString();
                    String gtinh = jt.getValueAt(jt.getSelectedRow(), 4).toString();
                    String nsinh = jt.getValueAt(jt.getSelectedRow(), 5).toString();
                    String sdt = jt.getValueAt(jt.getSelectedRow(), 6).toString();
                    String mail = jt.getValueAt(jt.getSelectedRow(), 7).toString();
                    try {
                        new InfoKhachHang(maKH, nameKH, cmnd, gtinh, sdt, mail,nsinh, jt, SelectRow);
                    } catch (ParseException ex) {
                        Logger.getLogger(PanelKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    public PanelKhachHang(int x) {
        
        initComponents();
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    int SelectRow = jt.getSelectedRow();
                    String maKH = jt.getValueAt(jt.getSelectedRow(), 1).toString();
                    String nameKH = jt.getValueAt(jt.getSelectedRow(), 2).toString();
                    String cmnd = jt.getValueAt(jt.getSelectedRow(), 3).toString();
                    String gtinh = jt.getValueAt(jt.getSelectedRow(), 4).toString();
                    String nsinh = jt.getValueAt(jt.getSelectedRow(), 5).toString();
                    String sdt = jt.getValueAt(jt.getSelectedRow(), 6).toString();
                    String mail = jt.getValueAt(jt.getSelectedRow(), 7).toString();
                    try {
                        new InfoKhachHang(maKH, nameKH, cmnd, gtinh, sdt, mail,nsinh, jt, SelectRow,1);
                    } catch (ParseException ex) {
                        Logger.getLogger(PanelKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    public void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        pnTitle.setPreferredSize(new Dimension(100, 40));
        
        pnMidContent.setPreferredSize(new Dimension(10, 30));
        pnMidContent2.setPreferredSize(new Dimension(10, 30));
        pnBottomContent.setPreferredSize(new Dimension(100, 600));
        
        this.add(pnTitle);
        this.add(pnMidContent);
        this.add(pnMidContent2);
        this.add(pnBottomContent);
        
        lbTitle.setFont(sgUI18b);
        pnTitle.add(lbTitle);
        
        jt = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        loaddata();
        
        scpn.setViewportView(jt);
        scpn = new JScrollPane(jt);
        
        pnBottomContent.setLayout(new BorderLayout());
        
        pnBottomContent.add(scpn, BorderLayout.CENTER);
        
        pnMidContent.setLayout(new BoxLayout(pnMidContent, BoxLayout.X_AXIS));
        
        pnMidContent.setLayout(new GridLayout(1, 5, 5, 2));
        
        pnMidContent2.setLayout(new BorderLayout());
        pnMidContent2.setBackground(Color.WHITE);
        //pnMidContent2.setLayout(new GridLayout(1, 5, 5, 2));
        
        
        pnMidContent.add(pnMaKH);
        pnMaKH.setBorder(new EmptyBorder(0, 8, 0, 0));
        pnMaKH.setLayout(new BorderLayout());
        pnMaKH.add(txt_maKH, BorderLayout.CENTER);
        txt_maKH.setMargin(new Insets(5, 10, 5, 10));
        pnMaKH.setFont(sgUI13);
        
        pnMidContent.add(pnTenKH);
        pnTenKH.setLayout(new BorderLayout());
        pnTenKH.add(txt_tenKH, BorderLayout.CENTER);
        txt_tenKH.setMargin(new Insets(5, 10, 5, 10));
        pnTenKH.setFont(sgUI13);
        
        pnMidContent.add(pnCmnd);
        pnCmnd.setLayout(new BorderLayout());
        pnCmnd.add(txt_cmnd, BorderLayout.CENTER);
        txt_cmnd.setMargin(new Insets(5, 10, 5, 10));
        pnCmnd.setFont(sgUI13);
        
        pnMidContent.add(pnSdt);
        pnSdt.setLayout(new BorderLayout());
        pnSdt.add(txt_sdt, BorderLayout.CENTER);
        txt_sdt.setMargin(new Insets(5, 10, 5, 10));
        pnMail.setFont(sgUI13);
        
        pnMidContent.add(pnMail);
        pnMail.setLayout(new BorderLayout());
        pnMail.add(txt_mail, BorderLayout.CENTER);
        txt_mail.setMargin(new Insets(5, 10, 5, 10));
        pnMail.setFont(sgUI13);
        
        
        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn đường dẫn và tên file lưu");

                // Thiết lập bộ lọc cho file Excel
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
                fileChooser.setFileFilter(filter);

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    // Lấy đường dẫn và tên file được chọn bởi người dùng
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                    new ImportExcel().ImportExcel_KhachHang(filePath);
                    loaddata();
                }
            }
        });
        gioitinh = new JComboBox(gt);
        pnMidContent.add(pnGt);
        pnGt.setLayout(new BorderLayout());
        pnGt.add(gioitinh, BorderLayout.CENTER);
        gioitinh.setFont(sgUI13);
        
        txt_maKH.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_maKH.getText().equals("Mã khách hàng...")) {
                    txt_maKH.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_maKH.getText().trim().length() == 0) {
                    txt_maKH.setText("Mã khách hàng...");
                }
            }
        });
        txt_tenKH.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_tenKH.getText().equals("Tên khách hàng...")) {
                    txt_tenKH.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_tenKH.getText().trim().length() == 0) {
                    txt_tenKH.setText("Tên khách hàng...");
                }
            }
        });
        txt_cmnd.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_cmnd.getText().equals("CCCD...")) {
                    txt_cmnd.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_cmnd.getText().trim().length() == 0) {
                    txt_cmnd.setText("CCCD...");
                }
            }
            
        });
        txt_mail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_mail.getText().equals("Mail...")) {
                    txt_mail.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_mail.getText().trim().length() == 0) {
                    txt_mail.setText("Mail...");
                }
            }
            
        });
        txt_sdt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_sdt.getText().equals("Số điện thoại...")) {
                    txt_sdt.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_sdt.getText().trim().length() == 0) {
                    txt_sdt.setText("Số điện thoại...");
                }
            }
            
        });
        
        ImageIcon iconTim = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/IconFind.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btn_tim.setIcon(iconTim);
        btn_tim.setFont(sgUI18);
        pnMidContent.add(btn_tim);
        
        //pnLeft.setLayout(new GridLayout(1, 3));
        //pnLeft.add(btn_tim);
        //pnLeft.add(btn_thoattim);
//        pnLeft.add(btn_them);
        //pnLeft.add(btnXuatFile);
//        pnLeft.add(btnImport);
        
        
        pnMidContent2.add(btnXuatFile, BorderLayout.WEST);
        //pnMidContent2.add(pnLeft, BorderLayout.EAST);
        ImageIcon iconThoat = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/IconReset.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btn_thoattim.setIcon(iconThoat);
        btn_thoattim.setFont(sgUI18);     
        pnMidContent.add(btn_thoattim);
        
        ImageIcon iconThem = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/IconAdd.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btn_them.setIcon(iconThem);
        btn_them.setFont(sgUI18);     
        //pnMidContent.add(btn_them);
        
        
        //pnMidContent.add(btnXuatFile);
        //pnMidContent2.add(btnImport);
        
        ImageIcon iconFile = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/ex.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btnXuatFile.setIcon(iconFile);
        btnXuatFile.setFont(sgUI18);
        btnXuatFile.setFocusPainted(false);
        
        btnImport.setIcon(iconFile);
        btnImport.setFont(sgUI18);
        btnImport.setFocusPainted(false);
        
        btnXuatFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    JOptionPane.showMessageDialog(null, KhachHangBUS.xuatExcel(filePath+".xlsx"), "Thông báo", 1);
                try {
                    Desktop.getDesktop().open(new File(KhachHangBUS.pathExcel));
                } catch (IOException ex) {
                    Logger.getLogger(PanelVeBay.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                
            }
        });
        
        
        btn_them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddKhachHang add = new AddKhachHang(jt);
            }
        });
        
        btn_thoattim.addActionListener((ActionEvent e) -> {
            DefaultTableModel dm = (DefaultTableModel) jt.getModel();
            dm.setColumnCount(0);
            loaddata();
            txt_maKH.setText("Mã khách hàng...");
            txt_tenKH.setText("Tên khách hàng...");
            txt_cmnd.setText("CCCD...");
            txt_sdt.setText("Số điện thoại...");
            txt_mail.setText("Mail...");
            gioitinh.setSelectedIndex(0);
            
        });
        btn_tim.addActionListener((ActionEvent e) -> {
            ArrayList<KhachHangDTO> KHList = new ArrayList<>();
            
                KHList = new KhachHangBUS().load();
            
            if ((txt_maKH.getText().equals("Mã khách hàng...") || txt_maKH.getText().isBlank())
                    && (txt_tenKH.getText().equals("Tên khách hàng...") || txt_tenKH.getText().isBlank())
                    && (txt_mail.getText().equals("Mail...") || txt_mail.getText().isBlank())
                    && (txt_sdt.getText().equals("Số điện thoại...") || txt_sdt.getText().isBlank())
                    && (txt_cmnd.getText().equals("CCCD...") || txt_cmnd.getText().isBlank()) && gioitinh.getSelectedIndex() == 0) {
                
                JOptionPane.showMessageDialog(null, "Mời lựa chọn", "Thông báo", 0);
            } else {
                int check=0;
                if (find((txt_maKH.getText()))) {
                    
                    int i = 0;
                    for (i = 0; i < KHList.size(); i++) {
                        if (KHList.get(i).getMaKH().toLowerCase().contains(txt_maKH.getText().toLowerCase()) == false) {
                            KHList.remove(KHList.get(i));
                            i--;
                        }
                    }
                    
                } else if (find((txt_maKH.getText())) == false && txt_maKH.getText().equals("Mã khách hàng...") == false || txt_maKH.getText().isBlank()) {
                    check=1;
                    JOptionPane.showMessageDialog(null, "Mã khách hàng không tồn tại", "Thông báo", 0);
                }
                if (findName((txt_tenKH.getText()))) {
                    int i = 0;
                    for (i = 0; i < KHList.size(); i++) {
                        if (KHList.get(i).getTenKH().toLowerCase().contains(txt_tenKH.getText().toLowerCase()) == false) {
                            KHList.remove(KHList.get(i));
                            i--;
                        }
                    }
                } else if (findName((txt_tenKH.getText())) == false && txt_tenKH.getText().equals("Tên khách hàng...") == false || txt_tenKH.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Tên khách hàng không tồn tại", "Thông báo", 0);
                    check=1;
                }
                if (findCmnd(txt_cmnd.getText())) {
                    int i = 0;
                    for (i = 0; i < KHList.size(); i++) {
                        if (KHList.get(i).getCccd().contains(txt_cmnd.getText()) == false) {
                            KHList.remove(KHList.get(i));
                            i--;
                        }
                    }
                    
                } else if (findCmnd(txt_cmnd.getText()) == false && txt_cmnd.getText().equals("CCCD...") == false || txt_cmnd.getText().isBlank()) {
                    check=1;
                    JOptionPane.showMessageDialog(null, "CCCD không tồn tại", "Thông báo", 0);
                }
                if (findMail(txt_mail.getText())) {
                    int i = 0;
                    for (i = 0; i < KHList.size(); i++) {
                        if (KHList.get(i).getMail().toLowerCase().contains(txt_mail.getText().toLowerCase()) == false) {
                            KHList.remove(KHList.get(i));
                            i--;
                        }
                    }
                    
                } else if (findMail(txt_mail.getText()) == false && txt_mail.getText().equals("Mail...") == false || txt_mail.getText().isBlank()) {
                    check=1;
                    JOptionPane.showMessageDialog(null, "Mail không tồn tại", "Thông báo", 0);
                }
                if (findSdt(txt_sdt.getText())) {
                    int i = 0;
                    for (i = 0; i < KHList.size(); i++) {
                        if (KHList.get(i).getSdt().contains(txt_sdt.getText()) == false) {
                            KHList.remove(KHList.get(i));
                            i--;
                        }
                    }
                    
                } else if (findSdt(txt_sdt.getText()) == false && txt_sdt.getText().equals("Số điện thoại...") == false || txt_sdt.getText().isBlank()) {
                    check=1;
                    JOptionPane.showMessageDialog(null, "số điện thoại không tồn tại", "Thông báo", 0);
                }
                
                if (gioitinh.getSelectedIndex() == 1) {
                    int i = 0;
                    for (i = 0; i < KHList.size(); i++) {
                        if (KHList.get(i).getGioiTinh()==0) {
                            KHList.remove(KHList.get(i));
                            i--;
                        }
                    }
                    
                }
                if (gioitinh.getSelectedIndex() == 2) {
                    int i = 0;
                    for (i = 0; i < KHList.size(); i++) {
                        if (KHList.get(i).getGioiTinh()==1) {
                            KHList.remove(KHList.get(i));
                            i--;
                        }
                    }
                }
                if (check ==0){
                        DefaultTableModel dm = (DefaultTableModel) jt.getModel();
                    while (dm.getRowCount() > 0) {
                        dm.removeRow(0);
                        }
                    Object rowData[] = new Object[8];

                    for (int i = 0; i < KHList.size(); i++) {

                        rowData[0] = i + 1;
                        rowData[1] = KHList.get(i).getMaKH();
                        rowData[2] = KHList.get(i).getTenKH();
                        rowData[3] = KHList.get(i).getCccd();
                        if (KHList.get(i).getGioiTinh()==0){
                            rowData[4] = "Nữ";
                        }
                        else if(KHList.get(i).getGioiTinh()==1){
                            rowData[4] = "Nam";
                        }
                        
                        rowData[5] = KHList.get(i).getNgaySinh();
                        rowData[6] = KHList.get(i).getSdt();
                        rowData[7] = KHList.get(i).getMail();
                        dm.addRow(rowData);

                        }
                }
                
            }
        });
    }
    
    public boolean find(String a) {
        ArrayList<KhachHangDTO> KHList = new ArrayList<>();
        
            KHList = new KhachHangBUS().load();
        String b=a.toLowerCase();
        for (int i = 0; i < KHList.size(); i++) {
            String str1=KHList.get(i).getMaKH().toLowerCase();
            if (str1.contains(b) && KHList.get(i).getXuLy() == 1) {
                return true;
            }
        }
        return false;
    }
    
    public boolean findName(String a) {
        ArrayList<KhachHangDTO> KHList = new ArrayList<>();
        
            KHList = new KhachHangBUS().load();
        String b=a.toLowerCase();
        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getTenKH().toLowerCase().contains(a.toLowerCase()) && KHList.get(i).getXuLy() == 1) {
                return true;
            }
        }
        return false;
    }
    
    public boolean findCmnd(String a) {
        ArrayList<KhachHangDTO> KHList = new ArrayList<>();
        
            KHList = new KhachHangBUS().load();
        String b=a.toLowerCase();
        for (int i = 0; i < KHList.size(); i++) {
            String str1=KHList.get(i).getCccd().toLowerCase();
            if (str1.contains(b) && KHList.get(i).getXuLy() == 1) {
                return true;
            }
        }
        return false;
    }
    public boolean findMail(String a) {
        ArrayList<KhachHangDTO> KHList = new ArrayList<>();
        
            KHList = new KhachHangBUS().load();
        String b=a.toLowerCase();
        for (int i = 0; i < KHList.size(); i++) {
            String str1=KHList.get(i).getMail().toLowerCase();
            if (str1.contains(b) && KHList.get(i).getXuLy() == 1) {
                return true;
            }
        }
        return false;
    }
    public boolean findSdt(String a) {
        ArrayList<KhachHangDTO> KHList = new ArrayList<>();
        
            KHList = new KhachHangBUS().load();
        String b=a.toLowerCase();
        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getSdt().contains(a) && KHList.get(i).getXuLy() == 1) {
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
    
    public void loaddata() {
        ArrayList<KhachHangDTO> KHList = new ArrayList<>();
        
            KHList = new KhachHangBUS().load();
        
        DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
            dm.setColumnCount(0);
        }
        dm.addColumn("STT");
        dm.addColumn("Mã khách hàng");
        dm.addColumn("Tên khách hàng");
        dm.addColumn("CCCD");
        dm.addColumn("Giới tính");
        dm.addColumn("Ngày sinh");
        dm.addColumn("SĐT");
        dm.addColumn("Mail");
        jt.setModel(dm);
        int i = 1;
        
        for (KhachHangDTO x : KHList) {
            String gt = null;
            if (x.getGioiTinh()==0){
                    gt = "Nữ";
                }
                else if(x.getGioiTinh()==1){
                    gt = "Nam";
                }
            Object[] data = {i, x.getMaKH(), x.getTenKH(), x.getCccd(), gt , x.getNgaySinh(), x.getSdt(), x.getMail()};
            dm.addRow(data);
            i++;
        }
        
        jt.setShowGrid(false);
        jt.setIntercellSpacing(new Dimension(0, 0));
        jt.setRowHeight(30);
        jt.getColumnModel().getColumn(jt.getColumnModel().getColumnIndex("STT")).setPreferredWidth(1);
        jt.getColumnModel().getColumn(1).setPreferredWidth(50);
        jt.getTableHeader().setPreferredSize(new Dimension(1, 32));
        jt.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                JLabel lb = (JLabel) c;
                if (column == 0) {
                    lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#DDDDDD")));
                    lb.setBackground(Color.decode("#97FFFF"));
                } else {
                    lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
                }
                lb.setForeground(Color.black);
                lb.setFont(sgUI13);
                lb.setHorizontalAlignment(JLabel.CENTER);
                
                if (isSelected) {
                    lb.setBackground(Color.decode("#D3D3D3"));
                } else {
                    if (row % 2 == 1) {
                        lb.setBackground(Color.decode("#FDFDFD"));
                    } else {
                        lb.setBackground(Color.white);
                    }
                }
                
                return lb;
            }
        };
        for (int j = 0; j < jt.getColumnCount(); j++) {
            jt.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
        }
        jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    public static void loaddata(JTable jt) {
        ArrayList<KhachHangDTO> KHList = new ArrayList<>();
        
            KHList = new KhachHangBUS().load();
        
        DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0); //xóa table để update table mới
            dm.setColumnCount(0);
        }
        dm.addColumn("STT");
        dm.addColumn("Mã khách hàng");
        dm.addColumn("Tên khách hàng");
        dm.addColumn("CCCD");
        dm.addColumn("Giới tính");
        dm.addColumn("Ngày sinh");
        dm.addColumn("SĐT");
        dm.addColumn("Mail");
        jt.setModel(dm);
        int i = 1;
        for (KhachHangDTO x : KHList) {
            String gt = null;
            if (x.getGioiTinh()==0){
                    gt = "Nữ";
                }
                else if(x.getGioiTinh()==1){
                    gt = "Nam";
                }
            Object[] data = {i, x.getMaKH(), x.getTenKH(), x.getCccd(), gt, x.getNgaySinh(), x.getSdt(), x.getMail()};
            dm.addRow(data);
            i++;
        }
        jt.setShowGrid(false);
        jt.setIntercellSpacing(new Dimension(0, 0));
        jt.setRowHeight(30);
        jt.getColumnModel().getColumn(jt.getColumnModel().getColumnIndex("STT")).setPreferredWidth(1);
        jt.getColumnModel().getColumn(1).setPreferredWidth(50);
        jt.getTableHeader().setPreferredSize(new Dimension(1, 32));
        jt.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                JLabel lb = (JLabel) c;
                if (column == 0) {
                    lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#DDDDDD")));
                    lb.setBackground(Color.decode("#97FFFF"));
                } else {
                    lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
                }
                lb.setForeground(Color.black);
                lb.setFont(sgUI13);
                lb.setHorizontalAlignment(JLabel.CENTER);
                if (isSelected) {
                    lb.setBackground(Color.decode("#C0C0C0"));
                } else {
                    if (row % 2 == 1) {
                        lb.setBackground(Color.decode("#FDFDFD"));
                    } else {
                        lb.setBackground(Color.white);
                    }
                }
                return lb;
            }
        };
        for (int j = 0; j < jt.getColumnCount(); j++) {
            jt.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
        }
        jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    public void lightDark(int lightDark) {
        if (lightDark == 1) {
            Color black = new Color(51, 51, 51);
            pnTitle.setBackground(black);
            pnMidContent.setBackground(black);
            pnMidContent2.setBackground(black);
            pnBottomContent.setBackground(black);
            scpn.setBackground(black);
            jt.setBackground(black);
            jt.setBackground(black);
            lbTitle.setForeground(Color.white);
            jt.getTableHeader().setBackground(Color.decode("#528B8B"));
            gioitinh.setBackground(Color.white);
            btn_tim.setBackground(Color.decode("#BFEFFF"));
            btn_thoattim.setBackground(Color.decode("#BFEFFF"));
            pnBottomContent.setBorder(BorderFactory.createLineBorder(black, 10));
            btn_tim.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, black), new EmptyBorder(10, 10, 10, 10)));
            btn_thoattim.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 5, 0, 10, black), new EmptyBorder(10, 10, 10, 10)));
            pnMaKH.setBackground(black);
            btnXuatFile.setBackground(Color.decode("#BFEFFF"));
            btnXuatFile.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, black), new EmptyBorder(10, 10, 10, 10)));
            btnImport.setBackground(Color.decode("#BFEFFF"));
            btnImport.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, black), new EmptyBorder(10, 10, 10, 10)));
        } else {
            pnTitle.setBackground(Color.white);
            pnMidContent.setBackground(Color.white);
            pnMidContent2.setBackground(Color.white);
            pnBottomContent.setBackground(Color.white);
            scpn.setBackground(Color.white);
            jt.setBackground(Color.white);
            jt.setBackground(Color.white);
            lbTitle.setForeground(Color.black);
            jt.getTableHeader().setBackground(Color.decode("#79CDCD"));
            gioitinh.setBackground(Color.white);
            btn_tim.setBackground(Color.decode("#87CEFA"));
            btn_thoattim.setBackground(Color.decode("#87CEFA"));
            pnBottomContent.setBorder(BorderFactory.createLineBorder(Color.white, 10));
            btn_tim.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, Color.white), new EmptyBorder(10, 10, 10, 10)));
            btn_thoattim.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 5, 0, 10, Color.white), new EmptyBorder(10, 10, 10, 10)));
            pnMaKH.setBackground(Color.white);
            btnXuatFile.setBackground(Color.decode("#87CEFA"));
            btnXuatFile.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, Color.white), new EmptyBorder(10, 10, 10, 10)));
            btnImport.setBackground(Color.decode("#87CEFA"));
            btnImport.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, Color.white), new EmptyBorder(10, 10, 10, 10)));
        }
    }
}
