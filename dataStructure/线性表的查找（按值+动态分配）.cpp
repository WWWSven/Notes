#include<stdio.h>
#include<stdlib.h>
const int initSize = 10; // ˳���ĳ�ʼ����
struct sequenceList
{
	int* data; // ��̬���������ָ��
	int maxSize; // ˳�����������
	int length; // ˳���ĵ�ǰ����
};

void initList(sequenceList& L) {
	L.data = (int*)malloc(sizeof(int) * initSize);
	L.maxSize = initSize;
	L.length = 0;
}

// ��˳���L�в��ҵ�һ��Ԫ��ֵ����e��Ԫ�أ���������λ��
int locateElem(sequenceList L,int e){
	for (int i = 0; i < L.length; i++)
		if (L.data[i] == e)
			return i + 1; // λ���1��ʼ��Ϊ�����±�+1
	return 0; // ����ʧ�ܷ���0
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