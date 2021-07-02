import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Bus extends Vehicles {

    private boolean isEmpty;

    public Bus(BigDecimal fuelQuantity, BigDecimal fuelConsumptionL, BigDecimal tankCapacity) {
        super(fuelQuantity, fuelConsumptionL, tankCapacity);
        isEmpty = false;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

   /* @Override
    protected void setFuelConsumptionL(BigDecimal fuelConsumptionL){
        if(isEmpty){
            super.setFuelConsumptionL(fuelConsumptionL);
        }else {
            super.setFuelConsumptionL(fuelConsumptionL.add(BigDecimal.valueOf(1.4)));
        }
    }*/
@Override
    protected String driving(BigDecimal distance) {
        //DecimalFormat df = new DecimalFormat("0.00########")
        //String formatted = df.format(bigDecimal.stripTrailingZeros())
        NumberFormat formatter = new DecimalFormat("0.##");
        if (isEmpty) {
            return super.driving(distance);
        } else {
            this.setFuelConsumptionL(this.getFuelConsumptionL().add(BigDecimal.valueOf(1.4)));
            if (this.getFuelQuantity().compareTo(this.getFuelConsumptionL().multiply(distance)) > 0) {
                this.setFuelQuantity(this.getFuelQuantity().subtract(this.getFuelConsumptionL().multiply(distance)));
                return String.format("%s travelled %s km", this.getClass().getName(), formatter.format(distance));
            } else {
                return String.format("%s needs refueling", this.getClass().getName());
            }
        }
    }
    @Override
    public String toString(){
        return String.format("Bus: %.2f", getFuelQuantity());
    }
}
