package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatSelectionApp {

    private JFrame frame;
    private JPanel seatPanel;

    public SeatSelectionApp() {
        frame = new JFrame("Chọn ghế máy bay");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        seatPanel = new JPanel();
        seatPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        
        int count=4;
        
        for (int i = 0; i <= 100; i++) {
            if (count%7==0) {
                JButton seatButton = new JButton(String.valueOf((i+1)/4));
                seatButton.setContentAreaFilled(false); // Loại bỏ nền màu
                seatButton.setBorderPainted(false); // Loại bỏ viền
                seatButton.setEnabled(false);

                gbc.gridx = i % 7;
                gbc.gridy = i / 7;

                seatPanel.add(seatButton, gbc);
                count++;
                --i;
            } else {
                JButton seatButton = new JButton("Ghế " + (i+1));
            seatButton.setBackground(Color.gray);
            seatButton.setOpaque(true);

            seatButton.addActionListener(new ActionListener() {
                private boolean isRed = false;

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    if (isRed) {
                        clickedButton.setBackground(Color.GREEN);
                    } else {
                        clickedButton.setBackground(Color.RED);
                    }
                    isRed = !isRed;
                }
            });

            gbc.gridx = i % 7;
            gbc.gridy = i / 7;

            seatPanel.add(seatButton, gbc);
            count++;
            }
            
        }

        // Thêm seatPanel vào JScrollPane
        JScrollPane scrollPane = new JScrollPane(seatPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(scrollPane);
        frame.setVisible(true);
    }

    
}
