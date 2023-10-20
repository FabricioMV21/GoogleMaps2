package fmv.fabricio.googlemaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        volver = findViewById(R.id.Volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ubicaciones.class));
            }
        });

        // Accedo a los servicos de ubicacion Actual.
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Recibir la Ubicacion N°1
        String ubicacion1 = getIntent().getStringExtra("Ubicacion1");
        String[] partes1 = ubicacion1.split(",");
        String latitud1 = partes1[0];
        String longitud1 = partes1[1];

        double lt1 = Double.parseDouble(latitud1);
        double lg1 = Double.parseDouble(longitud1);

        // Ubicacion N°1
        mMap = googleMap;
        LatLng ubi1 = new LatLng(lt1, lg1);
        mMap.addMarker(new MarkerOptions()
                .position(ubi1)
                .title("Marcador N°1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubi1));

        // Recibir la Ubicacion N°2
        String ubicacion2 = getIntent().getStringExtra("Ubicacion2");
        String[] partes2 = ubicacion2.split(",");
        String latitud2 = partes2[0];
        String longitud2 = partes2[1];

        double lt2 = Double.parseDouble(latitud2);
        double lg2 = Double.parseDouble(longitud2);

        // Ubicacion N°2
        mMap = googleMap;
        LatLng ubi2 = new LatLng(lt2, lg2);
        mMap.addMarker(new MarkerOptions()
                .position(ubi2)
                .title("Marcador N°2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubi2));

        // Recibir la Ubicacion N°3
        String ubicacion3 = getIntent().getStringExtra("Ubicacion3");
        String[] partes3 = ubicacion3.split(",");
        String latitud3 = partes3[0];
        String longitud3 = partes3[1];

        double lt3 = Double.parseDouble(latitud3);
        double lg3 = Double.parseDouble(longitud3);

        // Ubicacion N°3
        mMap = googleMap;
        LatLng ubi3 = new LatLng(lt3, lg3);
        mMap.addMarker(new MarkerOptions()
                .position(ubi3)
                .title("Marcador N°3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubi3));

        // MI UBICACION ACTUAL
        // Solicito los permisos para mi ubicacion y obtengo la ubicacion.
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // Si se han otorgado,procedo a obtener la ubicación actual
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        // Obtengo la ubicacion actual en el objeto (location)
                        // Verifico que la ubicacion no sea nula
                        if (location != null) {
                            // Almaceno la latitud y longitud en un variable (Double)
                            double lat = location.getLatitude();
                            double lng = location.getLongitude();

                            // Creo un marcador con la ubicacion actual
                            LatLng currentLatLng = new LatLng(lat, lng);
                            mMap.addMarker(new MarkerOptions()
                                    .position(currentLatLng)
                                    .title("Mi Ubicación Actual"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLatLng));
                        }
                    });
        }

    }
}