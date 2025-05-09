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
public class Searcher {
     
    public static int binarySearch( List<String> names, String target){
        int left = 0;
        int right = names.size() - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            String midVal = names.get(mid);
            
            int cmp = midVal.compareToIgnoreCase(target);
            if(cmp == 0){
                return mid;
            }else if(cmp < 0){
                left = mid +1;
            } else{
                right = mid - 1;
            }
            
        }
        
        return -1;// not found
        
    }
    
    
}
