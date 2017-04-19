package com.example.navigationdrawerdemo;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShezhiActivity extends AppCompatActivity {


    private TextView RPassword;
    private TextView RPMessage;
    private TextView AboutOurs;
    private TextView Out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shezhi);

//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.shezhi_container, new PlaceholderFragment())
//                    .commit();
//        }
        init();

//        RPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(ShezhiActivity.this,RevisePasswordActivitty.class);
//                startActivity(intent);
//            }
//        });

        AboutOurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShezhiActivity.this,AboutOursActivity.class);
                startActivity(intent);
            }
        });
   }

    private void init() {
        RPassword=(TextView) findViewById(R.id.rpassword);
        RPMessage= (TextView) findViewById(R.id.rmessage);
        AboutOurs=(TextView) findViewById(R.id.aboutours);
        Out=(TextView) findViewById(R.id.out);
    }


//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.shezhi_fragment, container, false);
//            return rootView;
//        }
//    }

}