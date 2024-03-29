package com.jiayu.commonbase.widget.flow;

public class FlowChildPosition {

    public int left;
    public int top;
    public int right;
    public int bottom;

    public FlowChildPosition() {
    }

    public FlowChildPosition(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public String toString() {
        return "FlowChildPosition{" +
                "left=" + left +
                ", top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                '}';
    }
}
