package com.demo.annotation;

/**
 * Created by wisdom on 15-12-11.
 */
class Base
{
    //成员变量，子类也有同样的成员变量名
    public String test="Base Field";
    //静态方法，子类也有同样签名的静态方法
    public static void staticMethod()
    {
        System.out.println("Base staticMethod()");
    }
    //子类将对此方法进行覆盖
    public void notStaticMethod()
    {
        System.out.println("Base notStaticMethod()");
    }
    public int notStaticMethod(String a){

        System.out.println("Base overload notStaticMethod()");
        return 1;
    }

}
public class Polymorphic extends Base
{
    public String test="Derive Field";
    public static void staticMethod()
    {
        System.out.println("Derive staticMethod()");
    }
    @Override
    public void notStaticMethod()
    {
        System.out.println("Derive notStaticMethod()");
    }

    @Override
    public int notStaticMethod(String a) {
        System.out.println("Derive overload notStaticMethod()");
        return 1;
    }

    public void moreMethod(){
        System.out.println("more method");
    }

    //输出成员变量的值，验证其为前期绑定。
    public static void testFieldBind(Base base)
    {
        System.out.println(base.test);
    }
    //静态方法，验证其为前期绑定。
    public static void testStaticMethodBind(Base base)
    {
        //The static method test() from the type Base should be accessed in a static way
        //使用Base.test()更加合理，这里为了更为直观的展示前期绑定才使用这种表示。
        base.staticMethod();
    }
    //调用非静态方法，验证其为后期绑定。
    public static void testNotStaticMethodBind(Base base)
    {
        base.notStaticMethod("sdd");
    }
    public static void main(String[] args)
    {
        Polymorphic d=new Polymorphic();
        testFieldBind(d);
        testStaticMethodBind(d);
        testNotStaticMethodBind(d);

//        Base poly=new Polymorphic();
//        Polymorphic polymorphic=(Polymorphic)poly;
//        polymorphic.moreMethod();
        Base poly=new Base();

        Polymorphic polymorphic=(Polymorphic)poly;
         polymorphic.moreMethod();
        Base p1=new Polymorphic();
        p1.notStaticMethod();

    }
}
