package STRIVERaTOz.BitManipulation.Theory;

public class BasicTheory {
    //convert decimal to Binary:
    public static String convertToBinary(int n) {
        StringBuilder rem = new StringBuilder();
        while (n != 0) {
            if (n % 2 == 1) {
                rem.append('1');
            } else rem.append('0');
            n = n / 2;
        }
        return rem.reverse().toString();
    }

    //convert binary to decimal:
    public static int convertToDecimal(String n) {
        int num = 0;
        int powOf2 = 1;
        for (int i = n.length() - 1; i >= 0; i--) {
            if (n.charAt(i) == '1') num += powOf2;
            powOf2 *= 2;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(convertToBinary(25));
        System.out.println(convertToDecimal("11001"));
    }
}
