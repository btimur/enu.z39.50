// QuickCodePage.cpp : Defines the entry point for the application.
//

#include "stdafx.h"
#include "resource.h"
#include "Reader.h"
#include "WinTools.h"
#include <iostream>
#include <process.h>
#include <shlwapi.h>
#pragma comment(lib,"shlwapi.lib")
#include "shlobj.h"

using namespace std;

#define _countof(x) (sizeof(x) / sizeof((x)[0]))

const UINT WM_TRAY = WM_USER + 1;
HINSTANCE g_hInstance = NULL;
HICON g_hIcon = NULL;
HICON g_hIconStop = NULL;

HWND trayWnd = NULL;

void setWorkStatus(int status, HWND hWnd);

void LoadStringSafe(UINT nStrID, LPTSTR szBuf, UINT nBufLen)
{
	UINT nLen = LoadString(g_hInstance, nStrID, szBuf, nBufLen);
	if (nLen >= nBufLen)
		nLen = nBufLen - 1;
	szBuf[nLen] = 0;
}

HWND g_hEditPort = NULL;
HWND g_hButtonSave = NULL;
HWND g_hButtonStart = NULL;
HWND g_hButtonStop = NULL;

struct CWndSizeData {
	HWND m_hWnd;
	RECT m_stRect;
	int m_nResizeFlags;
};

struct CPopupWndData {
	HWND m_hWnd;
	SIZE m_stInitialSize;

	CWndSizeData* m_pControls; // currently we have 3 child controls
	DWORD m_dwControls;

	static CPopupWndData* s_pThis;
};

CPopupWndData* CPopupWndData::s_pThis = NULL;

#define WORKSTATUS_STARTED 1
#define WORKSTATUS_STOPED 0

int currentStatus = WORKSTATUS_STOPED;
LPTSTR currentPort = NULL;
BOOL isNeedStop = false;

#include <iostream>
#include <fstream>
#include <codecvt>

BOOL writeToFile(LPTSTR text) {
	FILE* file = _tfopen(L"settings.txt", L"w");
	if (file != NULL) {
		BOOL res = fwrite(text, sizeof(TCHAR), _tcslen(text), file) > 0;
		fclose(file);
		return res;
	}
	return false;
}
LPTSTR getCurrentPort() {
	if (currentPort == NULL) {
		FILE* file = _tfopen(L"settings.txt", L"r");
		if (file != NULL) {
			LPTSTR buff = new TCHAR[256];
			int readBytes = fread(buff, sizeof(TCHAR), 255, file);
			if (readBytes > 0) {
				buff[readBytes] = 0x00;
				currentPort = buff;
				fclose(file);
				return currentPort;
			}
			else {
				fclose(file);
				writeToFile(_T("COM4"));
				currentPort = _T("COM4");
			}
		}
		else {
			writeToFile(_T("COM4"));
			currentPort = _T("COM4");
		}
		return _T("COM4");
	} 
	else
		return currentPort;	
}

void taskScanCardReader(void *param) {
	CReader* reader = new CReader();
	unsigned long uid;
	HWND hWnd = (HWND) param;

	setWorkStatus(WORKSTATUS_STARTED, hWnd);
	if (reader->open(getCurrentPort())) {
		reader->initReader();
		while (true) {
			if (reader->inventory(uid)) {
				if (uid > 0) {
					WinTools::sendAsDecToActiveWindow(uid);
				}
			}
			if (isNeedStop) {
				isNeedStop = false;
				break;
			}
			Sleep(200);
		}
		reader->close();
	}
	setWorkStatus(WORKSTATUS_STOPED, hWnd);
	_endthread();
}

