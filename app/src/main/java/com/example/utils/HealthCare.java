package com.example.utils;

public class HealthCare {
    public static BMIStatus calculate_bmi(double height, double weight){
        double BMI=weight/Math.pow(weight,2);
        String des="";
        if (BMI<18.5){
            des="So thin";
        }
        else if(BMI<25){
            des="Normal";
        }
        else{
            des="Fat";
        }
        return new BMIStatus(BMI, des);
    }
}
