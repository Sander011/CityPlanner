package hci.cityplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONHelper jsonHelper = new JSONHelper();
        jsonHelper.parseJSON();
    }

    public void loadMap(View view) {
        Intent intent = new Intent(this, HighlightsActivity.class);
        startActivity(intent);
    }
}
