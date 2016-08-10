package ecncounter.wilson.com.encounter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.joooonho.SelectableRoundedImageView;

import java.util.ArrayList;
import java.util.Random;

import ecncounter.wilson.com.encounter.DTO.Pictrue;
import ecncounter.wilson.com.encounter.R;
import ecncounter.wilson.com.encounter.listener.RecyclerViewOnItemClickListener;


/**
 * Created by xiaoqiang on 16/7/31.
 */
public class PicWallAdapter extends RecyclerView.Adapter<PicWallAdapter.ViewHolder> implements View.OnClickListener {
    int[] h = {600, 700, 800};
    private Context context;
    private ArrayList<Pictrue> dataList;
    private static RecyclerViewOnItemClickListener itemClickListener;

    public PicWallAdapter(Context context, ArrayList<Pictrue> dataLsit) {
        this.context = context;
        this.dataList = dataLsit;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_content_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.OnItemClick((Integer) view.getTag());
                }
            }
        });

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setBackgroundResource(dataList.get(position).getTestpic());
        ViewGroup.LayoutParams params = holder.imageView.getLayoutParams();
        Random r = new Random();
        params.height = h[r.nextInt(2)];
        holder.imageView.setLayoutParams(params);

//        holder.plane.setOnClickListener(this);
//        holder.love.setOnClickListener(this);

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    public void setOnItemClick(RecyclerViewOnItemClickListener clickListener) {
        itemClickListener = clickListener;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "点击了耳语或爱心", Toast.LENGTH_SHORT).show();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private SelectableRoundedImageView imageView;
        private RelativeLayout plane, love;

        public ViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            imageView = (SelectableRoundedImageView) itemView.findViewById(R.id.masonry_item_img);
            imageView.setCornerRadiiDP(10, 10, 0, 0);
            plane = (RelativeLayout) imageView.findViewById(R.id.main_picwall_item_plane);
            love = (RelativeLayout) imageView.findViewById(R.id.main_picwall_item_love);
        }
    }
}
