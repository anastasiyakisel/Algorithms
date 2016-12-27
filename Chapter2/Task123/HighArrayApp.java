class HighArrayApp {
    HighArrayApp() {
    }

    public static void main(String[] arrstring) {
        HighArray highArray = new HighArray(100);
        long [] ar = {77, 44, 55, 22, 88, 11, 0, 99, 66, 33};
        highArray.initialize(ar);
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
        System.out.println();

        //Task#6
        HighArray highArray2 = new HighArray(100);
        long [] b = {1, 3, 5, 99, 6, 3, 88, 1, 34, 67, 12, 99};
        highArray2.initialize(b);
        highArray2.noDups();
        highArray2.display();


    }
}