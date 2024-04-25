import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Counter extends JFrame {
    private int actualValue;
    private int timerValue;
    private JLabel valueLabel;
    private JLabel timerLabel;
    private JTextField timerField;
    private Timer countdownTimer;

    public Counter() {
        actualValue = 0;
        timerValue = 0;

        // Initialize components
        valueLabel = new JLabel("Value: " + actualValue);
        timerField = new JTextField(5);
        timerLabel = new JLabel("Timer: " + timerValue);

        // Create buttons
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton setButton = new JButton("Set Timer");

        // Add action listeners to buttons
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualValue++;
                updateCounterLabel();
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualValue--;
                updateCounterLabel();
            }
        });
//TODO:  protect against input spam
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    timerValue = Integer.parseInt(timerField.getText());
                    startCountdownTimer();
                    //JOptionPane.showMessageDialog(null, "Timer set to: " + timerValue);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for timer.");
                }
            }
        });

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(timerLabel);
        panel.add(valueLabel);
        panel.add(plusButton);
        panel.add(minusButton);
        panel.add(new JLabel("Set Timer:"));
        panel.add(timerField);
        panel.add(setButton);

        // Add panel to frame
        add(panel);

        // Set frame properties
        setTitle("Counter");
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateCounterLabel() {
        valueLabel.setText("Value: " + actualValue);
    }
    private void updateTimerLabel() {
        timerLabel.setText("Timer: " + timerValue);
    }

    private void startCountdownTimer() {
        countdownTimer = new Timer();
        countdownTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (timerValue > 0) {
                    timerValue--;
                    //JOptionPane.showMessageDialog(null, "Timer: " + timerValue);
                    updateTimerLabel();

                } else {
                    JOptionPane.showMessageDialog(null, "Timer double fininshed!");
                    countdownTimer.cancel();
                }
            }
        }, 0, 1000); // TimerTask will run every 1000 milliseconds (1 second)
    }

    public static void main(String[] args) {
        new Counter();
    }
}