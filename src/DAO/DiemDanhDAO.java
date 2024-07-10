/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnection;
import DTO.DiemDanhDTO;
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
public class DiemDanhDAO {
    public static ArrayList<DiemDanhDTO> DDList = new ArrayList<>();

    public static ArrayList<DiemDanhDTO> LoadData() {
        DDList = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from DiemDanh";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
        //    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            while (rs.next()) {
                java.sql.Timestamp timestamp = rs.getTimestamp("NgayDiLam");
                Date date = new Date(timestamp.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                
                String formattedDate = formatter.format(date);
                
                DiemDanhDTO DD = new DiemDanhDTO();
                DD.setMaNV(rs.getString("MaNhanVien"));
                //String datetime = sdf.format(rs.getDate("ngayDiLam"));
                DD.setNgayDiLam(formattedDate);
                DDList.add(DD);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return DDList;
    }
    public static void InsertDiemDanh(DiemDanhDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO DiemDanh (NgayDiLam,MaNhanVien) values (?,?)";
        statement = cons.prepareCall(sql);
        statement.setString(2, NV.getMaNV());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        java.util.Date date = sdf.parse(NV.getNgayDiLam());
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime());
        statement.setTimestamp(1, sqlTimestamp);
        
        statement.execute();
        cons.close();
    }
}
