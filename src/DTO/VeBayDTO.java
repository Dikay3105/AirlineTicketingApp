/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author huhuh
 */
public class VeBayDTO {
    private String maVe;
    private String maKhachHang;
    private String maNhanVien;
    private String maChuyenBay;
    private long giaVe;
    private String maghe;
    private int XuLy;
    private int DoiGhe;

    public VeBayDTO() {
    }

    public VeBayDTO(String maVe, String maKhachHang, String maNhanVien, String maChuyenBay, long giaVe, String maghe, int XuLy, int DoiGhe) {
        this.maVe = maVe;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maChuyenBay = maChuyenBay;
        this.giaVe = giaVe;
        this.maghe = maghe;
        this.XuLy = XuLy;
        this.DoiGhe = DoiGhe;
    }


    public int getDoiGhe() {
        return DoiGhe;
    }

    public void setDoiGhe(int DoiGhe) {
        this.DoiGhe = DoiGhe;
    }

    

    public int getXuLy() {
        return XuLy;
    }

    public void setXuLy(int XuLy) {
        this.XuLy = XuLy;
    }
    
    

    public String getMaghe() {
        return maghe;
    }

    public void setMaghe(String maghe) {
        this.maghe = maghe;
    }
    
    

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public long getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(long giaVe) {
        this.giaVe = giaVe;
    }

   
    
}
