package DTO;

public class KhachHangDTO {

    private String maKH;
    private String tenKH;
    private String cccd;
    private int gioiTinh;
    private String sdt;
    private int xuLy;
    private String mail;
    private String ngaySinh;

    public KhachHangDTO() {
    }

    public KhachHangDTO(String maKH, String tenKH, String cccd, int gioiTinh, String sdt, int xuLy, String mail, String ngaySinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.cccd = cccd;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.xuLy = xuLy;
        this.mail=mail;
        this.ngaySinh=ngaySinh;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }
}
