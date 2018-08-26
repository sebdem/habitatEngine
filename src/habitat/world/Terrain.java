package habitat.world;

import habitat.data.FTriplet;
import habitat.data.Plane;

public class Terrain extends Plane {


    private FTriplet[] planeData;

    public Terrain(FTriplet position, FTriplet xVec, FTriplet yVec) {
        super(position, xVec, yVec);
    }

}
