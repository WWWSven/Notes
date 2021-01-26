#include<stdio.h>
#include<stdlib.h>
namespace  ˳�����̬���䣩 {
	const int InitSize = 10;
	struct SequenceList
	{
		int* data;	// ָʾ��̬���������ָ��
		int MaxSize;// ˳�����������
		int length;	// ˳���ĵ�ǰ����
	};

	void InitList(SequenceList& L) {
		L.data = (int*)malloc(InitSize * sizeof(int)); // malloc ����һƬ�����Ĵ洢�ռ�
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