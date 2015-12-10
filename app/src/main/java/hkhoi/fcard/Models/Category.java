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
         if (defaultCategories == null) {
             defaultCategories = new ArrayList<>();

             /* TODO: Add more categories here */
             int[] titles = {
                     R.string.category_exams,
                     R.string.category_animals,
                     R.string.category_plants,
                     R.string.category_slang
             };
             int[] imageLinks = {
                     R.drawable.category_exam,
                     R.drawable.category_animal,
                     R.drawable.category_plants,
                     R.drawable.category_slangs
             };
             /* END */
             
            for (int i = 0; i < titles.length; ++i) {
                defaultCategories.add(new Category(context.getString(titles[i]), imageLinks[i]));
            }
         }
         return defaultCategories;
     }
}
