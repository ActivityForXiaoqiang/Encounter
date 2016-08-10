package ecncounter.wilson.com.encounter.EUI.Activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import ecncounter.wilson.com.encounter.DTO.Pictrue;
import ecncounter.wilson.com.encounter.EUI.dialog.ConstellationDialog;
import ecncounter.wilson.com.encounter.EUI.dialog.PositionDialog;
import ecncounter.wilson.com.encounter.EUI.dialog.TagDialog;
import ecncounter.wilson.com.encounter.R;
import ecncounter.wilson.com.encounter.adapter.PicWallAdapter;
import ecncounter.wilson.com.encounter.listener.RecyclerViewOnItemClickListener;


/**
 * Created by xiaoqiang on 16/7/31.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    //瀑布流
    private PullLoadMoreRecyclerView pullLoadMoreRecyclerView;
    private PicWallAdapter adapter;

    //侧滑
    private DrawerLayout mdrawerLayout;
    private NavigationView mNavigationView;

    //侧滑菜单item
    private String[] item_title = {"主题吧", "消息", "邀请好友", "设置"};

    //测试数据
    ArrayList<Pictrue> datas;
    private View showView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        getdata();
        init();
        custom();
    }

    private void custom() {
        //test
        //弧度距离
        int ActionMenuRadius = getResources().getDimensionPixelSize(R.dimen.mian_menu_radius);
        int menu_button_size = getResources().getDimensionPixelSize(R.dimen.mian_menu_button_size);
        int menu_button_margin = getResources().getDimensionPixelOffset(R.dimen.mian_menu_button_margin);
        int size = getResources().getDimensionPixelOffset(R.dimen.mian_menu_button_item_size);

        int menu_item_button_margin = getResources().getDimensionPixelOffset(R.dimen.mian_menu_button_item_margin);

        final ImageView menuIcon = new ImageView(this);
//        menuIcon.setBackgroundResource(R.color.colorPrimary);
        menuIcon.setImageResource(R.mipmap.icon_add);
        FloatingActionButton.LayoutParams params = new FloatingActionButton.LayoutParams(menu_button_size, menu_button_size);
        params.setMargins(menu_button_margin, menu_button_margin, menu_button_margin, menu_button_margin);
//        menuIcon.setLayoutParams(params);

        final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(this)
                .setContentView(menuIcon)
                .setBackgroundDrawable(R.mipmap.icon_menu)
                .setLayoutParams(params)
                .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
//        FrameLayout.LayoutParams blueContentParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
//
//        blueContentParams.setMargins(menu_item_button_margin,
//                menu_button_margin,
//                menu_button_margin,
//                menu_button_margin);
//        rLSubBuilder.setLayoutParams(blueContentParams);


        FrameLayout.LayoutParams blueParams = new FrameLayout.LayoutParams(size, size);
        rLSubBuilder.setLayoutParams(blueParams);
        ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);
        ImageView rlIcon4 = new ImageView(this);
        ImageView rlIcon5 = new ImageView(this);

        SubActionButton sab1 = rLSubBuilder.setContentView(rlIcon1, blueParams).build();
        SubActionButton sab2 = rLSubBuilder.setContentView(rlIcon2, blueParams).build();
        SubActionButton sab3 = rLSubBuilder.setContentView(rlIcon3, blueParams).build();
        SubActionButton sab4 = rLSubBuilder.setContentView(rlIcon4, blueParams).build();
        SubActionButton sab5 = rLSubBuilder.setContentView(rlIcon5, blueParams).build();


        rlIcon1.setBackgroundResource(R.mipmap.index_icon_near);
        rlIcon2.setBackgroundResource(R.mipmap.index_icon_tag);
        rlIcon3.setBackgroundResource(R.mipmap.index_icon_constellation);
        rlIcon4.setBackgroundResource(R.mipmap.index_icon_contact);
        rlIcon5.setBackgroundResource(R.mipmap.index_icon_meet);


        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(sab1)
                .addSubActionView(sab2)
                .addSubActionView(sab3)
                .addSubActionView(sab4)
                .addSubActionView(sab5)
                .setRadius(ActionMenuRadius)
                .attachTo(rightLowerButton)
                .build();

        rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                menuIcon.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(menuIcon, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu floatingActionMenu) {
                menuIcon.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(menuIcon, pvhR);
                animation.start();
            }
        });


        sab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PositionDialog dialog = new PositionDialog(MainActivity.this, R.style.Dialog_Fullscreen);
                dialog.show();
                rightLowerMenu.close(true);
            }
        });
        sab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TagDialog dialog = new TagDialog(MainActivity.this, R.style.Dialog_Fullscreen);
                dialog.show();
                rightLowerMenu.close(true);
            }
        });
        sab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstellationDialog dialog = new ConstellationDialog(MainActivity.this, R.style.Dialog_Fullscreen);
                dialog.show();
                rightLowerMenu.close(true);
            }
        });

    }


    private void init() {


        pullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.main_content_list);
        pullLoadMoreRecyclerView.setRefreshing(false);
        pullLoadMoreRecyclerView.setPullRefreshEnable(false);
        pullLoadMoreRecyclerView.setPushRefreshEnable(true);
        pullLoadMoreRecyclerView.setFooterViewText("loading");
        pullLoadMoreRecyclerView.setFooterViewTextColor(R.color.color_gray_dark);
        pullLoadMoreRecyclerView.setStaggeredGridLayout(2);
        //上啦加载 监听
        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                new Handler() {

                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
                    }
                }.sendEmptyMessageDelayed(1, 2000);
            }
        });

        adapter = new PicWallAdapter(this, datas);
        pullLoadMoreRecyclerView.setAdapter(adapter);
        adapter.setOnItemClick(new RecyclerViewOnItemClickListener() {
            @Override
            public void OnItemClick(int postion) {
                showToast("点击了" + postion);
            }
        });
        mdrawerLayout = (DrawerLayout) findViewById(R.id.main_DrawerLayout);


        mdrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                for (int i = 0; i < item_title.length; i++) {
                    if (item.getTitle().equals(item_title[i])) {
                        Click(i);
                    }
                }

                mdrawerLayout.closeDrawers();

                return false;
            }
        });


        findViewById(R.id.left_menu_buttn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    void Click(int index) {
        switch (index) {
            case 0: //主题吧
                break;
            case 1: //消息
                break;
            case 2: //邀请好友
                break;
            case 3: //设置
                startActivity(new Intent(MainActivity.this, SettingActivity.class));

                break;
        }
    }

    void getdata() {
        List<Integer> piclist = new ArrayList<>();
        piclist.add(R.mipmap.img_icon1);
        piclist.add(R.mipmap.img_icon2);
        piclist.add(R.mipmap.img_icon3);
        piclist.add(R.mipmap.img_icon4);
        piclist.add(R.mipmap.img_icon1);
        piclist.add(R.mipmap.img_icon2);
        piclist.add(R.mipmap.img_icon4);
        piclist.add(R.mipmap.img_icon2);
        piclist.add(R.mipmap.img_icon3);
        piclist.add(R.mipmap.img_icon2);
        datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Pictrue p = new Pictrue();
            p.setTestpic(piclist.get(i));
            datas.add(p);
        }
        ;
    }


    @Override
    public void onClick(View view) {
        Log.i("xiaoqiang", "dddd");
    }
}
