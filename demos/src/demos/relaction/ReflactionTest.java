package demos.relaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReflactionTest {
    public static void main(String[] args) {
         String name;
         if (args.length > 0)
             name = args[0];
         else {
             Scanner in = new Scanner(System.in);
             System.out.println("Enter class name (eg. java.util.Date)");
             name = in.next();
         }

         try {
             Class<?> cl = Class.forName(name);
             Class<?> supercl = cl.getSuperclass();
             String modifiers = Modifier.toString(cl.getModifiers());
             if (modifiers.length() > 0){
                 System.out.print(modifiers + " ");
             }
             System.out.print("class " + cl.getName());
             if (supercl != null && supercl != Object.class){
                 System.out.print(" extends " + supercl.getName());
             }
             System.out.println("\n{");
             printConstructors(cl);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
        System.out.println("};");
    }
    public static void printConstructors(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors){
            System.out.print("    ");
            String name = c.getName();
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0 ; j < paramTypes.length; j++){
                if (j >0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
}
