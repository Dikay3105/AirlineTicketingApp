
package GUI;


import BUS.ChuyenBayBUS;
import BUS.ImportExcel;
import DTO.ChuyenBayDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class PanelChuyenBay2 extends JPanel{
    
    private JPanel pnTitle = new JPanel();
    
    private JPanel pnMidContent = new JPanel();
    private JPanel pnMid2Content = new JPanel();
    private JPanel pnBottomContent = new JPanel();
    
    private ArrayList<JTextField> txtList = new ArrayList<>();
    private static Font sgUI18 = new Font("Segoe UI", Font.BOLD, 15);
    private static Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private static Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
  Time time1= new Time();
    JLabel lbTitle = new JLabel("QUẢN LÝ CHUYẾN BAY");
    
    JTextField txt_maCB = new JTextField("Mã chuyến bay...");
    JTextField txt_maDB = new JTextField("Mã đường bay...");
    JTextField txt_mamb = new JTextField("Mã máy bay...");
    JTextField txt_gate = new JTextField("Gate...");
   
    JLabel lbFrom = new JLabel("Giờ:     ");
    
    private JPanel pnMaCB = new JPanel();
    private JPanel pnMaDB = new JPanel();
    private JPanel pnMaMB = new JPanel();
    private JPanel pnGio1 = new JPanel();
    private JPanel pnGio2 = new JPanel();
    private JPanel pnNgayDi = new JPanel();
    private JPanel pnGate = new JPanel();
    
    private JPanel pnNgay = new JPanel();
    private JLabel lbNgay = new JLabel("Ngày:    ");
    private JComboBox cbNgay = new JComboBox();

    private JPanel pnThang = new JPanel();
    private JLabel lbThang = new JLabel("Tháng:    ");
    private JComboBox cbThang = new JComboBox();

    private JPanel pnNam = new JPanel();
    private JLabel lbNam = new JLabel("Năm:    ");
    private JComboBox cbNam = new JComboBox();
    
    JButton btn_tim = new JButton("TÌM KIẾM");
    JButton btn_thoattim = new JButton("THOÁT TÌM");
    public JButton btn_them = new JButton("THÊM");
    public JButton btn_xuat = new JButton("XUẤT");
    
    public JTable jt;
    private JScrollPane scpn = new JScrollPane();
    
    public class Time extends JPanel {

        JSpinner gioSpinner;
        JSpinner phutSpinner;
        JLabel gioJLabel=new JLabel("h:");
        JLabel phutJLabel=new JLabel("p");

        public void init() {
            //spinner giờ
            SpinnerNumberModel gioModel = new SpinnerNumberModel(0, 0, 23, 1);
            gioSpinner = new JSpinner(gioModel);

            //spinner phút
            SpinnerNumberModel phutModel = new SpinnerNumberModel(0, 0, 59, 1);
            phutSpinner = new JSpinner(phutModel);
            //setBackground(Color.WHITE);
            add(gioSpinner);
            add(gioJLabel);
            add(phutSpinner);
            add(phutJLabel);

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
        
        public void LightDark(int lightdark) {
            if(lightdark==0) {
                this.setBackground(Color.white);
                gioJLabel.setForeground(Color.black);
                phutJLabel.setForeground(Color.black);
            } else {
                Color black = new Color(51, 51, 51);
                this.setBackground(black);
                gioJLabel.setForeground(Color.white);
                phutJLabel.setForeground(Color.white);
            }
            
        }

        public Time() {
            init();
        }

    }
    
    public PanelChuyenBay2() {
        
        initComponents();
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    int SelectRow = jt.getSelectedRow();
                    String maChuyenBay = jt.getValueAt(jt.getSelectedRow(), 1).toString();
                    String maDuongBay = jt.getValueAt(jt.getSelectedRow(), 2).toString();
                    String maMayBay = jt.getValueAt(jt.getSelectedRow(), 3).toString();
                    String gioBay = jt.getValueAt(jt.getSelectedRow(), 4).toString();
                    String ngayDi = jt.getValueAt(jt.getSelectedRow(), 5).toString();
                 //   String gioDelay = jt.getValueAt(jt.getSelectedRow(), 6).toString();
                    String gate = jt.getValueAt(jt.getSelectedRow(), 8).toString();
                    try {
                        new InfoChuyenBay(maChuyenBay, maDuongBay, maMayBay, gioBay, ngayDi, gate, jt, SelectRow);
                    } catch (ParseException ex) {
                        Logger.getLogger(PanelChuyenBay2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
    }
    
    public PanelChuyenBay2(int x) {
        
        initComponents();
        pnMidContent.remove(btn_them);
        pnMidContent.remove(btn_xuat);
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });
        
    }
 
    
    public void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        pnTitle.setPreferredSize(new Dimension(100, 40));
        
        pnMidContent.setPreferredSize(new Dimension(10, 30));
        pnMid2Content.setPreferredSize(new Dimension(10, 30));
        pnBottomContent.setPreferredSize(new Dimension(100, 600));
        
        this.add(pnTitle);
        this.add(pnMidContent);
        this.add(pnMid2Content);
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
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(10);
        pnMid2Content.setLayout(flowLayout);
        
        pnMidContent.add(pnMaCB);
        pnMaCB.setBorder(new EmptyBorder(0, 8, 0, 0));
        pnMaCB.setLayout(new BorderLayout());
        pnMaCB.add(txt_maCB, BorderLayout.CENTER);
        txt_maCB.setMargin(new Insets(5, 10, 5, 10));
        pnMaCB.setFont(sgUI13);
        
        pnMidContent.add(pnMaDB);
        pnMaDB.setLayout(new BorderLayout());
        pnMaDB.add(txt_maDB, BorderLayout.CENTER);
        txt_maDB.setMargin(new Insets(5, 10, 5, 10));
        pnMaDB.setFont(sgUI13);
        
        pnMidContent.add(pnMaMB);
        pnMaMB.setLayout(new BorderLayout());
        pnMaMB.add(txt_mamb, BorderLayout.CENTER);
        txt_mamb.setMargin(new Insets(5, 10, 5, 10));
        pnMaMB.setFont(sgUI13);
        
        pnMidContent.add(pnGate);
        pnGate.setLayout(new BorderLayout());
        pnGate.add(txt_gate, BorderLayout.CENTER);
        txt_gate.setMargin(new Insets(5, 10, 5, 10));
        pnGate.setFont(sgUI13);
        
        pnMid2Content.add(pnGio1);
        pnGio1.setLayout(new BorderLayout());
        
        pnGio1.add(lbFrom, BorderLayout.WEST);
        pnGio1.add(time1, BorderLayout.CENTER);
        pnGio1.setFont(sgUI13);
        

        
        pnMid2Content.add(pnNam);

        pnNam.setLayout(new BorderLayout());
        pnNam.add(lbNam, BorderLayout.WEST);
        pnNam.add(cbNam, BorderLayout.CENTER);
        pnMid2Content.add(pnThang);
        pnThang.setLayout(new BorderLayout());
        pnThang.add(lbThang, BorderLayout.WEST);
        pnThang.add(cbThang, BorderLayout.CENTER);
        pnMid2Content.add(pnNgay);
        pnNgay.setLayout(new BorderLayout());
        pnNgay.add(lbNgay, BorderLayout.WEST);
        pnNgay.add(cbNgay, BorderLayout.CENTER);
        cbNam.removeAllItems();
        cbNam.addItem("Chọn năm");
        cbThang.addItem("Chọn tháng");
        cbNgay.addItem("Chọn ngày");

        for (int i = 1; i <= 31; i++) {
            cbNgay.addItem("Ngày " + i);
        }

        for (int i = 1; i <= 12; i++) {
            cbThang.addItem("Tháng " + i);
        }
        
        cbNam.addItem("Năm " + 2023);
        cbNam.addItem("Năm " + 2024);
        
        
//        pnMid2Content.add(pnNgayDi);    
//        pnNgayDi.setLayout(new BorderLayout());
//        pnNgayDi.add(lbNgaydi,BorderLayout.WEST);
//        pnNgayDi.add(txtNgayDi, BorderLayout.CENTER);
//        txtNgayDi.setFont(sgUI13);
        
        
        
/*
        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser("src\\GUI\\excel");
                fc.showDialog(null, "Open");
                try {
                    File file = fc.getSelectedFile();
                    ImportExcel ie = new ImportExcel();
                    ie.ImportExcel_KhachHang(file.getPath());
                    loaddata();
                } catch (Exception ex) {
                }
            }
        });
*/        
 
        
        txt_maCB.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_maCB.getText().equals("Mã chuyến bay...")) {
                    txt_maCB.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_maCB.getText().trim().length() == 0) {
                    txt_maCB.setText("Mã chuyến bay...");
                }
            }
        });
        txt_maDB.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_maDB.getText().equals("Mã đường bay...")) {
                    txt_maDB.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_maDB.getText().trim().length() == 0) {
                    txt_maDB.setText("Mã đường bay...");
                }
            }
        });
        txt_mamb.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_mamb.getText().equals("Mã máy bay...")) {
                    txt_mamb.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_mamb.getText().trim().length() == 0) {
                    txt_mamb.setText("Mã máy bay...");
                }
            }
            
        });
        txt_gate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_gate.getText().equals("Gate...")) {
                    txt_gate.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_gate.getText().trim().length() == 0) {
                    txt_gate.setText("Gate...");
                }
            }
            
        });
        
    //    ImageIcon iconTim = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/IconFind.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    //    btn_tim.setIcon(iconTim);
        btn_tim.setFont(sgUI18);
        btn_tim.setBackground(Color.CYAN);
        pnMidContent.add(btn_tim);
     //   ImageIcon iconThoat = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/IconReset.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
     //   btn_thoattim.setIcon(iconThoat);
        btn_thoattim.setFont(sgUI18);
        btn_thoattim.setBackground(Color.CYAN);
        pnMidContent.add(btn_thoattim);
        
        btn_them.setFont(sgUI18);
        btn_them.setBackground(Color.CYAN);
        
        btn_xuat.setFont(sgUI18);
        btn_xuat.setBackground(Color.CYAN);
        
        pnMidContent.add(btn_them);
        pnMidContent.add(btn_xuat);
        
        
        
        
    /*    
        btnXuatFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BackUpData bk = new BackUpData();
                try {
                    String path = System.getProperty("user.dir") + "\\src\\GUI\\excel\\BackUpData_KhachHang.xlsx";
                    bk.backup_KhachHang(path);
                    JOptionPane.showMessageDialog(null, "Xuất file thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Xuất file không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
       
       */ 
    btn_them.addActionListener(new ActionListener() {
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

                    new ImportExcel().ImportExcel_ChuyenBay(filePath);
                    rsTable();
                }

            }
            
        });
    
    btn_xuat.addActionListener(new ActionListener() {
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
                    JOptionPane.showMessageDialog(null, ChuyenBayBUS.xuatExcel(filePath+".xlsx"), "Thông báo", 1);
                try {
                    Desktop.getDesktop().open(new File(ChuyenBayBUS.pathExcel));
                } catch (IOException ex) {
                    Logger.getLogger(PanelVeBay.class.getName()).log(Level.SEVERE, null, ex);
                }
                }

            }
            
        });
    
         
        btn_thoattim.addActionListener((ActionEvent e) -> {
//            DefaultTableModel dm = (DefaultTableModel) jt.getModel();
//            dm.setColumnCount(0);
//            loaddata();
            txt_maCB.setText("Mã chuyến bay...");
           txt_maDB.setText("Mã đường bay...");
            txt_mamb.setText("Mã máy bay...");
            txt_gate.setText("Gate...");
            time1.reset();
            //time2.reset();
            //txtNgayDi.setDate(null);
            cbNam.setSelectedIndex(0);
            cbNgay.setSelectedIndex(0);
            cbThang.setSelectedIndex(0);
            rsTable();
            //loaddata();
        });
        
        
        btn_tim.addActionListener((ActionEvent e) -> {
            ArrayList<ChuyenBayDTO> CBList = new ArrayList<>();
            CBList = new ChuyenBayBUS().load();
            
            if ((txt_maCB.getText().equals("Mã chuyến bay...") || txt_maCB.getText().isBlank())
                    && (txt_maDB.getText().equals("Mã đường bay...") || txt_maDB.getText().isBlank())
                    && (txt_mamb.getText().equals("Mã máy bay...") || txt_mamb.getText().isBlank()) 
                    && (txt_gate.getText().equals("Gate...") || txt_gate.getText().isBlank())
                   // && txtNgayDi.getDate()==null 
                    && cbNam.getSelectedIndex()==0 &&cbThang.getSelectedIndex()==0 && cbNgay.getSelectedIndex()==0
                    &&(time1.gioSpinner.getValue().toString().equals("0") && time1.phutSpinner.getValue().toString().equals("0")))
            {
                
                JOptionPane.showMessageDialog(null, "Mời lựa chọn", "Thông báo", 0);
            } else {
                int check=0;
                if (findmaCB((txt_maCB.getText()))) {
                    
                    int i = 0;
                    for (i = 0; i < CBList.size(); i++) {
                        if (CBList.get(i).getMaChuyenBay().contains(txt_maCB.getText()) == false) {
                            CBList.remove(CBList.get(i));
                            i--;
                        }
                    }
                    
                } else if (findmaCB((txt_maCB.getText())) == false && txt_maCB.getText().equals("Mã chuyến bay...") == false || txt_maCB.getText().isBlank()) {
                    
                    JOptionPane.showMessageDialog(null, "Mã chuyến bay không tồn tại", "Thông báo", 0);
                    check=1;
                }
                if (findmaDB((txt_maDB.getText()))) {
                    int i = 0;
                    for (i = 0; i < CBList.size(); i++) {
                        if (CBList.get(i).getMaDuongBay().contains(txt_maDB.getText()) == false) {
                            CBList.remove(CBList.get(i));
                            i--;
                        }
                    }
                } else if (findmaDB((txt_maDB.getText())) == false && txt_maDB.getText().equals("Mã đường bay...") == false || txt_maDB.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Mã đường bay không tồn tại", "Thông báo", 0);
                    check=1;
                }
                if (findmaMB(txt_mamb.getText())) {
                    int i = 0;
                    for (i = 0; i < CBList.size(); i++) {
                        if (CBList.get(i).getMaMayBay().contains(txt_mamb.getText()) == false) {
                            CBList.remove(CBList.get(i));
                            i--;
                        }
                    }
                    
                } else if (findmaMB(txt_mamb.getText()) == false && txt_mamb.getText().equals("Mã máy bay...") == false || txt_mamb.getText().isBlank()) {
                    
                    JOptionPane.showMessageDialog(null, "Mã máy bay không tồn tại", "Thông báo", 0);
                    check=1;
                }
                if (findGate(txt_gate.getText())) {
                    int i = 0;
                    for (i = 0; i < CBList.size(); i++) {
                        if (CBList.get(i).getGate().contains(txt_gate.getText()) == false) {
                            CBList.remove(CBList.get(i));
                            i--;
                        }
                    }
                    
                } else if (findGate(txt_gate.getText()) == false && txt_gate.getText().equals("Gate...") == false || txt_gate.getText().isBlank()) {
                    
                    JOptionPane.showMessageDialog(null, "Gate không tồn tại", "Thông báo", 0);
                    check=1;
                }

                if(cbNam.getSelectedIndex()==1){
                    int i = 0;
                    
                    for (i = 0; i < CBList.size(); i++) {
                        if (CBList.get(i).getNgayDi().substring(6, 10).equals("2023")==false)  {
                            
                            CBList.remove(CBList.get(i));
                            i--;
                        }
                    }
                }
                if(cbNam.getSelectedIndex()==2){
                    int i = 0;
                    
                    for (i = 0; i < CBList.size(); i++) {
                        if (CBList.get(i).getNgayDi().substring(6, 10).equals("2024")==false)  {
                            
                            CBList.remove(CBList.get(i));
                            i--;
                        }
                    }
                }
                if(cbThang.getSelectedIndex()!=0){
                    int i = 0;
                    int j=cbThang.getSelectedIndex();
                    System.out.println(j);
                    System.out.println(CBList.get(i).getNgayDi().substring(3, 5));
                    for (i = 0; i < CBList.size(); i++) {
                        if (CBList.get(i).getNgayDi().substring(3, 5).equals(String.format("%02d", j))==false)  {
                            
                            CBList.remove(CBList.get(i));
                            i--;
                        }
                    }
                }
                if(cbNgay.getSelectedIndex()!=0){
                    int i = 0;
                    int j=cbNgay.getSelectedIndex();
                    System.out.println(j);
                    System.out.println(CBList.get(i).getNgayDi().substring(0, 2));
                    for (i = 0; i < CBList.size(); i++) {
                        if (CBList.get(i).getNgayDi().substring(0, 2).equals(String.format("%02d", j))==false)  {
                            
                            CBList.remove(CBList.get(i));
                            i--;
                        }
                    }
                }
                if(time1.gioSpinner.getValue().toString().equals("0")==false || time1.phutSpinner.getValue().toString().equals("0")==false){
                    String gio=String.format("%02d:%02d:00", time1.gioSpinner.getValue(),  time1.phutSpinner.getValue());
                    int i = 0;
                    for (i = 0; i < CBList.size(); i++) {
                        if (CBList.get(i).getGioDelay().equals(gio) == false) {
                            CBList.remove(CBList.get(i));
                            i--;
                        }
                    }
                }
                if(check == 0){
                    DefaultTableModel dm = (DefaultTableModel) jt.getModel();
                while (dm.getRowCount() > 0) {
                    dm.removeRow(0);
                }
                
                Object rowData[] = new Object[7];
                
                for (int i = 0; i < CBList.size(); i++) {
                    
                    rowData[0] = i + 1;
                    rowData[1] = CBList.get(i).getMaChuyenBay();
                    rowData[2] = CBList.get(i).getMaDuongBay();
                    rowData[3] = CBList.get(i).getMaMayBay();
                    rowData[4] = CBList.get(i).getGioBay();
                    rowData[5] = CBList.get(i).getNgayDi();
//                    rowData[6] = CBList.get(i).getGioDelay();
                    rowData[6] = CBList.get(i).getGate();
                    dm.addRow(rowData);
                    
                }
                }
                
            }
        });

    }
    
    public boolean findmaCB(String a) {
        ArrayList<ChuyenBayDTO> CBList = new ArrayList<>();
        CBList = new ChuyenBayBUS().load();
        
        for (int i = 0; i < CBList.size(); i++) {
            if (CBList.get(i).getMaChuyenBay().contains(a) && CBList.get(i).getXuLy() == 1) {
                
                return true;
            }
        }
        return false;
    }

    public boolean findmaDB(String a) {
        ArrayList<ChuyenBayDTO> CBList = new ArrayList<>();
        CBList = new ChuyenBayBUS().load();
        for (int i = 0; i < CBList.size(); i++) {
            String madb = CBList.get(i).getMaDuongBay();
            if (madb != null && madb.contains(a) && CBList.get(i).getXuLy() == 1) {
                return true;
            }
        }
        return false;
    }
    
    public boolean findmaMB(String a) {
        ArrayList<ChuyenBayDTO> CBList = new ArrayList<>();
        
            CBList = new ChuyenBayBUS().load();
        for (int i = 0; i < CBList.size(); i++) {
            if (CBList.get(i).getMaMayBay().contains(a) && CBList.get(i).getXuLy() == 1) {
                return true;
            }
        }
        return false;
    }
    public boolean findGate(String a) {
        ArrayList<ChuyenBayDTO> CBList = new ArrayList<>();
        
            CBList = new ChuyenBayBUS().load();
        for (int i = 0; i < CBList.size(); i++) {
            if (CBList.get(i).getGate().contains(a) && CBList.get(i).getXuLy() == 1) {
                return true;
            }
        }
        return false;
    }
    public boolean findDate(String a) {
        ArrayList<ChuyenBayDTO> CBList = new ArrayList<>();
        
            CBList = new ChuyenBayBUS().load();
        for (int i = 0; i < CBList.size(); i++) {
            if (CBList.get(i).getNgayDi().equals(a) && CBList.get(i).getXuLy() == 1) {
                return true;
            }
        }
        return false;
    }
