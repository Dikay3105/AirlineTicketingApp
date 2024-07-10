package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class NhanVienBUS {
    public static String pathExcel;
    private ArrayList<NhanVienDTO> NVlist;
    DefaultTableModel model;
    ArrayList<NhanVienDTO> listNhanVien;
    ArrayList<NhanVienDTO> listTemp;

    public NhanVienBUS() {

    }

    public void showTable(JTable table) {
        int i = 1;
        NVlist = new NhanVienDAO().LoadData();
        model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "Mã Nhân Viên", "Mật Khẩu", "Họ Tên", "Giới Tính", "Ngày Sinh", "Phòng Ban", "Email", "Hệ Số"
        });
        for (NhanVienDTO s : NVlist) {
            if (s.getXuLy() != 0) {
                model.addRow(new Object[]{
                    i++, s.getMaNV(), s.getmKNV(), s.getTenNV(), s.getGioiTinh(), s.getNgaySinhString(), s.getChucVu(), s.getEmail()/*, s.getHeSoLuong()*/
                });

            }
        }
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    public ArrayList<NhanVienDTO> getListNhanVien() {
        ArrayList<NhanVienDTO> listNhanVien = new ArrayList<>();
        for (NhanVienDTO x : NhanVienDAO.LoadData()) {
            if (x.getXuLy() == 1) {
                listNhanVien.add(x);
            }
        }
        return listNhanVien;
    }

    public boolean insertNhanVien(NhanVienDTO nv) throws SQLException, ParseException {
        if (new NhanVienDAO().InsertNhanVien(nv)) {
            return true;
        }
        return false;
    }

    public boolean editNhanVien(NhanVienDTO nv) throws SQLException, ParseException {
        if (new NhanVienDAO().UpdateNhanVien(nv)) {
            return true;
        }
        return false;
    }
    
    public static boolean isValidPassword(String input) {
        // Kiểm tra xem chuỗi có null không
        if (input == null) {
            return false;
        }

        // Kiểm tra chiều dài của chuỗi
        int length = input.length();
        if (length < 1 || length > 20) {
            return false;
        }

        // Kiểm tra xem chuỗi có chứa khoảng trắng không
        if (input.contains(" ")) {
            return false;
        }

        return true;
    }

    public boolean deleteNhanVieṇ̣̣̣̣̣̣(NhanVienDTO s) throws SQLException, ParseException {
        if (new NhanVienDAO().DelNhanVien(s)) {
            return true;
        }
        return false;
    }

    public void findNhanVien(JTable table, String mnv, String namenv, String gtinh, String pban, String hso) {
        model = (DefaultTableModel) table.getModel();
        Set<String> IdDelete = new TreeSet<String>();
        int numberRow;
        numberRow = table.getRowCount();
        String key, id;
        if (!mnv.isEmpty() && !mnv.equals("Mã Nhân Viên...")) {
            if (IDisEmty(mnv) == true) {
                for (int i = 0; i < numberRow; i++) {
                    key = model.getValueAt(i, 1) + "";
                    if (!key.equals(mnv)) {
                        IdDelete.add(String.valueOf(model.getValueAt(i, 1) + ""));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "MÃ NHÂN VIÊN KHÔNG TỒN TẠI TRONG HỆ THỐNG", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (!namenv.isEmpty() && !namenv.equals("Họ Tên...")) {
            if (NAMEisEmty(namenv) == true) {
                for (int i = 0; i < numberRow; i++) {
                    key = model.getValueAt(i, 3) + "";
                    if (!namenv.equals(key)) {
                        IdDelete.add(String.valueOf(model.getValueAt(i, 1) + ""));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "TÊN NHÂN VIÊN KHÔNG TỒN TẠI", "Thông Báo", JOptionPane.OK_OPTION);
            }
        }
        if (!pban.isEmpty() && !pban.equals("Phòng Ban")) {
            for (int i = 0; i < numberRow; i++) {
                key = model.getValueAt(i, 6) + "";
                if (!pban.equals(key)) {
                    IdDelete.add(String.valueOf(model.getValueAt(i, 1) + ""));
                }
            }
        }
        if (!gtinh.isEmpty() && !gtinh.equals("Giới Tính")) {
            for (int i = 0; i < numberRow; i++) {
                key = model.getValueAt(i, 4) + "";
                if (!gtinh.equals(key)) {
                    IdDelete.add(String.valueOf(model.getValueAt(i, 1) + ""));
                }
            }
        }
        /*if (!hso.isEmpty() && !hso.equals("Hệ Số Lương...")) {
            if (HESOisEmty(hso) == true) {
                for (int i = 0; i < numberRow; i++) {
                    key = model.getValueAt(i, 7) + "";
                    if (!hso.equals(key)) {
                        IdDelete.add(String.valueOf(model.getValueAt(i, 1) + ""));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "HỆ SỐ KHÔNG TỒN TẠI", "Thông Báo", JOptionPane.OK_OPTION);
            }
        }*/
        for (String x : IdDelete) {
            numberRow = table.getRowCount();
            for (int j = 0; j < numberRow; j++) {
                id = model.getValueAt(j, 1) + "";
                if (id.equals(x)) {
                    try {
                        model.removeRow(j);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    public void resetTable(JTable table) {
        model = (DefaultTableModel) table.getModel();
        int numberRow;
        while (true) {
            numberRow = table.getRowCount();
            if (numberRow == 0) {
                break;
            } else
                try {
                model.removeRow(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        showTable(table);

    }

    public boolean isNumber(int num) {
        return num > 0 && Integer.toString(num) != null && Integer.toString(num).matches("[-+]?\\d*\\.?\\d+");
    }

    public boolean isWord(String sData) {
        for (int i = 0; i < sData.length(); i++) {
            if (Character.isLetter(sData.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialCharacters(String name) {
        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
        String str2[] = name.split("");
        int count = 0;
        for (int i = 0; i < str2.length; i++) {
            if (specialCharacters.contains(str2[i])) {
                count++;
            }
        }
        if (name != null && count == 0) {
            return false;
        } else {
            return true;
        }
    }

//    public boolean checkInput(String mnv, String namenv, String mknv/*, String hso*/) {
//        if ("".equals(mnv) || "".equals(namenv) || "".equals(mknv)/* || "".equals(hso)*/) {
//            JOptionPane.showMessageDialog(null, "HÃY NHẬP ĐẦY ĐỦ VÀ CHÍNH XÁC THÔNG TIN", "Thông Báo", JOptionPane.OK_OPTION);
//            return false;
//        } /*else if (isSpecialCharacters(hso) == true || isWord(hso) == true || isNumber(Integer.parseInt(hso)) == false) {
//            JOptionPane.showMessageDialog(null, "LƯU Ý: HỆ SỐ LÀ SỐ TỰ NHIÊN", "Thông Báo", JOptionPane.OK_OPTION);
//            return false;
//        } */else if (isSpecialCharacters(namenv) == true /* || isNumber(Integer.parseInt(namenv))==true*/) {
//            JOptionPane.showMessageDialog(null, "LƯU Ý: HỌ TÊN KHÔNG ĐƯỢC CÓ KÍ TỰ ĐẶC BIỆT", "Thông Báo", JOptionPane.OK_OPTION);
//            return false;
//        } else if(!isValidPassword(mknv)) {
//            JOptionPane.showMessageDialog(null, "LƯU Ý: MẬT KHẨU TỪ 1-20 KÍ TỰ VÀ KHÔNG CHỨA KHOẢNG TRẮNG", "Thông Báo", JOptionPane.OK_OPTION);
//            return false;
//        }
//
//        return true;
//    }
     public boolean checkInput(String mnv, String namenv, String mknv/*, String hso*/, String nsinh, String gtinh) {
        if ("".equals(mnv) || "".equals(namenv) || "".equals(mknv)) {
            JOptionPane.showMessageDialog(null, "HÃY NHẬP ĐẦY ĐỦ VÀ CHÍNH XÁC THÔNG TIN", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }/* else if (isSpecialCharacters(hso) == true || isWord(hso) == true || isNumber(Integer.parseInt(hso)) == false) {
            JOptionPane.showMessageDialog(null, "LƯU Ý: HỆ SỐ LÀ SỐ TỰ NHIÊN", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }*/ 
        else if (namenv.length()>50) {
            JOptionPane.showMessageDialog(null, "LƯU Ý: HỌ TÊN QUÁ 50 KÍ TỰ", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        else if  (isSpecialCharacters(namenv) == true /* || isNumber(Integer.parseInt(namenv))==true*/) {
            JOptionPane.showMessageDialog(null, "LƯU Ý: HỌ TÊN KHÔNG ĐƯỢC CÓ KÍ TỰ ĐẶC BIỆT", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        else if(!NhanVienBUS.isValidPassword(mknv)) {
            JOptionPane.showMessageDialog(null, "LƯU Ý: MẬT KHẨU TỪ 1-20 KÍ TỰ VÀ KHÔNG CHỨA KHOẢNG TRẮNG", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        else if(gtinh.equals("Giới Tính")){
            JOptionPane.showMessageDialog(null, "HÃY NHẬP ĐẦY ĐỦ VÀ CHÍNH XÁC THÔNG TIN", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        String firstFourChars = nsinh.substring(0, 4);
        if(!isDateValid(nsinh) && (currentYear-Integer.parseInt(firstFourChars))<18){
            JOptionPane.showMessageDialog(null, "HÃY NHẬP ĐÚNG ĐỊNH DẠNG dd-MM-yyyy VÀ TUỔI PHẢI LỚN HƠN 18", "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        
        return true;
    }

    public boolean IDisEmty(String id) {
        try {
            for (NhanVienDTO nv : NVlist) {
                if (nv.getMaNV().equals(id)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean NAMEisEmty(String name) {
        for (NhanVienDTO nv : NVlist) {
            if (nv.getTenNV().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /*public boolean HESOisEmty(String heso) {
        for (NhanVienDTO nv : NVlist) {
            if (nv.getHeSoLuong() == Integer.parseInt(heso)) {
                return true;
            }
        }
        return false;
    }*/

    //Vĩnh Khoa
    public ArrayList<NhanVienDTO> LoadNV() {
        NVlist = new NhanVienDAO().LoadData();
        ArrayList<NhanVienDTO> a = new ArrayList<>();
        for (NhanVienDTO nv : NVlist) {
            if (nv.getXuLy() == 1) {
                a.add(nv);
            }
        }
        return a;
    }

    ////////////////////
    public static String getTenNV(String maNV) {
        return NhanVienDAO.getTenNV(maNV);
    }

    public static void updateNV(NhanVienDTO nv) throws SQLException, ParseException {
        new NhanVienDAO().UpdateNhanVien(nv);
    }

    public static NhanVienDTO getNV(String maNV) {
        return NhanVienDAO.getNV(maNV);
    }
    ////////////////////////////////////////////////////////////////    
    
    public static int getSize() {
        return NhanVienDAO.LoadData().size()+1;
    }
    
    public static String xuatExcel(String path) {
        BackUpData bk = new BackUpData();
        String message = "";
        try {
            bk.backup_NhanVien(path);
            message += "Xuất file thành công";
            pathExcel = path;
        } catch (Exception ex) {
            message += "Xuất file không thành công";
        }
        return message;
    }
    
    public static boolean containsWhitespace(String str) {
        // Sử dụng phương thức contains của lớp String
        return str.contains(" ");
    }
    public static boolean isDateValid(String dateStr) {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false); // Tắt tính linh hoạt để kiểm tra chính xác ngày tháng

        try {
            Date date = sdf.parse(dateStr);
            // Nếu ngày tháng được phân tích thành công, thì chuỗi đúng định dạng
            return true;
        } catch (ParseException e) {
            // Nếu có lỗi ParseException, chuỗi không đúng định dạng
            return false;
        }
    }      


    public static boolean isValidEmail(String email) {
        // regex pattern for email validation
        String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
////////////////////////////////////////////////////////////////   
}
