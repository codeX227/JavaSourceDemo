package prototype_pattern;

import java.util.HashMap;

/**
 * Client客户使用类
 * 给客户提供注册和克隆实例的方法
 * Client角色负责使用复制实例的方法生成新的实例
 */
public class Manager {
    //保存名字还实例对应关系
    HashMap<String ,Product> showcase = new HashMap<String ,Product>();
    //register方法将接收到的一组“名字”和“Product接口”注册到showcase中。
    // 这里Product是实现Product接口的实例，具体还未确定
    public void register(String name, Product product){
        showcase.put(name, product);
    }
    public Product create(String productname){
        Product product = showcase.get(productname);
        return product.createClone();
    }
}
