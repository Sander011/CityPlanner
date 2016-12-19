package hci.cityplanner;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class highlightsActivity extends AppCompatActivity {
    private HashMap<String, Highlight> highlights;
    private ArrayList<String> selectedHighlights;
    private ArrayList<String> spinnerHighlights;
    private JSONHelper jsonHelper;
    private String city;
    private ArrayList<Category> categories;
    final Context context = this;
    private int rowCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.jsonHelper = new JSONHelper();
        this.highlights = this.jsonHelper.parseJSON();
        this.selectedHighlights = new ArrayList<>();
        this.spinnerHighlights = new ArrayList<>();

        this.city = "Paris";

        this.categories = new ArrayList<>();
        this.categories.add(Category.CULTURE);
        this.categories.add(Category.FOOD);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlights);

        this.fillInitial();
        this.fillSpinner();

    }

    private void fillInitial() {
        for (Map.Entry<String, Highlight> e : this.highlights.entrySet()) {
            if(e.getValue().getCity().equals(this.city)) {
                for (Category c : this.categories) {
                    if(c.equals(e.getValue().getCategory())) {
                        addHighlight(e.getKey());
                        this.selectedHighlights.add(e.getKey());
                    }
                }
            }
        }
    }

    private void fillSpinner() {
        for(Map.Entry<String,Highlight> e : this.highlights.entrySet()) {
            if(e.getValue().getCity().equals(this.city) && !this.selectedHighlights.contains(e.getKey())) {
                spinnerHighlights.add(e.getKey());
            }
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerHighlights);
        ((Spinner)findViewById(R.id.selectHighlightSpinner)).setAdapter(dataAdapter);
    }

    public void addHighlight(View view) {
        Spinner spinner = (Spinner)findViewById(R.id.selectHighlightSpinner);
        String toAdd = (String)spinner.getSelectedItem();
        if(spinnerHighlights.contains(toAdd)) {
            spinnerHighlights.remove(toAdd);
        }
        selectedHighlights.add(toAdd);
        addHighlight(toAdd);
        spinner.setSelection(0);
    }

    private void addHighlight(String toAdd) {
        Highlight newHighlight = this.highlights.get(toAdd);

        TableLayout table = (TableLayout)findViewById(R.id.highlightsTable);
        TableRow newRow = new TableRow(this);
        newRow.setId(rowCount);
        newRow.setTag(newHighlight);

        TextView name = new TextView(this);
        name.setText(newHighlight.getName());
        name.setTextSize(18);
        newRow.addView(name);

        ImageButton information = new ImageButton(this);
        information.setImageResource(android.R.drawable.ic_dialog_info);
        information.setBackgroundColor(Color.TRANSPARENT);
        information.setColorFilter(Color.parseColor("#2c497a"));
        information.setTag(newHighlight);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Highlight highlight = (Highlight)v.getTag();
                System.out.println(highlight.getDescription());
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_custom);

                dialog.setTitle(highlight.getName());

                TextView text = (TextView) dialog.findViewById(R.id.dialogText);
                text.setText(highlight.getDescription());

                Button dialogButton = (Button)dialog.findViewById(R.id.dialogButtonOK);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        newRow.addView(information);

        ImageButton remove = new ImageButton(this);
        remove.setTag(rowCount);
        remove.setImageResource(android.R.drawable.ic_delete);
        remove.setBackgroundColor(Color.TRANSPARENT);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row = (TableRow)findViewById((Integer)v.getTag());
                TableLayout table = (TableLayout)findViewById(R.id.highlightsTable);
                table.removeView(row);
                Highlight highlight = (Highlight)row.getTag();
                selectedHighlights.remove(highlight.getName());
                spinnerHighlights.add(highlight.getName());
            }
        });
        newRow.addView(remove);

        table.addView(newRow);
        rowCount++;
    }
}
