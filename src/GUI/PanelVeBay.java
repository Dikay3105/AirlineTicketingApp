/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.VeBayBUS;
import DTO.KhachHangDTO;
import DTO.VeBayDTO;
import GUI.datve.MenuDatVe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author duyli
 */
public class PanelVeBay extends JPanel {

    public ArrayList<VeBayDTO> vbfull = VeBayBUS.load();
    public static ArrayList<VeBayDTO> findList = new ArrayList<>();
    private JPanel pnTitle = new JPanel();
    private JPanel pnCenter = new JPanel();
    private JPanel pnSearch = new JPanel();
    private JPanel pnContent = new JPanel();
    private JPanel pnList = new JPanel();
    private JPanel pnBtn = new JPanel();
    private JPanel pnInput = new JPanel();
    private JPanel pnTitleTop = new JPanel();
    private JPanel pnMid = new JPanel();
    private JScrollPane scp = new JScrollPane();

    private JPanel pnMaKH = new JPanel();
    private JPanel pnMaNV = new JPanel();
    private JPanel pnMaCTT = new JPanel();
    private JPanel pnTenKH = new JPanel();
    private JPanel pnTenNV = new JPanel();
    private JPanel pnTinhTrang = new JPanel();

    private JTextField txtMaKH = new JTextField("Mã khách hàng");
    private JTextField txtMaNV = new JTextField("Mã nhân viên");
    private JTextField txtTenKH = new JTextField("Tên khách hàng");
    private JTextField txtTenNV = new JTextField("Mã chuyến bay");
    private JTextField txtMaCTT = new JTextField("Mã vé");
    public static MenuDatVe mn;
    private JComboBox txtTinhTrang = new JComboBox();

