package the.project.core.agents.distance;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.ArrayList;
import the.project.core.objects.Request;
import the.project.core.objects.RequestSearch;
import the.project.core.objects.Restaurant;

public class DistanceAgent extends Agent {

    @Override
    protected void setup() {

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Agente de distância craido.");
            }
        });

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage rec = myAgent.receive();
                if (rec != null) {
                    try {
                        RequestSearch req = (RequestSearch) rec.getContentObject();

                        Request preferencias = req.getPreferencias();
                        ArrayList<Restaurant> restaurantes = req.getRestaurantes();
                        for (Restaurant rest : restaurantes) {
                            if (Float.parseFloat(rest.getDistance()) < preferencias.getDistanceFrom() || 
                                    Float.parseFloat(rest.getDistance()) > preferencias.getDistanceTo()) {
                                restaurantes.remove(rest);
                            }
                        }
                        
                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("SearchAgent", AID.ISLOCALNAME));
                        msg.setContentObject(req);
                        send(msg);

                    } catch (UnreadableException e) {
                    } catch (IOException ex) {
                        System.out.println("Erro ao enviar mensagem: DistanceAgent -> AgenteBuscaRestaurante");
                    }
                } else {
                    block();
                }
            }
        });

    }

}