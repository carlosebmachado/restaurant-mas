package the.project.core.agents.filter;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import the.project.core.objects.Request;
import the.project.core.objects.RequestSearch;
import the.project.core.objects.Restaurant;

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
                        System.out.println("Chega aqui2");  
                        RequestSearch req = (RequestSearch) rec.getContentObject();                        
                        Request preferencias = req.getPreferencias();                        
                        ArrayList<Restaurant> restaurantes = req.getRestaurantes();
                        ArrayList<Restaurant> filter_restaurantes = new ArrayList<>();
                                       
                        for (Iterator<Restaurant> it = restaurantes.iterator(); it.hasNext();) {
                               Restaurant rest = it.next();
                               if (filter(rest, preferencias)) {
                                  filter_restaurantes.add(rest);
                               }
                           }
                        req.setRestaurantes(filter_restaurantes);                       
                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID(receiver, AID.ISLOCALNAME));
                        msg.setContentObject(req);
                        send(msg);
                        System.out.println(getLocalName() + ": Enviei uma mensagem para " + receiver + ".");

                    } catch (UnreadableException e) {
                        System.out.println("Erro: " + getLocalName() + " -> " + receiver + ". Erro: " + e.toString());
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
