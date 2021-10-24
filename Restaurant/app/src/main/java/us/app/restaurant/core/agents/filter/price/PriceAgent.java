package us.app.restaurant.core.agents.filter.price;

import us.app.restaurant.core.agents.filter.FilterAgent;
import us.app.restaurant.core.objects.Request;
import us.app.restaurant.core.objects.Restaurant;

public class PriceAgent extends FilterAgent {
    
    @Override
    protected boolean filter(Restaurant rest, Request preferencias) {
        return !rest.getPrice().equalsIgnoreCase(preferencias.getPrice());
    }

}
