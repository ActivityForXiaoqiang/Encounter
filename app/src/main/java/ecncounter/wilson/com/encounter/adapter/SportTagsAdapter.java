package ecncounter.wilson.com.encounter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

import ecncounter.wilson.com.encounter.EUI.Sport;
import ecncounter.wilson.com.encounter.R;


/**
 * Created by Administrator on 2016/8/9.
 */
public class SportTagsAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sport> slist;

    public SportTagsAdapter(Context context, ArrayList<Sport> slist) {
        this.context = context;
        this.slist = slist;
    }

    @Override
    public int getCount() {
        return slist.size();
    }

    @Override
    public Object getItem(int i) {
        return slist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder vh;
        Sport s = slist.get(i);
        if (view == null) {
            vh = new viewHolder();
            view = View.inflate(context, R.layout.sport_list_item, null);
            vh.tv = (CheckBox) view.findViewById(R.id.sport_list_item_txt);
            vh.cb = (CheckBox) view.findViewById(R.id.sport_list_item_box);
            view.setTag(vh);
        } else {
            vh = (viewHolder) view.getTag();
        }
        vh.tv.setText(s.getTags());
        vh.tv.setChecked(s.isSelected());
        vh.cb.setChecked(s.isSelected());
        return view;
    }

    private class viewHolder {
        private CheckBox tv;
        private CheckBox cb;
    }
}
