/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author huhuh
 */
public class GheDTO {
    private String maGhe;
    private String maMayBay;
    private String loaiGhe;
    private int xuLy;

    public GheDTO() {
    }

    public GheDTO(String maGhe, String maMayBay, String loaiGhe, int xuLy) {
        this.maGhe = maGhe;
        this.maMayBay = maMayBay;
        this.loaiGhe = loaiGhe;
        this.xuLy = xuLy;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public String getMaMayBay() {
        return maMayBay;
    }

    public void setMaMayBay(String maMayBay) {
        this.maMayBay = maMayBay;
    }

    public String getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(String loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }
    
    
}
