#include <stdio.h>
/*
- ����ָ�룺ͨ��ָ����ú������ṩ�������õ�����һ�ַ�����
	ע�������ڴ洢ʱռ��һ���������ڴ�����������������Ƭ�ռ���׵�ַ��
		ִ�к������Ǵ��׵�ַ��ʼ��ֱ�����������Ľ�����䡣
	1������һ��ָ�������ʹ��ָ����������ʹ�����ָ���������ָ��ĺ�����
		�﷨����������ֵ���� (*ָ�������) (�β��б�);
		�磺int (*p) (int, int);
		ע��������Ҫָ��һ���������ʲ���Ҫ�����壬����Ҫ������βα�������
	2��������ָ�븳ֵ��
		int max(int a,int b){...};
		p = max;
	3��ͨ������ָ����ú�����
		(*p)(a,b); ע������(*p)����max(a,b)�е�max��
	ע������ͬ�ĺ���ָ���������ò�ͬ�ĺ��������ƶ�̬��
		�Ժ���ָ���������������û������ģ���������ָ�벻ͬ��
	��ʵ�����롿functionPoint()

- ����ָ����Ϊ������������һ����������ʵ�δ��ݸ������ú���������ʵ��һЩ���ӵ�Ӧ�á�
	��ʵ�����롿functionPointParameter()
- ָ�뺯��������һ������ָ��ֵ�ĺ���������һ��������Σ�ա���Ӧ�á� 
	����һ��ָ�뺯�������ǰ���ͨ�����ķ���ֵ���� ָ�������* ����ʽ
	��ʵ�����롿pointFunction()
ע������ָ����ص��� ָ�룬ָ�뺯�����ص��Ǻ������������ݴ��������ʣ��������ص㡣
*/
float triangle(float a,float b) {
	// �����������
	return a * b / 2.0;
}
float rectangle(float a,float b) {
	// ��������
	return a * b;
}

// ����ָ��
void functionPoint(){
	float a = 2,b = 4;
	float (*area)(float, float);
	// ��̬
	area = triangle;
	printf("%f \n", area(a, b));
	area = rectangle;
	printf("%f \n", area(a, b));
}

// ����ָ����Ϊ��������
void myP(float a, float b, float (*p)(float, float)) {
	printf("%f \n", (*p)(a, b));
}
void functionPointParameter() {
	float a = 2, b = 4;
	myP(a, b, triangle);
	myP(a, b, rectangle);
}

// ָ�뺯��
char* myStrcat(char* a, char* b) {
	// ƴ���ַ���
	char* pStr = a;
	while (*a != '\0')
		a++;
	while (*b != '\0')
		*a++ = *b++; // ��b�����ݸ�ֵ��a��ͬʱָ�����
	*a = '\0';
	return pStr;
}
void pointFunction() {
	char fir[80] = "fuck ";
	char sec[80] = "the world!";
	char* result = myStrcat(fir, sec);
	// ��Σ�ա�result�洢�ڱ�����������ַ������У�
	// ����ָ��ĺ�����myStrcat�����н�������ͷ��ڲ���������б�����
	// resultռ�õĿռ���ʱ���ܱ��޸ģ����ܻ�ȡ���޸ĺ�����ݡ�
	puts(result);
}

main() {
	pointFunction();
}

