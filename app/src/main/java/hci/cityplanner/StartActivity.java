package hci.cityplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class StartActivity extends AppCompatActivity {

    boolean[] categories = {false,false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void openMap(View view) {
        Intent intent = new Intent(this, HighlightsActivity.class);
        Bundle data = new Bundle();
        data.putBooleanArray("Categories", categories);
        data.putString("City", ((EditText)findViewById(R.id.City)).getText().toString());
        intent.putExtra("Data", data);
        startActivity(intent);
    }

    public void buttonPress(View view) {
        ImageButton imgbtn = (ImageButton)view;
        imgbtn.setAlpha((float)(imgbtn.getAlpha()>0.7 ? 0.5 : 1));
        int id = imgbtn.getId();
        switch(id) {
            case R.id.category1: {
                categories[0] = !categories[0];
                break;
            }case R.id.category4: {
                categories[1] = !categories[1];
                break;
            }case R.id.category2: {
                categories[2] = !categories[2];
                break;
            }case R.id.category3: {
                categories[3] = !categories[3];
                break;
            }
        }
    }
}
