package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


class UppercaseDocumentFilter extends DocumentFilter {

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        fb.insertString(offset, text.toUpperCase(), attr);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        fb.replace(offset, length, text.toUpperCase(), attrs);
    }
 }

public class FormChangeAccount extends JFrame {

    private Font font20b = new Font("Times New Roman", Font.BOLD, 20);
    private Font font25b = new Font("Times New Roman", Font.BOLD, 25);
    private Font font18b = new Font("Times New Roman", Font.BOLD, 18);
    private Font font18 = new Font("Times New Roman", Font.PLAIN, 18);
    private Font font13 = new Font("Times New Roman", Font.PLAIN, 13);
    JLabel lbTitle = new JLabel("Thay đổi mật khẩu");
    JLabel lbImg = new JLabel();
    JPanel pnInput = new JPanel();

    JLabel lbTop = new JLabel("Thay đổi mật khẩu");
    JPanel pnCenter = new JPanel();
    JPanel pnTk = new JPanel();
    JLabel lbTk = new JLabel("Tài khoản:");
    JTextField txtTk = new JTextField();
    JPanel pnMknow = new JPanel();
    JLabel lbMknow = new JLabel("Mật khẩu hiện tại:");
    JPasswordField pssnow = new JPasswordField();
    JPanel pnMknew = new JPanel();
    JLabel lbMknew = new JLabel("Mật khẩu mới:");
    JPasswordField pssnew = new JPasswordField();
    JPanel pnBottom = new JPanel();
    JPanel pnLogin = new JPanel();
    JButton btnLogin = new JButton("Đăng nhập");
    JButton btnForget = new JButton("Quên mật khẩu");
    JPanel pnForget = new JPanel();
    JPanel pnAcept = new JPanel();
    JButton btnAcept = new JButton("Đổi mật khẩu");

