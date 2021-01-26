#include<stdio.h>
#include<stdlib.h>
const int initSize = 10; // 顺序表的初始长度
struct sequenceList
{
	int* data; // 动态分配数组的指针
	int maxSize; // 顺序表的最大容量
	int length; // 顺序表的当前长度
};

void initList(sequenceList& L) {
	L.data = (int*)malloc(sizeof(int) * initSize);
	L.maxSize = initSize;
	L.length = 0;
}

// 在顺序表L中查找第一个元素值等于e的元素，并返回其位序
int locateElem(sequenceList L,int e){
	for (int i = 0; i < L.length; i++)
		if (L.data[i] == e)
			return i + 1; // 位序从1开始，为数组下标+1
	return 0; // 查找失败返回0
}

int main() {
	sequenceList L;
	initList(L);
	L.data[0] = 1;
	L.data[1] = 2;
	L.data[2] = 3;
	L.length = 3;
	printf("%d \n", locateElem(L, 2));
	printf("%d \n",locateElem(L, 999));
	return 0;
}