package us.app.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import us.app.restaurant.core.agents.gui.GuiAgent;

public class FilterActivity extends AppCompatActivity {

    private Spinner spType;
    private Spinner spScore;
    private Spinner spPrice;
    private EditText txtDistanceFrom;
    private EditText txtDistanceTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        spType = (Spinner)findViewById(R.id.spType);
        spScore = (Spinner)findViewById(R.id.spScore);
        spPrice = (Spinner)findViewById(R.id.spPrice);
        txtDistanceFrom = (EditText)findViewById(R.id.txtDistanceFrom);
        txtDistanceTo = (EditText)findViewById(R.id.txtDistanceTo);
    }

    public void confirm(View v){
        Intent output = new Intent();
        output.putExtra("type", spType.getSelectedItem().toString());
        output.putExtra("score", spScore.getSelectedItem().toString());
        output.putExtra("price", spPrice.getSelectedItem().toString());
        output.putExtra("distanceFrom", txtDistanceFrom.getText());
        output.putExtra("distanceTo", txtDistanceTo.getText());
        setResult(RESULT_OK, output);
        finish();
    }

}