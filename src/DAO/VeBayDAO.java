/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnection;
import DTO.HoaDonDTO;
import DTO.VeBayDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author duyli
 */
public class VeBayDAO {
    
    public static ArrayList<VeBayDTO> listVB = new ArrayList<>();

    public static ArrayList<VeBayDTO> LoadData() {
        listVB = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from VeBay";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VeBayDTO hd = new VeBayDTO();
                hd.setMaVe(rs.getString("MaVe"));       
                hd.setMaKhachHang(rs.getString("MaKhachHang"));
                hd.setMaNhanVien(rs.getString("MaNhanVien"));
                hd.setMaChuyenBay(rs.getString("MaChuyenBay"));
                hd.setGiaVe(rs.getLong("GiaVe"));
                hd.setMaghe(rs.getString("MaGhe"));
                hd.setXuLy(rs.getInt("XuLy"));
                hd.setDoiGhe(rs.getInt("DoiGhe"));
                
                listVB.add(hd);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listVB;
    }
    
    
    
    public static ArrayList<VeBayDTO> LoadDataActive() {
        listVB = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from VeBay where XuLy=1";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VeBayDTO hd = new VeBayDTO();
                hd.setMaVe(rs.getString("MaVe"));       
                hd.setMaKhachHang(rs.getString("MaKhachHang"));
                hd.setMaNhanVien(rs.getString("MaNhanVien"));
                hd.setMaChuyenBay(rs.getString("MaChuyenBay"));
                hd.setGiaVe(rs.getLong("GiaVe"));
                hd.setMaghe(rs.getString("MaGhe"));
                hd.setXuLy(rs.getInt("XuLy"));
                hd.setDoiGhe(rs.getInt("DoiGhe"));
                
                listVB.add(hd);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listVB;
    }

    public static void InsertVeBay(VeBayDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO VeBay (MaVe,MaKhachHang,MaNhanVien,MaChuyenBay,GiaVe,MaGhe,XuLy,DoiGhe) values (?,?,?,?,?,?,?,?)";
        statement = cons.prepareCall(sql);
        statement.setString(1, NV.getMaVe());
        statement.setString(2, NV.getMaKhachHang());
        statement.setString(3, NV.getMaNhanVien());
        statement.setString(4, NV.getMaChuyenBay());
        statement.setString(6, NV.getMaghe());
        statement.setLong(5, NV.getGiaVe());
        statement.setInt(7, NV.getXuLy());
        statement.setInt(8, NV.getDoiGhe());
        
        statement.execute();
        cons.close();
    }

    public static void DelVeBay(String mave) throws SQLException, ParseException {
        String sqlChange = "UPDATE VeBay SET XuLy=?  WHERE MaVe='" +mave + "' ";
      
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }
    
    public static void DelAllVeBay(String machuyenbay) throws SQLException, ParseException {
        String sqlChange = "UPDATE VeBay SET XuLy=?  WHERE MaChuyenBay='" +machuyenbay + "' ";
      
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }

    public static void UpdateVeBay(VeBayDTO NV) throws SQLException, ParseException {
        String sqlChange = "UPDATE VeBay SET MaKhachHang=?, MaNhanVien=?, MaChuyenBay=?,  Giave=?, MaGhe=?, DoiGhe=?  WHERE MaVe='" + NV.getMaVe() + "' ";
                
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setString(1, NV.getMaKhachHang());
        statement.setString(2, NV.getMaNhanVien());
        statement.setString(3, NV.getMaChuyenBay());
        statement.setLong(4, NV.getGiaVe());
        statement.setString(5, NV.getMaghe());
        statement.setInt(6, NV.getDoiGhe());
        statement.executeUpdate();
        cons.close();
    }
    
    public static void DoiGhe(String mave, String maghe) throws SQLException, ParseException {
        String sqlChange = "UPDATE VeBay SET MaGhe=?, DoiGhe=0  WHERE MaVe='" + mave + "' ";
                
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setString(1, maghe);
        statement.executeUpdate();
        cons.close();
    }
    
