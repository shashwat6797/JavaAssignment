import java.io.*;
import java.util.*;

public class CarRentalSystem{
  public static void main(String args[]){
    CarStore cs = new CarStore();
    cs.login();
  }
}

class Car{
  private
    String name;
    String model;
    Boolean isBooked = false;
    int price_per_hour;
  public
    Car(){};
    Car(String name, String model, Boolean isBooked, int price_per_hour){
      this.name = name;
      this.model = name;
      this.isBooked = isBooked;
      this.price_per_hour = price_per_hour;
    }
    void showDetail(){
      System.out.println("Name : "+this.name);
      System.out.println("Model : "+this.model);
      if(this.isBooked){
        System.out.println("Not Available");
      }else{
        System.out.println("Available");
      }      
      System.out.println("Price Per Hour : "+this.price_per_hour);
    }
}

class User{
  private
    Car bookedCar = new Car();
    Boolean hasBooked = false;
    String username;
  public
    User(){
    };
  void Rent(Car rentingCar){
    if(this.hasBooked){
      System.out.println("Car Already Booked");
      System.exit(0);
    }else{
      this.bookedCar = rentingCar;
      this.bookedCar.isBooked = true;
    }
  }
  void Return(){
    if(!this.hasBooked){
      System.out.println("No Car Booked ");
      System.exit(0);
    }else{
      this.hasBooked = false;
      this.bookedCar.isBooked = false;
      System.out.println("Car is Returned");
    }
  }
}

class CarStore extends IOException{
  private
    Car car1 = new Car("Maruti","Creta",false,200);
    Car car2 = new Car("Toyota","Fortuner",false,500);
    Car car3 = new Car("Hundai","Verna",false,500);
    Car car4 = new Car("BMW","X3",false,700);
    User user = new User();
    Scanner sc = new Scanner(System.in);
  public
    void showCars(){
      car1.showDetail();
      car2.showDetail();
      car3.showDetail();
      car4.showDetail();
    }
    void returnCar(){
      user.Return();
    }
    void rentCar(){
      System.out.print("Enter Car Name to Rent : ");
      String c = sc.nextLine();
      switch(c){
        case "Maruti" : user.Rent(car1);
        case "Toyota" : user.Rent(car2);
        case "Hundai" : user.Rent(car3);
        case "BMW" : user.Rent(car4);
        default : System.out.println("Car Not Found!");
                  System.exit(0);
      }
    }
    void handleChoice(int c){
      switch(c){
        case 1 : showCars();
                 showMenu();
                break;
        case 2 : returnCar();
                break;
        case 3 : rentCar();
                break;
        case 4 : System.exit(0);
      }
    }
    void showMenu(){
      System.out.println("======Menu======");
      System.out.println("1. Show Available Cars ");
      System.out.println("2. Return Car ");
      System.out.println("3. Rent Car ");
      System.out.println("4. Exit ");
      try{
        System.out.print("Enter your choice : ");
        int c = sc.nextInt();
        if( c < 1 || c > 4 )
          throw new IOException();
        else
          handleChoice(c);
      }catch(Exception e){
        System.out.println("Error: "+e);
      }
    }
    void login(){
      System.out.print("Enter Your UserName : ");
      String username = sc.nextLine();
      user.username = username;
      showMenu();
    }
}
