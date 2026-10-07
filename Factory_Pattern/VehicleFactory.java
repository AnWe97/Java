package Factory_Pattern;

public class VehicleFactory {

    public Vehicle getVehicle(String vehicleType){

        if (vehicleType.equalsIgnoreCase("CAR")){
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("MOTORCYCLE")) {
            return new Motorcycle();
        }else{
            return null;
        }
    }

}

interface Vehicle{

    void move();

}

class Car implements Vehicle{

    @Override
    public void move(){
        System.out.println("Das Auto fährt.");
    }

}

class Motorcycle implements Vehicle{

    @Override
    public void move(){
        System.out.println("Das Motorrad fährt.");
    }

}

