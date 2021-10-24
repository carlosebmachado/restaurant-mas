package us.app.restaurant.core.agents.filter.distance;

import us.app.restaurant.core.agents.filter.FilterAgent;
import us.app.restaurant.core.objects.Request;
import us.app.restaurant.core.objects.Restaurant;

public class DistanceAgent extends FilterAgent {
    
    @Override
    protected boolean filter(Restaurant rest, Request preferencias) {
        return Float.parseFloat(rest.getDistance()) < preferencias.getDistanceFrom() || 
               Float.parseFloat(rest.getDistance()) > preferencias.getDistanceTo();
    }

}
