package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This is the class to test the method of reflect
 */
public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // *******************************************
        // Get the Class object
        // 1. Get the class object by Object's getClass() method
        Test test = new Test();
        Class classOne = test.getClass();
        // 2. Get the class object by any Object's class attribute
        Class classTwo = Test.class;
        // 3. Get the class object by Class's forName() method
        Class classThree = Class.forName("reflect.Test");

        // *******************************************
        // Get the constructor of class
        Class testConstructor = Class.forName("reflect.Test");
        // 1. Get all public constructors
        Constructor[] publicConstructors = testConstructor.getConstructors();
        // 2. Get all constructor
        Constructor[] allConstructors = testConstructor.getDeclaredConstructors();
        // 3. Get the constructor without parameter
        Constructor constructorWithoutParam = testConstructor.getConstructor(null);
        Object object = constructorWithoutParam.newInstance();
        Test testClass = (Test) object;

        // *******************************************
        // Get the field of class
        Class testField = Class.forName("reflect.Test");
        // 1. Get all public fields
        Field[] publicFields = testField.getFields();
        // 2. Get all fields
        Field[] allFields = testField.getDeclaredFields();
        // 3. Get public field
        Field publicField = testField.getField("address");
        // 4. Get all type field
        Field allTypeField = testField.getDeclaredField("name");
        allTypeField.setAccessible(true);

        // *******************************************
        // Get the method of class
        Class testMethod = Class.forName("reflect.Test");
        // 1. Get all public methods
        Method[] publicMethods = testMethod.getMethods();
        // 2. Get all methods
        Method[] allMethods = testMethod.getDeclaredMethods();
        // 3. Get public method
        Method publicMethod = testMethod.getMethod("test1", String.class);
        // 4. Get all type method
        Method allTypeMethod = testMethod.getDeclaredMethod("test2", String.class);
        allTypeMethod.setAccessible(true);
        Object testObj = testMethod.newInstance();
        allTypeMethod.invoke(testObj, "test", "test");
    }
}

class Test {
    private String name;
    public String address;

    public Test() {
        System.out.println("public constructor without parameter");
    }

    public void test1(String name) {
        System.out.println(name);
    }

    private void test2(String name1, String name2) {
        System.out.println(name);
    }
}
