class OrderedApp
{
    public static void main(String[] args)
    {
        OrdArray arr = new OrdArray(100);   // create the array

        //Task#4 Main Program
        /*
        arr.insert(99);
        arr.insert(77);
        arr.insert(22);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        arr.display();
        arr.delete(0);
        arr.delete(22);
        arr.delete(999);
        arr.display();*/

        //Task#5 Main Program
        long [] array1 = {0, 1, 4, 5, 7, 19, 44, 56};
        long [] array2 = {7, 20, 33};
        long [] resultArray = OrdArray.merge(array1, array2);
        OrdArray.printArray(resultArray);

    }
}
