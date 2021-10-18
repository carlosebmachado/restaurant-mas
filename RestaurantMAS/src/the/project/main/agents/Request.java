package the.project.main.agents;

public class Request {
    
    private String type;
    private float priceFrom;
    private float priceTo;
    private float distanceFrom;
    private float distanceTo;
    private String score;

    public Request(String type, float priceFrom, float priceTo, float distanceFrom, float distanceTo, String score) {
        this.type = type;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.distanceFrom = distanceFrom;
        this.distanceTo = distanceTo;
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(float priceFrom) {
        this.priceFrom = priceFrom;
    }

    public float getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(float priceTo) {
        this.priceTo = priceTo;
    }

    public float getDistanceFrom() {
        return distanceFrom;
    }

    public void setDistanceFrom(float distanceFrom) {
        this.distanceFrom = distanceFrom;
    }

    public float getDistanceTo() {
        return distanceTo;
    }

    public void setDistanceTo(float distanceTo) {
        this.distanceTo = distanceTo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
}
