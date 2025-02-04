package io.zipcoder;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int countOfYZ=0, i=0;
        while (i<input.length()) {
            if ((input.charAt(i) == 'y' || input.charAt(i)=='z')
                    && (i+1==input.length() || !(Character.isLetter(input.charAt(i+1))))) {
                countOfYZ++;
            }
            //If statement check if the letters are y or z, then checks if it was the end of the string
            //or if the next character is a letter to indicate the end of the word. If both are true, then
            //increment count by 1
            i++;
        }
        return countOfYZ;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        String result = base.replaceAll(remove, "");
        return result;
        //Using the replaceAll method with base as the string and remove as the regex statement, we
        //can replace the matching parts with null.
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int iscount=0,notcount=0;
        Pattern pattern = Pattern.compile("is");
        Pattern pattern1 = Pattern.compile("not");
        Matcher matcher = pattern.matcher(input);
        Matcher matcher1 = pattern1.matcher(input);
        for (int i=0; matcher.find();i++){
            iscount++;
        }
        for (int i=0; matcher1.find();i++){
            notcount++;
        }
        return iscount == notcount;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        Boolean test =false;
        for (int i=0;i<input.length();i++){
            if (input.charAt(i) == 'g') {
                    if (input.charAt(i+1) == 'g' || input.charAt(i-1) == 'g'){
                        test=true;
                    }
                    else {
                        test = false;
                        break;
                    }
            }
        }
        return test;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int count=0;
        for (int i=0;i<input.length()-2;i++){
            //for loop limit is less than length due to the 2 last letters cannot be a triple 2 != 3
            if (input.charAt(i) == input.charAt(i+1) && input.charAt(i) == input.charAt(i+2))
                count++;
        }
        return count;
    }
}
