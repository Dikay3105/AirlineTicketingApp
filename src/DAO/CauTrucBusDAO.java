/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CauTrucBus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CauTrucBusDAO {
    List<CauTrucBus> lsCTB = new ArrayList<>();

    public CauTrucBusDAO() {
        lsCTB.add(new CauTrucBus("1","2-2-0"));
        lsCTB.add(new CauTrucBus("2","1-1-0"));
    }

    public int add(CauTrucBus ctb){
        lsCTB.add(ctb);
        return 1;
    }
    public List<CauTrucBus> getALLCauTrucBus(){
        return lsCTB;
    }
}
