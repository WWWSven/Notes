#include<stdio.h>

const int maxSize = 10;
struct SequenceList
{
	int data[maxSize];
	int length;
};

void initSequenceList(SequenceList &L) {
	L.length = 0;
}

bool listDelete(SequenceList &L,int i,int &e) {
	if (i<1 || i>L.length)
		return false;
	e = L.data[i - 1];
	for (int j = i; j < L.length; j++)
		L.data[j - 1] = L.data[j];
	L.length--;
	return true;
}

int main() {
	SequenceList L;
	L.data[0] = 1;
	L.data[1] = 2;
	L.data[2] = 3;
	L.data[3] = 4;
	L.data[4] = 5;
	L.length = 5;
	printf("Î´É¾³ýÇ°£º\n");
	for (int i = 0; i < L.length; i++)
	{
		printf("k£º%d , v: %d \n",i,L.data[i]);
	}

	int e = -1;
	if (listDelete(L,8,e))
	{
		printf("É¾³ýºó£º\n");
		for (int i = 0; i < L.length; i++)
		{
			printf("k£º%d , v: %d \n", i, L.data[i]);
		}
	}
	else
	{
		printf("É¾³ýÊ§°Ü£¡\n");
	}
	return 0;
}
