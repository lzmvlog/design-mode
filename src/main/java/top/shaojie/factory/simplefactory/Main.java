package top.shaojie.factory.simplefactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月06日 21:00
 * @Description： 主测试 简单工厂
 *      这样的扩展性不好 当需要添加这个图形时 就要修改 ShapeFactory 中的内容
 *      所以现在为 单独的图形创建一个工厂
 */
public class Main {

    public static void main(String[] args) {
//        ShapeFactory shapeFactory = new ShapeFactory();
//        Shape circle = shapeFactory.getShape("CIRCLE");
//        circle.draw();
//        Shape square = shapeFactory.getShape("SQUARE");
//        square.draw();
        Pattern circle = new CircleFactory().drowCircle();
        circle.draw();
        Pattern square = new SquareFactory().drowSquare();
        square.draw();
    }
}
