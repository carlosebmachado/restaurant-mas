/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.main.agents.gui.AgenteAnalisaScore;


import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import the.project.main.agents.gui.ReceiveBehabviour;


/**
 *
 * @author JF
 */
public class AgenteAnalisaScore extends Agent {
    
    private boolean greeting = true;

    @Override
    protected void setup(){
        addBehaviour(new ReceiveBehabviour(this));
    }

    

    public boolean isGreeting() {
        return greeting;
    }

    public void setGreeting(boolean greeting) {
        this.greeting = greeting;
    }
    
}
