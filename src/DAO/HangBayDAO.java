/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import GUI.HangBay;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class HangBayDAO {
    List<HangBay> lsHB = new ArrayList<>();

    public HangBayDAO() {
        lsHB.add(new HangBay("1","Vietnam Airlines"));
        lsHB.add(new HangBay("2","Vietjet Air"));
        lsHB.add(new HangBay("3","Jetstar Pacific Airlines"));
    }

    public int add(HangBay hb){
        lsHB.add(hb);
        return 1;
    }
    public List<HangBay> getALLHangBay(){
        return lsHB;
    }
}
