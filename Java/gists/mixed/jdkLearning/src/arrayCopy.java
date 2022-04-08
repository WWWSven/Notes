class arrayCopy{
    public static void main(String[] args) {
        new Object();
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = new int[10];
        System.arraycopy(arr,0,arr2,0,arr.length);

        myArrCopy(arr,0,arr2,0,arr.length);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
    public static boolean myArrCopy(
            int[] src,  int  srcPos,
            int[] dest, int destPos,
            int length){
        if (length>dest.length) return false;
        for (int i = srcPos; i < srcPos+length; ) {
            for (int j = destPos; j < destPos+length; j++,i++) {
                dest[j] = src[i];
            }
        }
        return true;
    }
}