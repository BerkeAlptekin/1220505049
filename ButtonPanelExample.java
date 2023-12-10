import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanelExample extends JFrame {
    private CustomButton[][] buttons;

    public ButtonPanelExample() {
        buttons = new CustomButton[4][4];
        setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new CustomButton();
                add(buttons[i][j]);
            }
        }

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonPanelExample();
    }

    private class CustomButton extends JButton implements ActionListener {
        private boolean isActive;
        private String schemaAddress;
        private Color activeColor;
        private Color inactiveColor;
        private Icon activeIcon;
        private Icon inactiveIcon;

        public CustomButton() {
            isActive = false;
            schemaAddress = "GraphQL Schema Address";
            activeColor = Color.GREEN;
            inactiveColor = Color.RED;
            activeIcon = new ImageIcon("active_icon.png");
            inactiveIcon = new ImageIcon("inactive_icon.png");

            setInactiveState();
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            if (isActive) {
                setInactiveState();
            } else {
                setActiveState();
            }
        }

        private void setActiveState() {
            isActive = true;
            setBackground(activeColor);
            setIcon(activeIcon);
        }

        private void setInactiveState() {
            isActive = false;
            setBackground(inactiveColor);
            setIcon(inactiveIcon);
        }
    }
}
