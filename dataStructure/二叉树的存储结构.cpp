#include <stdio.h>
#include <stdlib.h>

#define MaxSize 100

struct TreeNode
{
	int value;
	bool isEmpty;
};

TreeNode t[MaxSize];


main() {

	for (int i = 0; i < MaxSize; i++)
	{
		t[i].isEmpty = true; // ��ʼ��ʱ���нڵ���Ϊ�ա�
	}
}