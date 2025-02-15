package GUI.LeTanGUI;

import BUS.DiemDanhBUS;
import DAO.DBConnect;
import DTO.DiemDanhDTO;
import GUI.LoginGUI;
import GUI.PanelChuyenBay2;
import GUI.PanelVeBay;
import GUI.datve.MenuDatVe;
import GUI.mainGUI;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.plaf.ColorUIResource;
import java.sql.*;

public class ReceptionistGUI extends JFrame {

    int check = 0;
    public static MenuDatVe mn;
    public static PanelVeBay pnveBay=new PanelVeBay(1);
    JMenuBar menuBar = new JMenuBar();
    JMenu mFile = new JMenu("Settings");
    JMenuItem mItemHome = new JMenuItem("Quay lại trang chính");
//    JMenuItem mItemNew = new JMenuItem("Tạo mới thuê phòng");
    JMenuItem mItemLogOut = new JMenuItem("Đăng xuất");
//    JMenu mSetting = new JMenu("Settings");
////    JMenuItem mItemHomNay = new JMenuItem("Điểm danh hôm nay");
////    JMenuItem mItemTotal = new JMenuItem("Bảng điểm danh tổng");
//    JMenu mDiemDanh = new JMenu("Attendance");

    JLabel lbName = new JLabel("Xin chào, ");

    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);

    JPanel pnTopA = new JPanel();
    JPanel pnBottom = new JPanel();

    JPanel pnThongBao = new JPanel();
    JPanel pnCalendar = new JPanel();
    JPanel pnCD = new JPanel();
    JCalendar cd = new JCalendar();
    JPanel pnSoDoPhong = new JPanel();
    JLabel lbSoDoPhongTop = new JLabel();
    JLabel lbSoDoPhongBottom = new JLabel("Quản lý chuyến bay");
    JPanel pnThongTinCaNhan = new JPanel();
    JLabel lbInfoTop = new JLabel();
    JLabel lbInfoBottom = new JLabel("Thông tin cá nhân");
    JPanel pnDatPhong = new JPanel();
    JLabel lbDatPhongTop = new JLabel();
    JLabel lbDatPhongBottom = new JLabel("Đặt vé");
    JPanel pnKhachHang = new JPanel();
    JLabel lbKhachhangtop = new JLabel();
    JLabel lbKhachhangbottom = new JLabel("Quản lý khách hàng");
    JPanel pnDiemDanh = new JPanel();
    JLabel lbDiemDanhTop = new JLabel();
    JLabel lbDiemDanhBottom = new JLabel("Quản lý vé");
    JButton btn1 = new JButton("Update sau");

    JPanel pnCenter = new JPanel();
    JPanel pnTop = new JPanel();
    JPanel pnContent = new JPanel();

    JLabel lbThongBao = new JLabel("Thông báo");
    JPanel pnTB = new JPanel();

    public ReceptionistGUI() {
        lbName.setText(lbName.getText() + mainGUI.taiKhoan + " - " + mainGUI.nameNV);
        initComponents();
    }

    public void initComponents() {
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
        setTitle("Phần mềm quản lý vé máy bay");
        setSize(1300, 730);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(menuBar, BorderLayout.NORTH);
        menuBar.add(mFile);
//        mFile.add(mItemNew);
//        mFile.add(mItemHome);
//        mItemHome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
//        mItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

        mFile.add(mItemLogOut);
        mFile.setFont(sgUI13);
//        mSetting.setFont(sgUI13);
//        menuBar.add(mDiemDanh);
//        mDiemDanh.setFont(sgUI13);
//        mDiemDanh.add(mItemHomNay);
//        mItemHomNay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
//        mDiemDanh.add(mItemTotal);
//        menuBar.add(mSetting);

//        mItemHomNay.setFont(sgUI13);
//        mItemHome.setFont(sgUI13);
        mItemLogOut.setFont(sgUI13);
//        mItemNew.setFont(sgUI13);
//        mItemTotal.setFont(sgUI13);
//
//        mItemHome.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                new ReceptionistGUI();
//            }
//        });
//---------nút xuất bảng đd    
//        mItemTotal.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                renderDiemDanh();
//            }
//        });
        add(pnCenter, BorderLayout.CENTER);
        pnCenter.setLayout(new BorderLayout());
        pnCenter.add(pnTop, BorderLayout.NORTH);
        pnTop.setLayout(new BorderLayout());
        pnTop.add(lbName, BorderLayout.EAST);
        lbName.setBorder(new EmptyBorder(5, 5, 5, 5));

        lbName.setFont(sgUI15);
        pnCenter.add(pnContent, BorderLayout.CENTER);
        renderHome();

//        mItemNew.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                renderNew();
//            }
//        });

        mItemLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginGUI();
            }
        });
        pnThongBao.setLayout(new BorderLayout());
        JScrollPane scp = new JScrollPane();
        pnThongBao.add(scp, BorderLayout.CENTER);
        JPanel pnHello = new JPanel();
        scp.setViewportView(pnHello);
        pnHello.setLayout(new BoxLayout(pnHello, BoxLayout.Y_AXIS));
        try {
            java.sql.Connection conn = DBConnect.getConnection();
            String query = "SELECT * FROM ThongBao WHERE CONVERT(DATE, ngayDang) = CONVERT(DATE, GETDATE())";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                JPanel pnTB = new JPanel();
                JLabel lbTop = new JLabel(rs.getString("tieuDe"));
                lbTop.setHorizontalAlignment(SwingConstants.CENTER);
                lbTop.setVerticalAlignment(SwingConstants.CENTER);
                JTextArea txtarea = new JTextArea(rs.getString("noiDung"));
                pnTB.setLayout(new BorderLayout());
                pnTB.add(lbTop,BorderLayout.NORTH);
                pnTB.add(txtarea,BorderLayout.CENTER);
                pnHello.add(pnTB);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void renderHome() {
        check = 0;
        tpNew.removeAll();
        pnContent.removeAll();
        pnContent.repaint();
        pnContent.revalidate();
        pnContent.setLayout(new GridLayout(2, 1, 20, 20));
        pnContent.setBorder(new EmptyBorder(5, 80, 50, 80));
        pnContent.add(pnTopA);
        pnContent.add(pnBottom);

        pnTopA.setLayout(new GridLayout(1, 2, 20, 20));
        pnTopA.add(pnThongBao);
        pnTopA.add(pnCalendar);
        pnThongBao.setBackground(Color.white);
        pnThongBao.setLayout(new BorderLayout());
        pnThongBao.add(lbThongBao, BorderLayout.NORTH);
        lbThongBao.setFont(sgUI18b);
        lbThongBao.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnThongBao.add(pnTB, BorderLayout.CENTER);
        pnCalendar.setLayout(new GridLayout(1, 2, 20, 20));
        pnCalendar.add(pnSoDoPhong);
        pnCalendar.add(pnCD);

        pnCD.setLayout(new BorderLayout());
        pnCD.add(cd, BorderLayout.CENTER);
        pnCD.setBackground(Color.white);

        pnTB.setBackground(Color.white);

        pnBottom.setLayout(new GridLayout(1, 4, 20, 20));
        pnBottom.add(pnThongTinCaNhan);
        pnBottom.add(pnDatPhong);
        pnBottom.add(pnDiemDanh);
        pnBottom.add(pnKhachHang);

        ImageIcon iconsodophong = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/sodophong.png")).getImage().getScaledInstance(280, 170, Image.SCALE_SMOOTH));
        pnSoDoPhong.setLayout(new GridLayout(2, 1));
        pnSoDoPhong.setBackground(Color.white);
        pnSoDoPhong.add(lbSoDoPhongTop);
        pnSoDoPhong.add(lbSoDoPhongBottom);
        lbSoDoPhongTop.setHorizontalAlignment(JLabel.CENTER);
        lbSoDoPhongTop.setIcon(iconsodophong);
        lbSoDoPhongBottom.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon iconThongTinCaNhan = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/thongtinnhanvien.jpg")).getImage().getScaledInstance(280, 150, Image.SCALE_SMOOTH));
        pnThongTinCaNhan.setLayout(new GridLayout(2, 1));
        pnThongTinCaNhan.setBackground(Color.white);
        pnThongTinCaNhan.add(lbInfoTop);
        pnThongTinCaNhan.add(lbInfoBottom);
        lbInfoBottom.setHorizontalAlignment(JLabel.CENTER);
        lbInfoTop.setHorizontalAlignment(JLabel.CENTER);
        lbInfoTop.setIcon(iconThongTinCaNhan);

        ImageIcon iconDatPhong = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/bookingnow.png")).getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH));
        pnDatPhong.setLayout(new GridLayout(2, 1));
        pnDatPhong.add(lbDatPhongTop);
        pnDatPhong.add(lbDatPhongBottom);
        pnDatPhong.setBackground(Color.white);
        lbDatPhongTop.setHorizontalAlignment(JLabel.CENTER);
        lbDatPhongTop.setIcon(iconDatPhong);
        lbDatPhongBottom.setHorizontalAlignment(JLabel.CENTER);
        
        ImageIcon iconKhachHang = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/FHDThongTinKhach.png")).getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH));
        pnKhachHang.setLayout(new GridLayout(2, 1));
        pnKhachHang.add(lbKhachhangtop);
        pnKhachHang.add(lbKhachhangbottom);
        pnKhachHang.setBackground(Color.white);
        lbKhachhangtop.setHorizontalAlignment(JLabel.CENTER);
        lbKhachhangtop.setIcon(iconKhachHang);
        lbKhachhangbottom.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon iconDiemdanh= new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/diemdanh.jpg")).getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH));
        pnDiemDanh.setLayout(new GridLayout(2, 1));
        pnDiemDanh.add(lbDiemDanhTop);
        pnDiemDanh.add(lbDiemDanhBottom);
        pnDiemDanh.setBackground(Color.white);
        lbDiemDanhTop.setHorizontalAlignment(JLabel.CENTER);
        lbDiemDanhTop.setIcon(iconDiemdanh);
        lbDiemDanhBottom.setHorizontalAlignment(JLabel.CENTER);

        lbSoDoPhongBottom.setFont(sgUI15p);
        lbDatPhongBottom.setFont(sgUI15p);
        lbDiemDanhBottom.setFont(sgUI15p);
        lbInfoBottom.setFont(sgUI15p);

        pnDatPhong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                pnDatPhong.repaint();
//                pnDatPhong.revalidate();
//                new MenuDatVe();
//                renderDatPhong();
                  setVisible(false);
                  mn = new MenuDatVe(2);
                  mn.closeWin();
            }
        });
        
        pnKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new CallQuanLyKhachHang();
            }
        });
        
        pnThongTinCaNhan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                try {
                    new CallInforNhanVien(mainGUI.taiKhoan.trim());
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(ReceptionistGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

            }
        });

        pnSoDoPhong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new CallQuanLyChuyenBay();
            }
        });
        pnDiemDanh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new CallQuanLyVeBay();
 
            }
        });
    }

    JTabbedPane tpDatPhong = new JTabbedPane();
    JToolBar tbChiTietThue = new JToolBar();
    JToolBar tbDatPhong = new JToolBar();
