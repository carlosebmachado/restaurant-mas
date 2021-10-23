/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.core.agents.search;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import the.project.core.RestaurantCard;
import the.project.core.objects.Request;
import the.project.core.objects.RequestSearch;
import the.project.core.objects.Restaurant;

/**
 *
 * @author JF
 */
public class AgenteBuscaRestaurante extends Agent {

    @Override
    protected void setup() {
        //Constroi o behaviour
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Novo agente Busca Restaurante criado!!");
            }
        });
        addBehaviour(new BehaviourBusca());
        
        FSMBehaviour behaviour = new FSMBehaviour(this) {
            @Override
            public int onEnd() {
                System.out.println("FSM Behaviour finalized with success.");
                return 0;
            }
        };
        behaviour.registerFirstState(new CyclicBehaviour(this) {            
            private int state = 0;
            @Override
            public void action() {
                System.out.println("Executing behavour W");
                MessageTemplate template = 
                     MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("interface"));				
                ACLMessage message = myAgent.receive(template);
                if (message != null) {
                   System.out.println("Recebeu uma mensagem REQUEST");
                   RequestSearch busca;	
                   try {
                       busca = (RequestSearch) message.getContentObject();
                       ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("PriceAgent", AID.ISLOCALNAME));
                        msg.setContentObject(busca);
                        send(msg);
                        state = 1;
                    } catch (UnreadableException ex) {
                       Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                   }  
                   catch (IOException ep) {
                        System.out.println("Erro ao enviar mensagem: DistanceAgent -> AgenteBuscaRestaurante");
                    }
                }
            }
            @Override
            public int onEnd() {
                return state;
            }
        }, "W");
        
        // adicionando o segundo comportamento - Z
        behaviour.registerState(new CyclicBehaviour(this) {            
            private int state = 0;
            @Override
            public void action() {
                System.out.println("Executing behavour X");
                MessageTemplate template = 
                     MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("interface"));				
                ACLMessage message = myAgent.receive(template);
                if (message != null) {
                   System.out.println("Recebeu uma mensagem REQUEST");
                   RequestSearch busca;	
                   try {
                       busca = (RequestSearch) message.getContentObject();
                       ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("DistanceAgent", AID.ISLOCALNAME));
                        msg.setContentObject(busca);
                        send(msg);
                        state = 1;
                    } catch (UnreadableException ex) {
                       Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                   }  
                   catch (IOException ep) {
                        System.out.println("Erro ao enviar mensagem: DistanceAgent -> AgenteBuscaRestaurante");
                    }
                }
            }
            @Override
            public int onEnd() {
                return state;
            }
        }, "X");
        
        behaviour.registerState(new CyclicBehaviour(this) {            
            private int state = 0;
            @Override
            public void action() {
                System.out.println("Executing behavour Y");
                MessageTemplate template = 
                     MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("interface"));				
                ACLMessage message = myAgent.receive(template);
                if (message != null) {
                   System.out.println("Recebeu uma mensagem REQUEST");
                   RequestSearch busca;	
                   try {
                       busca = (RequestSearch) message.getContentObject();
                       ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("ScoreAgent", AID.ISLOCALNAME));
                        msg.setContentObject(busca);
                        send(msg);
                        state = 1;
                    } catch (UnreadableException ex) {
                       Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                   }  
                   catch (IOException ep) {
                        System.out.println("Erro ao enviar mensagem: DistanceAgent -> AgenteBuscaRestaurante");
                    }
                }
            }
            @Override
            public int onEnd() {
                return state;
            }
        }, "Y");
        
        // adicionando o terceiro comportamento - Y
        behaviour.registerLastState(new CyclicBehaviour(this) {            
            @Override
            public void action() {
                System.out.println("Executing behavour Z");
                MessageTemplate template = 
                     MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("interface"));				
                ACLMessage message = myAgent.receive(template);
                if (message != null) {
                   System.out.println("Recebeu uma mensagem REQUEST");
                   RequestSearch busca;	
                   try {
                       busca = (RequestSearch) message.getContentObject();
                        ArrayList<Restaurant> restaurantes = busca.getRestaurantes();
                        Collections.sort (restaurantes, new Comparator() {
                            public int compare(Object o1, Object o2) {
                                Restaurant r1 = (Restaurant) o1;
                                Restaurant r2 = (Restaurant) o2;
                                if(r1.getPrice().length() < r2.getPrice().length() && Float.parseFloat(r1.getDistance()) < Float.parseFloat(r2.getDistance()) && r1.getScore().length() > r2.getScore().length()){
                                    return +1;
                                }
                                else if(r1.getPrice().length() < r2.getPrice().length() && Float.parseFloat(r1.getDistance()) < Float.parseFloat(r2.getDistance()) ){
                                    return +1;
                                }
                                else if(r1.getPrice().length() < r2.getPrice().length()){
                                    return +1;
                                }
                                else{
                                    return -1;
                                }                                
                            }
                        });                        
                       ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("GuiAgent", AID.ISLOCALNAME));
                        msg.setContentObject(busca);
                        send(msg);
                    } catch (UnreadableException ex) {
                       Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                   }  
                   catch (IOException ep) {
                        System.out.println("Erro ao enviar mensagem: DistanceAgent -> AgenteBuscaRestaurante");
                    }
                }
            }           
        }, "Z");
    }


}
