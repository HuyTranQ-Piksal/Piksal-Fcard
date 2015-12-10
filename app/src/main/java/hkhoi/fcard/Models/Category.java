package hkhoi.fcard.Models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hkhoi.fcard.Others.CommonUtility;
import hkhoi.fcard.R;

/**
 * Created by hkhoi on 09/12/2015.
 */
public class Category {
    private String title;
    private int iconLink;
    private static List<Category> defaultCategories;

    public Category(String title, int iconLink) {
        this.title = title;
        this.iconLink = iconLink;
    }

    public int getIconLink() {
        return iconLink;
    }

    public void setIconLink(int iconLink) {
        this.iconLink = iconLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

     public static List<Category> getDefaultCategories(Context context) {
         if (defaultCategories != null)
             return defaultCategories;

         defaultCategories = new ArrayList<>();
         final String packageName = context.getPackageName();
         String[] categories = context.getResources().getStringArray(R.array.categories);
         for (int i = 0; i < categories.length; ++i) {
             String identifier = "category_" + categories[i];
             int idTitle = context.getResources().getIdentifier(identifier , "string" , packageName);
             int idImage = context.getResources().getIdentifier(identifier , "drawable" , packageName);
             defaultCategories.add(new Category(context.getString(idTitle), idImage));
         }
         return defaultCategories;
     }
}
