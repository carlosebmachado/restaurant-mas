/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.main.agents.gui.AgenteAnalisaScore;

import the.project.main.agents.gui.AgenteBuscaRestaurante.*;
import jade.core.Agent;

/**
 *
 * @author JF
 */
public class AgenteAnalisaScore extends Agent {
    
    private boolean greeting = true;

    @Override
    protected void setup(){
       
    }

    

    public boolean isGreeting() {
        return greeting;
    }

    public void setGreeting(boolean greeting) {
        this.greeting = greeting;
    }
    
}
