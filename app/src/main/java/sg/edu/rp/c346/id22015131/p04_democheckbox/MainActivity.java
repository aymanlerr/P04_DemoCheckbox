package sg.edu.rp.c346.id22015131.p04_democheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbEnabled;
    Button btnCheck;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbEnabled = findViewById(R.id.discount);
        btnCheck = findViewById(R.id.checkButton);
        tvShow = findViewById(R.id.textView);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");

                String display_discount = "";
                if (cbEnabled.isChecked()) {
                    double pay = calcPay(100, 20);
                    display_discount = String.format("The discount is given. You need to pay $%.2f",pay);
                } else {
                    double pay = calcPay(100, 0);
                    display_discount = String.format("The discount is not given. You need to pay $%.2f", pay);
                }
                tvShow.setText(display_discount);

                Context context = getApplicationContext();
                CharSequence text = "Button Click";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    private double calcPay (double price, double discount) {
        return price * (1-discount/100);
    }
}