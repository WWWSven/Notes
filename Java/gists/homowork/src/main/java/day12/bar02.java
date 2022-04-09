package day12;

import java.io.*;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class bar02 {
    /**
     * 统计斗破苍穹小说里面每个字符出现的次数, 求出现最多的字符是哪个字符
     */
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        File file = new File("D:\\itheima2\\day12_io\\代码\\day12_io\\斗破苍穹.txt");
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)
        ){
            char[] buffer = new char[1024*8];
            int len;
            while ((len=inputStreamReader.read(buffer))!=-1){
                for (int i = 0; i < len; i++) {
                    if (map.containsKey(String.valueOf(buffer[i]))){
                        map.put(String.valueOf(buffer[i]), map.get(String.valueOf(buffer[i]))+1);
                    }else {
                        map.put(String.valueOf(buffer[i]),1);
                    }
                }
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Map.Entry<String, Integer> entry = entries.stream().max(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        }).get();
        System.out.println(entry.getKey()+":"+entry.getValue());
    }
}
