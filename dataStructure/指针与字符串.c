#include <stdio.h>

/*
- c ���ַ�����δ洢��
	1�����ַ��������ʽ�洢���Զ���ĩβ��� \0 ��Ϊ�ַ���������ǡ�
	2����ʵ�����롿arrayString() pointString() diffBoth()
- �ַ���ָ����Ϊ��������ʱ�Ĵ�����ơ�
	1����ʵ�����롿copyTest()
- �ַ�ָ�������ʹ�á�
	1��һ��[2��4��]�����飬�ڶ�ά�������ָ������Ĳ�ͬ��(n* == null)
		+---��ά����---+
		|00 01 02 03   |    Ҫ������ַ������������С
		|10 11 n* n*   |	�˷ѿռ�
		+--------------+
		+---ָ������---+
		|00 01 02 03 \0|    �ַ����ж೤�ͷ���೤�Ŀռ�
		|10 11 \0      |    ��ʡ�ռ�
		+--------------+
	2����ʵ�����롿sort()������
- main �����βεĹ涨��ʹ�á�
	1, ��ʵ�����롿
*/

// ----------------------------------------------------------------------------------------
// ʹ�����顾�洢���ַ�����
void arrayString() {
	char s[] = "this is a string";
	int i = 0, total = 0;
	while (s[i] != '\0') {
		if (s[i] == 't') total++;
		i++;
	}
	printf("t�ĸ���Ϊ��%d", total);
}
// ʹ��ָ�롾ָ���ַ���
void pointString() {
	char* s = "this is a string";
	int i = 0, total = 0;
	while (*(s + i) != '\0') {
		if (*(s + i) == 't')  total++;
		i++;
	}
	printf("t�ĸ���Ϊ��%d", total);
}
// �Ƚ�����洢��ָ��ָ�������
void diffBoth() {
	// �����������ڴ棬���Դ��������ַ�����
	char sa[20];
	gets(sa);
	/*
	ָ����û�з���ռ䣬�޷����������ַ��������׳��쳣����mallocһ�¾ͺã�
	char* s;
	gets(s)
	;*/
}

// ---------------------------------------------------------------------------------------
// ͨ���������ã���main()�����е�һ���ַ������Ƶ���һ���ַ������С�
void nameCopy(char to[], char from[]) {
	// �ַ���������Ϊ����������
	int i = 0;
	while (from[i] != '\0') {
		to[i] = from[i];
		i++;
	}
	to[i] = 0; // ��β�ַ���
}
void pointCopy(char* to, char* from) {
	// �ַ���ָ����Ϊ����������
	while (*from != '\0') {
		*to++ = *from++;
	}
	*to = 0;
}
void copyTest() {
	char from1[] = "this is a test";
	char from2[] = "this is a test";
	char to[20] = "tis is 'to' array";
	nameCopy(to, from1); // �ַ���������Ϊ����������
	printf("�ַ���������Ϊ��������->"); puts(to);
	pointCopy(to, from2); // �ַ���ָ����Ϊ����������
	printf("�ַ���ָ����Ϊ��������->"); puts(to);
}

// -------------------------------�ַ�ָ������--------------------------------------
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
	// ��һ���������ַ�ָ�����鰴����ĸ˳���С��������
	char* t;
	int i, j, k;
	for (i = 0; i < n - 1; i++) {
		k = i; // �ڼ��У�
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

// -------------------------------main �����β�--------------------------------------
/*
	argc : ����ִ��ʱ��������Ŀ�������������
	arv[i] : ָ���i���������ַ�ָ�롣
*/
main(int argc, char* argv[]) {
	int i;
	printf("the programe name is:%s \n", argv[0]);
	for (i = 1; i < argc; i++)
		printf("%s \n", argv[i]);
}

