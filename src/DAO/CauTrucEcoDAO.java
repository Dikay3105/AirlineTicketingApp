/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CauTrucEco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CauTrucEcoDAO {
    List<CauTrucEco> lsCTE = new ArrayList<>();


    public CauTrucEcoDAO() {
        lsCTE.add(new CauTrucEco("1","2-3-2"));
        lsCTE.add(new CauTrucEco("2","3-3-0"));
        lsCTE.add(new CauTrucEco("3","3-3-3"));
        lsCTE.add(new CauTrucEco("4","2-2-0"));
    }
    public int add(CauTrucEco cte){
        lsCTE.add(cte);
        return 1;
    }
    public List<CauTrucEco> getALLCauTrucEco(){
        return lsCTE;
    }
}
