/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author huhuh
 */
public class ChuyenBayDTO {
    private String maChuyenBay;
    private String maDuongBay;
    private String maMayBay;
    private String gioBay;
    private String ngayDi;
    private String gioDelay;
    private String gate;
    private int xuLy;
    private int SLEco,SLBus;

    public ChuyenBayDTO() {
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

    public ChuyenBayDTO(String maChuyenBay, String maDuongBay, String maMayBay, String gioBay, String ngayDi, String gioDelay, String gate, int xuLy, int SLEco, int SLBus) {
        this.maChuyenBay = maChuyenBay;
        this.maDuongBay = maDuongBay;
        this.maMayBay = maMayBay;
        this.gioBay = gioBay;
        this.ngayDi = ngayDi;
        this.gioDelay = gioDelay;
        this.gate = gate;
        this.xuLy = xuLy;
        this.SLEco = SLEco;
        this.SLBus = SLBus;
    }

    public int getSLEco() {
        return SLEco;
    }

    public void setSLEco(int SLEco) {
        this.SLEco = SLEco;
    }

    public int getSLBus() {
        return SLBus;
    }

    public void setSLBus(int SLBus) {
        this.SLBus = SLBus;
    }

    

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getMaDuongBay() {
        return maDuongBay;
    }

    public void setMaDuongBay(String maDuongBay) {
        this.maDuongBay = maDuongBay;
    }

    public String getMaMayBay() {
        return maMayBay;
    }

    public void setMaMayBay(String maMayBay) {
        this.maMayBay = maMayBay;
    }

    public String getGioBay() {
        return gioBay;
    }

    public void setGioBay(String gioBay) {
        this.gioBay = gioBay;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public String getGioDelay() {
        return gioDelay;
    }

    public void setGioDelay(String gioDelay) {
        this.gioDelay = gioDelay;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }
    
    
    
}
