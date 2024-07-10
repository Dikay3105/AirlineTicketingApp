/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author huhuh
 */
public class GheChuyenBayDTO {
    private String maGhe;
    private String maChuyenBay;
    private int xuLy;
    private String maVe;

    public GheChuyenBayDTO() {
    }

    public GheChuyenBayDTO(String maGhe, String maChuyenBay, int xuLy, String maVe) {
        this.maGhe = maGhe;
        this.maChuyenBay = maChuyenBay;
        this.xuLy = xuLy;
        this.maVe=maVe;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }
    
    

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }
    
    
    
}
