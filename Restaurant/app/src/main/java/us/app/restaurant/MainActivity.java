package us.app.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

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
}