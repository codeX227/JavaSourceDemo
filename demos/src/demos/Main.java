package demos;

public class Main {

    public static void main(String[] args) {
        int a = 2;
        for (int i=0; i<4; i++){
            a = a>>1;
            System.out.print(a+" ");
        }
    }
}