package com.PractisePrograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class programSecondLargestNumber {
    public static void main(String[] args) {
        programSecondLargestNumber p = new programSecondLargestNumber();

        int sNum = 0;
        System.out.println("Enter array size : ");
        Scanner scn = new Scanner(System.in);
        sNum = scn.nextInt();
        System.out.println("Enter array elements : ");

        /*int[] aNum = p.getArrayValues(sNum);
        p.getSecondLargestNumber(aNum);*/

        /*int[] aNum = p.getArrayValues(sNum);
        int sMax = p.getSecondLargestNumberSwap(aNum);*/

        Integer[] aNum1 = p.getArrayValuesCollection(sNum);
        p.getSecondLargestNumberCollections(aNum1);

    }

    public int[] getArrayValues(int numSize)
    {
        Scanner scn = new Scanner(System.in);
        int[] aNum = new int[numSize];
        for (int i = 0 ; i < numSize ; i++)
        {
            aNum[i] = scn.nextInt();
        }
        return aNum;
    }

    public void getSecondLargestNumber(int[] arrNum)
    {
        int max = 0, smax = 0, arrSize=arrNum.length;
        for (int i = 0 ; i < arrSize ; i ++)
        {
            if (arrNum[i]>max)
            {
                smax = max;
                max = arrNum[i];
            }
            else if(arrNum[i] > smax)
            {
                smax = arrNum[i];
            }
        }
        System.out.println("Second Largest Number = " + smax);
    }

    public int getSecondLargestNumberSwap(int[] arrNum)
    {
        int temp = 0 , arrSize = arrNum.length;

        for (int i = 0 ; i < arrSize ; i++)
        {
            for (int j = i + 1 ; j < arrSize ; j++)
            {
                if (arrNum[i] > arrNum[j])
                {
                    temp = arrNum[i];
                    arrNum[i] = arrNum[j];
                    arrNum[j] = temp;
                }
            }
        }
        System.out.println("Second Largest Number = " + arrNum[arrSize-2]);
        return arrNum[arrSize-2];
    }

    public Integer[] getArrayValuesCollection(int numSize)
    {
        Scanner scn = new Scanner(System.in);
        Integer[] aNum = new Integer[numSize];
        for (int i = 0 ; i < numSize ; i++)
        {
            aNum[i] = scn.nextInt();
        }
        return aNum;
    }

    public void getSecondLargestNumberCollections(Integer[] arrNum)
    {
        int arrSize = arrNum.length, sMax = 0;
        Arrays.sort(arrNum, Collections.reverseOrder());
        for (int i = 0 ; i < arrSize ; i ++)
        {
            if (arrNum[i]!=arrNum[0])
            {
                sMax = arrNum[i];
                break;
            }
        }
        System.out.println("Second Largest Number = "+sMax);
    }
}
