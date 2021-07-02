import java.math.BigDecimal;

public class Car extends Vehicles {


    public Car(BigDecimal fuelQuantity, BigDecimal fuelConsumptionL, BigDecimal tankCapacity) {
        super(fuelQuantity, fuelConsumptionL, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionL(BigDecimal fuelConsumptionL){
        super.setFuelConsumptionL(fuelConsumptionL.add(BigDecimal.valueOf(0.9)));
    }

    @Override
    public String toString(){
        return String.format("Car: %.2f", getFuelQuantity());
    }

}



 /*
    //+	brakes() : String
    //+	gas() : String

    public  String brakes();
    public String gas();
}*/
