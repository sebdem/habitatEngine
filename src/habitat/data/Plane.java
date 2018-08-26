package habitat.data;

public class Plane{
    private FTriplet position;

    private FTriplet xVec;
    private FTriplet yVec;

    public Plane(FTriplet position, FTriplet xVec, FTriplet yVec) {
        this.position = position;
        this.xVec = xVec;
        this.yVec = yVec;
    }
}
