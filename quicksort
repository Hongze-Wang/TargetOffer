public class Exercise {
    public static int[] quicksort(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while ((i < j) && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while ((i < j) && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        if (i - 1 > left) arr = quicksort(arr, left, i - 1);
        if (j + 1 < right) arr = quicksort(arr, j + 1, right);
        return arr;
    }
    public static void main (String[]args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        int len = arr.length - 1;
        arr = quicksort(arr, 0, len);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
