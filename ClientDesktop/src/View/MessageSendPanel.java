package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageSendPanel extends JPanel {
    private JTextArea messageField;
    private JButton sendMessageButton;
    private ChatWindow parent;
    private SpringLayout layout;

    public MessageSendPanel(ChatWindow parent) {
        this.parent = parent;
        //button
        this.sendMessageButton = new JButton("Send");
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sendMessage(messageField.getText());
                messageField.setText("");
            }
        });

        //textarea
        messageField = new JTextArea();

        this.add(messageField);
        this.add(sendMessageButton);
        //layout
        this.layout = new SpringLayout();
        layout.putConstraint(SpringLayout.EAST, messageField, -6, SpringLayout.WEST, sendMessageButton);
        layout.putConstraint(SpringLayout.WEST, messageField, 6, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, sendMessageButton, -6, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, sendMessageButton, -6, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.NORTH, sendMessageButton, 6, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, messageField, 6, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, messageField, -6, SpringLayout.SOUTH, this);
        this.setLayout(layout);
        this.setRightSide(parent);
        this.setLeftSide(parent);
        this.setVisible(true);
        sendMessageButton.setVisible(true);
        messageField.setVisible(true);
        messageField.setText("Please enter Message");
        messageField.setBackground(Color.white);
    }

    public void sendMessage(String message) {
        if (!message.isBlank())
            parent.userSentMessage(message);
    }

    public void setLeftSide(Component left) {
        layout.putConstraint(SpringLayout.WEST, this, 5, SpringLayout.WEST, left);
    }

    public void setRightSide(Component right) {
        layout.putConstraint(SpringLayout.EAST, this, 5, SpringLayout.EAST, right);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(parent.getContentPane().getWidth(), Math.max(32, Math.min(100, parent.getHeight() / 7)));
    }
}
