package com.jbh.lib.adapter;

import com.jbh.lib.model.City;

public interface InnerListener {
    void dismiss(int position, City data);
    void locate();
}
