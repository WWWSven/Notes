#include <stdio.h>
// �������ṹ�����ͣ��ٶ����������
struct studentType1
{
	int num;
	char name[20];
};
struct studentType1 type1student1;
struct studentType1 type1student2;
// ���������͵�ͬʱ���������
struct studentType2
{
	int num;
	char name[20];
}type2student1, type2student2;
// ��ָ����������ֱ�Ӷ���ṹ�����ͱ�����
struct
{
	int num;
	char name[20];
}student1 = { 1,"sven" }, student2; // ������ͬʱ����ֵ

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
student stu1 = { 3,"Evan" }; // ʣ�µ���Ĭ��ֵ

main() {
	//stu1.name = "luce"; ����ֱ�Ӹ�ֵ��ʹ��strcpy
	strcpy(stu1.name, "luce");
	printf("%d:%s", stu1.num, stu1.name);

	student test = { 100,"luce" };
	scanf("%d%s", &test.num, test.name); // scanf ��Ҫ��ַ�������ַ�������������ǵ�ַ��
	printf("%d:%s", test.num, test.name);

}