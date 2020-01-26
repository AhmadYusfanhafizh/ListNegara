package id.ac.poliban.mi.yusfan.listnegara;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Counrty> counrties = new ArrayList<>();
    private ListView lvCountry;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCountry = findViewById(R.id.listview);

        counrties.addAll(CountryData.getAllContries());

        adapter = new CountryAdapter(counrties);

        lvCountry.setAdapter(adapter);

        lvCountry.setOnItemClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Negara yang adna pilih")
                    .setMessage("anda memilih: " +
                            counrties.get(position).getCountryName())
                    .setPositiveButton("OK", null).show();
        });
    }
}
