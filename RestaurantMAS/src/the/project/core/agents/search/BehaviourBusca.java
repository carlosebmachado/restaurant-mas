/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.core.agents.search;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import the.project.core.data.RestaurantData;
import the.project.core.objects.Request;
import the.project.core.objects.RequestSearch;
import the.project.core.objects.Restaurant;


/**
 *
 * @author JF
 */
public class BehaviourBusca extends CyclicBehaviour{

    @Override   
    public void action() {
                ACLMessage message = receiveMessage(ACLMessage.REQUEST);	
                if (message != null) {
                   System.out.println("Recebi uma mensagem do GuiAgent");
                   RequestSearch busca;	
                   try {
                       busca = (RequestSearch) message.getContentObject();
                       if (busca  != null){
                           
                           AgenteBuscaRestaurante search = (AgenteBuscaRestaurante)myAgent;
                           Request preferencias = busca.getPreferencias();
                           ArrayList<Restaurant> restaurantes = busca.getRestaurantes();
                            for (Restaurant rest : restaurantes) {
                                if (!rest.getType().contains(preferencias.getType())) {
                                    restaurantes.remove(rest);
                                }
                            }
                            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                            msg.addReceiver(new AID("SearchAgent", AID.ISLOCALNAME));
                            msg.setContentObject(busca);                           
                            search.send(msg);
                       }	
                   } catch (UnreadableException ex) {
                       Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                   }    
                   catch (IOException ep) {
                       Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ep);
                   }
               } else {
                        block();
                    }
            }

            private ACLMessage receiveMessage(int INFORM) {
                MessageTemplate template = MessageTemplate.MatchPerformative(INFORM);			
                ACLMessage message = myAgent.receive(template);
                return message;
            }
    
}
