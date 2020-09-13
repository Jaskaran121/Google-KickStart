package google.kickstart2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class RoundACountryLeader {
    public static String calculate(String[] array){
        HashSet<Character> set;
        int maxStringUniqueLength = Integer.MIN_VALUE;
        String maxString = "";
        for(int i=0;i<array.length;i++){
            // Using HashSet here, since HashSet does not store duplicate values.
            set = new HashSet<>();
            mapToHashSet(set,array[i]);
            int setSize = set.size();
            if(setSize>maxStringUniqueLength){
                maxStringUniqueLength = setSize;
                maxString= array[i];
            } else if(setSize == maxStringUniqueLength) {
                String[] tempArray = new String[]{maxString,array[i]};
                Arrays.sort(tempArray);
                maxString = tempArray[0];
                maxStringUniqueLength = setSize;
            }
        }
        return maxString;
    }

    public static void mapToHashSet(HashSet<Character> set,String string){
        for(int j=0;j<string.length();j++){
            char x = string.charAt(j);
            int num = (int) x;
            // Ensuring number is a capital letter alphabet.
            if(num>64 && num<91)
                set.add(x);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] result = new String[testCases];

        // Taking Input From the User.
        for (int i = 0; i <testCases; i++) {
            int arraySize = in.nextInt();
            in.nextLine();
            String[] array = new String[arraySize];
            for(int j=0;j<arraySize;j++){
                array[j] = in.nextLine();
            }
            result[i] = calculate(array);
        }
        for(int i=1;i<=testCases;i++){
            System.out.print("Case #" + i + ": " + result[i-1]);
            if(i!=testCases)
                System.out.println("");
        }
    }
}
