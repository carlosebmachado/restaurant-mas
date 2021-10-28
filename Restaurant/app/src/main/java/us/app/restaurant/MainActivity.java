package us.app.restaurant;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

import jade.core.AID;
import jade.core.Agent;

import jade.lang.acl.ACLMessage;
import us.app.restaurant.core.agents.gui.GuiAgent;
import us.app.restaurant.core.data.RestaurantData;
import us.app.restaurant.core.objects.Request;

public class MainActivity extends AppCompatActivity {

    private GuiAgent guiAgent;

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView)findViewById(R.id.scrollView);
    }

    public void search(View v){
        Toast.makeText(this, "Procurando...", Toast.LENGTH_SHORT).show();

//        for (int i = 0; i < 4; ++i){
//            Fragment fragment = RestaurantCard.newInstance(RestaurantData.data[i].getImage(),
//                                                           RestaurantData.data[i].getName(),
//                                                           RestaurantData.data[i].getScore(),
//                                                           RestaurantData.data[i].getPrice(),
//                                                           RestaurantData.data[i].getDistance(),
//                                                           RestaurantData.data[i].getType());
//
//            getSupportFragmentManager().beginTransaction().add(R.id.layCards, fragment).commit();
//        }

//        String type = cbType.getSelectedItem().toString();
//        String score = cbScore.getSelectedItem().toString();
//        String price = cbPrice.getSelectedItem().toString();
//        float distanceFrom;
//        try { distanceFrom = Float.parseFloat(txtDistanceFrom.toString()); }
//        catch (NumberFormatException e) { distanceFrom = 0; }
//
//        float distanceTo;
//        try { distanceTo = Float.parseFloat(txtDistanceTo.toString()); }
//        catch (NumberFormatException e) { distanceTo = 0; }
//
//        try {
//            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
//            msg.setSender(new AID("Usuário", AID.ISLOCALNAME));
//            msg.addReceiver(new AID("GuiAgent", AID.ISLOCALNAME));
//            msg.setContentObject(new Request(type, price, distanceFrom, distanceTo, score));
//            guiAgent.send(msg);
//        } catch (IOException e) {
//            System.out.println("Erro ao enviar mensagem: Usuário -> GuiAgent");
//        }

        scrollView.setVisibility(View.VISIBLE);
    }

    public void filters(View v){
        Intent intent = new Intent(this, FilterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FilterActivity && resultCode == RESULT_OK && data != null) {
            num1 = data.getIntExtra(Number1Code);
            num2 = data.getIntExtra(Number2Code);
        }
    }

}