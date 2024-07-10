/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.datve;

import BUS.ChuyenBayBUS;
import BUS.DichVuBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.SuDungDichVuBUS;
import BUS.VeBayBUS;
import DTO.ChiTietSuDungDV;
import DTO.ChuyenBayDTO;
import DTO.DichVuDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.SuDungDichVuDTO;
import DTO.VeBayDTO;
import GUI.ThanhToanGUI.Cash;
import GUI.ThanhToanGUI.ThanhToan;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANH KHOA
 */
public class createHoaDon {
    private ArrayList<DichVuDTO> dvList;
    private ArrayList<ChuyenBayDTO> cbList;
    public createHoaDon() {
    }
    public void createHD() throws SQLException, ParseException{
        System.out.println(""+MenuDatVe.KHlList.size());
        for(KhachHangDTO x: MenuDatVe.KHlList){
            KhachHangBUS khBus = new KhachHangBUS();
            System.out.println(""+x.getMaKH()+"k");
            KhachHangDTO kh = new KhachHangDTO();
            try {
                if(khBus.loadKH(x.getMaKH()).size()==0){
                    System.out.println(""+x.getMaKH()+"k");
                    khBus.insertKhachHang(x);
                    
                     
                } else{
                    khBus.updateKhachHang(x);
                } 
                    
                
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(Cash.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
            }
        }
        int i=0;
        for(VeBayDTO y : ThanhToan.listVeBay){
            HoaDonBUS hdBus = new HoaDonBUS();
            VeBayBUS vbBus = new VeBayBUS();  
            try {
                vbBus.insertVeBay(y);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(Cash.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(ChiTietSuDungDV ctsddv : ThanhToan.listCT){
                if(ctsddv.getMaChuyenBaydi().equals(y.getMaChuyenBay()) && ctsddv.getMaKH().equals(y.getMaKhachHang())){
                        HoaDonDTO hd = new HoaDonDTO();
                        hd.setMaHD("HD"+hdBus.getSize());
                        hd.setMaVe(y.getMaVe());
                        hd.setTienVe((int) y.getGiaVe());
                        hd.setTienDichVu((int) ctsddv.getTienDVdi());
                        hd.setTongTien((int) ctsddv.getTongtiendi());

                        LocalDate now = LocalDate.now();
                        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        hd.setNgayThanhToan(formattedDate);

                        hd.setGiamGia(0);
                        hd.setXuLy(1);
                        hd.setMaKH(y.getMaKhachHang());
                        hd.setMaNV(y.getMaNhanVien());
                        hdBus.insertHoaDon(hd);
                }
                if(ctsddv.getMaChuyenBayve().equals(y.getMaChuyenBay()) && ctsddv.getMaKH().equals(y.getMaKhachHang())){
                        HoaDonDTO hd = new HoaDonDTO();
                        hd.setMaHD("HD"+hdBus.getSize());
                        hd.setMaVe(y.getMaVe());
                        hd.setTienVe((int) y.getGiaVe());
                        hd.setTienDichVu((int) ctsddv.getTienDVve());
                        hd.setTongTien((int) ctsddv.getTongtienve());

                        LocalDate now = LocalDate.now();
                        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        hd.setNgayThanhToan(formattedDate);

                        hd.setGiamGia(0);
                        hd.setXuLy(1);
                        hd.setMaKH(y.getMaKhachHang());
                        hd.setMaNV(y.getMaNhanVien());
                        hdBus.insertHoaDon(hd);
                }
            }
            
        }
        //dvList.clear();
        for(VeBayDTO y : ThanhToan.listVeBay){       
            for(ChiTietSuDungDV ctsddv : ThanhToan.listCT){
                SuDungDichVuBUS sddvBUS = new SuDungDichVuBUS();
                DichVuBUS dvBUS = new DichVuBUS();
                
                dvList =  dvBUS.getListDV();
                if(ctsddv.getMaChuyenBaydi().equals(y.getMaChuyenBay()) && !ctsddv.getMaDVdi().equals("no") && ctsddv.getMaKH().equals(y.getMaKhachHang())){
                    SuDungDichVuDTO sddvDTO = new SuDungDichVuDTO();
                    sddvDTO.setMaVe(y.getMaVe());
                    sddvDTO.setMaDV(ctsddv.getMaDVdi());
                    sddvDTO.setSoLuong(1);
                    sddvDTO.setXuLy(1);
                    for(DichVuDTO dv : dvList){
                        if(dv.getMaDV().equals(sddvDTO.getMaDV())){
                            dv.setSoLuong(dv.getSoLuong()-1);
                            System.out.println("Số lượng"+dv.getSoLuong());
                            dvBUS.updateDV(dv);
                            break;
                        }
                    }
                    sddvBUS.insertSDDV(sddvDTO);
                }
                if(ctsddv.getMaChuyenBayve().equals(y.getMaChuyenBay()) && !ctsddv.getMaDVve().equals("no") && ctsddv.getMaKH().equals(y.getMaKhachHang())){
                    SuDungDichVuDTO sddvDTO = new SuDungDichVuDTO();
                    sddvDTO.setMaVe(y.getMaVe());
                    sddvDTO.setMaDV(ctsddv.getMaDVve());
                    sddvDTO.setSoLuong(1);
                    sddvDTO.setXuLy(1);
                    for(DichVuDTO dv : dvList){
                        if(dv.getMaDV().equals(sddvDTO.getMaDV())){
                            dv.setSoLuong(dv.getSoLuong()-1);
                            System.out.println("Số lượng"+dv.getSoLuong());
                            dvBUS.updateDV(dv);
                            break;
                        }
                    }
                    sddvBUS.insertSDDV(sddvDTO);
                }
            }    
        }
        
        int countEco;
        int countBus;
        ChuyenBayBUS cbBus = new ChuyenBayBUS();
        countEco = MenuDatVe.MaGheList.size();
        if(MenuDatVe.MaGheList.isEmpty()){
           countBus = MenuDatVe.MaGheListVe.size();
           System.out.println("Bus:   "+countBus);
        }
        for(VeBayDTO y : ThanhToan.listVeBay){
                for(ChiTietSuDungDV ctsddv : ThanhToan.listCT){
                    if(y.getMaChuyenBay().equals(ctsddv.getMaChuyenBaydi()) && MenuDatVe.hangghe1C.equals("Economy")){
                            ChuyenBayDTO cbdto = new ChuyenBayDTO();
                            cbdto= cbBus.loadCB(y.getMaChuyenBay());
                            cbdto.setSLEco(cbdto.getSLEco()-1);  
                            System.out.println("1c ECO   "+cbdto.getSLEco());
                            cbBus.updateChuyenBay(cbdto);
                            break;
                    }
                    else if(y.getMaChuyenBay().equals(ctsddv.getMaChuyenBaydi()) && MenuDatVe.hangghe1C.equals("Bussiness")){
                        ChuyenBayDTO cbdto = new ChuyenBayDTO();
                        cbdto= cbBus.loadCB(y.getMaChuyenBay());
                        cbdto.setSLBus(cbdto.getSLBus()-1);  
                        System.out.println("1c BUS   "+cbdto.getSLBus());
                        cbBus.updateChuyenBay(cbdto);
                        break;
                        
                    }
                    if(y.getMaChuyenBay().equals(ctsddv.getMaChuyenBayve()) && MenuDatVe.hangghe2C.equals("Economy")){
                            ChuyenBayDTO cbdto = new ChuyenBayDTO();
                            cbdto= cbBus.loadCB(y.getMaChuyenBay());
                            cbdto.setSLEco(cbdto.getSLEco()-1);  
                            System.out.println("2c ECO   "+cbdto.getSLEco());
                            cbBus.updateChuyenBay(cbdto);
                            break;
                    }
                    else if(y.getMaChuyenBay().equals(ctsddv.getMaChuyenBayve()) && MenuDatVe.hangghe2C.equals("Bussiness")){
                        ChuyenBayDTO cbdto = new ChuyenBayDTO();
                        cbdto= cbBus.loadCB(y.getMaChuyenBay());
                        cbdto.setSLBus(cbdto.getSLBus()-1);  
                        System.out.println("2c BUS   "+cbdto.getSLBus());
                        cbBus.updateChuyenBay(cbdto);
                        break;
                        
                    }
                
                }
                    
        }  
    }        
}
