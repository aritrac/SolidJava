package test.reflection.verification;

import test.reflection.ConcreteClass;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, InstantiationException{
        // Get Class using reflection
        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();
        try {
            // below method is used most of the times in frameworks like JUnit
            //Spring dependency injection, Tomcat web container
            //Eclipse auto completion of method names, hibernate, Struts2 etc.
            //because ConcreteClass is not available at compile time
            concreteClass = Class.forName("test.reflection.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //GET CLASS OBJECT
        System.out.println(concreteClass.getCanonicalName()); // prints com.journaldev.reflection.ConcreteClass

        //for primitive types, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName()); // prints boolean

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName()); // prints double

        Class<?> cDoubleArray = Class.forName("[D");
        System.out.println(cDoubleArray.getCanonicalName()); //prints double[]

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]

        //GET SUPER CLASS
        Class<?> superClass = Class.forName("test.reflection.ConcreteClass").getSuperclass();
        System.out.println(superClass); // prints "class test.reflection.BaseClass"
        System.out.println(Object.class.getSuperclass()); // prints "null"
        System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"

        //GET PUBLIC MEMBER CLASSES
        Class<?>[] classes = concreteClass.getClasses();
        //[class test.reflection.ConcreteClass$ConcreteClassPublicClass,
        //class test.reflection.ConcreteClass$ConcreteClassPublicEnum,
        //interface test.reflection.ConcreteClass$ConcreteClassPublicInterface,
        //class test.reflection.BaseClass$BaseClassInnerClass,
        //class test.reflection.BaseClass$BaseClassMemberEnum]
        System.out.println(Arrays.toString(classes));

        //GET DECLARED CLASSES
        //getting all of the classes, interfaces, and enums that are explicitly declared in ConcreteClass
        Class<?>[] explicitClasses = Class.forName("test.reflection.ConcreteClass").getDeclaredClasses();
        //prints [class test.reflection.ConcreteClass$ConcreteClassDefaultClass,
        //class test.reflection.ConcreteClass$ConcreteClassDefaultEnum,
        //class test.reflection.ConcreteClass$ConcreteClassPrivateClass,
        //class test.reflection.ConcreteClass$ConcreteClassProtectedClass,
        //class test.reflection.ConcreteClass$ConcreteClassPublicClass,
        //class test.reflection.ConcreteClass$ConcreteClassPublicEnum,
        //interface test.reflection.ConcreteClass$ConcreteClassPublicInterface]
        System.out.println(Arrays.toString(explicitClasses));

        //GET DECLARING CLASS
        Class<?> innerClass = Class.forName("test.reflection.ConcreteClass$ConcreteClassDefaultClass");
        //prints test.reflection.ConcreteClass
        System.out.println(innerClass.getDeclaringClass().getCanonicalName());
        System.out.println(innerClass.getEnclosingClass().getCanonicalName());

        //GETTING PACKAGE NAME
        //prints "test.reflection"
        System.out.println(Class.forName("test.reflection.BaseInterface").getPackage().getName());

        //GETTING CLASS MODIFIERS
        System.out.println(Modifier.toString(concreteClass.getModifiers())); //prints "public"
        //prints "public abstract interface"
        System.out.println(Modifier.toString(Class.forName("test.reflection.BaseInterface").getModifiers()));

        //GET TYPE PARAMETERS
        //Get Type parameters (generics)
        TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
        for(TypeVariable<?> t : typeParameters)
            System.out.print(t.getName()+",");

        //GET IMPLEMENTED INTERFACES
        Type[] interfaces = Class.forName("java.util.HashMap").getGenericInterfaces();
        //prints "[java.util.Map<K, V>, interface java.lang.Cloneable, interface java.io.Serializable]"
        System.out.println(Arrays.toString(interfaces));
        //prints "[interface java.util.Map, interface java.lang.Cloneable, interface java.io.Serializable]"
        System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));

        //GET ALL PUBLIC METHODS
        Method[] publicMethods = Class.forName("test.reflection.ConcreteClass").getMethods();
        //prints public methods of ConcreteClass, BaseClass, Object
        System.out.println(Arrays.toString(publicMethods));

        //GET ALL PUBLIC CONSTRUCTORS
        Constructor<?>[] publicConstructors = Class.forName("test.reflection.ConcreteClass").getConstructors();
        //prints public constructors of ConcreteClass
        System.out.println(Arrays.toString(publicConstructors));

        //GET ALL PUBLIC FIELDS
        Field[] publicFields = Class.forName("test.reflection.ConcreteClass").getFields();
        //prints public fields of ConcreteClass, it's superclass and super interfaces
        System.out.println(Arrays.toString(publicFields));

        //GET ALL ANNOTATIONS
        java.lang.annotation.Annotation[] annotations = Class.forName("test.reflection.ConcreteClass").getAnnotations();
        //prints [@java.lang.Deprecated()]
        System.out.println(Arrays.toString(annotations));

        //GET PUBLIC FIELD
        Field field = Class.forName("test.reflection.ConcreteClass").getField("interfaceInt");
        System.out.println(field.getName());

        //GET FIELD DECLARING CLASS
        field = Class.forName("test.reflection.ConcreteClass").getField("interfaceInt");
        Class<?> fieldClass = field.getDeclaringClass();
        System.out.println(fieldClass.getCanonicalName()); //prints test.reflection.BaseInterface

        //GET FIELD TYPE
        field = Class.forName("test.reflection.ConcreteClass").getField("publicInt");
        Class<?> fieldType = field.getType();
        System.out.println(fieldType.getCanonicalName()); //prints int

        //GET/SET PUBLIC FIELD VALUE
        field = Class.forName("test.reflection.ConcreteClass").getField("publicInt");
        ConcreteClass obj = new ConcreteClass(5);
        System.out.println(field.get(obj)); //prints 5
        field.setInt(obj, 10); //setting field value to 10 in object
        System.out.println(field.get(obj)); //prints 10

        //GET/SET PRIVATE FIELD VALUE
        Field privateField = Class.forName("test.reflection.ConcreteClass").getDeclaredField("privateString");
        //turning off access check with below method call
        privateField.setAccessible(true);
        ConcreteClass objTest = new ConcreteClass(1);
        System.out.println(privateField.get(objTest)); // prints "private string"
        privateField.set(objTest, "private string updated");
        System.out.println(privateField.get(objTest)); //prints "private string updated"

        //GET PUBLIC METHOD
        Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
        //get method parameter types, prints "[class java.lang.Object, class java.lang.Object]"
        System.out.println(Arrays.toString(method.getParameterTypes()));
        //get method return type, return "class java.lang.Object", class reference for void
        System.out.println(method.getReturnType());
        //get method modifiers
        System.out.println(Modifier.toString(method.getModifiers())); //prints "public"

        //INVOKE PUBLIC METHOD
        method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
        Map<String, String> hm = new HashMap<>();
        method.invoke(hm, "key", "value");
        System.out.println(hm); // prints {key=value}

        //INVOKING PRIVATE METHOD
        method = Class.forName("test.reflection.BaseClass").getDeclaredMethod("method3", null);
        method.setAccessible(true);
        method.invoke(null, null); //prints "Method3"

        //GET PUBLIC CONSTRUCTOR
        Constructor<?> constructor = Class.forName("test.reflection.ConcreteClass").getConstructor(int.class);
        //getting constructor parameters
        System.out.println(Arrays.toString(constructor.getParameterTypes())); // prints "[int]"

        Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
        System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes())); // prints "[]"

        //INSTANTIATE OBJECT USING CONSTRUCTOR
        constructor = Class.forName("test.reflection.ConcreteClass").getConstructor(int.class);
        //getting constructor parameters
        System.out.println(Arrays.toString(constructor.getParameterTypes())); // prints "[int]"

        Object myObj = constructor.newInstance(10);
        Method myObjMethod = myObj.getClass().getMethod("method1", null);
        myObjMethod.invoke(myObj, null); //prints "Method1 impl."

        hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
        System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes())); // prints "[]"
        HashMap<String,String> myMap = (HashMap<String,String>) hashMapConstructor.newInstance(null);
    }
}
