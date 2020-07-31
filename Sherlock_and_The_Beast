public class Solution{
static void caluclate(int length) {
         StringBuilder out = new StringBuilder();
         int arr[] = getAIntArray(length);
         boolean canProduceAnswer = false;

        Arrays.fill(arr, 5);
            int result=length/3;
            while(true) {    
                int divisble_By_5_Length= (length-(result*3));
                // 11  9  - 2
                if(divisble_By_5_Length%5==0) {
                    long currentMillis,dif;
                     currentMillis = System.currentTimeMillis();
                    for(int i=0;i<result*3;i++) {
                    //    arr[i] = 5;
                    // System.out.print(5+"");
                        out.append(5);
                     
                    }                
                    for(int i=0,place=length-1;i<divisble_By_5_Length;i++,place--) {
                        //arr[place] = 3;
                        out.append(3);
                    }
 
                    out.append("\n");
                    
                     dif= System.currentTimeMillis() - currentMillis;
                       // System.out.println("time take for arranging the number : "+dif);
                    
                    canProduceAnswer = true;
                    break;
                    
                }
                result = result-1;
                if(result<0)
                    break;
                
            }
            if(!canProduceAnswer) {
                System.out.println(-1);
            }else{
                
                System.out.print(out);
                
            }
            
            
    }
public static void main(String args[]){

}
}
