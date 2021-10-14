/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.main.agents.gui.AgenteAnalisaScore;


import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.ArrayList;



/**
 *
 * @author JF
 */
public class AgenteAnalisaScore extends Agent {
    
    private boolean greeting = true;

    @Override
    protected void setup(){
        addBehaviour(new OneShotBehaviour() {			
			@Override
			public void action() {
				System.out.println("Novo agente Busca Restaurante criado!!");
			}
		});
        addBehaviour(new BehaviourAnalisaScore());
    }

    

    public ArrayList filtraScore(ArrayList restaurantes) {
        /// filtra pelo score, caso não atenda retira o restaurante da lista.
        return restaurantes;
    }

    
}
