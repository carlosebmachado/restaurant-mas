package the.project.main;

public class Main {
    
    public static void main(String[] args) {
        // coloquei os argumentos em código para facilitar na inicialização
        // o seguindo argumento é para a criação do agente inicial
        String [] a = { 
            "-gui",
            "GuiAgent:the.project.core.agents.gui.GuiAgent;" +
            "SearchAgent:the.project.core.agents.search.AgenteBuscaRestaurante;" +
            "ScoreAgent:the.project.core.agents.filter.score.ScoreAgent;" +
            "PriceAgent:the.project.core.agents.filter.price.PriceAgent;" +
            "DistanceAgent:the.project.core.agents.filter.distance.DistanceAgent"};
        jade.Boot.main(a);
    }
    
}
