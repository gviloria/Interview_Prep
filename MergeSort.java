class MergeSort {

  void mergesort(int[] A, int left, int right){
    if (left < right) {
      int mid = (left + right) / 2;
      // Recursively split the arrays until we've reached individual elements
      mergesort(A,left,mid);
      mergesort(A,mid+1,right);
      // We sort the array in a bottom-up fashion
      merge(A,left,mid,right);
    }
  }
  
  void merge(int[] A, int left, int mid, int right){
    
    // The ending indexes and array sizes
    int left_size = mid - left;
    int right_size = right - mid + 1;
    int[] L = new int[left_size];
    int[] R = new int[right_size];
    
    // Copy everything on the left and right arrays to new arrays
    for (int i = 0; i < left_size; i++) {
      L[i] = A[left + i];
    }
    for (int x = 0; x < right_size; x++) {
      R[x] = A[mid + 1 + x];
    }
    
    // Counters for L and R index
    int li = 0;
    int ri = 0;
    
    // Counter for original array index
    int oi = left;
    
    // Compare elements in both arrays and insert into the original array in order
    while (li < left_size && ri < right_size) {
      if (L[li] <= R[ri]){
        A[oi] = L[li];
        li++;
      } else {
        A[oi] = R[ri];
        ri++;
      }
      oi++;
    }
    
    // There may still be left overs in either L or R array so copy them over
    while (li < left_size) {
      A[oi] = L[li];
      oi++;
      li++;
    }
    while (ri < right_size) {
      A[oi] = R[ri];
      oi++;
      ri++;
    }
    
  }
  public static void main (String[] args) {
    int[] A = new int{34, 3, 62, 6, 93, 24, 35, 16, 1};
    mergesort(A,0,A.length-1);
    for(int x:A){
      System.out.print(x+" ");
    }
  }
  
  
}
