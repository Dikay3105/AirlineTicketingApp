/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChuyenBayDAO;
import DAO.DuongBayDAO;
import DTO.ChuyenBayDTO;
import DTO.DuongBayDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author huhuh
 */
public class ChuyenBayBUS {
    public static String pathExcel;
    public static void insertChuyenBay(ChuyenBayDTO cbdto) throws SQLException, ParseException {
        ChuyenBayDAO.InsertChuyenBay(cbdto);
    }
    
    public static void delChuyenBay(String maChuyenBay) throws SQLException, ParseException {
        ChuyenBayDAO.DelChuyenBay(maChuyenBay);
    }
    
    public static void updateChuyenBay(ChuyenBayDTO cbdto) throws SQLException, ParseException {
        ChuyenBayDAO.UpdateChuyenBay(cbdto);
    }
    public static ChuyenBayDTO loadCB(String macb) {
        return ChuyenBayDAO.LoadCB(macb);
    }
    
    public static ArrayList<ChuyenBayDTO> loadCBtheoDB(String noidi, String noiden, String ngaydi, ArrayList<String> tgd, String hangbay, int total) {
        ArrayList<ChuyenBayDTO> tmpArrayList=new ArrayList<>();
        for(ChuyenBayDTO cbdto: ChuyenBayDAO.LoadCBTheoDB(noidi,noiden,ngaydi,tgd,hangbay))
            if(total<=cbdto.getSLBus() || total<=cbdto.getSLEco())
                tmpArrayList.add(cbdto);
        return tmpArrayList;
    }
    
    public static ArrayList<ChuyenBayDTO> load()   {
        
        ArrayList<ChuyenBayDTO> a = new ArrayList<>();
        ArrayList<ChuyenBayDTO> b = new ArrayList<>();
        a = new ChuyenBayDAO().LoadData();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getXuLy() == 1) {
                b.add(a.get(i));
            }
        }
        return b;
    }
    
    
    
    public static String xuatExcel(String path) {
        BackUpData bk = new BackUpData();
        String message = "";
        try {
            bk.backup_Chuyenbay(path);
            message += "Xuất file thành công";
            pathExcel = path;
        } catch (Exception ex) {
            message += "Xuất file không thành công";
        }
        return message;
    }
    
    public static String addHours(String inputDateStr, int hour) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            // Chuyển đổi chuỗi thành đối tượng Date
            Date inputDate = dateFormat.parse(inputDateStr);

            // Sử dụng Calendar để giảm giá trị thời gian đi 2 giờ
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(Calendar.HOUR_OF_DAY, hour);

            // Chuyển đối tượng Calendar thành đối tượng Date
            Date resultDate = calendar.getTime();

            // Chuyển đối tượng Date thành chuỗi
            return dateFormat.format(resultDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Xảy ra lỗi khi chuyển đổi chuỗi thành Date
        }
    }
    
     public static String addTimeToDate(String dateStr, String timeStr) {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            // Chuyển đổi chuỗi thành đối tượng Date
            Date date = dateTimeFormat.parse(dateStr);
            Date time = timeFormat.parse(timeStr);

            // Sử dụng Calendar để cộng thêm thời gian
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.HOUR_OF_DAY, time.getHours());
            calendar.add(Calendar.MINUTE, time.getMinutes());
            calendar.add(Calendar.SECOND, time.getSeconds());

            // Chuyển đối tượng Calendar thành đối tượng Date
            Date resultDate = calendar.getTime();

            // Chuyển đối tượng Date thành chuỗi
            return dateTimeFormat.format(resultDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Xảy ra lỗi khi chuyển đổi chuỗi thành Date
        }
    }
    
    public static boolean compareDates(String dateStr1, String dateStr2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            Date date1 = dateFormat.parse(dateStr1);
            Date date2 = dateFormat.parse(dateStr2);

            // Sử dụng phương thức compareTo để so sánh
            return date1.after(date2);
        } catch (ParseException e) {
            e.printStackTrace();
            return false; // Xảy ra lỗi khi chuyển đổi chuỗi thành Date
        }
    }
    
    public static boolean compareEqual(String dateStr1, String dateStr2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            Date date1 = dateFormat.parse(dateStr1);
            Date date2 = dateFormat.parse(dateStr2);

            // Sử dụng phương thức compareTo để so sánh
            return date1.equals(date2);
        } catch (ParseException e) {
            e.printStackTrace();
            return false; // Xảy ra lỗi khi chuyển đổi chuỗi thành Date
        }
    }
    
    public static ArrayList<String> gateNotAvailable(Object hour, Object minute, String ngay, String chuyenbay) {
        ArrayList<ChuyenBayDTO> cblist=ChuyenBayDAO.LoadData();
        ArrayList<String> tmp=new ArrayList<>();
        String time=ngay.trim()+" "+hour+":"+minute+":00";
        for(ChuyenBayDTO cbdto:cblist) {
            if(!cbdto.getMaChuyenBay().trim().equals(chuyenbay.trim())) {
                String time2=cbdto.getNgayDi()+" "+cbdto.getGioDelay().trim();
                //System.out.println(time2);
                if(compareDates(time2, addHours(time,-2))) {
                    if(compareDates(time, time2) || compareEqual(time2, time)) {
                        tmp.add(cbdto.getGate().trim());
                        //System.out.println(cbdto.getMaChuyenBay());
                    }
                }          
            }
                
        }
        return tmp;
    }
    
   
    
}
