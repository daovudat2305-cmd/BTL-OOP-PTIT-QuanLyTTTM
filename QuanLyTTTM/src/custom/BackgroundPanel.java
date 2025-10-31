
package custom;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel() {
        // Constructor mặc định để NetBeans Design nhận diện
    }

    public BackgroundPanel(String path) {
        backgroundImage = new ImageIcon(path).getImage();
    }

    public void setBackgroundImage(String path) {
        backgroundImage = new ImageIcon(path).getImage();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // vẽ full panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
