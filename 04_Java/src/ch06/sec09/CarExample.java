package ch06.sec09;

public class CarExample {
     public static void main(String[] args) {

         Car car1 = new Car("포르쉐");
         Car car2 = new Car("벤츠");

         car1.setSpeed(100);
         car1.run();

         car2.setSpeed(car1.getSpeed());
         car2.run();
     }


}
