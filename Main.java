
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Car {fuel quantity} {liters per km}"
        String[] carInfo = scanner.nextLine().split("\\s+");
       Car car = new Car(BigDecimal.valueOf(Double.parseDouble(carInfo[1])),
               BigDecimal.valueOf(Double.parseDouble(carInfo[2])),
               BigDecimal.valueOf(Double.parseDouble(carInfo[3])));
        //Truck {fuel quantity} {liters per km}
        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(BigDecimal.valueOf(Double.parseDouble(truckInfo[1])),
                BigDecimal.valueOf(Double.parseDouble(truckInfo[2]))
        ,BigDecimal.valueOf(Double.parseDouble(truckInfo[3])));
        //Vehicle {initial fuel quantity} {liters per km} {tank capacity}
        String[] busInfo = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(BigDecimal.valueOf(Double.parseDouble(busInfo[1])),
                BigDecimal.valueOf(Double.parseDouble(busInfo[2]))
                ,BigDecimal.valueOf(Double.parseDouble(busInfo[3])));

        int numberCommands = Integer.parseInt(scanner.nextLine());

        while (numberCommands-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            try {
                switch (command[0]) {
                    case "Drive":
                        BigDecimal distance = BigDecimal.valueOf(Double.parseDouble(command[2]));
                        if (command[1].equals("Car")) {
                            System.out.println(car.driving(distance));
                        } else if (command[1].equals("Truck")) {
                            System.out.println(truck.driving(distance));
                        } else if (command[1].equals("Bus")) {
                            System.out.println(bus.driving(distance));
                        }
                        break;
                    case "Refuel":
                        BigDecimal litersFuel = BigDecimal.valueOf(Double.parseDouble(command[2]));

                        if (command[1].equals("Car")) {
                            car.refueling(litersFuel);
                        } else if (command[1].equals("Truck")) {
                            truck.refueling(litersFuel);
                        } else if(command[1].equals("Bus")){
                            bus.refueling(litersFuel);
                        }
                        break;
                    case "DriveEmpty":
                        bus.setIsEmpty(true);
                        System.out.println(bus.driving(BigDecimal.valueOf(Double.parseDouble(command[2]))));
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());

    }

}
