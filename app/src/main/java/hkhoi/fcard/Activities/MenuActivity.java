package hkhoi.fcard.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import hkhoi.fcard.Adapters.CategoryAdapter;
import hkhoi.fcard.Models.Category;
import hkhoi.fcard.R;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = (RecyclerView) findViewById(R.id.activity_menu_recyclerView_categories);
        categoryAdapter = new CategoryAdapter(this , Category.getDefaultCategories(this));
        recyclerView.setAdapter(categoryAdapter);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
