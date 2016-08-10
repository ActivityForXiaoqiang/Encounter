package ecncounter.wilson.com.encounter.EUI.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import ecncounter.wilson.com.encounter.R;


public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private SeekBar seekBar;
    private CheckBox boy, girl, screen, alert;
    TextView scope_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    public void initView() {
        seekBar = (SeekBar) findViewById(R.id.setting_seekbar);
        boy = (CheckBox) findViewById(R.id.setting_boy_checkbox);
        boy.setClickable(false);
        girl = (CheckBox) findViewById(R.id.setting_girl_checkbox);
        girl.setClickable(false);
        screen = (CheckBox) findViewById(R.id.screen_contacts);
        alert = (CheckBox) findViewById(R.id.message_alert_box);
        //范围
        scope_num = (TextView) findViewById(R.id.setting_scope_num);
        findViewById(R.id.setting_back).setOnClickListener(this);
        findViewById(R.id.setting_more).setOnClickListener(this);
        findViewById(R.id.setting_boy).setOnClickListener(this);
        findViewById(R.id.setting_girl).setOnClickListener(this);
        findViewById(R.id.setting_privacy).setOnClickListener(this);
        findViewById(R.id.message_alert).setOnClickListener(this);
        findViewById(R.id.edit_information).setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                scope_num.setText(seekBar.getProgress() + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //返回
            case R.id.setting_back:
                finish();
                break;
            //更多
            case R.id.setting_more:
                startActivity(new Intent(this, MyProposalActivity.class));
                break;
            //性别选择男
            case R.id.setting_boy:
                boy.setChecked(!boy.isChecked());
                girl.setChecked(!girl.isChecked());
                break;
            //女
            case R.id.setting_girl:
                girl.setChecked(!girl.isChecked());
                boy.setChecked(!boy.isChecked());
                break;
            //隐私
            case R.id.setting_privacy:
                screen.setChecked(!screen.isChecked());
                break;
            //启用消息提醒
            case R.id.message_alert:
                alert.setChecked(!alert.isChecked());
                break;
            //编辑账户信息
            case R.id.edit_information:
                break;
            default:
                break;
        }
    }

    public void onClickLogout(View v) {

    }

    public void onClickContact(View v) {

    }
}
