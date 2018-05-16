package com.yzx.delegate.items;

import com.yzx.delegate.holder.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: yangzhenxiang
 * Time: 2018/5/15
 * Description:   item 个数根据数据源个数确定，但是布局为固定一种
 * E-mail: yangzhenxiang@chelun.com
 */

public abstract class CommonItem<T> extends DelegateItem {

    public List<T> data = new ArrayList<>();

    public CommonItem(int layoutResId) {
        super(layoutResId);
    }

    public CommonItem(int layoutResId, List<T> data) {
        super(layoutResId);
        setData(data);
    }


    @Override
    public int getCount() {
        return data.size();
    }


    public void setData(List<T> data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void addData(List<T> data) {
        if (data != null && data.size() > 0) {
            this.data.addAll(data);
        }
    }

    public List<T> getData() {
        return data;
    }


    @Override
    public void convert(CommonViewHolder holder, int position, int positionAtTotal) {
        convert(holder, position, positionAtTotal, data.get(position));
    }

    protected abstract void convert(CommonViewHolder holder, int position, int positionAtTotal, T t);
}
