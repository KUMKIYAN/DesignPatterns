package designprinciples;
// there are two classes algorithm for sorting  -> bubble sort and quick sort
// we need to call either BubbleSortAlgorithm method or QuickSortAlgorithm method
// This is tight coupled because it is not dynamic. we decide one algorithm and put in this line.

interface SortAlgorithm{
    public int[] sort(int number[]);
}

class BinarySearch1{
    SortAlgorithm sortAlgorithm;

    public BinarySearch1(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int binarySearch(int[] numbers, int numberWeAreLookingFor){
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        // write some logic to find the position of the numberWeAreLookingFor
        // return the position of the number
        return 2;
    }
}

class BubbleSortAlgorithm1 implements SortAlgorithm{
    @Override
    public int[] sort(int number[]){
        System.out.println("Bubble Sort Alogorithm");
        //we have some bubble sorting logic here
        int a[] = {0,1,2,3,4,34};
        return a;
    }
}

class QuickSortAlgorithm1 implements SortAlgorithm{
    @Override
    public int[] sort(int number[]){
        System.out.println("Quick Sort Alogorithm");
        //we have some quick sorting logic here
        int a[] = {0,1,2,3,4,34};
        return a;
    }
}

class SpringBootClass1{
    public static void main(String args[]){
        BinarySearch1 binarySearch = new BinarySearch1(new QuickSortAlgorithm1());
        // In the above line we can pass either quick sort / Bubble Sort
        System.out.println(binarySearch.binarySearch(new int[] {34,2, 3, 4, 1, 0}, 3));
    }
}

