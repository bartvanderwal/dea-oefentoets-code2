package nl.han.dea;

import java.util.List;

public class Operator {
    
    String operation;

    public int execute(int x, int y) {
         switch(operation) {
             case "Add":
                 return x + y;
             case "Subtract":
                 return x - y;
             case "Multiply":
                 return x * y;
             case "Divide":
                 return x / y;
             default:
                 throw new InvalidOperationException("Unsupported operation");
    	}
    }

    public void writeAll(List<Integer> xs) {
        for(var x:xs) {
            System.out.println(x);
        }
    }

    public void writeAll1(List<Integer> xs) {
        xs.stream().forEach(x -> System.out.println(x));
    }

    public void writeAll2(List<Integer> xs) {
        xs.stream().forEach((x) -> System.out.println(x));
    }

    public void writeAll3(List<Integer> xs) {
        // xs.stream().forEach(() -> System.out.println());
    }

    public void writeAll4(List<Integer> xs) {
        xs.stream().forEach(System.out::println);
    }

    public void writeAll5(List<Integer> xs) {
        xs.stream().forEach(x -> { System.out.println(x); });
    }

}
