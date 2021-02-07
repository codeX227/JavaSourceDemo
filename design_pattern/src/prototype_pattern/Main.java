package prototype_pattern;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        MessageBox mBos = new MessageBox('*');
        MessageBox sBos = new MessageBox('/');
        UnderlinePen underlinePen = new UnderlinePen('~');
        manager.register("Strong message", underlinePen);
        manager.register("Waring box", mBos);
        manager.register("Slash bos", sBos);
        Product p1 = manager.create("Strong message");
        p1.use("HelloWorld");
        Product p2 = manager.create("Waring box");
        p2.use("HelloWorld");
        Product p3 = manager.create("Slash bos");
        p3.use("HelloWorld");
    }
}
