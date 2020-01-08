package com.bawei.lqy.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lqy.R;
import com.bawei.lqy.model.bean.CartBean;
import com.bawei.lqy.utile.NetUtile;
import com.bawei.lqy.view.widget.AddSubView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Time:2020/1/7 0007上午 09:10202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class CartAdapter extends BaseExpandableListAdapter {


    private List<CartBean.ResultBean> result;

    public CartAdapter(List<CartBean.ResultBean> result) {

        this.result = result;
    }

    @Override
    public int getGroupCount() {
        return result.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return result.get(i).getShoppingCartList().size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    // TODO: 2020/1/7 0007 父控件
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        GroupHolder groupHolder;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.item_group, null);
            groupHolder = new GroupHolder(view);
            view.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) view.getTag();
        }
        CartBean.ResultBean resultBean = result.get(i);
        String categoryName = resultBean.getCategoryName();
        groupHolder.itName.setText(categoryName);

        // TODO: 2020/1/7 0007 拿到商品列表 
        List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        // TODO: 2020/1/7 0007 假设商家的checkbox为true 
        boolean groupChecked=true;
        // TODO: 2020/1/7 0007 循环商品列表 
        for (int j = 0; j < shoppingCartList.size(); j++) {
            // TODO: 2020/1/7 0007 获取对应商品
            CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
            // TODO: 2020/1/7 0007 判断商品状态
            if(shoppingCartListBean.isChecked()==false){
                // TODO: 2020/1/7 0007 只要有一个为false
                groupChecked=false;
                break;
            }
        }
        // TODO: 2020/1/7 0007 设置商家选中状态
        groupHolder.itBox.setChecked(groupChecked);
        // TODO: 2020/1/7 0007 点击事件
        boolean finalGroupChecked = groupChecked;
        groupHolder.itBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2020/1/7 0007 获取商家状态
                boolean currentgroupChecked= finalGroupChecked;
                currentgroupChecked=!currentgroupChecked;
                // TODO: 2020/1/7 0007 把所有商品设置为商家取反后的状态 
                for (int j = 0; j < shoppingCartList.size(); j++) {
                    shoppingCartList.get(j).setChecked(currentgroupChecked);
                }
                // TODO: 2020/1/7 0007 刷新适配器
                notifyDataSetChanged();
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick();
                }
            }
        });
        return view;
    }

    // TODO: 2020/1/7 0007 子控件
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildHolder childHolder;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.item_child, null);
            childHolder = new ChildHolder(view);
            view.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) view.getTag();
        }
        CartBean.ResultBean.ShoppingCartListBean listBean = result.get(i).getShoppingCartList().get(i1);
        String commodityName = listBean.getCommodityName();
        int price = listBean.getPrice();
        childHolder.itName.setText(commodityName);
        childHolder.itPrice.setText("$" + price);
        NetUtile.getInstance().getPhoto(listBean.getPic(), childHolder.itImg);
        // TODO: 2020/1/8 0008 给加减器绑定数据
        childHolder.addSubView.setNum(listBean.getCount());
        // TODO: 2020/1/8 0008 给加减器设置改变监听
        childHolder.addSubView.setOnAddSubClickListener(new AddSubView.onAddSubClickListener() {
            @Override
            public void onAddSubClick(int num) {
                // TODO: 2020/1/8 0008 讲商品传给bean类，刷新适配器，通知外部重新计算总价
                listBean.setCount(num);
                notifyDataSetChanged();
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick();
                }
            }
        });
        // TODO: 2020/1/7 0007 商品checkbox绑定数据
        childHolder.itBox.setChecked(listBean.isChecked);
        childHolder.itBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listBean.setChecked(!listBean.isChecked());
                notifyDataSetChanged();
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick();
                }
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    static
    class GroupHolder {
        @BindView(R.id.it_name)
        TextView itName;
        @BindView(R.id.it_box)
        CheckBox itBox;
        GroupHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static
    class ChildHolder {
        @BindView(R.id.it_img)
        ImageView itImg;
        @BindView(R.id.it_name)
        TextView itName;
        @BindView(R.id.it_price)
        TextView itPrice;
        @BindView(R.id.it_box)
        CheckBox itBox;
        @BindView(R.id.add_sub_view)
        AddSubView addSubView;
        ChildHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public float calculateTotalPrice() {
        float totalPrice = 0;
        for (int i = 0; i < result.size(); i++) {
            CartBean.ResultBean resultBean = result.get(i);
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                if (shoppingCartList.get(j).isChecked) {
                    int price = shoppingCartList.get(j).getPrice();
                    int count = shoppingCartList.get(j).getCount();
                    totalPrice+=price*count;
                }
            }
        }
        return totalPrice;
    }

    public int calculateTotalNumber() {
        int totalnumber = 0;
        for (int i = 0; i < result.size(); i++) {
            CartBean.ResultBean resultBean = result.get(i);
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                if (shoppingCartList.get(j).isChecked) {
                    int count = shoppingCartList.get(j).getCount();
                    totalnumber += count;
                }
            }
        }
        return totalnumber;
    }
    public boolean calculateAllIsChecked() {
        boolean isAllChecked = true;
        for (int i = 0; i < result.size(); i++) {
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = result.get(i).getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if (shoppingCartListBean.isChecked()==false) {
                    isAllChecked=false;
                }
                notifyDataSetChanged();
            }
        }
        return isAllChecked;
    }

    public void calculateisAllChecked(boolean b){
        for (int i = 0; i < result.size(); i++) {
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = result.get(i).getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                shoppingCartListBean.setChecked(b);
            }
        }
    }
    onItemClickListener onItemClickListener;

    public void setOnItemClickListener(CartAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onItemClick();
    }
}
