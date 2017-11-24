package designpattern.factory;

/**
 * 正方形
 * Created by Administrator on 2017-11-24.
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("正方形");
    }
}
