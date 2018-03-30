package penpencil.com.testapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.customComponent.utility.ProjectPrefrence;
import com.penpencil.core.custom.utility.AppConstant;

public class SplashActivity extends AppCompatActivity {
    private Context context;
    private int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context=this;
       // DatabaseOpration.getStateList(context);
       showSplash();
    }

    private void showSplash(){
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
             /*   UserItem item= UserItem.create(ProjectPrefrence.getSharedPrefrenceData(AppConstant.PROJECT_PREF,AppConstant.LOGIN_PREF,context));
                if(item!=null) {
                    Intent i = new Intent(context, Home.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent i = new Intent(context, Welcome.class);
                    startActivity(i);
                    finish();
                }*/
                //navigateUpToFromChild(SplashActivity.this,i);
            }
        }, SPLASH_TIME_OUT);
    }
}
