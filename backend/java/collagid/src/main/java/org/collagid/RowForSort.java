package org.collagid;

import java.util.Comparator;
import java.util.TreeSet;

public class RowForSort implements Comparator<RowForSort> {
    int val;

    public RowForSort(int i) {
        this.val = i;
    }

    @Override
    public String toString() {
        return "" + val;
    }

    @Override
    public int compareTo(RowForSort o) {
        if (val == o.val) {
            return 0;
        }else if (val > o.val) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        TreeSet<RowForSort> set = new TreeSet<>();
        set.add(new RowForSort(10));
        set.add(new RowForSort(3));
        set.add(new RowForSort(5));
        set.add(new RowForSort(6));
        set.add(new RowForSort(49));
        set.forEach(System.out::println);
    }
}
