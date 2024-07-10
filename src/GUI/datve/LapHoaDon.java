package GUI.datve;

import BUS.ChuyenBayBUS;
import BUS.DichVuBUS;

import BUS.VeBayBUS;
import DTO.ChiTietSuDungDV;
import DTO.ChuyenBayDTO;
import DTO.DichVuDTO;
import DTO.KhachHangDTO;
import DTO.PhongDTO;
import DTO.SuDungDichVuDTO;
import DTO.VeBayDTO;
import GUI.LeTanGUI.ReceptionistGUI;
import GUI.PanelVeBay;
import GUI.ThanhToanGUI.ThanhToan;
import static GUI.aircraft.KHlist;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class LapHoaDon extends JFrame {

    private JPanel pnTop = new JPanel();
    private JPanel pnContent = new JPanel();
    private JPanel pnTitle = new JPanel();
    private JPanel pnRadio = new JPanel();
    public static int closeWin;
    private JLabel lbTitle = new JLabel("Lập hóa đơn");

    private JRadioButton rbtnKH = new JRadioButton("Thông tin khách hàng");
    private JRadioButton rbtnP = new JRadioButton("Thông tin ghế bay");
    private JRadioButton rbtnDV = new JRadioButton("Thông tin dịch vụ");
    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
    ArrayList<PhongDTO> listPhong = new ArrayList<>();
    public static ArrayList<ChiTietSuDungDV> listCT;
    ArrayList<DichVuDTO> listDV = new ArrayList<>();
    ArrayList<SuDungDichVuDTO> listSuDungDV = new ArrayList<>();
    ArrayList<DichVuDTO> listDVDTO = DichVuBUS.getListDV();
    String maCTT;

    public LapHoaDon(ArrayList<ChiTietSuDungDV> list, int close) {
//        PanelVeBay.mn.setVisible(false);
        closeWin=close;
        listCT = list;
//        listThuePhongDTO = ThuePhongBUS.getListTP_P(maCTT, listPhong);
//        listSuDungDV = SuDungDichVuBUS.getListSDDV_maDV(maCTT, listDV);
//        this.maCTT = maCTT;
       initComponents();
       addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(closeWin==1){
                    PanelVeBay.mn.setVisible(true);
                }
                else{
                    ReceptionistGUI.mn.setVisible(true);
                }
                
//                dispose();
            }
        });
    }

    public void initComponents() {
        setVisible(true);
        setSize(1400, 800);
        getContentPane().setBackground(Color.white);
        setTitle("Lập hóa đơn");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        lbTitle.setFont(sgUI18b);
        pnTop.setBackground(Color.white);
        pnTop.setLayout(new GridLayout(2, 1));
        pnTitle.setBackground(Color.white);
        pnTitle.add(lbTitle);
        pnTop.add(pnTitle);
        pnTop.add(pnRadio);

        pnRadio.add(rbtnKH);
        pnRadio.add(rbtnP);
        pnRadio.add(rbtnDV);

        rbtnKH.setSelected(true);
        rbtnKH.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rbtnKH.setSelected(true);
                rbtnP.setEnabled(false);
                rbtnP.setSelected(false);
                rbtnDV.setEnabled(false);
                rbtnDV.setSelected(false);
                pnContent.removeAll();
                pnContent.revalidate();
                pnContent.repaint();
                renderKH();
            }
        });
        rbtnP.setEnabled(false);
        rbtnDV.setEnabled(false);
        rbtnP.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (rbtnP.isEnabled()) {
                    rbtnP.setSelected(true);
                } else {
                    rbtnP.setSelected(false);
                }
                rbtnDV.setEnabled(false);
                rbtnDV.setSelected(false);
                pnContent.removeAll();
                pnContent.revalidate();
                pnContent.repaint();
                renderVe();
            }
        });

       

        rbtnDV.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (rbtnP.isSelected() && rbtnDV.isEnabled()) {
                    rbtnDV.setSelected(true);
                } else {
                    rbtnDV.setSelected(false);
                }
            }
        });

        add(pnTop, BorderLayout.NORTH);
        add(pnContent, BorderLayout.CENTER);
        renderKH();
    }

    
    private JPanel pnMidContent = new JPanel();
    private JPanel pnBottomContent = new JPanel();
    private ArrayList<JTextField> txtList = new ArrayList<>();
    private static Font sgUI18 = new Font("Segoe UI", Font.BOLD, 15);
    private JTable jt;
    private JScrollPane scpn = new JScrollPane();
    public void renderKH() {
        pnContent.removeAll();
        pnContent.revalidate();
        pnContent.repaint();
        //JPanel pnEmpty1 = new JPanel();
        JPanel pnCenter = new JPanel();
        //JPanel pnEmpty2 = new JPanel();

//        pnEmpty1.setBackground(Color.white);
//        pnEmpty2.setBackground(Color.white);
        pnContent.setLayout(new BorderLayout());
        //pnContent.add(pnEmpty1);
//        pnEmpty1.setBackground(Color.decode("#DDDDDD"));
//        pnEmpty2.setBackground(Color.decode("#DDDDDD"));
        pnContent.add(pnCenter,BorderLayout.CENTER);
        //pnContent.add(pnEmpty2);

        pnCenter.setBackground(Color.white);

        JPanel pnTitle1 = new JPanel();
        JLabel lbTitle1 = new JLabel("Thông tin khách hàng");
        lbTitle1.setFont(sgUI15);
        pnTitle1.setBackground(Color.white);
        pnTitle1.add(lbTitle1);

        JPanel pnInfoKH = new JPanel();
        pnInfoKH.setBorder(new EmptyBorder(10, 10, 10, 10));
//        pnInfoKH.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.black), new EmptyBorder(10, 10, 10, 10)));
        pnInfoKH.setBackground(Color.white);
        pnCenter.setLayout(new BorderLayout());
        pnCenter.add(pnTitle1, BorderLayout.NORTH);
        pnCenter.add(pnInfoKH, BorderLayout.CENTER);
        pnCenter.setBorder(new EmptyBorder(0, 0, 10, 0));

        pnInfoKH.setLayout(new BorderLayout());

        JPanel pnInfo = new JPanel();
        pnInfo.setBackground(Color.white);
        JPanel pnBtn = new JPanel();
        pnBtn.setBackground(Color.white);

        pnInfoKH.add(pnInfo, BorderLayout.CENTER);
        pnInfoKH.add(pnBtn, BorderLayout.SOUTH);
        pnBtn.setLayout(new BorderLayout());
        JPanel pnEmptyBtn1 = new JPanel();
        JPanel pnEmptyBtn2 = new JPanel();
        JPanel pnBtnNext = new JPanel();

        pnBtn.add(pnEmptyBtn1, BorderLayout.WEST);
        pnBtn.add(pnEmptyBtn2, BorderLayout.CENTER);
        pnBtn.add(pnBtnNext, BorderLayout.EAST);
        pnEmptyBtn1.setBackground(Color.white);
        pnEmptyBtn2.setBackground(Color.white);
        pnBtnNext.setBackground(Color.white);

        pnBtn.setBackground(Color.white);
        JButton btnNext = new JButton("Tiếp theo");
        btnNext.setFocusPainted(false);

        btnNext.setBackground(new Color(51, 51, 51));
        btnNext.setForeground(Color.white);
        pnBtnNext.add(btnNext);

        ArrayList<KhachHangDTO> KHList = new ArrayList<>();
        
        //KHList.clear();
        KHList= MenuDatVe.KHlList;
        
        jt = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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
            Object[] data = {i, x.getMaKH(), x.getTenKH(), x.getCccd(), gt , x.getSdt(), x.getMail()};
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
//        jt.getColumnModel().getColumn(2).setCellRenderer(renderBorder);
//        jt.getColumnModel().getColumn(3).setCellRenderer(renderBorder);
//        jt.getColumnModel().getColumn(6).setCellRenderer(renderBorder);
//        jt.getColumnModel().getColumn(7).setCellRenderer(renderBorder);
        
        jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scpn.setViewportView(jt);
        scpn = new JScrollPane(jt);
        scpn.setPreferredSize(new Dimension(1200,550));
        pnInfo.add(scpn,BorderLayout.CENTER);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    rbtnP.setEnabled(true);
                    rbtnP.setSelected(true);
                    renderVe();
                
            }
        });
    }


    public void renderVe() {
        pnContent.removeAll();
        pnContent.revalidate();
        pnContent.repaint();

        pnContent.setLayout(new BorderLayout());
        JPanel pnEmpty1 = new JPanel();
        JPanel pnCenter = new JPanel();
        JPanel pnEmpty2 = new JPanel();
//        pnContent.add(pnEmpty1, BorderLayout.WEST);
        pnContent.add(pnCenter, BorderLayout.CENTER);
        pnContent.add(pnEmpty2, BorderLayout.EAST);
        pnEmpty1.setBackground(Color.decode("#DDDDDD"));
        pnEmpty2.setBackground(Color.decode("#DDDDDD"));
        pnCenter.setBackground(Color.white);
        pnEmpty2.setBackground(Color.white);

        JLabel lbTitle = new JLabel("Thông ghế đã chọn");

        JPanel pnContentCenter = new JPanel();
        pnContentCenter.setBackground(Color.white);
        JPanel pnBtn = new JPanel();

        JPanel pnTop = new JPanel();
        pnTop.setLayout(new BorderLayout());
        pnTop.add(lbTitle, BorderLayout.CENTER);
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        pnTop.setBackground(Color.white);
        lbTitle.setFont(sgUI15);

        pnCenter.setLayout(new BorderLayout());
        pnCenter.add(pnTop, BorderLayout.NORTH);
        pnCenter.add(pnContentCenter, BorderLayout.CENTER);

        pnBtn.setBackground(Color.white);
        pnBtn.setLayout(new BorderLayout());
        pnBtn.setBorder(new EmptyBorder(20, 20, 20, 20));
        pnCenter.add(pnBtn, BorderLayout.SOUTH);

        JPanel pnEmptyBtn1 = new JPanel();
        pnEmptyBtn1.setLayout(new BorderLayout());

        JPanel pnEmptyBtn2 = new JPanel();

        JPanel pnEmptyBtn3 = new JPanel();
        pnEmptyBtn3.setLayout(new BorderLayout());

        pnBtn.add(pnEmptyBtn1, BorderLayout.WEST);
        pnEmptyBtn1.setBackground(Color.black);
        pnEmptyBtn3.setBackground(Color.yellow);
        pnBtn.add(pnEmptyBtn2, BorderLayout.CENTER);
        pnEmptyBtn2.setBackground(Color.white);
        pnBtn.add(pnEmptyBtn3, BorderLayout.EAST);

        JButton btnReturn = new JButton("Quay lại");
        JButton btnNext = new JButton("Tiếp theo");
        pnEmptyBtn1.add(btnReturn, BorderLayout.CENTER);
        pnEmptyBtn3.add(btnNext, BorderLayout.CENTER);

        btnReturn.setFocusPainted(false);
        btnReturn.setBackground(new Color(51, 51, 51));
        btnReturn.setForeground(Color.white);

        btnNext.setFocusPainted(false);
        btnNext.setBackground(new Color(51, 51, 51));
        btnNext.setForeground(Color.white);

        pnContentCenter.setLayout(new BorderLayout());
        pnContentCenter.setBorder(new EmptyBorder(5, 20, 5, 20));
        JLabel lbTopTitle = new JLabel("DANH SÁCH GHẾ ĐÃ CHỌN");
        lbTopTitle.setFont(sgUI13b);

        JPanel pnTopTitle = new JPanel();
        pnTopTitle.setBackground(Color.white);
        pnTopTitle.setLayout(new BorderLayout());
        pnTopTitle.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 0, 1, Color.black), new EmptyBorder(10, 10, 10, 0)));
        pnTopTitle.add(lbTopTitle, BorderLayout.CENTER);

        JScrollPane scp = new JScrollPane();
        scp.getViewport().setBackground(Color.white);
        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        pnTable.add(scp, BorderLayout.CENTER);
        scp.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));

        JTable tbVe = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scp.getViewport().add(tbVe);
        renderTable(tbVe);
        pnContentCenter.add(pnTopTitle, BorderLayout.NORTH);
        pnContentCenter.add(pnTable, BorderLayout.CENTER);

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbtnDV.setEnabled(true);
                rbtnDV.setSelected(true);
                renderDV();
            }
        });

        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbtnP.setEnabled(false);
                rbtnP.setSelected(false);
                rbtnDV.setEnabled(false);
                rbtnDV.setSelected(false);
                if (rbtnP.isEnabled()) {
                    rbtnP.setSelected(true);
                } else {
                    rbtnP.setSelected(false);
                }
                rbtnDV.setEnabled(false);
                rbtnDV.setSelected(false);
                renderKH();
            }
        });

