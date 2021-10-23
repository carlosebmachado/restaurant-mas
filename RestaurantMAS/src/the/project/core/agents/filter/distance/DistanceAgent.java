package the.project.core.agents.filter.distance;

import the.project.core.agents.filter.FilterAgent;
import the.project.core.objects.Request;
import the.project.core.objects.Restaurant;

public class DistanceAgent extends FilterAgent {
    
    @Override
    protected boolean filter(Restaurant rest, Request preferencias) {
        return Float.parseFloat(rest.getDistance()) < preferencias.getDistanceFrom() || 
               Float.parseFloat(rest.getDistance()) > preferencias.getDistanceTo();
    }

}
