/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SuDungDichVuDAO;
import DTO.SuDungDichVuDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author huhuh
 */
public class SuDungDichVuBUS {
    public static ArrayList<SuDungDichVuDTO> load() {
        return SuDungDichVuDAO.LoadData();
    }
    
    public static ArrayList<SuDungDichVuDTO> loadmv(String mave) {
        return SuDungDichVuDAO.loadmv(mave);
    }
    
    public static SuDungDichVuDTO loadSDDV(String mave) {
        return loadSDDV(mave);
    }
    
    public static void insertSDDV(SuDungDichVuDTO sddvdto) throws SQLException, ParseException {
        SuDungDichVuDAO.InsertSuDungDichVu(sddvdto);
    }
    
    public static void delSDDV(String maVe, String maDichVu) throws SQLException, ParseException {
        SuDungDichVuDAO.DelSuDungDichVu(maVe,maDichVu);
    }
    
    public static void delAllSDDV(String maVe) throws SQLException, ParseException {
        SuDungDichVuDAO.DelAllSDDV(maVe);
    }
    
    public static void updateSDDV (SuDungDichVuDTO sddvdto) throws SQLException, ParseException {
        SuDungDichVuDAO.UpdateSuDungDichVu(sddvdto );
    }
    
    public static boolean check(String mave, String maDV) {
        return SuDungDichVuDAO.check(mave, maDV);
    }
    
}
