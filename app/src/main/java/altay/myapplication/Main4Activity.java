package altay.myapplication;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.FacebookSdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;



public class Main4Activity extends AppCompatActivity {


    TextView metin_alani;
    TextView metin_alani2;
    Button btn,btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main4);

        metin_alani = (TextView) findViewById(R.id.txt_user_name);
        metin_alani2 = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.login_button);
        btn2= (Button) findViewById(R.id.button2);
        final String sorular [] =
                {"asla başarısız olmacaksın" ,"asla pes edemeyeceksin",
                        "dünyada ki en güzel yemekleri pişireceksin","kendi yaptığın yemek dışında başka bir yemek yiyemezsin",
                        "meyvesi para olan bir ağacın var", "üzerinden para topladığın zaman elli bin ağaç ölüyor",
                        "500 yıl sonraya gidip geri geleceksin","sağ elin ayağına dönüşecek",
                        "maaşın 3'e katlanacak","boyun 3 kat kısalacak",
                        "kendine ait sualtı şehrin olacak","yeryüzüne bir daha çıkamayacaksın",
                        "sonsuza kadar yaşayacaksın","her yıl hafızan sıfırlanacak",
                        "normal yaşamından 15 yıl önce öleceksin","her zaman ideal vücut ölçülerine sahip olacaksın",
                        "sen ve tanığın herkes 100 yıl daha fazla yaşayacak","sen asla çoraplarını ve iç çamaşırını değiştiremeyeceksin",
                        "18", "19",
                        "7"};
        Random r = new Random();
        int sayi=r.nextInt(19);
        if (sayi%2!=0) {
            sayi = sayi + 1;
        }
        metin_alani.setText(sorular[sayi]);
        metin_alani2.setText(sorular[sayi+1]);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("veri", metin_alani.getText().toString());
                intent.putExtra("veri2", metin_alani2.getText().toString());
                startActivity(intent);



            }


        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                intent.putExtra("veri", metin_alani.getText().toString());
                intent.putExtra("veri2", metin_alani2.getText().toString());
                startActivity(intent);




            }
        });


    }






}