package com.admin.claire.gmaillikeinbox_using_recyclerview.adapter;

/**
 * Created by claire on 2017/9/20.
 */

public interface MessageAdapterListener {
    void onIconClicked(int position);

    void onIconImportantClicked(int position);

    void onMessageRowClicked(int position);

    void onRowLongClicked(int position);
}
