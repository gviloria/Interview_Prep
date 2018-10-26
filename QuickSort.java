class QuickSort {
  public static void main(String[] args) {
    int[] A = new int{23,6,30,12,32,9,40};
    quicksort(A,0,A.length-1);
    for(int x:A){
      System.out.print(x+" ");
    }
  }
  
  static void quicksort(int[] A, int start, int end){
    if (start < end) {
      // We sort the array and we find the partition index
      int partition_index = partition(A,start,end);
      quicksort(A,start,partition_index);
      quicksort(A,partition_index+1,end);
    }
  }
  
  static int partition(int[] A, int start, int end){
    // Initially set pivot as the right-most element
    int pivot = A[end];
    partition_index = start;
    int temp;
    // Set every less than pivot to the left and anythign greater to the right
    for (int i = start; i < end; i++ ){
      if (A[i] <= pivot){
        temp = A[i];
        A[i] = A[partition_index];
        A[partition_index] = temp;
        partition_index++;
      }
    }
    // Set the pivot to the partition_index
    // Array after for loop: [1,2,5,>13<,8,24,>6<] where 6 = pivot and 3 = partition_index
    // Array after swap: [1,2,5,< 6 >,8,24,13]
    temp = A[partition_index];
    A[partition_index] =  A[end];
    A[end] = temp;
    
    return partition_index;
  }
}
