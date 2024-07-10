/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ChuyenBayBUS;
import BUS.MayBayBUS;
import DAO.MayBayDAO;
import DTO.ChiTietSuDungDV;
import DTO.ChuyenBayDTO;
import DTO.KhachHangDTO;
import DTO.MayBayDTO;
import GUI.datve.Pn_SelectDichVu;
import GUI.datve.MenuDatVe;
import static GUI.datve.MenuDatVe.btn_CCN;
import static GUI.datve.MenuDatVe.pn_View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author huhuh
 */
public class aircraft extends JPanel {

    private Font sgUI20 = new Font("Segoe UI", Font.BOLD, 20);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTabbedPane tabbedPane2 = new JTabbedPane();
    JTabbedPane tabbedPaneCB = new JTabbedPane();

    public seatSetting a, b, c, d;
    public static ArrayList<KhachHangDTO> KHlist = MenuDatVe.KHlList;
    ;
    //public static ArrayList<String> MaGheLlist = new ArrayList<>();
    public static ArrayList<ChiTietSuDungDV> listCT = new ArrayList<>();
    pnKhachHang pn_KhachHang;
    pnKhachHang pn_KhachHang2;
    private Font sgUI14b = new Font("Segoe UI", Font.BOLD, 14);

    public aircraft(String machuyenbay, int SL, String gheChosen) throws SQLException, ParseException {
        ChuyenBayDTO cbdto = ChuyenBayBUS.loadCB(machuyenbay);
        MayBayDTO mb = MayBayDAO.LoadMayBay(cbdto.getMaMayBay());

        String[] dayghe = mb.getCautrucBus().split("-");
        ArrayList<Integer> daygheint = new ArrayList<>();
        int soghe1hang = 0;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(dayghe[i]) != 0) {
                daygheint.add(Integer.parseInt(dayghe[i]));
                soghe1hang += daygheint.get(count);
                count++;
            }

        }
        int sohang = mb.getSLbus() / soghe1hang;

        a = new seatSetting(mb.getCautrucBus(), mb.getSLbus(), 1, machuyenbay, "Bussiness", SL, gheChosen);
        b = new seatSetting(mb.getCautrucEco(), mb.getSLeco(), sohang + 1, machuyenbay, "Economy", SL, gheChosen);

        tabbedPane.add(a, "Business");
        tabbedPane.add(b, "Economy");
        add(tabbedPane, BorderLayout.CENTER);

    }

    public aircraft(String machuyenbay, int SL, String gheChosen, int dis) throws SQLException, ParseException {
        ChuyenBayDTO cbdto = ChuyenBayBUS.loadCB(machuyenbay);
        MayBayDTO mb = MayBayDAO.LoadMayBay(cbdto.getMaMayBay());

        String[] dayghe = mb.getCautrucBus().split("-");
        ArrayList<Integer> daygheint = new ArrayList<>();
        int soghe1hang = 0;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(dayghe[i]) != 0) {
                daygheint.add(Integer.parseInt(dayghe[i]));
                soghe1hang += daygheint.get(count);
                count++;
            }

        }
        int sohang = mb.getSLbus() / soghe1hang;

        a = new seatSetting(mb.getCautrucBus(), mb.getSLbus(), 1, machuyenbay, "Bussiness", SL, gheChosen);
        b = new seatSetting(mb.getCautrucEco(), mb.getSLeco(), sohang + 1, machuyenbay, "Economy", SL, gheChosen);

        tabbedPane.add(a, "Business");
        tabbedPane.add(b, "Economy");
        tabbedPane.setEnabledAt(dis, false);
        add(tabbedPane, BorderLayout.CENTER);

    }

    public aircraft(String machuyenbay, String machuyenbayve, int SL, String gheChosen, int dis, int dis2, int KhuHoi) throws SQLException, ParseException {

        ChuyenBayDTO cbdto = ChuyenBayBUS.loadCB(machuyenbay);
        MayBayDTO mb = MayBayBUS.loadMB(cbdto.getMaMayBay());

        String[] dayghe = mb.getCautrucBus().split("-");
        ArrayList<Integer> daygheint = new ArrayList<>();
        int soghe1hang = 0;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(dayghe[i]) != 0) {
                daygheint.add(Integer.parseInt(dayghe[i]));
                soghe1hang += daygheint.get(count);
                count++;
            }

        }
        int sohang = mb.getSLbus() / soghe1hang;

        a = new seatSetting(mb.getCautrucBus(), mb.getSLbus(), 1, machuyenbay, "Bussiness", SL, gheChosen, 0);
        b = new seatSetting(mb.getCautrucEco(), mb.getSLeco(), sohang + 1, machuyenbay, "Economy", SL, gheChosen, 0);

        tabbedPane.add(a, "Business");
        tabbedPane.add(b, "Economy");
        tabbedPane.setEnabledAt(dis, false);

        if (KhuHoi == 1) {
            cbdto = ChuyenBayBUS.loadCB(machuyenbayve);
            mb = MayBayBUS.loadMB(cbdto.getMaMayBay());

            dayghe = mb.getCautrucBus().split("-");
            daygheint = new ArrayList<>();
            soghe1hang = 0;
            count = 0;
            for (int i = 0; i < 3; i++) {
                if (Integer.parseInt(dayghe[i]) != 0) {
                    daygheint.add(Integer.parseInt(dayghe[i]));
                    soghe1hang += daygheint.get(count);
                    count++;
                }

            }
            c = new seatSetting(mb.getCautrucBus(), mb.getSLbus(), 1, machuyenbayve, "Bussiness", SL, gheChosen, 1);
            d = new seatSetting(mb.getCautrucEco(), mb.getSLeco(), sohang + 1, machuyenbayve, "Economy", SL, gheChosen, 1);
            tabbedPane2.add(c, "Business");
            tabbedPane2.add(d, "Economy");
            tabbedPane2.setEnabledAt(dis2, false);
        }

        JScrollPane scrollPane = new JScrollPane(tabbedPane);
        JScrollPane scrollPane2 = new JScrollPane(tabbedPane2);

        init(scrollPane, scrollPane2, KhuHoi);
    }

    public class pnKhachHang extends JPanel {

        final JComboBox cbbKH;
        JTable jTable;
        JButton btnChonGhe;
        DefaultTableModel model;

        public pnKhachHang(String DiVe) {
            btn_CCN.setEnabled(true);
            cbbKH = new JComboBox();
            btnChonGhe = new JButton("Chọn ghế");
            //loadItemKH(cbbKH,DiVe);
            if (!listCT.isEmpty()) {
                listCT.clear();
            }
            init(DiVe);
            System.out.println(MenuDatVe.MaGheList.size());
            System.out.println(MenuDatVe.MaGheListVe.size());
        }

//    public void loadItemKH( JComboBox cbbtmp, String DiVe) {
//            //KHlist.clear();
//            //KHlist = MenuDatVe.KHlList;
//            for (KhachHangDTO khdto : KHlist) {
//                cbbtmp.addItem(khdto.getTenKH());
//                if(DiVe.equals("Đi"))
//                MenuDatVe.MaGheList.add("");
//                else if(DiVe.equals("Về"))
//                MenuDatVe.MaGheListVe.add("");
//                ChiTietSuDungDV ctsd = new ChiTietSuDungDV();
//                ctsd.setMaKH(khdto.getMaKH());
//                ctsd.setTenKH(khdto.getTenKH());
//                //ctsd.setMaGhedi("");
//                listCT.add(ctsd);
//            }
//        }
        public void init(String DiVe) {

            setLayout(new BorderLayout());
            setPreferredSize(new Dimension(300, 1300));

            JPanel pn_Title = new JPanel(new GridLayout(2, 1));
            pn_Title.setBackground(Color.white);
            pn_Title.setPreferredSize(new Dimension(300, 50));

            JLabel lb1 = new JLabel("Chọn chỗ ngồi");
            lb1.setFont(sgUI20);
            lb1.setForeground(Color.decode("#00CCCC"));
            lb1.setHorizontalAlignment(SwingConstants.CENTER);
            lb1.setVerticalAlignment(SwingConstants.CENTER);
            JLabel lb2 = new JLabel("Vui lòng chọn khách hàng để chọn ghế");
            lb1.setFont(sgUI13);
            pn_Title.add(lb1);
            pn_Title.add(lb2);

            JPanel pn_Combobox = new JPanel(new BorderLayout());
            pn_Combobox.setPreferredSize(new Dimension(300, 1250));

            JPanel pn_Content = new JPanel(new BorderLayout(30, 30));
            pn_Content.setBackground(Color.white);

            JPanel pnChon = new JPanel(new BorderLayout(10, 10));
            pnChon.setBackground(Color.white);

            cbbKH.setBackground(Color.white);
            cbbKH.setPreferredSize(new Dimension(100, 50));
            cbbKH.setBorder(new MatteBorder(2, 0, 0, 0, Color.white));

            btnChonGhe.setBackground(Color.decode("#59D4FD"));
            btnChonGhe.setPreferredSize(new Dimension(100, 50));
            btnChonGhe.setBorder(new MatteBorder(10, 20, 5, 20, Color.white));

            pnChon.add(cbbKH, BorderLayout.CENTER);
            pnChon.add(btnChonGhe, BorderLayout.SOUTH);

//        JPanel pn1 = new JPanel();
//        pn1.setPreferredSize(new Dimension(300,1000));
            //pn_Content.setPreferredSize(new Dimension(300,500));
            jTable = new JTable() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable.setBackground(Color.white);
            JScrollPane jScrollPane = new JScrollPane(jTable);
            jScrollPane.setPreferredSize(new Dimension(300, 225));
            jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JTableHeader tableHeader = jTable.getTableHeader();
            DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTable.getTableHeader().getDefaultRenderer();
            headerRenderer.setHorizontalAlignment(JLabel.CENTER);
            model = (DefaultTableModel) jTable.getModel();
            model.setColumnIdentifiers(new Object[]{
                "Mã khách hàng", "Họ tên", "Mã ghế"
            });
//        for (NhanVienDTO s : NVLIST) {
//            if (s.getXuLy() != 1) {
//                model.addRow(new Object[]{
//                    "NAK","Ghế 1"
//                });
//                model.addRow(new Object[]{
//                    "NAK","Ghế 1"
//                });
//            }
//        }
            JPanel pn_Button = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        pn_Button.setPreferredSize(new Dimension(300,300));
            pn_Button.setBackground(Color.white);
//        JButton btn_QL = new JButton("Quay lại");
//        btn_QL.setBorder(new MatteBorder(4, 4, 4, 4, Color.white));
//        btn_QL.setBackground(Color.decode("#FFCCCC"));

//        pn_Button.add(btn_QL);
            JButton btn_OK = new JButton("TIẾP THEO");
            btn_OK.setBorder(new MatteBorder(4, 16, 16, 16, Color.white));
            btn_OK.setPreferredSize(new Dimension(225, 60));
            pn_Button.setPreferredSize(new Dimension(250, 75));
            btn_OK.setBackground(Color.decode("#00F5E1"));
            btn_OK.setForeground(Color.white);
            btn_OK.setFont(sgUI14b);
            pn_Button.add(btn_OK);

            btn_OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkPickCho(listCT) == true) {
                        Pn_SelectDichVu dv = new Pn_SelectDichVu(listCT);
//                    for (ChiTietSuDungDV x : listCT) {
////                        //System.out.println(""+x.toString());
////                        System.out.println(""+listCT.size());
////                        System.out.println("" + x.getMaKH());
////                        System.out.println("Tên:   " + x.getTenKH());
////                        System.out.println("1:   " + x.getMaGhedi());
////                        System.out.println("2:   " + x.getMaGheve());
//                    }    
                        pn_View.add(dv, "page5");
                        MenuDatVe.cardLayout.show(pn_View, "page5");
                    } else {
                        JOptionPane.showMessageDialog(null, "Còn hành khách chưa chọn ghế", "Thông báo", JOptionPane.OK_OPTION);
                    }

                }
            });

            pn_Content.add(pnChon, BorderLayout.NORTH);
            pn_Content.add(pn_Button, BorderLayout.SOUTH);
            pn_Content.add(jScrollPane, BorderLayout.CENTER);

            JPanel pn2 = new JPanel();
            pn2.setPreferredSize(new Dimension(300, 500));
            pn2.setBackground(Color.white);

            //pn_Combobox.add(cbb,BorderLayout.NORTH);
            pn_Combobox.add(pn_Content, BorderLayout.NORTH);
            pn_Combobox.add(pn2, BorderLayout.CENTER);

