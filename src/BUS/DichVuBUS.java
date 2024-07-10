package BUS;

import DTO.DichVuDTO;
import DAO.DichVuDAO;
import java.util.ArrayList;

public class DichVuBUS {
    public static String pathExcel="";
    public static ArrayList<DichVuDTO> getListDichVu() {
        ArrayList<DichVuDTO> listDichVu = new ArrayList<>();
        for (DichVuDTO dvDTO : DichVuDAO.getListDichVu()) {
            if (dvDTO.getXuLy() == 1) {
                listDichVu.add(dvDTO);
            }
        }
        return listDichVu;
    }
    public static boolean insertDV(DichVuDTO dvDTO) {
        if(DichVuDAO.checkMaDV(dvDTO.getMaDV())) {
            return false;
        }
        else {
            if(DichVuDAO.insertDV(dvDTO)) {
                return true;
            }
        }
        return false;
    }
    public static boolean updateDV(DichVuDTO dvDTO) {
        if(DichVuDAO.checkMaDV(dvDTO.getMaDV())) {
            return DichVuDAO.updateDV(dvDTO);
        }
        return false;
    }
    public static boolean deleteDV(String maDV) {
        if(DichVuDAO.checkMaDV(maDV)) {
            return DichVuDAO.deleteDV(maDV);
        }
        return false;
    }
    public static ArrayList<DichVuDTO> getListDV() {
        return DichVuDAO.getListDichVu();
    }
    
    public static String xuatExcel(String path) {
        BackUpData bk = new BackUpData();
        String message = "";
        try {
            bk.backup_DichVu(path);
            message += "Xuất file thành công";
            pathExcel = path;
        } catch (Exception ex) {
            message += "Xuất file không thành công";
        }
        return message;
    }
}
