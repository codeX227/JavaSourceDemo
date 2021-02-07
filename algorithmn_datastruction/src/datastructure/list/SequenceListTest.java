package datastructure.list;


public class SequenceListTest {

    public static void main(String[] args) {

        SequenceList<String> sl = new SequenceList<>(3);
        sl.insert("张三");
        sl.insert("李四");
        sl.insert("王五");
        sl.insert("赵六");
        System.out.println("元素个数：" + sl.length());
//        System.out.println("数组长度：" + sl.arrayLength());
        for (String s : sl) {
            System.out.println(s);
        }

//        SequenceList<String> sl = new SequenceList<>(10);
//        sl.insert("姚明");
//        sl.insert("科比");
//        sl.insert("麦迪");
//        sl.insert("詹姆斯");
//
//        //测试迭代器
//        for (String s : sl){
//            System.out.println(s);
//        }
//        System.out.println("=======================================================");
//        //测试获取
//        String getResult = sl.get(1);
//        System.out.println("获取索引为1处的结果为：" + getResult);
//        //测试删除
//        String removeResult = sl.remove(0);
//        System.out.println("删除的元素是：" + removeResult);
//        //测试清空
//        sl.clear();
//        System.out.println("清空后元素个数：" + sl.length());
    }
}
