/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.main.agents.gui.AnalisaDistancia;

import the.project.main.agents.gui.AgenteBuscaRestaurante.*;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.ArrayList;
import objects.RequestSearch;
import objects.Restaurante;

/**
 *
 * @author JF
 */
public class AgenteAnalisaDistancia extends Agent {
    
    private boolean greeting = true;

    @Override
    protected void setup(){
        addBehaviour(new OneShotBehaviour() {			
			@Override
			public void action() {
				System.out.println("Novo agente Busca Restaurante criado!!");
			}
		});
       addBehaviour(new BehaviouAnalisaDistancia());
    }

    

    public RequestSearch filtraDistancia(RequestSearch busca) {
        //filtra a distancia do restaurante conforme as preferencias do usuário e a distancia do usuário para cada bairro;
        String[][] preferencias = busca.getPreferencias();
        ArrayList<Restaurante> restaurantes = busca.getRestaurantes();
        ArrayList<Restaurante> filterRest = new ArrayList<>();
        for(Restaurante rest: restaurantes){
            if(Integer.parseInt(rest.distancia )<= Integer.parseInt(preferencias[2][2]) ){
                filterRest.add(rest);
            }
        }
        if(!filterRest.isEmpty()){
            busca.setRestaurantes(filterRest);
        }
        
        return busca;
    }

    
}
