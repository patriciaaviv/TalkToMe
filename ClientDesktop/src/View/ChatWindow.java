package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ChatWindow extends JFrame{
    private SpringLayout layout;
    private Container contentPane;
    private MessageSendPanel sendPanel;
    private StatisticsPanel statisticPanel;
    private MessageDisplayPanel displayPanel;
    private MessageHandler handler;

    public ChatWindow(MessageHandler handler){
        this();
        this.handler=handler;
    }

    public ChatWindow(){
        contentPane=this.getContentPane();
        this.layout=new SpringLayout();
        contentPane.setLayout(layout);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Send
        sendPanel= new MessageSendPanel(this);
        contentPane.add(sendPanel);
        sendPanel.setVisible(true);
        layout.putConstraint(SpringLayout.SOUTH,sendPanel,0,SpringLayout.SOUTH,contentPane);

        //Display
        displayPanel=new MessageDisplayPanel();
        contentPane.add(displayPanel);
        displayPanel.setVisible(true);
        layout.putConstraint(SpringLayout.SOUTH,displayPanel,0,SpringLayout.NORTH,sendPanel);
        layout.putConstraint(SpringLayout.NORTH,displayPanel,0,SpringLayout.NORTH,contentPane);
        layout.putConstraint(SpringLayout.WEST,displayPanel,0,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.EAST,displayPanel,0,SpringLayout.EAST,contentPane);

        //statistics


        this.pack();
        this.setVisible(true);

        //random stuff
        this.setBounds(100,50,800,600);
    }

    public void userSentMessage(String message){
        if(handler!=null){
            handler.userSentMessage(message);
        }
        displayPanel.recieveMessage(message,false);
    }

    /**
     * Call this method if the remote chat Partner sent a message
     * @param message - The message recieved
     */
    public void partnerSentMessage(String message){
        displayPanel.recieveMessage(message,new Date(System.currentTimeMillis()), true);
    }
}
