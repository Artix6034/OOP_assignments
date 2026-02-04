package agency.algorithms;

import agency.models.Apartment;
import java.util.ArrayList;
import java.util.List;
public class Apartmentsorter {
    public static List<Apartment> bubbleSort(List<Apartment> apartments) {
        List<Apartment> sorted = new ArrayList<>(apartments);
        int n = sorted.size();

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (sorted.get(j).getprice() > sorted.get(j + 1).getprice()) {
                    // Swap
                    Apartment temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                    swapped = true;
                }
            }

            // Если не было обменов, массив уже отсортирован
            if (!swapped) break;
        }

        return sorted;
    }
}
