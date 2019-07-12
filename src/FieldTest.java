import java.lang.reflect.Field;

class FieldTestClass{
    String name;
    int age;
    public FieldTestClass(String name,int age){
        super();
        this.name=name;
        this.age=age;
    }
}
public class FieldTest {
    public static void main(String[] args){
        FieldTestClass obj1 = new FieldTestClass("hello1",100);
        FieldTestClass obj2 = new FieldTestClass("hello2",300);
        System.out.println(compare(obj1,obj2).name+"is bigger");
    }
    private static FieldTestClass compare(FieldTestClass obj1,FieldTestClass obj2){
        try {
            Field field = obj1.getClass().getDeclaredField("age");
            field = FieldTestClass.class.getDeclaredField("age");
            int val1 = (Integer)field.get(obj1);
            int val2 = (Integer)field.get(obj2);
            if (val1>val2){
                return obj1;
            }else {
                return obj2;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
