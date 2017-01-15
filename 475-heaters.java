// Binaray Search, O(mlogn + nlogn), m: houses.length, n: heaters.length
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) index = -(index + 1);
            radius = Math.max(radius, Math.min(index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE, index > 0 ? house - heaters[index - 1] : Integer.MAX_VALUE));
        }
        return radius;
    }
}

// O(mlogm + nlogn), m: houses.length, n: heaters.length
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0, i = 0;
        for (int house : houses) {
            while (i + 1 < heaters.length && heaters[i + 1] < house) i++;
            radius = Math.max(radius, Math.min(Math.abs(heaters[i] - house), i + 1 < heaters.length ? heaters[i + 1] - house : Integer.MAX_VALUE));
        }
        return radius;
    }
}
