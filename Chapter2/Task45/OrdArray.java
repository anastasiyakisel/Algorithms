class OrdArray {

    private long[] a;
    private int nElems;

    public OrdArray(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return -1;
            else
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    //Task#4
    public void insert(long value)
    {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        boolean isFound = false;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == value) {
                isFound = true;
                break;
            } else if (lowerBound > upperBound) {
                break;
            } else
            {
                if (a[curIn] < value)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
        int j = (isFound) ? curIn : upperBound + 1;
        for (int k = nElems; k > j; k--)
            a[k] = a[k - 1];
        a[j] = value;
        nElems++;
    }
    //Task#4
    public boolean delete(long value) {
        int j = find(value);
        if (j == -1)
            return false;
        else
        {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display()
    {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    /**
     * Task#5 Merges two sorted array into one sorted array
     *
     * @param array1 first sorted array
     * @param array2 second sorted array
     * @return sorted array
     */
    public static final long [] merge (long [] array1, long[] array2){
        int length = array1.length + array2.length;
        long [] resultArray = new long [length];
        int counter1 = 0;
        int counter2 = 0;
        int i=0;
        while (i < length){
            if (counter1 < array1.length && counter2 < array2.length) {
                if (array1[counter1] < array2[counter2]) {
                    resultArray[i] = array1[counter1];
                    counter1++;
                    i++;
                } else {
                    resultArray[i] = array2[counter2];
                    counter2++;
                    i++;
                }
            } else {
                break;
            }
        }
        if (counter1 < array1.length){
            for (int j = i; j < length ; j++) {
                resultArray[j] = array1[counter1];
                counter1++;
            }

        } else {
            for (int j = i; j < length ; j++) {
                resultArray[j] = array2[counter2];
                counter2++;
            }
        }

        return resultArray;
    }

    public static final void printArray(long [] array){
        for (int i=0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }

}
