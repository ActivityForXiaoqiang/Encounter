package ecncounter.wilson.com.encounter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ecncounter.wilson.com.encounter.R;


/**
 * Created by Administrator on 2016/8/3.
 */
public class ProposalTagsAdapter extends BaseAdapter {
    Context context;
    String[] tags;

    public ProposalTagsAdapter(Context context, String[] tags) {
        this.context = context;
        this.tags = tags;
    }

    @Override
    public int getCount() {
        return tags.length;
    }

    @Override
    public Object getItem(int i) {
        return tags[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder vh;
        if (view == null) {
            vh = new viewHolder();
            view = View.inflate(context, R.layout.proposal_tags_item, null);
            vh.tv_tag = (TextView) view.findViewById(R.id.proposal_tags_tv);
            view.setTag(vh);
        }else{
            vh = (viewHolder) view.getTag();
        }
        vh.tv_tag.setText(tags[i]);
        return view;
    }

    class viewHolder {
        private TextView tv_tag;
    }
}
