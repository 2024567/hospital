/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.*;

/**
 *
 * @author sorgi
 * This class helps sort a list of names using the merge sort algorithm.
 */
public class sorter {
    /**
    * This method sorts a list of names using merge sort.
    * It splits the list into two halves, sorts each, and combines them.
    */
    public static List<String> mergeSort(List<String> names){
        // If the list has one or zero items, it’s already sorted
        if(names.size() <= 1){
            return names;
        }
        
        // Split the list into two parts
        int middle = names.size() / 2;
        List<String> left = mergeSort(names.subList(0, middle));
        List<String> right = mergeSort(names.subList(middle, names.size()));
        
        // Merge the two sorted halves
        return merge(left,right);
    }
    /**
     * 
     * This method merges two sorted lists into one sorted list.
     */
    private static List<String> merge(List<String> left, List<String> right){
        List<String> sorted = new ArrayList<>();
        int i=0, j=0;
        
        // Compare items from each list and add the smaller one
        while(i < left.size() && j < right.size()){
            if(left.get(i).compareToIgnoreCase(right.get(j)) <= 0){
                sorted.add(left.get(i));
                i++;
            } else {
                sorted.add(right.get(j));
                j++;
            }
        }
        
        // Add any remaining items from the left lis
        while(i < left.size()){
            sorted.add(left.get(i));
            i++;
        }
        
        // Add any remaining items from the right list
        while (j < right.size()){
            sorted.add(right.get(j));
            j++;
        }
        return sorted;
    }
    
}
