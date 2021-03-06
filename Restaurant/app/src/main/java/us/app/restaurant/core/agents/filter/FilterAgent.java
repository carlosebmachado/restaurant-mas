package us.app.restaurant.core.agents.filter;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.ArrayList;
import us.app.restaurant.core.objects.Request;
import us.app.restaurant.core.objects.RequestSearch;
import us.app.restaurant.core.objects.Restaurant;

public class FilterAgent extends Agent {

    @Override
    protected void setup() {

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Olá. Eu sou o " + getLocalName() + ".");
            }
        });

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage rec = receive();
                if (rec != null) {
                    System.out.println(getLocalName() + ": Recebi uma mensagem de " + rec.getSender().getLocalName() + ".");
                    String receiver = "SearchAgent";
                    try {
                        RequestSearch req = (RequestSearch) rec.getContentObject();

                        Request preferencias = req.getPreferencias();
                        ArrayList<Restaurant> restaurantes = req.getRestaurantes();
                        for (Restaurant rest : restaurantes) {
                            if (filter(rest, preferencias)) {
                                restaurantes.remove(rest);
                            }
                        }
                        
                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID(receiver, AID.ISLOCALNAME));
                        msg.setContentObject(req);
                        send(msg);
                        System.out.println(getLocalName() + ": Enviei uma mensagem para " + receiver + ".");

                    } catch (UnreadableException e) {
                    } catch (IOException e) {
                        System.out.println("Erro ao enviar mensagem: " + getLocalName() + " -> " + receiver + ". Erro: " + e.toString());
                    }
                } else {
                    block();
                }
            }
        });

    }
    
    protected boolean filter(Restaurant rest, Request preferencias) {
        return false;
    }

}
