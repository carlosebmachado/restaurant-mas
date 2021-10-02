package the.project.main;

import jade.core.Agent;
import the.project.main.agent.HelloAgent;

public class Main {
    
    public static void main(String[] args) {
        Agent agent = new HelloAgent();
        agent.setArguments(args);
        agent.run();
    }
    
}
