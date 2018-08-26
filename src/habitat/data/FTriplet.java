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

    // i get the feeling those two methods will help a lot, especially when rendering
    public static FTriplet zero(){
        return new FTriplet(0,0,0);
    }
    public static FTriplet one(){
        return new FTriplet(1,1,1);
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

    // all calculation methods return a NEW instance of FTriplets
    public <E extends FTriplet> FTriplet add(E other) {
        return new FTriplet( getV1()+other.getV1(),getV2()+other.getV2(),getV3()+other.getV3());
    }
    public <E extends FTriplet> FTriplet substract(E other) {
        return new FTriplet( getV1()-other.getV1(),getV2()-other.getV2(),getV3()-other.getV3());
    }

    public <E extends FTriplet> FTriplet multiply(E other) {
        return new FTriplet( getV1()*other.getV1(),getV2()*other.getV2(),getV3()*other.getV3());
    }
    public <E extends FTriplet> FTriplet multiply(float factor) {
        return new FTriplet( getV1()*factor,getV2()*factor,getV3()*factor);
    }
    public <E extends FTriplet> FTriplet divide(float factor) {
        return new FTriplet( getV1()/factor,getV2()/factor,getV3()/factor);
    }
}
