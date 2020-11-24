/*
 * Agnes@needemand
 */
package tools;

/**
 *
 * @author agnes
 */
public class MyArray {
    
    /**
     * 
     * @param arr
     * @param val
     * @return 
     */
    public static boolean contains(String[] arr, String val){
        boolean flag = false;
        for (String string : arr) {
            if(string.equals(val)){
                flag = true;
            }
        }
        return flag;
    }
    
    public static int indexOf(String[] arr, String val){
        int index = 0, i = 0;
        for (String string : arr) {
            if(string.equals(val)){
                index = i;
            }
        }
        return index;
    }
}
