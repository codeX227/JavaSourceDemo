package datastructure.symbol;

public class OrderSymbleTableTest {

    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> orderSymbolTable = new OrderSymbolTable<>();

        orderSymbolTable.put(4,"张三");
        orderSymbolTable.put(3,"乔峰");
        orderSymbolTable.put(2,"虚竹");
        orderSymbolTable.put(1,"段誉");


        System.out.println("元素个数为：" + orderSymbolTable.size());

        orderSymbolTable.put(2,"慕容复");
        System.out.println("替换完元素个数为：" + orderSymbolTable.size());

        System.out.println("替换完后键 2 对应的值为：" + orderSymbolTable.get(2));

        orderSymbolTable.delete(2);
        System.out.println("删除后元素个数：" + orderSymbolTable.size());
    }
}
