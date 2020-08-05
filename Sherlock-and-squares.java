public class sherlock-and-squares {
     static int squares(int a, int b) {
        double a1= Math.sqrt(a),
        b1=Math.sqrt(b);
        System.out.println(a1+" "+b1);
        if(isInt(a1)&&isInt(b1)){
            a1--;
        }else if(isInt(a1)||isInt(b1)){
            if(isInt(a1)){
                a1--;
            }
            if(isInt(b1)){
                b1++;
            }
        }else{
            a1=Math.floor(a1);
            b1= Math.floor(b1);
        }
        return (int)(b1-a1);
    }
    static boolean isInt(double a){
        return ((a-Math.floor(a))==0);
    }
    public static void main(String args[]){

    }
}
