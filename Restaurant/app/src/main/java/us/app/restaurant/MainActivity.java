package us.app.restaurant;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;

import jade.core.Agent;

import us.app.restaurant.data.RestaurantData;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView)findViewById(R.id.scrollView);
    }

    public void search(View v){
        Toast.makeText(this, "Procurando...", Toast.LENGTH_SHORT).show();

        // exemplo de popup
        popup();

        for (int i = 0; i < 4; ++i){
            Fragment fragment = RestaurantCard.newInstance(RestaurantData.data[i][RestaurantData.PHOTO],
                                                           RestaurantData.data[i][RestaurantData.NAME],
                                                           RestaurantData.data[i][RestaurantData.SCORE],
                                                           RestaurantData.data[i][RestaurantData.PRICE],
                                                           RestaurantData.data[i][RestaurantData.DISTANCE],
                                                           RestaurantData.data[i][RestaurantData.TYPE]);

            getSupportFragmentManager().beginTransaction().add(R.id.layCards, fragment).commit();
        }

        scrollView.setVisibility(View.VISIBLE);
    }

    private void popup(){
        // provavelmente será criada uma classe
        // referencia: https://developer.android.com/guide/topics/ui/dialogs?hl=pt-br

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add the buttons
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        // Set other dialog properties
        builder.setMessage("Hm... Achamos apenas 1 restaurante desse tipo perto de você.\nVocê se importaria de andar por pelo menos 10km?").setTitle("Assistente");

        // Create the AlertDialog
        AlertDialog dialog = builder.create();

        dialog.show();
    }
    
}