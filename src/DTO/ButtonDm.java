/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatVeDTO;
import javax.swing.JButton;
public class ButtonDm {
    private String kind;
   /* private JPanel jpn;*/
    private JButton btn;

    public ButtonDm() {
    }

    public ButtonDm(String kind/*, JPanel jpn*/, JButton btn) {
        this.kind = kind;
        /*this.jpn = jpn;*/
        this.btn = btn;
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

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }
    
    

}
