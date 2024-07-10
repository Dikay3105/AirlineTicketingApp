import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private DataPanel dataPanel;

    public MainFrame() {
        setTitle("Trang Chu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        dataPanel = new DataPanel();

        // Create individual panels
        HomePanel homePanel = new HomePanel();
        Page1Panel page1Panel = new Page1Panel(dataPanel);
        Page2Panel page2Panel = new Page2Panel(dataPanel);
        Page3Panel page3Panel = new Page3Panel(dataPanel);
        Page4Panel page4Panel = new Page4Panel(dataPanel);

        // Add panels to contentPanel
        contentPanel.add(homePanel, "home");
        contentPanel.add(page1Panel, "page1");
        contentPanel.add(page2Panel, "page2");
        contentPanel.add(page3Panel, "page3");
        contentPanel.add(page4Panel, "page4");

        // Create buttons for navigation
        JButton homeButton = new JButton("Trang Chu");
        JButton page1Button = new JButton("Chon Chuyen");
        JButton page2Button = new JButton("Thong Tin Khach Hang");
        JButton page3Button = new JButton("Chon Cho Ngoi");
        JButton page4Button = new JButton("Thanh Toan");

        // Add action listeners to buttons to switch between panels
        homeButton.addActionListener(e -> cardLayout.show(contentPanel, "home"));
        page1Button.addActionListener(e -> cardLayout.show(contentPanel, "page1"));
        page2Button.addActionListener(e -> cardLayout.show(contentPanel, "page2"));
        page3Button.addActionListener(e -> cardLayout.show(contentPanel, "page3"));
        page4Button.addActionListener(e -> cardLayout.show(contentPanel, "page4"));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(homeButton);
        buttonPanel.add(page1Button);
        buttonPanel.add(page2Button);
        buttonPanel.add(page3Button);
        buttonPanel.add(page4Button);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }

    private class HomePanel extends JPanel {
        public HomePanel() {
            add(new JLabel("Trang Chu"));
        }
    }

    private class Page1Panel extends JPanel {
        private DataPanel dataPanel;

        public Page1Panel(DataPanel dataPanel) {
            this.dataPanel = dataPanel;
            add(new JLabel("Chon Chuyen"));

            JTextField textField = new JTextField(20);
            JButton sendDataButton = new JButton("Gửi Dữ Liệu");
            sendDataButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String data = textField.getText();
                    dataPanel.setData(data);
                    cardLayout.show(contentPanel, "page2");
                }
            });
            add(textField);
            add(sendDataButton);
        }
    }

    private class Page2Panel extends JPanel {
        private DataPanel dataPanel;

        public Page2Panel(DataPanel dataPanel) {
            this.dataPanel = dataPanel;
            add(new JLabel("Thong Tin Khach Hang"));

            JLabel dataLabel = new JLabel("Dữ liệu từ Trang 1: " + dataPanel.getData());
            add(dataLabel);
        }
    }

    private class Page3Panel extends JPanel {
        private DataPanel dataPanel;

        public Page3Panel(DataPanel dataPanel) {
            this.dataPanel = dataPanel;
            add(new JLabel("Chon Cho Ngoi"));
        }
    }

    private class Page4Panel extends JPanel {
        private DataPanel dataPanel;

        public Page4Panel(DataPanel dataPanel) {
            this.dataPanel = dataPanel;
            add(new JLabel("Thanh Toan"));
        }
    }
}

class DataPanel extends JPanel {
    private String data;

    public DataPanel() {
        data = "1233";
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
