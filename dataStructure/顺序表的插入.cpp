//#include<stdio.h>
//#define MaxSize 10 // ����������󳤶�
//
//struct SequenceList
//{
//	int data[MaxSize]; // �þ�̬�ġ����顱�������Ԫ��
//	int length; // ˳���ǰ�ĳ���
//};
//
//void InitList(SequenceList & L) {
//	L.length = 0;
//}
//
//bool ListInsert(SequenceList & L, int i, int e) {
//	if (i<1 || i>L.length + 1) { // �жϲ����λ���Ƿ���Ч		
//		return false;
//	}
//	if (L.length >= MaxSize) { // �洢�ռ����ˣ����ܲ���
//		return false;
//	}
//	/*
//	 ������һ���ҵľ������
//	*/
//	//for (int j = i - 1; j < L.length; j++)
//		//L.data[j + 1] = L.data[j];
//	for (int j = L.length; j >= i; j--) 
//		L.data[j] = L.data[j - 1];
//	L.data[i - 1] = e;
//	L.length++;
//	return true;
//}
//
//int main() {
//	SequenceList L;
//	InitList(L);
//	L.data[0] = 1;
//	L.data[1] = 2;
//	L.data[2] = 4;
//	L.data[3] = 5;
//	L.length = 4;
//	ListInsert(L,3,3);
//	for (int i = 0; i < L.length; i++)
//	{
//		printf("��%d��Ԫ�أ�%d \n", i+1, L.data[i]);
//	}
//	return 0;
//}