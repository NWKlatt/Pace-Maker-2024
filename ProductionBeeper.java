import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductionBeeper extends JFrame {
    private JLabel countdownLabel;
    private JLabel counterLabel;
    private JLabel smileyFaceLabel;

    private int countdownValue;
    private int counterValue;

    public ProductionBeeper() {
        setTitle("OSTA Value Thunderbeat Type-S Production Beeper");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize countdown label
        countdownLabel = new JLabel();
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 24));
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateCountdown();

        // Initialize counter label
        counterLabel = new JLabel("Counter: 0");
        counterLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Initialize smiley face label
        smileyFaceLabel = new JLabel();
        updateSmileyFace();

        // Add components to the frame
        getContentPane().setLayout(new GridLayout(3, 1));
        getContentPane().add(countdownLabel);
        getContentPane().add(counterLabel);
        getContentPane().add(smileyFaceLabel);

        // Timer to update countdown
        Timer countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdownValue--;
                updateCountdown();
                if (countdownValue == 0) {
                    playBeep();
                    counterValue++;
                    updateCounter();
                    updateSmileyFace();
                }
            }
        });
        countdownTimer.start();
    }

    private void updateCountdown() {
        countdownLabel.setText("Countdown: " + countdownValue);
    }

    private void updateCounter() {
        counterLabel.setText("Counter: " + counterValue);
    }

    private void updateSmileyFace() {
        if (counterValue - countdownValue > 30) {
            smileyFaceLabel.setIcon(new ImageIcon("red_smiley.png"));
        } else if (counterValue - countdownValue > 15) {
            smileyFaceLabel.setIcon(new ImageIcon("yellow_smiley.png"));
        } else {
            smileyFaceLabel.setIcon(new ImageIcon("green_smiley.png"));
        }
    }

    private void playBeep() {
        // Code to play beep sound
        System.out.println("Beep!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductionBeeper().setVisible(true);
            }
        });
    }
}
