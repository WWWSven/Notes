class MyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        System.out.println(systemClassLoader.getParent());
        System.out.println(systemClassLoader.getParent().getParent());
        System.out.println(Class.forName("java.lang.Object").getClassLoader());
        System.out.println(System.getProperty("java.class.path"));
    }
}