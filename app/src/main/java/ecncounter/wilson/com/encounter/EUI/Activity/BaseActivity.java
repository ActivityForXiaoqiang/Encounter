package ecncounter.wilson.com.encounter.EUI.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/2.
 */
public class BaseActivity extends FragmentActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }


    public void showToast(String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}
