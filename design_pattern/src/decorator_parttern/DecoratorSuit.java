package decorator_parttern;

/**
 * 具体的装饰者类，负责给增加附加的操作：穿西服
 */
public class DecoratorSuit extends Decorator {

    public DecoratorSuit(Person person){
        super(person);
    }
    public void wear() {
        super.wear();
        System.out.println("穿个西服");
    }
}
