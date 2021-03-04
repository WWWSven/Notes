#include <stdio.h>
/*
- 函数指针：通过指针调用函数，提供函数调用的另外一种方法。
	注：函数在存储时占用一段连续的内存区，函数名就是这片空间的首地址。
		执行函数就是从首地址开始，直到碰到函数的结束语句。
	1，定义一个指针变量，使其指向函数。可以使用这个指针调用它所指向的函数。
		语法：函数返回值类型 (*指针变量名) (形参列表);
		如：int (*p) (int, int);
		注：由于它要指向一个函数，故不需要函数体，不需要具体的形参变量名。
	2，给函数指针赋值。
		int max(int a,int b){...};
		p = max;
	3，通过函数指针调用函数。
		(*p)(a,b); 注：既用(*p)代替max(a,b)中的max。
	注：用相同的函数指针名，调用不同的函数，类似多态。
		对函数指针变量进行运算是没有意义的，这点跟数组指针不同。
	【实例代码】functionPoint()

- 函数指针作为函数参数：把一个函数名当实参传递给被调用函数，可以实现一些复杂的应用。
	【实例代码】functionPointParameter()
- 指针函数：定义一个返回指针值的函数，这是一个充满【危险】的应用。 
	定义一个指针函数：就是把普通函数的返回值换成 指针变量名* 的形式
	【实例代码】pointFunction()
注：函数指针的重点是 指针，指针函数的重点是函数。就像形容词修饰名词，名词是重点。
*/
float triangle(float a,float b) {
	// 求三角形面积
	return a * b / 2.0;
}
float rectangle(float a,float b) {
	// 求矩形面积
	return a * b;
}

// 函数指针
void functionPoint(){
	float a = 2,b = 4;
	float (*area)(float, float);
	// 多态
	area = triangle;
	printf("%f \n", area(a, b));
	area = rectangle;
	printf("%f \n", area(a, b));
}

// 函数指针作为函数参数
void myP(float a, float b, float (*p)(float, float)) {
	printf("%f \n", (*p)(a, b));
}
void functionPointParameter() {
	float a = 2, b = 4;
	myP(a, b, triangle);
	myP(a, b, rectangle);
}

// 指针函数
char* myStrcat(char* a, char* b) {
	// 拼接字符串
	char* pStr = a;
	while (*a != '\0')
		a++;
	while (*b != '\0')
		*a++ = *b++; // 把b的数据赋值给a的同时指针后移
	*a = '\0';
	return pStr;
}
void pointFunction() {
	char fir[80] = "fuck ";
	char sec[80] = "the world!";
	char* result = myStrcat(fir, sec);
	// 【危险】result存储在本函数定义的字符数组中，
	// 返回指针的函数（myStrcat）运行结束后会释放内部定义的所有变量，
	// result占用的空间随时可能被修改，可能会取到修改后的数据。
	puts(result);
}

main() {
	pointFunction();
}