    public static VeBayDTO LoadVe(String maCTT) {
        VeBayDTO Nhanvien = new VeBayDTO();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from VeBay WHERE MaVe='" + maCTT + "'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Nhanvien.setMaVe(rs.getString("MaVe"));
                Nhanvien.setMaKhachHang(rs.getString("MaKhachHang"));
                Nhanvien.setMaNhanVien(rs.getString("MaNhanVien"));
                Nhanvien.setMaChuyenBay(rs.getString("MaChuyenBay"));
                Nhanvien.setMaghe(rs.getString("MaGhe"));
                Nhanvien.setXuLy(rs.getInt("XuLy"));
                Nhanvien.setGiaVe(rs.getInt("GiaVe"));
                Nhanvien.setDoiGhe(rs.getInt("DoiGhe"));
                
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Nhanvien;
    }
    
    public static ArrayList<VeBayDTO> LoadVeWithHD(String maCTT) {
        listVB = new ArrayList<>();
        
        try {
            
            java.sql.Connection cons = getConnection();
            String sql = "select * from VeBay vb,HoaDon hd"
                    + " WHERE vb.MaVe=hd.MaVe and"
                    + " hd.MaHoaDon='"+maCTT+"'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                VeBayDTO Nhanvien = new VeBayDTO();
                Nhanvien.setMaVe(rs.getString("MaVe"));
                Nhanvien.setMaKhachHang(rs.getString("MaKhachHang"));
                Nhanvien.setMaNhanVien(rs.getString("MaNhanVien"));
                Nhanvien.setMaChuyenBay(rs.getString("MaChuyenBay"));
                Nhanvien.setMaghe(rs.getString("MaGhe"));
                Nhanvien.setXuLy(rs.getInt("XuLy"));
                Nhanvien.setGiaVe(rs.getInt("GiaVe"));
                Nhanvien.setDoiGhe(rs.getInt("DoiGhe"));
                listVB.add(Nhanvien);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listVB;
    }
    
    public static ArrayList<String> getCountLoai(ArrayList<Integer> listCount, String dateTuNgay, String dateDenNgay) {
        ArrayList<String> listLoai = new ArrayList<>();
        listCount.clear();
        try {
            java.sql.Connection conn = getConnection();
            String query = "select count(vb.MaVe) as count, g.LoaiGhe\n" +
"from VeBay vb, ChuyenBay cb, MayBay mb, Ghe g, HoaDon hd\n" +
"where vb.MaChuyenBay=cb.MaChuyenBay and\n" +
"cb.MaMayBay=mb.MaMayBay and\n" +
"mb.MaMayBay=g.MaMayBay and\n" +
"vb.MaGhe=g.MaGhe and\n" +
"hd.MaVe=vb.MaVe and\n" +
"vb.XuLy=1 and hd.NgayThanhToan >= '"+dateTuNgay+"' and hd.NgayThanhToan <= '"+dateDenNgay+"' group by g.LoaiGhe";

           Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String loaiP = rs.getString("LoaiGhe");
                int count = rs.getInt("count");
                listCount.add(count);
                listLoai.add(loaiP);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception ex) {
        }
        return listLoai;
    }
    
     public static ArrayList<String> getCountLoai(ArrayList<Integer> listCount) {
        ArrayList<String> listLoai = new ArrayList<>();
        listCount.clear();
        try {
            java.sql.Connection conn = getConnection();
            String query = "select count(vb.MaVe) as count, g.LoaiGhe\n" +
"from VeBay vb, ChuyenBay cb, MayBay mb, Ghe g, HoaDon hd\n" +
"where vb.MaChuyenBay=cb.MaChuyenBay and\n" +
"	cb.MaMayBay=mb.MaMayBay and\n" +
"	mb.MaMayBay=g.MaMayBay and\n" +
"	vb.MaGhe=g.MaGhe and\n" +
"	hd.MaVe=vb.MaVe and\n" +
"	vb.XuLy=1\n" +
"group by g.LoaiGhe";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String loaiP = rs.getString("LoaiGhe");
                int count = rs.getInt("count");
                listCount.add(count);
                listLoai.add(loaiP);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception ex) {
        }
        return listLoai;
    }
}
