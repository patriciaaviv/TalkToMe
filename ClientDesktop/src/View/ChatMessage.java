package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ChatMessage extends JPanel {
    private String message;
    private String timeStamp;
    private int width;
    private final String html = "<html><body style = 'width: %1spx'>%1s";
    private JLabel messageLabel, timeLabel;
    private SpringLayout layout;

    public ChatMessage(String message, String timeStamp) {
        layout = new SpringLayout();
        this.setLayout(layout);

        this.messageLabel = new JLabel();
        this.timeLabel = new JLabel();

        this.add(messageLabel);
        this.add(timeLabel);
        layout.putConstraint(SpringLayout.WEST, messageLabel, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, timeLabel, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH,timeLabel,0, SpringLayout.SOUTH,messageLabel);

        this.setMessage(message);
        this.setTimeStamp(timeStamp);
        this.setWidth(300);

        messageLabel.setVisible(true);
        this.timeLabel.setVisible(true);
        this.setVisible(true);
        this.setBackground(Color.WHITE);

    }

    public void setMessage(String message) {
        this.message = message;
        messageLabel.setText(String.format(html, width, message));
    }

    public void setWidth(int width) {
        this.width = width;
        messageLabel.setText(String.format(html, width, message));
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
        this.timeLabel.setText(timeStamp);
    }

    @Override
    public Dimension getPreferredSize() {
        int x = Math.max(this.messageLabel.getPreferredSize().width, 200);
        int y = messageLabel.getPreferredSize().height+timeLabel.getPreferredSize().height;
        return new Dimension(x, y);
    }
}
