/*import Exercises.Container;
import Exercises.RoRo;
import Exercises.Tankers;
import Exercises.Vessel;
*/
public class PortfolieOneJacobTest {

    public static void main(String[] args) {
        Tankers tankersVessel = new Tankers("Norge", "Tanker",25, 100, 40, 10);
        Container containerVessel = new Container("Somalia", "Container",1, 5, 2, 25);
        RoRo roRoVessel = new RoRo("Finland", "RoRo",50, 150, 60, 150 );

        tankersVessel.loadingCargo(5);
        tankersVessel.utilitylevelofCapacity();
        containerVessel.loadingCargo(23);
        containerVessel.utilitylevelofCapacity();
        roRoVessel.loadingCargo(8);
        roRoVessel.utilitylevelofCapacity();


    }

}

abstract class Vessel {
    String flagNation;
    String vesselType;
    int draft;
    int length;
    int width;
    int maxCap;


    public Vessel(String flagNation, String vesselType, int draft, int length, int width, int maxCap) {
        this.flagNation = flagNation;
        this.vesselType = vesselType;
        this.draft = draft;
        this.length = length;
        this.width = width;
        this.maxCap = maxCap;

    }

    abstract void loadingCargo(int maxCap); // Ved at lave denne abstract metode sikrer vi, at alle subclasses af Vessel anvender denne

    abstract void utilitylevelofCapacity();

    double reduce(double n1, double n2){ //Bruger modulus, til at finde laveste tal de to tal går op i
        if (n2== 0){
            return n1;
        }
        return reduce(n2, n1 % n2);

    }


}

class Container extends Vessel {
    int containerAmount;

    public Container(String flagNation, String vesselType, int draft, int length, int width, int maxCap) {
        super(flagNation, vesselType, draft, length, width, maxCap);

    }


    public void loadingCargo(int containers){
        if (containers > this.maxCap){
            System.out.println("The maximum amount of countainers is " + this.maxCap + "Vessel is therefore only loaded with this amount of containers" + this.maxCap);
            containerAmount = this.maxCap;
        } else if (containers <= 0 )
        {
            System.out.println("Cannot load " + containers + "Please load an approiate load");
        }
        else {
            this.containerAmount = containers;
        }

    }

    public void utilitylevelofCapacity() {
        System.out.println("The container vessel is filled with " + this.containerAmount + "/" + maxCap);
        System.out.println(super.reduce(32,4));
    }

}

class Tankers extends Vessel {
    int compartmentsAmount;
    public Tankers(String flagNation, String vesselType, int draft, int length, int width, int maxCap) {
        super(flagNation, vesselType, draft, length, width, maxCap);

    }

    public void loadingCargo( int compartments){
        if (compartments > this.maxCap){
            System.out.println("The maximum amount of compartments is " + this.maxCap + "Vessel is therefore only loaded with this amount of compartments" + this.maxCap);
            compartmentsAmount = this.maxCap;
        } else if (compartments <= 0 )
        {
            System.out.println("Cannot load " + compartmentsAmount + "Please load an approiate load");
        }
        else {
            this.compartmentsAmount = compartments;
        }
    }

    public void utilitylevelofCapacity() {
        System.out.println("The container vessel is filled with " + this.compartmentsAmount + "/" + maxCap);
    }


}

class RoRo extends Vessel {
    double carLength = 8;
    double truckLength = 30;

    public RoRo(String flagNation, String vesselType, int draft, int length, int width, int maxCap) {
        super(flagNation, vesselType, draft, length, width, maxCap);

    }

    public void loadingCargo(int vehicles) {
        this.carLength = vehicles;
        System.out.println("Carlength on ship: " + (carLength * 3) + ". Trucklength on ship: " + truckLength * 3
                + ". Total amout of cargo length: " + (carLength * 3 + truckLength * 3 + "."));
    }

    public void utilitylevelofCapacity() {
        System.out.println("Total ship length: " + length + ". Fraction of cargo space left: "
                + (carLength * 3 + truckLength * 3 / length) + "%");
    }
}
