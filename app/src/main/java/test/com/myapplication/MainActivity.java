package test.com.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private View cview;// 底部视图
    ArrayAdapter<String> Adapter;
   ArrayList<String> arr=new ArrayList<String>();
    private BottomNavigationView bottomNavigationView;

   private  Fragment1 fragment1;
   private  Fragment2 fragment2;
   private Fragment[] fragments;
   private int lastfragment;//用于记录上个选择的Fragment


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home: {
                      //  mTextMessage.setText(R.string.title_home);
                        if(lastfragment!=0)
                        {
                            switchFragment(lastfragment,0);
                            lastfragment=0;

                        }
                        return true;
                    }
                    case R.id.navigation_dashboard: {
                        if(lastfragment!=1)
                        {
                            switchFragment(lastfragment,1);
                            lastfragment=1;

                        }
                        return true;
                    }
                        case R.id.navigation_notifications:
                      //  mTextMessage.setText(R.string.title_notifications);
                        return true;
                }
                return false;
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
      //  mTextMessage = (TextView) findViewById(R.id.message);
    //    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
     //   navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_home:
                Toast.makeText(this, "我是第一个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_dashboard:
                Toast.makeText(this, "我是第二个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_notifications:
                Toast.makeText(this, "我是第三个", Toast.LENGTH_SHORT).show();
                break;


        }
        return true;
    }

    //初始化fragment和fragment数组
    private void initFragment() {

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragments = new Fragment[]{fragment1, fragment2};
        lastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview, fragment1).show(fragment1).commit();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.mainview,fragments[index]);


        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }



}
