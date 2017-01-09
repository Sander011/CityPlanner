package hci.cityplanner.pathfinding;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Sander on 4-1-2017.
 */

public class Distance {

    private LatLng src;
    private LatLng dest;
    private double distance;

    public LatLng getSrc() {
        return src;
    }

    public LatLng getDest() {
        return dest;
    }

    public double getDistance() {
        return distance;
    }

    public Distance(LatLng src, LatLng dest, double distance) {
        this.src = src;
        this.dest = dest;
        this.distance = distance;
    }
}
