/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.main.agents.gui.AgenteBuscaRestaurante;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
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
public class AgenteBuscaRestaurante extends Agent {
    

    @Override
    protected void setup(){
        //Constroi o behaviour
		addBehaviour(new OneShotBehaviour() {			
			@Override
			public void action() {
				System.out.println("Novo agente Busca Restaurante criado!!");
			}
		});
       addBehaviour(new BehaviourBusca());
    }

    void filtrarestaurantes(RequestSearch busca) {
        //filtrar restaurantes
    }
    

    

    
}
