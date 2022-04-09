package day06;

class Star {
    /**
     * 定义一个Star(明星),明星有名字属性,自己手动重写Star的toString 和equals方法
     * 	在测试类中创建两个Star类的对象.判断一下两个对象是否相等.
     */
    public String name;

    public Star(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (!(obj instanceof Star)) return false;
        return this.name.equals(((Star) obj).name);
    }

    @Override
    public String toString() {
        return "名字:"+this.name;
    }
}
class test{
    public static void main(String[] args) {
        Star w = new Star("魏家然");
        Star wT = new Star("魏家然");
        Star l = new Star("李荣浩");
        System.out.println(w.equals(l) ? "相等" : "不相等");
        System.out.println(w.equals(wT) ? "相等" : "不相等");
        System.out.println(w);
        System.out.println(l);
    }
}
