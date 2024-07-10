package DAO;

import static DAO.DBConnect.getConnection;
import DTO.DichVuDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DichVuDAO {

    public static ArrayList<DichVuDTO> getListDichVu() {
        ArrayList<DichVuDTO> listDichVu = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "select * from DichVu";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DichVuDTO dvDTO = new DichVuDTO();
                dvDTO.setMaDV(rs.getString("MaDichVu"));
                dvDTO.setTenDV(rs.getString("TenDichVu"));
                dvDTO.setTenLoaiDV(rs.getString("LoaiDichVu"));
                dvDTO.setGiaDV(rs.getInt("Gia"));
                dvDTO.setXuLy(rs.getInt("XuLy"));
                dvDTO.setSoLuong(rs.getInt("SoLuong"));
                listDichVu.add(dvDTO);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDichVu;
    }

    public static boolean insertDV(DichVuDTO dvDTO) {
        boolean check = false;
        try {
            java.sql.Connection conn = getConnection();
            String query = "insert into DichVu values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, dvDTO.getMaDV());
            ps.setString(2, dvDTO.getTenDV());
            ps.setString(3, dvDTO.getTenLoaiDV());
            ps.setInt(4, dvDTO.getGiaDV());
            ps.setInt(5, dvDTO.getSoLuong());
            ps.setInt(6, 1);
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public static boolean checkMaDV(String maDV) {
        boolean check = false;
        try {
            java.sql.Connection conn = getConnection();
            String query = "select * from DichVu where MaDichVu = '" + maDV + "'";
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

    public static boolean updateDV(DichVuDTO dvDTO) {
        boolean check = false;
        try {
            java.sql.Connection conn = getConnection();
            String query = "update DichVu set TenDichVu = ?, LoaiDichVu = ?, Gia = ?, SoLuong=? where MaDichVu = '" + dvDTO.getMaDV() + "'";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, dvDTO.getTenDV());
            ps.setString(2, dvDTO.getTenLoaiDV());
            ps.setInt(3, dvDTO.getGiaDV());
            ps.setInt(4, dvDTO.getSoLuong());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public static boolean deleteDV(String maDV) {
        boolean check = false;
        try {
            java.sql.Connection conn = getConnection();
            String query = "update DichVu set XuLy = 0 where MaDichVu = '"+maDV +"'";
            PreparedStatement ps = conn.prepareCall(query);
            if(ps.executeUpdate()>=1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
