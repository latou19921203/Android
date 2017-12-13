package com.example.a61555.maintenance_demo10;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.a61555.maintenance_demo10.activity.InspectionActivity;
import com.example.a61555.maintenance_demo10.activity.ParameterActivity;
import com.example.a61555.maintenance_demo10.adapter.PagerViewAdapter;
import com.example.a61555.maintenance_demo10.fragment.FaultFragment;
import com.example.a61555.maintenance_demo10.fragment.HomeFragment;
import com.example.a61555.maintenance_demo10.fragment.InspectionFragment;
import com.example.a61555.maintenance_demo10.fragment.ParameterFragment;
import com.example.a61555.maintenance_demo10.utils.TutorialUtils;

import za.co.riggaroo.materialhelptutorial.tutorial.MaterialTutorialActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏原有的ActionBar
        setContentView(R.layout.activity_home_main);

        initToolbar();//初始化顶部Toolbar
        initHomeNavigation();//初始化HomeNavigation
        initAddFab();//初始化Fab
        //loadTutorial(this);//载入引导界面
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadHomeFragments();//载入PagerView
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == TUTORIAL_REQUEST_CODE){
            //退出引导页面时调用的方法
        }
    }

    /**
     * 载入引导界面
     */
    private static final int TUTORIAL_REQUEST_CODE = 3333;//引导界面的返回码

    public void loadTutorial(Context context) {
        Intent mainAct = new Intent(context, MaterialTutorialActivity.class);
        mainAct.putParcelableArrayListExtra(MaterialTutorialActivity.MATERIAL_TUTORIAL_ARG_TUTORIAL_ITEMS, TutorialUtils.getTutorialItems(this));
        startActivityForResult(mainAct, TUTORIAL_REQUEST_CODE);
    }

    /**
     * 载入PagerView
     */
    private ViewPager viewPager;
    private final int PARAMETER_ITEM_NUM = 0;
    private final int INSPECTION_ITEM_NUM = 1;
    private final int FAULT_ITEM_NUM = 2;
    private final int PRE_LOAD_PAGE_SUM = 2;

    public void loadHomeFragments() {
        PagerViewAdapter pagerViewAdapter;
        HomeFragment[] homeFragments;
        viewPager = (ViewPager) findViewById(R.id.view_pager_home);
        homeFragments = new HomeFragment[]{new ParameterFragment(), new InspectionFragment(), new FaultFragment()};
        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager(), homeFragments, 0);
        viewPager.setAdapter(pagerViewAdapter);
        viewPager.setOffscreenPageLimit(PRE_LOAD_PAGE_SUM);//设置预加载的页面数
        viewPager.setCurrentItem(currentPageNum);//设置初始页面
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             * 当页面在滑动时至滑动停止之前，此方法会一直调用
             * @param position 页面编号，向左滑动时为起始页面编号和终止页面编号（从起始变到终止）；向右滑动时为终止页面编号
             * @param positionOffset 当前页面偏移百分比
             * @param positionOffsetPixels 当前页面偏移的像素位置
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /**
             * 页面跳转完后调用
             * @param position 当前所在页编号
             */
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case PARAMETER_ITEM_NUM:
                        homeNavigation.setSelectedItemId(R.id.tab_menu_parameter);
                        break;
                    case INSPECTION_ITEM_NUM:
                        homeNavigation.setSelectedItemId(R.id.tab_menu_inspection);
                        break;
                    case FAULT_ITEM_NUM:
                        homeNavigation.setSelectedItemId(R.id.tab_menu_fault);
                        break;
                    default:
                        break;
                }
                currentPageNum = position;
            }

            /**
             * 页面状态改变时调用，页面状态分为静止、滑动时和滑动后
             * @param state 页面状态
             */
            @Override
            public void onPageScrollStateChanged(int state) {

                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING://滑动状态
                        break;
                    case ViewPager.SCROLL_STATE_IDLE://空闲状态
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING://滑动后自然沉降的状态
                        break;
                }
            }
        });
    }

    /**
     * 初始化HomeNavigation
     */
    private BottomNavigationView homeNavigation;
    private int currentPageNum = 0;
    public void initHomeNavigation() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            currentPageNum = bundle.getInt("currentPage");//当出其他页面返回时
            Log.i("[initHomeNavigation]", "success");
        }

        homeNavigation = (BottomNavigationView) findViewById(R.id.home_navigation);
        switch (currentPageNum) {
            case PARAMETER_ITEM_NUM:
                homeNavigation.setSelectedItemId(R.id.tab_menu_parameter);
                break;
            case INSPECTION_ITEM_NUM:
                homeNavigation.setSelectedItemId(R.id.tab_menu_inspection);
                break;
            case FAULT_ITEM_NUM:
                homeNavigation.setSelectedItemId(R.id.tab_menu_fault);
                break;
            default:
                break;
        }

        homeNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab_menu_parameter:
                        viewPager.setCurrentItem(PARAMETER_ITEM_NUM);
                        break;
                    case R.id.tab_menu_inspection:
                        viewPager.setCurrentItem(INSPECTION_ITEM_NUM);
                        break;
                    case R.id.tab_menu_fault:
                        viewPager.setCurrentItem(FAULT_ITEM_NUM);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    /**
     * 初始化新建报告的浮动按钮
     */
    public void initAddFab() {
        FloatingActionButton addFab = (FloatingActionButton) findViewById(R.id.add_fab);
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putBoolean("newForm", true);

                Intent intent = new Intent();
                intent.putExtras(bundle);
                switch (currentPageNum) {
                    case PARAMETER_ITEM_NUM:
                        intent.setClass(MainActivity.this, ParameterActivity.class);
                        break;
                    case INSPECTION_ITEM_NUM:
                        intent.setClass(MainActivity.this, InspectionActivity.class);
                        break;
                    case FAULT_ITEM_NUM:
                        //
                        break;
                    default: break;
                }
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化顶部Toolbar
     */
    public void initToolbar() {
        final String NavigationTitle = "Application Name";

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(NavigationTitle);//设置主标题
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorTitleText));//设置标题文本颜色
        toolbar.inflateMenu(R.menu.base_toolbar_menu);//设置右上角菜单
    }

    /**
     * 双击返回桌面
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        final long MIN_TIME = 2000;//两次点击相隔最短时长
        long exitTime = 0;//记录当前时间
        //判断是否点击系统回退键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //判断两次点击的时间间隔是否小于2秒
            if (System.currentTimeMillis() - exitTime > MIN_TIME) {
                Toast.makeText(this, "再次点击退出程序", Toast.LENGTH_SHORT).show();////显示提示信息
                exitTime = System.currentTimeMillis();//记录当前时间
            } else
                System.exit(0);//退出程序
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
