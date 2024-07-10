/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author huhuh
 */
public class MayBayDTO {
    private String maMayBay;
    private String hangBay;
    private String kichThuoc;
    private int xuLy;
    private String cautrucBus;
    private String cautrucEco;
    private int SLeco;
    private int SLbus;
    
    
    public MayBayDTO() {
    }

    public MayBayDTO(String maMayBay, String hangBay, String kichThuoc, int xuLy, String cautrucBus, String cautrucEco, int SLeco, int SLbus) {
        this.maMayBay = maMayBay;
        this.hangBay = hangBay;
        this.kichThuoc = kichThuoc;
        this.xuLy = xuLy;
        this.cautrucBus = cautrucBus;
        this.cautrucEco = cautrucEco;
        this.SLeco = SLeco;
        this.SLbus = SLbus;
    }

    
    public String getCautrucBus() {
        return cautrucBus;
    }

    public void setCautrucBus(String cautrucBus) {
        this.cautrucBus = cautrucBus;
    }

    public String getCautrucEco() {
        return cautrucEco;
    }

    public void setCautrucEco(String cautrucEco) {
        this.cautrucEco = cautrucEco;
    }

    

    

    public int getSLeco() {
        return SLeco;
    }

    public void setSLeco(int SLeco) {
        this.SLeco = SLeco;
    }

    public int getSLbus() {
        return SLbus;
    }

    public void setSLbus(int SLbus) {
        this.SLbus = SLbus;
    }

    

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

    
    
    public String getMaMayBay() {
        return maMayBay;
    }

    public void setMaMayBay(String maMayBay) {
        this.maMayBay = maMayBay;
    }


    public String getHangBay() {
        return hangBay;
    }

    public void setHangBay(String hangBay) {
        this.hangBay = hangBay;
    }


    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }
    
    
}
