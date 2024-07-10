package BUS;
import DAO.ChuyenBayDAO;
import DAO.DichVuDAO;
import DAO.DuongBayDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DAO.SuDungDichVuDAO;
import DTO.ChuyenBayDTO;
import DTO.DichVuDTO;
import DTO.DuongBayDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.MayBayDTO;
import DTO.NhanVienDTO;
import DTO.SuDungDichVuDTO;
import DTO.VeBayDTO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ANH KHOA
 */
public class BackUpData {
    
//backup_NhanVien
    public void backup_NhanVien(String path) throws FileNotFoundException, IOException{
        
        ArrayList<NhanVienDTO> ListNhanVien = NhanVienDAO.LoadData();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thông Tin Nhân Viên");
            
        XSSFRow headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("STT");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Mã Nhân Viên");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Họ Tên");
        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("Chức Vụ");
        Cell headerCell5 = headerRow.createCell(4);
        headerCell5.setCellValue("Mail");
        Cell headerCell6 = headerRow.createCell(5);
        headerCell6.setCellValue("Xử Lý");
        Cell headerCell7 = headerRow.createCell(6);
        headerCell7.setCellValue("Giới tính");
         Cell headerCell8 = headerRow.createCell(7);
        headerCell8.setCellValue("Ngày Sinh");
        Cell headerCell9 = headerRow.createCell(8);
        headerCell9.setCellValue("Mật Khẩu");

        int rowNum = 1;
        for (NhanVienDTO nv : ListNhanVien) {
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(rowNum-1);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(nv.getMaNV());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(nv.getTenNV());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(nv.getChucVu());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(nv.getEmail());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(nv.getXuLy());
            Cell cell7 = row.createCell(6);
            if(nv.getGioiTinh()==1)
                cell7.setCellValue("Nam");
            else 
                cell7.setCellValue("Nữ");
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(nv.getNgaySinhString());
            Cell cell9 = row.createCell(8);
            cell9.setCellValue(nv.getmKNV());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
    }
    
    
    //backup_MayBay
    public void backup_MayBay(String path) throws FileNotFoundException, IOException{
        
        ArrayList<MayBayDTO> ListNhanVien = MayBayBUS.load();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thông Tin Nhân Viên");
            
        XSSFRow headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("STT");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Mã Máy Bay");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Kích Thước");
        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("Hãng Bay");
        Cell headerCell5 = headerRow.createCell(4);
        headerCell5.setCellValue("Xử Lý");
        Cell headerCell6 = headerRow.createCell(5);
        headerCell6.setCellValue("Cấu Trúc Bus");
        Cell headerCell7 = headerRow.createCell(6);
        headerCell7.setCellValue("Cấu Trúc Eco");
         Cell headerCell8 = headerRow.createCell(7);
        headerCell8.setCellValue("Số Lượng Bus");
        Cell headerCell9 = headerRow.createCell(8);
        headerCell9.setCellValue("Số Lượng Eco");

        int rowNum = 1;
        for (MayBayDTO nv : ListNhanVien) {
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(rowNum-1);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(nv.getMaMayBay());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(nv.getKichThuoc());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(nv.getHangBay());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(nv.getXuLy());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(nv.getCautrucBus());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(nv.getCautrucEco());
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(nv.getSLbus());
            Cell cell9 = row.createCell(8);
            cell9.setCellValue(nv.getSLeco());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
    }
    
