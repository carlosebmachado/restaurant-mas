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
import the.project.core.objects.RequestSearch;
import the.project.core.objects.Restaurant;

public class AgenteBuscaRestaurante extends Agent {

    @Override
    protected void setup() {
        //Constroi o behaviour
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Olá. Eu sou o " + getLocalName() + ".");
            }
        });

        //addBehaviour(new BehaviourBusca());
        FSMBehaviour behaviour = new FSMBehaviour(this) {
            @Override
            public int onEnd() {
                System.out.println(getLocalName() + ": Terminei minha FSM.");
                return 0;
            }
        };

        behaviour.registerFirstState(new BehaviourBusca(), "V");

        behaviour.registerState(new CyclicBehaviour(this) {
            private int state = 0;

            @Override
            public void action() {
                System.out.println(getLocalName() + ": Comportamento W");
                MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
                ACLMessage message = myAgent.receive(template);
                if (message != null) {
                    System.out.println(getLocalName() + ": Recebi uma mensagem de " + message.getSender().getLocalName() + ".");
                    RequestSearch busca;
                    try {
                        busca = (RequestSearch) message.getContentObject();
                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("PriceAgent", AID.ISLOCALNAME));
                        msg.setContentObject(busca);
                        send(msg);
                        System.out.println(getLocalName() + ": Enviei uma mensagem para PriceAgent.\n");
                        state = 1;
                    } catch (UnreadableException ex) {
                        Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ep) {
                        System.out.println("Erro ao enviar mensagem: " + getLocalName() + " -> PriceAgent. Erro: " + ep.toString());
                    }
                } else {
                    block();
                }
            }

            @Override
            public int onEnd() {
                System.out.println("onEnd state W: " + state);
                return state;
            }
        }, "W");

        behaviour.registerState(new CyclicBehaviour(this) {
            private int state = 0;

            @Override
            public void action() {
                System.out.println(getLocalName() + ": Comportamento X");
                MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
                ACLMessage message = myAgent.receive(template);
                if (message != null) {
                    System.out.println(getLocalName() + ": Recebi uma mensagem de " + message.getSender().getLocalName() + ".");
                    RequestSearch busca;
                    try {
                        busca = (RequestSearch) message.getContentObject();
                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("DistanceAgent", AID.ISLOCALNAME));
                        msg.setContentObject(busca);
                        send(msg);
                        System.out.println(getLocalName() + ": Enviei uma mensagem para DistanceAgent.\n");
                        state = 1;
                    } catch (UnreadableException ex) {
                        Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ep) {
                        System.out.println("Erro ao enviar mensagem: " + getLocalName() + " -> DistanceAgent. Erro: " + ep.toString());
                    }
                } else {
                    block();
                }
            }

            @Override
            public int onEnd() {
                System.out.println("onEnd state X: " + state);
                return state;
            }
        }, "X");

        behaviour.registerState(new CyclicBehaviour(this) {
            private int state = 0;

            @Override
            public void action() {
                System.out.println(getLocalName() + ": Comportamento Y");
                MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
                ACLMessage message = myAgent.receive(template);
                if (message != null) {
                    System.out.println(getLocalName() + ": Recebi uma mensagem de " + message.getSender().getLocalName() + ".");
                    RequestSearch busca;
                    try {
                        busca = (RequestSearch) message.getContentObject();
                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("ScoreAgent", AID.ISLOCALNAME));
                        msg.setContentObject(busca);
                        send(msg);
                        System.out.println(getLocalName() + ": Enviei uma mensagem para ScoreAgent.\n");
                        state = 1;
                    } catch (UnreadableException ex) {
                        Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ep) {
                        System.out.println("Erro ao enviar mensagem: " + getLocalName() + " -> ScoreAgent. Erro: " + ep.toString());
                    }
                } else {
                    block();
                }
            }

            @Override
            public int onEnd() {
                System.out.println("onEnd state Y: " + state);
                return state;
            }
        }, "Y");

        behaviour.registerLastState(new CyclicBehaviour(this) {
            @Override
            public void action() {
                System.out.println(getLocalName() + ": Comportamento Z");
                MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
                ACLMessage message = myAgent.receive(template);
                if (message != null) {
                    System.out.println(getLocalName() + ": Recebi uma mensagem de " + message.getSender().getLocalName() + ".");
                    RequestSearch busca;
                    try {
                        busca = (RequestSearch) message.getContentObject();
                        ArrayList<Restaurant> restaurantes = busca.getRestaurantes();
                        Collections.sort(restaurantes, (Object o1, Object o2) -> {
                            Restaurant r1 = (Restaurant) o1;
                            Restaurant r2 = (Restaurant) o2;
                            if (r1.getPrice().length() < r2.getPrice().length() && Float.parseFloat(r1.getDistance()) < Float.parseFloat(r2.getDistance()) && r1.getScore().length() > r2.getScore().length()) {
                                return +1;
                            } else if (r1.getPrice().length() < r2.getPrice().length() && Float.parseFloat(r1.getDistance()) < Float.parseFloat(r2.getDistance())) {
                                return +1;
                            } else if (r1.getPrice().length() < r2.getPrice().length()) {
                                return +1;
                            } else {
                                return -1;
                            }
                        });
                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("GuiAgent", AID.ISLOCALNAME));
                        msg.setContentObject(busca);
                        send(msg);
                        System.out.println(getLocalName() + ": Enviei uma mensagem para GuiAgent.\n");
                    } catch (UnreadableException ex) {
                        Logger.getLogger(AgenteBuscaRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ep) {
                        System.out.println("Erro ao enviar mensagem: " + getLocalName() + " -> GuiAgent. Erro: " + ep.toString());
                    }
                } else {
                    block();
                }
            }
        }, "Z");

        behaviour.registerDefaultTransition("V", "V", new String[]{"V"});
        behaviour.registerTransition("V", "W", 1);
        behaviour.registerDefaultTransition("W", "W", new String[]{"W"});
        behaviour.registerTransition("W", "X", 1);
        behaviour.registerDefaultTransition("X", "X", new String[]{"X"});
        behaviour.registerTransition("X", "Y", 1);
        behaviour.registerDefaultTransition("Y", "Y", new String[]{"Y"});
        behaviour.registerTransition("Y", "Z", 1);

        addBehaviour(behaviour);
    }

}
