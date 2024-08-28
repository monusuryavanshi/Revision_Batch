package com.PractisePrograms;

import java.util.Arrays;
import java.util.Scanner;

public class programDuplicateCharsString {
    public static void main(String[] args) {
        programDuplicateCharsString p = new programDuplicateCharsString();

        String str = "";
        System.out.println("Enter String : ");
        Scanner scn = new Scanner(System.in);
        str = scn.next();
        p.getDuplicateChars(str);
    }

    public void getDuplicateChars(String str)
    {
        int len = str.length();
        int count = 0 ;
        char [] arrStr = str.toCharArray();
        Arrays.sort(arrStr);
        String sortStr = new String(arrStr);
        System.out.println(sortStr+ "," + len);
        for (int i = 0 ; i < len ; i++)
        {
            count = 1;
            if (i < len-1 && sortStr.charAt(i) == sortStr.charAt(i+1))
            {
                count++;
                i++;
            }
            if (count > 1){
                System.out.println(sortStr.charAt(i) + " :" + count);
            }
        }
    }
}