//        tbPhong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                String tenP = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Tên phòng")).toString();
//                String ngayThue = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Ngày thuê")).toString();
//                String ngayTra = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Ngày trả")).toString();
//                String loaiP = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Loại phòng")).toString();
//                String loaiHinhThue = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Loại hình thuê")).toString();
//                String giaP = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Giá phòng")).toString();
//                String ngayCheckOut = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Ngày checkout")).toString();
//                renderInfo(pnEmpty2, tenP, ngayThue, ngayTra, loaiP, loaiHinhThue, giaP, ngayCheckOut);
//            }
//        });

    }

    

    public void renderDV() {
        pnContent.removeAll();
        pnContent.revalidate();
        pnContent.repaint();
        pnContent.setLayout(new BorderLayout());
        JPanel pnEmpty1 = new JPanel();
        JPanel pnCenter = new JPanel();
        JPanel pnEmpty2 = new JPanel();
//        pnContent.add(pnEmpty1, BorderLayout.WEST);
        pnContent.add(pnCenter, BorderLayout.CENTER);
//        pnContent.add(pnEmpty2, BorderLayout.EAST);
        pnEmpty1.setBackground(Color.decode("#DDDDDD"));
        pnEmpty2.setBackground(Color.decode("#DDDDDD"));
        pnCenter.setBackground(Color.white);
        JLabel lbEmpty1 = new JLabel("                                          ");
        JLabel lbEmpty2 = new JLabel("                                          ");
        pnEmpty1.add(lbEmpty1);
        pnEmpty2.add(lbEmpty2);
        JLabel lbTitle = new JLabel("Thông tin dịch vụ");

        JPanel pnContentCenter = new JPanel();
        pnContentCenter.setBackground(Color.white);
        JPanel pnBtn = new JPanel();

        JPanel pnTop = new JPanel();
        pnTop.setLayout(new BorderLayout());
        pnTop.add(lbTitle, BorderLayout.CENTER);
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        pnTop.setBackground(Color.white);
        lbTitle.setFont(sgUI15);

        pnCenter.setLayout(new BorderLayout());
        pnCenter.add(pnTop, BorderLayout.NORTH);
        pnCenter.add(pnContentCenter, BorderLayout.CENTER);

        pnBtn.setBackground(Color.white);
        pnBtn.setLayout(new BorderLayout());
        pnBtn.setBorder(new EmptyBorder(20, 20, 20, 20));
        pnCenter.add(pnBtn, BorderLayout.SOUTH);

        JPanel pnEmptyBtn1 = new JPanel();
        pnEmptyBtn1.setLayout(new BorderLayout());

        JPanel pnEmptyBtn2 = new JPanel();

        JPanel pnEmptyBtn3 = new JPanel();
        pnEmptyBtn3.setLayout(new BorderLayout());

        pnBtn.add(pnEmptyBtn1, BorderLayout.WEST);
        pnEmptyBtn1.setBackground(Color.black);
        pnEmptyBtn3.setBackground(Color.yellow);
        pnBtn.add(pnEmptyBtn2, BorderLayout.CENTER);
        pnEmptyBtn2.setBackground(Color.white);
        pnBtn.add(pnEmptyBtn3, BorderLayout.EAST);

        JButton btnReturn = new JButton("Quay lại");
        JButton btnNext = new JButton("Tiếp theo");
        pnEmptyBtn1.add(btnReturn, BorderLayout.CENTER);
        pnEmptyBtn3.add(btnNext, BorderLayout.CENTER);

        btnReturn.setFocusPainted(false);
        btnReturn.setBackground(new Color(51, 51, 51));
        btnReturn.setForeground(Color.white);

        btnNext.setFocusPainted(false);
        btnNext.setBackground(new Color(51, 51, 51));
        btnNext.setForeground(Color.white);

        pnContentCenter.setLayout(new BorderLayout());
        pnContentCenter.setBorder(new EmptyBorder(5, 20, 5, 20));
        JLabel lbTopTitle = new JLabel("DANH SÁCH DỊCH VỤ");
        lbTopTitle.setFont(sgUI13b);

        JPanel pnTopTitle = new JPanel();
        pnTopTitle.setBackground(Color.white);
        pnTopTitle.setLayout(new BorderLayout());
        pnTopTitle.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.black), new EmptyBorder(10, 10, 10, 0)));
        pnTopTitle.add(lbTopTitle, BorderLayout.CENTER);

        JScrollPane scp1 = new JScrollPane();
        scp1.getViewport().setBackground(Color.white);
        scp1.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        
        JScrollPane scp2 = new JScrollPane();
        scp2.getViewport().setBackground(Color.white);

        
        int count = 0;
        for (ChiTietSuDungDV x : listCT) {
            if(!x.getMaDVve().equals("no")){
                System.out.println(""+x.getMaDVve());
                count++;
            }
        }
        if(count!=0){
            scp1.setBorder(new MatteBorder(10, 0, 0, 75, Color.white));
            scp1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#00CCCC"),3), "Chiều đi", TitledBorder.CENTER, TitledBorder.TOP));
            scp2.setBorder(new MatteBorder(10, 75, 0, 0, Color.white));
            scp2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#00CCCC"),3), "Chiều về", TitledBorder.CENTER, TitledBorder.TOP));
            JPanel pnTable = new JPanel();
            pnTable.setLayout(new GridLayout(1,2));
            pnTable.setBackground(Color.white);
            pnTable.add(scp1);
            pnTable.add(scp2);

            JTable tbDV1 = new JTable() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            scp1.getViewport().add(tbDV1);
            renderTableDV(tbDV1,"1c");

            JTable tbDV2 = new JTable() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            scp2.getViewport().add(tbDV2);
            renderTableDV(tbDV2,"2c");
            pnContentCenter.add(pnTopTitle, BorderLayout.NORTH);
            pnContentCenter.add(pnTable, BorderLayout.CENTER);
        }else{
            JPanel pnTable = new JPanel();
            pnTable.setLayout(new BorderLayout());
            pnTable.add(scp1, BorderLayout.CENTER);
            scp1.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
            JTable tbDV1 = new JTable() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            scp1.getViewport().add(tbDV1);
            renderTableDV(tbDV1,"1c");
            pnContentCenter.add(pnTopTitle, BorderLayout.NORTH);
            pnContentCenter.add(pnTable, BorderLayout.CENTER);
        }
        
        
        
        
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("ỌKKK");
//                for (ChiTietSuDungDV csdto : listCT) {
//                    System.out.println("Mã khách hàng"+csdto.getMaKH());
//                    System.out.println("Tiền vé"+csdto.getTienVe());
//                    System.out.println("Tiền dịch vụ"+csdto.getTienDV());
//                    System.out.println("\n");
//                }
                setVisible(false);
                new ThanhToan(listCT,closeWin);
            }
        });
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbtnDV.setEnabled(false);
                rbtnDV.setSelected(false);
                renderVe();
            }
        });
    }

    public void renderTableDV(JTable tbDV, String key) {
        tbDV.setBorder(null);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Tên khách hàng");
        dtm.addColumn("Mã dịch vụ");
        dtm.addColumn("Tên dịch vụ");
        dtm.addColumn("Loại dịch vụ");
        dtm.addColumn("Giá dịch vụ");
        tbDV.setModel(dtm);
        tbDV.setRowHeight(40);
        int i = 0;
        if(key.equals("1c")){
            for (ChiTietSuDungDV x : listCT) {
                for(DichVuDTO y : listDVDTO){
                    if(x.getMaDVdi().equals(y.getMaDV())){
                        Object row[] = {
                            i + 1,x.getTenKH(), x.getMaDVdi(), y.getTenDV(), y.getTenLoaiDV(), y.getGiaDV()};
                        dtm.addRow(row);
                        i++;
                        x.setTienDVdi(y.getGiaDV());
                    }
                }
            }
        }
        if(key.equals("2c")){
            for (ChiTietSuDungDV x : listCT) {
                for(DichVuDTO y : listDVDTO){
                    if(x.getMaDVve().equals(y.getMaDV())){
                        Object row[] = {
                            i + 1,x.getTenKH(), x.getMaDVve(), y.getTenDV(), y.getTenLoaiDV(), y.getGiaDV()};
                        dtm.addRow(row);
                        i++;
                        x.setTienDVve(y.getGiaDV());
                    }
                }
            }
        }
        
//        listCT.clear();
        tbDV.setShowGrid(false);
        tbDV.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbDV.getTableHeader().setFont(sgUI13b);
        tbDV.setIntercellSpacing(new Dimension(0, 0));
        DefaultTableCellRenderer RendererBorder = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                String txt = (String) table.getValueAt(row, column);
                JLabel lb = (JLabel) c;
                lb.setHorizontalAlignment(JLabel.CENTER);
                lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                if (isSelected) {
                    lb.setBackground(Color.decode("#D3D3D3"));
                } else {
                    lb.setBackground(Color.decode("#FFFFFF"));
                }
                return lb;
            }
        };
        tbDV.getTableHeader().setPreferredSize(new Dimension(1, 40));
        for (int j = 0; j < tbDV.getColumnCount(); j++) {
            tbDV.getColumnModel().getColumn(j).setCellRenderer(RendererBorder);
        }
    }
   
    public void renderTable(JTable tbVe) {
        tbVe.setBorder(null);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã hành khách");
        dtm.addColumn("Tên hành khách");
        dtm.addColumn("Mã chuyến bay");
        dtm.addColumn("Ngày đi");
        dtm.addColumn("Giờ bay");
        dtm.addColumn("Mã ghế");
        dtm.addColumn("Giá");
        tbVe.setModel(dtm);
        tbVe.setRowHeight(40);
        int k = 1;
        ArrayList<ChuyenBayDTO> listChuyenBay = ChuyenBayBUS.load();
        ArrayList<VeBayDTO> listVe = VeBayBUS.load();
        System.out.println(""+MenuDatVe.Gia1C);
        System.out.println(""+MenuDatVe.Gia2C);
        for(ChuyenBayDTO cb: listChuyenBay){
            if(MenuDatVe.ma1c.equals(cb.getMaChuyenBay())){
                    for (int i = 0; i < MenuDatVe.MaGheList.size(); i++) {
                        String x = MenuDatVe.MaGheList.get(i);
                        for (int j = 0; j < KHlist.size(); j++) {
                            KhachHangDTO khdto = KHlist.get(j);
                            if (i == j) { // So sánh vị trí của x và khdto
                                if(MenuDatVe.hangghe1C.equals("Economy")){
                                    dtm.addRow(new Object[]{
                                        k++, khdto.getMaKH(), khdto.getTenKH(), MenuDatVe.ma1c, cb.getNgayDi(), cb.getGioBay(), x, MenuDatVe.Gia1C
                                    });
                                }
                                else{
                                    dtm.addRow(new Object[]{
                                        k++, khdto.getMaKH(), khdto.getTenKH(), MenuDatVe.ma1c, cb.getNgayDi(), cb.getGioBay(), x, MenuDatVe.Gia1C
                                    });
                                }    
                                for(ChiTietSuDungDV ctsddv : listCT){
                                    if(ctsddv.getMaKH().equals(khdto.getMaKH())){
                                        ctsddv.setTienVedi(Long.parseLong(MenuDatVe.Gia1C));
                                        ctsddv.setMaChuyenBaydi(MenuDatVe.ma1c);
                                    }
                                }
                                
                                
                            }
                        }
                }                  
              
            }
        }
        for(ChuyenBayDTO cb: listChuyenBay){
            if(MenuDatVe.ma2c.equals(cb.getMaChuyenBay())){
                    for (int i = 0; i < MenuDatVe.MaGheListVe.size(); i++) {
                        String x = MenuDatVe.MaGheListVe.get(i);
                        for (int j = 0; j < KHlist.size(); j++) {
                            KhachHangDTO khdto = KHlist.get(j);
                            if (i == j) { // So sánh vị trí của x và khdto
                                if(MenuDatVe.hangghe2C.equals("Economy")){
                                    dtm.addRow(new Object[]{
                                        k++, khdto.getMaKH(), khdto.getTenKH(), MenuDatVe.ma2c, cb.getNgayDi(), cb.getGioBay(), x, MenuDatVe.Gia2C
                                    });
                                }
                                else{
                                    dtm.addRow(new Object[]{
                                        k++, khdto.getMaKH(), khdto.getTenKH(), MenuDatVe.ma2c, cb.getNgayDi(), cb.getGioBay(), x, MenuDatVe.Gia2C
                                    });
                                }    
                                for(ChiTietSuDungDV ctsddv : listCT){
                                    if(ctsddv.getMaKH().equals(khdto.getMaKH())){
                                        ctsddv.setTienVeve(Long.parseLong(MenuDatVe.Gia2C));
                                        ctsddv.setMaChuyenBayve(MenuDatVe.ma2c);
                                    }
                                }
                                
                                
                            }
                        }
                }                  
              
            }
        }
        tbVe.setShowGrid(false);
        tbVe.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbVe.getTableHeader().setFont(sgUI13b);
        DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String txt = (String) table.getValueAt(row, column);
                JLabel lb = (JLabel) c;
                lb.setHorizontalAlignment(JLabel.CENTER);
//                if (txt.equals("Theo ngày")) {
//                    lb.setForeground(Color.decode("#3366CC"));
//                    lb.setFont(sgUI13);
//                    lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
//                } else if (txt.equals("Theo giờ")) {
//                    lb.setForeground(Color.decode("#00CC00"));
//                    lb.setFont(sgUI13);
//                    lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
//                }
                if (isSelected) {
                    lb.setBackground(Color.decode("#D3D3D3"));
                } else {
                    lb.setBackground(Color.decode("#FFFFFF"));
                }
                return lb;
            }
        };
        tbVe.setIntercellSpacing(new Dimension(0, 0));
        DefaultTableCellRenderer RendererBorder = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                String txt = (String) table.getValueAt(row, column);
                JLabel lb = (JLabel) c;
                lb.setHorizontalAlignment(JLabel.CENTER);
                lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
//                if (lb.getText().equals("Theo Ngày")) {
//                    lb.setForeground(Color.decode("#3366CC"));
//                } else if (lb.getText().equals("Theo Giờ")) {
//                    lb.setForeground(Color.decode("#00CC00"));
//                } else {
//                    lb.setForeground(Color.black);
//                }
                if (isSelected) {
                    lb.setBackground(Color.decode("#D3D3D3"));
                } else {
                    lb.setBackground(Color.decode("#FFFFFF"));
                }
                return lb;
            }
        };

        Renderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tbVe.getColumnCount(); i++) {
            tbVe.getColumnModel().getColumn(i).setCellRenderer(RendererBorder);
        }

        tbVe.getTableHeader().setPreferredSize(new Dimension(1, 40));
    }
    public static void closeMenu(int x){
        if(x==1){
            PanelVeBay.mn.setVisible(false);
        }
        else 
            ReceptionistGUI.mn.setVisible(false);
        
    }
}
