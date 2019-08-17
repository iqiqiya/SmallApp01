/**
 * Title: 模拟相册
 * Author: iqiqiya
 * Blog: blog.77sec.cn
 * GitHub: github.com/iqiqiya
 */
package com.iqiqiya.smallapp01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImage;
    private TextView mText;
    private int num;
    private int index;
    private int[] images;
    private String[] title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化界面控件
        initView();
        //初始化数据
        initData();
    }
    private void initView(){
        mImage = findViewById(R.id.iv_show);
        mText = findViewById(R.id.tv_show);
        findViewById(R.id.btn_previous).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);
    }

    private void initData(){
        title = new String[]{"第一张图片","第二张图片","第三张图片","第四张图片"};
        images = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};

        mImage.setImageResource(images[0]);
        mText.setText(title[0]);

        num = title.length;//图片总数目
        //当前图片索引 默认加载第一张图片
        index = 0;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_previous:
                //上一张
                if (index == 0){
                    index = num - 1;
                } else{
                    index = 0;
                }
                break;
            case R.id.btn_next:
                //下一张
                if (index == 3){
                    index = 0;
                } else {
                    index++;
                }
                break;
        }
        updateImageAndTitle();//根据当前索引设置图片和标题
    }
    private void updateImageAndTitle(){
        mImage.setImageResource(images[index]);
        mText.setText(title[index]);
    }
}
