package the.project.main.agents.gui;

import javax.swing.*;

import jade.core.*;

public class GuiAgent extends Agent {

    private JFrame frame;
    
    private JLabel lblName;
    private JLabel lblMessage;
    
    private boolean greeting = true;

    @Override
    protected void setup(){
        frame = new JFrame();
        lblName = new JLabel();
        lblMessage = new JLabel();
        frame.setSize(400, 225);
        frame.setTitle("Restaurant MAS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(lblName);
        frame.add(lblMessage);
        
        frame.setVisible(true);
        
        addBehaviour(new GreetingBehaviour(this));
        
        lblName.setText(getLocalName() + ":");
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getLblName() {
        return lblName;
    }

    public JLabel getLblMessage() {
        return lblMessage;
    }

    public boolean isGreeting() {
        return greeting;
    }

    public void setGreeting(boolean greeting) {
        this.greeting = greeting;
    }
    
}
