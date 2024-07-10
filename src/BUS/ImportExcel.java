/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChuyenBayDAO;
import DAO.DichVuDAO;
import DAO.DuongBayDAO;
import DAO.KhachHangDAO;
import DAO.MayBayDAO;
import DAO.NhanVienDAO;
import DTO.ChuyenBayDTO;
import DTO.DichVuDTO;
import DTO.DuongBayDTO;
import DTO.KhachHangDTO;
import DTO.MayBayDTO;
import DTO.NhanVienDTO;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author duyli
 */
public class ImportExcel {
    public void ImportExcel_DichVu(String path) {
        String[] expectedHeaders = {"STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Tên Loại Dịch Vụ", "Giá Dịch Vụ","Số Lượng", "Xử Lý"};
        try {
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            if (hasNullValue(sheet) == false) {
                if (checkHeader(sheet, expectedHeaders)) {
                    for (Row row : sheet) {
                        // Bỏ qua hàng đầu tiên vì nó chứa tiêu đề của bảng Excel
                        if (row.getRowNum() == 0) {
                            continue;
                        }
                        DichVuDTO nv = new DichVuDTO();
                        nv.setMaDV(row.getCell(1).getStringCellValue());
                        nv.setTenDV(row.getCell(2).getStringCellValue());
                        nv.setTenLoaiDV(row.getCell(3).getStringCellValue());
                        nv.setGiaDV((int) row.getCell(4).getNumericCellValue());
                         nv.setSoLuong((int) row.getCell(5).getNumericCellValue());
                        
                        nv.setXuLy((int) row.getCell(6).getNumericCellValue());
                       
//                      nv.setHeSoLuong((int) row.getCell(8).getNumericCellValue());


                        ArrayList<DichVuDTO> ListDichVu = DichVuDAO.getListDichVu();
                        int count = 0;
                        for (DichVuDTO x : ListDichVu) {
                            if (x.getMaDV().equals(nv.getMaDV())) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            new DichVuDAO().insertDV(nv);
                        }
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Tiêu Đề Cột Hoặc Thứ Tự Cột Dữ Liệu ");
                }

            } else {
                JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Lại, Có Giá Trị Là NULL");
            }

            workbook.close();
            file.close();
        } catch (Exception e) {
        }

    }
    public void ImportExcel_DuongBay(String path) {
        String[] expectedHeaders = {"STT", "Mã Đường Bay", "Nơi Đi", "Nơi Đến", "Thời Gian Ước Tính", "Xử Lý"};
        try {
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            if (hasNullValue(sheet) == false) {
                if (checkHeader(sheet, expectedHeaders)) {
                    for (Row row : sheet) {
                        // Bỏ qua hàng đầu tiên vì nó chứa tiêu đề của bảng Excel
                        if (row.getRowNum() == 0) {
                            continue;
                        }
                        DuongBayDTO nv = new DuongBayDTO();
                        nv.setMaDuongBay(row.getCell(1).getStringCellValue());
                        nv.setNoiDi(row.getCell(2).getStringCellValue());
                        nv.setNoiDen(row.getCell(3).getStringCellValue());
                        nv.setThoiGianBay(row.getCell(4).getStringCellValue());
                        
                        
                        nv.setXuLy((int) row.getCell(5).getNumericCellValue());
                        nv.setNoiNgoai(1);
//                      nv.setHeSoLuong((int) row.getCell(8).getNumericCellValue());


                        ArrayList<DuongBayDTO> ListDuongBay = DuongBayDAO.LoadData();
                        int count = 0;
                        for (DuongBayDTO x : ListDuongBay) {
                            if (x.getMaDuongBay().equals(nv.getMaDuongBay())) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            new DuongBayDAO().InsertDuongBay(nv);
                        }
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Tiêu Đề Cột Hoặc Thứ Tự Cột Dữ Liệu ");
                }

            } else {
                JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Lại, Có Giá Trị Là NULL");
            }

            workbook.close();
            file.close();
        } catch (Exception e) {
        }

    }
    public void ImportExcel_MayBay(String path) {
        String[] expectedHeaders = {"STT", "Mã Máy Bay", "Kích Thước", "Hãng Bay", "CauTrucBus", "CauTrucEco", "SLBussiness","SLEconomy"};
        try {
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            if (hasNullValue(sheet) == false) {
                if (checkHeader(sheet, expectedHeaders)) {
                    for (Row row : sheet) {
                        // Bỏ qua hàng đầu tiên vì nó chứa tiêu đề của bảng Excel
                        if (row.getRowNum() == 0) {
                            continue;
                        }
                        MayBayDTO nv = new MayBayDTO();
                        nv.setMaMayBay(row.getCell(1).getStringCellValue());
                        nv.setKichThuoc(row.getCell(2).getStringCellValue());
                        nv.setHangBay(row.getCell(3).getStringCellValue());
                        nv.setCautrucBus(row.getCell(4).getStringCellValue());
                        
                        
                        nv.setCautrucEco(row.getCell(5).getStringCellValue());
                        nv.setSLbus((int) row.getCell(6).getNumericCellValue());
                        nv.setSLeco((int) row.getCell(7).getNumericCellValue());
//                      nv.setHeSoLuong((int) row.getCell(8).getNumericCellValue());


                        ArrayList<MayBayDTO> ListMayBay = MayBayDAO.LoadData();
                        int count = 0;
                        for (MayBayDTO x : ListMayBay) {
                            if (x.getMaMayBay().equals(nv.getMaMayBay())) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            new MayBayDAO().insert(nv);
                        }
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Tiêu Đề Cột Hoặc Thứ Tự Cột Dữ Liệu ");
                }

            } else {
                JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Lại, Có Giá Trị Là NULL");
            }

            workbook.close();
            file.close();
        } catch (Exception e) {
        }

    }
    public void ImportExcel_NhanVien(String path) {
        String[] expectedHeaders = {"STT", "Mã Nhân Viên", "Họ Tên", "Chức Vụ", "Giới Tính", "Ngày Sinh", "Mail","Mật Khẩu", "Xử Lý"};
        try {
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            if (hasNullValue(sheet) == false) {
                if (checkHeader(sheet, expectedHeaders)) {
                    for (Row row : sheet) {
                        // Bỏ qua hàng đầu tiên vì nó chứa tiêu đề của bảng Excel
                        if (row.getRowNum() == 0) {
                            continue;
                        }
                        NhanVienDTO nv = new NhanVienDTO();
                        nv.setMaNV(row.getCell(1).getStringCellValue());
                        nv.setTenNV(row.getCell(2).getStringCellValue());
                        nv.setChucVu(row.getCell(3).getStringCellValue());
                        if(row.getCell(4).getStringCellValue().equals("Nam")){
                            nv.setGioiTinh(1);
                        }
                        else 
                            nv.setGioiTinh(0);
                        
                        nv.setNgaySinhString(row.getCell(5).getStringCellValue());
                        nv.setEmail(row.getCell(6).getStringCellValue());
                        nv.setmKNV(row.getCell(7).getStringCellValue());
//                        nv.setHeSoLuong((int) row.getCell(8).getNumericCellValue());
                        nv.setXuLy((int) row.getCell(8).getNumericCellValue());

                        ArrayList<NhanVienDTO> ListNhanVien = NhanVienDAO.LoadData();
                        int count = 0;
                        for (NhanVienDTO x : ListNhanVien) {
                            if (x.getMaNV().equals(nv.getMaNV())) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            new NhanVienDAO().InsertNhanVien(nv);
                        }
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Tiêu Đề Cột Hoặc Thứ Tự Cột Dữ Liệu ");
                }

            } else {
                JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Lại, Có Giá Trị Là NULL");
            }

            workbook.close();
            file.close();
        } catch (Exception e) {
        }

    }

    


    public void ImportExcel_KhachHang(String path) {
        String[] expectedHeaders = {"STT", "Mã Khách Hàng", "Tên Khách Hàng", "CCCD", "Giới Tính", "Số Điện Thoại", "Mail", "Ngày Sinh", "Xử Lý"};
        try {
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            if (hasNullValue(sheet) == false) {
                if (checkHeader(sheet, expectedHeaders)) {

                    for (Row row : sheet) {
                        // Bỏ qua hàng đầu tiên vì nó chứa tiêu đề của bảng Excel
                        if (row.getRowNum() == 0) {
                            continue;
                        }
                        KhachHangDTO kh = new KhachHangDTO();
                        kh.setMaKH(row.getCell(1).getStringCellValue());
                        kh.setTenKH(row.getCell(2).getStringCellValue());
                        kh.setCccd(row.getCell(3).getStringCellValue());
                        if(row.getCell(4).getStringCellValue().equals("Nam")){
                            kh.setGioiTinh(1);
                        }
                        else 
                            kh.setGioiTinh(0);
                        kh.setSdt(row.getCell(5).getStringCellValue());
                        kh.setMail(row.getCell(6).getStringCellValue());
                        kh.setNgaySinh(row.getCell(7).getStringCellValue());
                        kh.setXuLy((int) row.getCell(8).getNumericCellValue());

                        ArrayList<KhachHangDTO> ListKhachHang = KhachHangDAO.LoadData();
                        int count = 0;
                        for (KhachHangDTO x : ListKhachHang) {
                            if (x.getMaKH().equals(kh.getMaKH())) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            KhachHangBUS.insertKhachHang(kh);
                        }
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Tiêu Đề Cột Hoặc Thứ Tự Cột Dữ Liệu ");
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Lại, Có Giá Trị Là NULL");
            }
            workbook.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void ImportExcel_ChuyenBay(String path) {
        String[] expectedHeaders = {"STT", "Mã Chuyến Bay", "Mã Đường Bay", "Mã Máy Bay", "Giờ Bay", "Giờ Delay", "Ngày Đi", "SLEco", "SlBus", "Gate"};
        try {
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            if (hasNullValue(sheet) == false) {
                if (checkHeader(sheet, expectedHeaders)) {

                    for (Row row : sheet) {
                        // Bỏ qua hàng đầu tiên vì nó chứa tiêu đề của bảng Excel
                        if (row.getRowNum() == 0) {
                            continue;
                        }
                        ChuyenBayDTO kh = new ChuyenBayDTO();
                        kh.setMaChuyenBay(row.getCell(1).getStringCellValue());
                        kh.setMaDuongBay(row.getCell(2).getStringCellValue());
                        kh.setMaMayBay(row.getCell(3).getStringCellValue());
                        kh.setGioBay(row.getCell(4).getStringCellValue());
                        kh.setGioDelay(row.getCell(5).getStringCellValue());
                        
                        kh.setNgayDi(row.getCell(6).getStringCellValue());
                        kh.setSLEco(Integer.parseInt(row.getCell(7).getStringCellValue().trim()));
                        kh.setSLBus(Integer.parseInt(row.getCell(8).getStringCellValue().trim()));
                        kh.setGate(row.getCell(9).getStringCellValue());

                        ArrayList<ChuyenBayDTO> ListKhachHang = ChuyenBayDAO.LoadData();
                        int count = 0;
                        for (ChuyenBayDTO x : ListKhachHang) {
                            if (x.getMaChuyenBay().equals(kh.getMaChuyenBay())) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            ChuyenBayBUS.insertChuyenBay(kh);
                        }
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Tiêu Đề Cột Hoặc Thứ Tự Cột Dữ Liệu ");
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Lại, Có Giá Trị Là NULL");
            }
            workbook.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public boolean checkHeader(Sheet sheet, String[] expectedHeaders) {
        Row headerRow = sheet.getRow(0);
        int numColumns = headerRow.getLastCellNum();
        if (numColumns != expectedHeaders.length) {
            return false;
        }
        for (int i = 0; i < numColumns; i++) {
            Cell cell = headerRow.getCell(i);
            String actualHeader = cell.getStringCellValue().trim();
            String expectedHeader = expectedHeaders[i];
            if (!actualHeader.equals(expectedHeader)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasNullValue(Sheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        Row firstRow = sheet.getRow(0);
        int lastCellNum = firstRow.getLastCellNum();
        for (int i = 0; i <= lastRowNum; i++) { // duyệt hết các hàng trong bảng
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            for (int j = 0; j < lastCellNum; j++) { // duyệt hết các ô trong hàng
                Cell cell = row.getCell(j);
                if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                    return true; // nếu có bất kỳ ô nào null hoặc rỗng thì trả về true và dừng hàm
                }
                if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getStringCellValue().isEmpty()) {
                    return true; // nếu có ô chứa chuỗi rỗng thì trả về true và dừng hàm
                }
            }
        }
        return false; // nếu không có ô nào null hoặc rỗng thì trả về false
    }
}
