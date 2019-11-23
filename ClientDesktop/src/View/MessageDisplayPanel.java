package View;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MessageDisplayPanel extends JPanel {
    private List<ChatMessage> messages;
    private SpringLayout layout;

    public MessageDisplayPanel() {
        messages = new LinkedList<ChatMessage>();
        layout = new SpringLayout();
        this.setLayout(layout);
        this.setVisible(true);
        this.setBackground(new Color(0xDDFF70));
    }

    public void recieveMessage(String message, Date timeStamp, boolean fromRemote) {
        ChatMessage cm = new ChatMessage(message, timeStamp.toString());
        if (fromRemote) {
            layout.putConstraint(SpringLayout.WEST, cm, 6, SpringLayout.WEST, this);
        } else {
            layout.putConstraint(SpringLayout.EAST, cm, 6, SpringLayout.EAST, this);
        }
        layout.putConstraint(SpringLayout.SOUTH, cm, -6, SpringLayout.SOUTH, this);
        if (!messages.isEmpty())
            layout.putConstraint(SpringLayout.SOUTH, messages.get(0), -6, SpringLayout.NORTH, cm);
        messages.add(0, cm);
        cm.setVisible(true);
        this.add(cm);

    }

    public void recieveMessage(String message, boolean fromRemote) {
        recieveMessage(message, new Date(System.currentTimeMillis()), fromRemote);
    }

}
