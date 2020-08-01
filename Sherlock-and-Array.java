
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sherlock-and-Array {
public static void main(String args[]) {
	List<Integer> list=new ArrayList<Integer>();
	list.add(0);//a
	list.add(0);//b
	list.add(0);//c
	list.add(0);//d
	list.add(1);//e
	list.add(0);//f
	list.add(0);//g
	list.add(0);//h
	list.add(0);//i
	convertListToArray(list);
	//list.add(0);//j
	System.out.println(balancedSums(list));
	
}
static int[]  convertListToArray(List<Integer> list) {
	List<Integer> list1=new ArrayList<Integer>();
	list1.add(0);
	list.removeAll(list1);
//	for(Integer i:list) {
//		System.out.println(i);
//	}
	return list.stream().mapToInt(i->i).toArray();
	
}
// Complete the balancedSums function below.
static String balancedSums(List<Integer> arr) {
int[] array = arr.stream().mapToInt(i->i).toArray();
 System.out.println("start");
 if(array.length>7){
     int mid = getHalf(array.length)- 1;
     return iterate(array,mid,0,array.length-1);
 }
    for(int i=0;i<array.length;i++){
        int leftSum = 0,rightSum=0;
        for(int k=0;k<i;k++){
            leftSum += array[k];
        }
        for(int j=i+1;j<array.length;j++){
            rightSum+= array[j];
        }
        System.out.println("leftSum:"+leftSum+" rightSum:"+rightSum);
        if(leftSum==rightSum)
            return "YES";
    }
    return "NO";
}
 static String iterate(int arr[],int mid ,int left,int right){
    int leftSum = getSum(arr,0,mid-1);
    int rightSum= getSum(arr,mid+1,arr.length-1);
    if(mid==left||mid==right||(left>right)) {
    		return "NO";
    	
    }     
    if(leftSum==rightSum)
    return "YES";
    if(leftSum<rightSum){
    	//move right
        int newMid = mid+(getHalf(right-mid));
        return iterate(arr,newMid,mid,right);
    }else {
    	//move left
        int newMid = getHalf(mid);
        return iterate(arr,newMid,left,mid);
    }
}
//incuding end position
static int getHalf(int num) {
	int half=num/2;
	half = (num%2==0)?half:half+1;
	return half;
}
static int getSum(int []arr,int start,int end){
    if(start<0){
    //	System.out.println("cannot be ");
        return 0;
        
    }
    if(end>=arr.length){
    //	System.out.println("cannot be ");
        return 0;
        
    }
    
    int toReturn =0;
    for(int i=start;i<=end;i++)
        toReturn+=arr[i];

    return toReturn;
}



}
