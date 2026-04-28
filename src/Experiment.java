public class Experiment{
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();
    //measure time for sorting
    public long measureSortTime(int[] arr, String type) {
        long startTime =System.nanoTime();
        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }
    // measure time for searching
    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        searcher.search(arr, target);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    public void runAllExperiments() {
        int[] sizes={10, 100, 1000}; //small, medium, large

        for (int size : sizes) {
            System.out.println(" size: " + size );
            int[] data = sorter.generateRandomArray(size);
            int[] dataCopy = data.clone(); //use a copy so both get unsorted data

            long basicTime = measureSortTime(data, "basic");
            long advTime = measureSortTime(dataCopy, "advanced");

            System.out.println("Basic Sort: "+basicTime+ " ns");
            System.out.println("Advanced Sort: " +advTime+ " ns");

            // search experiment (using sorted data)
            long searchTime = measureSearchTime(data,500);
            System.out.println("Search Time: " +searchTime + " ns");
            System.out.println();
        }
    }
}