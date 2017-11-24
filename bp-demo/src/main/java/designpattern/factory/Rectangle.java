package designpattern.factory;

/**
 * 矩形
 * Created by Administrator on 2017-11-24.
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}
