package GUI.datve;

import BUS.DichVuBUS;
import DTO.ChiTietSuDungDV;
import DTO.DichVuDTO;
import DTO.KhachHangDTO;
import DTO.SuDungDichVuDTO;
import GUI.PanelVeBay;
import GUI.aircraft;
import GUI.datve.LapHoaDon;
import GUI.datve.MenuDatVe;
import static GUI.datve.MenuDatVe.btn_DVBT;
import static GUI.datve.MenuDatVe.pn_View;
import static GUI.datve.Panel_ThongTinKH.Aircraft;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class Pn_SelectDichVu extends JPanel {
    
    JProgressBar pb = new JProgressBar();
    JPanel pnSelectDichVu = new JPanel();
    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
    Font sgUI25b = new Font("Segoe UI", Font.BOLD, 25);
    public static ArrayList<KhachHangDTO> KHllist;
    ArrayList<DichVuDTO> listDV = DichVuBUS.getListDichVu();
    public static ArrayList<ChiTietSuDungDV> listCT;
    public static LapHoaDon lhd;
    public boolean checkTimeNow(Date date) {

        Calendar cd = Calendar.getInstance();

        cd.setTime(date);

        Date d = new Date();

        return true;

    }

    public Pn_SelectDichVu(ArrayList<ChiTietSuDungDV> list) {
        btn_DVBT.setEnabled(true);
        listCT = list;
//        for (ChiTietSuDungDV x : list) {
//                    //System.out.println(""+x.toString());
//                    System.out.println(""+list.size());
//                    System.out.println("" + x.getMaKH());
//                    System.out.println("Tên:   " + x.getTenKH());
//                    System.out.println("1:   " + x.getMaGhedi());
//                    System.out.println("2:   " + x.getMaGheve());
//                }
        initComponents();
//        btnXuly.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Date dateNow = new Date();
//                String error = "";
//                if (txtMaDV.getText().trim().length() == 0) {
//                    error += "Vui lòng chọn dịch vụ muốn thuê\n";
//                }
//                if (error.length() == 0) {
//                    if (dateNgaySD.getDate() == null) {
//                        error += "Vui lòng chọn ngày muốn thuê\n";
//                    }
////                    if (txtSLDV.getText().trim().length() == 0) {
////                        error += "Vui lòng nhập số lượng";
////                        txtSLDV.requestFocus();
////                    }
//                    if (error.length() == 0) {
//                        try {
//                            int SL = Integer.parseInt(txtSLDV.getText());
//                            if (SL <= 0) {
//                                JOptionPane.showMessageDialog(null, "Số lượng là số lớn hơn 0", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                            } else {
//                                if (checkTimeNow(dateNgaySD.getDate())) {
//                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                                    SuDungDichVuDTO sdDV = new SuDungDichVuDTO();
//
//                                    sdDV.setMaDV(txtMaDV.getText());
//                                    sdDV.setSoLuong(SL);
//                                    sdDV.setDonGia(SL * Integer.parseInt(txtGiaDV.getText()));
//                                    sdDV.setXuLy(0);
//
//                                    DichVuDTO dv = new DichVuDTO();
//                                    dv.setMaDV(txtMaDV.getText());
//                                    dv.setTenDV(txtTenDV.getText());
//                                    dv.setGiaDV(Integer.parseInt(txtGiaDV.getText()));
//                                    dv.setXuLy(0);
//                                    dv.setTenLoaiDV(txtLoaiDV.getText());
//
////                                    DatPhongGUI.listDV.add(dv);
////                                    DatPhongGUI.listSDDV.add(sdDV);
////                                    DatPhongGUI.renderDV(DatPhongGUI.tbDV);
////                                    dispose();
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "Ngày sử dụng phải lớn hơn hoặc bằng ngày hiện tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                }
//
//                            }
//                        } catch (Exception ex) {
//                            JOptionPane.showMessageDialog(null, "Số lượng là số nguyên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, error, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, error, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        });
//    }
    }
//    public Pn_SelectDichVu(int i) {
//        initComponents();
//        btnXuly.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Date dateNow = new Date();
//                String error = "";
//                if (txtMaDV.getText().trim().length() == 0) {
//                    error += "Vui lòng chọn dịch vụ muốn thuê\n";
//                }
//                if (error.length() == 0) {
//                    if (dateNgaySD.getDate() == null) {
//                        error += "Vui lòng chọn ngày muốn thuê\n";
//                    }
////                    if (txtSLDV.getText().trim().length() == 0) {
////                        error += "Vui lòng nhập số lượng";
////                        txtSLDV.requestFocus();
////                    }
//                    if (error.length() == 0) {
//                        try {
//                            int SL = Integer.parseInt(txtSLDV.getText());
//                            if (SL <= 0) {
//                                JOptionPane.showMessageDialog(null, "Số lượng là số lớn hơn 0", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                            } else {
//                                if (checkTimeNow(dateNgaySD.getDate())) {
//                                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//
//                                    DichVuDTO dv = new DichVuDTO();
//                                    dv.setMaDV(txtMaDV.getText());
//                                    dv.setTenDV(txtTenDV.getText());
//                                    dv.setGiaDV(Integer.parseInt(txtGiaDV.getText()));
//                                    dv.setXuLy(1);
//                                    dv.setTenLoaiDV(txtLoaiDV.getText());
//
////                                    FrameXemVe.dvdto = dv;
////                                    FrameXemVe.SL = SL;
////                                    //FrameOrderRoom.ngayDV = sdf.format(dateNgaySD.getDate());
////                                    FrameXemVe.btnChonDV.doClick();
//                                    //dispose();
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "Ngày sử dụng phải lớn hơn hoặc bằng ngày hiện tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                }
//
//                            }
//                        } catch (HeadlessException | NumberFormatException ex) {
//                            JOptionPane.showMessageDialog(null, "Số lượng là số nguyên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, error, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, error, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        });
//    }
    
    
    private JPanel pnContent = new JPanel();
    private JPanel pnSearch = new JPanel();
    private JPanel pnSearchInput = new JPanel();
    private JTextField txtSearch = new JTextField();
    private JPanel pnTable = new JPanel();
    private JScrollPane scp = new JScrollPane();
    private JTable tbDV = new JTable() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JPanel pnInput = new JPanel();
    private JButton btnSearch = new JButton();
    private JPanel pnSelect = new JPanel();
    private JPanel pnCenter = new JPanel();
    private JCheckBox ckbAnUong = new JCheckBox("Ăn sáng");
    private JCheckBox ckbSacDep = new JCheckBox("Ăn trưa");
    private JCheckBox ckbGiaiTri = new JCheckBox("Ăn tối");
    private JCheckBox ckbTienIch = new JCheckBox("Nước");
    private JButton btnReset = new JButton("Làm mới");
    private JPanel pnDV = new JPanel();

    private JPanel pnMaDV = new JPanel();
    private JLabel lbMaDV = new JLabel("Mã dịch vụ:   ");
    private JTextField txtMaDV = new JTextField();

    private JPanel pnTenDV = new JPanel();
    private JLabel lbTenDV = new JLabel("Tên dịch vụ: ");
    private JTextField txtTenDV = new JTextField();

    private JPanel pnLoaiDV = new JPanel();
    private JLabel lbLoaiDV = new JLabel("Loại dịch vụ: ");
    private JTextField txtLoaiDV = new JTextField();

    private JPanel pnGiaDV = new JPanel();
    private JLabel lbGiaDV = new JLabel("Giá dịch vụ:  ");
    private JTextField txtGiaDV = new JTextField();

    private JPanel pnSLDV = new JPanel();
    private JLabel lbSLDV = new JLabel("Số lượng:     ");
    private JTextField txtSLDV = new JTextField();

    private JPanel pnSelectKH = new JPanel();
    private JPanel pnBTNChonKH = new JPanel();

    private JPanel pncbbChieu = new JPanel();
    private JLabel lbcbbChieu = new JLabel("Chọn chiều sử dụng dịch vụ:");
    private JDateChooser dateNgaySD = new JDateChooser();
    
    private JLabel lbSelectHK = new JLabel("Chọn hành khách sử dụng dịch vụ: ");
    private JButton btnChonKH = new JButton("Chọn dịch vụ");

    private JPanel pnbtnXoaDV = new JPanel();
    private JButton btnXoaDV  = new JButton("Xóa dịch vụ");
    
    private JPanel pnBtn = new JPanel();
    private JComboBox cbbKH = new JComboBox();
    private JComboBox cbbChieu;
    private JPanel pnBlank = new JPanel();
    private JButton btnXuly = new JButton("TIẾP THEO");
    private JButton btnQuayLai = new JButton("Quay lại");
    
    private JPanel pnbtn_next = new JPanel();

    ArrayList<JCheckBox> listCkb = new ArrayList<>();
    public void initComponents() {
        setSize(700, 1200);
        //setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());
        //setResizable(false);
        setBackground(Color.decode("#F8FFEB"));
        add(pnSelectDichVu, BorderLayout.CENTER);
        pnSelectDichVu.setLayout(new BorderLayout());
//        pnSelectDichVu.add(pb, BorderLayout.NORTH);
//        pb.setValue(0);
//        pb.setStringPainted(true);
//        pb.setForeground(Color.decode("#FFFDAD"));
//        pb.setBackground(Color.black);
//        pb.setVisible(true);
//
////        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        int counter = 0;
//        pb.setFont(new Font("MV Boli", Font.BOLD, 18));
//        while (counter <= 100) {
//            pb.setValue(counter);
//            try {
//                Thread.sleep(50);
//            } catch (Exception e) {
//            }
//            counter += 10;
//        }
//        pb.setString("Danh mục dịch vụ");
//        pb.setFont(sgUI25b);
        ckbAnUong.setFocusPainted(false);
        ckbAnUong.setFont(sgUI13b);
        ckbSacDep.setFocusPainted(false);
        ckbSacDep.setFont(sgUI13b);
        ckbGiaiTri.setFocusPainted(false);
        ckbGiaiTri.setFont(sgUI13b);
        ckbTienIch.setFocusPainted(false);
        ckbTienIch.setFont(sgUI13b);


        listCkb.add(ckbAnUong);
        listCkb.add(ckbGiaiTri);
        listCkb.add(ckbSacDep);
        listCkb.add(ckbTienIch);

        pnSelectDichVu.add(pnContent, BorderLayout.CENTER);
        pnContent.setLayout(new BorderLayout());
        pnContent.add(pnSearch, BorderLayout.NORTH);
        pnContent.add(pnCenter, BorderLayout.CENTER);
        pnContent.add(pnbtn_next, BorderLayout.SOUTH);
        

        pnSearch.setLayout(new BorderLayout());
        pnSearch.add(pnSearchInput, BorderLayout.EAST);
        pnSearch.setBackground(Color.decode("#F8FFEB"));

        pnSearchInput.setLayout(new BorderLayout());
        pnSearchInput.setBorder(new MatteBorder(10,0,0,10, Color.decode("#F8FFEB")));
        pnSearchInput.add(pnInput, BorderLayout.CENTER);
//        pnSearchInput.add(btnSearch, BorderLayout.EAST);
        ImageIcon iconFind = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/IconFind.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btnSearch.setIcon(iconFind);
        btnSearch.setBorder(new EmptyBorder(0, 5, 0, 0));
        btnSearch.setBackground(Color.decode("#FCFCFC"));
        btnSearch.setFocusPainted(false);

        pnInput.setLayout(new BorderLayout());
        pnInput.add(txtSearch, BorderLayout.CENTER);
        pnInput.add(btnSearch, BorderLayout.EAST);
        txtSearch.setBackground(Color.white);
        txtSearch.setBorder(new MatteBorder(1, 0, 0, 0, Color.decode("#F8FFEB")));
        pnInput.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#F8FFEB")), new MatteBorder(0, 0, 3, 0, Color.decode("#F8FFEB"))));
        txtSearch.setFont(sgUI13);
        txtSearch.setPreferredSize(new Dimension(200, 35));

        pnCenter.setBackground(Color.decode("#F8FFEB"));
        pnCenter.setLayout(new GridLayout(2, 1));
        pnCenter.add(pnTable);
        pnTable.setLayout(new BorderLayout());
        pnTable.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnTable.add(scp, BorderLayout.CENTER);
        pnSelect.setBackground(Color.decode("#F8FFEB"));
        pnTable.add(pnSelect, BorderLayout.EAST);
        pnTable.setBackground(Color.decode("#F8FFEB"));
        
        btnReset.setBackground(Color.decode("#E0E0E0"));
        for(JCheckBox x : listCkb){
            x.setBackground(Color.decode("#F8FFEB"));
        }
        pnSelect.setLayout(new GridLayout(6, 1));
        pnSelect.setBackground(Color.white);
        pnSelect.add(ckbAnUong);
        pnSelect.add(ckbSacDep);
        pnSelect.add(ckbGiaiTri);
        pnSelect.add(ckbTienIch);
        pnSelect.add(btnReset);
        

        pnCenter.add(pnDV);
        pnDV.setLayout(new GridLayout(3, 3));
        pnDV.setBackground(Color.decode("#F8FFEB"));

        pnDV.add(pnMaDV);
        pnMaDV.setBorder(new EmptyBorder(22, 50, 22, 50));
        pnMaDV.setLayout(new BorderLayout());
        pnMaDV.setBackground(Color.decode("#F8FFEB"));
        pnMaDV.add(lbMaDV, BorderLayout.WEST);
        pnMaDV.add(txtMaDV, BorderLayout.CENTER);

        pnDV.add(pnGiaDV);
        pnGiaDV.setBorder(new EmptyBorder(22, 50, 22, 50));
        pnGiaDV.setLayout(new BorderLayout());
        pnGiaDV.add(lbGiaDV, BorderLayout.WEST);
        pnGiaDV.add(txtGiaDV, BorderLayout.CENTER);

        
        pnDV.add(pnSLDV);
        pnSLDV.setBorder(new EmptyBorder(22, 50, 22, 50));
//        pnSLDV.setLayout(new BorderLayout());
//        pnSLDV.add(lbSLDV, BorderLayout.WEST);
//        pnSLDV.add(txtSLDV, BorderLayout.CENTER);
        
        pnDV.add(pnTenDV);   
        pnTenDV.setBorder(new EmptyBorder(22, 50, 22, 50));
        pnTenDV.setLayout(new BorderLayout());
        pnTenDV.add(lbTenDV, BorderLayout.WEST);
        pnTenDV.add(txtTenDV, BorderLayout.CENTER);


        pnDV.add(pnSelectKH);
        pnSelectKH.setBorder(new EmptyBorder(22, 50, 22, 25));
        pnSelectKH.setLayout(new BorderLayout());
        loadItemKH();
        cbbKH.setBackground(Color.white);
        pnSelectKH.add(lbSelectHK, BorderLayout.WEST);
        pnSelectKH.add(cbbKH, BorderLayout.CENTER);


        pnDV.add(pnBTNChonKH);
        pnBTNChonKH.setLayout(new BorderLayout());
        pnBTNChonKH.setBorder(new EmptyBorder(22, 100, 22, 100));
        btnChonKH.setFocusPainted(false);
        btnChonKH.setBackground(Color.decode("#CCFFCC"));
        pnBTNChonKH.add(btnChonKH, BorderLayout.SOUTH);

        pnDV.add(pnLoaiDV);
        pnLoaiDV.setBorder(new EmptyBorder(22, 50, 22, 50));
        pnLoaiDV.setLayout(new BorderLayout());
        pnLoaiDV.add(lbLoaiDV, BorderLayout.WEST);
        pnLoaiDV.add(txtLoaiDV, BorderLayout.CENTER);

        pnDV.add(pncbbChieu);
        pncbbChieu.setBorder(new EmptyBorder(22, 50, 22, 50));
        pncbbChieu.setLayout(new BorderLayout());
        loadItemChieu();
        cbbChieu.setBackground(Color.white);
        pncbbChieu.add(lbcbbChieu, BorderLayout.WEST);
        pncbbChieu.add(cbbChieu, BorderLayout.CENTER);

        pnDV.add(pnbtnXoaDV);
        pnbtnXoaDV.setLayout(new BorderLayout());
        pnbtnXoaDV.setBorder(new EmptyBorder(22, 100, 22, 100));
        btnXoaDV.setBackground(Color.decode("#FF9999"));
        btnXoaDV.setFocusPainted(false);
        pnbtnXoaDV.add(btnXoaDV, BorderLayout.SOUTH);
        
        txtMaDV.setEditable(false);
        txtTenDV.setEditable(false);
        txtLoaiDV.setEditable(false);
        txtGiaDV.setEditable(false);
//        pnBlank.setPreferredSize(new Dimension(200,50));
//        pnDV.add(pnBlank);
        btnChonKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                String tenKhachHang = (String) cbbKH.getSelectedItem();
                String chieu = (String) cbbChieu.getSelectedItem();
                if(txtMaDV.getText().isEmpty()){
                    JOptionPane.showConfirmDialog(null, "Vui lòng chọn dịch vụ để thêm", "Thông báo", JOptionPane.YES_OPTION);
                    check=false;
                }
                else if(chieu.equals("Cả hai chiều") && tenKhachHang.equals("Tất cả")){
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn muốn thêm dịch vụ "+txtTenDV.getText()+ " cho tất cả hành khách ở cả hai chiều" , "Thông báo", JOptionPane.YES_NO_OPTION);
                    if(choice==JOptionPane.OK_OPTION){
                        check = true;
                    }
                }
                else if(chieu.equals("Cả hai chiều")&& !tenKhachHang.equals("Tất cả")){
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn muốn thêm dịch vụ "+txtTenDV.getText()+ "cho hành khách "+tenKhachHang+" ở cả hai chiều" , "Thông báo", JOptionPane.YES_NO_OPTION);
                    if(choice==JOptionPane.OK_OPTION){
                        check = true;
                    }
                }
                else if(!chieu.equals("Cả hai chiều")&& tenKhachHang.equals("Tất cả")){
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn muốn thêm dịch vụ "+txtTenDV.getText()+ " cho tất cả hành khách ở " + chieu , "Thông báo", JOptionPane.YES_NO_OPTION);
                    if(choice==JOptionPane.OK_OPTION){
                        check = true;
                    }
                }
                else if(!chieu.equals("Cả hai chiều")&& !tenKhachHang.equals("Tất cả")){
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn thêm dịch vụ "+txtTenDV.getText()+ " cho hành khách: "+tenKhachHang +" ở " +chieu , "Thông báo", JOptionPane.YES_NO_OPTION);
                    if(choice==JOptionPane.OK_OPTION){
                        check = true;
                    }
                }
                if(check==true){
                    if(chieu.equals("Chiều đi")){
                        if(!tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                if(x.getTenKH().equals(tenKhachHang)){
                                    x.setMaDVdi(txtMaDV.getText());
                                }
                            }
                        }        
                        if(tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                 x.setMaDVdi(txtMaDV.getText());
                            }
                        }
                    }
                    if(chieu.equals("Chiều về")){
                        if(!tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                if(x.getTenKH().equals(tenKhachHang)){
                                    x.setMaDVve(txtMaDV.getText());
                                }
                            }
                        }        
                        if(tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                 x.setMaDVve(txtMaDV.getText());
                            }
                        }
                    }
                    if(chieu.equals("Cả hai chiều")){
                        if(!tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                if(x.getTenKH().equals(tenKhachHang)){
                                    x.setMaDVdi(txtMaDV.getText());
                                    x.setMaDVve(txtMaDV.getText());
                                }
                            }
                        }        
                        if(tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                x.setMaDVdi(txtMaDV.getText());
                                x.setMaDVve(txtMaDV.getText());
                            }
                        }
                    }
                }
                
