package com.example.models;

import java.util.ArrayList;

public class ListCategory {
    private ArrayList<Category> categories;

    public ListCategory() {
        categories = new ArrayList<>();
    }

    public void addCategory(Category cate) {
        categories.add(cate);
    }
    public ArrayList<Category> getCategories() {return categories;}
    public void setCategories(ArrayList<Category> categories) {this.categories = categories;}
    public void generate_sample_dataset_category() {
        addCategory(new Category(1, "Điện thoại"));
        addCategory(new Category(2, "Laptop"));
        addCategory(new Category(3, "Phụ kiện"));
        addCategory(new Category(4, "Máy ảnh"));
    }
}
