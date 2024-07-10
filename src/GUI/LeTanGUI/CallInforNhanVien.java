package GUI.LeTanGUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import GUI.InforNhanVien;
import GUI.LoginGUI;
import GUI.PanelNhanVien;
import GUI.mainGUI;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
public class CallInforNhanVien extends JFrame{
    String gt[] = {"Nam", "Nữ"};
    String phongban[] = {"Bán Vé","Quản Lý"};
    private JLabel lbMaNhanVien, lbHoTen, lbMatKhau, lbGTinh, lbPBan/*, lbHeso*/, lbNgaySinh;
    private JTextField jtfMaNhanVien, jtfHoTen, jtfMatKhau/*, jtfHeso*/;
    private JComboBox cbGioiTinh, cbPhongBan;
    private JDateChooser jdNgaySinh;
    private JButton jbEDIT, jbCANCEL;
    private JLabel lbTitle = new JLabel("Thông Tin Nhân Viên");
    private JPanel pnContent = new JPanel();
    private Font sgUI25b = new Font("Segoe UI", Font.BOLD, 25);
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15 = new Font("Segoe UI", Font.PLAIN, 15);
    static NhanVienBUS nv = new NhanVienBUS();
    public String emailString;
    private ArrayList<NhanVienDTO> NVlist = new NhanVienBUS().LoadNV();;
    public CallInforNhanVien(String key) throws ParseException{
        initComponents(key);
    }
    public void initComponents(String key) throws ParseException{
        NhanVienBUS nv = new NhanVienBUS();
        NVlist = new NhanVienBUS().getListNhanVien();
        setVisible(true);
        setSize(450, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        add(lbTitle, BorderLayout.NORTH);
        lbTitle.setPreferredSize(new Dimension(getWidth(), 50));
        lbTitle.setOpaque(true);
        lbTitle.setBackground(Color.white);
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        lbTitle.setFont(sgUI25b);

        add(pnContent);
        pnContent.setBackground(Color.decode("#F0FFFF"));
        pnContent.setLayout(null);
        add(pnContent, BorderLayout.CENTER);
        
        for(NhanVienDTO nvDTO: NVlist){
            if(nvDTO.getMaNV().trim().equals(key.trim())){
                emailString=nvDTO.getEmail();
                lbMaNhanVien = new JLabel("Mã Nhân Viên: ");
                lbMaNhanVien.setFont(sgUI15b);
                lbMaNhanVien.setBounds(50, 50, 150, 50);
                jtfMaNhanVien = new JTextField();
                jtfMaNhanVien.setBounds(160, 55, 230, 40);
                jtfMaNhanVien.setFont(sgUI15b);
                jtfMaNhanVien.setText(nvDTO.getMaNV()+"");
                jtfMaNhanVien.setEditable(false);

                lbMatKhau = new JLabel("Mật Khẩu: ");
                lbMatKhau.setFont(sgUI15b);
                lbMatKhau.setBounds(50, 120, 100, 50);
                jtfMatKhau = new JTextField();
                jtfMatKhau.setBounds(160, 125, 230, 40);
                jtfMatKhau.setFont(sgUI15);
                jtfMatKhau.setText(nvDTO.getmKNV());

                lbHoTen = new JLabel("Họ & Tên: ");
                lbHoTen.setFont(sgUI15b);
                lbHoTen.setBounds(50, 190, 100, 50);
                jtfHoTen = new JTextField();
                jtfHoTen.setBounds(160, 195, 230, 40);
                jtfHoTen.setFont(sgUI15);
                jtfHoTen.setText(nvDTO.getTenNV());

                lbGTinh = new JLabel("Giới Tính: ");
                lbGTinh.setFont(sgUI15b);
                lbGTinh.setBounds(50, 260, 100, 50);
                cbGioiTinh = new JComboBox(gt);
                cbGioiTinh.setBackground(Color.decode("#FAFAFA"));
                cbGioiTinh.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                cbGioiTinh.setBounds(160, 265, 230, 40);
                cbGioiTinh.setFont(sgUI15);
                if (nvDTO.getGioiTinh()==1) {
                    cbGioiTinh.setSelectedItem(gt[0]);
                } else {
                    cbGioiTinh.setSelectedItem(gt[1]);
                }

                lbPBan = new JLabel("Phòng Ban : ");
                lbPBan.setFont(sgUI15b);
                lbPBan.setBounds(50, 330, 100, 50);
                cbPhongBan = new JComboBox(phongban);
                cbPhongBan.setBackground(Color.decode("#FAFAFA"));
                cbPhongBan.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                cbPhongBan.setBounds(160, 335, 230, 40);
                cbPhongBan.setFont(sgUI15);
                if (nvDTO.getChucVu().equals(phongban[0])) {
                    cbPhongBan.setSelectedItem(phongban[0]);
                } else if (nvDTO.getChucVu().equals(phongban[1])) {
                    cbPhongBan.setSelectedItem(phongban[1]);
                } 
                cbPhongBan.setEnabled(false);

                lbNgaySinh = new JLabel("Ngày sinh:");
                lbNgaySinh.setFont(sgUI15b);
                lbNgaySinh.setBounds(50, 395, 100, 50);
                jdNgaySinh = new JDateChooser();
                LocalDate dateDefault = java.time.LocalDate.now();
                Date date = java.sql.Date.valueOf(dateDefault);
                jdNgaySinh.setDate(date);
                jdNgaySinh.setDateFormatString("yyyy-MM-dd");
                jdNgaySinh.setBackground(Color.decode("#FAFAFA"));
                jdNgaySinh.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                jdNgaySinh.setBounds(160, 400, 230, 40);
                jdNgaySinh.setFont(sgUI15);
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = formatter1.parse(nvDTO.getNgaySinhString()+"");
                jdNgaySinh.setDate(date1);

//                lbHeso = new JLabel("Hệ Số: ");
//                lbHeso.setFont(sgUI15b);
//                lbHeso.setBounds(50, 465, 100, 50);
//                jtfHeso = new JTextField();
//                jtfHeso.setBounds(160, 470, 230, 40);
//                jtfHeso.setFont(sgUI15);
//                /*jtfHeso.setText(nvDTO.getHeSoLuong()+"");*/
//                jtfHeso.setEditable(false);
            }
        }    

        jbEDIT = new JButton("Sửa");
        jbEDIT.setBounds(100, 535, 100, 40);
        jbEDIT.setFont(sgUI15b);
        jbEDIT.setBackground(Color.decode("#F1EF65"));
        jbEDIT.setForeground(Color.white);

        jbCANCEL = new JButton("Cancel");
        jbCANCEL.setBounds(230, 535, 100, 40);
        jbCANCEL.setFont(sgUI15b);
        jbCANCEL.setBackground(Color.decode("#D3D3D3"));
        jbCANCEL.setForeground(Color.white);

        pnContent.add(lbMaNhanVien);
        pnContent.add(jtfMaNhanVien);
        pnContent.add(lbMatKhau);
        pnContent.add(jtfMatKhau);
        pnContent.add(lbHoTen);
        pnContent.add(jtfHoTen);
        pnContent.add(lbGTinh);
        pnContent.add(cbGioiTinh);
        pnContent.add(lbNgaySinh);
        pnContent.add(jdNgaySinh);
        pnContent.add(lbPBan);
        pnContent.add(cbPhongBan);
//        pnContent.add(lbHeso);
//        pnContent.add(jtfHeso);
        pnContent.add(jbEDIT);
        pnContent.add(jbCANCEL);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Quay lại JFrame trước đó
                mainGUI.nameNV=jtfHoTen.getText().trim();
                new ReceptionistGUI().setVisible(true);
                dispose(); // Đóng JFrame hiện tại
            }
        });

        setVisible(true);
        
        jbEDIT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jbEDIT.setBackground(Color.decode("#EFEC3F"));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                jbEDIT.setBackground(Color.decode("#F1EF65"));
            }
        });
        jbEDIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    java.util.Date date = jdNgaySinh.getDate();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String dateofbirth = formatter.format(date);
                    editNhanVien(jtfMaNhanVien.getText(), jtfMatKhau.getText(), jtfHoTen.getText(), cbGioiTinh.getSelectedItem() + "", dateofbirth, cbPhongBan.getSelectedItem() + "",emailString/*, jtfHeso.getText()*/);
                } catch (SQLException | ParseException ex){
                    Logger.getLogger(InforNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jbCANCEL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jbCANCEL.setBackground(Color.decode("#B9B8B8"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbCANCEL.setBackground(Color.decode("#D3D3D3"));
            }
        });
        jbCANCEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainGUI.nameNV=jtfHoTen.getText().trim();
                new ReceptionistGUI();
                
            }
        });
        
        
        
    }
   public void editNhanVien(String mnv, String mknv, String namenv, String gtinh, String nsinh, String pban, String emailString/*, String hso*/) throws SQLException, ParseException {
        int choice = JOptionPane.showConfirmDialog(null, "Bạn Muốn Sửa Lại Thông Tin Nhân Viên", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (nv.checkInput(mnv, namenv, mknv,nsinh,gtinh/*, hso*/) == true) {
                for (NhanVienDTO s : NVlist) {
                    if (s.getMaNV().equals(mnv)) {
                        s.setmKNV(mknv);
                        s.setTenNV(namenv);
                        if (gtinh.equals("Nam")) {
                            s.setGioiTinh(1);
                        }else s.setGioiTinh(0);
                        
                        s.setChucVu(pban);
                        s.setNgaySinhString(nsinh);
                        s.setEmail(emailString);
                        /*s.setHeSoLuong(Integer.parseInt(hso));*/
                        if (nv.editNhanVien(s) == true) {
                            JOptionPane.showMessageDialog(null, "ĐÃ SỬA THÔNG TIN NHÂN VIÊN CÓ MÃ NHÂN VIÊN: " + mnv, "Thông Báo", JOptionPane.OK_OPTION);
                            setVisible(false);
                            mainGUI.nameNV=jtfHoTen.getText().trim();
                            new ReceptionistGUI(); 
                            break;
                        }
                     
                        else{
                            JOptionPane.showMessageDialog(null, "Error");
                        }
                        break;
                    }    
                }
            }
        }
    }
}
