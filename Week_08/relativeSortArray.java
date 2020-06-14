class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        for(int num: arr1)
            arr[num] ++;
        int pos = 0;
        for(int num: arr2)
            while(arr[num] -- > 0)
                arr1[pos ++] = num;
        for(int i = 0; i < 1001; i ++)
            while(arr[i] -- > 0)
                arr1[pos ++] = i;
        return arr1;
    }
}