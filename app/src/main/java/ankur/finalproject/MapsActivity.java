package ankur.finalproject;

import android.content.Intent;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private GPSTracker gpsTracker;
    private Location mLocation;
    double latitude, longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        gpsTracker = new GPSTracker(getApplicationContext());
        mLocation = gpsTracker.getLocation();
        if (mLocation != null) {
            latitude = mLocation.getLatitude();
            longitude = mLocation.getLongitude();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(sydney).title("I'm here...").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10));
        //static marker
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.677210, -79.446669)).title("st. clair Store"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.785188, -79.279195)).title("FairView"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.775293, -79.257825)).title("STC"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.656281, -79.380459)).title("Dundas"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.725456, -79.452095)).title("YorkDale"));


    }


    @Override
    public boolean onMarkerClick(Marker marker) {

        Toast.makeText(MapsActivity.this, marker.getTitle(),Toast.LENGTH_LONG).show();

        Intent myIntent = new Intent(getApplicationContext(), ConfirmationActivity.class);
        myIntent.putExtra("location", marker.getTitle());
        startActivity(myIntent);
        return true;

    }
}