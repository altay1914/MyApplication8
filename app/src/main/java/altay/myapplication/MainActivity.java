package altay.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.*;
import com.facebook.share.ShareApi;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.Delayed;


public class MainActivity extends Activity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private TextView user_name;
    private Button share_button;
    private ShareDialog shareDialog;
    private EditText share_txt;
    Bitmap mbitmap;
    ImageView imageView;
    Button button;

    TextView textView,textView6;
    TextView textView2;


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        FacebookSdk.sdkInitialize(getApplicationContext());

        shareDialog = new ShareDialog(MainActivity.this);

        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_main);

        user_name = (TextView)findViewById(R.id.txt_user_name);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);

        textView6 = (TextView)findViewById(R.id.textView6);

        imageView = (ImageView) findViewById(R.id.imageView);


        textView.setText(getIntent().getExtras().getString("veri"));
        textView2.setText(getIntent().getExtras().getString("veri2"));



        loginButton = (LoginButton)findViewById(R.id.login_button);

        share_txt = (EditText)findViewById(R.id.edit_share);

        share_button = (Button)findViewById(R.id.share_button);

        loginButton.setReadPermissions(Arrays.asList("public_profile ","user_friends","email"));

        button = (Button) findViewById(R.id.button);





        loginButton.registerCallback(callbackManager,new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {





                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject user,
                                    GraphResponse response) {



                                // user_name.setText(response.toString());

                                try{

                                    String id = user.getString("id");
                                    String name = user.getString("name");
                                    user_name.setText("Hoşgeldin " + " " + name);



                                }catch (Exception e)
                                {
                                    e.printStackTrace();
                                }



                            }
                        });

                request.executeAsync();

            }

            @Override
            public void onCancel() {




            }

            @Override
            public void onError(FacebookException e) {

            }
        });


        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              mbitmap = getBitmapOFRootView(share_button);
                textView6.setText("deneme");

                textView6.setText("DENEME2");
             createImage(mbitmap);




             shareToWall();

            }
        });





    }



    public Bitmap getBitmapOFRootView(View v) {
        View rootview = v.getRootView();
        rootview.setDrawingCacheEnabled(true);
        Bitmap bitmap1 = rootview.getDrawingCache();
        return bitmap1;
    }
    public void createImage(Bitmap bmp) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
        File file = new File(Environment.getExternalStorageDirectory() +
                "/capturedscreenandroid.jpg");

        try {
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes.toByteArray());
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    private void shareToWall()
    {


        String send = share_txt.getText().toString();
       // textView.setText(getIntent().getExtras().getString("veri"));
       // textView2.setText(getIntent().getExtras().getString("veri2"));



        textView6.setText("DENEME4");
            ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
                    .setContentTitle("mobilhanem")
                    .setContentUrl(Uri.parse("http://www.mobilhanem.com/"))
                    .setContentDescription("Facebook Entegrasyonu Tamamlandı"+" "+send)
                    .build();









    }


}
