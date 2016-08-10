package ecncounter.wilson.com.encounter.EUI.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ecncounter.wilson.com.encounter.EUI.Sport;
import ecncounter.wilson.com.encounter.R;
import ecncounter.wilson.com.encounter.adapter.SportTagsAdapter;


public class SportActivity extends BaseActivity implements View.OnClickListener {

    private ListView listView;
    String[] sports = {"运动", "游泳", "单车", "篮球", "瑜伽", "滑雪", "台球", "街舞"};
    private ArrayList<Sport> slist;
    private SportTagsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        initView();
    }

    private void initView() {

        findViewById(R.id.sport_back).setOnClickListener(this);
        findViewById(R.id.sport_setup_tags).setOnClickListener(this);
        listView = (ListView) findViewById(R.id.sport_listview);
        //初始化数据
        slist = new ArrayList<Sport>();
        for (int i = 0; i < sports.length; i++) {
            slist.add(new Sport(i, sports[i], false));
        }
        adapter = new SportTagsAdapter(this, slist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //点击选择或取消
                Sport s = slist.get(i);
                //设置相反值
                s.setSelected(!s.isSelected());
                slist.set(i, s);
                //更新
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sport_back:
                finish();
                break;
            case R.id.sport_setup_tags:
                break;
        }
    }
}
