package shipwithdroid;

public class MainShip {

    public static void main(String[] args) {
        Ship<Droid> ship = new Ship();
        ship.put(new Droid("Alfa", "R2D2"));
        ship.put(new Droid("Beta", "C3PO"));
        ship.put(new Droid("3bot", "nexus"));
        System.out.println(ship.size());
        System.out.println(ship.get(0));
        System.out.println(ship.get(1));
        System.out.println(ship.get(2));
        System.out.println(ship.remove(2));
        System.out.println(ship.get(1));
        ship.put(new Droid("newRobot", "nexus6"));
        System.out.println(ship.get(2));
        System.out.println(3001);
    }
}