    private static JTable tbCTT = new JTable() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    static Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    static Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);

    private JLabel lbList = new JLabel("Danh sách vé");

    private JButton btnSearch = new JButton("Đặt vé");
    private JButton btnReset = new JButton("Thoát tìm");
    private JButton btnXuatFile = new JButton("Xuất File");

    public PanelVeBay() {
        initComponents();
    }
    
    public PanelVeBay(int x) {
        initComponents();
        pnBtn.remove(btnXuatFile);
    }

    public void initComponents() {
        setBackground(Color.white);
        setLayout(new BorderLayout());

        pnTitle.setBackground(Color.white);
        add(pnTitle, BorderLayout.NORTH);
        add(pnCenter, BorderLayout.CENTER);

        pnCenter.setLayout(new BorderLayout());
        pnCenter.add(pnSearch, BorderLayout.NORTH);
        pnCenter.add(pnContent, BorderLayout.CENTER);
        pnCenter.setBackground(Color.white);

        pnSearch.setLayout(new BorderLayout());
        pnSearch.add(pnBtn, BorderLayout.EAST);
        pnSearch.add(pnInput, BorderLayout.CENTER);
        pnSearch.setBackground(Color.white);

        pnInput.setLayout(new GridLayout(1, 8, 2, 2));
        pnInput.setBackground(Color.white);
        pnInput.add(pnMaCTT);
        pnMaCTT.setLayout(new BorderLayout());
        pnMaCTT.add(txtMaCTT, BorderLayout.CENTER);
        txtMaCTT.setMargin(new Insets(5, 5, 5, 5));
        pnMaCTT.setFont(sgUI13);

        pnInput.add(pnMaKH);
        pnMaKH.setLayout(new BorderLayout());
        pnMaKH.add(txtMaKH, BorderLayout.CENTER);
        txtMaKH.setMargin(new Insets(5, 5, 5, 5));
        txtMaKH.setFont(sgUI13);

        pnInput.add(pnTenKH);
        pnTenKH.setLayout(new BorderLayout());
        pnTenKH.add(txtTenKH, BorderLayout.CENTER);
        txtTenKH.setMargin(new Insets(5, 5, 5, 5));
        txtTenKH.setFont(sgUI13);

        pnInput.add(pnMaNV);
        pnMaNV.setLayout(new BorderLayout());
        pnMaNV.add(txtMaNV, BorderLayout.CENTER);
        txtMaNV.setMargin(new Insets(5, 5, 5, 5));
        txtMaNV.setFont(sgUI13);

        pnInput.add(pnTenNV);
        pnTenNV.setLayout(new BorderLayout());
        pnTenNV.add(txtTenNV, BorderLayout.CENTER);
        txtTenNV.setMargin(new Insets(5, 5, 5, 5));
        txtTenNV.setFont(sgUI13);

        pnInput.add(pnTinhTrang);
        pnTinhTrang.setLayout(new BorderLayout());
        pnTinhTrang.add(txtTinhTrang, BorderLayout.CENTER);
        txtTinhTrang.setFont(sgUI13);
        txtTinhTrang.setBackground(Color.white);
        txtTinhTrang.addItem("Tình trạng");
        txtTinhTrang.addItem("Đã hủy");
        txtTinhTrang.addItem("Chưa hủy");

        pnInput.setBorder(new EmptyBorder(5, 8, 5, 8));

        pnBtn.setLayout(new GridLayout(1, 3, 5, 5));
        pnBtn.setBackground(Color.white);
        ImageIcon iconTim = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/IconFind.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btnSearch.setIcon(iconTim);
        btnSearch.setFont(sgUI13);
        btnSearch.setBackground(Color.decode("#87CEFA"));
        pnBtn.add(btnSearch);

        btnSearch.setRequestFocusEnabled(false);

        ImageIcon iconThoat = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/IconReset.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btnReset.setIcon(iconThoat);
        btnReset.setFont(sgUI13);
        btnReset.setBackground(Color.decode("#87CEFA"));
        btnXuatFile.setBackground(Color.decode("#87CEFA"));
        ImageIcon iconFile = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/ex.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btnXuatFile.setFocusPainted(false);
        btnXuatFile.setIcon(iconFile);
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
                    JOptionPane.showMessageDialog(null, VeBayBUS.xuatExcel(filePath+".xlsx"), "Thông báo", 1);
                try {
                    Desktop.getDesktop().open(new File(VeBayBUS.pathExcel));
                } catch (IOException ex) {
                    Logger.getLogger(PanelVeBay.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                
            }
        });
        pnBtn.add(btnReset);
        pnBtn.add(btnXuatFile);
        btnReset.setRequestFocusEnabled(false);

        pnBtn.setBorder(new EmptyBorder(5, 0, 5, 10));

        pnContent.setLayout(new BorderLayout());
        pnContent.add(pnTitleTop, BorderLayout.NORTH);
        lbList.setFont(sgUI15);
        pnTitleTop.setLayout(new BorderLayout());
        pnTitleTop.add(lbList, BorderLayout.CENTER);

        lbList.setHorizontalAlignment(JLabel.LEFT);
        lbList.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnContent.add(pnMid, BorderLayout.CENTER);
        lbList.setBackground(Color.white);
        lbList.setOpaque(true);
        lbList.setForeground(Color.black);

        pnMid.setLayout(new BorderLayout());
        pnMid.setBackground(Color.white);
        pnMid.add(scp, BorderLayout.CENTER);
        pnMid.setBorder(new EmptyBorder(0, 10, 10, 10));
        pnMid.setBackground(Color.white);
        tbCTT.getTableHeader().setBackground(Color.decode("#79CDCD"));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
                mn = new MenuDatVe(1);
            }
        });

        scp.setViewportView(tbCTT);
        loadTable(vbfull);
        txtMaKH.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtMaKH.getText().equals("Mã khách hàng")) {
                    txtMaKH.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtMaKH.getText().trim().length() == 0) {
                    txtMaKH.setText("Mã khách hàng");
                }
            }
        });
        txtMaNV.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtMaNV.getText().equals("Mã nhân viên")) {
                    txtMaNV.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtMaNV.getText().trim().length() == 0) {
                    txtMaNV.setText("Mã nhân viên");
                }
            }
        });
        txtTenKH.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTenKH.getText().equals("Tên khách hàng")) {
                    txtTenKH.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTenKH.getText().trim().length() == 0) {
                    txtTenKH.setText("Tên khách hàng");
                }
            }
        });
        txtTenNV.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTenNV.getText().equals("Mã chuyến bay")) {
                    txtTenNV.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTenNV.getText().trim().length() == 0) {
                    txtTenNV.setText("Mã chuyến bay");
                }
            }
        });
        txtMaCTT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtMaCTT.getText().equals("Mã vé")) {
                    txtMaCTT.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtMaCTT.getText().trim().length() == 0) {
                    txtMaCTT.setText("Mã vé");
                }
            }
        });

        //-----------click chuot vao table-----
        tbCTT.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2 ) {
                    int column = tbCTT.getColumnModel().getColumnIndex("Mã vé");
                    FrameOrderRoom.mave = (String) tbCTT.getValueAt(tbCTT.getSelectedRow(), column);
                    try {
                        new FrameOrderRoom();
                    } catch (IOException ex) {
                        Logger.getLogger(PanelVeBay.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(PanelVeBay.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(PanelVeBay.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                
            }
        });

        btnReset.addActionListener((ActionEvent e) -> {
            DefaultTableModel dm = (DefaultTableModel) tbCTT.getModel();
            dm.setColumnCount(0);
            vbfull=VeBayBUS.load();
            loadTable(vbfull);
            txtMaCTT.setText("Mã vé");
            txtMaKH.setText("Mã khách hàng");
            txtMaNV.setText("Mã nhân viên");
            txtTenKH.setText("Tên khách hàng");
            txtTenNV.setText("Mã chuyến bay");
            txtTinhTrang.setSelectedIndex(0);
        });

        txtTinhTrang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaCTT.setText("Mã vé");
                txtMaKH.setText("Mã khách hàng");
                txtMaNV.setText("Mã nhân viên");
                txtTenKH.setText("Tên khách hàng");
                txtTenNV.setText("Mã chuyến bay");
                String selectedItem = txtTinhTrang.getSelectedItem().toString();
                int doighe;
                if (selectedItem.equals("Chưa hủy")) {
                    doighe = 1;
                    VeBayBUS.findXuLy(vbfull, doighe);
                } else if (selectedItem.equals("Đã hủy")) {
                    doighe = 0;
                    VeBayBUS.findXuLy(vbfull, doighe);
                } else if (selectedItem.equals("Tình trạng")) {
                    loadTable(vbfull);
                    findList = new ArrayList<>();
                }

            }
        });


        txtMaCTT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==10)
                if (findList.isEmpty()) {
                    VeBayBUS.findMaVe(vbfull, txtMaCTT.getText());
                } else {
                    VeBayBUS.findMaVe(findList, txtMaCTT.getText());
                }
            }
        });
        
        txtTenKH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==10)
                if (findList.isEmpty()) {
                    VeBayBUS.findTenKh(vbfull, txtTenKH.getText());
                } else {
                    VeBayBUS.findTenKh(findList, txtTenKH.getText());
                }
            }
        });
        
        txtTenNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==10)
                if (findList.isEmpty()) {
                    VeBayBUS.findMaCb(vbfull, txtTenNV.getText());
                } else {
                    VeBayBUS.findMaCb(findList, txtTenNV.getText());
                }
            }
        });
        
        txtMaNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (findList.isEmpty()) {
                    VeBayBUS.findMaNV(vbfull, txtMaNV.getText());
                } else {
                    VeBayBUS.findMaNV(findList, txtMaNV.getText());
                }
            }
        });
        
        txtMaKH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==10)
                if (findList.isEmpty()) {
                    VeBayBUS.findMaKh(vbfull, txtMaKH.getText());
                } else {
                    VeBayBUS.findMaKh(findList, txtMaKH.getText());
                }
            }
        });

    }

    public static void delTB(JTable tbCTT) {
        DefaultTableModel dm = (DefaultTableModel) tbCTT.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
            dm.setColumnCount(0);
        }
    }

    public void loadTable(ArrayList<VeBayDTO> CTTList) {
        //   CTTList.clear();
        DefaultTableModel dm = (DefaultTableModel) tbCTT.getModel();
        delTB(tbCTT);
        dm.addColumn("STT");
        dm.addColumn("Mã vé");
        dm.addColumn("Mã khách hàng");
        dm.addColumn("Tên khách hàng");
        dm.addColumn("Mã nhân viên");
        dm.addColumn("Mã chuyến bay");
        dm.addColumn("Mã ghế");
        dm.addColumn("Tình trạng");
        tbCTT.setModel(dm);

        Object rowData[] = new Object[8];
        for (int i = 0; i < CTTList.size(); i++) {
            rowData[0] = i + 1;
            rowData[1] = CTTList.get(i).getMaVe();
            rowData[2] = CTTList.get(i).getMaKhachHang();
            rowData[3] = TenKH(CTTList.get(i).getMaKhachHang());
            rowData[4] = CTTList.get(i).getMaNhanVien();
            rowData[5] = CTTList.get(i).getMaChuyenBay();

            rowData[6] = CTTList.get(i).getMaghe();
            if (CTTList.get(i).getXuLy()== 0) {
                rowData[7] = "Đã hủy";
            } else {
                rowData[7] = "";
            }
            dm.addRow(rowData);
        }
        tbCTT.setShowGrid(false);
        tbCTT.setIntercellSpacing(new Dimension(0, 0));
        tbCTT.setRowHeight(40);
        tbCTT.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbCTT.getTableHeader().setPreferredSize(new Dimension(1, 40));
        tbCTT.setBackground(Color.white);
        tbCTT.getTableHeader().setBackground(Color.decode("#79CDCD"));
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
                    lb.setBackground(Color.decode("#F5F5F5"));
                } else {
                    lb.setBackground(Color.decode("#FFFFFF"));
                }
                return lb;
            }
        };
        for (int i = 0; i < tbCTT.getColumnCount(); i++) {
            tbCTT.getColumnModel().getColumn(i).setCellRenderer(renderBorder);
        }
        tbCTT.getTableHeader().setFont(sgUI13b);
        tbCTT.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public static void loadTable(JTable tbCTT, ArrayList<VeBayDTO> CTTList) {
        //    CTTList.clear();
        delTB(tbCTT);
        DefaultTableModel dm = (DefaultTableModel) tbCTT.getModel();
        dm.addColumn("STT");
        dm.addColumn("Mã vé");
        dm.addColumn("Mã khách hàng");
        dm.addColumn("Tên khách hàng");
        dm.addColumn("Mã nhân viên");
        dm.addColumn("Mã chuyến bay");
        dm.addColumn("Mã ghế");
        dm.addColumn("Tình trạng");
        tbCTT.setModel(dm);

        Object rowData[] = new Object[8];
        for (int i = 0; i < CTTList.size(); i++) {
            rowData[0] = i + 1;
            rowData[1] = CTTList.get(i).getMaVe();
            rowData[2] = CTTList.get(i).getMaKhachHang();
            rowData[3] = TenKH(CTTList.get(i).getMaKhachHang());
            rowData[4] = CTTList.get(i).getMaNhanVien();
            rowData[5] = CTTList.get(i).getMaChuyenBay();

            rowData[6] = CTTList.get(i).getMaghe();
            if (CTTList.get(i).getXuLy() == 0) {
                rowData[7] = "Đã hủy";
            } else {
                rowData[7] = "";
            }
            dm.addRow(rowData);
        }
        tbCTT.setShowGrid(false);
        tbCTT.setIntercellSpacing(new Dimension(0, 0));
        tbCTT.setRowHeight(40);
        tbCTT.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbCTT.getTableHeader().setPreferredSize(new Dimension(1, 40));
        tbCTT.setBackground(Color.white);
        tbCTT.getTableHeader().setBackground(Color.decode("#79CDCD"));
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
                    lb.setBackground(Color.decode("#F5F5F5"));
                } else {
                    lb.setBackground(Color.decode("#FFFFFF"));
                }
                return lb;
            }
        };
        for (int i = 0; i < tbCTT.getColumnCount(); i++) {
            tbCTT.getColumnModel().getColumn(i).setCellRenderer(renderBorder);
        }
        tbCTT.getTableHeader().setFont(sgUI13b);
        tbCTT.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public static String TenKH(String id) {
        ArrayList<KhachHangDTO> KHList = new ArrayList<>();

        KHList = new KhachHangBUS().load();

        for (int i = 0; i < KHList.size(); i++) {
            if (KHList.get(i).getMaKH().equals(id)) {
                return KHList.get(i).getTenKH();
            }
        }
        return null;
    }

    public static JTable getTbCTT() {
        return tbCTT;
    }

    public void setTbCTT(JTable tbCTT) {
        this.tbCTT = tbCTT;
    }

    public static void setNewTbCTT() {
        PanelVeBay.tbCTT = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static void loadFind(JTable tbCTT, ArrayList<VeBayDTO> CTTList) {
        DefaultTableModel dm = (DefaultTableModel) tbCTT.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        Object rowData[] = new Object[8];
        for (int i = 0; i < CTTList.size(); i++) {
            rowData[0] = i + 1;
            rowData[1] = CTTList.get(i).getMaVe();
            rowData[2] = CTTList.get(i).getMaKhachHang();
            rowData[3] = TenKH(CTTList.get(i).getMaKhachHang());
            rowData[4] = CTTList.get(i).getMaNhanVien();
            rowData[5] = CTTList.get(i).getMaChuyenBay();

            rowData[6] = CTTList.get(i).getMaghe();
            if (CTTList.get(i).getXuLy()== 0) {
                rowData[7] = "Đã hủy";
            } else {
                rowData[7] = "";
            }
            dm.addRow(rowData);
        }
    }
    
    public void lightDark(int lightDark) {
        if (lightDark == 1) {
            Color black = new Color(51, 51, 51);
            pnTitle.setBackground(black);
             pnSearch.setBackground(black);
             pnBtn.setBackground(black);
             pnCenter.setBackground(black);
             pnContent.setBackground(black);
             pnList.setBackground(black);
             pnInput.setBackground(black);
             pnTitleTop.setBackground(black);
             pnMid.setBackground(black);
             lbList.setBackground(black);
             lbList.setForeground(Color.white);

        } else {
            pnTitle.setBackground(Color.white);
             pnSearch.setBackground(Color.white);
             pnBtn.setBackground(Color.white);
             pnCenter.setBackground(Color.white);
             pnContent.setBackground(Color.white);
             pnList.setBackground(Color.white);
             pnInput.setBackground(Color.white);
             pnTitleTop.setBackground(Color.white);
             pnMid.setBackground(Color.white);
             lbList.setBackground(Color.white);
             lbList.setForeground(Color.black);

        }
    }

}
