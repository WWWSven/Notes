// 4行，BufferedReader没有接收File对象的构造，改为new BufferedReader(new FileReader("stu.txt"));
// 9行，br.read()返回的是int，此处应该为br.readLine();
// 21行，return的值错误，应该改为o2.getScore()-o1.getScore();
// 25行，bw没有开启append模式，应该为new BufferedWriter(new FileWriter("stu.txt", true));
// 32行，8192大小的缓冲器被写入文件了list.size()次，应把flush操作移到for循环体外
