package us.app.restaurant;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantCard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantCard extends Fragment {

    private static final String ARG_PHOTO = "photo";
    private static final String ARG_NAME = "name";
    private static final String ARG_SCORE = "score";
    private static final String ARG_PRICE = "price";
    private static final String ARG_DISTANCE = "distance";
    private static final String ARG_TYPE = "type";

    private String mPhoto;
    private String mName;
    private String mScore;
    private String mPrice;
    private String mDistance;
    private String mType;

    private ImageView imageView;
    private TextView txtName;
    private TextView txtScore;
    private TextView txtPrice;
    private TextView txtDistance;
    private TextView txtType;

    int photos[] = {
            R.drawable.restaurant0,
            R.drawable.restaurant1,
            R.drawable.restaurant2,
            R.drawable.restaurant3,
            R.drawable.restaurant4,
            R.drawable.restaurant5,
            R.drawable.restaurant6,
            R.drawable.restaurant7,
            R.drawable.restaurant8,
            R.drawable.restaurant9,
            R.drawable.restaurant10,
            R.drawable.restaurant11,
            R.drawable.restaurant12,
            R.drawable.restaurant13,
            R.drawable.restaurant14,
            R.drawable.restaurant15
    };

    public RestaurantCard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param photo Photo.
     * @param name Name.
     * @param score Score.
     * @param price Price.
     * @param distance Distance.
     * @param type Type.
     * @return A new instance of fragment RestaurantCard.
     */
    public static RestaurantCard newInstance(String photo, String name, String score, String price, String distance, String type) {
        RestaurantCard fragment = new RestaurantCard();
        Bundle args = new Bundle();
        args.putString(ARG_PHOTO, photo);
        args.putString(ARG_NAME, name);
        args.putString(ARG_SCORE, score);
        args.putString(ARG_PRICE, price);
        args.putString(ARG_DISTANCE, distance);
        args.putString(ARG_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mPhoto = getArguments().getString(ARG_PHOTO);
            mName = getArguments().getString(ARG_NAME);
            mScore = getArguments().getString(ARG_SCORE);
            mPrice = getArguments().getString(ARG_PRICE);
            mDistance = getArguments().getString(ARG_DISTANCE);
            mType = getArguments().getString(ARG_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_card, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imageView   = (ImageView) getView().findViewById(R.id.imageView);
        txtName     = (TextView) getView().findViewById(R.id.txtName);
        txtScore    = (TextView) getView().findViewById(R.id.txtScore);
        txtPrice    = (TextView) getView().findViewById(R.id.txtPrice);
        txtDistance = (TextView) getView().findViewById(R.id.txtDistance);
        txtType     = (TextView) getView().findViewById(R.id.txtType);

        imageView.setImageResource(photos[Integer.parseInt(mPhoto)]);
        txtName.setText(mName);
        txtScore.setText(mScore);
        txtPrice.setText(mPrice);
        txtDistance.setText(mDistance);
        txtType.setText(mType);
    }

}