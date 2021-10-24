package us.app.restaurant.core.agents.filter.score;

import us.app.restaurant.core.agents.filter.FilterAgent;
import us.app.restaurant.core.objects.Request;
import us.app.restaurant.core.objects.Restaurant;

public class ScoreAgent extends FilterAgent {
    
    @Override
    protected boolean filter(Restaurant rest, Request preferencias) {
        return !rest.getScore().equalsIgnoreCase(preferencias.getPrice());
    }

}
