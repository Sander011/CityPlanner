package hci.cityplanner;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import hci.cityplanner.pathfinding.Distance;

import static hci.cityplanner.pathfinding.DistanceCalculator.calculateDistance;
import static java.lang.Thread.sleep;

public class ChooseRouteActivity extends AppCompatActivity implements OnMapReadyCallback {
    private TreeMap<String, Highlight> highlights;
    private GoogleMap map;
    private hci.cityplanner.Distance distance = hci.cityplanner.Distance.NORMAL;
    private List<Distance> distances;

    private List<List<LatLng>> routeList = new ArrayList<>();

    private double maxLength = 10000;

    private int sizeA;
    private int sizeB;
    private int sizeC;

    private double distanceA = 0.0;
    private double distanceB = 0.0;
    private double distanceC = 0.0;
    private List<Double> routeDistances = new ArrayList<>();

    private int p = 0;


    private int color = Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_route);
        Bundle b = getIntent().getBundleExtra("Data");
        String[] high = Arrays.copyOf((Object[]) b.get("Highlights"), ((Object[]) b.get("Highlights")).length, String[].class);
        highlights = new TreeMap<>();
        JSONHelper jsonHelper = new JSONHelper();
        HashMap<String, Highlight> temp = new HashMap<>();
        temp = jsonHelper.parseJSON();
        for (String s : high) {
            highlights.put(s, temp.get(s));
        }

