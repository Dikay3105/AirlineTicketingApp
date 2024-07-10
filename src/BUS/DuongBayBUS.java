/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DuongBayDAO;
import DTO.DuongBayDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author huhuh
 */
public class DuongBayBUS {
    public static String pathExcel="";
    public static ArrayList<DuongBayDTO> load() {
        return DuongBayDAO.LoadData();
    }
    
    public static void insertDuongBay(DuongBayDTO dbdto) throws SQLException, ParseException {
        DuongBayDAO.InsertDuongBay(dbdto);
    }
    
    public static void updateDuongBay(DuongBayDTO dbdto) throws SQLException, ParseException {
        DuongBayDAO.UpdateDuongBay(dbdto);
    }
    
    public static void delDuongBay(String maDuongBay) throws SQLException, ParseException {
        DuongBayDAO.DelDuongBay(maDuongBay);
    }
    
    public static DuongBayDTO loadDB (String maDuongBay) {
        return DuongBayDAO.loadDB(maDuongBay);
    }
    
    public static String xuatExcel(String path) {
        BackUpData bk = new BackUpData();
        String message = "";
        try {
            bk.backup_DuongBay(path);
            message += "Xuất file thành công";
            pathExcel = path;
        } catch (Exception ex) {
            message += "Xuất file không thành công";
        }
        return message;
    }
}
