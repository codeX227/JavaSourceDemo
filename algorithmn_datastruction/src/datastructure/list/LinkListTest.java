package datastructure.list;

public class LinkListTest {

    public static void main(String[] args) {
        //创建单向链表对象
        LinkList<String> sl = new LinkList<>();
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");

        //测试迭代器
        for (Object s : sl){
            System.out.println(s);
        }
        System.out.println("=======================================================");
        //测试获取
        String getResult = sl.get(1);
        System.out.println("获取索引为1处的结果为：" + getResult);
        //测试删除
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是：" + removeResult);
        //测试清空
        sl.clear();
        System.out.println("清空后元素个数：" + sl.length());
    }
}
