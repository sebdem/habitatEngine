package habitat.data;

public class FTriplet {
    float v1;
    float v2;
    float v3;

    public FTriplet(float v1, float v2, float v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public static FTriplet zero(){
        return new FTriplet(0,0,0);
    }

    public float getV1() {
        return v1;
    }

    public float getV2() {
        return v2;
    }

    public float getV3() {
        return v3;
    }

    public FTriplet setV1(float v1) {
        this.v1 = v1;
        return this;
    }

    public FTriplet setV2(float v2) {
        this.v2 = v2;
        return this;
    }

    public FTriplet setV3(float v3) {
        this.v3 = v3;
        return this;
    }


    public float[] toArray(){
        return new float[]{v1,v2,v3};
    }
}
