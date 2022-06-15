package June;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Week2{
    public static void main(String[] args){

        int[] MedianArray1;
        int[] MedianArray2;

        MedianArray1 = getRandomSortedIntArray();
        MedianArray2 = getRandomSortedIntArray();

        //MedianArray1 = new int[] {1, 3};
        //MedianArray2 =  new int[] {2,50};
        System.out.println(median(MedianArray1, MedianArray2));

        LinkedList<Integer>[] kMerge = new LinkedList[new Random().nextInt(10) + 1];
        for (int i = 0; i < kMerge.length; i++)
            kMerge[i] = arrayToLinkedList(getRandomSortedIntArray());

        System.out.println(combineSortedLinkList(kMerge));
    }

    static int[] getRandomSortedIntArray(){
        Random rand = new Random();
        int[] randInts = new int[rand.nextInt(10) + 1];
        for (int i = 0; i < randInts.length; i++)
            randInts[i] = rand.nextInt(200);
        int[] sortedResult = Arrays.stream(randInts).sorted().toArray();
        StringBuilder builder = new StringBuilder("\t[");
        for (int i = 0; i < sortedResult.length; i++) {
            String append = (i != sortedResult.length - 1) ? ", " : "]";
            builder.append(sortedResult[i] + append);
        }
        System.out.println(builder);
        return sortedResult;
    }

    static double median(int[] MA1, int[] MA2){

        LinkedList<Integer> linkedList1 = arrayToLinkedList(MA1);
        LinkedList<Integer> linkedList2 = arrayToLinkedList(MA2);

        LinkedList<Integer> sortedLinkList = combineSortedLinkList(linkedList1, linkedList2);

        int midpoint = sortedLinkList.size() / 2 - 1;
        if (sortedLinkList.size() % 2 == 1) {
            return sortedLinkList.get(midpoint);
        }
        return (sortedLinkList.get(midpoint) + sortedLinkList.get(midpoint + 1)) / 2D;
    }

    static LinkedList<Integer> arrayToLinkedList(int[] array){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int item : array) {
            linkedList.add(item);
        }
        return linkedList;
    }

    static LinkedList<Integer> combineSortedLinkList(LinkedList<Integer>... args){
        LinkedList<Integer> result = new LinkedList<>();
        while (Arrays.stream(args).anyMatch(x -> !x.isEmpty())) {
            LinkedList<Integer> peekResult = null;
            for (LinkedList<Integer> item : args) {
                if (!item.isEmpty() && (peekResult == null || item.peek() < peekResult.peek()))
                    peekResult = item;
            }
            result.add(peekResult.pollFirst());
        }
        return result;
    }
}