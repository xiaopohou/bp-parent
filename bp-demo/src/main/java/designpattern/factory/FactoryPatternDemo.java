package designpattern.factory;

/**
 * Created by Administrator on 2017-11-24.
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {

        ShapeFactory shapeFactory=new ShapeFactory();

        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        Shape square = shapeFactory.getShape("square");
        square.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();


        Object shapeUp = shapeFactory.getShapeUp(Circle.class);
        Circle circle1=(Circle)shapeUp;
        circle1.draw();

    }
}
