package singleton_pattern;

/**
 * 单例模式 饿汉方式
 *
 * 所谓 “饿汉方式” 就是说JVM在加载这个类时就马上创建此唯一的单例实例，不管你用不用，先创建了再说
 */
public class SingletonHungryDemo {

    //在静态初始化器中创建单例实例，这段代码保证了线程安全
    private static SingletonHungryDemo uniqueInstance = new SingletonHungryDemo();

    //Singleton类只有一个构造方法并且是被private修饰的，所以用户无法通过new方法创建该对象实例
    private SingletonHungryDemo(){

    }

    public static SingletonHungryDemo getInstance(){
        return uniqueInstance;
    }
}