//                for(ChiTietSuDungDV x : listCT){
//                    System.out.println(""+x.getTenKH());
//                    System.out.println(""+x.getMaKH());
//                    System.out.println(""+x.getMaGhe());
//                    System.out.println(""+x.getMaDV());
//                    System.out.println("\n");
//                }
            }
        });
        btnXoaDV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                String tenKhachHang = (String) cbbKH.getSelectedItem();
                String chieu = (String) cbbChieu.getSelectedItem();
                if(chieu.equals("Cả hai chiều") && tenKhachHang.equals("Tất cả")){
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa dịch vụ của tất cả hành khách ở cả hai chiều" , "Thông báo", JOptionPane.YES_NO_OPTION);
                    if(choice==JOptionPane.OK_OPTION){
                        check = true;
                    }
                }
                else if(chieu.equals("Cả hai chiều")&& !tenKhachHang.equals("Tất cả")){
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa dịch vụ của hành khách "+tenKhachHang+" ở cả hai chiều" , "Thông báo", JOptionPane.YES_NO_OPTION);
                    if(choice==JOptionPane.OK_OPTION){
                        check = true;
                    }
                }
                else if(!chieu.equals("Cả hai chiều")&& tenKhachHang.equals("Tất cả")){
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa dịch vụ của tất cả hành khách ở " + chieu , "Thông báo", JOptionPane.YES_NO_OPTION);
                    if(choice==JOptionPane.OK_OPTION){
                        check = true;
                    }
                }
                else if(!chieu.equals("Cả hai chiều")&& !tenKhachHang.equals("Tất cả")){
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa dịch vụ của hành khách: "+tenKhachHang +" ở " +chieu , "Thông báo", JOptionPane.YES_NO_OPTION);
                    if(choice==JOptionPane.OK_OPTION){
                        check = true;
                    }
                }
                if(check==true){
                    if(!tenKhachHang.equals("Tất cả")){
                        for(ChiTietSuDungDV x : listCT){
                            if(x.getTenKH().equals(tenKhachHang)){
                                x.setMaDVdi("no");
                            }
                        }
                    }        
                    if(tenKhachHang.equals("Tất cả")){
                        for(ChiTietSuDungDV x : listCT){
                             x.setMaDVdi("no");
                        }
                    }
                    if(chieu.equals("Chiều đi")){
                        if(!tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                if(x.getTenKH().equals(tenKhachHang)){
                                    x.setMaDVdi("no");
                                }
                            }
                        }        
                        if(tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                 x.setMaDVdi("no");
                            }
                        }
                    }
                    if(chieu.equals("Chiều về")){
                        if(!tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                if(x.getTenKH().equals(tenKhachHang)){
                                    x.setMaDVve("no");
                                }
                            }
                        }        
                        if(tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                 x.setMaDVve("no");
                            }
                        }
                    }
                    if(chieu.equals("Cả hai chiều")){       
                        if(tenKhachHang.equals("Tất cả")){
                            for(ChiTietSuDungDV x : listCT){
                                x.setMaDVdi("no");
                                x.setMaDVve("no");
                            }
                        }
                    }
                }
                
                
