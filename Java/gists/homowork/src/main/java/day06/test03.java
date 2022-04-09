package day06;

class runTest03 {
    /**
     * 1、按照要求完成以下内容：
     * 	（1）创建Animal（动物）抽象类，包含：
     * 					成员属性：姓名（name），String类型。
     * 					有参无返回值的抽象方法：void speak (String str)。
     * 	（2）创建Sports（运动）接口，包含：
     * 				  无参无返回值的抽象方法：void swimming ()。
     * 	（3）创建Dog（狗）类，要求：
     * 				继承Animal（动物）类，实现speak方法，在方法内打印“X说：Y”，其中X为狗的名字，Y为当前方法的参数。
     *             完成满参构造。
     *             实现Sports接口，实现swimming方法，在方法内打印：XXX狗刨中！其中，X为狗的名字。
     *             创建成员方法：goPlay()，在方法内依次调用speak(String str)方法和swimming ()方法。其中speak方法的参数自行创建。
     * 	（4）创建测试类，在测试类的main方法中完成：
     * 				通过满参构造创建一个姓名为“旺财”Dog类对象。
     * 				调用这个对象的goPlay()方法。
     * 		程序运行后的打印示例如图：
     */
    public static void main(String[] args) {
        Dog dog = new Dog("旺财");
        dog.goPlay();
    }
}
abstract class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void speak(String str);
}
interface Sports{
    public abstract void swimming();
}
class Dog extends Animal implements Sports{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak(String str) {
        System.out.printf("%s说：%s",getName(),str);
    }

    @Override
    public void swimming() {
        System.out.printf("%s狗刨中！",getName());
    }

    public void goPlay(){
        speak("日密码，退钱！");
        swimming();
    }
}