package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class HoaDonBUS {
    public static String pathExcel;
    public static ArrayList<HoaDonDTO> getListHD() {
        ArrayList<HoaDonDTO> listHD = new ArrayList<>();
        for (HoaDonDTO x : HoaDonDAO.getListHD()) {
            if (x.getXuLy() == 1) {
                listHD.add(x);
            }
        }
        return listHD;
    }
    
    public static ArrayList<HoaDonDTO> getListHD2() {
        return HoaDonDAO.getListHoaDon2();
    }
    
    public static ArrayList<HoaDonDTO> getListHD3() {
        return HoaDonDAO.getListHoaDon3();
    }

    public static void insertHoaDon(HoaDonDTO hd) throws SQLException, ParseException {
        HoaDonDAO.InsertHoaDon(hd);
    }

    public static int getSize() {
        return HoaDonDAO.getListHoaDon().size() + 1;
    }

    public static int tienPhong(int month) {
        return HoaDonDAO.tienPhong(month);
    }

    public static ArrayList<Integer> getListYear() {
        return HoaDonDAO.getListYear();
    }

    public static String getMaNV(String maHD) {
        return HoaDonDAO.getMaNV(maHD);
    }

    
    
    public static HoaDonDTO getHD(String maCTT) {
        return HoaDonDAO.getHD(maCTT);
    }

    public static int tienPhong() {
        return HoaDonDAO.tienPhong();
    }

    public static int tienDichVu() {
        return HoaDonDAO.tienDichVu();
    }

    public static int tongTien() {
        return HoaDonDAO.tongTien();
    }

    public static ArrayList<Integer> getListYear_1() {
        return HoaDonDAO.getListYear_1();
    }

    public static ArrayList<Integer> getTienNam(ArrayList<Integer> tienPh, ArrayList<Integer> tienDV, ArrayList<Integer> listTien, int year) {
        return HoaDonDAO.getTienNam(tienPh, tienDV, listTien, year);
    }

    public static ArrayList<Integer> getTienThang(ArrayList<Integer> tienPh, ArrayList<Integer> tienDV, int month, int year) {
        return HoaDonDAO.getTienThang(tienPh, tienDV, month, year);
    }
    
    public static String xuatExcel(String path) {
        BackUpData bk = new BackUpData();
        String message = "";
        try {
            bk.backup_VeBay(path);
            message += "Xuất file thành công";
            pathExcel = path;
        } catch (Exception ex) {
            message += "Xuất file không thành công";
        }
        return message;
    }
    
    
}
