

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nastenka on 01.12.16.
 */
public class MergeSort {

    private static Comparable[] mergeSort(Comparable[] array){
        // if array is empty, no need to do anything
        if (array.length<=1){
            return array;
        }
        //Split the array in half in two parts
        Comparable [] firstHalf = new Comparable [array.length/2];
        Comparable [] secondHalf = new Comparable [array.length - firstHalf.length];
        //populate halfs with values
        System.arraycopy(array, 0, firstHalf, 0, firstHalf.length);
        System.arraycopy(array, firstHalf.length, secondHalf, 0, secondHalf.length);
        // Sort each half recursively
        mergeSort(firstHalf);
        mergeSort(secondHalf);

        merge(firstHalf, secondHalf, array);

        return array;
    }

    private static void merge (Comparable [] first, Comparable [] second, Comparable [] result){
        // index position in first array
        int iFirst = 0;

        // index position in second array
        int iSecond = 0;

        //index position in merge array
        int iMerged = 0;

        //Compare elements at iFirst and iSecond and
        // move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length){
            if (first[iFirst].compareTo(second[iSecond])<0){
                result[iMerged]=first[iFirst];
                iFirst++;
            } else {
                result[iMerged]=second[iSecond];
                iSecond++;
            }
            iMerged++;
        }

        System.arraycopy(first, iFirst, result, iMerged, first.length-iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length-iSecond);
    }

    private static Integer [] readNumberArrayFromConsole() throws IOException {
        Scanner in = new Scanner(System.in);
        String [] numberStrArray = in.nextLine().trim().split("\\s+");
        Integer [] numberArray = new Integer[numberStrArray.length];
        for (int i=0; i<numberStrArray.length; i++ ){
            numberArray[i]=Integer.parseInt(numberStrArray[i]);
        }
        return numberArray;
    }

    public static void main(String[] args) throws IOException {
        // Unsorted array
        System.out.println("Please input numbers array of even size. Numbers should be separated with spaces.");
        Integer [] numbers = readNumberArrayFromConsole();

        //Call mergeSort
        mergeSort(numbers);

        // Sorted array
        System.out.println("Sorted Array is : "+Arrays.toString(numbers));

    }

}