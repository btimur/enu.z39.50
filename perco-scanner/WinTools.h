#pragma once

#include <Windows.h>

class WinTools
{
public:
	WinTools();
	~WinTools();	
	static void sendAsHexToActiveWindow(LPBYTE data, int dataLen);
	static void sendAsDecToActiveWindow(unsigned long uid);
};

