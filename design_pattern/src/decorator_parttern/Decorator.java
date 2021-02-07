package decorator_parttern;

/**
 * 装饰者类，持有一个将要被装饰的接口对象的实例
 */
public class Decorator implements Person {
    private Person person = null;

    public Decorator(Person person){
        this.person = person;
    }

    @Override
    public void wear() {
        person.wear();
    }
}
