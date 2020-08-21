public class Sort {
    public static void insertionsort(int[] arr) { // stable
        int i, j, temp;
        for(i=1; i<arr.length; i++) {
            temp = arr[i];
            for(j=i; j>0 && arr[j-1] > temp; j--) { // 寻找插入位置
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
    public static void selectionsort(int[] arr) {   // unstable
        int i, j, temp;
        for(i=0; i<arr.length-1; i++) {
            for(j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[i]) {    // 比当前位置小 则交换 每一趟确定一个位置
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void bubblesort(int[] arr) {     // stable
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) { // 向后冒泡
                if(arr[j] > arr[j+1]) {           // 大数往后移 每一趟确定一个位置
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 555, 32, 342, 435, 1455, 145, 4, 6, 7, 231};
        insertionsort(nums);
//        bubblesort(nums);
//        selectionsort(nums);

        for(int n : nums) {
            System.out.print(n+" ");
        }
    }
}
