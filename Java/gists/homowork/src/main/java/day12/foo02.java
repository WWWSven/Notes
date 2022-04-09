package day12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class foo02 {
    public static void main(String[] args) throws Exception{
        File students = new File("D:\\itheima2\\day12_io\\作业\\1.txt");
        try (
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(students), StandardCharsets.UTF_8)
            );
        ){
            String[][] result = new String[4][2];
            String[][] arr = new String[4][2];//name,19 name,18
            String oneLine;
            int i = 0;
            while ((oneLine=bufferedReader.readLine())!=null){
                String[] split = oneLine.split(",");
                arr[i++] = split;
            }
            Arrays.stream(arr).forEach(e-> System.out.println(Arrays.toString(e)));
            int[] age = new int[4]; // 18,19
            for (int i1 = 0; i1 < age.length; i1++) {
                age[i1] = Integer.parseInt(arr[i1][1]);
            }
            Arrays.sort(age);
            for (int i1 = 0; i1 < age.length; i1++) {
                for (int i2 = 0; i2 < arr.length; i2++) {
                    if (Integer.parseInt(arr[i2][1])==age[i1]){
                        result[i1] = arr[i2];
                    }
                }
            }
            try (
                BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(students), StandardCharsets.UTF_8)
                );
            ){
                for (String[] strings : result) {
                    System.out.println(strings[0]+","+strings[1]);
                    bufferedWriter.write(strings[0]+","+strings[1]);
                    bufferedWriter.newLine();
                }
            }
        }
    }
}
class method02{
    public static void main(String[] args) throws Exception {
        File students = new File("D:\\itheima2\\day12_io\\作业\\1.txt");
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(students), StandardCharsets.UTF_8)
                );
        ){
            String[][] arr = new String[4][2];
            String oneLine;
            int i = 0;
            while ((oneLine=bufferedReader.readLine())!=null){
                String[] split = oneLine.split(",");
                arr[i++] = split;
            }
            /*
            [
                [李四,11],
                [...,...]...
            ]
             */
            List<String[]> list = Arrays.stream(arr).sorted(new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
            }).collect(Collectors.toList());
            list.stream().forEach(e-> System.out.println(Arrays.toString(e)));
        }
    }
}
