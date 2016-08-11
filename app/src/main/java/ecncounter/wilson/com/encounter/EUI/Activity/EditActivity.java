package ecncounter.wilson.com.encounter.EUI.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import ecncounter.wilson.com.encounter.R;

public class EditActivity extends BaseActivity implements View.OnClickListener {
    //创建标签
    EditText tag;
    private final int SPORT = 0;
    private final int MODIFY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        String from = getIntent().getStringExtra("from");
        if (from.equals("sport")) {
            initView(SPORT);
        }

    }

    private void initView(int type) {
        ImageView cancel_img = (ImageView) findViewById(R.id.edit_cancel_img);
        TextView cancel = (TextView) findViewById(R.id.edit_cancel);
        cancel.setOnClickListener(this);
        TextView finish = (TextView) findViewById(R.id.edit_finish);
        finish.setOnClickListener(this);
        tag = (EditText) findViewById(R.id.edit_tag);
        if (type == SPORT) {
            findViewById(R.id.edit_hint).setVisibility(View.GONE);
            cancel_img.setVisibility(View.GONE);
        } else if (type == 1) {
            TextView title = (TextView) findViewById(R.id.edit_title);
            cancel.setVisibility(View.GONE);
            cancel_img.setOnClickListener(this);
            title.setText("修改手机号码");
            finish.setText("下一步");
            tag.setHint("请输入密码");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_cancel:
                finish();
                break;
            case R.id.edit_cancel_img:
                finish();
                break;
            case R.id.edit_finish:
                break;
        }
    }
}
