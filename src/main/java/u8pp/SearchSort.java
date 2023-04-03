package u8pp;
import java.util.ArrayList;

public class SearchSort {
    
    public static void selectionSort (int[] array){
        if(array.length == 0){
            return;
        }
        for(int i = 0; i<array.length; i++){
            int min = i;
            for(int j = i+1; j<array.length; j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static ArrayList<Student> selectionSort(ArrayList<Student> array){
        if(array.size() == 0){
            return array;
        }
        ArrayList<Student> returnArray = new ArrayList<Student>();
        // Loops until array is empty
        for(int i = 0; array.size()>0; i++){
            int min = 0;
            // Finds smallest number in array
            for(int j = 1; j<array.size(); j++){
                if(array.get(j).getYear() <= array.get(min).getYear()){
                    min = j;
                }
            }
        returnArray.add(0, array.remove(min));
        // If any students share the same year, swaps them lexicographicaly
        if(returnArray.size()>1){
            if(returnArray.get(1).getYear() == returnArray.get(0).getYear()){
                if(returnArray.get(1).getLastName().equals(returnArray.get(0).getLastName())){
                    if(returnArray.get(1).getFirstName().compareTo(returnArray.get(0).getFirstName()) < 0){
                        Student temp = returnArray.get(0);
                        returnArray.set(0, returnArray.get(i));
                        returnArray.set(1, temp);
                    } else if (returnArray.get(1).getFirstName().compareTo(returnArray.get(0).getFirstName()) > 0){

                    }
                } else {
                    if(returnArray.get(1).getLastName().compareTo(returnArray.get(0).getLastName()) < 0){
                        Student temp = returnArray.get(0);
                        returnArray.set(0, returnArray.get(i));
                        returnArray.set(1, temp);
                    } else if (returnArray.get(1).getLastName().compareTo(returnArray.get(0).getLastName()) > 0){

                    }
                }
            }
        }
    }
    return returnArray;
}
    

    public static void insertionSort (int[] array){
        // Runs for array length
        for(int bols = 1; bols < array.length; bols++){
            int j = bols;
            int i = bols-1;
            // Swaps i and j while they're not in order until you reach the beginning
            while(i>=0){
                if(array[j]<array[i]){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                }
                i--;
                j--;
            }
        }
    }

    public static ArrayList<Student> insertionSort(ArrayList<Student> array){
        ArrayList<Student> returnArray = new ArrayList<Student>(array);
        for(int bols = 1; bols < array.size(); bols++){
            int j = bols;
            int i = bols-1;
            // Swaps i and j while they're not in order until you reach the beginning
            while(i>=0){
                if(array.get(j).getYear() > array.get(i).getYear()){
                    // Swaps larger year behind
                    Student temp = returnArray.get(i);
                    returnArray.set(i, returnArray.get(j));
                    returnArray.set(j, temp);

                }
                // Cases for if years are the same
                if(returnArray.get(j).getYear() == returnArray.get(i).getYear()){
                    if(returnArray.get(j).getLastName() == returnArray.get(i).getLastName()){
                        if(returnArray.get(j).getFirstName().compareTo(returnArray.get(i).getFirstName()) > 0){
                            //break;
                        } else if (returnArray.get(j).getFirstName().compareTo(returnArray.get(i).getFirstName()) < 0){
                            // Swaps same last name, larger first name behind
                            Student temp1 = returnArray.get(i);
                            returnArray.set(i, returnArray.get(j));
                            returnArray.set(j, temp1);                            }
                    } else {
                        if(returnArray.get(j).getLastName().compareTo(returnArray.get(i).getLastName()) > 0){
                            //break;
                        } else if (returnArray.get(j).getLastName().compareTo(returnArray.get(i).getLastName()) < 0){
                            // Swaps larger last name behind
                            Student temp2 = returnArray.get(i);
                            returnArray.set(i, returnArray.get(j));
                            returnArray.set(j, temp2);       
                        }             
                    }
                }
                i--;
                j--;
            }
            
        }
        return returnArray;
    }

    public static int[] mergeSort (int[] array){
        if(array.length == 0){
            return null;
        } else if(array.length == 1){
            return array;
        } else {
            int mid = array.length/2;
            int[] leftHalf = new int[mid];
            int[] rightHalf = new int[array.length-mid];
            // Splits input array into two halves
            for(int i = 0; i<array.length; i++){
                if(i<mid){
                    leftHalf[i] = array[i];
                } else {
                    rightHalf[i-mid] = array[i];
                }
            }
            // Sorts two lists which they themselves have been recursively sorted.
            return mergeSortHelpr(mergeSort(leftHalf), mergeSort(rightHalf));
        }
    }

    private static int[] mergeSortHelpr (int[] leftHalf, int[] rightHalf){
        
        int[] returnList = new int[leftHalf.length+rightHalf.length];
        int a=0;
        int b=0;
        int c=0;
        // Runs until one half is empty
        while(a < leftHalf.length && b < rightHalf.length){

            if(leftHalf[a] < rightHalf[b]){
                returnList[c] = leftHalf[a];
                a++;
                c++;
            } else if(leftHalf[a] > rightHalf[b]){
                returnList[c] = rightHalf[b];
                b++;
                c++;
            } else {
                returnList[c] = leftHalf[a];
                a++;
                c++;
            }
        }
        while(a < leftHalf.length){
            returnList[c] = leftHalf[a];
            a++;
            c++;
        }
        while(b < rightHalf.length){
            returnList[c] = rightHalf[b];
            b++;
            c++;
        }
        return returnList;
    }

    public static ArrayList<Student> mergeSort(ArrayList<Student> array){
        ArrayList<Student> copyArray = new ArrayList<Student>(array);
        if(copyArray.size() == 0){
            return array;
        } else if(copyArray.size() == 1){
            return copyArray;
        } else {
            ArrayList<Student> leftHalf = new ArrayList<Student>();
            ArrayList<Student> rightHalf = new ArrayList<Student>();
            // Splits input array into two halves
            for(int i = 0; i<copyArray.size(); i++){
                if(i<copyArray.size()/2){
                    leftHalf.add(copyArray.get(i));
                } else {
                    rightHalf.add(copyArray.get(i));
                }
            }
            // Sorts two lists which they themselves have been recursively sorted.
            return mergeSortHelpr(mergeSort(new ArrayList<Student>(leftHalf)), mergeSort(new ArrayList<Student>(rightHalf)));
        }
    }

    private static ArrayList<Student> mergeSortHelpr (ArrayList<Student> leftHalf, ArrayList<Student> rightHalf){
        System.out.println("leftHalfName: " + leftHalf.get(0).getFirstName() + leftHalf.get(0).getLastName());
        System.out.println("leftHalfNum: " + leftHalf.get(0));
        System.out.println("rightHalf: " + rightHalf.get(0).getFirstName() + rightHalf.get(0).getLastName());
        System.out.println("rightHalfNum: " + rightHalf.get(0));
        
        ArrayList<Student> returnArray = new ArrayList<Student>();
        // Runs until one half is empty
        while(leftHalf.size() != 0 && rightHalf.size() != 0){
            // Compares first elements of both lists, and adds the smallest one to the beginning of the list,
            // Meaning the smallest items get pushed to the end each time.
            if(leftHalf.get(0).getYear() < rightHalf.get(0).getYear()){
                returnArray.add(0, leftHalf.remove(0)); 
            } else if(rightHalf.get(0).getYear() < leftHalf.get(0).getYear()){
                returnArray.add(0, rightHalf.remove(0)); 
            } else if(leftHalf.get(0).getYear() == rightHalf.get(0).getYear()){
                if(leftHalf.get(0).getLastName().equals(rightHalf.get(0).getLastName())){
                    if(leftHalf.get(0).getFirstName().compareTo(rightHalf.get(0).getFirstName()) < 0){
                        returnArray.add(0, rightHalf.remove(0)); 
                    } else if (leftHalf.get(0).getFirstName().compareTo(rightHalf.get(0).getFirstName()) > 0){
                        returnArray.add(0, leftHalf.remove(0));                    
                    } else {
                        returnArray.add(0, leftHalf.remove(0));   
                    }
                } else {
                    if(leftHalf.get(0).getLastName().compareTo(rightHalf.get(0).getLastName()) < 0){
                        returnArray.add(0, rightHalf.remove(0)); 
                    } else if (leftHalf.get(0).getLastName().compareTo(rightHalf.get(0).getLastName()) > 0){
                        returnArray.add(0, leftHalf.remove(0));
                    } else {
                        //returnArray.add(leftHalf.remove(0));   
                    }
                }
            }
        }
        // Adds leftover items from whichever list is still full
        while(leftHalf.size()>0){
            returnArray.add(0, leftHalf.remove(0));
        }
        while(rightHalf.size()>0){
            returnArray.add(0, rightHalf.remove(0));
        }
        return returnArray;
    }

    

}
