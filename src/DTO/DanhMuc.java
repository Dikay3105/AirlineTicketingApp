package DatVeDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class DanhMuc {
    private String kind;
   /* private JPanel jpn;*/
    private JLabel jlb;

    public DanhMuc() {
    }

    public DanhMuc(String kind/*, JPanel jpn*/, JLabel jlb) {
        this.kind = kind;
        /*this.jpn = jpn;*/
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
/*
    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }
*/
    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    
    
}
