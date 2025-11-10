public class Main {

    public static void main(String[] args){
        int[] array = {9,3,4,7,6,1,8,2,0};

        bubbleSort(array);

        for(int i : array){
            System.out.println(i);
        }



    }

    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
