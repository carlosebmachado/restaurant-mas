package us.app.restaurant.core.agents.gui;

import jade.core.*;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.ArrayList;

import us.app.restaurant.core.data.RestaurantData;
import us.app.restaurant.core.objects.Request;
import us.app.restaurant.core.objects.RequestSearch;
import us.app.restaurant.core.objects.Restaurant;

public class GuiAgent extends Agent {

    private ArrayList<Restaurant> restaurants;
    private boolean ready;

    @Override
    protected void setup(){

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
                String receiver = "SearchAgent";
                if (rec != null) {
                    System.out.println(getLocalName() + ": Recebi uma mensagem de " + rec.getSender().getLocalName() + ".");
                    try {
                        Request req = (Request) rec.getContentObject();
                        ArrayList<Restaurant> restaurantes = new ArrayList<>();
                        for(Restaurant rest : RestaurantData.data){
                             restaurantes.add(rest);
                        }
                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID(receiver, AID.ISLOCALNAME));
                        msg.setContentObject(new RequestSearch(restaurantes,req));
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
        
        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println(getLocalName() + ": Recebi uma mensagem de " + msg.getSender().getLocalName() + ".");
                    try {
                        RequestSearch req = (RequestSearch) msg.getContentObject();

                        restaurants = req.getRestaurantes();
                        
                        System.out.println(getLocalName() + ": Entreguei as informações requisitadas pelo Usuário.");
                        
                    } catch (UnreadableException e) {}
                } else {
                    block();
                }
            }
        });
        
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

}