//                for(ChiTietSuDungDV x : listCT){
//                    System.out.println(""+x.getTenKH());
//                    System.out.println(""+x.getMaKH());
//                    System.out.println(""+x.getMaGhe());
//                    System.out.println(""+x.getMaDV());
//                    System.out.println("\n");
//                }
            }
        });

        pnbtn_next.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
        pnbtn_next.setBackground(Color.decode("#F8FFEB"));
        pnbtn_next.setBorder(new EmptyBorder(12, 50, 12, 50)); 
//        btnQuayLai.setFocusPainted(false);
//        btnQuayLai.setPreferredSize(new Dimension(150,30));
//        btnQuayLai.setBackground(Color.decode("#FFCCCC"));
//        pnbtn_next.add(btnQuayLai);
        
        btnXuly.setFocusPainted(false);
        btnXuly.setPreferredSize(new Dimension(225,40));
        btnXuly.setBackground(Color.decode("#00F5E1"));
        btnXuly.setForeground(Color.white);
        btnXuly.setFont(sgUI18b);
        pnbtn_next.add(btnXuly);
        
        btnXuly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> maloi =checkSl(listCT); 
                StringBuilder errorBuilder = new StringBuilder();
                if (maloi.size()==0) {
                    lhd = new LapHoaDon(listCT,MenuDatVe.closeWin);
                    
                    //MenuDatVe.setVisible(false);
                }else{
                    for (String x : maloi) {
                        errorBuilder.append(x).append(", ");
                    }
                    String error = errorBuilder.length() > 0 ? errorBuilder.substring(0, errorBuilder.length() - 2) : ""; 
                    JOptionPane.showMessageDialog(null, "Các mã dịch vụ sau: "+error+" không đủ số lượng\nVui lòng chọn dịch vụ khác", "Thông báo", JOptionPane.OK_OPTION);
                }
                
