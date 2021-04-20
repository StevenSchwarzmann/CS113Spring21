package edu.miracosta.cs113.change;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculator {
	
	public static HashSet<String> resultSet = new HashSet<String>();
	public static int[] coinValues = {25, 10, 5, 1};
	public static String fileName = "C:\\Users\\stevens\\eclipse-workspace\\CS113Spring21\\DS-RecursionTrees-master\\src\\edu\\miracosta\\cs113\\change\\CoinCombinations.txt";

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static int calculateChange(int cents) {
    	resultSet = new HashSet<String>();
        makeChange(cents, 0, 0, 0, cents);
		return resultSet.size();
    }
    
    private static void makeChange(int total, int numQuarters, int numDimes, int numNickels, int numPennies) {
    	final int QUARTER = coinValues[0], DIME = coinValues[1], NICKEL = coinValues[2], PENNY = coinValues[3];
    	
    	if(numQuarters * QUARTER + numDimes * DIME + numNickels * NICKEL + numPennies * PENNY > total) {
    		return;
    	}
    	
    	String result = "[" + numQuarters + ", " + numDimes + ", " + numNickels + ", " + numPennies + "]";
    	
    	if(!resultSet.contains(result))
    		resultSet.add(result);
    	
    	if (numPennies >= 5)
    		makeChange(total, numQuarters, numDimes, numNickels + 1, numPennies - 5);
    	if (numPennies >= 10)
    		makeChange(total, numQuarters, numDimes + 1, numNickels, numPennies - 10);
    	if (numPennies >= 25)
    		makeChange(total, numQuarters + 1, numDimes, numNickels, numPennies - 25);
    	
    }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents) {
        calculateChange(cents);
        
        PrintWriter pw = null;
        try {
            try {
				pw = new PrintWriter(
				    new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			} catch (UnsupportedEncodingException usee) {
				// TODO Auto-generated catch block
				usee.printStackTrace();
			} catch (FileNotFoundException fnfe) {
				// TODO Auto-generated catch block
				fnfe.printStackTrace();
			}
            for (String s : resultSet) {
                pw.println(s);
            }
            pw.flush();
        } finally {
            pw.close();
        }
        
        
    }

} // End of class ChangeCalculator