//        pn_Khach.add(pn_Title, BorderLayout.NORTH);
//        pn_Khach.add(pn_Combobox, BorderLayout.CENTER);
            add(pn_Title, BorderLayout.NORTH);
            add(pn_Combobox, BorderLayout.CENTER);
        }

    }

    public void init(JScrollPane scrollPane, JScrollPane scrollPane2, int KhuHoi) {
        setLayout(new BorderLayout());

        tabbedPaneCB.setBackground(Color.white);

        JPanel contentChieuDi = new JPanel(new BorderLayout());

        pn_KhachHang = new pnKhachHang("Đi");
        pn_KhachHang2 = new pnKhachHang("Về");

        contentChieuDi.add(pn_KhachHang, BorderLayout.WEST);
        contentChieuDi.add(scrollPane, BorderLayout.CENTER);

        tabbedPaneCB.add(contentChieuDi, "Chuyến bay chiều đi");

        if (KhuHoi == 1) {
            JPanel contentChieuVe = new JPanel(new BorderLayout());

            contentChieuVe.add(pn_KhachHang2, BorderLayout.WEST);
            contentChieuVe.add(scrollPane2, BorderLayout.CENTER);
            tabbedPaneCB.add(contentChieuVe, "Chuyến bay chiều về");
        }

        add(tabbedPaneCB, BorderLayout.CENTER);
//        KHlist.clear();
//        KHlist = MenuDatVe.KHlList;
        for (KhachHangDTO khdto : KHlist) {
            String tmp = khdto.getMaKH() + ": " + khdto.getTenKH();
            pn_KhachHang.cbbKH.addItem(tmp);
            pn_KhachHang2.cbbKH.addItem(tmp);
            pn_KhachHang.model.addRow(new Object[]{
                khdto.getMaKH(), khdto.getTenKH(), ""
            });
            pn_KhachHang2.model.addRow(new Object[]{
                khdto.getMaKH(), khdto.getTenKH(), ""
            });
            MenuDatVe.MaGheList.add("");
            MenuDatVe.MaGheListVe.add("");
            ChiTietSuDungDV ctsd = new ChiTietSuDungDV();
            ctsd.setMaKH(khdto.getMaKH());
            ctsd.setTenKH(khdto.getTenKH());
            ctsd.setMaGhedi("");
            ctsd.setMaGheve("");
            listCT.add(ctsd);

        }

        pn_KhachHang2.cbbKH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = pn_KhachHang2.cbbKH.getSelectedIndex();
                //System.out.println(index);
                if (MenuDatVe.hangghe2C.equals("Bussiness")) {
                    if (MenuDatVe.MaGheListVe.get(index).equals("")) {
                        c.a.greenButtonCount = 0;
                    } else {
                        c.a.greenButtonCount = 1;
                    }
                    for (String mg : MenuDatVe.MaGheListVe) {
                        c.setPicked(mg);
                    }
                    c.setChosen(MenuDatVe.MaGheListVe.get(index));
                } else {
                    if (MenuDatVe.MaGheListVe.get(index).equals("")) {
                        d.a.greenButtonCount = 0;
                    } else {
                        d.a.greenButtonCount = 1;
                    }
                    for (String mg : MenuDatVe.MaGheListVe) {
                        d.setPicked(mg);
                    }
                    d.setChosen(MenuDatVe.MaGheListVe.get(index));
                }
                //KHlist.clear();

//                    //MenuDatVe.MaGheList.clear();
//                    for (ChiTietSuDungDV j : listCT) {
//                        j.toString();
//                    }
//                }
            }

