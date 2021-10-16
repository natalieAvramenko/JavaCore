package lesson3;

public class Box {
    private Object obj;

    @Override
    public String toString() {
        return "Box{" +
                "object=" + obj +
                '}';
    }

    public Box(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        Box box1 = new Box(5);
        Box box2 = new Box(10);

        System.out.println(box1.getObj().getClass());

        int sum = (Integer) box1.getObj() + (Integer) box2.getObj();
        System.out.println(sum);

        Box box3 = new Box("Test");

        if (box1.getObj() instanceof Integer && box3.getObj() instanceof Integer) {
            int sum2 = (Integer) box1.getObj() + (Integer) box3.getObj();
        }
    }
}

