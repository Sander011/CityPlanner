package hci.cityplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Arrays;

public class StartActivity extends AppCompatActivity {
    boolean nature = false;
    boolean musea = false;
    boolean shopping = false;
    boolean food = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void openMap(View view) {
        Intent intent = new Intent(this, HighlightsActivity.class);
        Bundle data = new Bundle();
        boolean[] meh = new boolean[4];
        meh[0] = nature;
        meh[1] = musea;
        meh[2] = shopping;
        meh[3] = food;
        data.putBooleanArray("Categories", meh);
        intent.putExtra("Data", data);
        startActivity(intent);
    }

    public void buttonPress(View view) {
        ImageButton imgbtn = (ImageButton)view;
        imgbtn.setAlpha((float)(imgbtn.getAlpha()>0.7 ? 0.5 : 1));
        int id =imgbtn.getId();
        switch(id) {
            case R.id.nature: {
                nature = !nature;
                break;
            }case R.id.shopping: {
                shopping = !shopping;
                break;
            }case R.id.musea: {
                musea = !musea;
                break;
            }case R.id.food: {
                food = !food;
                break;
            }
        }
    }
}
