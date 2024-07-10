package DTO;

public class HoaDonDTO {

    private String maHD;
    private String maVe;
    private int tienVe;
    private int tienDichVu;
    private int tongTien;
    private String ngayThanhToan;
    private int giamGia;
    private String maNV;
    private String maKH;
    private int xuLy;

    public HoaDonDTO() {
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public int getTienVe() {
        return tienVe;
    }

    public void setTienVe(int tienVe) {
        this.tienVe = tienVe;
    }

    public int getTienDichVu() {
        return tienDichVu;
    }

    public void setTienDichVu(int tienDichVu) {
        this.tienDichVu = tienDichVu;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

    public HoaDonDTO(String maHD, String maVe, int tienVe, int tienDichVu, int tongTien, String ngayThanhToan, int giamGia, String maNV, String maKH, int xuLy) {
        this.maHD = maHD;
        this.maVe = maVe;
        this.tienVe = tienVe;
        this.tienDichVu = tienDichVu;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
        this.giamGia = giamGia;
        this.maNV = maNV;
        this.maKH = maKH;
        this.xuLy = xuLy;
    }

    

}
