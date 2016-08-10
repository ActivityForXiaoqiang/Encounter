package ecncounter.wilson.com.encounter.EUI.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import ecncounter.wilson.com.encounter.R;

/**
 * Created by xiaoqiang on 16/8/10.
 */
public class PositionDialog extends Dialog{
    public PositionDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_position);
    }
}
