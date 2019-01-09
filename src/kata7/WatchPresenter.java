package kata7;

import java.awt.Point;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class WatchPresenter implements WatchModel.Observer {
    private final WatchModel watchModel;
    private final WatchView watchView;

    public WatchPresenter(WatchModel watchModel, WatchView watchView) {
        this.watchModel = watchModel;
        this.watchModel.add(this);
        this.watchView = watchView;
    }
    
    @Override
    public void update() {
        refresh();
    }

    private void refresh() {
        watchView.paint(pointsOf(watchModel));
    }
    
    private Point[] pointsOf(WatchModel watchModel){
        Point[] points = new Point[3];
        points[0] = pointOf(watchModel.getHour(), 90);
        points[1] = pointOf(watchModel.getMinute(), 150);
        points[2] = pointOf(watchModel.getSecond(), 180);
        return points;
    }

    private Point pointOf(double angle, int length) {
        return new Point(toInt(length*cos(angle)), toInt(length*sin(angle)));
    }
    
    private int toInt(double value){
        return (int) value;
    }
}