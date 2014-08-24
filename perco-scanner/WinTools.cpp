#include "stdafx.h"
#include "WinTools.h"


WinTools::WinTools()
{
}


WinTools::~WinTools()
{
}

void WinTools::sendAsHexToActiveWindow(LPBYTE data, int dataLen) {
	char hexstr[2];
	char lookup[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	BlockInput(true);
	for (int i = 0; i < dataLen; i++)
	{
		char text[2];
		text[0] = lookup[data[i] / 0x10];
		text[1] = lookup[data[i] % 0x10];
		
		for (int j = 0; j < 2; j++) {
			INPUT* pInputs = new INPUT[2];
			pInputs[0].type = 1;
			pInputs[1].type = 1;
			pInputs[1].ki.wVk = 0;
			pInputs[1].ki.dwFlags = 6;
			pInputs[0].ki.dwExtraInfo = NULL;
			pInputs[0].ki.time = 0;
			pInputs[1].ki.dwExtraInfo = NULL;
			pInputs[1].ki.time = 0;
			int cbSize = sizeof(pInputs[0]);
			int num2 = 0;

			pInputs[0].ki.wVk = 0;
			pInputs[0].ki.wScan = (short) text[j];
			pInputs[0].ki.dwFlags = 4;

			pInputs[1].ki.wScan = (short) text[j];

			SendInput(2, pInputs, cbSize);
			delete pInputs;
		}
	}

	INPUT* pInputs = new INPUT[2];
	pInputs[0].type = 1;
	pInputs[0].ki.wVk = 13;
	pInputs[0].ki.wScan = 0;
	pInputs[0].ki.dwFlags = 4;
	pInputs[0].ki.dwExtraInfo = NULL;
	pInputs[0].ki.time = 0;

	pInputs[1].type = 1;
	pInputs[1].ki.wVk = 13;
	pInputs[1].ki.wScan = (short)0;
	pInputs[1].ki.dwFlags = 6;
	pInputs[1].ki.dwExtraInfo = NULL;
	pInputs[1].ki.time = 0;

	int cbSize = sizeof(pInputs[0]);
	int num2 = 0;

	SendInput(2, pInputs, cbSize);
	delete pInputs;

	BlockInput(false);
}

void WinTools::sendAsDecToActiveWindow(unsigned long uid) {
	char text[22];
	_itoa_s(uid, text, sizeof(text), 10);
	int len = strlen(text);

	BlockInput(true);
	for(int i = 0; i < len; i++) 
	{
		INPUT* pInputs = new INPUT[2];
		pInputs[0].type = 1;
		pInputs[1].type = 1;
		pInputs[1].ki.wVk = 0;
		pInputs[1].ki.dwFlags = 6;
		pInputs[0].ki.dwExtraInfo = NULL;
		pInputs[0].ki.time = 0;
		pInputs[1].ki.dwExtraInfo = NULL;
		pInputs[1].ki.time = 0;
		int cbSize = sizeof(pInputs[0]);
		int num2 = 0;

		pInputs[0].ki.wVk = 0;
		pInputs[0].ki.wScan = (short)text[i];
		pInputs[0].ki.dwFlags = 4;

		pInputs[1].ki.wScan = (short)text[i];

		SendInput(2, pInputs, cbSize);
		delete pInputs;
	}

	INPUT* pInputs = new INPUT[2];
	pInputs[0].type = 1;
	pInputs[0].ki.wVk = 13;
	pInputs[0].ki.wScan = 0;
	pInputs[0].ki.dwFlags = 4;
	pInputs[0].ki.dwExtraInfo = NULL;
	pInputs[0].ki.time = 0;

	pInputs[1].type = 1;
	pInputs[1].ki.wVk = 13;
	pInputs[1].ki.wScan = (short)0;
	pInputs[1].ki.dwFlags = 6;
	pInputs[1].ki.dwExtraInfo = NULL;
	pInputs[1].ki.time = 0;

	int cbSize = sizeof(pInputs[0]);
	int num2 = 0;

	SendInput(2, pInputs, cbSize);
	delete pInputs;

	BlockInput(false);
}