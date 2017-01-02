class InsertSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;            // array size
        ArrayIns arr;                 // reference to array
        arr = new ArrayIns(maxSize);  // create the array

        arr.insert(99);               // insert 10 items
        arr.insert(99);
        arr.insert(22);
        arr.insert(22);
        arr.insert(22);
        arr.insert(88);
        arr.insert(99);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        //System.out.println("Median is " + arr.median());
        arr.noDups();

        arr.display();
    }  // end main()
}  // end class InsertSortApp
