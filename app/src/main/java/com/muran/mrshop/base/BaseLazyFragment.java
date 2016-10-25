package com.muran.mrshop.base;

/**
 * Created by Administrator on 2016/9/6.
 */
public  abstract class BaseLazyFragment extends BaseFragment {
    //是否可见
    protected boolean isVisible;
    // 标志位，标志Fragment已经初始化完成。
    public boolean isPrepared = false;

    /**
     * 实现Fragment数据的缓加载
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisiable();
        } else {
            isVisible = false;
            onInVisiable();
        }
    }
    protected void onInVisiable() {
    }
    protected void onVisiable() {
        //加载数据
        loadData();
    }
    protected abstract void loadData();
}
