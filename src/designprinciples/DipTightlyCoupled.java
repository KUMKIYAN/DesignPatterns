package designprinciples;
// there are two classes algorithm for sorting  -> bubble sort and quick sort
// we need to call either BubbleSortAlgorithm method or QuickSortAlgorithm method
// This is tight coupled because it is not dynamic. we decide one algorithm and put in this line.

class BinarySearch{
    public int binarySearch(int[] numbers, int numberWeAreLookingFor){
        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
        // write some logic to find the position of the numberWeAreLookingFor
        return 2; // return the position of the number
    }
}

class BubbleSortAlgorithm{
    public int[] sort(int number[]){
        //we have some bubble sorting logic here
        int a[] = {0,1,2,3,4,34};
        return a;
    }
}

class QuickSortAlgorithm{
    public int[] sort(int number[]){
        //we have some quick sorting logic here
        int a[] = {0,1,2,3,4,34};
        return a;
    }
}

class SpringBootClass{
    public static void main(String args[]){
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(new int[] {34,2, 3, 4, 1, 0}, 3));
    }
}