//System.out.println(index);
//            }
        });
        pn_KhachHang2.btnChonGhe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < MenuDatVe.MaGheListVe.size(); i++) {
                    String x = MenuDatVe.MaGheListVe.get(i);
                    for (int j = 0; j < KHlist.size(); j++) {
                        KhachHangDTO khdto = KHlist.get(j);
                        if (i == j) { // So sánh vị trí của x và khdto
                            boolean existed = false;

                            // Kiểm tra xem tên khách hàng đã có trong bảng chưa
                            for (int row = 0; row < pn_KhachHang2.model.getRowCount(); row++) {
                                if ((pn_KhachHang2.model.getValueAt(row, 1).equals(khdto.getTenKH())) && (pn_KhachHang2.model.getValueAt(row, 0).equals(khdto.getMaKH()))) {
                                    // Nếu tên khách hàng đã có trong bảng, sửa lại nội dung của dòng đó
                                    pn_KhachHang2.model.setValueAt(x, row, 2);

                                    // Cập nhật thông tin trong listCT nếu cần
                                    for (ChiTietSuDungDV t : listCT) {
                                        if (t.getMaKH().equals(khdto.getMaKH())) {
                                            t.setMaGheve(x);
                                        }
                                    }

                                    existed = true;
                                    break;
                                }
                            }

                            // Nếu tên khách hàng chưa có trong bảng, thêm dòng mới
                            if (!existed) {
                                pn_KhachHang2.model.addRow(new Object[]{
                                    khdto.getMaKH(), khdto.getTenKH(), ""
                                });
                                ChiTietSuDungDV ctsd = new ChiTietSuDungDV();
                                ctsd.setMaKH(khdto.getMaKH());
                                ctsd.setMaGheve(x);
                                ctsd.setTenKH(khdto.getTenKH());

                                // Kiểm tra và cập nhật thông tin trong listCT
                                for (ChiTietSuDungDV t : listCT) {
                                    if (t.getMaKH().equals(ctsd.getMaKH())) {
                                        t.setMaGheve(ctsd.getMaGheve());
                                    }
                                }
//
//                        listCT.add(ctsd);
                            }
                        }
                    }
                }
            }
