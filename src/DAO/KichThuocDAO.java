/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import GUI.KichThuoc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class KichThuocDAO {
    List<KichThuoc> lsKT = new ArrayList<>();

    public KichThuocDAO() {
        lsKT.add(new KichThuoc("1","Lớn"));
        lsKT.add(new KichThuoc("2","Nhỏ"));
        lsKT.add(new KichThuoc("3","Vừa"));
    }
    

    public int add(KichThuoc kt){
        lsKT.add(kt);
        return 1;
    }
    public List<KichThuoc> getALLKichThuoc(){
        return lsKT;
    }
}