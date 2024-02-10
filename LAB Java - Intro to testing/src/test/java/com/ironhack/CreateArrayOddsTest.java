package com.ironhack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
       }
       };
       int[] input={7,3,12};

       for(int[] output_array: Output) {
           for(int input_element:input){
               assertEquals(output_array,App.createArrayOdds(input_element));
           }
       }
   }
   @Test
   @DisplayName("test Edge cases the input is 0 or 1 ")
   public void testNumberIsZeroOrOne(){
       List<int[]> Output = new ArrayList<int []>() {{
           add(new int[]{0});

       }
       };
       int[] input={0,1};

       for(int[] output_array: Output) {
           for(int input_element:input){
               assertEquals(output_array,App.createArrayOdds(input_element));
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
                assertEquals(output_array,App.createArrayOdds(input_element));
            }
        }
    }

    @Test
    @DisplayName("The array elements are always Odd")
    public void testReturnAlwaysOdd(){
        List<int[]> Output = new ArrayList<int []>() {{
            add(new int[]{1,3,5,7});
            add(new int[]{1,3});
            add(new int[]{1,3,5,7,9,11});
        }
        };
        int[] input={-7,-3,-12};

        for(int[] output_array: Output) {
            for(int input_element:input){
                assertTrue(input_element %2 !=0);
                ;
            }
        }
    }

    @Test
    @DisplayName("The test return always an array")
    public void testReturnAndArrayType(){
        assertInstanceOf(int[].class, App.createArrayOdds(56));
    }

}
