/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnection;
import DTO.GheChuyenBayDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author duyli
 */
public class GheChuyenBayDAO {
    public static ArrayList<GheChuyenBayDTO> listGCB = new ArrayList<>();

    public static ArrayList<GheChuyenBayDTO> LoadData() {
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from GheChuyenBay";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GheChuyenBayDTO hd = new GheChuyenBayDTO();
                hd.setMaGhe(rs.getString("MaGhe"));       
                hd.setMaChuyenBay(rs.getString("MaChuyenBay"));
                hd.setXuLy(rs.getInt("XuLy"));
                hd.setMaVe(rs.getString("MaVe"));
                listGCB.add(hd);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listGCB;
    }

    public static void InsertGheChuyenBay(GheChuyenBayDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO GheChuyenBay values (?,?,?,?)";
        statement = cons.prepareCall(sql);
        statement.setString(1, NV.getMaGhe());
        statement.setString(2, NV.getMaChuyenBay());
        statement.setString(3, NV.getMaVe());
        statement.setInt(4, NV.getXuLy());
        
        statement.execute();
        cons.close();
    }

    public static void UpdateGheChuyenBay(GheChuyenBayDTO NV) throws SQLException, ParseException {
        String sqlChange = "UPDATE GheChuyenBay set MaVe=?  WHERE MaGhe='" + NV.getMaGhe()+ "' and MaChuyenBay='" + NV.getMaChuyenBay()+ "' ";
      
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setString(1, NV.getMaVe());
        statement.executeUpdate();
        cons.close();
    }
    public static void DelGheChuyenBay(String maGhe, String maChuyenBay) throws SQLException, ParseException {
        String sqlChange = "UPDATE DuongBay SET XuLy=?  WHERE MaGhe='"+maGhe+"' and MaChuyenBay='"+maChuyenBay+"'" ;
      
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }
}
