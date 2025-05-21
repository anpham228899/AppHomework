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
        Category c1=new Category(1,"Drink",110);
        Product p1=new Product(1, "Coca", 12, 12000, 115);
        Product p2=new Product(2, "Pepsi", 10, 12000, 111);
        Product p3=new Product(3, "Fanta", 12, 12000, 112);
        Product p4=new Product(4, "Sprite", 13, 12000, 113);
        Product p5=new Product(5, "7up", 14, 12000, 114);
        c1.addProduct(p1);
        c1.addProduct(p2);
        c1.addProduct(p3);
        c1.addProduct(p4);
        c1.addProduct(p5);
        categories.add(c1);

        Category c2=new Category(2,"Food",120);
        Product p6=new Product(6, "Pizza", 12, 200000, 125);
        Product p7=new Product(7, "Hamburger", 10, 50000, 121);
        Product p8=new Product(8, "Hotdog", 12, 30000, 122);
        Product p9=new Product(9, "Salad", 13, 45000, 123);
        Product p10=new Product(10, "Soup", 14, 45000, 124);
        c2.addProduct(p6);
        c2.addProduct(p7);
        c2.addProduct(p8);
        c2.addProduct(p9);
        c2.addProduct(p10);
        categories.add(c2);

        Category c3=new Category(3,"Furniture",130);
        Product p11=new Product(11, "Chair", 12, 1201000, 135);
        Product p12=new Product(12, "Table", 10, 1220000, 131);
        Product p13=new Product(13, "Sofa", 12, 1450400, 132);
        Product p14=new Product(14, "Homeware", 13, 1205500, 133);
        Product p15=new Product(15, "Desk", 14, 1421000, 134);
        c3.addProduct(p11);
        c3.addProduct(p12);
        c3.addProduct(p13);
        c3.addProduct(p14);
        c3.addProduct(p15);
        categories.add(c3);

        Category c4=new Category(4,"Electronic",140);
        Product p16=new Product(16, "Laptop", 12, 5000000,141);
        Product p17=new Product(17, "Mouse", 10, 240000,142);
        Product p18=new Product(18, "Air-conditioner", 12, 15000,143);
        Product p19=new Product(19, "Washing machine", 13, 1800000,144);
        Product p20=new Product(20, "Dish washer", 14, 50000,145);
        c4.addProduct(p16);
        c4.addProduct(p17);
        c4.addProduct(p18);
        c4.addProduct(p19);
        c4.addProduct(p20);
        categories.add(c4);

        Category c5=new Category(5,"Clothes",150);
        Product p21=new Product(21, "Shirt", 12, 500000,151);
        Product p22=new Product(22, "Pants", 10, 190000,152);
        Product p23=new Product(23, "Shoes", 12, 1200000,153);
        Product p24=new Product(24, "Jacket", 13, 200000,154);
        Product p25=new Product(25, "Hat", 14, 180000,155);
        c5.addProduct(p21);
        c5.addProduct(p22);
        c5.addProduct(p23);
        c5.addProduct(p24);
        c5.addProduct(p25);
        categories.add(c5);

        Category c6=new Category(6,"Toy",160);
        Product p26=new Product(26, "Car", 12, 300000,161);
        Product p27=new Product(27, "Doll", 10, 400000,162);
        Product p28=new Product(28, "Lego", 12, 1200000,163);
        Product p29=new Product(29, "Puzzle", 13, 130000,164);
        Product p30=new Product(30, "Action Figure", 14, 140000,165);
        c6.addProduct(p26);
        c6.addProduct(p27);
        c6.addProduct(p28);
        c6.addProduct(p29);
        c6.addProduct(p30);
        categories.add(c6);

        Category c7=new Category(7,"Sport",170);
        Product p31=new Product(31, "Ball", 12, 450000,171);
        Product p32=new Product(32, "Bat", 10, 230000,172);
        Product p33=new Product(33, "Basket", 12, 410000,173);
        Product p34=new Product(34, "Helmet", 13, 100000,174);
        Product p35=new Product(35, "Gloves", 14, 120000,175);
        c7.addProduct(p31);
        c7.addProduct(p32);
        c7.addProduct(p33);
        c7.addProduct(p34);
        c7.addProduct(p35);
        categories.add(c7);

        Category c8=new Category(8,"Beauty",180);
        Product p36=new Product(36, "Lipstick", 12, 120000,181);
        Product p37=new Product(37, "Mascara", 10, 130000,182);
        Product p38=new Product(38, "Foundation", 12, 140000,183);
        Product p39=new Product(39, "Concealer", 13, 150000,184);
        Product p40=new Product(40, "Blusher", 14, 160000,185);
        c8.addProduct(p36);
        c8.addProduct(p37);
        c8.addProduct(p38);
        c8.addProduct(p39);
        c8.addProduct(p40);
        categories.add(c8);

        Category c9=new Category(9,"Home",190);
        Product p41=new Product(41, "Bed Sheet", 12, 1200000,191);
        Product p42=new Product(42, "Pillow", 10, 130000,192);
        Product p43=new Product(43, "Curtain", 12, 1900000,193);
        Product p44=new Product(44, "Mirror", 13, 120000,194);
        Product p45=new Product(45, "Curtains", 14, 120000,195);
        c9.addProduct(p41);
        c9.addProduct(p42);
        c9.addProduct(p43);
        c9.addProduct(p44);
        c9.addProduct(p45);
        categories.add(c9);

        Category c10=new Category(10, "Stationery", 200);
        Product p46=new Product(46, "Pen", 12, 12000, 201);
        Product p47=new Product(47, "Pencil", 10, 13000, 202);
        Product p48=new Product(48, "Pencil case", 12, 19000, 203);
        Product p49=new Product(49, "Notebook", 13, 12000, 204);
        Product p50=new Product(50, "Calculator", 14, 12000, 205);
        c10.addProduct(p46);
        c10.addProduct(p47);
        c10.addProduct(p48);
        c10.addProduct(p49);
        c10.addProduct(p50);
        categories.add(c10);
    }
}
