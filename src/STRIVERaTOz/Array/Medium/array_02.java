package STRIVERaTOz.Array.Medium;

import java.util.HashMap;

//Majority Element-I;
public class array_02 {
    //BruteForce approach:
    public static int majorityElem(int[] arr){
        for(int i: arr){
            int count =0;
            for(int j: arr){
                if(i==j) count++;
            }
            if(count > Math.floor((double) arr.length /2)) return i;
        }
        return -1;
    }

    //Better solution(Using HashMap):
    public static int majorityEle(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i)> arr.length/2) return i;
        }
        return -1;
    }

    //Optimal Solution(Moore's voting algorithm):
    public static int majorityElements(int[] arr){
        int count =0;
        int element=-1;
        for(int i: arr){
            if(count==0){
                count=1;
                element=i;
            }else if(element==i){
                count++;
            }else count--;
        }
        int newCount =0;
        for(int i: arr){
            if(i==element) newCount++;
        }
        if(newCount>arr.length/2) return element;
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,1,1,1,2,2};
        System.out.println(majorityElements(arr));
    }
}
