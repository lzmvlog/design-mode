package top.shaojie.factory.simple;

/**
 * @author： ShaoJie
 * @data： 2020年02月06日 21:00
 * @Description： 主测试
 */
public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();
    }
}
