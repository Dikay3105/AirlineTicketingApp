/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnection;
import DTO.MayBayDTO;
import DTO.SuDungDichVuDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyli
 */
public class MayBayDAO {
    public static ArrayList<MayBayDTO> listMB = new ArrayList<>();

    public static ArrayList<MayBayDTO> LoadData() {
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from MayBay";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MayBayDTO mb = new MayBayDTO();

                mb.setMaMayBay(rs.getString("MaMayBay"));
                mb.setKichThuoc(rs.getString("KichThuoc"));
                mb.setHangBay(rs.getString("HangBay"));
                mb.setXuLy(rs.getInt("XuLy"));
                mb.setSLbus(rs.getInt("SLBussiness"));
                mb.setSLeco(rs.getInt("SLEconomy"));
                mb.setCautrucEco(rs.getString("CauTrucEco"));
                mb.setCautrucBus(rs.getString("CauTrucBus"));
               listMB.add(mb);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listMB;
    }
    
    public static int InsertMayBay(MayBayDTO MB) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO MayBay (MaMayBay, KichThuoc, HangBay, XuLy, CauTrucBus, CauTrucEco, SLBussiness, SLEconomy) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, MB.getMaMayBay());
            ps.setString(2, MB.getKichThuoc());
            ps.setString(3, MB.getHangBay());
            ps.setInt(4, 1);
            ps.setString(5, MB.getCautrucBus());
            ps.setString(6, MB.getCautrucEco());
            ps.setInt(7, MB.getSLbus());
            ps.setInt(8, MB.getSLeco());
            int result = ps.executeUpdate();
            ps.close();
            cons.close();
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1; // Return a different error code if necessary
        }
    }

   public static int UpdateMayBay(MayBayDTO MB) {
    try {
        Connection cons = DBConnect.getConnection();
        String sql = "UPDATE MayBay SET KichThuoc=?, HangBay=?, CauTrucBus=?, CauTrucEco=?, SLBussiness=?, SLEconomy=? WHERE MaMayBay=?";
        PreparedStatement ps = cons.prepareStatement(sql);
        ps.setString(1, MB.getKichThuoc());
        ps.setString(2, MB.getHangBay());
        ps.setString(3, MB.getCautrucBus());
        ps.setString(4, MB.getCautrucEco());
        ps.setInt(5, MB.getSLbus());
        ps.setInt(6, MB.getSLeco());
        ps.setString(7, MB.getMaMayBay());

        int result = ps.executeUpdate();
        ps.close();
        cons.close();
        return result;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return -1; // Return a different error code if necessary
    }
}

