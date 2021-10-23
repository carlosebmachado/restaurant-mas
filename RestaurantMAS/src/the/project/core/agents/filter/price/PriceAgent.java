package the.project.core.agents.filter.price;

import the.project.core.agents.filter.FilterAgent;
import the.project.core.objects.Request;
import the.project.core.objects.Restaurant;

public class PriceAgent extends FilterAgent {
    
    @Override
    protected boolean filter(Restaurant rest, Request preferencias) {
        return !rest.getPrice().equalsIgnoreCase(preferencias.getPrice());
    }

}
