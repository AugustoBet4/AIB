package naturalbolivia.com.aibautoparts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarsListActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);

        List<Cars> items = new ArrayList<>();

        items.add(new Cars(R.mipmap.ic_launcher, "Auto 1", 230));
        items.add(new Cars(R.mipmap.ic_launcher, "Auto 2", 456));
        items.add(new Cars(R.mipmap.ic_launcher, "Auto 3", 342));
        items.add(new Cars(R.mipmap.ic_launcher, "Auto 4", 645));
        items.add(new Cars(R.mipmap.ic_launcher, "Auto 5", 459));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new CarsAdapter(items);
        recycler.setAdapter(adapter);
    }
}
