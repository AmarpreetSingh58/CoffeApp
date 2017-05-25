package com.example.kk.coffeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This variable contains the quantity.
     */
    int quantity=0;
    /**
     * This method is called when the order button is clicked.
     */
    public void submitorder(View view){
        int price = calculatePrice();
        String orderSummary= createOrderSummary(price);
        displayOrderSummary(orderSummary);
        composeMail(orderSummary);
    }


    /**
     * This procedure increases the count of quantity when + button is clicked.
     */
    public void increaseQuantity(View view){
        quantity++;
        displayQuantity();
    }

    /**
     * This procedure increases the count of quantity when + button is clicked.
     */
    public void decreaseQuantity(View view){
        if(quantity!=0)
        quantity--;
        else
        quantity=0;
        displayQuantity();
    }

    /**
     * this precedure displays the change in quantity
     */
    private void displayQuantity(){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textView);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This procedure resets all the things.
     */
    public void resetAll(View view){
        quantity=0;
        displayQuantity();
        resetdisplayMessage();
        EditText nameTextView = (EditText) findViewById(R.id.nameTextView);
        nameTextView.setText("Enter your name");
        resetCheckbox();
    }
    /**
     * This method calculates the total amount.
     */
    private int calculatePrice(){
        int total,price=5;
        if(isWhippedCreamChecked()){
            price= price+2;
        }
        if(isCaramelChecked()){
            price = price+1;
        }
        if(isChoclateCokkieCrumbsChecked()){
            price= price+3;
        }
        if(isChoclateCurlsChecked()){
            price= price+2;
        }
        if(ischoclateSprinklesChecked()){
            price=price+2;
        }
        if(isCinnamonChecked()){
            price=price+2;
        }
        if(isNutmegChecked()){
            price+=2;
        }
        total = price * quantity;
        return (total);
    }

    /**
    * This method displays the given text on the screen.
    */
    private String createOrderSummary(int price) {
        String message;
        message = "Ordered By : "+getName()+
        "\n Quantity : "+quantity+
        "\n Summary : \n"+
        "\n Coffee :                                        "+quantity+" * $5  "+quantity*5;
        if(isWhippedCreamChecked()){
            message = message+"\n Whipped Cream :           "+quantity+" * $2 = "+quantity*2;
        }
        if(isCaramelChecked()){
            message = message+"\n Caramel Syrup :           "+quantity+" * $1 = "+quantity*3;
        }
        if(isChoclateCokkieCrumbsChecked()){
            message = message+"\n Chocolate Cookie Crumbs : "+quantity+" * $3 = "+quantity*3;
        }
        if(isChoclateCurlsChecked()){
            message = message+"\n Chocolate Curls :         "+quantity+" * $2 = "+quantity*2;
        }
        if(ischoclateSprinklesChecked()){
            message = message+"\n Chocolate Sprinkles :     "+quantity+" * $2 = "+quantity*2;
        }
        if(isCinnamonChecked()){
            message = message+"\n Cinnamon Sprinkles :      "+quantity+" * $2 = "+quantity*2;
        }
        if(isNutmegChecked()){
            message = message+"\n Nutmeg :                  "+quantity+" * $2 = "+quantity*2;
        }
        message= message+"\n Total :                                            "+price;

        return (message);
    }

    /**
     * This function displays the order summary.
     */
    private void displayOrderSummary(String summary){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummaryTextView);
        orderSummaryTextView.setText(summary);
    }

    /**
     * this function returns name of the user.
     * @return
     */
    private String getName(){
        EditText nameTextView = (EditText) findViewById(R.id.nameTextView);
        String name = nameTextView.getText().toString();
        return (name);
    }

    /**
     * This procedure checks if the check box for topping is checked or not.
     * @return
     */
    private Boolean isWhippedCreamChecked(){
        CheckBox toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_whippedCheckbox);
        Boolean ischecked = toppingsCheckbox.isChecked();
        return (ischecked);
    }
    /**
     * This procedure checks if the check box for topping is checked or not.
     * @return
     */
    private Boolean ischoclateSprinklesChecked(){
        CheckBox toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_cholclateSprinklesCheckbox);
        Boolean ischecked = toppingsCheckbox.isChecked();
        return (ischecked);
    }
    /**
     * This procedure checks if the check box for topping is checked or not.
     * @return
     */
    private Boolean isNutmegChecked(){
        CheckBox toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_nutmegCheckbox);
        Boolean ischecked = toppingsCheckbox.isChecked();
        return (ischecked);
    }
    /**
     * This procedure checks if the check box for topping is checked or not.
     * @return
     */
    private Boolean isCinnamonChecked(){
        CheckBox toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_cinnamonSprinklesCheckbox);
        Boolean ischecked = toppingsCheckbox.isChecked();
        return (ischecked);
    }
    /**
     * This procedure checks if the check box for topping is checked or not.
     * @return
     */
    private Boolean isChoclateCurlsChecked(){
        CheckBox toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_choclateCurlsCheckbox);
        Boolean ischecked = toppingsCheckbox.isChecked();
        return (ischecked);
    }
    /**
     * This procedure checks if the check box for topping is checked or not.
     * @return
     */
    private Boolean isChoclateCokkieCrumbsChecked(){
        CheckBox toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_ChoclateCokkiesCrumbCheckbox);
        Boolean ischecked = toppingsCheckbox.isChecked();
        return (ischecked);
    }
    /**
     * This procedure checks if the check box for topping is checked or not.
     * @return
     */
    private Boolean isCaramelChecked(){
        CheckBox toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_CaramelSyrupCheckbox);
        Boolean ischecked = toppingsCheckbox.isChecked();
        return (ischecked);
    }

    /**
     * this functions resets the checkbox to false.
     */
    private void resetCheckbox(){
        CheckBox toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_whippedCheckbox);
        if(toppingsCheckbox.isChecked()){
            toppingsCheckbox.setChecked(false);
        }
        toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_cholclateSprinklesCheckbox);
        if(toppingsCheckbox.isChecked()) {
            toppingsCheckbox.setChecked(false);
        }
        toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_choclateCurlsCheckbox);
        if(toppingsCheckbox.isChecked()) {
            toppingsCheckbox.setChecked(false);
        }
        toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_ChoclateCokkiesCrumbCheckbox);
        if(toppingsCheckbox.isChecked()) {
            toppingsCheckbox.setChecked(false);
        }
        toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_CaramelSyrupCheckbox);
        if(toppingsCheckbox.isChecked()) {
            toppingsCheckbox.setChecked(false);
        }
        toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_cinnamonSprinklesCheckbox);
        if(toppingsCheckbox.isChecked()) {
            toppingsCheckbox.setChecked(false);
        }
        toppingsCheckbox = (CheckBox) findViewById(R.id.toppings_nutmegCheckbox);
        if(toppingsCheckbox.isChecked()) {
            toppingsCheckbox.setChecked(false);
        }
    }

    /**
     * This resets the order Summary Text View to blank.
     */
    private void resetdisplayMessage(){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummaryTextView);
        orderSummaryTextView.setText("");
    }

    /**
     * This functions calls the intent.
     */
    private void composeMail(String summary){
        Intent mail = new Intent(Intent.ACTION_SENDTO);
        mail.setData(Uri.parse("mailto:"));
        mail.putExtra(Intent.EXTRA_EMAIL,"amarpreetsingh58@gmail.com");
        mail.putExtra(Intent.EXTRA_SUBJECT,"Order Summary of order by "+getName());
        mail.putExtra(Intent.EXTRA_TEXT,summary);
        if(mail.resolveActivity(getPackageManager())!= null){
            startActivity(mail);
        }
    }


}
