package ecncounter.wilson.com.encounter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ecncounter.wilson.com.encounter.DTO.Proposal;
import ecncounter.wilson.com.encounter.EUI.NoScrollGridView;
import ecncounter.wilson.com.encounter.R;

/**
 * Created by Administrator on 2016/8/3.
 */
public class ProposalAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Proposal> plist;

    public ProposalAdapter(Context context, ArrayList<Proposal> plist) {
        this.context = context;
        this.plist = plist;
    }

    @Override
    public int getCount() {
        return plist.size();
    }

    @Override
    public Object getItem(int i) {
        return plist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Proposal p = plist.get(i);
        viewHolder vh;
        if (view == null) {
            vh = new viewHolder();
            view = View.inflate(context, R.layout.proposal_list_item, null);
            vh.gridView = (NoScrollGridView) view.findViewById(R.id
                    .proposal_listview_item_gridview);
            vh.tv_time = (TextView) view.findViewById(R.id.proposal_listview_item_tv_time);
            view.setTag(vh);
        } else {
            vh = (viewHolder) view.getTag();
        }
        String[] tags = p.getTags().split("&");
        vh.gridView.setAdapter(new ProposalTagsAdapter(context, tags));
        vh.tv_time.setText(p.getTime());
        return view;
    }

    public class viewHolder {
        private NoScrollGridView gridView;
        private TextView tv_time;
    }
}
