package the.project.core.agents.filter.score;

import the.project.core.agents.filter.FilterAgent;
import the.project.core.objects.Request;
import the.project.core.objects.Restaurant;

public class ScoreAgent extends FilterAgent {
    
    @Override
    protected boolean filter(Restaurant rest, Request preferencias) {
        return !rest.getScore().equalsIgnoreCase(preferencias.getPrice());
    }

}
