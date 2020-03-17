package task.model;

public class TTC {
    private Carry carry;
    private int sightingRange;
    private boolean clamp;
    private boolean optics;

    public TTC(Carry carry, int sightingRange, boolean clamp, boolean optics) {
        this.carry = carry;
        this.sightingRange = sightingRange;
        this.clamp = clamp;
        this.optics = optics;
    }

    public TTC() {
    }

    public Carry getCarry() {
        return carry;
    }

    public void setCarry(Carry carry) {
        this.carry = carry;
    }

    public int getSightingRange() {
        return sightingRange;
    }

    public void setSightingRange(int sightingRange) {
        this.sightingRange = sightingRange;
    }

    public boolean isClamp() {
        return clamp;
    }

    public void setClamp(boolean clamp) {
        this.clamp = clamp;
    }

    public boolean isOptics() {
        return optics;
    }

    public void setOptics(boolean optics) {
        this.optics = optics;
    }
}
