class 冒泡排序 {
   public static void main(String[] args) {
       int[] arr = {5,4,3,2,1};
       popSort(arr);
       // Arrays.sort(arr);
       for (int i : arr) {
           System.out.print(i+",");
       }
   }

    private static void popSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) { // 0 1 2 3
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]> arr[j+1]){
                    int foo = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = foo;
                }
            }
        }
    }
}