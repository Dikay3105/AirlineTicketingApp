/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MayBayDAO;
import DTO.MayBayDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author huhuh
 */
public class MayBayBUS {
    public static String pathExcel;
    public static ArrayList<MayBayDTO> load() {
        return MayBayDAO.LoadData();
    }
    
    public int insertMayBay(MayBayDTO mbdto) throws SQLException, ParseException {
        return MayBayDAO.InsertMayBay(mbdto);
    }
    
    public void updateMayBay(MayBayDTO mbdto) throws SQLException, ParseException {
        MayBayDAO.UpdateMayBay(mbdto);
    }
    
    public void delMayBay(String maMayBay) throws SQLException, ParseException {
        MayBayDAO.DelMayBay(maMayBay);
    }
    
    public static MayBayDTO loadMB(String maMayBay) throws SQLException, ParseException {
        return MayBayDAO.LoadMayBay(maMayBay);
    }
    
    public static String xuatExcel(String path) {
        BackUpData bk = new BackUpData();
        String message = "";
        try {
            bk.backup_MayBay(path);
            message += "Xuất file thành công";
            pathExcel = path;
        } catch (Exception ex) {
            message += "Xuất file không thành công";
        }
        return message;
    }
}
