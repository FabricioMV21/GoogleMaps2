package fmv.fabricio.googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity
    implements OnMapReadyCallback {
    private GoogleMap mMap;
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment)
            getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        volver = findViewById(R.id.btnVolver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ubicaciones.class));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Recibir la Ubicacion N°1
        String ubicacion1 = getIntent().getStringExtra("Ubicacion1");
        String[] partes1 = ubicacion1.split(",");
        String latitud1 = partes1[0];
        String longitud1 = partes1[1];

        int lt1 = Integer.parseInt(latitud1);
        int lg1 = Integer.parseInt(longitud1);

        // Ubicacion N°1
        mMap = googleMap;
        LatLng ubi1 = new LatLng(lt1,lg1);
        mMap.addMarker(new MarkerOptions()
                        .position(ubi1)
                        .title("Marcador N°1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubi1));

        // Recibir la Ubicacion N°2
        String ubicacion2 = getIntent().getStringExtra("Ubicacion2");
        String[] partes2 = ubicacion2.split(",");
        String latitud2 = partes2[0];
        String longitud2 = partes2[1];

        int lt2 = Integer.parseInt(latitud2);
        int lg2 = Integer.parseInt(longitud2);

        // Ubicacion N°2
        mMap = googleMap;
        LatLng ubi2 = new LatLng(lt2,lg2);
        mMap.addMarker(new MarkerOptions()
                .position(ubi2)
                .title("Marcador N°2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubi2));

        // Recibir la Ubicacion N°3
        String ubicacion3 = getIntent().getStringExtra("Ubicacion3");
        String[] partes3 = ubicacion3.split(",");
        String latitud3 = partes3[0];
        String longitud3 = partes3[1];

        int lt3 = Integer.parseInt(latitud3);
        int lg3 = Integer.parseInt(longitud3);

        // Ubicacion N°3
        mMap = googleMap;
        LatLng ubi3 = new LatLng(lt3,lg3);
        mMap.addMarker(new MarkerOptions()
                .position(ubi3)
                .title("Marcador N°3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubi3));
    }
}