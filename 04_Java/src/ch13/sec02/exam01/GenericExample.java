package ch13.sec02.exam01;

public class GenericExample {
    public static void main(String[] args) {
        // K는 Tv로, M는 String으로 대체
        Product<Tv, String> product1 = new Product<>();

        // Setter 매개값은 반드시 Tv, String 제공해야 함.
        product1.setKind(new Tv());
        product1.setModel("Smart TV");

        // Getter 리턴값은 Tv, String이 됨.
        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        Product<Car, String> product2 = new Product<>();

        product2.setKind(new Car());
        product2.setModel("SUV");

        Car car = product2.getKind();
        String carModel = product2.getModel();

    }
}
