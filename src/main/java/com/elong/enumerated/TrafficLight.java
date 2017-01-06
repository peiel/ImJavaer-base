package com.elong.enumerated;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class TrafficLight {
    Signal color = Signal.GREEN;

    public void change(){
        switch (color){
            case GREEN: color = Signal.RED;
                break;
            case RED: color = Signal.YELLOW;
                break;
            case YELLOW: color = Signal.GREEN;
                break;
        }
    }

    @Override
    public String toString() {
        return "当前颜色是 : " + color;
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        for (int i = 0; i < 10; i++) {
            System.out.println(trafficLight);
            trafficLight.change();
        }
    }


}

enum Signal{
    GREEN, RED, YELLOW
}


