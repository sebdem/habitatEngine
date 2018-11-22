package habitat.data.models;

import habitat.data.FTriplet;
import habitat.data.HColor;

public class ModelMaterial {

    public final static FTriplet GLOSS_MATT = FTriplet.zero();
    public final static FTriplet GLOSS_SHINE = FTriplet.one();


    private FTriplet glossiness; // how does light react to this material
    private FTriplet glow; //
    private HColor color; // the color of this material

    /**
     * Creates a matt gray material
     */
    public ModelMaterial(){
        glossiness = GLOSS_MATT;
        glow = FTriplet.zero();
        color = new HColor(0.5f, 0.5f,0.5f);
    }
}
