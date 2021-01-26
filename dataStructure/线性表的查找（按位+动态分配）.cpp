#include<stdio.h>
#include<stdlib.h>
const int initSize = 10; // ˳���ĳ�ʼ����
struct sequenceList
{
	int* data; // ��̬���������ָ��
	int maxSize; // ˳�����������
	int length; // ˳���ĵ�ǰ����
};

void initList(sequenceList &L) {
	L.data = (int*)malloc(sizeof(int)*initSize);
	L.maxSize = initSize;
	L.length = 0;
}

int getElem(sequenceList L,int i) {
	if (i>1&&i<L.length)
	{
		return L.data[i - 1];
	}
	return -1;
}

int main() {
	sequenceList L;
	initList(L);
	L.data[0] = 1;
	L.data[1] = 2;
	L.data[2] = 3;
	L.data[3] = 4;
	L.data[4] = 5;
	L.length = 5;
	printf("getElem: %d", getElem(L, 30));
	return 0;
}