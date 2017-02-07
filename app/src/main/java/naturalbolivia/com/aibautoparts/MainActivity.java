package naturalbolivia.com.aibautoparts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }
    protected void parts (View View){
        Intent i = new Intent(getApplicationContext(),PartsFormActivity.class);
        startActivity(i);
    }
    protected void inventario(View View){
        Intent i = new Intent(getApplicationContext(),CarsListActivity.class);
        startActivity(i);
    }
}
