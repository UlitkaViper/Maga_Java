package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    /* №1 */
	    int[] nums = {1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                nums[i] = 1;
            }
            else{
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));

    /* №2 */
        int nums2[] = new int[8];

        for (int i = 0; i < nums2.length; i++){
            nums2[i] = i * 3;
        }
        System.out.println(Arrays.toString(nums2));

    /* №3 */
        int[] nums3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < nums3.length; i++){
            if (nums3[i] < 6){
                nums3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(nums3));

    /* №4 */
        int nums4[][] = new int[5][5];
        System.out.println(nums4.length);
        for (int i = 0; i < nums4.length; i++){
            for (int j = 0; j < nums4[i].length; j++){
                if (i == j){
                    nums4[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(nums4[i]));
        }

    /* №5 */
        int nums5[] = {69, 420, 111, 222, 322, 146};

        for (int i = 0; i < nums5.length; i++){
            for (int j = i; j < nums5.length; j++){
                if (nums5[i] > nums5[j]){
                    int temp = nums5[i];
                    nums5[i] = nums5[j];
                    nums5[j] = temp;
                }
            }
        }
        System.out.println("Min: " + nums5[0] + ", Max: " + nums5[nums5.length - 1]);

    /* №6 */
        int nums6[] = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(nums6));

    }

    public static boolean checkBalance(int nums6[]){
        int tempSumm = 0;
        int tempSummArray[] = new int[nums6.length - 1];

        for (int i = 0; i < nums6.length - 1; i++){
            tempSumm += nums6[i];
            tempSummArray[i] = tempSumm;
        }
        System.out.println(Arrays.toString(tempSummArray));
        tempSumm = nums6[nums6.length - 1];
        for (int i = nums6.length - 2; i >= 0; i--){
            tempSumm += nums6[i];
            for (int j = 1; j < i; j++){
                if (tempSumm == tempSummArray[j]){
                        return true;
                }
            }
        }
        return false;
    }
}
