package com.sucaisheng.dui;


public class DuiPaiXu {
    public static void main(String[] args){
        int index = 0;
        int[] array = {1,4,9,3,5};
        for (int i=0; i<5;i++){
            heapInsert(index++, array);
        }
        for (int i=0 ;i<5; i++){
            //System.out.println(array[i]);
            System.out.println(pop(index--, array));
        }
    }

    public static void heapInsert(int index, int[] heap){
        while(heap[index] < heap[(index - 1) / 2]){
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapfy(int[] arr, int index, int size){
        int left = index * 2 + 1;
        int largeIndex = 0;
        while(left < size){
            largeIndex = left + 1 < size && arr[left + 1] < arr[left] ? left + 1 : left;
            largeIndex = arr[index] < arr[largeIndex] ? index : largeIndex;
            if(largeIndex == index){
                break;
            }
            swap(arr,index,largeIndex);
            index = largeIndex;
            left = index * 2 +1;
        }
    }

    public static int pop(int size,int[] arr){
        int value = arr[0];
        swap(arr,0,--size);
        heapfy(arr,0,size);
        return value;
    }

    public static void swap(int[] arr, int x1, int x2){
        int temp;
        temp = arr[x1];
        arr[x1] = arr[x2];
        arr[x2] = temp;
    }
}
