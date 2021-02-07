package singleton_pattern;

/**
 * 单例模式，双重检查加锁的懒汉模式
 *
 * 懒汉方式。单例实例在第一次被使用时构建，而不是在JVM在加载这个类时就马上创建此唯一的单例实例
 */

public class SingletonDemo {
    //instance成员变量和getInstance方法必须设置为static，才能在实例化前用来构造单例实例

    //volatile保证，当uniqueInstance变量被初始化成Singleton实例时，多个线程可以正确处理uniqueInstance变量
    private static volatile SingletonDemo instance;
    //单例类必须要有一个 private 访问级别的构造函数，只有这样，才能确保单例不会在系统中的其他代码内被实例化;
    private SingletonDemo(){

    }
    //只有在第一次初始化实例时候才加锁，减少消耗
    public static SingletonDemo getInstance(){
        //检查实例，不存在就进入同步代码块
        if(instance==null){
            //第一次才执行同步代码块
            synchronized (SingletonDemo.class){
                //进入同步代码块后，再检查一次，如果仍是null，才创建实例
                if(instance==null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
