/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.main.agents.gui.AgenteBuscaRestaurante;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.RequestSearch;


/**
 *
 * @author JF
 */
public class BehaviourBusca extends CyclicBehaviour{

    @Override   
    public void action() {
	ACLMessage message = receiveMessage(ACLMessage.INFORM);	
         if (message != null) {
            System.out.println("Recebeu uma mensagem INFORM");
            RequestSearch busca;	
            try {
                busca = (RequestSearch) message.getContentObject();
                if (busca  != null){
                    AgenteBuscaRestaurante search = (AgenteBuscaRestaurante)myAgent;
                    search.filtrarestaurantes(busca);
                }	
            } catch (UnreadableException ex) {
                Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
            }                                        	
        } else {
        block();
        }
    }

    private ACLMessage receiveMessage(int INFORM) {
            MessageTemplate template = 
                 MessageTemplate.and(MessageTemplate.MatchPerformative(INFORM), MessageTemplate.MatchOntology("interface"));				
            ACLMessage message = myAgent.receive(template);
            return message;
    }
    
}
