package designpattern.factory;

/**
 * 工厂
 * Created by Administrator on 2017-11-24.
 */
public class ShapeFactory {

    public Shape getShape(String shapeType){

        if(shapeType.equals("circle")){
            return new Circle();
        }else if(shapeType.equals("square")){
            return new Square();
        }else if(shapeType.equals("rectangle")){
            return new Rectangle();
        }
        return null;
    }

}
