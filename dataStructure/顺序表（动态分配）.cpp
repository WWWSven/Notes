#include<stdio.h>
#include<stdlib.h>
namespace  顺序表（动态分配） {
	const int InitSize = 10;
	struct SequenceList
	{
		int* data;	// 指示动态分配数组的指针
		int MaxSize;// 顺序表的最大容量
		int length;	// 顺序表的当前长度
	};

	void InitList(SequenceList& L) {
		L.data = (int*)malloc(InitSize * sizeof(int)); // malloc 申请一片连续的存储空间
		L.length = 0;
		L.MaxSize = InitSize;
	}

	void IncreaseSize(SequenceList& L, int len) {
		int* p = L.data;
		L.data = (int*)malloc((L.MaxSize + len) * sizeof(int));
		for (int i = 0; i < L.length; i++)
		{
			L.data[i] = p[i];
		}
		L.MaxSize = L.MaxSize + len;
		free(p);
	}

	int main() {
		SequenceList L;
		InitList(L);
		IncreaseSize(L, 5);
		return 0;
	}
}