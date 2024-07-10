/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.ChiTietSuDungDV;
import DTO.ChuyenBayDTO;
import DTO.DichVuDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.SuDungDichVuDTO;
import DTO.VeBayDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanh Tran
 */
public class HoaDonPDF {
    static ArrayList<DichVuDTO> listDV = DichVuBUS.getListDV();
    static ArrayList<SuDungDichVuDTO> listSuDungDV = new ArrayList<>();
    static ArrayList<VeBayDTO> listThuePhongDTO = new ArrayList<>();
    
    public static void generatePDF(String mahd, String tt, String gg) {
        String path = "";
        HoaDonDTO hd=HoaDonBUS.getHD(mahd);
        listThuePhongDTO = VeBayBUS.LoadVeWithHD(mahd);
        for(VeBayDTO veBayDTO: listThuePhongDTO)
            listSuDungDV.addAll(SuDungDichVuBUS.loadmv(veBayDTO.getMaVe()));

        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(null);

        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }

        Document doc = new Document(PageSize.A4, 20, 20, 20, 20);

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\" + mahd + ".pdf"));

            doc.open();

            Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            
            
            

            Paragraph centerText = new Paragraph("HOA DON MUA VE", boldFont);
            centerText.setAlignment(Element.ALIGN_CENTER);

            doc.add(centerText);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("Đai ly ve Deadline Airlines", font));
            doc.add(new Paragraph("Dia Chi: 273 An Duong Vuong, Phuong 3, Quan 5, TPHCM"));
            doc.add(new Paragraph("Lien He: 023 4567 8910"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            doc.add(new Paragraph("Ma Hoa Don: " + mahd + "                                                  "
                    + "Ngay Lap: " + hd.getNgayThanhToan()));
            
            doc.add(new Paragraph("Ma Khach Hang: "+hd.getMaKH()));
            doc.add(new Paragraph("Ma Nhan Vien: "+hd.getMaNV()));

            doc.add(new Paragraph("\n"));

            doc.add(new Paragraph("Bang ve da mua: "));
            doc.add(new Paragraph("\n"));
            PdfPTable btmp = createPdfTableVB();
            doc.add(btmp);

            // Thêm một đoạn trắng giữa hai bảng
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("Bang dich vu: "));
            doc.add(new Paragraph("\n"));

            // Gọi createPdfTable cho bảng bổ sung
            PdfPTable additionalPdfTable = createPdfTableDV();
            doc.add(additionalPdfTable);

            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("Tong tien: " + tt + "            Giam gia: " + gg ));

            JOptionPane.showMessageDialog(null, "Xuất thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HoaDonPDF.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Xuất thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } catch (DocumentException ex) {
            Logger.getLogger(HoaDonPDF.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Xuất thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } finally {
            doc.close();
        }
    }

    
    private static PdfPTable createPdfTableDV() {
        float[] columnWidths = {1.5f, 1.5f, 2.5f, 1.5f, 1.5f, 1.5f};
        PdfPTable pdfTable = new PdfPTable(columnWidths);
        pdfTable.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfTable.setWidthPercentage(100f);

        pdfTable.addCell("Ma Dich Vu");
        pdfTable.addCell("Ma Ve");
        pdfTable.addCell("Ten Dich Vu");
        pdfTable.addCell("So Luong");
        pdfTable.addCell("Don Gia");
        pdfTable.addCell("Thanh Tien");

       
        for (SuDungDichVuDTO x : listSuDungDV) {
            for(DichVuDTO dvdto: listDV) {
                if(x.getMaDV().equals(dvdto.getMaDV())) {
                    pdfTable.addCell(x.getMaDV());
                    pdfTable.addCell(x.getMaVe());
                    pdfTable.addCell(dvdto.getTenDV());
                    pdfTable.addCell(String.valueOf(x.getSoLuong()));
                    pdfTable.addCell(String.valueOf(dvdto.getGiaDV()));
                    pdfTable.addCell(String.valueOf(x.getSoLuong()*dvdto.getGiaDV()));
                }
            }
            
        }
        
        

        return pdfTable;
    }
    
    private static PdfPTable createPdfTableVB() {
        float[] columnWidths = {1.5f, 2.5f, 1.5f, 1.5f};
        PdfPTable pdfTable = new PdfPTable(columnWidths);
        pdfTable.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfTable.setWidthPercentage(100f);

        pdfTable.addCell("Ma Ve");
        pdfTable.addCell("Ten Khach Hang");
        pdfTable.addCell("Ma Ghe");
        pdfTable.addCell("Gia Ve");

        
 
        for (VeBayDTO x : listThuePhongDTO) {
            pdfTable.addCell(x.getMaVe());
            KhachHangDTO khdto=KhachHangBUS.loadKHtheoMaVe(x.getMaVe());
            pdfTable.addCell(khdto.getTenKH());
            pdfTable.addCell(x.getMaghe().trim());
            pdfTable.addCell(String.valueOf(x.getGiaVe()));

        }

        return pdfTable;
    }

   
}
