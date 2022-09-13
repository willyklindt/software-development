public class PortfolieOne {

    public static void main(String[] args) {
        Tankers tankersVessel = new Tankers("Norge", 25, 100, 40, 30);
        Container containerVessel = new Container("Somalia", 1, 5, 2, 1);
        RoRo roRoVessel = new RoRo("Finland", 50, 150, 60, 6);

        tankersVessel.loadingCargo();
        containerVessel.loadingCargo();
        roRoVessel.loadingCargo();
        roRoVessel.utilitylevelofCapacity();
    }

}

class Vessel {
    String flagNation;
    int draft;
    int length;
    int width;
    int cargo;

    public Vessel(String flagNation, int draft, int length, int width, int cargo) {
        this.flagNation = flagNation;
        this.draft = draft;
        this.length = length;
        this.width = width;
        this.cargo = cargo;
    }
}

class Container extends Vessel {

    public Container(String flagNation, int draft, int length, int width, int cargo) {
        super(flagNation, draft, length, width, cargo);
    }

    public void loadingCargo() {
        System.out.println("Container cargo amount: " + cargo);

    }
}

class Tankers extends Vessel {

    public Tankers(String flagNation, int draft, int length, int width, int cargo) {
        super(flagNation, draft, length, width, cargo);

    }

    public void loadingCargo() {
        System.out.println("Tankers cargo amount: " + cargo);
    }
}

class RoRo extends Vessel {
    int carLength = 8;
    int truckLength = 30;

    public RoRo(String flagNation, int draft, int length, int width, int cargo) {
        super(flagNation, draft, length, width, cargo);

    }

    public void loadingCargo() {
        System.out.println("RoRo cargo amount: " + cargo);
        System.out.println("Carlength on ship: " + (carLength * 3) + ". Trucklength on ship: " + truckLength * 3
                + ". Total amout of cargo length: " + (carLength * 3 + truckLength * 3));
    }

    public void utilitylevelofCapacity() {
        System.out.println("Total ship length: " + length + ". Fraction of cargo space left: "
                + (carLength * 3) + (truckLength * 3) / length + "%");
    }
}
