/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author huhuh
 */
public class KhachHangBUS {
    public static String pathExcel;
    public static ArrayList<KhachHangDTO> load() {
        ArrayList<KhachHangDTO> a = new ArrayList<>();
        ArrayList<KhachHangDTO> b = new ArrayList<>();
        a = new KhachHangDAO().LoadData();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getXuLy() == 1) {
                b.add(a.get(i));
            }
        }
        return b;
    }
    
    public static ArrayList<KhachHangDTO> loadKH(String maKH) {
        return KhachHangDAO.LoadDatatheomaKH(maKH);
    }
    
    public static KhachHangDTO loadKHtheoMaVe(String mave) {
        return KhachHangDAO.LoadKHtheoMaVe(mave);
    }
    
    public static void insertKhachHang(KhachHangDTO khachHangDTO) throws SQLException, ParseException {
        KhachHangDAO.InsertKhachHang(khachHangDTO);
    }
    
    public static void updateKhachHang(KhachHangDTO khachHangDTO) throws SQLException, ParseException {
        KhachHangDAO.UpdateKhachHang(khachHangDTO);
    }
    
    public static void delKhachHang(String maKhachHang) throws SQLException, ParseException {
        KhachHangDAO.DelKhachHang(maKhachHang);
    }
    
    public static String xuatExcel(String path) {
        BackUpData bk = new BackUpData();
        String message = "";
        try {
            bk.backup_KhachHang(path);
            message += "Xuất file thành công";
            pathExcel = path;
        } catch (Exception ex) {
            message += "Xuất file không thành công";
        }
        return message;
    }
}
