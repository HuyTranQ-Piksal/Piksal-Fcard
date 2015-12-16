package hkhoi.fcard.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import hkhoi.fcard.Adapters.CategoryAdapter;
import hkhoi.fcard.Models.Category;
import hkhoi.fcard.R;

public class MenuActivity extends BaseNavigationDrawerActivity {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = (RecyclerView) findViewById(R.id.activity_menu_recyclerView_categories);
        categoryAdapter = new CategoryAdapter(this , Category.getDefaultCategories(this));
        recyclerView.setAdapter(categoryAdapter);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
