package naturalbolivia.com.aibautoparts;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by GutO on 11/02/2017.
 */

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder>{
    private List<Cars> items;
    public static class CarsViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;

        public CarsViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            visitas = (TextView) v.findViewById(R.id.visitas);
        }
    }
    public CarsAdapter(List<Cars> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CarsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cars_cards, viewGroup, false);
        return new CarsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarsViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.visitas.setText("Visitas:"+String.valueOf(items.get(i).getVisitas()));
    }
}
