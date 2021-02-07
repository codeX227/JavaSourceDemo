package datastructure.symbol;

public class SymbleTableTest {

    public static void main(String[] args) {
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();

        symbolTable.put(1,"乔峰");
        symbolTable.put(2,"虚竹");
        symbolTable.put(3,"段誉");

        System.out.println("元素个数为：" + symbolTable.size());

        symbolTable.put(2,"慕容复");
        System.out.println("替换完元素个数为：" + symbolTable.size());

        System.out.println("替换完后键 2 对应的值为：" + symbolTable.get(2));

        symbolTable.delete(2);
        System.out.println("删除后元素个数：" + symbolTable.size());
    }
}
