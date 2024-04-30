package test;

public class Q1 {
    public static void main(String[] args) {

        int[] nums = {21,22,30,11,99,31};


        for (int i = 0; i < nums.length / 2; i++) {
           int index = nums.length -i -1;
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;

            // length는 6임. 나는 5인줄 (0부터 시작해서 5...)


        }


    }
}

