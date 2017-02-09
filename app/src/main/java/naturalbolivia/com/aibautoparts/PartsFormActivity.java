package naturalbolivia.com.aibautoparts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PartsFormActivity extends AppCompatActivity{
    TextView name,year,mail,espe;
    Spinner spinnermodel,spinnerpartes;
    String mod,part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_form);

        spinnermodel = (Spinner) findViewById(R.id.spinnermodel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.model_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnermodel.setAdapter(adapter);

        spinnerpartes = (Spinner) findViewById(R.id.spinnerpartes);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.parte_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerpartes.setAdapter(adapter2);

        name = (TextView) findViewById(R.id.name);
        year = (TextView) findViewById(R.id.year);
        mail = (TextView) findViewById(R.id.mail);
        espe = (TextView) findViewById(R.id.espe);

        spinnermodel.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,android.view.View v, int position, long id) {
                        mod = ""+parent.getItemAtPosition(position);
                        Log.i("Spinner Modelo",mod);
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        Log.i("Spinner Modelo","Nada");
                    }
                });
        spinnerpartes.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,android.view.View v, int position, long id) {
                        part = ""+parent.getItemAtPosition(position);
                        Log.i("Spinner Modelo",part);
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        Log.i("Spinner Modelo","Nada");
                    }
                });

    }
    protected void enviar(View View){
        String name_err = getString(R.string.it_name);
        String mail_err = getString(R.string.it_mail);
        String anio_err = getString(R.string.it_anio);
        String espe_err = getString(R.string.it_espe);
        boolean na=true,ma=true,ye=true,es=true,mo=true,pa=true;

        if( name.getText().toString().length() == 0 ) {
            name.setError(name_err);
            na=false;
        }
        if( mail.getText().toString().length() == 0 ) {
            mail.setError(mail_err);
            ma=false;
        }
        if( year.getText().toString().length() == 0 ){
            year.setError(anio_err);
            ye=false;
        }
        if( espe.getText().toString().length() == 0 ) {
            espe.setError(espe_err);
            es=false;
        }
        String op1=getString(R.string.op);
        String err_mod=getString(R.string.err_mod);
        if(mod.equals(op1)){
            Toast.makeText(this,err_mod,Toast.LENGTH_SHORT).show();
            mo=false;
        }
        String op2=getString(R.string.op);
        String err_parts=getString(R.string.err_parts);
        if(part.equals(op2)){
            Toast.makeText(this,err_parts ,Toast.LENGTH_SHORT).show();
            pa=false;
        }
        if((na)&&(ma)&&(ye)&&(es)&&(mo)&&(pa)){

            String correo=getString(R.string.correo);
            String order = getString(R.string.subject);
            String lang = getString(R.string.lang);

            String text = "Idioma de Contacto: "+lang+"\nNombre: "+name.getText().toString()+
                    "\nCorreo Electronico: "+mail.getText().toString()+"\nMarca/Modelo: "+mod+
                    "\nAño: "+year.getText().toString()+"\nAutoparte: "+part+"\nEspecificación: "+espe.getText().toString();

            String[] TO = {correo};
            String[] CC = {""};

            Intent emailIntent = new Intent(Intent.ACTION_SEND);

            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, order);
            emailIntent.putExtra(Intent.EXTRA_TEXT, text);
            String send = getString(R.string.send);
            try {
                startActivity(Intent.createChooser(emailIntent, send));
            }
            catch (android.content.ActivityNotFoundException e) {
                Toast.makeText(this, "NO existe ningún cliente de email instalado!.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    protected void borrar(View view){
        name.setText("");
        year.setText("");
        mail.setText("");
        espe.setText("");
    }
}