//                pn_View.add(lhd, "page6");
//                MenuDatVe.cardLayout.show(pn_View, "page6");
            }
        });

        pnMaDV.setBackground(Color.decode("#F8FFEB"));
        pnTenDV.setBackground(Color.decode("#F8FFEB"));
        pnLoaiDV.setBackground(Color.decode("#F8FFEB"));
        pnGiaDV.setBackground(Color.decode("#F8FFEB"));
        pnSLDV.setBackground(Color.decode("#F8FFEB"));
        pncbbChieu.setBackground(Color.decode("#F8FFEB"));
        pnSelectKH.setBackground(Color.decode("#F8FFEB"));
        pnBTNChonKH.setBackground(Color.decode("#F8FFEB"));
        pnbtnXoaDV.setBackground(Color.decode("#F8FFEB"));
        pnBtn.setBackground(Color.decode("#F8FFEB"));
        
        

        scp.getViewport().setBackground(Color.white);
        scp.setViewportView(tbDV);
        renderTB(listDV);
        btnReset.setFocusPainted(false);

        btnSearch.setMnemonic(KeyEvent.VK_S);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtSearch.getText().trim().length() == 0) {
                    txtSearch.setText("");
                    txtSearch.requestFocus();
                }
            }
        });
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                for (JCheckBox ckb : listCkb) {
                    ckb.setSelected(false);
                }
                ArrayList<DichVuDTO> listTmp = new ArrayList<>();
                for (DichVuDTO x : listDV) {
                    if (x.getTenDV().toLowerCase().contains(txtSearch.getText().toLowerCase())) {
                        listTmp.add(x);
                    }
                }
                if (listTmp.size() == 0) {
                    renderTB(listDV);
                } else {
                    renderTB(listTmp);
                }
            }
        });

        for (JCheckBox ckb : listCkb) {
            ckb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    txtSearch.setText("");
                    ArrayList<DichVuDTO> list = new ArrayList<>();
                    if (ckb.isSelected()) {
                        list = getLoai(ckb);
                        for (JCheckBox ckbox : listCkb) {
                            if (ckbox != ckb) {
                                if (ckbox.isSelected()) {
                                    list = addArray(list, getLoai(ckbox));
                                }
                            }
                        }
                        renderTB(list);
                    } else {
                        for (JCheckBox ckbox : listCkb) {
                            if (ckbox != ckb) {
                                if (ckbox.isSelected()) {
                                    list = addArray(list, getLoai(ckbox));
                                }
                            }
                        }
                        renderTB(list);
                    }
                }
            });
        }
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JCheckBox ckb : listCkb) {
                    ckb.setSelected(false);
                }
                renderTB(listDV);
            }
        });
    }

    public ArrayList<DichVuDTO> addArray(ArrayList<DichVuDTO> listA, ArrayList<DichVuDTO> listB) {
        for (DichVuDTO x : listB) {
            listA.add(x);
        }
        return listA;
    }

    public ArrayList<DichVuDTO> getLoai(JCheckBox ckb) {
        ArrayList<DichVuDTO> list = new ArrayList<>();
        for (DichVuDTO x : listDV) {
            if (x.getTenLoaiDV().equals(ckb.getText())) {
                list.add(x);
            }
        }
        return list;
    }

    public void renderTB(ArrayList<DichVuDTO> listDV) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã dịch vụ");
        dtm.addColumn("Tên dịch vụ");
        dtm.addColumn("Loại dịch vụ");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Giá");
        tbDV.setModel(dtm);
        tbDV.setShowGrid(false);
        tbDV.setIntercellSpacing(new Dimension(0, 0));
        tbDV.setRowHeight(30);
        tbDV.getColumnModel().getColumn(0).setPreferredWidth(5);
        tbDV.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbDV.getTableHeader().setPreferredSize(new Dimension(1, 30));
        tbDV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tbDV.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        int i = 1;
        for (DichVuDTO x : listDV) {
            if(x.getSoLuong()!=0) {
                Object data[] = {i, x.getMaDV(), x.getTenDV(), x.getTenLoaiDV(), x.getSoLuong(), x.getGiaDV()};
                dtm.addRow(data);
                i++;
            }
            
        }
        DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                JLabel lb = (JLabel) c;

                lb.setHorizontalAlignment(JLabel.CENTER);
                lb.setForeground(table.getForeground());
                if (isSelected) {
                    lb.setBackground(Color.decode("#F5EBE5"));
                } else {
                    lb.setBackground(Color.decode("#FFFFFF"));
                    
                }
