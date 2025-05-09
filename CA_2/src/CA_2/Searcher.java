/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
import java.util.*;

/**
 *
 * @author sorgi
 * This class helps find a name using binary search.
 */
public class Searcher {
     /**
      * This method searches for a target name in a sorted list of names.
      * It uses binary search which is fast for sorted lists.
      * 
      * @param names the list of names (must be sorted)
      * @param target the name we want to find
      * @return the index of the name if found, or -1 if not found
      */
    public static int binarySearch( List<String> names, String target){
        int left = 0; // start of the list
        int right = names.size() - 1;// end of the list
        
        // Keep checking while there is a search range
        while(left <= right){
            int mid = (left + right) / 2;// middle index
            String midVal = names.get(mid);// name at the middle
            
            int cmp = midVal.compareToIgnoreCase(target);// compare names
            if(cmp == 0){
                return mid;// found
            }else if(cmp < 0){
                left = mid +1;// search the right half
            } else{
                right = mid - 1;// search the left half
            }
            
        }
        
        return -1;// not found
        
    } 
}
