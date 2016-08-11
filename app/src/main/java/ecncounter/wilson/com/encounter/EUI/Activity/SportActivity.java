package ecncounter.wilson.com.encounter.EUI.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ecncounter.wilson.com.encounter.DTO.Sport;
import ecncounter.wilson.com.encounter.R;
import ecncounter.wilson.com.encounter.adapter.SportTagsAdapter;


public class SportActivity extends BaseActivity implements View.OnClickListener {

    private ListView listView;
    String[] sports = {"运动", "游泳", "单车", "篮球", "瑜伽", "滑雪", "台球", "街舞"};
    String[] profession = {"文化/艺术", "学生", "IT/互联网/通讯", "媒体/公关", "金融", "法律", "咨询", "房地产/建筑"};
    private ArrayList<Sport> slist;
    private SportTagsAdapter adapter;
    private final int SPORT = 0;
    private final int PROFESSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
//        String from = getIntent().getStringExtra("fromto");
//        if (from.equals("sport")) {
//
//        }
        initView(SPORT);
    }

    private void initView(int type) {
        String[] ss = null;
        if (type == SPORT) {
            ss = sports;
            findViewById(R.id.sport_setup_tags).setOnClickListener(this);
        } else if (type == PROFESSION) {
            ss = profession;
            findViewById(R.id.sport_setup_tags).setVisibility(View.GONE);
        }
        findViewById(R.id.sport_back).setOnClickListener(this);

        listView = (ListView) findViewById(R.id.sport_listview);
        //初始化数据
        slist = new ArrayList<Sport>();
        for (int i = 0; i < sports.length; i++) {
            slist.add(new Sport(i, ss[i], false));
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
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("from", "sport");
                startActivity(intent);
                break;
        }
    }
}
