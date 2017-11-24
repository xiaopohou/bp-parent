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


    //使用反射机制可以解决每次增加一个产品时，都需要增加一个对象实现工厂的缺点
    public Object getShapeUp(Class<? extends Shape> clazz){
        Object obj=null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
