/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.VeBayDAO;
import DTO.VeBayDTO;
import GUI.PanelChuyenBay2;
import GUI.PanelVeBay;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author huhuh
 */
public class VeBayBUS {

    public static String pathExcel = "";

    public static ArrayList<VeBayDTO> load() {
        return VeBayDAO.LoadData();
    }

    public static ArrayList<VeBayDTO> loadActive() {
        return VeBayDAO.LoadDataActive();
    }

    public static ArrayList<VeBayDTO> LoadVeWithHD(String maCTT) {
        return VeBayDAO.LoadVeWithHD(maCTT);
    }

    public static void insertVeBay(VeBayDTO vbdto) throws SQLException, ParseException {
        VeBayDAO.InsertVeBay(vbdto);
    }

    public static void updateVeBay(VeBayDTO vbdto) throws SQLException, ParseException {
        VeBayDAO.UpdateVeBay(vbdto);
    }

    public static void DoiGhe(String mave, String maghe) throws SQLException, ParseException {
        VeBayDAO.DoiGhe(mave, maghe);
    }

    public static void delVeBay(String maVeBay) throws SQLException, ParseException {
        VeBayDAO.DelVeBay(maVeBay);
    }

    public static void delAllVeBay(String machuyenbay) throws SQLException, ParseException {
        VeBayDAO.DelAllVeBay(machuyenbay);
    }

    public static VeBayDTO loadVe(String maVeBay) throws SQLException, ParseException {
        return VeBayDAO.LoadVe(maVeBay);
    }

    public static String xuatExcel(String path) {
        BackUpData bk = new BackUpData();
        String message = "";
        try {
            bk.backup_VeBay(path);
            message += "Xuất file thành công";
            pathExcel = path;
        } catch (Exception ex) {
            message += "Xuất file không thành công";
        }
        return message;
    }

    public static void findXuLy(ArrayList<VeBayDTO> CBListVB, int xuly) {
        ArrayList<VeBayDTO> CBList = new ArrayList<>();
        for (int i = 0; i < CBListVB.size(); i++) {
            if (CBListVB.get(i).getXuLy() == xuly) {

                CBList.add(CBListVB.get(i));
            }
        }
        PanelVeBay.loadFind(PanelVeBay.getTbCTT(), CBList);
        PanelVeBay.findList = CBList;
    }

    public static ArrayList<VeBayDTO> findMaVe(ArrayList<VeBayDTO> CBListVB, String mave) {
        ArrayList<VeBayDTO> listTmp = new ArrayList<>();
        for (VeBayDTO x : CBListVB) {
            if (x.getMaVe().toLowerCase().contains(mave.toLowerCase())) {
                listTmp.add(x);
            }
        }
        if (listTmp.size() == 0) {
            PanelVeBay.loadTable(PanelVeBay.getTbCTT(), CBListVB);
            return listTmp;
        } else {
            PanelVeBay.loadFind(PanelVeBay.getTbCTT(), listTmp);
            return listTmp;
        }

    }
    
    public static ArrayList<VeBayDTO> findMaKh(ArrayList<VeBayDTO> CBListVB, String MaKH) {
        ArrayList<VeBayDTO> listTmp = new ArrayList<>();
        for (VeBayDTO x : CBListVB) {
            if (x.getMaKhachHang().toLowerCase().contains(MaKH.toLowerCase())) {
                listTmp.add(x);
            }
        }
        if (listTmp.size() == 0) {
            PanelVeBay.loadTable(PanelVeBay.getTbCTT(), CBListVB);
            return listTmp;
        } else {
            PanelVeBay.loadFind(PanelVeBay.getTbCTT(), listTmp);
            return listTmp;
        }

    }
    
    public static ArrayList<VeBayDTO> findMaNV(ArrayList<VeBayDTO> CBListVB, String MaKH) {
        ArrayList<VeBayDTO> listTmp = new ArrayList<>();
        for (VeBayDTO x : CBListVB) {
            if (x.getMaNhanVien().toLowerCase().contains(MaKH.toLowerCase())) {
                listTmp.add(x);
            }
        }
        if (listTmp.size() == 0) {
            PanelVeBay.loadTable(PanelVeBay.getTbCTT(), CBListVB);
            return listTmp;
        } else {
            PanelVeBay.loadFind(PanelVeBay.getTbCTT(), listTmp);
            return listTmp;
        }

    }
    
    public static ArrayList<VeBayDTO> findMaCb(ArrayList<VeBayDTO> CBListVB, String macb) {
        ArrayList<VeBayDTO> listTmp = new ArrayList<>();
        for (VeBayDTO x : CBListVB) {
            if (x.getMaChuyenBay().toLowerCase().contains(macb.toLowerCase())) {
                listTmp.add(x);
            }
        }
        if (listTmp.size() == 0) {
            PanelVeBay.loadTable(PanelVeBay.getTbCTT(), CBListVB);
            return listTmp;
        } else {
            PanelVeBay.loadFind(PanelVeBay.getTbCTT(), listTmp);
            return listTmp;
        }

    }
    
    public static ArrayList<VeBayDTO> findTenKh(ArrayList<VeBayDTO> CBListVB, String tenkh) {
        ArrayList<VeBayDTO> listTmp = new ArrayList<>();
        for (VeBayDTO x : CBListVB) {
            if ((PanelVeBay.TenKH(x.getMaKhachHang())).toLowerCase().contains(tenkh.toLowerCase())) {
                listTmp.add(x);
            }
        }
        if (listTmp.size() == 0) {
            PanelVeBay.loadTable(PanelVeBay.getTbCTT(), CBListVB);
            return listTmp;
        } else {
            PanelVeBay.loadFind(PanelVeBay.getTbCTT(), listTmp);
            return listTmp;
        }

    }

    public static ArrayList<String> getLoaiP_SL(ArrayList<Integer> listInt, String dateTuNgay, String dateDenNgay) {
        return VeBayDAO.getCountLoai(listInt, dateTuNgay, dateDenNgay);
    }

    //Ham add du lieu vao bieu do tron kh dk
    public static ArrayList<String> getLoaiP_SL(ArrayList<Integer> listInt) {
        return VeBayDAO.getCountLoai(listInt);
    }

}
