package com.ironhack;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class CreateArrayOddsTest
{
   @Test
   @DisplayName("test return array of odds numbers ")
   public void testBasicFunctionality(){
       List<int[]> Output = new ArrayList<int []>() {{
        add(new int[]{1,3,5,7});
        add(new int[]{1,3});
        add(new int[]{1,3,5,7,9,11});
        add(new int[]{1});
       }
       };
       int[] input={7,3,12,1};

       for(int[] output_array: Output) {
           for(int input_element:input){
               Arrays.equals(output_array,App.createArrayOdds(input_element));
           }
       }
   }
   @Test
   @DisplayName("test Edge cases the input is 0")
   public void testNumberIsZero(){
       List<int[]> Output = new ArrayList<int []>() {{
           add(new int[]{0});

       }
       };
       int[] input={0};

       for(int[] output_array: Output) {
           for(int input_element:input){
               Arrays.equals(output_array,App.createArrayOdds(input_element));
           }
       }
   }

    @Test
    @DisplayName("Negative Number acts as positive ")
    public void testNegativeNumber(){
        List<int[]> Output = new ArrayList<int []>() {{
            add(new int[]{1,3,5,7});
            add(new int[]{1,3});
            add(new int[]{1,3,5,7,9,11});
        }
        };
        int[] input={-7,-3,-12};

        for(int[] output_array: Output) {
            for(int input_element:input){
                int[] output_list =App.createArrayOdds(input_element);
                Arrays.equals(output_array,output_list);
            }
        }
    }

    @Test
    @DisplayName("The array elements are always Odd")
    public void testReturnAlwaysOdd(){

        int[] input_list={7,3,12,20,2};

            for(int input:input_list){
                int[] output =App.createArrayOdds(input);
                for(int element:output){
                    assertTrue(element %2 !=0);

            }
        }
    }

    @Test
    @DisplayName("The test return always an array")
    public void testReturnAndArrayType(){
        assertInstanceOf(int[].class, App.createArrayOdds(56));
    }


}
