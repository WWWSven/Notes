/*
1, ���һ�����Ա��ʼ���������㷨��Ϊ˳������һ��Ԥ�����С������ռ䣬�������Ա�ĵ�ǰ������Ϊ��0����
2, ���һ���㷨����˳�����Ա�L�е�i��1��i��n����λ��֮ǰ�����µ�Ԫ��e���������㷨ʱ�临�Ӷȡ�
3, ��֪һ��˳���L,���е�Ԫ�ص�����������,���һ���㷨����һ��Ԫ��x�󱣳ָ�˳����Ե����������С�
4, �����ʾ���ϵ�˳�����һ������˳���,���һ����Ч�㷨ʵ�ּ��ϵ��󲢼����㡣
*/

/*

#include <stdio.h>
#define LIST_INIT_SIZE 10
typedef struct {
	int data[LIST_INIT_SIZE];
	int length;
}SqList;
void InitList(SqList &L) {
	for (int i = 0; i < LIST_INIT_SIZE; i++)
	{
		L.data[i] = 0;
	}
	L.length = 0;
}
void main() {
	SqList L;
	InitList(L);
	for (int i = 0; i < LIST_INIT_SIZE; i++)
	{
		printf("data [%d]=%d \n", i, L.data[i]);
	}
}

*/

/*
#include <stdio.h>
#define LIST_INIT_SIZE 5
typedef struct {
	int data[LIST_INIT_SIZE];
	int length;
}SqList;
void InitList(SqList &L) {
	L.length = 0;
}
bool ListInsert(SqList &L, int i, int e) {
	if (i<1 || i>L.length + 1)
		return false;
	if (L.length >= LIST_INIT_SIZE) // ?
		return false;
	for (int j = L.length - 1; j >= i - 1; j--)
		L.data[j + 1] = L.data[j];
	L.data[i - 1] = e;
	L.length++;
	return true;
}
void main() {
	SqList L;
	InitList(L);
	bool InsertStat[5];
	InsertStat[0] = ListInsert(L, 1, 1);
	InsertStat[1] = ListInsert(L, 2, 2);
	InsertStat[2] = ListInsert(L, 3, 3);
	InsertStat[3] = ListInsert(L, 4, 4);
	InsertStat[4] = ListInsert(L, 5, 5);
	for (int i = 0; i < 5; i++)
	{
		if (InsertStat[i])
			printf("��%d��Ԫ��%d����ɹ���\n", i + 1, L.data[i]);
		else
			printf("��%d��Ԫ��%d����ʧ�ܣ�\n", i + 1, L.data[i]);
	}
	printf("L.length = %d", L.length);
}
*/

#include <stdio.h>
#include "˳���ı�ʾ��ʵ��.h"
#define LIST_INIT_SIZE 5

typedef struct {
	int data[LIST_INIT_SIZE];
	int length;
}SqList;

void InitList(SqList &L) {
	for (int i = 0; i < LIST_INIT_SIZE; i++)
	{
		L.data[i] = 0;
	}
	L.length = 0;
}

bool ListInsert(SqList &L, int i, int e) {
	if (i<1 || i>L.length + 1)
		return false;
	if (L.length >= LIST_INIT_SIZE) // ?
		return false;
	for (int j = L.length - 1; j >= i - 1; j--)
		L.data[j + 1] = L.data[j];
	L.data[i - 1] = e;
	L.length++;
	return true;
}

bool InsertBySort(SqList &L, int e) {
	if (L.length >= LIST_INIT_SIZE) return false;
	for (int i = 0; i < L.length; i++)
	{
		if (L.data[i] >= e) {
			for (int j = L.length - 1; j >= i; j--)
				L.data[j + 1] = L.data[j];
			L.data[i] = e;
			L.length++;
			return true;
		}
	}
	return false;
}

