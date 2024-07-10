/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnection;
import DTO.SuDungDichVuDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author duyli
 */
public class SuDungDichVuDAO {
    public static ArrayList<SuDungDichVuDTO> SDDVList = new ArrayList<>();

    public static ArrayList<SuDungDichVuDTO> LoadData() {
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from SuDungDichVu";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SuDungDichVuDTO Nhanvien = new SuDungDichVuDTO();

                Nhanvien.setMaVe(rs.getString("MaVe"));
                Nhanvien.setMaDV(rs.getString("MaDichVu"));
                Nhanvien.setSoLuong(rs.getInt("SoLuong"));
                Nhanvien.setXuLy(rs.getInt("XuLy"));

                SDDVList.add(Nhanvien);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SDDVList;
    }
    
    public static boolean check(String mave, String maDV) {
        boolean check = false;
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select * from SuDungDichVu where MaVe = '" + mave + "' and MaDichVu='" + maDV + "'";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            check = rs.next();
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public static ArrayList<SuDungDichVuDTO> loadmv(String mave) {
        SDDVList = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from SuDungDichVu where MaVe='"+mave+"'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SuDungDichVuDTO Nhanvien = new SuDungDichVuDTO();

                Nhanvien.setMaVe(rs.getString("MaVe"));
                Nhanvien.setMaDV(rs.getString("MaDichVu"));
                Nhanvien.setSoLuong(rs.getInt("SoLuong"));
                Nhanvien.setXuLy(rs.getInt("XuLy"));

                SDDVList.add(Nhanvien);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SDDVList;
    }
    
    public static SuDungDichVuDTO loadSDDV(String mave) {
        SuDungDichVuDTO Nhanvien = new SuDungDichVuDTO();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from SuDungDichVu where MaVe='"+mave+"'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                

                Nhanvien.setMaVe(rs.getString("MaVe"));
                Nhanvien.setMaDV(rs.getString("MaDichVu"));
                Nhanvien.setSoLuong(rs.getInt("SoLuong"));
                Nhanvien.setXuLy(rs.getInt("XuLy"));

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Nhanvien;
    }
    
    public static void InsertSuDungDichVu(SuDungDichVuDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO SuDungDichVu values (?,?,?,?)";
        statement = cons.prepareCall(sql);
        statement.setString(1, NV.getMaVe());
        statement.setString(2, NV.getMaDV());
        statement.setInt(3, NV.getSoLuong());
        statement.setInt(4, NV.getXuLy());

        statement.execute();
        cons.close();
    }

    public static void DelSuDungDichVu(String mave, String madichvu) throws SQLException, ParseException {
        String sqlChange = "UPDATE SuDungDichVu SET XuLy=?  WHERE MaVe='" + mave + "' and MaDichVu='" + madichvu + "'";
      
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }
    
    public static void DelAllSDDV(String mave) throws SQLException, ParseException {
        String sqlChange = "UPDATE SuDungDichVu SET XuLy=?  WHERE MaVe='" + mave + "'";
      
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }
    
    public static void UpdateSuDungDichVu(SuDungDichVuDTO NV) throws SQLException, ParseException {
        String sqlChange = "UPDATE SuDungDichVu SET SoLuong=?, XuLy=?  WHERE MaVe='" + NV.getMaVe() + "' and MaDichVu='" + NV.getMaDV() + "'";
                
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, NV.getSoLuong());
        statement.setInt(2, NV.getXuLy());

        statement.executeUpdate();
        cons.close();
    }
}
