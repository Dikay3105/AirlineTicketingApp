/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnection;
import DTO.ChuyenBayDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;

/**
 *
 * @author duyli
 */
public class ChuyenBayDAO {

    public static ArrayList<ChuyenBayDTO> listCB = new ArrayList<>();

    public static ArrayList<ChuyenBayDTO> LoadData() {
        ArrayList<ChuyenBayDTO> tmp = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from ChuyenBay";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChuyenBayDTO mb = new ChuyenBayDTO();
                mb.setMaChuyenBay(rs.getString("MaChuyenBay"));
                mb.setMaDuongBay(rs.getString("MaDuongBay"));
                mb.setMaMayBay(rs.getString("MaMayBay"));
                mb.setSLEco(rs.getInt("SLEco"));
                mb.setSLBus(rs.getInt("SLBus"));
                Time time = rs.getTime("GioBay");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                String timeString = sdf.format(time);
                //String timeString = time.toString();
                mb.setGioBay(timeString);

                Time time2 = rs.getTime("GioDelay");
                String timeString1 = sdf.format(time2);
                mb.setGioDelay(timeString1);

                Date date = rs.getDate("NgayDi");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                String dateString = sdf1.format(date);
                mb.setNgayDi(dateString);


                mb.setGate(rs.getString("Gate"));

                mb.setXuLy(rs.getInt("xuLy"));
                tmp.add(mb);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tmp;
    }

    public static ChuyenBayDTO LoadCB(String macb) {
        ChuyenBayDTO mb = new ChuyenBayDTO();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "select * from ChuyenBay where MaChuyenBay='" + macb + "'";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                mb.setMaChuyenBay(rs.getString("MaChuyenBay"));
                mb.setMaDuongBay(rs.getString("MaDuongBay"));
                mb.setMaMayBay(rs.getString("MaMayBay"));
                mb.setSLEco(rs.getInt("SLEco"));
                mb.setSLBus(rs.getInt("SLBus"));
                Time time = rs.getTime("GioBay");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                String timeString = sdf.format(time);
                //String timeString = time.toString();
                mb.setGioBay(timeString);

                Date date = rs.getDate("NgayDi");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                String dateString = sdf1.format(date);
                mb.setNgayDi(dateString);

                Time time2 = rs.getTime("GioDelay");
                String timeString1 = sdf.format(time2);
                mb.setGioDelay(timeString1);

                mb.setGate(rs.getString("Gate"));

                mb.setXuLy(rs.getInt("xuLy"));

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mb;
    }

