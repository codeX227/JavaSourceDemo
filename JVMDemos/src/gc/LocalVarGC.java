package gc;

public class LocalVarGC {
    public void localvarGC1(){
        byte[] buffer = new byte[10 * 1024 * 1024];
        System.gc();//局部变量表保留有buffer引用，不会回收
    }

    public void localvarGC2(){
        byte[] buffer = new byte[10 * 1024 * 1024];
        buffer = null;
        System.gc();//局部变量表的buffer引用为空，会回收
    }

    public void localvarGC3(){
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        System.gc();//引用仍记录在局部变量表，不会回收
    }

    public void localvarGC4(){
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        int value = 10;
        System.gc();//局部变量表buffer的槽被value占用，会回收
    }
    
    public void localvarGC5(){
        localvarGC1();
        System.gc();
    }

    public static void main(String[] args) {
        new LocalVarGC().localvarGC5();

    }
}