int getSymbol(SqList foo, SqList bar, int *arr) {
	int i = 0, j = 0, k = 0;
	while (foo.data[i] <= foo.data[foo.length - 1] && bar.data[j] <= bar.data[bar.length - 1])
	{
		if (foo.data[i] == bar.data[j]) {
			arr[k] = foo.data[i];
			k++; i++; j++;
		}
		else if (foo.data[i] < bar.data[j]) {
			i++;
		}
		else {
			j++;
		}
	}
	return k;
}

int mergeList(SqList L1, SqList L2, int *resultArray) {
	int i = 0, j = 0, resultArrayIndex = 0;
	while (i < L1.length && j < L2.length) {
		if (L1.data[i] == L2.data[j]) {
			resultArray[resultArrayIndex] = L1.data[i];
			i++; j++; resultArrayIndex++;
		}
		else if (L1.data[i] > L2.data[j]) {
			resultArray[resultArrayIndex] = L2.data[j];
			j++; resultArrayIndex++;
		}
		else if (L1.data[i] < L2.data[j]) {
			resultArray[resultArrayIndex] = L1.data[i];
			i++; resultArrayIndex++;
		}
	}
	while (i < L1.length) {
		resultArray[resultArrayIndex] = L1.data[i];
		i++; resultArrayIndex++;
	}
	while (j < L2.length) {
		resultArray[resultArrayIndex] = L2.data[j];
		j++; resultArrayIndex++;
	}
	return resultArrayIndex;
}
void main() {
	SqList L;
	InitList(L);
	bool InsertStat[5];
	InsertStat[0] = ListInsert(L, 1, 1);
	InsertStat[1] = ListInsert(L, 2, 3);
	InsertStat[2] = ListInsert(L, 3, 5);
	InsertStat[3] = ListInsert(L, 4, 7);
	InsertStat[4] = ListInsert(L, 5, 9);
	SqList L2;
	InitList(L2);
	bool InsertStat2[5];
	InsertStat2[0] = ListInsert(L2, 1, 2);
	InsertStat2[1] = ListInsert(L2, 2, 4);
	InsertStat2[2] = ListInsert(L2, 3, 6);
	InsertStat2[3] = ListInsert(L2, 4, 8);
	InsertStat2[4] = ListInsert(L2, 5, 10);
	printf("����: ");
	for (int i = 0; i < L.length; i++)
	{
		if (i != 0) printf(",");
		printf("%d", L.data[i]);
	}
	printf("\n����: ");
	for (int i = 0; i < L2.length; i++)
	{
		if (i != 0) printf(",");
		printf("%d", L2.data[i]);
	}
	printf("\n����: ");
	int arr[LIST_INIT_SIZE];
	int arrLength = getSymbol(L, L2, arr);
	for (int i = 0; i < arrLength; i++)
	{
		printf("%d ,", arr[i]);
	}
	printf("\n����: ");
	int arr2[10];
	int arrLastIndex = mergeList(L, L2, arr2);
	for (int i = 0; i < arrLastIndex; i++)
	{
		printf("%d ,", arr2[i]);
	}
}
// 03 ��
//void main() {
//	SqList L;
//	InitList(L);
//	bool InsertStat[5];
//	InsertStat[0] = ListInsert(L, 1, 1);
//	InsertStat[1] = ListInsert(L, 2, 2);
//	InsertStat[2] = ListInsert(L, 3, 4);
//	InsertStat[3] = ListInsert(L, 4, 5);
//	for (int i = 0; i < LIST_INIT_SIZE - 1; i++)
//	{
//		printf("��%d��Ԫ�� = %d ��\n", i + 1, L.data[i]);
//	}
//	InsertStat[4] = InsertBySort(L, 3);
//	printf("����3��\n");
//	for (int i = 0; i < LIST_INIT_SIZE; i++)
//	{
//		printf("��%d��Ԫ�� = %d ��\n", i + 1, L.data[i]);
//	}
//	printf("L.length = %d", L.length);
//}