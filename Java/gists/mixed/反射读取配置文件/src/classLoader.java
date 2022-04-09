import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.Properties;

class classLoader {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = classLoader.class.getClassLoader();
        URL resource = classLoader.getResource(".");
        File file = new File(resource.getPath(), "prop.properties");
        if (!file.exists()){
            file.createNewFile();
            properties.setProperty("1","a");
            properties.setProperty("2","b");
            properties.store(new FileWriter(file),null);
        }
        URL resource1 = classLoader.getResource(file.getName());
        FileReader fileReader = new FileReader(resource1.getPath());
        properties.load(fileReader);
        properties.list(System.out);
    }
}