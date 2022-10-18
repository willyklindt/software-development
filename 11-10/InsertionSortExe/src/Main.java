public class Main {

    public static void main(String[] args) {

        int arr[] = {12, 45, 76, 34, 4, 6, 102, 34, 23, 544545, 2, 3};
        int length = arr.length;
        InsertionSort iSort = new InsertionSort();
        iSort.sort(arr);

        for (int i = 0; i < length; i++) {
            System.out.println(arr[i] + " ");
        }

    }

}

class InsertionSort { void sort(int arr[])
    {
        int pointer = arr.length;

        for (int i = 1; i < pointer; i++)
        {
            int current = arr[i];
            int position = i-1;

            while (position >= 0 && arr[position] > current)
            {
                arr[position+1] = arr[position];
                position = position-1;
            }
            arr[position+1] = current;
        }
    }
}
