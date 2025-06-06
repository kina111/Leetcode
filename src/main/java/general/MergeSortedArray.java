package general;

/*
Leetcode#1: Merge Two Array
Link: https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
Sol: Using two pointers and put the greater num to the end instead of pushing the smalled to the begin
Complex: O(n)   0
*/
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        int k = m+n-1;
        while (j >= 0){
            if (i >= 0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else {
                nums1[k--] = nums2[j--];
            }
        }
    }
    
    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }
    public static void main(String[] args) {
        int sizeS1 = 5, sizeS2 = 5;
        int[] nums1 = {4, 5, 6, 7, 8, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 7, 9};
        merge(nums1, sizeS1, nums2, sizeS2);
        display(nums1);
    }
}