//            public void actionPerformed(ActionEvent e) {
//                 for (int i = 0; i < MenuDatVe.MaGheListVe.size(); i++) {
//                    String x = MenuDatVe.MaGheListVe.get(i);
//                    for (int j = 0; j < KHlist.size(); j++) {
//                        KhachHangDTO khdto = KHlist.get(j);
//                        if (i == j) { // So sánh vị trí của x và khdto
//                            boolean existed = false;
//                            for (int row = 0; row < pn_KhachHang2.model.getRowCount(); row++) {
//                                if (pn_KhachHang2.model.getValueAt(row, 0).equals(khdto.getTenKH())) {
//                                    pn_KhachHang2.model.setValueAt(x, row, 1);
//                                    existed = true;
//                                    break;
//                                }
//                            }
//                            if (!existed) {
//                                pn_KhachHang2.model.addRow(new Object[]{
//                                    khdto.getTenKH(), x
//                                });
//                                ChiTietSuDungDV ctsd = new ChiTietSuDungDV();
//                                ctsd.setMaKH(khdto.getMaKH());
//                                ctsd.setMaGheve(x);
//                                ctsd.setTenKH(khdto.getTenKH());
//                                System.out.println("" + khdto.getMaKH() + x + ctsd.getTenKH());
//                                for (ChiTietSuDungDV t : listCT) {
//                                    if (t.getMaKH().equals(ctsd.getMaKH()) && !t.getMaGheve().equals(ctsd.getMaGheve())) {
//    //                                        t.setTenKH(ctsd.getTenKH());
//                                        t.setMaGheve(ctsd.getMaGheve());
//                                    }
//                                }
//                                    //listCT.add(ctsd);  
//                                }
//                            }
//                        }
//                    }
//            }
        });

        pn_KhachHang.cbbKH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int index = pn_KhachHang.cbbKH.getSelectedIndex();
                System.out.println(index);
                System.out.println(index);
                if (MenuDatVe.hangghe1C.equals("Bussiness")) {
                    if (MenuDatVe.MaGheList.get(index).equals("")) {
                        a.a.greenButtonCount = 0;
                    } else {
                        a.a.greenButtonCount = 1;
                    }
                    for (String mg : MenuDatVe.MaGheList) {
                        a.setPicked(mg);
                    }
                    a.setChosen(MenuDatVe.MaGheList.get(index));
                } else {
                    if (MenuDatVe.MaGheList.get(index).equals("")) {
                        b.a.greenButtonCount = 0;
                    } else {
                        b.a.greenButtonCount = 1;
                    }
                    for (String mg : MenuDatVe.MaGheList) {
                        b.setPicked(mg);
                    }
                    b.setChosen(MenuDatVe.MaGheList.get(index));
                }

                //KHlist.clear();
