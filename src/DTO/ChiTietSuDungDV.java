/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ANH KHOA
 */
public class ChiTietSuDungDV {
    private String maKH, tenKH, maChuyenBaydi;
    private String maGhedi="no";
    private String maGheve="no";
    private String maChuyenBayve="no";
    private String maDVdi="no";
    private String maDVve="no";
    private long tienVedi=0, tienDVdi=0, tongtiendi;
    private long tienVeve=0, tienDVve=0, tongtienve;

    public ChiTietSuDungDV(String maKH, String maGhedi, String tenKH, String maChuyenBaydi, long tongtiendi, long tongtienve) {
        this.maKH = maKH;
        this.maGhedi = maGhedi;
        this.tenKH = tenKH;
        this.maChuyenBaydi = maChuyenBaydi;
        this.tongtiendi = tongtiendi;
        this.tongtienve = tongtienve;
    } 
    public ChiTietSuDungDV() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaGhedi() {
        return maGhedi;
    }

    public void setMaGhedi(String maGhedi) {
        this.maGhedi = maGhedi;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaChuyenBaydi() {
        return maChuyenBaydi;
    }

    public void setMaChuyenBaydi(String maChuyenBaydi) {
        this.maChuyenBaydi = maChuyenBaydi;
    }

    public String getMaGheve() {
        return maGheve;
    }

    public void setMaGheve(String maGheve) {
        this.maGheve = maGheve;
    }

    public String getMaChuyenBayve() {
        return maChuyenBayve;
    }

    public void setMaChuyenBayve(String maChuyenBayve) {
        this.maChuyenBayve = maChuyenBayve;
    }

    public String getMaDVdi() {
        return maDVdi;
    }

    public void setMaDVdi(String maDVdi) {
        this.maDVdi = maDVdi;
    }

    public String getMaDVve() {
        return maDVve;
    }

    public void setMaDVve(String maDVve) {
        this.maDVve = maDVve;
    }

    public long getTienVedi() {
        return tienVedi;
    }

    public void setTienVedi(long tienVedi) {
        this.tienVedi = tienVedi;
    }

    public long getTienDVdi() {
        return tienDVdi;
    }

    public void setTienDVdi(long tienDVdi) {
        this.tienDVdi = tienDVdi;
    }

    public long getTongtiendi() {
        return tongtiendi;
    }

    public void setTongtiendi(long tongtiendi) {
        this.tongtiendi = tongtiendi;
    }

    public long getTienVeve() {
        return tienVeve;
    }

    public void setTienVeve(long tienVeve) {
        this.tienVeve = tienVeve;
    }

    public long getTienDVve() {
        return tienDVve;
    }

    public void setTienDVve(long tienDVve) {
        this.tienDVve = tienDVve;
    }

    public long getTongtienve() {
        return tongtienve;
    }

    public void setTongtienve(long tongtienve) {
        this.tongtienve = tongtienve;
    }
    
    
}
