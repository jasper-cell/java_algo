package niuke;

public class findKth {
    public int findkth(int[] a, int n, int K){
        int res = findk(a, 0, n, K);
        return res;
    }

    private int findk(int[] a, int left, int right, int k) {
        if(left < right) {

            int index = partition(a, left, right);

            if (index == k - 1) {
                return a[index];
            } else if (index > k) {
                findk(a, left, index, k);
            } else {
                findk(a, index + 1, right, k);
            }

        }
        return -1;
    }

    private int partition(int[] a, int left, int right) {
        int mark = a[left];

        int i = left+1;
        int j = right;
        while (i < j){
            if(mark < a[i]){
                j--;
                swap(a, i, j);
            }
            else{
                i++;
            }
        }
        swap(a, left, i-1);
        return i-1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
