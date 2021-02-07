package algorithmn.list;

import datastructure.list.LinkList;

/**
 * 自定义 LinkList
 * 递归实现单链表反转
 */
public class LinkListReverse {

    public static void main(String[] args) {
        //创建单向链表对象
        LinkList<String> sl = new LinkList<>();
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");

        for (Object s : sl){
            System.out.print(s + " ");
        }
        System.out.print("\n");
        System.out.println("=======================================================");

        sl.reverse();
        for (Object s : sl){
            System.out.print(s + " ");
        }
    }
}
