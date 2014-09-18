#include "stdafx.h"
#include "Reader.h"


CReader::CReader()
{
	hSerial = INVALID_HANDLE_VALUE;
	logFile = fopen("logPercoFile.txt", "a");
}


CReader::~CReader()
{
	close();
	fclose(logFile);
}

BOOL CReader::open(LPCWSTR port) {
	hSerial = CreateFile(port, GENERIC_READ | GENERIC_WRITE, 0, NULL, OPEN_EXISTING, 0, NULL);
	if (hSerial == INVALID_HANDLE_VALUE)
		return false;
	if (modifyCommSettings()) {
		SetCommMask(hSerial, EV_RXCHAR | EV_ERR);
		return true;
	}
	return false;
}
void CReader::close() {
	if (hSerial != INVALID_HANDLE_VALUE) {
		CloseHandle(hSerial);
		hSerial = INVALID_HANDLE_VALUE;
	}
}

BYTE CReader::calculateCheckSum(LPBYTE data, int len) {
	if (len > 4) {
		BYTE checkSum = data[2];
		for (int i = 3; i < len - 1; i++)
			checkSum = checkSum ^ data[i];
		data[len - 1] = checkSum;
		return checkSum;
	}
	return 0;
}

BOOL CReader::modifyCommSettings()
{	
	DCB PortDCB;
	// Initialize the DCBlength member. 
	PortDCB.DCBlength = sizeof (DCB);
	// Get the default serial port settings DCB information.
	GetCommState(hSerial, &PortDCB);
	// Change the common DCB structure settings to modify serial port settings.
	PortDCB.BaudRate = 9600;              // Current baud 
	PortDCB.ByteSize = 8;                 // Number of bits/byte, 4-8 
	PortDCB.Parity = NOPARITY;            // 0-4=no,odd,even,mark,space 
	PortDCB.StopBits = ONESTOPBIT;        // 0,1,2 = 1, 1.5, 2 
	// Configure the port settings according to the new specifications  
	// of the DCB structure.
	if (!SetCommState(hSerial, &PortDCB))
		return false;

	// Set read time outs 
	COMMTIMEOUTS ctos;
	ctos.ReadIntervalTimeout = MAXDWORD;
	ctos.ReadTotalTimeoutMultiplier = MAXDWORD;
	ctos.ReadTotalTimeoutConstant = 1;
	ctos.WriteTotalTimeoutMultiplier = 0;
	ctos.WriteTotalTimeoutConstant = 0;
	if (!SetCommTimeouts(hSerial, &ctos))
		return false;

	return true;
}

BOOL CReader::readWrite(LPBYTE sData, int sDataLen, BYTE rData[256], int &rDataLen) {
	// 1. WRITE DATA
	DWORD writedbytes = 0;
	calculateCheckSum(sData, sDataLen);

	if (!WriteFile(hSerial, sData, sDataLen, &writedbytes, NULL))
		return false;
	
	//printArray(sData, writedbytes, ">>");

	// 2. WAIT
	DWORD dwMask;
	WaitCommEvent(hSerial, &dwMask, 0);
	Sleep(100);
	// 3. READ DATA
	rDataLen = 0;
	BYTE rDataBuff[256];
	int rDataBuffLen = 256;
	DWORD readbytes = 0;
	do {
		if (ReadFile(hSerial, rDataBuff, rDataBuffLen, &readbytes, NULL)) {
			if (readbytes > 0 && rDataLen + readbytes <= 256) {
				for (int i = 0; i < readbytes; i++)
					rData[rDataLen + i] = rDataBuff[i];
				rDataLen = rDataLen + readbytes;
			}
			//printArray(rDataBuff, readbytes, "<<");
		}
	} while (readbytes > 0);

	return (rDataLen > 0);
}

void CReader::printArray(LPBYTE sData, int len, const char* mark) {
	printf("\n%s", mark);
	for (int i = 0; i < len; i++)
		printf(" %.2X", sData[i]);
	printf("\n");
}

BOOL CReader::initReader() {
	BYTE	cmdInit[] = { 0xF2, 0xFF, 0x03, 0x01, 0x00, 0x26, 0x00 };
	int		cmdInitLen = 7;

	BYTE rData[256];
	int rDataLen;

	if (readWrite(cmdInit, cmdInitLen, rData, rDataLen)) {
		if (rDataLen > 5 && rData[0] == 0xF2 && rData[1] == 0xFF 
						 && rData[2] == 0x04 && rData[3] == 0xF0
						 && rData[4] == 0x00 && rData[5] == 0x00)
			return true;
	}

	return false;
}
BOOL CReader::inventory(unsigned long &uid) {
	BYTE	cmdInv[] = { 0xF2, 0xFF, 0x01, 0x02, 0x00 };
	int		cmdInvLen = 5;

	BYTE rData[256];
	int rDataLen;

	uid = 0;

	if (readWrite(cmdInv, cmdInvLen, rData, rDataLen)) {
		if (rDataLen > 5) {
			if (rData[0] == 0xF2 && rData[1] == 0xFF && rData[2] == 0x04 && rData[3] == 0xF0 && rData[4] == 0x00 && rData[5] == 0x00) {
				return true;
			}
			else if (rDataLen > 12 && rData[0] == 0xF2 && rData[1] == 0xFF && rData[2] >= 0x09 && rData[3] == 0xF0) {
				for (int i = 10; i > 6; i--) 
					uid = uid * (unsigned long) 0x100 + rData[i];
				writeLogFile(rData, rDataLen, uid);
				return true;
			}
		}		
	}

	return false;
}

void CReader::writeLogFile(BYTE data[256], int dataLen, unsigned long uid)
{
	fprintf(logFile, ">> ");
	for (int i = 0; i < dataLen; i++)
		fprintf(logFile, " %.2X", data[i]);
	fprintf(logFile, "\n");

	fprintf(logFile, "%lu\n", uid);
	fflush(logFile);
}

void CReader::writeLogFile(char* text) 
{
	fprintf(logFile, "%s\n", text);
	fflush(logFile);
}