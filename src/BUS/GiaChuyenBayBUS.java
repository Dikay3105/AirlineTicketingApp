/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.GiaChuyenBayDTO;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ANH KHOA
 */
public class GiaChuyenBayBUS {
    public static ArrayList<GiaChuyenBayDTO> taoGia() {
    ArrayList<GiaChuyenBayDTO> list = new ArrayList<>();
    String[] diemDi = {
        "Hà Nội",
        "Thành phố Hồ Chí Minh",
        "Đà Nẵng",
        "Quảng Ninh",
        "Hải Phòng",
        "Nghệ An",
        "Huế",
        "Khánh Hòa",
        "Lâm Đồng",
        "Bình Định",
        "Cần Thơ",
        "Kiên Giang"
    };
    
    long[] gia = {
        1500000,
        1200000,
        1000000,
        1500000,
        1200000,
        1000000,
        900000,
        1300000,
        1100000,
        800000,
        700000,
        800000
    };

    for (int i = 0; i < diemDi.length; i++) {
            for (int j = 0; j < diemDi.length; j++) {
                if (i != j) {
                    GiaChuyenBayDTO giaChuyenBayDTO = new GiaChuyenBayDTO(diemDi[i], diemDi[j], gia[i]);
                    list.add(giaChuyenBayDTO);
                }
            }
        }
        return list;
    }

    
}
