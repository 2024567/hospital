/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.*;

/**
 *
 * @author sorgi
 */
public class sorter {
    
    public static List<String> mergeSort(List<String> names){
        if(names.size() <= 1){
            return names;
        }
        
        int middle = names.size() / 2;
        List<String> left = mergeSort(names.subList(0, middle));
        List<String> right = mergeSort(names.subList(middle, names.size()));
        
        return merge(left,right);
    }
    
    private static List<String> merge(List<String> left, List<String> right){
        List<String> sorted = new ArrayList<>();
        int i=0, j=0;
        
        while(i < left.size() && j < right.size()){
            if(left.get(i).compareToIgnoreCase(right.get(j)) <= 0){
                sorted.add(left.get(i));
                i++;
            } else {
                sorted.add(right.get(j));
                j++;
            }
        }
        
        while(i < left.size()){
            sorted.add(left.get(i));
            i++;
        }
        while (j < right.size()){
            sorted.add(right.get(j));
            j++;
        }
        return sorted;
    }
    
}
