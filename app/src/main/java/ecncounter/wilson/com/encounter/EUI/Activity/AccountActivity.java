package ecncounter.wilson.com.encounter.EUI.Activity;

import android.os.Bundle;
import android.view.View;

import ecncounter.wilson.com.encounter.R;

public class AccountActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        initView();
    }

    private void initView() {
        findViewById(R.id.account_back).setOnClickListener(this);
        findViewById(R.id.account_sex).setOnClickListener(this);
        findViewById(R.id.account_name).setOnClickListener(this);
        findViewById(R.id.account_birthday).setOnClickListener(this);
        findViewById(R.id.account_phone).setOnClickListener(this);
        findViewById(R.id.account_modify_pwd).setOnClickListener(this);
        findViewById(R.id.account_logout).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.account_back:
                finish();
                break;
            case R.id.account_sex:
                break;
            case R.id.account_name:
                break;
            case R.id.account_birthday:
                break;
            case R.id.account_phone:
                break;
            case R.id.account_modify_pwd:
                break;
            case R.id.account_logout:
                break;
        }
    }
}