//                KHlist = MenuDatVe.KHlList;
//                    //MenuDatVe.MaGheList.clear();
//                    for (ChiTietSuDungDV j : listCT) {
//                        j.toString();
//                    }
//                }
            }

//System.out.println(index);
//            }
        });
        pn_KhachHang.btnChonGhe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < MenuDatVe.MaGheList.size(); i++) {
                    if (!MenuDatVe.MaGheList.get(i).isBlank()) {
                        String x = MenuDatVe.MaGheList.get(i);
                        for (int j = 0; j < KHlist.size(); j++) {
                            KhachHangDTO khdto = KHlist.get(j);
                            if (i == j) { // So sánh vị trí của x và khdto
                                boolean existed = false;
                                for (int row = 0; row < pn_KhachHang.model.getRowCount(); row++) {
                                    if ((pn_KhachHang.model.getValueAt(row, 1).equals(khdto.getTenKH())) && (pn_KhachHang.model.getValueAt(row, 0).equals(khdto.getMaKH()))) {
                                        pn_KhachHang.model.setValueAt(x, row, 2);
                                        for (ChiTietSuDungDV t : listCT) {
                                            if (t.getMaKH().equals(khdto.getMaKH())) {
                                                t.setMaGhedi(x);
                                            }
                                        }
                                        existed = true;
                                        break;
                                    }
                                }
                                if (!existed) {
                                    pn_KhachHang.model.addRow(new Object[]{
                                        khdto.getMaKH(), khdto.getTenKH(), x
                                    });
                                    ChiTietSuDungDV ctsd = new ChiTietSuDungDV();
                                    ctsd.setMaKH(khdto.getMaKH());
                                    ctsd.setMaGhedi(x);
                                    ctsd.setTenKH(khdto.getTenKH());
                                    for (ChiTietSuDungDV t : listCT) {
                                        if (t.getMaKH().equals(ctsd.getMaKH())) {
                                            t.setMaGhedi(ctsd.getMaGhedi());
                                        }
                                    }
//
//                        listCT.add(ctsd);
                                }
                            }
                        }
                    }
                }

