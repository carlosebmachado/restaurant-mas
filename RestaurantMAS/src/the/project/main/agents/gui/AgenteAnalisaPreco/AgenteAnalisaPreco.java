/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.project.main.agents.gui.AgenteAnalisaPreco;


import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import objects.Restaurante;

/**
 *
 * @author JF
 */
public class AgenteAnalisaPreco extends Agent {
    
    private boolean greeting = true;

    @Override
    protected void setup(){
        addBehaviour(new OneShotBehaviour() {			
			@Override
			public void action() {
				System.out.println("Novo agente Busca Restaurante criado!!");
			}
		});
       addBehaviour(new BehaviourNalisaPreco());
    }

    

    public Restaurante filtraPreco(Restaurante rest) {
        //pesqusia dentro do retaurante os preços desejados, caso não atenda o preço retorna nulo
        return null;
    }

    
}