//                if (column == tbDV.getColumnModel().getColumnIndex("STT")) {
//                    lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
//                    lb.setBackground(Color.decode("#99FF99"));
//                } else {
                    lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
//                }
                return lb;
            }
        };
        for (int j = 0; j < tbDV.getColumnCount(); j++) {
            tbDV.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
        }
        tbDV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    txtMaDV.setText(tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString());
                    txtTenDV.setText(tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Tên dịch vụ")).toString());
                    txtLoaiDV.setText(tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Loại dịch vụ")).toString());
                    txtGiaDV.setText(tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Giá")).toString());
                } catch (Exception ex) {
                    txtMaDV.setText("");
                    txtTenDV.setText("");
                    txtLoaiDV.setText("");
                    txtGiaDV.setText("");
                }
            }
        });
    }
    
public void loadItemKH() {
   //KHllist.clear();
    KHllist= MenuDatVe.KHlList;
    if(KHllist.size()>1){
        cbbKH.addItem("Tất cả");
    }
    for(KhachHangDTO khdto: KHllist) {
        cbbKH.addItem(khdto.getTenKH());   
    }
}

public void loadItemChieu() {
    if(!MenuDatVe.hangghe2C.equals("")){
        String Chieu[] = {"Cả hai chiều","Chiều đi", "Chiều về"};
        cbbChieu = new JComboBox(Chieu);
    }else{
        String Chieu[] = {"Chiều đi"};
        cbbChieu = new JComboBox(Chieu);
        cbbChieu.setEditable(false);
    }
}
//    public static void main(String[] args) {
//        new PanelSelectDichVu();
//    }
    public ArrayList<String> checkSl(ArrayList<ChiTietSuDungDV> listCT){
        ArrayList<DichVuDTO> dvlist = new DichVuBUS().getListDichVu();
        ArrayList<String> maloi = new ArrayList<>();
        for(ChiTietSuDungDV x : listCT){
            for(DichVuDTO dv : dvlist){
                if(x.getMaDVdi().equals(dv.getMaDV())){
                    dv.setSoLuong(dv.getSoLuong()-1);
                }
                if(x.getMaDVve().equals(dv.getMaDV())){
                    dv.setSoLuong(dv.getSoLuong()-1);
                }
            }
        }
        for(DichVuDTO dv : dvlist){
            if(dv.getSoLuong()<0){
                maloi.add(dv.getMaDV());
            } 
        }
        return maloi;
    }
}
