package naturalbolivia.com.aibautoparts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
    private ImageView ivImagen;
    private TextView tvNombre;
    private TextView tvVisitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ivImagen = (ImageView) findViewById(R.id.ivDetalleImagen);
        tvNombre = (TextView) findViewById(R.id.tvDetalleNombre);
        tvVisitas = (TextView) findViewById(R.id.tvDetalleVisitas);

        Cars cars = (Cars) getIntent().getSerializableExtra("car");

        ivImagen.setImageResource(cars.getImagen());
        tvNombre.setText(cars.getNombre());
        tvVisitas.setText(cars.getVisitas()+"");
    }
}
