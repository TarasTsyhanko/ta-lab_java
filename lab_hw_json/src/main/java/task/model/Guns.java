package task.model;

public class Guns {
    private String model;
    private Handy handy;
    private Origin origin;
    private TTC ttc;
    private Material material;

    public Guns(String model, Handy handy, Origin origin, TTC ttc, Material material) {
        this.model = model;
        this.handy = handy;
        this.origin = origin;
        this.ttc = ttc;
        this.material = material;
    }

    public Guns() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Handy getHandy() {
        return handy;
    }

    public void setHandy(Handy handy) {
        this.handy = handy;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public TTC getTtc() {
        return ttc;
    }

    public void setTtc(TTC ttc) {
        this.ttc = ttc;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
