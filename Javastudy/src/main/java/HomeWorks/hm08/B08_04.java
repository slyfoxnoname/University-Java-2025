package HomeWorks.hm08;

import java.util.Comparator;
import java.util.PriorityQueue;


public class B08_04 {
    public static void main(String[] args) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(Point::distanceSquared));

        pq.add(new Point(3, 4));   // d=5
        pq.add(new Point(1, 1));   // d=√2
        pq.add(new Point(-2, 2));  // d=√8
        pq.add(new Point(0, 5));   // d=5
        pq.add(new Point(0, 0));   // d=0

        System.out.println("Точки у порядку зростання відстаней до (0,0):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
