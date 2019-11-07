package ie.ncirl.student.pintpricerv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

public class SelectionActivity extends AppCompatActivity {
    //initializing variables
    private Button mLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_actionbar);
        setSupportActionBar (toolbar);

        Spinner locationSpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> locationAdaptor = new ArrayAdapter<String>(SelectionActivity.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.location_array));
        locationAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdaptor);

        Spinner drinkSpinner = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> drinkAdaptor = new ArrayAdapter<String>(SelectionActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.drink_type_array));
        drinkAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drinkSpinner.setAdapter(drinkAdaptor);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.action_logout:
                //Logout Case
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SelectionActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                //unknown error
        }
       return super.onOptionsItemSelected(item);
    }


}