void setWorkStatus(int status, HWND hWnd) {
	currentStatus = status;
	EnableWindow(g_hEditPort, status != WORKSTATUS_STARTED);
	EnableWindow(g_hButtonSave, status != WORKSTATUS_STARTED);
	EnableWindow(g_hButtonStart, status != WORKSTATUS_STARTED);
	EnableWindow(g_hButtonStop, status == WORKSTATUS_STARTED);
	if (status == WORKSTATUS_STARTED) {
		//SendMessage(hWnd, WM_SETICON, ICON_BIG, (LPARAM)g_hIcon);
		//SendMessage(hWnd, WM_SETICON, ICON_SMALL, (LPARAM)g_hIcon);
	}
	else {
		//SendMessage(hWnd, WM_SETICON, ICON_BIG, (LPARAM)g_hIconStop);
		//SendMessage(hWnd, WM_SETICON, ICON_SMALL, (LPARAM)g_hIconStop);
	}
}

void initDialog(HWND hWnd) {
	setWorkStatus(currentStatus, hWnd);
	SetWindowText(g_hEditPort, getCurrentPort());
}

void saveButtonClicked(HWND hWnd) {	
	LPTSTR lpString = new TCHAR[50];
	GetWindowText(g_hEditPort, lpString, 50);
	if (writeToFile(lpString)) {
		if (currentPort != NULL)
			delete currentPort;
		currentPort = lpString;
	}
	
	MessageBox(hWnd, lpString, _T("Cap"), MB_OK | MB_SYSTEMMODAL);
}

void startButtonClicked(HWND hWnd) {
	if (currentStatus == WORKSTATUS_STOPED) {
		HANDLE hThread;
		hThread = (HANDLE)_beginthread(taskScanCardReader, 0, hWnd);
	}
	else {
		MessageBox(hWnd, _T("Warning: It's already started..."), _T("Warning"), MB_OK | MB_SYSTEMMODAL);
	}
}

void stopButtonClicked(HWND hWnd) {
	isNeedStop = true;
}

