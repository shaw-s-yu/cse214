import java.util.Scanner;
public class TestDrive{
    public static double fuelEfficiency;
    public static double fuelAmount;
    public static double distance;
    public static double traveled;
    public static Scanner reader=new Scanner(System.in);
    
    public static void askForFuelE(){
        System.out.println("Enter Fuel Efficiency: ");
        double fuelE=reader.nextDouble();
        fuelEfficiency=fuelE;
    }
    public static void askForAmount(){
        System.out.println("Enter Amount of Fuel: ");
        double fuelA=reader.nextDouble();
        fuelAmount=fuelA;
    }
    public static void askForAdd(){
        System.out.println("Enter Fuel to Add: ");
        double fuelA=reader.nextDouble();
        fuelAmount=fuelA;
    }
    public static void askForDistance(){
        System.out.println("Enter Distance to Travel: ");
        double d=reader.nextDouble();
        distance=d;
    }
    public static void report(Car u){
        System.out.println("Miles Travelled: "+Double.toString(traveled));
        System.out.println("Current Fuel Level: "+Double.toString(u.getFuelLevel()));
        System.out.println("Current Odometer Reading: "+Double.toString(u.getOdometer()));
    }
    public static void newDrive(){
        
    }
    public  static void main( String[] args)
    {
        TestDrive a=new TestDrive();
        while(true){
            a.askForFuelE();
            if(a.fuelEfficiency==0){break;}
            Car user=new Car(a.fuelEfficiency);
            a.askForAmount();
            user.addFuel(a.fuelAmount);
            a.askForDistance();
            while(a.distance!=0){
                a.traveled=user.drive(a.distance);
                a.report(user);
                a.askForDistance();
            }
            a.askForAdd();
            while(a.fuelAmount!=0){
                user.addFuel(a.fuelAmount);
                a.askForDistance();
                while(a.distance!=0){
                    a.traveled=user.drive(a.distance);
                    a.report(user);
                    a.askForDistance();
                }
                a.askForAdd();
            }
        }
        a.reader.close();
    }
}
