package DAO;

import static DAO.DBConnect.getConnection;
import DTO.NhanVienDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NhanVienDAO {

    public static ArrayList<NhanVienDTO> NVList = new ArrayList<>();

    public static ArrayList<NhanVienDTO> LoadData() {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from NhanVien";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienDTO Nhanvien = new NhanVienDTO();

                Nhanvien.setMaNV(rs.getString("MaNhanVien").trim());
                Nhanvien.setTenNV(rs.getString("HoTen"));
                Nhanvien.setmKNV(rs.getString("MatKhau").trim());
                /*Nhanvien.setHeSoLuong(rs.getInt("heSoLuong"));*/
                Nhanvien.setNgaySinhString(rs.getDate("NgaySinh").toString());
                Nhanvien.setGioiTinh(rs.getInt("GioiTinh"));
                Nhanvien.setChucVu(rs.getString("ChucVu"));
                Nhanvien.setEmail(rs.getString("Mail").trim());
                Nhanvien.setXuLy(rs.getInt("XuLy"));

                list.add(Nhanvien);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean InsertNhanVien(NhanVienDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO NhanVien (MaNhanVien, HoTen, MatKhau, GioiTinh, ChucVu, NgaySinh, Mail, XuLy) values (?,?,?,?,?,?,?,?)";
        try {
            statement = cons.prepareCall(sql);
            statement.setString(1, NV.getMaNV());
            statement.setString(2, NV.getTenNV());
            statement.setString(3, NV.getmKNV().trim());
            statement.setInt(4, NV.getGioiTinh());
            statement.setString(5, NV.getChucVu());
            /*statement.setInt(7, NV.getHeSoLuong());*/
            statement.setString(7, NV.getEmail().trim());
            statement.setInt(8, NV.getXuLy());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date date = sdf.parse(NV.getNgaySinhString());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            statement.setDate(6, sqlDate);
/*
            statement.execute();
            cons.close();*/
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean DelNhanVien(NhanVienDTO NV) throws SQLException, ParseException {
        try {
            String sqlChange = "UPDATE NhanVien SET xuLy=?  WHERE maNV='" + NV.getMaNV() + "'";
            java.sql.Connection cons = getConnection();
            PreparedStatement statement = cons.prepareCall(sqlChange);
            statement.setInt(1, 1);
            //        pst.executeUpdate();
            //        cons.close();
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean UpdateNhanVien(NhanVienDTO NV) throws SQLException, ParseException {
        String sqlChange = "UPDATE NhanVien SET HoTen=?, MatKhau=?, GioiTinh=?, ChucVu=?, NgaySinh=?, Mail=?, XuLy=?  WHERE MaNhanVien='" + NV.getMaNV() + "'";
        try {
            java.sql.Connection cons = getConnection();
            PreparedStatement statement = cons.prepareCall(sqlChange);
            statement.setString(1, NV.getTenNV());
            statement.setString(2, NV.getmKNV().trim());
            statement.setInt(3, NV.getGioiTinh());
            statement.setString(4, NV.getChucVu());
            /*statement.setInt(6, NV.getHeSoLuong());*/
            statement.setString(6, NV.getEmail().trim());
            statement.setInt(7, NV.getXuLy());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date date = sdf.parse(NV.getNgaySinhString());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            statement.setDate(5, sqlDate);
            /*statement.executeUpdate();
            cons.close();*/
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getTenNV(String maNV) {
        String name = "";
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select HoTen from NhanVien where MaNhanVien = '" + maNV + "' and xuLy = 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                name = rs.getString("HoTen");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return name;
    }

    public static NhanVienDTO getNV(String maNV) {
        NhanVienDTO Nhanvien = new NhanVienDTO();
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select from NhanVien where MaNhanVien = '" + maNV + "' and xuLy = 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Nhanvien.setMaNV(rs.getString("MaNhanVien"));
                Nhanvien.setTenNV(rs.getString("HoTen"));
                Nhanvien.setmKNV(rs.getString("MatKhau").trim());
                /*Nhanvien.setHeSoLuong(rs.getInt("heSoLuong"));*/
                Nhanvien.setNgaySinhString(rs.getDate("NgaySinh").toString());
                Nhanvien.setGioiTinh(rs.getInt("GioiTinh"));
                Nhanvien.setChucVu(rs.getString("ChucVu"));
                Nhanvien.setXuLy(rs.getInt("XuLy"));
                Nhanvien.setEmail(rs.getString("Mail").trim());
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return Nhanvien;
    }
    
    
}
