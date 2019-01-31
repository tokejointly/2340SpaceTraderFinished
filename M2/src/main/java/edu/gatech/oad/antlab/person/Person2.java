package edu.gatech.oad.antlab.person;
import java.util.Random;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Owen McCarty
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	  //Person 2 put your implementation here
		String result = "";
		int count = input.length();
		int count2 = count;
		String newstring = "";
		String newstring2 = "";
		while (count2 > 0) {	
			Random rand = new Random();
			int num = rand.nextInt(count2);
			if (num != 0 && num != input.length()) {
				newstring = input.substring(0, num - 1);
				newstring2 = input.substring(num + 1, count2);
			} else if (num == 0) {
				newstring = "";
				newstring2 = input.substring(num + 1, count2);
			} else {
				newstring = input.substring(num + 1, count2 - 1);
				newstring2 = "";
			}
			count2--;
		}
		result = newstring + newstring2;
	  return result;
	}
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}
