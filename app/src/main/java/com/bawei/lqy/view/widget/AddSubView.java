package com.bawei.lqy.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.lqy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Time:2020/1/8 0008下午 02:15202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class AddSubView extends LinearLayout {
    @BindView(R.id.it_sub)
    TextView it_Sub;
    @BindView(R.id.it_num)
    TextView it_Num;
    @BindView(R.id.it_add)
    TextView it_Add;

    public AddSubView(Context context) {
        super(context);
    }

    public AddSubView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.add_sub_item, this);
        ButterKnife.bind(this);
    }

    private int num=1;
    @OnClick({R.id.it_sub, R.id.it_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.it_sub:
                if(num>1){
                    num--;
                    it_Num.setText(num+"");
                    if (onAddSubClickListener != null) {
                        onAddSubClickListener.onAddSubClick(num);
                    }
                }
                break;
            case R.id.it_add:
                num++;
                it_Num.setText(num+"");
                if (onAddSubClickListener != null) {
                    onAddSubClickListener.onAddSubClick(num);
                }
                break;
        }
    }

    public void setNum(int num) {
        this.num = num;
        it_Num.setText(num+"");
    }

    onAddSubClickListener onAddSubClickListener;

    public void setOnAddSubClickListener(AddSubView.onAddSubClickListener onAddSubClickListener) {
        this.onAddSubClickListener = onAddSubClickListener;
    }

    public interface onAddSubClickListener{
        void onAddSubClick(int num);
    }
}