    //backup_ChuyenBay
    public void backup_Chuyenbay(String path) throws FileNotFoundException, IOException{
        
        ArrayList<ChuyenBayDTO> ListNhanVien = ChuyenBayDAO.LoadData();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thông Tin Nhân Viên");
            
        XSSFRow headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("STT");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Mã Chuyến Bay");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Mã Đường Bay");
        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("Mã Máy Bay");
        Cell headerCell5 = headerRow.createCell(4);
        headerCell5.setCellValue("Giờ Bay");
        Cell headerCell6 = headerRow.createCell(5);
        headerCell6.setCellValue("Ngày Đi");
        Cell headerCell7 = headerRow.createCell(6);
        headerCell7.setCellValue("Giờ Delay");
         Cell headerCell8 = headerRow.createCell(7);
        headerCell8.setCellValue("Xử Lý");
        Cell headerCell9 = headerRow.createCell(8);
        headerCell9.setCellValue("Số Lượng Eco");
        Cell headerCell10 = headerRow.createCell(9);
        headerCell10.setCellValue("Số Lượng Bus");
        Cell headerCell11 = headerRow.createCell(10);
        headerCell11.setCellValue("gate");

        int rowNum = 1;
        for (ChuyenBayDTO nv : ListNhanVien) {
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(rowNum-1);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(nv.getMaChuyenBay());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(nv.getMaDuongBay());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(nv.getMaMayBay());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(nv.getGioBay());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(nv.getNgayDi());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(nv.getGioDelay());
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(nv.getXuLy());
            Cell cell9 = row.createCell(8);
            cell9.setCellValue(nv.getSLEco());
            Cell cell10 = row.createCell(9);
            cell10.setCellValue(nv.getSLBus());
            Cell cell11 = row.createCell(10);
            cell11.setCellValue(nv.getGate());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
    }
    
//backup_KhachHang    
    public void backup_KhachHang(String path) throws FileNotFoundException, IOException{
        
        ArrayList<KhachHangDTO> ListKhachHang = KhachHangDAO.LoadData();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thông Tin Khách Hàng");
            
        XSSFRow headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("STT");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Mã Khách Hàng");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Tên Khách Hàng");
        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("SĐT");
        Cell headerCell5 = headerRow.createCell(4);
        headerCell5.setCellValue("CCCD");
        Cell headerCell6 = headerRow.createCell(5);
        headerCell6.setCellValue("Giới Tính");
        Cell headerCell7 = headerRow.createCell(6);
        headerCell7.setCellValue("Mail");
        Cell headerCell8 = headerRow.createCell(7);
        headerCell8.setCellValue("Ngày Sinh");
        Cell headerCell9 = headerRow.createCell(8);
        headerCell9.setCellValue("Xử Lý");

        int rowNum = 1;
        for (KhachHangDTO kh : ListKhachHang) {
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(rowNum-1);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(kh.getMaKH());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(kh.getTenKH());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(kh.getSdt());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(kh.getCccd());
            Cell cell6 = row.createCell(5);
            if(kh.getGioiTinh()==1)
                cell6.setCellValue("Nam");
            else cell6.setCellValue("Nữ");
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(kh.getMail());
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(kh.getNgaySinh());
            Cell cell9 = row.createCell(8);
            cell9.setCellValue(kh.getXuLy());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
    }


//backup_DichVu    
    public void backup_DichVu(String path) throws FileNotFoundException, IOException{
        
        ArrayList<DichVuDTO> ListDichVu = DichVuDAO.getListDichVu();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thông Tin Dịch Vụ");
            
        XSSFRow headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("STT");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Mã Dịch Vụ");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Tên Dịch Vụ");
        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("Tên Loại Dịch Vụ");
        Cell headerCell5 = headerRow.createCell(4);
        headerCell5.setCellValue("Giá Dịch Vụ");
        Cell headerCell6 = headerRow.createCell(5);
        headerCell6.setCellValue("Số Lượng");
        Cell headerCell7 = headerRow.createCell(6);
        headerCell7.setCellValue("Xử Lý");

        int rowNum = 1;
        for (DichVuDTO dv : ListDichVu) {
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(rowNum-1);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(dv.getMaDV());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(dv.getTenDV());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(dv.getTenLoaiDV());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(dv.getGiaDV());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(dv.getSoLuong());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(dv.getXuLy());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
    }
    
