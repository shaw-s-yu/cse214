public class Car{
    //3 private variables
    private static double fuelEfficiency;           //miles per gallon
    private static double fuelLevel;
    private static double odometer;
    
    //constructor
    public Car(double fuelE){
        this.fuelEfficiency=fuelE;
        this.fuelLevel=0;
        this.odometer=0;
    }
    
    public double getFuelEfficiency(){
        return this.fuelEfficiency;
    }
    
    public double getOdometer(){
        return this.odometer;
    }
    
    public double getFuelLevel(){
        return this.fuelLevel;
    }
    
    public double addFuel(double gallons){
        this.fuelLevel+=gallons;
        return this.fuelLevel;
    }
    
    public double drive(double miles){
        double milesLeft=this.fuelLevel*this.fuelEfficiency;
        if(milesLeft>= miles){
            this.odometer+=miles;
            this.fuelLevel-=(miles/this.fuelEfficiency);
            return miles;
        }
        else{
            this.odometer+=milesLeft;
            this.fuelLevel=0;
            return milesLeft;
        }
    }
}
