package ecncounter.wilson.com.encounter.EUI.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import ecncounter.wilson.com.encounter.EUI.FlowRadioGroup;
import ecncounter.wilson.com.encounter.R;


public class WriteProposalActivity extends BaseActivity implements View.OnClickListener {
    FlowRadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_proposal);
        initView();
    }

    private void initView() {
        findViewById(R.id.write_proposal_cancel).setOnClickListener(this);
        findViewById(R.id.write_proposal_finish).setOnClickListener(this);
        findViewById(R.id.write_proposal_add).setOnClickListener(this);
        rg = (FlowRadioGroup) findViewById(R.id.write_proposa_radiogroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //取消
            case R.id.write_proposal_cancel:
                finish();
                break;
            //发表建议
            case R.id.write_proposal_finish:

                break;
            //添加标签
            case R.id.write_proposal_add:
                addTags("new tags");
                break;
        }
    }

    //添加新标签
    private void addTags(String str) {
        CheckBox ck = (CheckBox) View.inflate(this, R.layout.my_check_box, null);
        ck.setText(str);
        rg.addView(ck);
    }
}
