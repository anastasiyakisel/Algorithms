import java.util.ArrayList;
import java.util.stream.IntStream;

class ArrayIns
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayIns(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------
    public void insertionSort()
    {
        int in, out;

        for(out=1; out<nElems; out++)     // out is dividing line
        {
            long temp = a[out];            // remove marked item
            in = out;                      // start shifts at out
            while(in>0 && a[in-1] >= temp) // until one is smaller,
            {
                a[in] = a[in-1];            // shift item to right
                --in;                       // go left one position
            }
            a[in] = temp;                  // insert marked item
        }  // end for
    }  // end insertionSort()


    public long median(){
        insertionSort();
        int index;
        long median;
        if (nElems % 2 == 0){
            index = nElems / 2;
            median = (a[index - 1] + a[index]) / 2 ;
        } else {
            index = (int) Math.floor(nElems / 2);
            median = a[index];
        }
        return median;

    }

    // Task#3 : Remove duplicates in sorted array. Shift all other elements only 1 time.
    public void noDups(){
        insertionSort();
        int [] indexesOfDuplicates = new int[100];
        int duplicatesSize = 0;
        for (int i=0; i < nElems; i++){
            if (a[i] == a[i+1]){
                indexesOfDuplicates[duplicatesSize] = i+1;
                duplicatesSize++;
            }
        }
        // Copying is 3 times faster than transposition. All non-duplicate elements
        // will be moved only 1 time.
        long [] copyArray = new long [nElems - duplicatesSize];
        int sh = 0; //counter of loop , used for copying
        int dupSh = 0;
        int aSh = 0;
        while (sh < nElems - duplicatesSize){
            if (indexesOfDuplicates[dupSh] != aSh){
                copyArray[sh] = this.a[aSh];
                sh ++;
                aSh ++;
            } else {
                dupSh ++;
                aSh ++;
            }
        }
        this.a = copyArray;
        this.nElems = nElems - duplicatesSize;
    }

}  // end class ArrayIns