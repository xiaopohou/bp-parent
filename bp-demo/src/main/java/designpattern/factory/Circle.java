package designpattern.factory;

/**
 * 圆形
 * Created by Administrator on 2017-11-24.
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("圆形");
    }
}
