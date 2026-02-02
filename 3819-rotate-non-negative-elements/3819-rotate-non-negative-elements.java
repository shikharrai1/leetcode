class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int countNonNeg = 0;
        List<Integer> list = new ArrayList<>();
        // find out indexes where non negative is present
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= 0){
                countNonNeg++;
                list.add(i);
            } 
        }
        if(countNonNeg <= 1) return nums;

        int arr1[] = new int[countNonNeg];
        
        k = k%countNonNeg;

        // if(k == 0) return nums;

        for(int i=0; i<list.size(); i++){
            arr1[i] = nums[list.get(i)];
        }

        int arr2[] = new int[k];
        int arr3[] = new int[countNonNeg-k];

        for(int i=0; i<k; i++){
            arr2[i] = arr1[i];
        }
        for(int i=k,j=0; i<arr1.length; i++,j++){
            arr3[j] = arr1[i];
        }

        for(int i=0; i<arr3.length; i++){
            arr1[i] = arr3[i];
        }

        for(int i=arr3.length, j=0; j<arr2.length; i++,j++){
            arr1[i] = arr2[j];
        }

        // now do rotation countNonNeg times
       
        // reverse 1st k i.e., from 0 to k-1
        // reverse(0,k-1,arr1);
        // reverse elements from k to n-1
        // reverse(k,arr1.length-1,arr1);
        // reverse entire arr
        // reverse(0,arr1.length-1,arr1);
        // now reassign values in the original arr at appropriate indexes
        for(int i=0; i<list.size(); i++){
            nums[list.get(i)] = arr1[i];
        }
        
        return nums;
    }
    // reverse
    // public static void reverse(int si, int ei, int arr[]){
    //     while(si < ei){
    //         int temp = arr[si];
    //         arr[si] = arr[ei];
    //         arr[ei] = temp;
    //         si++;
    //         ei--;
    //     }
    // }
}