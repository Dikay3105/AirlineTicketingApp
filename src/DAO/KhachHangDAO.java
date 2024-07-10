
package DAO;

import static DAO.DBConnect.getConnection;
import DTO.KhachHangDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class KhachHangDAO {
    
    public static ArrayList<KhachHangDTO> KHList = new ArrayList<>();

    public static ArrayList<KhachHangDTO> LoadData() {
        KHList = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from KhachHang";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangDTO KhachHang = new KhachHangDTO();

                KhachHang.setMaKH(rs.getString("MaKhachHang"));
                KhachHang.setTenKH(rs.getString("TenKhachHang"));
                KhachHang.setGioiTinh(rs.getInt("GioiTinh"));
                KhachHang.setSdt(rs.getString("SDT"));
                KhachHang.setCccd(rs.getString("CCCD"));
                KhachHang.setXuLy(rs.getInt("XuLy"));
                KhachHang.setMail(rs.getString("mail").trim());
                
                
                Date date = rs.getDate("NgaySinh");    
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); 
                String dateString = sdf1.format(date);
                KhachHang.setNgaySinh(dateString);
                KHList.add(KhachHang);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return KHList;
    }

    public static ArrayList<KhachHangDTO> LoadDatatheomaKH(String maKH) {
        KHList = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from KhachHang where MaKhachHang='"+maKH+"'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangDTO KhachHang = new KhachHangDTO();
                KhachHang.setMaKH(rs.getString("MaKhachHang"));
                KhachHang.setTenKH(rs.getString("TenKhachHang"));
                Date date = rs.getDate("NgaySinh");    
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); 
                String dateString = sdf1.format(date);
                KhachHang.setNgaySinh(dateString);
                KhachHang.setGioiTinh(rs.getInt("GioiTinh"));
                KhachHang.setSdt(rs.getString("SDT"));
                KhachHang.setCccd(rs.getString("CCCD"));
                KhachHang.setXuLy(rs.getInt("XuLy"));
                KhachHang.setMail(rs.getString("mail").trim());
                KHList.add(KhachHang);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return KHList;
    }
    
    public static KhachHangDTO LoadKHtheoMaVe(String mave) {
        KhachHangDTO KhachHang = new KhachHangDTO();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from KhachHang kh, VeBay vb "
                    + "where kh.MaKhachHang=vb.MaKhachHang and "
                    + "vb.MaVe='"+mave+"'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                

                KhachHang.setMaKH(rs.getString("MaKhachHang"));
                KhachHang.setTenKH(rs.getString("TenKhachHang"));
                Date date = rs.getDate("NgaySinh");    
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); 
                String dateString = sdf1.format(date);
                KhachHang.setNgaySinh(dateString);
                KhachHang.setGioiTinh(rs.getInt("GioiTinh"));
                KhachHang.setSdt(rs.getString("SDT"));
                KhachHang.setCccd(rs.getString("CCCD"));
                KhachHang.setXuLy(rs.getInt("XuLy"));
                KhachHang.setMail(rs.getString("mail").trim());
             

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return KhachHang;
    }
    
    public static void InsertKhachHang(KhachHangDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO KhachHang (MaKhachHang, TenKhachHang, CCCD, GioiTinh, SDT, XuLy,"
                + "mail, NgaySinh) values (?,?,?,?,?,?,?,?)";
        statement = cons.prepareCall(sql);
        statement.setString(1, NV.getMaKH());
        statement.setString(2, NV.getTenKH());
        statement.setString(3, NV.getCccd());
        statement.setInt(4, NV.getGioiTinh());
        statement.setString(5, NV.getSdt());
        statement.setInt(6, 1);
        statement.setString(7, NV.getMail());
        
        
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date3 = sdf1.parse(NV.getNgaySinh());
        java.sql.Date sqlDate = new java.sql.Date(date3.getTime());
        statement.setDate(8, sqlDate);
 
        statement.execute();
        cons.close();
    }

    public static void DelKhachHang(String maKhachHang) throws SQLException, ParseException {
        String sqlChange = "UPDATE KhachHang SET XuLy=?  WHERE MaKhachHang='" + maKhachHang + "'";
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }

    public static void UpdateKhachHang(KhachHangDTO NV) throws SQLException, ParseException {
        String sqlChange = "UPDATE KhachHang SET TenKhachHang=?, CCCD=?, GioiTinh=?, SDT=?, "
                + "mail=?, NgaySinh=?  WHERE MaKhachHang= '" + NV.getMaKH() + "'";

        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setString(1, NV.getTenKH());
        statement.setString(2, NV.getCccd());
        statement.setInt(3, NV.getGioiTinh());
        statement.setString(4, NV.getSdt());
        statement.setString(5, NV.getMail());
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date3 = sdf1.parse(NV.getNgaySinh());
        java.sql.Date sqlDate = new java.sql.Date(date3.getTime());
        statement.setDate(6, sqlDate);
        
        statement.executeUpdate();
        cons.close();
    }
}
