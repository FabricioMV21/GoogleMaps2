package fmv.fabricio.googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ubicaciones extends AppCompatActivity {
    EditText ubi1, ubi2, ubi3;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);

        // Ubicacion (latitud,longitud)
        ubi1  = findViewById(R.id.ubi1);
        ubi2  = findViewById(R.id.ubi2);
        ubi3  = findViewById(R.id.ubi3);

        // Click boton agregar
        agregar = findViewById(R.id.btnagregar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Convertir las ubicaciones a STRING
                String ubicacion1 = ubi1.getText().toString();
                String ubicacion2 = ubi2.getText().toString();
                String ubicacion3 = ubi3.getText().toString();

                // Pasar las ubicaciones a la siguiente ACTIVITY
                if(ubicacion1.isEmpty() || ubicacion2.isEmpty() || ubicacion3.isEmpty()){
                    Toast.makeText(ubicaciones.this, "Ningun Campo Debe Estar Vacio", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("Ubicacion1", ubicacion1);
                    intent.putExtra("Ubicacion2", ubicacion2);
                    intent.putExtra("Ubicacion3", ubicacion3);
                    startActivity(intent);
                }

            }
        });
    }
}