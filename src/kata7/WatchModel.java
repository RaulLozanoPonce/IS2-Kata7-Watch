package kata7;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class WatchModel {
    private static final double secondStep = Math.PI * 2 /60;
    private static final double minuteStep = secondStep /60;
    private static final double hourStep = minuteStep /12;
    private final List<Observer> observers = new ArrayList<>();
    private double second = (Math.PI / 2) - (LocalTime.now().getSecond() * secondStep);
    private double minute = (Math.PI / 2) - (LocalTime.now().getMinute() * secondStep);
    private double hour = (Math.PI / 2) - (LocalTime.now().getHour() * secondStep * 5);
    
    public WatchModel(){
        Timer timer = new Timer();
        timer.schedule(timerTask(), 0, 1000);
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step();
                updateObservers();
            }
        };
    }
    
    public double getSecond() {
        return second;
    }
    
    public double getMinute() {
        return minute;
    }

    public double getHour() {
        return hour;
    }
    
    private void step() {
        second = normalize(second - secondStep);
        minute = normalize(minute - minuteStep);
        hour = normalize(hour - hourStep);
    }
    
    private double normalize(double angle) {
        return (angle + 2 * Math.PI) % (2 * Math.PI);
    }
    
    public interface Observer {
        public void update();
    }
    
    public void add(Observer observer){
        observers.add(observer);
    }
    
    private void updateObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}