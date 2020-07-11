// 字节2020最大区间个数

public class Interval {
    int start;
    int end;
    Interval(int a, int b) {
        start = a;
        end = b;
    }
}

class Point implement Comparable<Point> {
    int value;
    int type;
    Point(int v, int t) {
        value = v;
        type = t;
    }
    public int compareTo(Point p) {
        if(this.value == p.value) return 0;
        else if(this.value > p.value)
        else return -1;
    }
}

class Solution {
    int getOverlappingCount(Interval[] A) {
        int max=0, count = 1;
        Point[] points = new Point[A.length*2];
        for(int i=0; i<A.length; i++) {
            points[2*i] = new Point(A[i].start, 0);
            points[2*i+1] = new Point(A[i].end, 1);
        }
        Collections.sort(points);
        for(int i=0; i<points.length; i++) {
            if(points[i].type == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        return max;
    }
}
