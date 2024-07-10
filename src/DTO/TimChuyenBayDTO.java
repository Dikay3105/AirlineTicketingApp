/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ANH KHOA
 */
public class TimChuyenBayDTO {
    private String noidi, noiden;
    private int lonhon12;
    private int tu2den12;
    private int nhohon2;
    private String ngaydi, ngayve;
    private String hangBaydi,hangBayve;
    public TimChuyenBayDTO() {
    }

    public TimChuyenBayDTO(String noidi, String noiden, int lonhon12, int tu2den12, int nhohon2, String ngaydi, String ngayve, String hangBaydi, String hangBayve) {
        this.noidi = noidi;
        this.noiden = noiden;
        this.lonhon12 = lonhon12;
        this.tu2den12 = tu2den12;
        this.nhohon2 = nhohon2;
        this.ngaydi = ngaydi;
        this.ngayve = ngayve;
        this.hangBaydi = hangBaydi;
        this.hangBayve = hangBayve;
    }
    

    public String getNoidi() {
        return noidi;
    }

    public void setNoidi(String noidi) {
        this.noidi = noidi;
    }

    public String getNoiden() {
        return noiden;
    }

    public void setNoiden(String noiden) {
        this.noiden = noiden;
    }

    public int getLonhon12() {
        return lonhon12;
    }

    public void setLonhon12(int lonhon12) {
        this.lonhon12 = lonhon12;
    }

    public int getTu2den12() {
        return tu2den12;
    }

    public void setTu2den12(int tu2den12) {
        this.tu2den12 = tu2den12;
    }

//    public int getNhohon2() {
//        return nhohon2;
//    }
//
//    public void setNhohon2(int nhohon2) {
//        this.nhohon2 = nhohon2;
//    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public String getNgayve() {
        return ngayve;
    }

    public void setNgayve(String ngayve) {
        this.ngayve = ngayve;
    }

    public int getNhohon2() {
        return nhohon2;
    }

    public void setNhohon2(int nhohon2) {
        this.nhohon2 = nhohon2;
    }

    public String getHangBaydi() {
        return hangBaydi;
    }

    public void setHangBaydi(String hangBaydi) {
        this.hangBaydi = hangBaydi;
    }

    public String getHangBayve() {
        return hangBayve;
    }

    public void setHangBayve(String hangBayve) {
        this.hangBayve = hangBayve;
    }

    
    

    
}
