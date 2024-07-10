/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnection;
import DTO.DuongBayDTO;
import java.beans.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author duyli
 */
public class DuongBayDAO {
    public static ArrayList<DuongBayDTO> listDB = new ArrayList<>();

    public static ArrayList<DuongBayDTO> LoadData() {
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from DuongBay";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DuongBayDTO mb = new DuongBayDTO();

                mb.setMaDuongBay(rs.getString("MaDuongBay"));
                mb.setNoiDi(rs.getString("NoiDi"));
                mb.setNoiDen(rs.getString("NoiDen"));
                
                java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
                Date date = new Date(timestamp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                
                String formattedDate = formatter.format(date);
                mb.setThoiGianBay(formattedDate);
                mb.setNoiNgoai(rs.getInt("NoiNgoai"));
                mb.setXuLy(rs.getInt("XuLy"));
               listDB.add(mb);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listDB;
    }
    
    public static DuongBayDTO loadDB(String madb) {
        DuongBayDTO mb = new DuongBayDTO();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from DuongBay where MaDuongBay='"+madb+"'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                

                mb.setMaDuongBay(rs.getString("MaDuongBay"));
                mb.setNoiDi(rs.getString("NoiDi"));
                mb.setNoiDen(rs.getString("NoiDen"));
                
                java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
                Date date = new Date(timestamp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                
                String formattedDate = formatter.format(date);
                mb.setThoiGianBay(formattedDate);
                mb.setNoiNgoai(rs.getInt("NoiNgoai"));
                mb.setXuLy(rs.getInt("XuLy"));

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mb;
    }

    public static  List<DuongBayDTO> getALL(){
        List<DuongBayDTO> ls = new ArrayList<>();
        try{
            String SQL ="select * from DuongBay";
            java.sql.Connection cons = getConnection();
            PreparedStatement ps = cons.prepareCall(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DuongBayDTO db = new DuongBayDTO();
                db.setMaDuongBay(rs.getString("MaDuongBay"));
                db.setNoiDi(rs.getString("NoiDi"));
                db.setNoiDen(rs.getString("NoiDen"));
                java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
                Date date = new Date(timestamp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");                
                String formattedDate = formatter.format(date);
                db.setThoiGianBay(formattedDate);
                db.setNoiNgoai(rs.getInt("NoiNgoai"));
                db.setXuLy(rs.getInt("XuLy"));
                ls.add(db);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }
        return ls;
    }
    
    public static void InsertDuongBay(DuongBayDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO DuongBay values (?,?,?,?,?,?)";
        statement = cons.prepareCall(sql);
        statement.setString(1, NV.getMaDuongBay());
        statement.setString(2, NV.getNoiDi());
        statement.setString(3, NV.getNoiDen());
        statement.setInt(5, NV.getNoiNgoai());
        statement.setInt(6, NV.getXuLy());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date = sdf.parse(NV.getThoiGianBay());
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime());
        statement.setTimestamp(4, sqlTimestamp);
        statement.executeUpdate();
        cons.close();
    }
    public int insert(DuongBayDTO DB){
        try {
            String sql = "INSERT INTO DuongBay values (?,?,?,?,?,?)";
            java.sql.Connection cons = getConnection();
            PreparedStatement statement = null;
            statement = cons.prepareCall(sql);
            statement.setString(1, DB.getMaDuongBay());
            statement.setString(2, DB.getNoiDi());
            statement.setString(3, DB.getNoiDen());
            statement.setInt(5, DB.getNoiNgoai());
            statement.setInt(6, DB.getXuLy());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            java.util.Date date = sdf.parse(DB.getThoiGianBay());
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime());
            statement.setTimestamp(4, sqlTimestamp);
            if (statement.executeUpdate()>0){
            System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString());
        }
        return -1;
    }
    public static void DelDuongBay(String maDuongBay) throws SQLException, ParseException {
        String sqlChange = "UPDATE DuongBay SET XuLy=?  WHERE MaDuongBay='"+maDuongBay+"'" ;
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }
    
    public int del(String  maDuongBay){
        try {
            String sqlChange = "UPDATE DuongBay SET XuLy=?  WHERE MaDuongBay='"+maDuongBay+"'" ;
            java.sql.Connection cons = getConnection();
            PreparedStatement statement = cons.prepareCall(sqlChange);
            statement.setInt(1,0);
            if (statement.executeUpdate()>0){
                System.out.println("Delete thanh cong");
                return 1;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString());
        }
        return -1;
    }
    public static void UpdateDuongBay(DuongBayDTO DB) throws SQLException, ParseException {
        String sqlChange = "UPDATE DuongBay SET NoiDi=?, NoiDen=?, ThoiGianBayUocTinh=?, NoiNgoai=?  WHERE MaDuongBay='" + DB.getMaDuongBay()+ "'";              
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setString(1, DB.getNoiDi());
        statement.setString(2, DB.getNoiDen());
        statement.setInt(4, DB.getNoiNgoai());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date = sdf.parse(DB.getThoiGianBay());
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime());
        statement.setTimestamp(3, sqlTimestamp);
        statement.executeUpdate();
        cons.close();
    }
    public int update(DuongBayDTO DB){
        try {
            String sqlChange = "UPDATE DuongBay SET NoiDi=?, NoiDen=?, ThoiGianBayUocTinh=?, NoiNgoai=?  WHERE MaDuongBay='" + DB.getMaDuongBay()+ "'";
            java.sql.Connection cons = getConnection();
            PreparedStatement statement = cons.prepareCall(sqlChange);
            statement.setString(1, DB.getNoiDi());
            statement.setString(2, DB.getNoiDen());
            statement.setInt(4, DB.getNoiNgoai());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            java.util.Date date = sdf.parse(DB.getThoiGianBay());
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime());
            statement.setTimestamp(3, sqlTimestamp);
                 if (statement.executeUpdate()>0){
                        System.out.println("Update thanh cong");
                        return 1;
                        }
            }catch (Exception e){
                System.out.println("Error: "+ e.toString());
                }
            return -1;
    }

