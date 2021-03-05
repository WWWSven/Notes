#include <stdio.h>
// 先声明结构体类型，再定义变量名。
struct studentType1
{
	int num;
	char name[20];
};
struct studentType1 type1student1;
struct studentType1 type1student2;
// 在声明类型的同时定义变量。
struct studentType2
{
	int num;
	char name[20];
}type2student1, type2student2;
// 不指定类型名而直接定义结构体类型变量。
struct
{
	int num;
	char name[20];
}student1 = { 1,"sven" }, student2; // 声明的同时赋初值

struct student
{
	int num;
	char name[20];
	struct date
	{
		int year, month, day;
	}birthday;
	float score;
}stu = { 2,"tom",1999,10,07,99 };
typedef struct student student;
student stu1 = { 3,"Evan" }; // 剩下的有默认值

main() {
	//stu1.name = "luce"; 不能直接赋值，使用strcpy
	strcpy(stu1.name, "luce");
	printf("%d:%s", stu1.num, stu1.name);

	student test = { 100,"luce" };
	scanf("%d%s", &test.num, test.name); // scanf 需要地址参数，字符数组变量名就是地址。
	printf("%d:%s", test.num, test.name);

}