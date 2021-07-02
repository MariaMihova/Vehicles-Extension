import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class Vehicles {
    private BigDecimal fuelQuantity;
    private BigDecimal fuelConsumptionL;
    private BigDecimal tankCapacity;

    protected Vehicles(BigDecimal fuelQuantity, BigDecimal fuelConsumptionL, BigDecimal tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionL(fuelConsumptionL);
        this.setTankCapacity(tankCapacity);

    }

    protected void setTankCapacity(BigDecimal tankCapacity){
        if(validate(tankCapacity)){
            this.tankCapacity = tankCapacity;
        } else{
            throw new IllegalArgumentException("Tank capacity must br a positive number");
        }
    }


    public BigDecimal getTankCapacity() {
        return tankCapacity;
    }

    protected void setFuelQuantity(BigDecimal fuelQuantity) {
        if(validate(fuelQuantity)) {
            this.fuelQuantity = fuelQuantity;
        }else {
           throw  new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    public BigDecimal getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelConsumptionL(BigDecimal fuelConsumptionL) {
        if(validate(fuelConsumptionL)) {
            this.fuelConsumptionL = fuelConsumptionL;
        }else {
            throw  new IllegalArgumentException("Fuel consumption must be a positive number");
        }
    }

    public BigDecimal getFuelConsumptionL() {
        return fuelConsumptionL;
    }


    protected String driving(BigDecimal distance){
        //DecimalFormat df = new DecimalFormat("0.00########")
        //String formatted = df.format(bigDecimal.stripTrailingZeros())
        NumberFormat formatter = new DecimalFormat("0.##");
        if(fuelQuantity.compareTo(fuelConsumptionL.multiply(distance)) > 0){
            this.setFuelQuantity(this.getFuelQuantity().subtract(fuelConsumptionL.multiply(distance)));
            return String.format("%s travelled %s km", this.getClass().getName(), formatter.format(distance));
        }
        return String.format("%s needs refueling", this.getClass().getName());
    }

    protected void refueling(BigDecimal refuelL){
        if(validate(refuelL)) {
            if (this.fuelQuantity.add(refuelL).compareTo(this.getTankCapacity()) > 0) {
                throw new IllegalArgumentException("Cannot fit fuel in tank");
            }
            this.setFuelQuantity(this.fuelQuantity.add(refuelL));
        }else {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    protected boolean validate(BigDecimal number){
        if(number.compareTo(new BigDecimal("0.00")) > 0) {
            return true;
        }
        return false;
    }
}
