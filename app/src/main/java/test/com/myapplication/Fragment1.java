package test.com.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class Fragment1 extends Fragment {
    private TextView textView;
    private Button button;
    private ListView ls1;
    private  View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.f1,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView=(TextView)getActivity().findViewById(R.id.textView1);
        button=(Button)getActivity().findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Fragment1",Toast.LENGTH_SHORT).show();
            }
        });

           /*     String[] listItem = { "a", "b", "c", "d", "e" };
        int[] iconItem = { R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher };
        adapter = new SimpleAdapter(getActivity(), getData(listItem, iconItem),
                R.layout.me_function_item, new String[] { "name", "icon" },
                new int[] { R.id.functionName, R.id.functionIcon });
        setListAdapter(adapter); */

        List<Map<String,Object>> ls=new ArrayList<Map<String, Object>>();
        Map<String,Object> m=new HashMap<String, Object>();
        m.put("coursename","语文");
        m.put("qty","12");
        Map<String,Object> m1=new HashMap<String, Object>();
        m1.put("coursename","数学");
        m1.put("qty","20");
        ls.add(m);
        ls.add(m1);
    /*
        for(int i=0;i<=ls.size();i++){

         Log.i("i",String.valueOf(ls.get(i).get("coursename") ));
        }  */


        ls1 =(ListView) getActivity().findViewById(R.id.ls1);//getActivity()
        SimpleAdapter adapter=new SimpleAdapter(this.getActivity(),
                ls,R.layout.list_item,
                new String[]{"coursename","qty"},  //添加字段，与控件对应，这个不是设置标题的
                new int[]{R.id.coursename,R.id.qty}
        );
        ls1.setAdapter(adapter);
    }





}
