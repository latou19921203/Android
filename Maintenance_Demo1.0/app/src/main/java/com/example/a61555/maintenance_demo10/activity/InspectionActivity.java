package com.example.a61555.maintenance_demo10.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.a61555.maintenance_demo10.MainActivity;
import com.example.a61555.maintenance_demo10.R;
import com.example.a61555.maintenance_demo10.adapter.PagerViewAdapter;
import com.example.a61555.maintenance_demo10.fragment.InspectionFormFragment;
import com.example.a61555.maintenance_demo10.views.FormListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 61555 on 2017/8/23.
 */

public class InspectionActivity extends AppCompatActivity {

    private final String NavigationTitle = "巡检记录表";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏原有的ActionBar
        setContentView(R.layout.activity_form_container);

        initToolbar();
        initCommitButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadFormViewPager();
    }

    /**
     * 初始化Toolbar
     */
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_left2);//设置导航栏图标
        toolbar.setTitle(NavigationTitle);//设置主标题
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorTitleText));//设置标题文本颜色
        toolbar.inflateMenu(R.menu.base_toolbar_menu);//设置右上角菜单
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putInt("currentPage", 1);

                Intent intent = new Intent();
                intent.setClass(InspectionActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtras(data);

                startActivity(intent);//返回主页
                finish();//结束当前activity
            }
        });
    }

    /**
     * 初始化表单Fragment
     */
    private PagerTabStrip pagerTabStrip;
    private PagerViewAdapter pagerViewAdapter;

    private void loadFormViewPager() {
        int FIRST_LOAD_PAGE_NUM = 0;//初始页面
        final int PRE_LOAD_PAGE_SUM = 2;//预加载页面数
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_form);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.pager_form_tab_strip);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            FIRST_LOAD_PAGE_NUM = bundle.getInt("timePoint");//初始页面
        }
        pagerTabStrip.setDrawFullUnderline(true);
        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager(), getFromFragments(), 2);
        viewPager.setAdapter(pagerViewAdapter);
        viewPager.setOffscreenPageLimit(PRE_LOAD_PAGE_SUM);//设置预加载的页面数
        viewPager.setCurrentItem(FIRST_LOAD_PAGE_NUM);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //切换tab时更换tab颜色
                switch (position%4) {
                    case 0:
                        pagerTabStrip.setTabIndicatorColorResource(R.color.slide_1);break;
                    case 1:
                        pagerTabStrip.setTabIndicatorColorResource(R.color.slide_2);break;
                    case 2:
                        pagerTabStrip.setTabIndicatorColorResource(R.color.slide_3);break;
                    case 3:
                        pagerTabStrip.setTabIndicatorColorResource(R.color.slide_4);break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化CommitButton
     */
    private List<Boolean> dataList;
    public void initCommitButton() {
        Button commitBtn = (Button) findViewById(R.id.form_commit_btn);
        commitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList = new ArrayList<Boolean>();
                InspectionFormFragment formFragment = (InspectionFormFragment) pagerViewAdapter.getCurrentFragment();
                FormListView inspForm = formFragment.getInspForm();
                for (int i=0; i<18; i++) {
                    View view = inspForm.getChildAt(i);
                    RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.form_radio_group);
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    if (checkedRadioButtonId != -1) {
                        if (checkedRadioButtonId == R.id.form_radio_btn_safe)
                            dataList.add(i, true);
                        else
                            dataList.add(i, false);
                    } else {
                        Toast.makeText(InspectionActivity.this, "填写数据不完整", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(InspectionActivity.this, "数据提交成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 点击返回主页
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断是否点击系统回退键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Bundle data = new Bundle();
            data.putInt("currentPage", 1);

            Intent intent = new Intent();
            intent.setClass(InspectionActivity.this, MainActivity.class);
            intent.putExtras(data);

            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 生成Fragments
     * @return
     */
    private Fragment[] getFromFragments() {
        Fragment[] formFragments = new Fragment[6];
        for (int i=0; i<6; i++) {
            formFragments[i] = new InspectionFormFragment(this);
        }
        return formFragments;
    }
}