BOOL CALLBACK ConverterProc(HWND hWnd, UINT uMsg, WPARAM wParam, LPARAM lParam)
{
	switch (uMsg)
	{
	case WM_INITDIALOG:
		
		if (CPopupWndData::s_pThis)
		{
			CPopupWndData::s_pThis->m_hWnd = hWnd;

			if (g_hIcon)
			{
				SendMessage(hWnd, WM_SETICON, ICON_BIG, (LPARAM) g_hIcon);
				SendMessage(hWnd, WM_SETICON, ICON_SMALL, (LPARAM) g_hIcon);
			}

			for (HWND hChild = GetWindow(hWnd, GW_CHILD); hChild; hChild = GetWindow(hChild, GW_HWNDNEXT))
				CPopupWndData::s_pThis->m_dwControls++;

			if (CPopupWndData::s_pThis->m_pControls = new CWndSizeData[CPopupWndData::s_pThis->m_dwControls])
			{
				RECT stRect;
				GetClientRect(hWnd, &stRect);
				CPopupWndData::s_pThis->m_stInitialSize.cx = stRect.right;
				CPopupWndData::s_pThis->m_stInitialSize.cy = stRect.bottom;

				DWORD dwControl = 0;
				for (HWND hChild = GetWindow(hWnd, GW_CHILD); hChild; hChild = GetWindow(hChild, GW_HWNDNEXT))
				{
					RECT* pRect = &CPopupWndData::s_pThis->m_pControls[dwControl].m_stRect;
					GetWindowRect(hChild, pRect);
					ScreenToClient(hWnd, (POINT*) pRect);
					ScreenToClient(hWnd, ((POINT*) pRect) + 1);

					CPopupWndData::s_pThis->m_pControls[dwControl].m_hWnd = hChild;

					switch (GetDlgCtrlID(hChild))
					{/*
					case IDC_CODEPAGE:
						CPopupWndData::s_pThis->m_pControls[dwControl].m_nResizeFlags = 2;
						break;
					case IDC_TEXT:
						CPopupWndData::s_pThis->m_pControls[dwControl].m_nResizeFlags = 10;
						break;*/
					case IDC_REFRESH:
						CPopupWndData::s_pThis->m_pControls[dwControl].m_nResizeFlags = 3;
						break;
					default:
						CPopupWndData::s_pThis->m_pControls[dwControl].m_nResizeFlags = 0;
					}

					if (dwControl++ >= CPopupWndData::s_pThis->m_dwControls)
						break;
				}

			} else
				CPopupWndData::s_pThis->m_dwControls = 0;

			// fill our combo box with all available code pages
			g_hEditPort = GetDlgItem(hWnd, IDC_EDITPORT);
			g_hButtonSave = GetDlgItem(hWnd, IDC_REFRESH);
			g_hButtonStart = GetDlgItem(hWnd, IDC_STARTREADER);
			g_hButtonStop = GetDlgItem(hWnd, IDC_STOPREADER);

			initDialog(hWnd);

			// display it
			SendMessage(hWnd, WM_COMMAND, MAKELONG(0, CBN_SELENDOK), 0);
		}
		return TRUE;

	case WM_CLOSE:
		EndDialog(hWnd, IDCANCEL);
		return TRUE;

	case WM_COMMAND:
		switch (LOWORD(wParam))
		{
		case IDC_REFRESH:
			//todo: Zdes' obrabativautsa knopki
			saveButtonClicked(hWnd);
			SendMessage(hWnd, WM_COMMAND, MAKELONG(0, CBN_SELENDOK), 0);
			return 0;
		case IDC_STARTREADER:
			startButtonClicked(hWnd);
			SendMessage(hWnd, WM_COMMAND, MAKELONG(0, CBN_SELENDOK), 0);
			return 0;
		case IDC_STOPREADER:
			stopButtonClicked(hWnd);
			SendMessage(hWnd, WM_COMMAND, MAKELONG(0, CBN_SELENDOK), 0);
			return 0;
		}

		break;

	case WM_SIZE:
		if (SIZE_MINIMIZED == wParam)
			DestroyWindow(hWnd); // no need to hide it
		else
			if (CPopupWndData::s_pThis)
			{
				int nDx = LOWORD(lParam) - CPopupWndData::s_pThis->m_stInitialSize.cx;
				int nDy = HIWORD(lParam) - CPopupWndData::s_pThis->m_stInitialSize.cy;

				// resize our child controls
				for (DWORD dwControl = 0; dwControl < CPopupWndData::s_pThis->m_dwControls; dwControl++)
				{
					RECT stNewRect;
					CopyMemory(&stNewRect, &CPopupWndData::s_pThis->m_pControls[dwControl].m_stRect, sizeof(RECT));

					int nLocks = CPopupWndData::s_pThis->m_pControls[dwControl].m_nResizeFlags;
					if (1 & nLocks)
						stNewRect.left += nDx;
					if (2 & nLocks)
						stNewRect.right += nDx;
					if (4 & nLocks)
						stNewRect.top += nDy;
					if (8 & nLocks)
						stNewRect.bottom += nDy;

					MoveWindow(CPopupWndData::s_pThis->m_pControls[dwControl].m_hWnd, stNewRect.left, stNewRect.top,
						stNewRect.right - stNewRect.left, stNewRect.bottom - stNewRect.top, TRUE);
				}
			}

		return 0;

	case WM_DESTROY:	
		return 0;

	}
	return FALSE;
}

