package hw04.src;

import hw04.src.collection.CollectionDisk;
import hw04.src.model.*;

public class Main {
    public static void main(String[] args) {
        CollectionDisk myDisk = new CollectionDisk("Моя музика");

        myDisk.addComposition(new Song("Imagine", "John Lennon", 3, 5, 3.12, 15000));
        myDisk.addComposition(new Instrumental("Moonlight Sonata", "Beethoven", 10, 5, 3));

        myDisk.showAll();

        myDisk.sortByStarsDescending();
        myDisk.showAll();

        myDisk.showByType(CompositionType.INSTRUMENTAL);
    }
}