    public static void DelChuyenBay(String maChuyenBay) throws SQLException, ParseException {
        String sqlChange = "UPDATE ChuyenBay SET xuLy=?  WHERE MaChuyenBay='" + maChuyenBay + "'";

        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);
        statement.setInt(1, 0);
        statement.executeUpdate();
        cons.close();
    }

    public void loaddelay() throws SQLException, ParseException {
        ArrayList<ChuyenBayDTO> tmpArrayList = LoadData();
        for (ChuyenBayDTO cbdto : tmpArrayList) {
            cbdto.setGioDelay(cbdto.getGioBay());
            UpdateChuyenBay(cbdto);
        }

    }

    public static void InsertChuyenBay(ChuyenBayDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO ChuyenBay (MaChuyenBay, MaDuongBay, MaMayBay, Giobay, NgayDi, GioDelay, Gate,XuLy, SLEco, SLBus) values (?,?,?,?,?,?,?,?,?,?)";
        statement = cons.prepareCall(sql);
        statement.setString(1, NV.getMaChuyenBay());
        statement.setString(2, NV.getMaDuongBay());
        statement.setString(3, NV.getMaMayBay());
        statement.setString(5, NV.getNgayDi());
        statement.setString(7, NV.getGate());
        statement.setInt(8, 1);
        statement.setInt(9, NV.getSLEco());
        statement.setInt(10, NV.getSLBus());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date = sdf.parse(NV.getGioBay());
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime());
        statement.setTimestamp(4, sqlTimestamp);

        date = sdf.parse(NV.getGioDelay());
        sqlTimestamp = new java.sql.Timestamp(date.getTime());
        statement.setTimestamp(6, sqlTimestamp);

        statement.execute();
        cons.close();
    }

    public static void UpdateChuyenBay(ChuyenBayDTO NV) throws SQLException, ParseException {
        String sqlChange = "UPDATE ChuyenBay SET MaMayBay=?, GioDelay=?, NgayDi=?, Gate=?, MaDuongBay=?, SLEco=?, SLBus=?"
                + "  WHERE MaChuyenBay='" + NV.getMaChuyenBay() + "'";

        java.sql.Connection cons = getConnection();
        PreparedStatement statement = cons.prepareCall(sqlChange);

        statement.setString(1, NV.getMaMayBay());
        statement.setString(4, NV.getGate());
        statement.setString(5, NV.getMaDuongBay());
        statement.setInt(6, NV.getSLEco());
        statement.setInt(7, NV.getSLBus());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        java.util.Date date = sdf.parse(NV.getGioBay());
//        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime());
//        statement.setTimestamp(2, sqlTimestamp);

        Date date2 = sdf.parse(NV.getGioDelay());
        java.sql.Timestamp sqlTimestamp2 = new java.sql.Timestamp(date2.getTime());
        statement.setTimestamp(2, sqlTimestamp2);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date3 = sdf1.parse(NV.getNgayDi());
        java.sql.Date sqlDate = new java.sql.Date(date3.getTime());
        statement.setDate(3, sqlDate);

        statement.executeUpdate();
        cons.close();
    }

    public static ArrayList<ChuyenBayDTO> LoadCBTheoDB(String noidi, String noiden, String ngaydi, ArrayList<String> tgd, String hangbay) {
        String tmpString = "";
        if (hangbay.equals("Vietjet Air")) {
            tmpString = "VJ";
        } else if (hangbay.equals("Vietnam Airlines")) {
            tmpString = "VN";
        } else if (hangbay.equals("Bamboo")) {
            tmpString = "QH";
        } else if (hangbay.equals("Jetstar Pacific")) {
            tmpString = "BL";
        }

        ArrayList<ChuyenBayDTO> abc = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "SELECT cb.MaChuyenBay, cb.MaDuongBay, cb.Gate, cb.GioBay, cb.GioDelay, cb.MaMayBay, cb.NgayDi, cb.xuLy, cb.SLEco, cb.SLBus, DATEADD(SECOND, (DATEPART(hour, ThoiGianBayUocTinh) * 3600 + DATEPART(minute, ThoiGianBayUocTinh) * 60 + DATEPART(second, ThoiGianBayUocTinh)), GioDelay) AS ThoiGianDen\n"
                    + "FROM ChuyenBay cb, DuongBay db\n"
                    + "WHERE cb.MaDuongBay = db.MaDuongBay\n"
                    + "AND db.NoiDen = N'" + noiden + "'\n"
                    + "AND db.NoiDi = N'" + noidi + "'\n"
                    + "AND cb.NgayDi = '" + ngaydi + "'\n"
                    + "AND cb.MaChuyenBay LIKE '" + tmpString + "%' "
                    + "AND CONVERT(DATETIME, Cast(cb.NgayDi as DATETIME) + Cast(cb.GioDelay as DATETIME)) > CONVERT(DATETIME, GETDATE())";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChuyenBayDTO mb = new ChuyenBayDTO();

                mb.setMaChuyenBay(rs.getString("MaChuyenBay"));
                mb.setMaDuongBay(rs.getString("MaDuongBay"));
                mb.setMaMayBay(rs.getString("MaMayBay"));
                mb.setSLEco(rs.getInt("SLEco"));
                mb.setSLBus(rs.getInt("SLBus"));
                Time time = rs.getTime("GioBay");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                String timeString = sdf.format(time);
                //String timeString = time.toString();
                mb.setGioBay(timeString);

                time = rs.getTime("ThoiGianDen");
                timeString = sdf.format(time);
                String tmp = timeString;

                Date date = rs.getDate("NgayDi");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                String dateString = sdf1.format(date);
                mb.setNgayDi(dateString);

                Time time2 = rs.getTime("GioDelay");
                String timeString1 = sdf.format(time2);
                mb.setGioDelay(timeString1);

                mb.setGate(rs.getString("Gate"));

                mb.setXuLy(rs.getInt("xuLy"));
                abc.add(mb);
                tgd.add(tmp);

            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
        }
        return abc;
    }

    public static ArrayList<String> LoadGateNotAvailable(Object hour, Object minute, String ngay, String chuyenbay) {
        String time = hour + ":" + minute + ":00";
        ArrayList<String> abc = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "SELECT Distinct Gate\n"
                    + "FROM ChuyenBay\n"
                    + "WHERE NgayDi = '" + ngay + "'\n"
                    + "    and MaChuyenBay <> '" + chuyenbay + "' AND Gate NOT IN (\n"
                    + "        SELECT Gate\n"
                    + "        FROM ChuyenBay\n"
                    + "        WHERE NgayDi = '" + ngay + "'\n"
                    + "            AND GioDelay < CAST('" + time + "' AS TIME)\n"
                    + "			AND CAST('" + ngay + "' AS DATETIME) + CAST('" + time + "' AS DATETIME) > CAST('" + ngay + "' AS DATETIME) + CAST((DATEADD(HOUR, 1, CAST('" + time + "' AS TIME))) AS DATETIME)\n"
                    + "    );";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tmpString = (rs.getString("Gate"));
                abc.add(tmpString);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {

        }

        return abc;
    }

    public static ArrayList<String> LoadMayBayNotAvailable(Object hour, Object minute, String ngay, String chuyenbay) {
        String time = hour + ":" + minute + ":00";
        ArrayList<String> abc = new ArrayList<>();
        try {
            java.sql.Connection cons = getConnection();
            String sql = "SELECT Distinct MaMayBay\n"
                    + "FROM ChuyenBay\n"
                    + "WHERE NgayDi = '" + ngay + "'\n"
                    + "    and MaChuyenBay <> '" + chuyenbay + "' AND MaMayBay NOT IN (\n"
                    + "        SELECT MaMayBay\n"
                    + "        FROM ChuyenBay\n"
                    + "        WHERE NgayDi = '" + ngay + "'\n"
                    + "            AND GioDelay < CAST('" + time + "' AS TIME)\n"
                    + "			AND CAST('" + ngay + "' AS DATETIME) + CAST('" + time + "' AS DATETIME) > CAST('" + ngay + "' AS DATETIME) + CAST((DATEADD(HOUR, 1, CAST('" + time + "' AS TIME))) AS DATETIME)\n"
                    + "    );";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tmpString = (rs.getString("MaMayBay"));
                abc.add(tmpString);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {

        }

        return abc;
    }

    

}