//        switch(SOMETHING) {
//            case 0:
//                maxLength = 5000;
//                break;
//            case 1:
//                maxLength = 10000;
//                break;
//            case 2:
//                maxLength = 15000;
//                break;
//            default:
//                maxLength = 10000;
//                break;
//
//        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.previewMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;
        if (!(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            googleMap.setMyLocationEnabled(true);
        }
        ArrayList<LatLng> list = new ArrayList<>();

        for (Highlight h : highlights.values()) {
            list.add(new LatLng(h.getLattitude(), h.getLongtitude()));
        }
        PolygonOptions options = new PolygonOptions();
        for (LatLng l : list) {
            options.add(l);
        }
        options.fillColor(Color.TRANSPARENT);
        options.strokeColor(Color.BLUE);
        //Polygon polygon = googleMap.addPolygon(options);
        List<MarkerOptions> markers = new ArrayList<>();
        for (Highlight highlight : highlights.values()) {
            if (highlight.equals(highlights.firstEntry().getValue())) {
                MarkerOptions options1 = new MarkerOptions()
                        .position(new LatLng(highlight.getLattitude(), highlight.getLongtitude()))
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                googleMap.addMarker(options1);
                markers.add(options1);
            } else {
                MarkerOptions options1 = new MarkerOptions()
                        .position(new LatLng(highlight.getLattitude(), highlight.getLongtitude()));
                markers.add(options1);
                googleMap.addMarker(options1);
            }
        }

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for(MarkerOptions marker : markers) {
            builder.include(marker.getPosition());
        }
        LatLngBounds bounds = builder.build();
        int padding = 150;
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds,padding);
        googleMap.moveCamera(cu);
        googleMap.animateCamera(cu);
        fillDistances();
        List<LatLng> routeA = getRouteA();
        sizeA = routeA.size();
        routeList.add(routeA);
        routeDistances.add(distanceA);
        TextView a = (TextView)findViewById(R.id.routeA);
        a.setText("Distance: " + routeDistances.get(0).intValue() / 1000 + " km");
        List<LatLng> routeB = getRouteB();
        sizeB = routeB.size();
        routeList.add(routeB);
        routeDistances.add(distanceB);
        TextView b = (TextView)findViewById(R.id.routeB);
        b.setText("Distance: " + routeDistances.get(1).intValue() / 1000 + " km");
        List<LatLng> routeC = getRouteC();
        sizeC = routeC.size();
        routeList.add(routeC);
        routeDistances.add(distanceC);
        TextView c = (TextView)findViewById(R.id.routeC);
        c.setText("Distance: " + routeDistances.get(2).intValue() / 1000 + " km");

        for (int i = 0; i < routeA.size() - 1; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String url = getDirectionsUrl(routeA.get(i), routeA.get(i + 1));
            DownloadTask dt = new DownloadTask();
            dt.execute(url);
        }
        for (int i = 0; i < routeB.size() - 1; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String url = getDirectionsUrl(routeB.get(i), routeB.get(i + 1));
            DownloadTask dt = new DownloadTask();
            dt.execute(url);
        }
        for (int i = 0; i < routeC.size() - 1; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String url = getDirectionsUrl(routeC.get(i), routeC.get(i + 1));
            DownloadTask dt = new DownloadTask();
            dt.execute(url);

        }
    }

    public void showInfo(View view) {
        int id = view.getId();
        String route = "";
        int routeNo = 0;
        Set<Highlight> routeHighlights = new HashSet<>();
        switch (id) {
            case R.id.info1:
                routeHighlights = findHighlight(0);
                route = "A";
                routeNo = 0;
                break;
            case R.id.info2:
                routeHighlights = findHighlight(1);
                route = "B";
                routeNo = 1;
                break;
            case R.id.info3:
                routeHighlights = findHighlight(2);
                route = "C";
                routeNo = 2;
                break;
            default:
                System.out.println("Niet mogelijk");
        }
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);

        dialog.setTitle("Route " + route);

        TextView text = (TextView) dialog.findViewById(R.id.dialogText);
        int distance = routeDistances.get(routeNo).intValue() / 1000;
        String result = "Distance of this route: " + distance + " km\n\nHighlights: \n";
        for(Highlight highlight : routeHighlights) {
            result += "\t" + highlight.getName() + "\n";
        }

        text.setText(result);
        Button dialogButton = (Button)dialog.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private Set<Highlight> findHighlight(int route) {
        Set<Highlight> routeHighlights = new HashSet<>();
        for (Highlight h : highlights.values()) {
            for (LatLng l : routeList.get(route)) {
                if (h.getLatLng().equals(l)) {
                    routeHighlights.add(h);
                }
            }
        }
        return routeHighlights;
    }

    private void fillDistances() {
        //        Set<Vertex> nodes = new HashSet<>();
//        List<Edge> edges = new ArrayList<>();
        distances = new ArrayList<>();

        for (Highlight h : highlights.values()) {
            for (Highlight h1 : highlights.values()) {
//                Vertex v = new Vertex("id=" + h.getName(), h.getName());
//                Vertex v2 = new Vertex("id=" + h1.getName(), h1.getName());
                distances.add(new Distance(h.getLatLng(), h1.getLatLng(), calculateDistance(h.getLatLng(), h1.getLatLng())));
//                edges.add(new Edge("idEdge=" + h.getName() + h1.getName(), v, v2, calculateDistance(h.getLatLng(), h1.getLatLng())));
            }
        }
//        List<Vertex> vertices = new ArrayList<>();
//        for(Vertex vertex : nodes) {
//            vertices.add(vertex);
//        }

    }

    public List<LatLng> getRouteC() {
        double routeDistance = 0.0;
        List<LatLng> route = new ArrayList<>();
        route.add(highlights.firstEntry().getValue().getLatLng());
        int count = 0;
        double shortest = 0.0;
        Distance temp = null;
        int counter = 0;
        while (route.size() != highlights.size()) {
            for (Distance d : distances) {
                if (d.getSrc().equals(route.get(count)) && !route.contains(d.getDest())) {
                    if (d.getDistance() < shortest || shortest == 0.0) {
                        shortest = d.getDistance();
                        temp = d;
                    }
                    counter++;
                    if (counter >= highlights.size() - route.size()) {
                        route.add(temp.getDest());
                        routeDistance += temp.getDistance();
                        counter = 0;
                        count++;
                        shortest = 0.0;
                    }

                }
            }
        }
        routeDistance += calculateDistance(route.get(route.size() - 1), route.get(0));
        distanceC = routeDistance;
        route.add(route.get(0));
        return route;
    }


    public List<LatLng> getRouteA() {
        double routeLength = 0.0;
        double returnDistance = 0.0;
        List<LatLng> route = new ArrayList<>();
        route.add(highlights.firstEntry().getValue().getLatLng());
        int count = 0;
        double shortest = 0.0;
        Distance temp = null;
        int counter = 0;
        boolean isActive = true;
        while (route.size() != highlights.size()) {
            for (Distance d : distances) {
                if (d.getSrc().equals(route.get(count)) && !route.contains(d.getDest())) {
                    if (d.getDistance() < shortest || shortest == 0.0) {
                        shortest = d.getDistance();
                        temp = d;
                    }
                    counter++;
                    if (counter >= highlights.size() - route.size()) {
                        route.add(temp.getDest());
                        routeLength += (temp.getDistance());
                        counter = 0;
                        count++;
                        shortest = 0.0;
                        for (Distance distance : distances) {
                            if (distance.getSrc().equals(route.get(count)) && distance.getDest().equals(route.get(0))) {
                                returnDistance = distance.getDistance();
                            }
                        }
                        if (routeLength + returnDistance >= maxLength) {
                            routeLength += returnDistance;
                            isActive = false;
                        }
                    }

                }
                if (!isActive) {
                    break;
                }
            }
            if (!isActive) {
                break;
            }
        }
        route.add(route.get(0));
        distanceA = routeLength;
        return route;
    }


    public List<LatLng> getRouteB() {
        double routeLength = 0.0;
        double returnDistance = 0.0;
        List<LatLng> route = new ArrayList<>();
        route.add(highlights.firstEntry().getValue().getLatLng());
        int count = 0;
        double shortest = 0.0;
        Distance temp = null;
        int counter = 0;
        boolean isActive = true;
        while (route.size() != highlights.size()) {
            for (Distance d : distances) {
                if (d.getSrc().equals(route.get(count)) && !route.contains(d.getDest())) {
                    if (d.getDistance() < shortest || shortest == 0.0) {
                        shortest = d.getDistance();
                        temp = d;
                    }
                    counter++;
                    if (counter >= highlights.size() - route.size()) {
                        route.add(temp.getDest());
                        routeLength += (temp.getDistance());
                        counter = 0;
                        count++;
                        shortest = 0.0;
                        for (Distance distance : distances) {
                            if (distance.getSrc().equals(route.get(count)) && distance.getDest().equals(route.get(0))) {
                                returnDistance = distance.getDistance();
                            }
                        }
                        if (routeLength + returnDistance >= maxLength * 1.5) {
                            routeLength += returnDistance;
                            isActive = false;
                        }
                    }

                }
                if (!isActive) {
                    break;
                }
            }
            if (!isActive) {
                break;
            }
        }
        distanceB = routeLength;
        route.add(route.get(0));
        return route;
    }


    protected void showRoute(View view) {
        int id = 0;
        switch (view.getId()) {
            case R.id.buttonRoute1:
                id = 1;
                break;
            case R.id.buttonRoute2:
                id = 2;
                break;
            case R.id.buttonRoute3:
                id = 3;
                break;
            default:
                id = 1;
                break;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Start route")
                .setMessage("Do you want to start this route?")
                .setPositiveButton("Start!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Start activity
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
        });
        AlertDialog alertDialog = builder.show();
    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;

        return url;
    }

    /**
     * A method to download json data from url
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Error while downloading", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                //sleep(1000);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }

    /**
     * A class to parse the Google Places in JSON format
     */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }


        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {

            if (p == sizeA - 1 || p == sizeA + sizeB - 1) {
                switch (color) {
                    case Color.RED:
                        color = Color.BLUE;
                        break;
                    case Color.BLUE:
                        color = Color.GREEN;
                        break;
                    default:
                        color = Color.BLUE;
                        break;
                }
            }
            p++;
//
//            List<List<HashMap<String, String>>> resultA = result.subList(0, sizeA);
//            List<List<HashMap<String, String>>> resultB = result.subList(sizeA + 1, sizeA + sizeB);

            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }


                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(4);
                lineOptions.color(color);
            }


            // Drawing polyline in the Google Map for the i-th route
            map.addPolyline(lineOptions);

//            // Traversing through all the routes
//            for (int i = 0; i < resultB.size(); i++) {
//                points = new ArrayList<LatLng>();
//                lineOptions = new PolylineOptions();
//
//                // Fetching i-th route
//                List<HashMap<String, String>> path = resultB.get(i);
//
//                // Fetching all the points in i-th route
//                for (int j = 0; j < path.size(); j++) {
//                    HashMap<String, String> point = path.get(j);
//
//                    double lat = Double.parseDouble(point.get("lat"));
//                    double lng = Double.parseDouble(point.get("lng"));
//                    LatLng position = new LatLng(lat, lng);
//
//                    points.add(position);
//                }
//
//                // Adding all the points in the route to LineOptions
//                lineOptions.addAll(points);
//                lineOptions.width(4);
//                lineOptions.color(Color.BLUE);
//            }
//
//
//
//            // Drawing polyline in the Google Map for the i-th route
//            map.addPolyline(lineOptions);
        }
    }

}
