#pragma once

#include <Windows.h>

class CReader
{
private:
	HANDLE hSerial;
	FILE* logFile;

public:
	CReader();
	~CReader();
	BOOL open(LPCWSTR port);
	void close();
	BOOL initReader();
	BOOL inventory(unsigned long &uid);

	void writeLogFile(BYTE data[256], int dataLen, unsigned long uid);
	void writeLogFile(char* data);

private:
	BYTE calculateCheckSum(LPBYTE data, int len);
	BOOL modifyCommSettings();
	BOOL readWrite(LPBYTE sData, int sDataLen, BYTE rData[256], int &rDataLen);
	void printArray(LPBYTE sData, int len, const char* mark);

	
};

