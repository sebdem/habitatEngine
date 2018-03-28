package habitat.util;

import java.util.Random;

public class HMath {

    private static final Random RANDOM_GEN_1 = new java.util.Random();
    private static final Random RANDOM_GEN_2 = new java.util.Random();

    public static float fRandom(){
        return (float)((RANDOM_GEN_1.nextFloat() + RANDOM_GEN_2.nextFloat()) / 2.0f);
    }

    public static float fRandom(float lower, float upper){
        return lower + (upper - lower) * fRandom();
    }

    /**
     * Generates a float between 0 and upper
     * @param upper Needs to be positiv
     * @return
     */
    public static float fRandom(float upper){
        return fRandom(0, upper);
    }
}
