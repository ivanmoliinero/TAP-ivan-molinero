package solutionsIvanMolinero;

import dynamic.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynamicProxyIvan implements InvocationHandler {
    private Object target = null;
    public static Object newInstance(Object target){
        Class targetClass = target.getClass();
        Class interfaces[] = targetClass.getInterfaces();
        return Proxy. newProxyInstance(targetClass.getClassLoader(),
                interfaces, new DynamicProxyIvan(target));
    }
    private DynamicProxyIvan(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object invocationResult = null;
        try
        {
            System.out.println("Method name: " + method.getName());
            System.out.println("Parameters: ");
            Arrays.stream(args).forEach(System.out::println);
            invocationResult = method.invoke(this.target, args);
            Bonus bon = (Bonus) EmpBusinessLogic.class.getAnnotation(Bonus.class);
            invocationResult = (Object)((Double)invocationResult + bon.bonus());
        }
        catch(InvocationTargetException ite)
        {
            throw ite.getTargetException();
        }
        catch(Exception e)
        {
            System.err.println("Invocation of " + method.getName() + " failed");
        }
        finally{
            return invocationResult;
        }
    }

}
