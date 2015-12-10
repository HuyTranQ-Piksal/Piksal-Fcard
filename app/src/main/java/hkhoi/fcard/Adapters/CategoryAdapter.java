package hkhoi.fcard.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import hkhoi.fcard.Models.Category;
import hkhoi.fcard.R;

/**
 * Created by hkhoi on 09/12/2015.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private Context context;
    private List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_categories, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        holder.textView.setText(categories.get(position).getTitle());
        Picasso.with(context)
                .load(categories.get(position).getIconLink())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public CategoryHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.row_categories_textView_title);
            imageView = (ImageView) itemView.findViewById(R.id.row_categories_imageView_icon);
        }
    }
}
