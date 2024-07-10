package DTO;

public class NhanVienDTO {
    private String maNV;
    private String mKNV;
    private String tenNV;
    private int gioiTinh;
    private String ngaySinhString;
    private String chucVu;
    private String Email;
    private int xuLy;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String maNV, String mKNV, String tenNV, int gioiTinh, String ngaySinhString, String chucVu,String Email, int xuLy) {
        this.maNV = maNV;
        this.mKNV = mKNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.ngaySinhString = ngaySinhString;
        this.chucVu = chucVu;
        this.Email =Email;
        this.xuLy = xuLy;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getmKNV() {
        return mKNV;
    }

    public void setmKNV(String mKNV) {
        this.mKNV = mKNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinhString() {
        return ngaySinhString;
    }

    public void setNgaySinhString(String ngaySinhString) {
        this.ngaySinhString = ngaySinhString;
    }
/*
    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
*/
    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String ChucVu) {
        this.chucVu = ChucVu;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }
    
}
