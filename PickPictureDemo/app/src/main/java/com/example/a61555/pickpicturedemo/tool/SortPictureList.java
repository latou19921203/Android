package com.example.a61555.pickpicturedemo.tool;

import java.io.File;
import java.util.Comparator;

/**
 * Created by 61555 on 2017/12/13.
 */

class SortPictureList implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        String path1 = o.toString();
        String path2 = t1.toString();
        File file1 = new File(path1);
        File file2 = new File(path2);
        if (file1.lastModified() < file2.lastModified()) {
            return 1;
        } else return -1;
    }
}