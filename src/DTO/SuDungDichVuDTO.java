package DTO;

public class SuDungDichVuDTO {

    private String maVe;
    private String maDV;
    private int soLuong;
    private int donGia;
    private int xuLy;

    public SuDungDichVuDTO() {
    }

    public SuDungDichVuDTO(String maVe, String maDV, int soLuong, int donGia, int xuLy) {
        this.maVe = maVe;
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.xuLy = xuLy;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }


    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

}
