package decorator_parttern;

/**
 * 具体的对象，该对象将被附加一些额外的操作
 */
public class Jane implements Person {
    @Override
    public void wear() {
        System.out.println("穿衣服");
    }
}
