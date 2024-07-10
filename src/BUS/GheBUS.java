/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.GheDAO;
import DTO.GheDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author huhuh
 */
public class GheBUS {
    public static ArrayList<GheDTO> load() {
        return GheDAO.LoadData();
    }
    
    public static GheDTO loadGhe(String maghe,String mamaybay) {
        return GheDAO.LoadGhe(maghe,mamaybay);
    }
    
    public static void insertGhe(GheDTO gheDTO) throws SQLException, ParseException {
        GheDAO.InsertGhe(gheDTO);
    }
    
    public static void DelAllGhe(String mamaybay) throws SQLException, ParseException {
        GheDAO.DelAllGhe(mamaybay);
    }
    
//    public static void updateGhe(GheDTO gheDTO) throws SQLException, ParseException {
//        GheDAO.UpdateGhe(gheDTO);
//    }
    
    public static void delGhe(String maGhe) throws SQLException, ParseException {
        GheDAO.DelGhe(maGhe);
    }
}
