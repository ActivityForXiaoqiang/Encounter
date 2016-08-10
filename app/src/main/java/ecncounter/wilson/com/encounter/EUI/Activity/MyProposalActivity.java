package ecncounter.wilson.com.encounter.EUI.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import ecncounter.wilson.com.encounter.DTO.Proposal;
import ecncounter.wilson.com.encounter.R;
import ecncounter.wilson.com.encounter.adapter.ProposalAdapter;


public class MyProposalActivity extends BaseActivity implements View.OnClickListener {
    ListView listView;
    ArrayList<Proposal> plist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_proposal);
        initView();
    }

    public void initView() {
        listView = (ListView) findViewById(R.id.proposal_listview);
        View v = View.inflate(this, R.layout.proposal_list_head, null);
        findViewById(R.id.proposal_back).setOnClickListener(this);
        findViewById(R.id.proposal_write).setOnClickListener(this);
        listView.addHeaderView(v);
        //初始化数据
        plist = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String tags = "";
            for (int j = 0; j < 4; j++) {
                tags += "第" + j + "tags" + "&";
            }
            tags = tags.substring(0, tags.length() - 1);
            Proposal p = new Proposal(i, tags, "2016年6月1日");
            plist.add(p);
        }
        listView.setAdapter(new ProposalAdapter(this, plist));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.proposal_back:
                finish();
                break;
            case R.id.proposal_write:
                startActivity(new Intent(this,WriteProposalActivity.class));
                break;
        }
    }
}