    public FormChangeAccount() {
        initComponents();
        btnAcept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ChangePassFunct();
                } catch (IOException | SQLException | ParseException ex) {
                    Logger.getLogger(FormChangeAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public FormChangeAccount(String tk) {
        initComponents();
        pnCenter.remove(pnMknow);
        txtTk.setEditable(false);
        txtTk.setText(tk);
        pnForget.setVisible(false);
        pnLogin.setVisible(false);
        pnBottom.setVisible(false);
        btnAcept.setText("Lưu mật khẩu mới");
        btnAcept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passnew = new String(pssnew.getPassword());
                String infor = "";
                ArrayList<NhanVienDTO> list = new ArrayList<>();
                list = new NhanVienBUS().LoadNV();
                if (passnew.trim().length() == 0) {
                    infor += "Mật khẩu mới không được để trống";
                    JOptionPane.showMessageDialog(null, infor, "Báo lỗi", 0);
                } else {
                    for (NhanVienDTO nvdto : list) {
                        if (nvdto.getMaNV().equals(txtTk.getText())) {
                            nvdto.setmKNV(passnew);
                            try {
                                NhanVienBUS.updateNV(nvdto);
                            } catch (SQLException ex) {
                                Logger.getLogger(FormChangeAccount.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ParseException ex) {
                                Logger.getLogger(FormChangeAccount.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(null, "Đã đổi mật khẩu mới");
                            break;
                        }
                    }
                    setVisible(false);
                    new LoginGUI();
                }

            }
        });
    }

    public void initComponents() {
        ((AbstractDocument) txtTk.getDocument()).setDocumentFilter(new UppercaseDocumentFilter());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        lbTitle.setBounds(350, 10, 300, 30);
        lbTitle.setFont(font25b);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/asset/change.jpg")).getImage().getScaledInstance(400, 550, Image.SCALE_SMOOTH));
        lbImg.setBounds(90, 10, 400, 500);
        lbImg.setIcon(imageIcon);
        add(lbTitle);
        add(lbImg);
        setVisible(true);
        setSize(1014, 637);
        setLocationRelativeTo(null);

        pnInput.setBounds(510, 150, 400, 300);
        pnInput.setBackground(Color.red);
        pnInput.setLayout(new BorderLayout());
        pnInput.add(lbTop, BorderLayout.NORTH);
        pnInput.add(pnCenter, BorderLayout.CENTER);
        pnInput.add(pnBottom, BorderLayout.SOUTH);
        pnInput.setBorder(new EmptyBorder(0, 50, 0, 50));

        lbTop.setHorizontalAlignment(JLabel.CENTER);
        lbTop.setFont(font25b);
        lbTop.setForeground(new Color(0, 0, 153));

        pnCenter.setLayout(new GridLayout(4, 1, 5, 5));
        pnCenter.add(pnTk);
        pnTk.setBackground(Color.white);
        pnTk.setLayout(new BorderLayout());
        pnTk.add(lbTk, BorderLayout.NORTH);
        pnTk.add(txtTk, BorderLayout.CENTER);
        pnCenter.add(pnMknow);
        pnMknow.setBackground(Color.white);
        pnMknow.setLayout(new BorderLayout());
        pnMknow.add(lbMknow, BorderLayout.NORTH);
        pnMknow.add(pssnow, BorderLayout.CENTER);
        pnCenter.add(pnMknew);
        pnMknew.setBackground(Color.white);
        pnMknew.setLayout(new BorderLayout());
        pnMknew.add(lbMknew, BorderLayout.NORTH);
        pnMknew.add(pssnew, BorderLayout.CENTER);
        pnCenter.add(pnAcept);
        pnAcept.setBackground(Color.white);
        pnAcept.setLayout(new BorderLayout());
        pnAcept.setBorder(new EmptyBorder(15, 50, 15, 50));
        pnAcept.add(btnAcept, BorderLayout.CENTER);

        btnAcept.setBackground(Color.decode("#98FB98"));
        btnAcept.setFocusPainted(false);

        btnAcept.setFont(font13);
        pnBottom.setBackground(Color.white);
        pnBottom.setLayout(new GridLayout(1, 2, 5, 5));
        pnBottom.add(pnLogin);
        pnBottom.add(pnForget);

        pnLogin.setLayout(new BorderLayout());
        pnLogin.add(btnLogin, BorderLayout.CENTER);

        pnInput.setBackground(Color.white);

        btnLogin.setBackground(Color.decode("#FFC0CB"));
        btnForget.setBackground(Color.white);
        btnLogin.setFont(font13);
        btnForget.setFont(font13);

        txtTk.setFont(font18);
        pssnew.setFont(font18);
        pssnow.setFont(font18);

        txtTk.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 10, 0, 10)));
        pssnew.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 10, 0, 10)));
        pssnow.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 10, 0, 10)));

        lbTk.setFont(font18);
        lbMknow.setFont(font18);
        lbMknew.setFont(font18);

        pnForget.setLayout(new BorderLayout());
        pnForget.add(btnForget, BorderLayout.CENTER);
        btnLogin.setFocusPainted(false);
        btnForget.setFocusPainted(false);
        add(pnInput);
        
        btnForget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FormForgotPassword();
            }
        });
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginGUI();
                dispose();
            }
        });
    }

    public boolean checkMK_MKnew(String mk, String mkNew) {
        if (!mk.equals(mkNew)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới không được giống mật khẩu cũ vì lý do bảo mật");
            return false;
        }

    }

    public boolean checkNull() {
        String infor = "";
        if (txtTk.getText().trim().length() == 0) {
            infor += "Tài khoản không được để trống\n";
            JOptionPane.showMessageDialog(this, infor, "Báo lỗi", 0);
            return false;
        }
        String pass = new String(pssnow.getPassword());
        if (pass.trim().length() == 0) {
            infor += "Mật khẩu hiện tại không được để trống";
            JOptionPane.showMessageDialog(this, infor, "Báo lỗi", 0);
            return false;
        }
        String passnew = new String(pssnew.getPassword());
        if (passnew.trim().length() == 0) {
            infor += "Mật khẩu mới không được để trống";
            JOptionPane.showMessageDialog(this, infor, "Báo lỗi", 0);
            return false;
        }
        
        if(pass.trim().length()> 20) {
            infor += "Mật khẩu không được dài hơn 20 kí tự";
            JOptionPane.showMessageDialog(this, infor, "Báo lỗi", 0);
            return false;
        }
        return true;
    }

    //kiểm tra xem tài khoản có trong DB không
    public boolean checkTK(ArrayList<NhanVienDTO> list, String tk) {
        for (NhanVienDTO s : list) {
            if (s.getMaNV().equals(tk)) {
                return true;
            }
        }
        return false;
    }

    //check Tk và Mk trong DB
    public boolean checkMK(ArrayList<NhanVienDTO> list, String tk, String mk) {
        for (NhanVienDTO s : list) {
            if (s.getMaNV().equals(tk) && s.getmKNV().equals(mk)) {
                mainGUI.nameNV = s.getTenNV();
                return true;
            }
        }
        return false;
    }

    public void run(JButton btn, Color color) {
        new Thread(() -> {
            btn.setLayout(null);
            JPanel pn = new JPanel();
            pn.setBackground(color);
            JPanel pn1 = new JPanel();
            pn1.setBackground(color);
            btn.add(pn);
            btn.add(pn1);
            int k = 1;
            for (int i = btnAcept.getWidth() / 2; i > 0; i--) {
                pn.setBounds(i, 1, 25, 25);
                pn1.setBounds(i + 2 * k, 1, 25, 25);
                k++;
                repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
            btn.remove(pn);
            btn.remove(pn1);
        }).start();
    }

    public void ChangePassFunct() throws IOException, SQLException, ParseException {
        if (checkNull()) {
            String pass = new String(pssnow.getPassword());
            String passnew = new String(pssnew.getPassword());
            ArrayList<NhanVienDTO> list = new ArrayList<>();
            list = new NhanVienBUS().LoadNV();

            if (checkTK(list, txtTk.getText()) == false) {
                JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (checkMK(list, txtTk.getText(), pass)) {
                if (checkMK_MKnew(pass, passnew)) {
                    for (NhanVienDTO nvdto : list) {
                        if (nvdto.getMaNV().equals(txtTk.getText())) {
                            nvdto.setmKNV(passnew);
                            NhanVienBUS.updateNV(nvdto);
                            JOptionPane.showMessageDialog(null, "Đã đổi mật khẩu");
                            break;
                        }
                    }
                    this.setVisible(false);
                    new LoginGUI();

                }
            } else {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}
