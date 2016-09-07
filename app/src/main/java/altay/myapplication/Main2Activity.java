package altay.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;



    Button btn;
    Button share_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Random r = new Random();
        int sayi=r.nextInt(100);

        textView = (TextView)findViewById(R.id.txt_user_name);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);



        textView3.setText("%");
        textView4.setText(String.valueOf(sayi+1));



        textView.setText(getIntent().getExtras().getString("veri"));
        textView2.setText(getIntent().getExtras().getString("veri2"));
        btn = (Button) findViewById(R.id.login_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intent);
            }
        });
        share_button = (Button) findViewById(R.id.share_button);
        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.putExtra("veri", textView.getText().toString());
                intent.putExtra("veri2", textView2.getText().toString());
                startActivity(intent);



            }
        });

    }

}