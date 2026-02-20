import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RainPanel extends JPanel {
    Droplet[] rain = new Droplet[500];
    final private Timer timer;

    public RainPanel() {
        timer = new Timer(5, this::update);
        timer.start();

        for (int i = 0; i < rain.length; i++) {
            rain[i] = new Droplet(true);
        }
    }

    private void update(ActionEvent e) {
        for (int i = 0; i < rain.length; i++) {
            rain[i].y += -1.0 / 33.0 * rain[i].z + 166.0 / 33.0; // Range 2 - 5

            if (rain[i].y - rain[i].len > RainSim.HEIGHT) {
                rain[i] = new Droplet(false);
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);

        for (Droplet drop:rain) {
            g.drawLine(drop.x, drop.y, drop.x, drop.y - drop.len);
        }
    }
}
