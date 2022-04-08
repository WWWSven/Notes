interface IUserDao {
    public void save();
}

class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
class UserDaoProxy implements IUserDao{
    private IUserDao target;
    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }
    @Override
    public void save() {
        System.out.println("开启事务");//扩展了额外功能
        target.save();
        System.out.println("提交事务");
    }
}
class StaticUserProxy {
    public void testStaticProxy(){
        //目标对象
        IUserDao target = new UserDao();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
class run{
    public static void main(String[] args) {
        new StaticUserProxy().testStaticProxy();
    }
}