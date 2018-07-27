package com.jbh.lib.adapter;

import com.jbh.lib.model.City;

public interface OnPickListener {
    void onPick(int position, City data);
    void onLocate();
}
