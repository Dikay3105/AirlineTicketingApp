/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author huhuh
 */
public class DuongBayDTO {
    private String maDuongBay;
    private String noiDi;
    private String noiDen;
    private String thoiGianBay;
    private int xuLy;
    private int noiNgoai;
    public DuongBayDTO() {
    }

    public DuongBayDTO(String maDuongBay, String noiDi, String noiDen, String thoiGianBay, int xuLy, int noiNgoai) {
        this.maDuongBay = maDuongBay;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.thoiGianBay = thoiGianBay;
        this.xuLy = xuLy;
        this.noiNgoai=noiNgoai;
    }

    public int getNoiNgoai() {
        return noiNgoai;
    }

    public void setNoiNgoai(int noiNgoai) {
        this.noiNgoai = noiNgoai;
    }
    
    

    public String getMaDuongBay() {
        return maDuongBay;
    }

    public void setMaDuongBay(String maDuongBay) {
        this.maDuongBay = maDuongBay;
    }

    public String getNoiDi() {
        return noiDi;
    }

    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public String getThoiGianBay() {
        return thoiGianBay;
    }

    public void setThoiGianBay(String thoiGianBay) {
        this.thoiGianBay = thoiGianBay;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }
    
    
}
