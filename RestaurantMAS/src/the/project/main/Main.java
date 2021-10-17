package the.project.main;

public class Main {
    
    public static void main(String[] args) {
        // coloquei os argumentos em código para facilitar na inicialização
        // o seguindo argumento é para a criação do agente inicial
        String [] a = { 
            "-gui",
            "GuiAgent:the.project.core.agents.gui.GuiAgent;" +
            "SearchAgent:the.project.core.agents.search.AgenteBuscaRestaurante"};
        jade.Boot.main(a);
    }
    
}