    public List<DuongBayDTO> getAllActive() {
    List<DuongBayDTO> ls = new ArrayList<>();
    try {
        String SQL = "SELECT * FROM DuongBay WHERE XuLy = 1"; 
        java.sql.Connection cons = getConnection();
        PreparedStatement ps = cons.prepareCall(SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DuongBayDTO db = new DuongBayDTO();
            db.setMaDuongBay(rs.getString("MaDuongBay"));
            db.setNoiDi(rs.getString("NoiDi"));
            db.setNoiDen(rs.getString("NoiDen"));
            java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
            Date date = new Date(timestamp.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String formattedDate = formatter.format(date);
            db.setThoiGianBay(formattedDate);
            db.setNoiNgoai(rs.getInt("NoiNgoai"));
            db.setXuLy(rs.getInt("XuLy"));
            ls.add(db);
        }
    } catch (Exception e) {
        System.out.println("Error:" + e.toString());
    }
    return ls;
}
    
    public static ArrayList<DuongBayDTO> getAllActive1() {
        try {
            java.sql.Connection cons = getConnection();
            String sql = "SELECT * FROM DuongBay WHERE XuLy = 1";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DuongBayDTO mb = new DuongBayDTO();
                mb.setMaDuongBay(rs.getString("MaDuongBay"));
                mb.setNoiDi(rs.getString("NoiDi"));
                mb.setNoiDen(rs.getString("NoiDen"));
                java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
                Date date = new Date(timestamp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                String formattedDate = formatter.format(date);
                mb.setThoiGianBay(formattedDate);
                mb.setNoiNgoai(rs.getInt("NoiNgoai"));
                mb.setXuLy(rs.getInt("XuLy"));
               listDB.add(mb);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listDB;
    }
    
  public List<DuongBayDTO> getAllUnActive() {
    List<DuongBayDTO> ls = new ArrayList<>();
    try {
        String SQL = "SELECT * FROM DuongBay WHERE XuLy = 0"; 
        java.sql.Connection cons = getConnection();
        PreparedStatement ps = cons.prepareCall(SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DuongBayDTO db = new DuongBayDTO();
            db.setMaDuongBay(rs.getString("MaDuongBay"));
            db.setNoiDi(rs.getString("NoiDi"));
            db.setNoiDen(rs.getString("NoiDen"));
            java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
            Date date = new Date(timestamp.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String formattedDate = formatter.format(date);
            db.setThoiGianBay(formattedDate);
            db.setNoiNgoai(rs.getInt("NoiNgoai"));
            db.setXuLy(rs.getInt("XuLy"));
            ls.add(db);
        }
    } catch (Exception e) {
        System.out.println("Error:" + e.toString());
    }
    return ls;
}
    public  List<DuongBayDTO> getNoiDi(String NoiDi){
        List<DuongBayDTO> ls = new ArrayList<>();
        try{
            String SQL ="SELECT * FROM DuongBay WHERE NoiDi='"+NoiDi+"'";
            java.sql.Connection cons = getConnection();
            PreparedStatement ps = cons.prepareCall(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DuongBayDTO db = new DuongBayDTO();
                db.setMaDuongBay(rs.getString("MaDuongBay"));
                db.setNoiDi(rs.getString("NoiDi"));
                db.setNoiDen(rs.getString("NoiDen"));
                java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
                Date date = new Date(timestamp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");                
                String formattedDate = formatter.format(date);
                db.setThoiGianBay(formattedDate);
                db.setNoiNgoai(rs.getInt("NoiNgoai"));
                db.setXuLy(rs.getInt("XuLy"));
                ls.add(db);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }
        return ls;
    }
        public  List<DuongBayDTO> getNoiDen(String NoiDen){
        List<DuongBayDTO> ls = new ArrayList<>();
        try{
            String SQL ="SELECT * FROM DuongBay WHERE NoiDen='"+NoiDen+"'";
            java.sql.Connection cons = getConnection();
            PreparedStatement ps = cons.prepareCall(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DuongBayDTO db = new DuongBayDTO();
                db.setMaDuongBay(rs.getString("MaDuongBay"));
                db.setNoiDi(rs.getString("NoiDi"));
                db.setNoiDen(rs.getString("NoiDen"));
                java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
                Date date = new Date(timestamp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");                
                String formattedDate = formatter.format(date);
                db.setThoiGianBay(formattedDate);
                db.setNoiNgoai(rs.getInt("NoiNgoai"));
                db.setXuLy(rs.getInt("XuLy"));
                ls.add(db);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }
        return ls;
    }
    public List<DuongBayDTO> getDuongBayByNoiDiNoiDen(String noiDi, String noiDen) {
    List<DuongBayDTO> ls = new ArrayList<>();
    try {
        String SQL = "SELECT * FROM DuongBay WHERE NoiDi = ? OR NoiDen = ?";
        java.sql.Connection cons = getConnection();
        PreparedStatement ps = cons.prepareStatement(SQL);
        ps.setString(1, noiDi);
        ps.setString(2, noiDen);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            DuongBayDTO db = new DuongBayDTO();
            db.setMaDuongBay(rs.getString("MaDuongBay"));
            db.setNoiDi(rs.getString("NoiDi"));
            db.setNoiDen(rs.getString("NoiDen"));
            java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
            Date date = new Date(timestamp.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");                
            String formattedDate = formatter.format(date);
            db.setThoiGianBay(formattedDate);
            db.setNoiNgoai(rs.getInt("NoiNgoai"));
            db.setXuLy(rs.getInt("XuLy"));
            ls.add(db);
        }
    } catch (Exception e) {
        System.out.println("Error:"+e.toString());
    }
    return ls;
}

    public List<DuongBayDTO> findDuongBayByID (String maDuongBay){
         List<DuongBayDTO> ls = new ArrayList<>();
        try{
            String sql = "SELECT * FROM DuongBay WHERE MaDuongBay ='"+maDuongBay+"'";
            java.sql.Connection cons = getConnection();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DuongBayDTO db = new DuongBayDTO();
                db.setMaDuongBay(rs.getString("MaDuongBay"));
                db.setNoiDi(rs.getString("NoiDi"));
                db.setNoiDen(rs.getString("NoiDen"));
                java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
                Date date = new Date(timestamp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");                
                String formattedDate = formatter.format(date);
                db.setThoiGianBay(formattedDate);
                db.setNoiNgoai(rs.getInt("NoiNgoai"));
                db.setXuLy(rs.getInt("XuLy"));
                ls.add(db);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }
        return ls;
    }
    
    public List<DuongBayDTO> getRoutesByNoiDiNoiDen(String noiDi, String noiDen) {
    List<DuongBayDTO> routes = new ArrayList<>();
    try {
        String sql = "SELECT * FROM DuongBay WHERE NoiDi = ? AND NoiDen = ?";
        java.sql.Connection cons = getConnection();
        PreparedStatement ps = cons.prepareStatement(sql);
        ps.setString(1, noiDi);
        ps.setString(2, noiDen);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DuongBayDTO db = new DuongBayDTO();
            db.setMaDuongBay(rs.getString("MaDuongBay"));
            db.setNoiDi(rs.getString("NoiDi"));
            db.setNoiDen(rs.getString("NoiDen"));
            java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
            Date date = new Date(timestamp.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String formattedDate = formatter.format(date);
            db.setThoiGianBay(formattedDate);
            db.setNoiNgoai(rs.getInt("NoiNgoai"));
            db.setXuLy(rs.getInt("XuLy"));
            routes.add(db);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return routes;
}
    
    public  int getSLDuongbay(){
        int stt=0;
        try {
            String sql = "SELECT COUNT(*) FROM dbo.DuongBay";
            java.sql.Connection cons = getConnection();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               stt=rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }
        return stt;
    }
    
    public int getMaxMaDuongBay() {
        int maxMaDuongBay = 0;

        String sql = "select count(MaDuongBay) from DuongBay";

        try (
            java.sql.Connection cons = getConnection();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();) {
            if (rs.next()) {
                maxMaDuongBay = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxMaDuongBay;
    }
    
    public List<DuongBayDTO> getDuongBayByNoiDiNoiDen1(String noiDi, String noiDen) {
    List<DuongBayDTO> ls = new ArrayList<>();
    try {
        String SQL = "SELECT * FROM DuongBay WHERE NoiDi = ? AND NoiDen = ?";
        java.sql.Connection cons = getConnection();
        PreparedStatement ps = cons.prepareStatement(SQL);
        ps.setString(1, noiDi);
        ps.setString(2, noiDen);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            DuongBayDTO db = new DuongBayDTO();
            db.setMaDuongBay(rs.getString("MaDuongBay"));
            db.setNoiDi(rs.getString("NoiDi"));
            db.setNoiDen(rs.getString("NoiDen"));
            java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
            Date date = new Date(timestamp.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");                
            String formattedDate = formatter.format(date);
            db.setThoiGianBay(formattedDate);
            db.setNoiNgoai(rs.getInt("NoiNgoai"));
            db.setXuLy(rs.getInt("XuLy"));
            ls.add(db);
        }
    } catch (Exception e) {
        System.out.println("Error:"+e.toString());
    }
    return ls;
}
    
    public List<DuongBayDTO> getAllUnActiveByNoiDiNoiDen(String noiDi, String noiDen) {
    List<DuongBayDTO> ls = new ArrayList<>();
    try {
        String SQL = "SELECT * FROM DuongBay WHERE XuLy = 0 AND (NoiDi = ? AND NoiDen = ?)";
        java.sql.Connection cons = getConnection();
        PreparedStatement ps = cons.prepareStatement(SQL);
        ps.setString(1, noiDi);
        ps.setString(2, noiDen);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DuongBayDTO db = new DuongBayDTO();
            db.setMaDuongBay(rs.getString("MaDuongBay"));
            db.setNoiDi(rs.getString("NoiDi"));
            db.setNoiDen(rs.getString("NoiDen"));
            java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
            Date date = new Date(timestamp.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String formattedDate = formatter.format(date);
            db.setThoiGianBay(formattedDate);
            db.setNoiNgoai(rs.getInt("NoiNgoai"));
            db.setXuLy(rs.getInt("XuLy"));
            ls.add(db);
        }
    } catch (Exception e) {
        System.out.println("Error:" + e.toString());
    }
    return ls;
}
    
    public List<DuongBayDTO> getAllActiveByNoiDiNoiDen(String noiDi, String noiDen) {
    List<DuongBayDTO> ls = new ArrayList<>();
    try {
        String SQL = "SELECT * FROM DuongBay WHERE XuLy = 1 AND (NoiDi = ? AND NoiDen = ?)";
        java.sql.Connection cons = getConnection();
        PreparedStatement ps = cons.prepareStatement(SQL);
        ps.setString(1, noiDi);
        ps.setString(2, noiDen);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DuongBayDTO db = new DuongBayDTO();
            db.setMaDuongBay(rs.getString("MaDuongBay"));
            db.setNoiDi(rs.getString("NoiDi"));
            db.setNoiDen(rs.getString("NoiDen"));
            java.sql.Timestamp timestamp = rs.getTimestamp("ThoiGianBayUocTinh");
            Date date = new Date(timestamp.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String formattedDate = formatter.format(date);
            db.setThoiGianBay(formattedDate);
            db.setNoiNgoai(rs.getInt("NoiNgoai"));
            db.setXuLy(rs.getInt("XuLy"));
            ls.add(db);
        }
    } catch (Exception e) {
        System.out.println("Error:" + e.toString());
    }
    return ls;
}
    
    public int undoldel(String  maDuongBay){
        try {
            String sqlChange = "UPDATE DuongBay SET XuLy=?  WHERE MaDuongBay='"+maDuongBay+"'" ;
            java.sql.Connection cons = getConnection();
            PreparedStatement statement = cons.prepareCall(sqlChange);
            statement.setInt(1,1);
            if (statement.executeUpdate()>0){
                System.out.println("Khoi phuc thanh cong");
                return 1;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString());
        }
        return -1;
    }
    
//    public String checkDBIsUsed(String  maDuongBay){
//        String value="";
//        try {
//            String sqlChange = "SELECT \n" +
//"    CASE \n" +
//"        WHEN EXISTS (\n" +
//"            SELECT 1\n" +
//"            FROM ChuyenBay\n" +
//"            WHERE MaDuongBay = '"+maDuongBay+"' AND \n" +
//"                  (TRY_CAST(NgayDi AS DATETIME) IS NOT NULL) AND\n" +
//"                  (CONVERT(DATETIME, NgayDi) + CAST(GioDelay AS DATETIME)) >= GETDATE()\n" +
//"        )\n" +
//"        THEN 'true'\n" +
//"        ELSE 'false'\n" +
//"    END AS Result;" ;
//            java.sql.Connection cons = getConnection();
//            PreparedStatement statement = cons.prepareCall(sqlChange);
//            ResultSet rs = statement.executeQuery();
//        while (rs.next()) {
//            value=rs.getString("Result");
//        }
//        } catch (Exception e){
//            System.out.println("Error: "+ e.toString());
//        }
//        return value;
//    }
//    
}
    