    //backup_DichVu    
    public void backup_DuongBay(String path) throws FileNotFoundException, IOException{
        
        ArrayList<DuongBayDTO> ListDichVu = (ArrayList<DuongBayDTO>) DuongBayDAO.getALL();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thông Tin Đường Bay");
            
        XSSFRow headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("STT");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Mã Đường Bay");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Nơi Đi");
        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("Nơi Đến");
        Cell headerCell5 = headerRow.createCell(4);
        headerCell5.setCellValue("Thời Gian Ước Tính");
        Cell headerCell6 = headerRow.createCell(5);
        headerCell6.setCellValue("Xử Lý");

        int rowNum = 1;
        for (DuongBayDTO dv : ListDichVu) {
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(rowNum-1);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(dv.getMaDuongBay());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(dv.getNoiDi());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(dv.getNoiDen());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(dv.getThoiGianBay());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(dv.getXuLy());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
    }
  

//backup_VeBay
    public void backup_VeBay(String path) throws FileNotFoundException, IOException{
        
        ArrayList<VeBayDTO> ListChiTietThue = VeBayBUS.load();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Vé Bay");
            
        XSSFRow headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("STT");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Mã Vé");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Mã Nhân Viên");
        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("Mã Khách Hàng");
        Cell headerCell5 = headerRow.createCell(4);
        headerCell5.setCellValue("Mã Chuyến Bay");
        Cell headerCell6 = headerRow.createCell(5);
        headerCell6.setCellValue("Mã Ghế");
        Cell headerCell7 = headerRow.createCell(6);
        headerCell7.setCellValue("Xử Lý");
        Cell headerCell8 = headerRow.createCell(7);
        headerCell8.setCellValue("Đổi Ghế");
        Cell headerCell9 = headerRow.createCell(8);
        headerCell9.setCellValue("Giá Ghế");

        int rowNum = 1;
        for (VeBayDTO vb : ListChiTietThue) {
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(rowNum-1);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(vb.getMaVe());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(vb.getMaNhanVien());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(vb.getMaKhachHang());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(vb.getMaChuyenBay());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(vb.getMaghe());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(vb.getXuLy());
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(vb.getDoiGhe());
            Cell cell9 = row.createCell(8);
            cell9.setCellValue(vb.getGiaVe());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
    }    
//backup_HoaDon
    public void backup_HoaDon(String path) throws FileNotFoundException, IOException{
        
        ArrayList<HoaDonDTO> ListHoaDon= HoaDonDAO.getListHoaDon();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Danh Sách Hóa Đơn");
            
        XSSFRow headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("STT");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Mã Hóa Đơn");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Mã Vé");
        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("Tiền Vé");
        Cell headerCell5 = headerRow.createCell(4);
        headerCell5.setCellValue("Tiền Dịch Vụ");
        Cell headerCell6 = headerRow.createCell(5);
        headerCell6.setCellValue("Tổng Tiền");
        Cell headerCell7 = headerRow.createCell(6);
        headerCell7.setCellValue("Ngày Thanh Toán");
        Cell headerCell8 = headerRow.createCell(7);
        headerCell8.setCellValue("Giảm Giá");
        Cell headerCell9 = headerRow.createCell(8);
        headerCell9.setCellValue("Xử Lý");
        Cell headerCell10 = headerRow.createCell(9);
        headerCell10.setCellValue("Mã Khách Hàng");
        Cell headerCell11 = headerRow.createCell(9);
        headerCell11.setCellValue("Mã Nhân Viên");

        int rowNum = 1;
        for (HoaDonDTO hd : ListHoaDon) {
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(rowNum-1);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(hd.getMaHD());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(hd.getMaVe());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(hd.getTienVe());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(hd.getTienDichVu());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(hd.getTienVe()+hd.getTienDichVu());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(hd.getNgayThanhToan());
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(hd.getGiamGia());
            Cell cell9 = row.createCell(8);
            cell9.setCellValue(hd.getXuLy());
            Cell cell10 = row.createCell(9);
            cell10.setCellValue(hd.getMaKH());
            Cell cell11 = row.createCell(10);
            cell11.setCellValue(hd.getMaNV());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
    }        
}
