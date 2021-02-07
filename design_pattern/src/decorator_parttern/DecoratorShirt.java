package decorator_parttern;

/**
 * 具体的装饰者类，负责给增加附加的操作：穿衬衫
 */
public class DecoratorShirt extends Decorator {

    public DecoratorShirt(Person person) {
        super(person);
    }

    public void wear(){
        super.wear();
        System.out.println("穿短袖");
    }
}
