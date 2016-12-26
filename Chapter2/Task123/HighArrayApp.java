/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  HighArray
 */
import java.io.PrintStream;

class HighArrayApp {
    HighArrayApp() {
    }

    public static void main(String[] arrstring) {
        int n = 100;
        HighArray highArray = new HighArray(n);
        highArray.insert(77);
        highArray.insert(44);
        highArray.insert(55);
        highArray.insert(22);
        highArray.insert(88);
        highArray.insert(11);
        highArray.insert(0);
        highArray.insert(99);
        highArray.insert(66);
        highArray.insert(33);
        highArray.display();


        //Task#1 dev testing
        long max1 = highArray.getMax();
        System.out.println(max1);

        //Task#2 dev testing
        long max2 = highArray.removeMax();
        highArray.display();
        System.out.println(max2);

        //Task#3
        long [] a = new long[highArray.getnElems()];
        for (int i = highArray.getnElems(); i > 0; i--) {
            a[i-1] = highArray.removeMax();
        }
        //print sorted array
        for (int j = 0; j < a.length; j++){
            System.out.print(a[j]+" ");
        }

        /*int n2 = 35;
        if (highArray.find((long)n2)) {
            System.out.println("Found " + n2);
        } else {
            System.out.println("Can't find " + n2);
        }
        highArray.delete(0);
        highArray.delete(55);
        highArray.delete(99);
        highArray.display();*/
    }
}