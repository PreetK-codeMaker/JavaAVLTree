package appDriver;

import avlTree.AvlTree;
import exception.AvlExceptions;
public class main {
    public static void main(String[] args) throws AvlExceptions {

        AvlTree<Integer>d = new AvlTree<>();

        long total = 0;
        for (int i = 0; i <= 1000000; i ++) {

            int range = (1000000 -i) +1;
            long StaddTime  = System.nanoTime();
            d.add((int)(Math.random() * range) + i);
            long EdaddTime  = System.nanoTime();
            total += ( EdaddTime - StaddTime );
        }

        System.out.println("Total Nano Sec for Add  "+ total);

        double avdTimeForaAdd = (total/ 1000000);
        System.out.println("Average per insertion: "+ avdTimeForaAdd);

        System.out.println("----------------------------------------------Removal-----------------------------");
        long removalTime= 0;
        for (int i = 495800; i > 0; i--) {
            long StartTime  = System.nanoTime();
            int range = (495800 - i) + 1;
            d.remove((int) (Math.random() * range) + i);
            long endTime  = System.nanoTime();
            removalTime += (endTime - StartTime);
        }
        System.out.println("Total Nano Sec for removal " + removalTime);
        System.out.println("Average per Removal time: "+ (double)removalTime/495800);

        System.out.println("----------------------------------------------Search-----------------------------");
    long searchTime= 0;
        for (int i = 504200; i > 0; i--) {
            long StartTime  = System.nanoTime();
            int range = (504200 - i) + 1;
            d.search((int) (Math.random() * range) + i);
            long endTime  = System.nanoTime();
            searchTime += (endTime - StartTime);
        }

        System.out.println("Total Nano Sec for Search " + searchTime);
        System.out.println("Average per search time: "+ (double)searchTime/504200);

    }

}
