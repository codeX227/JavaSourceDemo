package decorator_parttern;

public class Main {
    public static void main(String[] args) {
        Person p1 = new DecoratorSuit(new DecoratorShirt(new Jane()));
        p1.wear();
        System.out.println("--------------");
    }
}
