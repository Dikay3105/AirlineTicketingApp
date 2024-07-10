/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnection;
import DTO.GheDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author duyli
 */
public class GheDAO {

    public static ArrayList<GheDTO> listGhe = new ArrayList<>();

    public static ArrayList<GheDTO> LoadData() {
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from Ghe";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GheDTO hd = new GheDTO();
                hd.setMaGhe(rs.getString("MaGhe"));
                hd.setMaMayBay(rs.getString("MaMayBay"));
                hd.setLoaiGhe(rs.getString("LoaiGhe"));
                hd.setXuLy(rs.getInt("XuLy"));

                listGhe.add(hd);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listGhe;
    }

    public static GheDTO LoadGhe(String maghe, String mamaybay) {
        GheDTO hd = new GheDTO();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from Ghe where MaGhe='" + maghe + "' and MaMayBay='" + mamaybay + "'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                hd.setMaGhe(rs.getString("MaGhe"));
                hd.setLoaiGhe(rs.getString("LoaiGhe"));
                hd.setXuLy(rs.getInt("XuLy"));

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hd;
    }

    public static String checkGhe(String maghe, String machuyenbay) {
        String value = "";
        try {
            // Kết nối đến CSDL
            java.sql.Connection cons = getConnection();

            // Truy vấn SQL kiểm tra dữ liệu NULL
            String sql = "SELECT \n"
                    + "    CASE \n"
                    + "        WHEN EXISTS (\n"
                    + "            SELECT g.MaGhe\n"
                    + "            FROM Ghe g\n"
                    + "            JOIN VeBay vb ON g.MaGhe = vb.MaGhe\n"
                    + "            JOIN ChuyenBay cb ON vb.MaChuyenBay = cb.MaChuyenBay\n"
                    + "            WHERE g.MaGhe = '" + maghe + "'\n"
                    + "            AND cb.MaChuyenBay = '" + machuyenbay + "'\n"
                    + "        )\n"
                    + "        THEN 'true'\n"
                    + "        ELSE 'false'\n"
                    + "    END AS Result";
            PreparedStatement preparedStatement = cons.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Lấy giá trị từ cột your_column (cột đầu tiên)
                value = resultSet.getString("Result");
            }

            // Đóng kết nối
            resultSet.close();
            preparedStatement.close();
            cons.close();

            return value;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "-1";
    }


    public static void InsertGhe(GheDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO Ghe (MaGhe, MamayBay,LoaiGhe , XuLy) values (?,?,?,?)";
        statement = cons.prepareCall(sql);
        statement.setString(1, NV.getMaGhe());
        statement.setString(2, NV.getMaMayBay());
        statement.setString(3, NV.getLoaiGhe());
        statement.setInt(4, 1);

        statement.execute();
        cons.close();
    }

//    public static void UpdateGhe(GheDTO NV) throws SQLException, ParseException {
//        String sqlChange = "UPDATE Ghe SET XuLy=?  WHERE MaGhe='" + NV.getMaGhe()+ "' ";
//      
//        java.sql.Connection cons = getConnection();
//        PreparedStatement statement = cons.prepareCall(sqlChange);
//        statement.setString(1, NV.getMaMayBay());
//        statement.setString(2, NV.getLoaiGhe());
//        statement.executeUpdate();
//        cons.close();
//    }
    public static void DelGhe(String maGhe) throws SQLException, ParseException {
        String sqlChange = "UPDATE Ghe SET XuLy=?  WHERE MaGhe='" + maGhe + "' ";

        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }


    public static void DelAllGhe(String mamaybay) throws SQLException, ParseException {
        String sqlChange = "UPDATE Ghe SET XuLy=? WHERE MaMayBay='" + mamaybay + "' ";

        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }
    

}
