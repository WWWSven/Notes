/*
1, 设计一个线性表初始化操作的算法：为顺序表分配一个预定义大小的数组空间，并将线性表的当前长度设为“0”。
2, 设计一个算法：在顺序线性表L中第i（1≤i≤n）个位置之前插入新的元素e，并求其算法时间复杂度。
3, 已知一个顺序表L,其中的元素递增有序排列,设计一个算法插入一个元素x后保持该顺序表仍递增有序排列。
4, 假设表示集合的顺序表是一个有序顺序表,设计一个高效算法实现集合的求并集运算。
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
			printf("第%d个元素%d插入成功！\n", i + 1, L.data[i]);
		else
			printf("第%d个元素%d插入失败！\n", i + 1, L.data[i]);
	}
	printf("L.length = %d", L.length);
}
*/

#include <stdio.h>
#include "顺序表的表示与实现.h"
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
	printf("集合: ");
	for (int i = 0; i < L.length; i++)
	{
		if (i != 0) printf(",");
		printf("%d", L.data[i]);
	}
	printf("\n集合: ");
	for (int i = 0; i < L2.length; i++)
	{
		if (i != 0) printf(",");
		printf("%d", L2.data[i]);
	}
	printf("\n交集: ");
	int arr[LIST_INIT_SIZE];
	int arrLength = getSymbol(L, L2, arr);
	for (int i = 0; i < arrLength; i++)
	{
		printf("%d ,", arr[i]);
	}
	printf("\n并集: ");
	int arr2[10];
	int arrLastIndex = mergeList(L, L2, arr2);
	for (int i = 0; i < arrLastIndex; i++)
	{
		printf("%d ,", arr2[i]);
	}
}
// 03 题
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
//		printf("第%d个元素 = %d ！\n", i + 1, L.data[i]);
//	}
//	InsertStat[4] = InsertBySort(L, 3);
//	printf("插入3后！\n");
//	for (int i = 0; i < LIST_INIT_SIZE; i++)
//	{
//		printf("第%d个元素 = %d ！\n", i + 1, L.data[i]);
//	}
//	printf("L.length = %d", L.length);
//}