//    public boolean findGio(String a) {
//        ArrayList<ChuyenBayDTO> CBList = new ArrayList<>();
//        
//            CBList = new ChuyenBayBUS().load();
//        for (int i = 0; i < CBList.size(); i++) {
//            if (CBList.get(i).getGioBay().equals(a) && CBList.get(i).getXuLy() == 1) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public static boolean checkTime(String a, String b, String c) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//        LocalTime timeA = LocalTime.parse(a, formatter);
//        LocalTime timeB = LocalTime.parse(b, formatter);
//        LocalTime timeC = LocalTime.parse(c, formatter);
//
//        return !timeA.isBefore(timeB) && !timeA.isAfter(timeC);
//    }
    
    public boolean checknonNum(String a) {
        try {
            double d = Double.parseDouble(a);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }

   
    public void loaddata() {
        ArrayList<ChuyenBayDTO> CBList = new ArrayList<>();

       CBList = new ChuyenBayBUS().load();
      
        DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
            dm.setColumnCount(0);
        }
        dm.addColumn("STT");
        dm.addColumn("Mã chuyến bay");
        dm.addColumn("Mã đường bay");
        dm.addColumn("Mã máy bay");
        dm.addColumn("Giờ bay");
        dm.addColumn("Ngày đi");
        dm.addColumn("Số ghế Eco");
        dm.addColumn("Số ghế Bus");
        dm.addColumn("Gate");
        jt.setModel(dm);
        int i = 1;
        for (ChuyenBayDTO x : CBList) {
            Object data[] = {i, x.getMaChuyenBay(), x.getMaDuongBay(), x.getMaMayBay(), x.getGioDelay(), x.getNgayDi(), x.getSLEco(), x.getSLBus(), x.getGate()};
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
        ArrayList<ChuyenBayDTO> CBList = new ArrayList<>();
        
        
            CBList = new ChuyenBayBUS().load();
        DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        while (dm.getRowCount() > 0) {
            dm.setRowCount(0); //xóa table để update table mới
            dm.setColumnCount(0);
        }
        dm.addColumn("STT");
        dm.addColumn("Mã chuyến bay");
        dm.addColumn("Mã đường bay");
        dm.addColumn("Mã máy bay");
        dm.addColumn("Giờ bay");
        dm.addColumn("Ngày đi");
        dm.addColumn("Số ghế Eco");
        dm.addColumn("Số ghế Bus");
        dm.addColumn("Gate");
        jt.setModel(dm);
        int i = 1;
        for (ChuyenBayDTO x : CBList) {
            Object data[] = {i, x.getMaChuyenBay(), x.getMaDuongBay(), x.getMaMayBay(), x.getGioDelay(), x.getNgayDi(), x.getSLEco(), x.getSLBus(), x.getGate()};
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
    public void rsTable(){
        DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        //while (dm.getRowCount() > 0) {
            dm.setRowCount(0); //xóa table để update table mới
            dm.setColumnCount(0);
        loaddata();
    }
    
    public void lightDark(int lightDark) {
        if (lightDark == 1) {
            Color black = new Color(51, 51, 51);
            time1.LightDark(lightDark);
            pnGio1.setBackground(black);
            pnGio2.setBackground(black);
            pnNam.setBackground(black);
            pnThang.setBackground(black);
            pnNgay.setBackground(black);
            lbTitle.setForeground(Color.white);
            lbThang.setForeground(Color.white);
            lbNgay.setForeground(Color.white);
            lbNam.setForeground(Color.white);
            lbFrom.setForeground(Color.white);
            pnTitle.setBackground(black);
            pnBottomContent.setBackground(black);
            pnTitle.setBackground(black);
            pnMidContent.setBackground(black);
            pnBottomContent.setBackground(black);
            pnMid2Content.setBackground(black);
            scpn.setBackground(black);
            jt.setBackground(black);
            jt.setBackground(black);
            lbTitle.setForeground(Color.white);
            jt.getTableHeader().setBackground(Color.decode("#528B8B"));
            btn_tim.setBackground(Color.decode("#BFEFFF"));
            btn_thoattim.setBackground(Color.decode("#BFEFFF"));
            pnBottomContent.setBorder(BorderFactory.createLineBorder(black, 10));
            btn_tim.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, black), new EmptyBorder(10, 10, 10, 10)));
            btn_thoattim.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 5, 0, 10, black), new EmptyBorder(10, 10, 10, 10)));
