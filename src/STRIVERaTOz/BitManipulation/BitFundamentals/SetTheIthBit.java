package STRIVERaTOz.BitManipulation.BitFundamentals;

public class SetTheIthBit {
    public static int settingIthBit(int n, int i){
        return (n | (1<< i ));
    }
    public static void main(String[] args) {
        System.out.println(settingIthBit(9,2));
    }
}
