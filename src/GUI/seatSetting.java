package GUI;

import BUS.GheBUS;
import BUS.MayBayBUS;
import DAO.GheDAO;
import DTO.GheDTO;
import DTO.MayBayDTO;
import GUI.datve.MenuDatVe;
import GUI.datve.Panel_ThongTinKH;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class seatSetting extends JPanel {

    private ArrayList<JButton> buttons = new ArrayList<>();

    public planeSeat a;

    public seatSetting(String cautruc, int soghe, int start, String machuyenbay, String loaighe, int SL, String gheChosen) throws SQLException, ParseException {
        a = new planeSeat(cautruc, soghe, start, machuyenbay, loaighe, SL, gheChosen);

        add(a, BorderLayout.NORTH);

    }

    public seatSetting(String cautruc, int soghe, int start, String machuyenbay, String loaighe, int SL, String gheChosen, int n) throws SQLException, ParseException {
        a = new planeSeat(cautruc, soghe, start, machuyenbay, loaighe, SL, gheChosen, n);

        add(a, BorderLayout.NORTH);

    }

    //class hiển thị ghế
    public class planeSeat extends JPanel {

        public int greenButtonCount = 0, khuhoi;
        private static int MAX_GREEN_BUTTONS = 0;

        public planeSeat(String cautruc, int soghe, int start, String machuyenbay, String loaighe, int SL, String gheChosen) throws SQLException, ParseException {
            setLayout(new GridBagLayout());
            MAX_GREEN_BUTTONS = SL;

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

            phantich ghe = phantichghe(cautruc, soghe);
            String countString = "A";
            char nextChar = countString.charAt(0);
            int begin = start;
            int count = 1;
            int count2 = 0;
            int soday = ghe.daygheint.size();
            int ghedu = soghe % ghe.soghe1hang;
            //System.out.println(ghe.soghe1hang + 2);
            for (int i = 0; i < ghe.sohang; i++) {
                for (int j = 0; j < ghe.soghe1hang + soday - 1; j++) {
                    if (j == ghe.daygheint.get(0) || j == ghe.daygheint.get(0) + 1 + ghe.daygheint.get(1)) {
                        JButton seatButton = new JButton();
                        seatButton.setContentAreaFilled(false); // Loại bỏ nền màu
                        seatButton.setBorderPainted(false); // Loại bỏ viền
                        seatButton.setEnabled(false);

                        gbc.gridx = count2 % (ghe.soghe1hang + soday - 1);
                        gbc.gridy = count2 / (ghe.soghe1hang + soday - 1);

                        add(seatButton, gbc);
                        count2++;

                    } else {
                        JButton seatButton = new JButton(begin + countString);
                        String tfString = GheDAO.checkGhe(begin + countString, machuyenbay);
                        //System.out.println(tfString);
                        if (gheChosen.equals(begin + countString)) {
                            seatButton.setBackground(Color.decode("#99FF99"));
                        } else if (tfString.equals("false")) {
                            seatButton.setBackground(Color.gray);

                        } else {
                            seatButton.setBackground(Color.decode("#FF9999"));
                            seatButton.setEnabled(false);
                        }
                        seatButton.setOpaque(true);
                        nextChar = (char) (nextChar + 1);
                        countString = String.valueOf(nextChar);
                        seatButton.addActionListener(new ButtonActionListener(seatButton));

                        gbc.gridx = count2 % (ghe.soghe1hang + soday - 1);
                        gbc.gridy = count2 / (ghe.soghe1hang + soday - 1);

                        add(seatButton, gbc);
                        count++;
                        count2++;
                        buttons.add(seatButton);
                    }
                }
                begin++;
                countString = "A";
                nextChar = countString.charAt(0);
            }

        }

        public planeSeat(String cautruc, int soghe, int start, String machuyenbay, String loaighe, int SL, String gheChosen, int n) throws SQLException, ParseException {
            khuhoi = n;
            setLayout(new GridBagLayout());
            MAX_GREEN_BUTTONS = SL;

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

            phantich ghe = phantichghe(cautruc, soghe);
            String countString = "A";
            char nextChar = countString.charAt(0);
            int begin = start;
            int count = 1;
            int count2 = 0;
            int soday = ghe.daygheint.size();
            int ghedu = soghe % ghe.soghe1hang;
            //System.out.println(ghe.soghe1hang + 2);
            for (int i = 0; i < ghe.sohang; i++) {
                for (int j = 0; j < ghe.soghe1hang + soday - 1; j++) {
                    if (j == ghe.daygheint.get(0) || j == ghe.daygheint.get(0) + 1 + ghe.daygheint.get(1)) {
                        JButton seatButton = new JButton();
                        seatButton.setContentAreaFilled(false); // Loại bỏ nền màu
                        seatButton.setBorderPainted(false); // Loại bỏ viền
                        seatButton.setEnabled(false);

                        gbc.gridx = count2 % (ghe.soghe1hang + soday - 1);
                        gbc.gridy = count2 / (ghe.soghe1hang + soday - 1);

                        add(seatButton, gbc);
                        count2++;

                    } else {
                        JButton seatButton = new JButton(begin + countString);
                        String tfString = GheDAO.checkGhe(begin + countString, machuyenbay);
                        //System.out.println(tfString);
                        if (gheChosen.equals(begin + countString)) {
                            seatButton.setBackground(Color.decode("#99FF99"));
                        } else if (tfString.equals("false")) {
                            seatButton.setBackground(Color.gray);

                        } else {
                            seatButton.setBackground(Color.decode("#FF9999"));
                            seatButton.setEnabled(false);
                        }
                        seatButton.setOpaque(true);
                        nextChar = (char) (nextChar + 1);
                        countString = String.valueOf(nextChar);
                        seatButton.addActionListener(new ButtonActionListener2(seatButton));

                        gbc.gridx = count2 % (ghe.soghe1hang + soday - 1);
                        gbc.gridy = count2 / (ghe.soghe1hang + soday - 1);

                        add(seatButton, gbc);
                        count++;
                        count2++;
                        buttons.add(seatButton);
                    }
                }
                begin++;
                countString = "A";
                nextChar = countString.charAt(0);
            }

        }

        class ButtonActionListener implements ActionListener {

            private JButton button;

            public ButtonActionListener(JButton button) {
                this.button = button;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.isEnabled()) {
                    if (button.getBackground() == Color.RED) {
                        // Do nothing for red buttons
                    } else if (button.getBackground() == Color.GRAY) {
                        if (greenButtonCount < MAX_GREEN_BUTTONS) {
                            button.setBackground(Color.decode("#99FF99"));
                            greenButtonCount++;
                            FrameOrderRoom.maGhetmp = button.getText();
                        }
                    } else {
                        button.setBackground(Color.GRAY);
                        greenButtonCount--;
                    }
                }
            }
        }

        class ButtonActionListener2 implements ActionListener {

            private JButton button;

            public ButtonActionListener2(JButton button) {
                this.button = button;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.isEnabled()) {
                    if (button.getBackground() == Color.RED) {
                        // Do nothing for red buttons
                    } else if (button.getBackground() == Color.GRAY) {
                        if (greenButtonCount < MAX_GREEN_BUTTONS) {
                            button.setBackground(Color.decode("#99FF99"));
                            greenButtonCount++;
                            int tmp;
                            if (khuhoi == 0) {
                                tmp = Panel_ThongTinKH.Aircraft.pn_KhachHang.cbbKH.getSelectedIndex();
                                MenuDatVe.MaGheList.set(tmp, button.getText());
                            } else {
                                tmp = Panel_ThongTinKH.Aircraft.pn_KhachHang2.cbbKH.getSelectedIndex();
                                MenuDatVe.MaGheListVe.set(tmp, button.getText());
                            }

                        }
                    } else {
                        button.setBackground(Color.GRAY);
                        greenButtonCount--;
                        int tmp;

                        if (khuhoi == 0) {
                            tmp = Panel_ThongTinKH.Aircraft.pn_KhachHang.cbbKH.getSelectedIndex();
                            MenuDatVe.MaGheList.set(tmp, "");
                        } else {
                            tmp = Panel_ThongTinKH.Aircraft.pn_KhachHang2.cbbKH.getSelectedIndex();
                            MenuDatVe.MaGheListVe.set(tmp, "");
                        }

                    }
                }
            }
        }

    }

    //đối tượng phân tích
    static class phantich {

        public int soghe, soghe1hang, sohang;
        public ArrayList<Integer> daygheint;

        public phantich(int soghe, int soghe1hang, int sohang, ArrayList<Integer> daygheint) {
            this.soghe = soghe;
            this.soghe1hang = soghe1hang;
            this.sohang = sohang;
            this.daygheint = daygheint;
        }

    }

    public static phantich phantichghe(String thongso, int soghe) {
        String[] dayghe = thongso.split("-");
        ArrayList<Integer> daygheint = new ArrayList<>();
        int soghe1hang = 0;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(dayghe[i]) != 0) {
                daygheint.add(Integer.parseInt(dayghe[i]));
                soghe1hang += daygheint.get(count);
                count++;
            }

        }

        int sohang = soghe / soghe1hang;

        phantich a = new phantich(soghe, soghe1hang, sohang, daygheint);
        return a;

    }

    public void setPicked(String maghe) {
        if (!maghe.equals("")) {
            for (JButton btnGhe : buttons) {
                if (btnGhe.getText().equals(maghe)) {
                    btnGhe.setBackground(Color.decode("#FF9999"));
                    btnGhe.setEnabled(false);
                    break;
                }

            }
        }
    }

    public void setChosen(String maghe) {
        if (!maghe.equals("")) {
            for (JButton btnGhe : buttons) {
                if (btnGhe.getText().equals(maghe)) {
                    btnGhe.setBackground(Color.decode("#99FF99"));
                    btnGhe.setEnabled(true);
                    break;
                }

            }
        }
    }

    public static void addGhe(String mamaybay) throws SQLException, ParseException {
        MayBayDTO mbdto = MayBayBUS.loadMB(mamaybay);
        phantich ghe = phantichghe(mbdto.getCautrucBus(), mbdto.getSLbus());
        String countString = "A";
        char nextChar = countString.charAt(0);
        int begin = 1;

        for (int i = 0; i < ghe.sohang; i++) {
            for (int j = 0; j < ghe.soghe1hang; j++) {
                GheDTO gheDTO = new GheDTO(begin + countString, mamaybay, "Bussiness", 1);
                GheBUS.insertGhe(gheDTO);

                nextChar = (char) (nextChar + 1);
                countString = String.valueOf(nextChar);
                //System.out.println(mamaybay + " " + begin + countString);
            }
            begin++;
            countString = "A";
            nextChar = countString.charAt(0);
        }

        phantich ghe1 = phantichghe(mbdto.getCautrucEco(), mbdto.getSLeco());
        countString = "A";
        nextChar = countString.charAt(0);

        for (int i = 0; i < ghe1.sohang; i++) {
            for (int j = 0; j < ghe1.soghe1hang; j++) {
                GheDTO gheDTO = new GheDTO(begin + countString, mamaybay, "Economy", 1);
                GheBUS.insertGhe(gheDTO);

                nextChar = (char) (nextChar + 1);
                countString = String.valueOf(nextChar);
            }
            begin++;
            countString = "A";
            nextChar = countString.charAt(0);
        }

    }

}