//            pnMaKH.setBackground(black);
            btn_them.setBackground(Color.decode("#BFEFFF"));
            btn_them.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, black), new EmptyBorder(10, 10, 10, 10)));
            btn_xuat.setBackground(Color.decode("#BFEFFF"));
            btn_xuat.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, black), new EmptyBorder(10, 10, 10, 10)));
//            btnImport.setBackground(Color.decode("#BFEFFF"));
//            btnImport.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, black), new EmptyBorder(10, 10, 10, 10)));
        } else {
            time1.LightDark(lightDark);
            pnTitle.setBackground(Color.white);
            pnMidContent.setBackground(Color.white);
            pnBottomContent.setBackground(Color.white);
            scpn.setBackground(Color.white);
            jt.setBackground(Color.white);
            jt.setBackground(Color.white);
            lbTitle.setForeground(Color.black);
            lbThang.setForeground(Color.black);
            lbNgay.setForeground(Color.black);
            lbNam.setForeground(Color.black);
            lbFrom.setForeground(Color.black);
            jt.getTableHeader().setBackground(Color.decode("#79CDCD"));
            btn_tim.setBackground(Color.decode("#87CEFA"));
            btn_thoattim.setBackground(Color.decode("#87CEFA"));
            pnBottomContent.setBorder(BorderFactory.createLineBorder(Color.white, 10));
            btn_tim.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, Color.white), new EmptyBorder(10, 10, 10, 10)));
            btn_thoattim.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 5, 0, 10, Color.white), new EmptyBorder(10, 10, 10, 10)));
            //pnMaKH.setBackground(Color.white);
            pnMid2Content.setBackground(Color.white);
            pnGio1.setBackground(Color.WHITE);
            pnGio2.setBackground(Color.WHITE);
            pnNam.setBackground(Color.WHITE);
            pnThang.setBackground(Color.WHITE);
            pnNgay.setBackground(Color.WHITE);
            btn_them.setBackground(Color.decode("#87CEFA"));
            btn_them.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, Color.white), new EmptyBorder(10, 10, 10, 10)));
            btn_xuat.setBackground(Color.decode("#87CEFA"));
            btn_xuat.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, Color.white), new EmptyBorder(10, 10, 10, 10)));

//            btnImport.setBackground(Color.decode("#87CEFA"));
//            btnImport.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 10, 0, 10, Color.white), new EmptyBorder(10, 10, 10, 10)));
        }
    }
}
