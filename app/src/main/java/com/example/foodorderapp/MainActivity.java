package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());   // getting the linear layout from the activity_main (press ctrl + click) on get root()

        // recycler view (only one cycle)

        ArrayList<MainModel> list = new ArrayList<MainModel>();
        list.add(new MainModel(R.drawable.aloo_gobi,"Aloo Gobi","10","Aloo-Gobi - Cauliflower with potatoes sautéed with garam masala, turmeric."));
        list.add(new MainModel(R.drawable.alootikki,"Aloo Tikki","20","Aloo-Tikki - Patties of potato mixed with some vegetables fried"));
        list.add(new MainModel(R.drawable.amritsari_kulcha,"Amritsar Kulcha","10","Kulcha - mildly leavened flatbread"));
        list.add(new MainModel(R.drawable.biryani,"Biryani","20","Biryani - Mixed rice dish, optional spices, optional vegetables, meats or seafood."));
        list.add(new MainModel(R.drawable.dal_makhani,"Dal Makhani","10","Dal - Assorted types of lentils, such as toor, urad, chana, masoor dal"));
        list.add(new MainModel(R.drawable.poha,"Poha","15","Poha - Common snack in central part of India. Flattended rice, potato, turmeric."));
        list.add(new MainModel(R.drawable.gajar_halwa,"Gajar Ka Halwa","30","Gajar ka Halwa - sweet dish contains Carrot, Milk, Ghee, Cashew."));
        list.add(new MainModel(R.drawable.kadaipanner,"Kadai Panner","90","kadai Panner - Paneer and green peppers in tomato gravy"));
        list.add(new MainModel(R.drawable.kheer,"Kheer","50","Khir - Rice cooked with milk and dry fruits"));
        list.add(new MainModel(R.drawable.paneer_kofta_curry,"Panner Curry","150","Kofta - Gram flour balls fried with vegetables. "));
        list.add(new MainModel(R.drawable.matkakulfi,"Matkakulfi","40","Kolfi_Faluda - dessert to ward off sweltering heat of summers"));
        list.add(new MainModel(R.drawable.palakpaneer,"Palak Panner","80","Palak-Panner - Paneer cubes in spinach gravy"));
        list.add(new MainModel(R.drawable.onion_masala_papad,"Masala Papad","10","Masala-Papad - A crispy add on to Lunch and Dinner."));
        list.add(new MainModel(R.drawable.paratha,"Paratha","10","Paratha - flatbread native to the Indian prevalent throughout the modern-day"));
        list.add(new MainModel(R.drawable.samosa,"Samosa","15","Samosa - Normally served as Potatoes, onions, peas, coriander, and lentils"));
        list.add(new MainModel(R.drawable.idli_sambar,"Idli Sambar","20","Idle - Steamed cake of fermented rice and pulse flour. Rice, urad dal"));
        list.add(new MainModel(R.drawable.masala_dosa,"Masala Dosa","30","Masala Dhosa - Dosa with masala and potato"));
        list.add(new MainModel(R.drawable.dabeli,"Dabeli","10","Dabeli - Snack made by mixing boiled potatoes with a special dabeli masala."));
        list.add(new MainModel(R.drawable.dahi_vadas,"Dahi Vadas","40","Dahi-Vada - Fried lentil balls in a yogurt sauce. Lentils, yogurt."));


        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    // Add the menu bar to the main Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            // if the order is there then start the activity
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrdersActivity.class));
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}