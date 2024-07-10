package DTO;


import java.awt.List;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;

public class GiaChuyenBayDTO {

    private String diemDi;
    private String diemDe;
    private long gia ;

    public GiaChuyenBayDTO() {
    }

    public GiaChuyenBayDTO(String diemDi, String diemDe, long gia) {
        this.diemDi = diemDi;
        this.diemDe = diemDe;
        this.gia = gia;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDe() {
        return diemDe;
    }

    public void setDiemDe(String diemDe) {
        this.diemDe = diemDe;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
}