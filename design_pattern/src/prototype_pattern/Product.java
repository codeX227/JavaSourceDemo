package prototype_pattern;

/**
 * Prototype抽象原型类
 * Product角色负责定义用于复制现有实例来生成新实例的方法
 */
public interface Product extends Cloneable{
    //打印字符的方法
    public void use(String s);
    //用于复制实例的方法
    Product createClone();
}
