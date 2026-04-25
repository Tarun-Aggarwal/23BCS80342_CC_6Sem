public class ExtendedGCD {
    
    public static int extendedGCD(int a, int b, int[] temp) {
        if(b == 0) {
            temp[0] = 1;
            temp[1] = 0;
            return a;
        }

        int[] tem = new int[2];
        int gcd = extendedGCD(b, a % b, tem);
        temp[0] = tem[1];
        temp[1] = tem[0] - (a / b) * tem[1];
        return gcd;
    }

    public static void main(String[] args) {
        int a = 30, b = 20;
        int[] temp = new int[2];
        System.out.println("GCD: "+extendedGCD(a, b, temp));
        System.out.println("x: "+temp[0]+" , y: "+temp[1]);
    }
}
