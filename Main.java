import functions.*;

public class Main {
    public static void main(String[] args) {
        //f(x) = x^2 на интервале [0, 4]
        double[] values = {1, 3, 4, 9, 16};
        TabulatedFunction function = new TabulatedFunction(0, 4, values);
        
        System.out.println("Исходная функция:");
        printFunctionInfo(function);
        
        
        System.out.println("\nЗначения функции в различных точках:");
        testFuncVal(function);
        
        
        System.out.println("\nПосле изменения точек:");
        test(function);
        
        
        System.out.println("\nПосле добавления и удаления точек:");
        testAddDel(function);
    }
    
    private static void printFunctionInfo(TabulatedFunction function) {
        System.out.printf("Область определения: [%.1f, %.1f]\n", 
            function.getLeftDomainBorder(), function.getRightDomainBorder());
        System.out.println("Количество точек: " + function.getPointsCount());
        
        for (int i = 0; i < function.getPointsCount(); i++) {
            FunctionPoint point = function.getPoint(i);
            System.out.printf("Точка %d: (%.1f, %.1f)\n", i, point.getX(), point.getY());
        }
    }
    
    private static void testFuncVal(TabulatedFunction function) {
             double x = 3.3;
        double y = function.getFunctionValue(x);
        System.out.println("Значение функции X = " + x + " Y = " + y);
    }
    
    private static void test(TabulatedFunction function) {
        
        function.setPointY(3, 8);
        System.out.println("После изменения y в точке 3 на 8.0:");
        printFunctionInfo(function);
        
        
        function.setPointX(3, 3.5);
        System.out.println("После изменения x в точке 3 на 3.5:");
        printFunctionInfo(function);
    }
    
    private static void testAddDel(TabulatedFunction function) {
        
        function.addPoint(new FunctionPoint(3, 5));
        System.out.println("После добавления точки (3, 5):");
        printFunctionInfo(function);
        
    
        function.deletePoint(3);
        System.out.println("После удаления точки с индексом 3:");
        printFunctionInfo(function);
    }
}