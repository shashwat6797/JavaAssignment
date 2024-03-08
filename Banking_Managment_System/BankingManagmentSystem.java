import java.util.*;
import java.io.*;

public class BankingManagmentSystem {
  public static void main(String args[]){
    User user = new User();
    user.login();
  }
}

class User extends IOException {
  private 
    HashMap<String, String> userPassword = new HashMap<>();
    HashMap<String, Integer> userBalance = new HashMap<>();
    String username;
    Scanner sc = new Scanner(System.in);
  public
    User(){
      userPassword.put("shashwat","shashwat");
      userPassword.put("hemant","hemant");
      userPassword.put("updesh","updesh");
      userPassword.put("omi","om");
      userBalance.put("shashwat",1000);
      userBalance.put("hemant",9000);
      userBalance.put("updesh",5000);
      userBalance.put("shashwat",10000);
    }
  void getBalance(){
    System.out.println("Balance for User "+this.username+" : "+userBalance.get(this.username));
    showMenu();
  }
  void deposit(){
    System.out.print("Enter Amount to be deposited : ");
    int amount = sc.nextInt();
    amount = userBalance.get(this.username) + amount;
    userBalance.put(this.username,amount);
    System.out.println("New Balance for "+this.username+" : "+amount);
    showMenu();
  }
  void withdraw(){
    System.out.print("Enter Amount to withdraw : ");
    int amount = sc.nextInt();
    amount = userBalance.get(this.username) - amount;
    userBalance.put(this.username,amount);
    System.out.println("New Balance for "+this.username+" : "+amount);
    showMenu();
  }
  void handleChoice(int c ){
    switch (c){
      case 1 : getBalance();
               break;
      case 2 : deposit();
               break;
      case 3 : withdraw();
               break;
      case 4 : System.exit(0);
               break;
    }
  }
  void showMenu() {
    System.out.println("======Menu======");
    System.out.println("1. Check Balance ");
    System.out.println("2. Deposit ");
    System.out.println("3. Withdraw ");
    System.out.println("4. Exit ");
      try{
        System.out.print("Enter your choice : ");
        int c = sc.nextInt();
        if( c < 1 || c > 4 )
          throw new IOException();
        else
          handleChoice(c);
      }catch(Exception e){
        System.out.println("Error : "+e);
      } 
  }
  void login(){
      System.out.print("Enter Your UserName : ");
        this.username = sc.nextLine();
        if( userPassword.containsKey(username) ){
        System.out.print("Enter Your Password : ");
        String password = sc.nextLine();
        String p = userPassword.get(this.username);
        Boolean auth = password.equals(p) ? true : false;
        if( auth ){
          System.out.println("Welcome : "+username);
          showMenu();
        }else{
          System.out.println("wrong Password "+p+" "+password);
        }
        }else{
          System.out.println("User does not Exist");
        }
  }
}


