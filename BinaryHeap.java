
public class BinaryHeap {

    int size;
    int [] a;

    public BinaryHeap(){
        size = 0;
        a = new int[10];  //intialize the array to 10
    }

    private void growArray(){
        int [] arr = new int[a.length*2];      //this grows the array if we cannot add due to the size
        for (int i = 0; i < a.length; i++){
            arr[i] = a[i];
        }
        a = arr;
    }

    private void siftdown(int parent){          //this swtiches the heap so the smallest priority is the root after a swap
        int child = 2 * parent + 1;
        if(child < size) {
            if (child + 1 < size && (a[child] > a[child + 1])) {
                child += 1;
            }
            if (a[parent] > a[child]) {
                swap(parent, child);
                siftdown(child);
            }
        }
    }

    private void swap(int x, int y){   //the method that swaps two values
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public void add(int value){
        if(size == a.length){           //this adds a value to the heap 
            growArray();
        }

        a[size++] = value;
        int child = size - 1;
        int parent = (child - 1) / 2;

        while(parent >= 0 && (a[parent] > a[child])){      //if the parents and child need to swap
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public int remove(){
        if(size == 0){

            throw new IndexOutOfBoundsException();
        }

        int removed = a[0];
        a[0] = a[--size];

        siftdown(0);                   //the remove funtion removes the root, when the root is removed to keep the tree ordered we swap what needs be. 
        return removed;
    }    

}