//                for (int i = 0; i < MenuDatVe.MaGheList.size(); i++) {
//                    String x = MenuDatVe.MaGheList.get(i);
//                    for (int j = 0; j < KHlist.size(); j++) {
//                        KhachHangDTO khdto = KHlist.get(j);
//                        if (i == j) { // So sánh vị trí của x và khdto
//                            System.out.println(""+i+"  "+j);
//                            boolean existed = false;
//                            for (int row = 0; row < pn_KhachHang.model.getRowCount(); row++) {
//                                if (pn_KhachHang.model.getValueAt(row, 0).equals(khdto.getTenKH())) {
//                                    pn_KhachHang.model.setValueAt(x, row, 1);
//                                    existed = true;
//                                    break;
//                                }
//                            }
//                            if (!existed) {
//                                pn_KhachHang.model.addRow(new Object[]{
//                                    khdto.getTenKH(), x
//                                });
//                                ChiTietSuDungDV ctsd = new ChiTietSuDungDV();
//                                ctsd.setMaKH(khdto.getMaKH());
//                                ctsd.setMaGhedi(x);
//                                ctsd.setTenKH(khdto.getTenKH());
//                                System.out.println("ffffffffff" + khdto.getMaKH() + x + ctsd.getTenKH());
//                                for (ChiTietSuDungDV t : listCT) {
//                                    System.out.println(t.getMaKH()+"  "+ ctsd.getMaKH() + "    "+t.getMaGhedi()+" "+ctsd.getMaGhedi());
//                                    if (t.getMaKH().equals(ctsd.getMaKH()) && !t.getMaGhedi().equals(ctsd.getMaGhedi())) {
//    //                                        t.setTenKH(ctsd.getTenKH());
//                                        t.setMaGhedi(ctsd.getMaGhedi());
//                                        System.out.println(""+t.getMaGhedi());
//                                    }
//                                }
//                                    //listCT.add(ctsd);  
//                            }
//                        }
//                    }
//                }
            }
        });
    }

    public void setIndex(int index, String khuhoi) {
        if (khuhoi.equals("Đi")) {
            if (index == 0) {
                tabbedPane.setSelectedIndex(0);
            } else {
                tabbedPane.setSelectedIndex(1);
            }
        } else if (khuhoi.equals("Về")) {
            if (index == 0) {
                tabbedPane2.setSelectedIndex(0);
            } else {
                tabbedPane2.setSelectedIndex(1);
            }
        }
    }

    public boolean checkPickCho(ArrayList<ChiTietSuDungDV> list) {
        if (MenuDatVe.khuhoi == 1) {
            for (ChiTietSuDungDV x : list) {
                System.out.println("" + MenuDatVe.ma2c);
                if (x.getMaGhedi().equals("")) {
                    System.out.println("" + x.getMaGhedi());
                    return false;
                }
                if (x.getMaGheve().equals("")) {
                    System.out.println("" + x.getMaGheve());
                    return false;
                }
            }
        }
        if (MenuDatVe.khuhoi == 0) {
            for (ChiTietSuDungDV x : list) {
                System.out.println("ma gh di" + x.getMaGhedi());
                if (x.getMaGhedi().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

}
