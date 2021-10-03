package the.project.main.agents.gui;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class TestBehaviour extends Behaviour {

    private int i = 1;

    public TestBehaviour(Agent a) {
        super(a);
    }
    
    @Override
    public void action() {
        System.out.println("Behaviour of agent " + myAgent.getLocalName());
        i++;
    }

    @Override
    public boolean done() {
        return i > 1;
    }
    
}