LRESULT CALLBACK HiddenWndProc(HWND hWnd, UINT uMsg, WPARAM wParam, LPARAM lParam)
{
	switch (uMsg)
	{
	case WM_CREATE:
		{
			trayWnd = hWnd;
			NOTIFYICONDATA stData;
			ZeroMemory(&stData, sizeof(stData));
			stData.cbSize = sizeof(stData);
			stData.hWnd = hWnd;
			stData.uFlags = NIF_ICON | NIF_MESSAGE | NIF_TIP;
			stData.uCallbackMessage = WM_TRAY;
			stData.hIcon = g_hIcon = LoadIcon(g_hInstance, MAKEINTRESOURCE(IDI_TRAYICON));
			g_hIconStop = LoadIcon(g_hInstance, MAKEINTRESOURCE(IDI_TRAYICON_STOP));
			LoadStringSafe(IDS_TIP, stData.szTip, _countof(stData.szTip));
			if (!Shell_NotifyIcon(NIM_ADD, &stData))
				return -1; // oops 
		}
		return 0;

	case WM_DESTROY:
		{					   
			NOTIFYICONDATA stData;
			ZeroMemory(&stData, sizeof(stData));
			stData.cbSize = sizeof(stData);
			stData.hWnd = hWnd;
			Shell_NotifyIcon(NIM_DELETE, &stData);
		}
		return 0;

	case WM_TRAY:
		switch (lParam)
		{
		case WM_LBUTTONDBLCLK:
			SendMessage(hWnd, WM_COMMAND, ID_SHOW, 0);
			break;

		case WM_RBUTTONDOWN:
			{
				HMENU hMenu = LoadMenu(g_hInstance, MAKEINTRESOURCE(IDR_POPUP));
				if (hMenu)
				{
					HMENU hSubMenu = GetSubMenu(hMenu, 0);
					if (hSubMenu)
					{
						POINT stPoint;
						GetCursorPos(&stPoint);

						TrackPopupMenu(hSubMenu, TPM_LEFTALIGN | TPM_BOTTOMALIGN | TPM_RIGHTBUTTON, stPoint.x, stPoint.y, 0, hWnd, NULL);
					}

					DestroyMenu(hMenu);
				}
			}
			break;
		}
		return 0;

	case WM_COMMAND:
		switch (LOWORD(wParam))
		{
		case ID_SHOW:
			if (CPopupWndData::s_pThis)
				SetForegroundWindow(CPopupWndData::s_pThis->m_hWnd);
			else
			{
				CPopupWndData stData;
				ZeroMemory(&stData, sizeof(stData));
				CPopupWndData::s_pThis = &stData;
				
				DialogBox(g_hInstance, MAKEINTRESOURCE(IDD_CONVERTER), NULL, ConverterProc);

				if (stData.m_pControls)
					delete[] stData.m_pControls;
				CPopupWndData::s_pThis = NULL;
			}
			return 0;

		case ID_QUIT:
			PostQuitMessage(0);
			return 0;
		}
		break;

	}
	return DefWindowProc(hWnd, uMsg, wParam, lParam);
}

int WINAPI WinMain(HINSTANCE hInstance,
                     HINSTANCE hPrevInstance,
                     LPSTR     lpCmdLine,
                     int       nCmdShow)
{
	TCHAR szTxt[0x100];
	wsprintf(szTxt, _T("hInstance=%08x\n"), hInstance);
	OutputDebugString(szTxt);

	WNDCLASS stWC;
	ZeroMemory(&stWC, sizeof(stWC));
	stWC.lpszClassName = _T("Quick_Translator");

	HWND hHiddenWnd = FindWindow(stWC.lpszClassName, NULL);
	if (hHiddenWnd)
		PostMessage(hHiddenWnd, WM_TRAY, 0, WM_LBUTTONDBLCLK);
	else
	{
		stWC.hInstance = hInstance;
		stWC.lpfnWndProc = HiddenWndProc;

		ATOM aClass = RegisterClass(&stWC);
		if (aClass)
		{
			g_hInstance = hInstance;
			HWND hHiddenWnd = CreateWindow((LPCTSTR)aClass, _T(""), 0, 0, 0, 0, 0, NULL, NULL, hInstance, NULL);
			
			if (hHiddenWnd)
			{
				HANDLE hThread;
				hThread = (HANDLE)_beginthread(taskScanCardReader, 0, hHiddenWnd);
				MSG stMsg;
				while (GetMessage(&stMsg, NULL, 0, 0) > 0)
				{
					TranslateMessage(&stMsg);
					DispatchMessage(&stMsg);
				}

				if (IsWindow(hHiddenWnd))
					DestroyWindow(hHiddenWnd);
			}
			UnregisterClass((LPCTSTR) aClass, g_hInstance);

			
		}
	}
	return 0;
}



