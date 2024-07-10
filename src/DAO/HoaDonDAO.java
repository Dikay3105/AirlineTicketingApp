package DAO;

import BUS.DichVuBUS;
import BUS.HoaDonBUS;
import BUS.SuDungDichVuBUS;
import BUS.VeBayBUS;
import static DAO.DBConnect.getConnection;

import DTO.DichVuDTO;
import DTO.HoaDonDTO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class HoaDonDAO {

    public static ArrayList<HoaDonDTO> getListHoaDon() {
        ArrayList<HoaDonDTO> listHD = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select * from HoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString("MaHoaDon"));
                hd.setMaVe(rs.getString("MaVe"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String date = sdf.format(rs.getDate("NgayThanhToan"));
                hd.setNgayThanhToan(date);
                hd.setTienVe(rs.getInt("TienVe"));
                hd.setTienDichVu(rs.getInt("TienDichVu"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setGiamGia(rs.getInt("GiamGia"));
                hd.setMaNV(rs.getString("MaNhanVien"));
                hd.setMaKH(rs.getString("MaKhachHang"));
                hd.setXuLy(rs.getInt("xuLy"));
                listHD.add(hd);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return listHD;
    }
    
    public static ArrayList<HoaDonDTO> getListHoaDon2() {
        ArrayList<HoaDonDTO> listHD = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "select distinct MaHoaDon, sum(TienVe) as TienVe, sum(TienDichVu) as TienDichVu, sum(TongTien) as TongTien, sum(GiamGia) as GiamGia\n" +
"from HoaDon\n" +
"group by MaHoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString("MaHoaDon"))    ;
                hd.setTienVe(rs.getInt("TienVe"));
                hd.setTienDichVu(rs.getInt("TienDichVu"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setGiamGia(rs.getInt("GiamGia"));
                listHD.add(hd);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return listHD;
    }
    
    public static ArrayList<HoaDonDTO> getListHoaDon3() {
        ArrayList<HoaDonDTO> listHD = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "select distinct MaHoaDon, MaNhanVien, "
                    + "MaKhachHang, NgayThanhToan, xuLy\n" +
                    "from HoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString("MaHoaDon"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String date = sdf.format(rs.getDate("NgayThanhToan"));
                hd.setNgayThanhToan(date);
                hd.setMaNV(rs.getString("MaNhanVien"));
                hd.setMaKH(rs.getString("MaKhachHang"));
                hd.setXuLy(rs.getInt("xuLy"));
                listHD.add(hd);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return listHD;
    }

    public static void InsertHoaDon(HoaDonDTO NV) throws SQLException, ParseException {
        java.sql.Connection cons = getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO HoaDon (MaHoaDon, TienVe, TienDichVu, TongTien, NgayThanhToan, MaVe, GiamGia, MaNhanVien, xuLy, MaKhachHang) values (?,?,?,?,?,?,?,?,?,?)";
        statement = cons.prepareCall(sql);
        statement.setString(1, NV.getMaHD());
        statement.setInt(2, NV.getTienVe());
        statement.setInt(3, NV.getTienDichVu());
        statement.setInt(4, NV.getTongTien());
        statement.setString(6, NV.getMaVe());
        statement.setInt(7, NV.getGiamGia());
        statement.setString(8, NV.getMaNV());
        statement.setString(10, NV.getMaKH());
        statement.setInt(9, NV.getXuLy());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(NV.getNgayThanhToan());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        statement.setDate(5, sqlDate);

        statement.execute();
        cons.close();
    }

    public static ArrayList<HoaDonDTO> getListHD() {
        ArrayList<HoaDonDTO> listHD = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select * from HoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString("MaHoaDon"));
                hd.setMaVe(rs.getString("MaVe"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String date = sdf.format(rs.getDate("NgayThanhToan"));
                hd.setNgayThanhToan(date);
                hd.setTienVe(rs.getInt("TienVe"));
                hd.setTienDichVu(rs.getInt("TienDichVu"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setGiamGia(rs.getInt("GiamGia"));
                hd.setMaNV(rs.getString("MaNhanVien"));
                hd.setMaKH(rs.getString("MaKhachHang"));
                hd.setXuLy(rs.getInt("xuLy"));
                listHD.add(hd);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return listHD;
    }

    public static int tienPhong(int month) {
        int money = 0;
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select count(TienVe) from HoaDon where month(NgayThanhToan) = " + month;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                money = rs.getInt("count(TienVe)");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception ex) {
        }
        return money;
    }

    public static ArrayList<Integer> getListYear() {
        ArrayList<Integer> listInt = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "select distinct year(NgayThanhToan) as year from HoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int i = rs.getInt("year");
                listInt.add(i);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return listInt;
    }

    public static String getMaNV(String maHD) {
        String maNV = "";
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select MaNhanVien from HoaDon where MaHoaDon = '" + maHD + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                maNV = rs.getString("MaNhanVien");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return maNV;
    }

    public static HoaDonDTO getHoaDon(String maCTT) {
        HoaDonDTO x = new HoaDonDTO();
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select * from HoaDon where MaVe = '" + maCTT + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                x.setMaHD(rs.getString("MaHoaDon"));
                x.setTienVe(rs.getInt("TienVe"));
                x.setTienDichVu(rs.getInt("TienDichVu"));
                x.setTongTien(rs.getInt("TongTien"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                x.setNgayThanhToan(sdf.format(rs.getDate("NgayThanhToan")));
                x.setMaVe(rs.getString("MaVe"));
                x.setGiamGia(rs.getInt("GiamGia"));
                x.setMaNV(rs.getString("MaNhanVien"));
                x.setMaKH(rs.getString("MaKhachHang"));
                x.setXuLy(rs.getInt("xuLy"));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return x;
    }
    
    
    public static HoaDonDTO getHD(String maCTT) {
        HoaDonDTO x = new HoaDonDTO();
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select * from HoaDon where MaHoaDon = '" + maCTT + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                x.setMaHD(rs.getString("MaHoaDon"));
                x.setTienVe(rs.getInt("TienVe"));
                x.setTienDichVu(rs.getInt("TienDichVu"));
                x.setTongTien(rs.getInt("TongTien"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                x.setNgayThanhToan(sdf.format(rs.getDate("NgayThanhToan")));
                x.setMaVe(rs.getString("MaVe"));
                x.setGiamGia(rs.getInt("GiamGia"));
                x.setMaNV(rs.getString("MaNhanVien"));
                x.setMaKH(rs.getString("MaKhachHang"));
                x.setXuLy(rs.getInt("xuLy"));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return x;
    }

    //Ham dung de tinh tong tien phong
    public static int tienPhong() {
        int money = 0;
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select sum(TienVe) as tong from HoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                money = rs.getInt("tong");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception ex) {
        }
        return money;
    }
    //

    //Ham dung de tinh tong tien dich vu
    public static int tienDichVu() {
        int money = 0;
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select sum(TienDichVu) as tong from HoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                money = rs.getInt("tong");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception ex) {
        }
        return money;
    }
    //

    //Ham dung de tinh tong tien
    public static int tongTien() {
        int money = 0;
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select sum(TongTien) as tong from HoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                money = rs.getInt("tong");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception ex) {
        }
        return money;
    }
    //

    //Ham dung de lay nam add vao ComboBox
    public static ArrayList<Integer> getListYear_1() {
        ArrayList<Integer> listNum = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "SELECT DISTINCT YEAR(NgayThanhToan) as num FROM HoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            try {
                while (rs.next()) {
                    int i = rs.getInt("num");
                    listNum.add(i);
                }
            } catch (Exception e) {
            }
            rs.close();
        } catch (Exception e) {
        }
        return listNum;
    }
    //

    //Ham dung de add du lieu cho bieu do cot
    public static ArrayList<Integer> getTienNam(ArrayList<Integer> tienPh, ArrayList<Integer> tienDV, ArrayList<Integer> listTien, int year) {
        ArrayList<Integer> listThang = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select sum(TienVe) as tp, sum(TienDichVu) as tdv, sum(TongTien) as tt, month(NgayThanhToan) as month from HoaDon where year(NgayThanhToan) = " + year + " group by month(NgayThanhToan)";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int tienP = rs.getInt("tp");
                int tienD = rs.getInt("tdv");
                int tong = rs.getInt("tt");
                int thang = rs.getInt("month");
                tienPh.add(tienP);
                tienDV.add(tienD);
                listTien.add(tong);
                listThang.add(thang);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return listThang;
    }
    //

    //Ham dung de add du lieu cho bieu do duong
    public static ArrayList<Integer> getTienThang(ArrayList<Integer> tienPh, ArrayList<Integer> tienDV, int month, int year) {
        ArrayList<Integer> listNgay = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "Select TienVe, TienDichVu, day(NgayThanhToan) as ngay from HoaDon where month(NgayThanhToan) = " + month + " and year(NgayThanhToan) = " + year;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int tienP = rs.getInt("TienVe");
                int tienD = rs.getInt("TienDichVu");
                int ngay = rs.getInt("ngay");
                tienPh.add(tienP);
                tienDV.add(tienD);
                listNgay.add(ngay);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return listNgay;
    }
    //
    
//    public static void main(String[] args) throws SQLException, ParseException {
//        ArrayList<VeBayDTO> vblist=VeBayBUS.load();
//        ArrayList<SuDungDichVuDTO> sddv=new ArrayList<>();
//        ArrayList<DichVuDTO> dv=DichVuBUS.getListDichVu();
//        int tiendv=0;
//        int count=1;
//        for(VeBayDTO vbdto: vblist) {
//            sddv=SuDungDichVuBUS.loadmv(vbdto.getMaVe());
//            for(SuDungDichVuDTO sddvdto:sddv) {
//                for(DichVuDTO dvdto:dv) {
//                    if(dvdto.getMaDV().equals(sddvdto.getMaDV()))
//                        tiendv+=dvdto.getGiaDV()*sddvdto.getSoLuong();
//                }
//            }
//            HoaDonDTO hddto=new HoaDonDTO();
//            hddto.setMaHD("HD"+count);
//            hddto.setMaVe(vbdto.getMaVe());
//            hddto.setGiamGia(0);
//            hddto.setMaKH(vbdto.getMaKhachHang());
//            hddto.setMaNV(vbdto.getMaNhanVien());
//            hddto.setNgayThanhToan("2023-10-15");
//            hddto.setTienDichVu(tiendv);
//            hddto.setTienVe((int) vbdto.getGiaVe());
//            hddto.setXuLy(1);
//            hddto.setTongTien((int) vbdto.getGiaVe()+tiendv);
//            HoaDonBUS.insertHoaDon(hddto);
//            count++;tiendv=0;sddv=new ArrayList<>();
//        }
//    ArrayList<HoaDonDTO> vblist=HoaDonBUS.getListHD();
//        System.out.println(vblist.get(0).getMaHD());
//
//    }
}
