package HomeWorks.hw04.collection;
import HomeWorks.hw04.model.*;


import java.util.ArrayList;
import java.util.Comparator;

public class CollectionDisk {
    private String name;                        // назва колекції
    private ArrayList<Composition> compositions; // список композицій

    public CollectionDisk(String name) {
        this.name = name;
        this.compositions = new ArrayList<>();
    }

    // ✅ Додати композицію
    public void addComposition(Composition composition) {
        if (composition != null) {
            compositions.add(composition);
            System.out.println("✅ Додано композицію: " + composition.getName());
        }
    }

    // ❌ Видалити композицію за назвою
    public void removeComposition(String name) {
        boolean removed = compositions.removeIf(c -> c.getName().equalsIgnoreCase(name));
        if (removed)
            System.out.println("❌ Видалено композицію: " + name);
        else
            System.out.println("⚠ Композицію \"" + name + "\" не знайдено.");
    }

    // 🔍 Знайти композицію за назвою
    public Composition findByName(String name) {
        for (Composition c : compositions) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    // 📋 Показати всі композиції
    public void showAll() {
        System.out.println("\n🎵 Колекція: " + name);
        if (compositions.isEmpty()) {
            System.out.println("(порожня)");
            return;
        }

        for (Composition c : compositions) {
            System.out.println("-------------------------------");
            c.showInfo();
        }
    }

    // 🔢 Повернути кількість композицій
    public int getCount() {
        return compositions.size();
    }

    // 🔽 Відсортувати за тривалістю
    public void sortByLength() {
        compositions.sort(Comparator.comparingInt(Composition::getSongLength));
        System.out.println("✅ Відсортовано за тривалістю.");
    }

    // ⭐ Відсортувати за рейтингом (кількістю зірок)
    public void sortByStarsDescending() {
        compositions.sort((a, b) -> Integer.compare(b.getStars(), a.getStars()));
        System.out.println("✅ Відсортовано за популярністю (зірки ↓).");
    }

    // 🎼 Фільтрувати композиції за типом
    public void showByType(CompositionType type) {
        System.out.println("\n🎧 Композиції типу: " + type.getDescription());
        boolean found = false;
        for (Composition c : compositions) {
            if (matchesType(c, type)) {
                c.showInfo();
                found = true;
            }
        }
        if (!found) System.out.println("(немає композицій цього типу)");
    }

    // Визначення типу (через instanceof)
    private boolean matchesType(Composition c, CompositionType type) {
        return switch (type) {
            case SONG -> c instanceof HomeWorks.hw04.model.Song;
            case INSTRUMENTAL -> c instanceof HomeWorks.hw04.model.Instrumental;
            case SYMPHONY -> c instanceof HomeWorks.hw04.model.Symphony;
        };
    }
}
