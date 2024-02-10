package com.ironhack;

import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static int[] createArrayOdds( int n )
    {
        if( n==0) {
            return new int[]{0};
        } else if (n<0) {
           n = Math.abs(n);
        }

        int[] result = new int[(n + 1) / 2];
        for (int i = 0, odd = 1; odd <= n; i++, odd += 2) {
            result[i] = odd;
        }
        return result;
    }
}
