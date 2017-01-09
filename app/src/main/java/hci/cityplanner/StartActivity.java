package hci.cityplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Arrays;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void openMap(View view) {
        Intent intent = new Intent(this, HighlightsActivity.class);
        Bundle data = new Bundle();
      //  data.putStringArray("Highlights", Arrays.copyOf(selectedHighlights.toArray(), selectedHighlights.size(), String[].class));
        intent.putExtra("Data", data);
        startActivity(intent);
    }

    public void buttonPress(View view) {
        ImageButton imgbtn = (ImageButton)view;
        imgbtn.setAlpha((float)(imgbtn.getAlpha()>0.7 ? 0.5 : 1));
    }
}
