/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.main.agents.gui.AgenteAnalisaPreco;


import jade.core.Agent;
import the.project.main.agents.gui.ReceiveBehabviour;

/**
 *
 * @author JF
 */
public class AgenteAnalisaPreco extends Agent {
    
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
