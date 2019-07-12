import java.lang.reflect.Method;

class MethodTestClass{
    public void m1(){
        System.out.println("m1 is called ...");
    }
    public void m2(){
        System.out.println("m2 is called ...");
    }
}
public class CallMethodTest {
    public static void main(String[] args){
        args = new String[]{"m2"};
        String methodName = args[0];
        if (methodName!=null){
            Class<MethodTestClass> clazz = MethodTestClass.class;
            try {
                Method m = clazz.getDeclaredMethod(methodName);
                if (m!=null){
                    MethodTestClass obj = clazz.newInstance();
                    m.invoke(obj);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