//-------update-----
    private PanelDiemDanhTong pnDiemDanhTong;
//------------


    public void renderDatPhong() {
        check = 0;
//        tpNew.removeAll();
        pnContent.removeAll();
        pnContent.repaint();
        pnContent.revalidate();
        pnContent.setBorder(null);
        pnContent.setLayout(new BorderLayout());
        PanelChuyenBay2 pncb=new PanelChuyenBay2(1);
        pnContent.add(pncb, BorderLayout.CENTER);
        
//        tbDatPhong.removeAll();
//
////        tpDatPhong.addTab("Chi tiết thuê", tbChiTietThue);
////        tpDatPhong.addTab("Đặt phòng", tbDatPhong);
//        tpDatPhong.setFont(sgUI15);
//
//        tbDatPhong.setBorderPainted(false);
//        tbDatPhong.setBorder(null);
//        tbDatPhong.setLayout(new BorderLayout());
//        DatPhongLeTan dpLT = new DatPhongLeTan(true);
//        tbDatPhong.add(dpLT, BorderLayout.CENTER);
//        tbDatPhong.setRollover(true);
//
//        tpDatPhong.getModel().addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                if (tpDatPhong.getSelectedIndex() == 1) {
//                    tbDatPhong.removeAll();
//                    tbDatPhong.repaint();
//                    tbDatPhong.revalidate();
//                    DatPhongLeTan dpLT = new DatPhongLeTan(true);
//                    tbDatPhong.add(dpLT, BorderLayout.CENTER);
//                } else {
//                    tbChiTietThue.removeAll();
//                    tbChiTietThue.repaint();
//                    tbChiTietThue.revalidate();
//                    PanelChiTietThueGUI pnCTT = new PanelChiTietThueGUI(tpDatPhong, dpLT);
//                    tbChiTietThue.add(pnCTT, BorderLayout.CENTER);
//                }
//            }
//        });
//
//        tbChiTietThue.setRollover(true);
//        tbChiTietThue.setBorderPainted(false);
//        tbChiTietThue.setBorder(null);
//        tbChiTietThue.setLayout(new BorderLayout());
//        PanelChiTietThueGUI pnCTT = new PanelChiTietThueGUI(tpDatPhong, dpLT);
//        tbChiTietThue.add(pnCTT, BorderLayout.CENTER);
    }
//
    JTabbedPane tpNew = new JTabbedPane();

    public void renderNew() {
        if (check == 0) {
            pnContent.removeAll();
            pnContent.repaint();
            pnContent.revalidate();
            pnContent.setBorder(null);
            pnContent.setLayout(new BorderLayout());
            pnContent.add(tpNew, BorderLayout.CENTER);
            //addTab();
        } else {
            //addTab();
        }
    }

 
}
