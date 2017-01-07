package hci.cityplanner.pathfinding;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Sander on 4-1-2017.
 */

public class DistanceCalculator {
    // Use Haversines method to calculate the distance, height not included
    public static double calculateDistance(LatLng src, LatLng dest) {
        double result = 0;

        final int radiusEarth = 6371;

        Double latDistance = Math.toRadians(dest.latitude - src.latitude);
        Double longDistance = Math.toRadians(dest.longitude - src.longitude);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(src.latitude)) * Math.cos(Math.toRadians(dest.latitude))
                * Math.sin(longDistance / 2) * Math.sin(longDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        result = radiusEarth * c * 1000;
        return result;
    }
}
