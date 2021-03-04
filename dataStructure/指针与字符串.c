#include <stdio.h>

/*
- c 中字符串如何存储。
	1，以字符数组的形式存储，自动在末尾添加 \0 作为字符串结束标记。
	2，【实例代码】arrayString() pointString() diffBoth()
- 字符串指针作为函数参数时的处理机制。
	1，【实例代码】copyTest()
- 字符指针数组的使用。
	1，一个[2行4列]的数组，在二维数组里跟指针数组的不同。(n* == null)
		+---二维数组---+
		|00 01 02 03   |    要按最长的字符串定义数组大小
		|10 11 n* n*   |	浪费空间
		+--------------+
		+---指针数组---+
		|00 01 02 03 \0|    字符串有多长就分配多长的空间
		|10 11 \0      |    节省空间
		+--------------+
	2，【实例代码】sort()看不懂
- main 函数形参的规定和使用。
	1, 【实例代码】
*/

// ----------------------------------------------------------------------------------------
// 使用数组【存储】字符串。
void arrayString() {
	char s[] = "this is a string";
	int i = 0, total = 0;
	while (s[i] != '\0') {
		if (s[i] == 't') total++;
		i++;
	}
	printf("t的个数为：%d", total);
}
// 使用指针【指向】字符串
void pointString() {
	char* s = "this is a string";
	int i = 0, total = 0;
	while (*(s + i) != '\0') {
		if (*(s + i) == 't')  total++;
		i++;
	}
	printf("t的个数为：%d", total);
}
// 比较数组存储和指针指向的区别
void diffBoth() {
	// 数组分配好了内存，可以存放输入的字符串。
	char sa[20];
	gets(sa);
	/*
	指针则没有分配空间，无法存放输入的字符串，故抛出异常。（malloc一下就好）
	char* s;
	gets(s)
	;*/
}

// ---------------------------------------------------------------------------------------
// 通过函数调用，把main()函数中的一个字符串复制到另一个字符数组中。
void nameCopy(char to[], char from[]) {
	// 字符串变量作为函数参数。
	int i = 0;
	while (from[i] != '\0') {
		to[i] = from[i];
		i++;
	}
	to[i] = 0; // 结尾字符？
}
void pointCopy(char* to, char* from) {
	// 字符串指针作为函数参数。
	while (*from != '\0') {
		*to++ = *from++;
	}
	*to = 0;
}
void copyTest() {
	char from1[] = "this is a test";
	char from2[] = "this is a test";
	char to[20] = "tis is 'to' array";
	nameCopy(to, from1); // 字符串变量作为函数参数。
	printf("字符串变量作为函数参数->"); puts(to);
	pointCopy(to, from2); // 字符串指针作为函数参数。
	printf("字符串指针作为函数参数->"); puts(to);
}

// -------------------------------字符指针数组--------------------------------------
void sort(char* b[], int n);
void print(char* b[], int n);
void test() {
	char* a[] = { "Pronhub","Bilibili","CocaCola","Amazen" };
	int n = 4;
	sort(a, n);
	print(a, n);
	system("pause");
}
void sort(char* b[], int n) {
	// 将一个给定的字符指针数组按首字母顺序从小到大排列
	char* t;
	int i, j, k;
	for (i = 0; i < n - 1; i++) {
		k = i; // 第几行？
		for (j = i + 1; j < n; j++)
			if (strcmp(b[k], b[j]) > 0)
				k = j;
		if (k != i) {
			t = b[i];
			b[i] = b[k];
			b[k] = t;
		}
	}
}
void print(char* b[], int n) {
	int i;
	for (i = 0; i < n; i++)
		printf("%s \n", b[i]);
}

// -------------------------------main 函数形参--------------------------------------
/*
	argc : 程序执行时参数的数目（包括命令本身）。
	arv[i] : 指向第i个参数的字符指针。
*/
main(int argc, char* argv[]) {
	int i;
	printf("the programe name is:%s \n", argv[0]);
	for (i = 1; i < argc; i++)
		printf("%s \n", argv[i]);
}