public static int DelMayBay(String maMayBay) throws SQLException {
    String sqlChange = "UPDATE MayBay SET XuLy=? WHERE MaMayBay='" + maMayBay + "' ";

        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        try {
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MayBayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(MayBayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
}

    
    public static MayBayDTO LoadMayBay(String mamaybay) {
        MayBayDTO mb = new MayBayDTO();
        try {
            
            java.sql.Connection cons = getConnection();
            String sql = "select * from MayBay where MaMayBay= '"+mamaybay+"'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                

                mb.setMaMayBay(rs.getString("MaMayBay"));
                mb.setKichThuoc(rs.getString("KichThuoc"));
                mb.setHangBay(rs.getString("HangBay"));
                mb.setXuLy(rs.getInt("XuLy"));
                mb.setSLbus(rs.getInt("SLBussiness"));
                mb.setSLeco(rs.getInt("SLEconomy"));
                mb.setCautrucEco(rs.getString("CauTrucEco"));
                mb.setCautrucBus(rs.getString("CauTrucBus"));

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mb;
    }
    
    public  List<MayBayDTO> getALL(){
        List<MayBayDTO> ls = new ArrayList<>();
        try{
            String SQL ="select * from MayBay";
            java.sql.Connection cons = getConnection();
            PreparedStatement ps = cons.prepareCall(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                MayBayDTO mb = new MayBayDTO();
                mb.setMaMayBay(rs.getString("MaMayBay"));
                mb.setKichThuoc(rs.getString("KichThuoc"));
                mb.setHangBay(rs.getString("HangBay"));
                mb.setXuLy(rs.getInt("XuLy"));
                mb.setSLbus(rs.getInt("SLBussiness"));
                mb.setSLeco(rs.getInt("SLEconomy"));
                mb.setCautrucEco(rs.getString("CauTrucEco"));
                mb.setCautrucBus(rs.getString("CauTrucBus"));
                ls.add(mb);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }
        return ls;
    }
    public int insert(MayBayDTO MB){
        try {
            String sql = "INSERT INTO DuongBay values (?,?,?,?,?,?,?,?)";
            java.sql.Connection cons = getConnection();
            PreparedStatement statement = null;
            statement.setString(1, MB.getMaMayBay());
            statement.setString(2, MB.getKichThuoc());
            statement.setString(3, MB.getHangBay());
            statement.setInt(4, MB.getXuLy());
            statement.setString(5, MB.getCautrucBus());
            statement.setString(6, MB.getCautrucEco());
            statement.setInt(7, MB.getSLbus());
            statement.setInt(8, MB.getSLeco());
            if (statement.executeUpdate()>0){
            System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString());
        }
        return -1;
    }public int getSLMayBay() throws SQLException{
    int stt=0;
    try{
        String sql = "SELECT COUNT(*) FROM dbo.MayBay";
        java.sql.Connection cons = getConnection();
        PreparedStatement ps = cons.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            stt=rs.getInt(1);
        }
    } catch(Exception e){
        System.out.println("Error: " + e.toString());
    }
    return stt;
}
    
    public static List<MayBayDTO> findByAirlineAndSize(String airline, String size) {
    List<MayBayDTO> result = new ArrayList<>();
    try {
        java.sql.Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM MayBay WHERE HangBay=? AND KichThuoc=?";
        PreparedStatement ps = cons.prepareStatement(sql);
        ps.setString(1, airline);
        ps.setString(2, size);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            MayBayDTO mb = new MayBayDTO();
            mb.setMaMayBay(rs.getString("MaMayBay"));
            mb.setKichThuoc(rs.getString("KichThuoc"));
            mb.setHangBay(rs.getString("HangBay"));
            mb.setXuLy(rs.getInt("XuLy"));
            mb.setCautrucBus(rs.getString("CauTrucBus"));
            mb.setCautrucEco(rs.getString("CauTrucEco"));
            mb.setSLbus(rs.getInt("SLBussiness"));
            mb.setSLeco(rs.getInt("SLEconomy"));
            result.add(mb);
        }
        rs.close();
        ps.close();
        cons.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return result;
}
    
    public static List<MayBayDTO> findByAirlineAndSizeAndSL(String airline, String size, int sleco, int slbus) {
    List<MayBayDTO> result = new ArrayList<>();
    try {
        java.sql.Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM MayBay WHERE HangBay=? AND KichThuoc=?  and SLEconomy=? and SLBussiness=?";
        PreparedStatement ps = cons.prepareStatement(sql);
        ps.setString(1, airline);
        ps.setString(2, size);
        ps.setInt(3, sleco);
        ps.setInt(4, slbus);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            MayBayDTO mb = new MayBayDTO();
            mb.setMaMayBay(rs.getString("MaMayBay"));
            mb.setKichThuoc(rs.getString("KichThuoc"));
            mb.setHangBay(rs.getString("HangBay"));
            mb.setXuLy(rs.getInt("XuLy"));
            mb.setCautrucBus(rs.getString("CauTrucBus"));
            mb.setCautrucEco(rs.getString("CauTrucEco"));
            mb.setSLbus(rs.getInt("SLBussiness"));
            mb.setSLeco(rs.getInt("SLEconomy"));
            result.add(mb);
        }
        rs.close();
        ps.close();
        cons.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return result;
}
    
    public List<MayBayDTO> findBySize(String size) {
    List<MayBayDTO> result = new ArrayList<>();
    try {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM MayBay WHERE KichThuoc=?";
        PreparedStatement ps = cons.prepareStatement(sql);
        ps.setString(1, size);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            MayBayDTO mb = new MayBayDTO();
            mb.setMaMayBay(rs.getString("MaMayBay"));
            mb.setKichThuoc(rs.getString("KichThuoc"));
            mb.setHangBay(rs.getString("HangBay"));
            mb.setXuLy(rs.getInt("XuLy"));
            mb.setCautrucBus(rs.getString("CauTrucBus"));
            mb.setCautrucEco(rs.getString("CauTrucEco"));
            mb.setSLbus(rs.getInt("SLBussiness"));
            mb.setSLeco(rs.getInt("SLEconomy"));
            result.add(mb);
        }
        rs.close();
        ps.close();
        cons.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return result;
}
    
    public List<MayBayDTO> findByAirline(String airline) {
    List<MayBayDTO> result = new ArrayList<>();
    try {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM MayBay WHERE HangBay=?";
        PreparedStatement ps = cons.prepareStatement(sql);
        ps.setString(1, airline);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            MayBayDTO mb = new MayBayDTO();
            mb.setMaMayBay(rs.getString("MaMayBay"));
            mb.setKichThuoc(rs.getString("KichThuoc"));
            mb.setHangBay(rs.getString("HangBay"));
            mb.setXuLy(rs.getInt("XuLy"));
            mb.setCautrucBus(rs.getString("CauTrucBus"));
            mb.setCautrucEco(rs.getString("CauTrucEco"));
            mb.setSLbus(rs.getInt("SLBussiness"));
            mb.setSLeco(rs.getInt("SLEconomy"));
            result.add(mb);
        }
        rs.close();
        ps.close();
        cons.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return result;
}
    
    public MayBayDTO findByID(String id) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM MayBay WHERE MaMayBay=?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MayBayDTO mb = new MayBayDTO();
                mb.setMaMayBay(rs.getString("MaMayBay"));
                mb.setKichThuoc(rs.getString("KichThuoc"));
                mb.setHangBay(rs.getString("HangBay"));
                mb.setXuLy(rs.getInt("XuLy"));
                mb.setCautrucBus(rs.getString("CauTrucBus"));
                mb.setCautrucEco(rs.getString("CauTrucEco"));
                mb.setSLbus(rs.getInt("SLBussiness"));
                mb.setSLeco(rs.getInt("SLEconomy"));
                return mb;
            }
            rs.close();
            ps.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static boolean mbStillWork(String id) {
        String machuyenbay=null;
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM ChuyenBay WHERE MaMayBay=? "
                    + "AND CONVERT(DATETIME, Cast(cb.NgayDi as DATETIME) + Cast(cb.GioDelay as DATETIME)) >= CONVERT(DATETIME, GETDATE())";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                machuyenbay=rs.getString("MaChuyenBay");
            }
            rs.close();
            ps.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(machuyenbay==null) return false;
        return true;
    }
}
