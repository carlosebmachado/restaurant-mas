package the.project.main.agents.gui;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class GreetingBehaviour extends CyclicBehaviour {

    public GreetingBehaviour(Agent a) {
        super(a);
    }
    
    @Override
    public void action() {
        GuiAgent guiAgent = (GuiAgent) myAgent;
        if (guiAgent.isGreeting()) {
            guiAgent.getLblMessage().setText("Olá! Eu sou " + guiAgent.getLocalName() + ". Digite algo para ");
            guiAgent.setGreeting(false);
        }
    }
    
}
