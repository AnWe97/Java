package Factory_Pattern;

public class Main {

    public static void main(String[] args){

        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle car = vehicleFactory.getVehicle("CAR");
        Vehicle motorcycle = vehicleFactory.getVehicle("MOTORCYCLE");

        car.move();
        motorcycle.move();
    }
}
