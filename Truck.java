import java.math.BigDecimal;

public class Truck extends Vehicles{

    public Truck(BigDecimal fuelQuantity, BigDecimal fuelConsumptionL, BigDecimal tankCapacity) {
        super(fuelQuantity, fuelConsumptionL, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionL(BigDecimal fuelConsumptionL){
        super.setFuelConsumptionL(fuelConsumptionL.add(BigDecimal.valueOf(1.6)));
    }
    @Override
    protected void refueling(BigDecimal refuelL){
        if(super.validate(refuelL)) {
            if((this.getFuelQuantity().add(refuelL)).compareTo(this.getTankCapacity()) > 0) {
                throw new IllegalArgumentException("Cannot fit fuel in tank");
            }
            this.setFuelQuantity(this.getFuelQuantity().add((refuelL.multiply(BigDecimal.valueOf(0.95)))));

        }else {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    @Override
    public String toString(){
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
