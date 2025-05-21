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

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void generate_sample_dataset_category() {
        Category c1 = new Category(1, "Drink", 110);
        c1.addProduct(new Product(1, "Coca", 12, 12000, 115, "Refreshing cola drink", 0));
        c1.addProduct(new Product(2, "Pepsi", 10, 12000, 111, "Popular cola brand", 0));
        c1.addProduct(new Product(3, "Fanta", 12, 12000, 112, "Orange flavored soda", 0));
        c1.addProduct(new Product(4, "Sprite", 13, 12000, 113, "Lemon-lime soda", 0));
        c1.addProduct(new Product(5, "7up", 14, 12000, 114, "Citrus soda drink", 0));
        categories.add(c1);

        Category c2 = new Category(2, "Food", 120);
        c2.addProduct(new Product(6, "Pizza", 12, 200000, 125, "Cheesy Italian pizza", 0));
        c2.addProduct(new Product(7, "Hamburger", 10, 50000, 121, "Beef burger with bun", 0));
        c2.addProduct(new Product(8, "Hotdog", 12, 30000, 122, "Grilled sausage sandwich", 0));
        c2.addProduct(new Product(9, "Salad", 13, 45000, 123, "Mixed vegetable dish", 0));
        c2.addProduct(new Product(10, "Soup", 14, 45000, 124, "Hot liquid food", 0));
        categories.add(c2);

        Category c3 = new Category(3, "Furniture", 130);
        c3.addProduct(new Product(11, "Chair", 12, 1201000, 135, "Wooden seating", 0));
        c3.addProduct(new Product(12, "Table", 10, 1220000, 131, "Dining table", 0));
        c3.addProduct(new Product(13, "Sofa", 12, 1450400, 132, "Comfortable seating", 0));
        c3.addProduct(new Product(14, "Homeware", 13, 1205500, 133, "Household items", 0));
        c3.addProduct(new Product(15, "Desk", 14, 1421000, 134, "Office desk", 0));
        categories.add(c3);

        Category c4 = new Category(4, "Electronic", 140);
        c4.addProduct(new Product(16, "Laptop", 12, 5000000, 141, "Portable computer", 0));
        c4.addProduct(new Product(17, "Mouse", 10, 240000, 142, "Computer pointing device", 0));
        c4.addProduct(new Product(18, "Air-conditioner", 12, 15000, 143, "Cooling appliance", 0));
        c4.addProduct(new Product(19, "Washing machine", 13, 1800000, 144, "Laundry machine", 0));
        c4.addProduct(new Product(20, "Dish washer", 14, 50000, 145, "Dish cleaning appliance", 0));
        categories.add(c4);

        Category c5 = new Category(5, "Clothes", 150);
        c5.addProduct(new Product(21, "Shirt", 12, 500000, 151, "Casual wear", 0));
        c5.addProduct(new Product(22, "Pants", 10, 190000, 152, "Lower body garment", 0));
        c5.addProduct(new Product(23, "Shoes", 12, 1200000, 153, "Footwear", 0));
        c5.addProduct(new Product(24, "Jacket", 13, 200000, 154, "Warm outerwear", 0));
        c5.addProduct(new Product(25, "Hat", 14, 180000, 155, "Headwear", 0));
        categories.add(c5);

        Category c6 = new Category(6, "Toy", 160);
        c6.addProduct(new Product(26, "Car", 12, 300000, 161, "Toy car", 0));
        c6.addProduct(new Product(27, "Doll", 10, 400000, 162, "Toy doll", 0));
        c6.addProduct(new Product(28, "Lego", 12, 1200000, 163, "Building blocks", 0));
        c6.addProduct(new Product(29, "Puzzle", 13, 130000, 164, "Puzzle game", 0));
        c6.addProduct(new Product(30, "Action Figure", 14, 140000, 165, "Character toy", 0));
        categories.add(c6);

        Category c7 = new Category(7, "Sport", 170);
        c7.addProduct(new Product(31, "Ball", 12, 450000, 171, "Sports ball", 0));
        c7.addProduct(new Product(32, "Bat", 10, 230000, 172, "Sports bat", 0));
        c7.addProduct(new Product(33, "Basket", 12, 410000, 173, "Sports basket", 0));
        c7.addProduct(new Product(34, "Helmet", 13, 100000, 174, "Protective gear", 0));
        c7.addProduct(new Product(35, "Gloves", 14, 120000, 175, "Hand protection", 0));
        categories.add(c7);

        Category c8 = new Category(8, "Beauty", 180);
        c8.addProduct(new Product(36, "Lipstick", 12, 120000, 181, "Makeup item", 0));
        c8.addProduct(new Product(37, "Mascara", 10, 130000, 182, "Eyelash makeup", 0));
        c8.addProduct(new Product(38, "Foundation", 12, 140000, 183, "Face makeup", 0));
        c8.addProduct(new Product(39, "Concealer", 13, 150000, 184, "Skin blemish cover", 0));
        c8.addProduct(new Product(40, "Blusher", 14, 160000, 185, "Cheek color", 0));
        categories.add(c8);

        Category c9 = new Category(9, "Home", 190);
        c9.addProduct(new Product(41, "Bed Sheet", 12, 1200000, 191, "Bedding item", 0));
        c9.addProduct(new Product(42, "Pillow", 10, 130000, 192, "Sleeping support", 0));
        c9.addProduct(new Product(43, "Curtain", 12, 1900000, 193, "Window cover", 0));
        c9.addProduct(new Product(44, "Mirror", 13, 120000, 194, "Reflective surface", 0));
        c9.addProduct(new Product(45, "Curtains", 14, 120000, 195, "Duplicate curtain", 0));
        categories.add(c9);

        Category c10 = new Category(10, "Stationery", 200);
        c10.addProduct(new Product(46, "Pen", 12, 12000, 201, "Writing instrument", 0));
        c10.addProduct(new Product(47, "Pencil", 10, 13000, 202, "Graphite stick", 0));
        c10.addProduct(new Product(48, "Pencil case", 12, 19000, 203, "Stationery holder", 0));
        c10.addProduct(new Product(49, "Notebook", 13, 12000, 204, "Note paper book", 0));
        c10.addProduct(new Product(50, "Calculator", 14, 12000, 205, "Math device", 0));
        categories.add(c10);
    }
}
