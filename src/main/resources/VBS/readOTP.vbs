Set WshShell = WScript.CreateObject("WScript.Shell")

'Get the Count of Items in Inbox
Set app = CreateObject("Outlook.Application")
Set nameSpace = app.GetNamespace("MAPI")
Set MyFolders1 = nameSpace.GetDefaultFolder(6)
Set MyFolders = MyFolders1.Folders

Dim folderName
'*************************
'Folder to read the emails
'Need to be parametrized
'*************************
folderName = "eCorp"

Dim mailSubject, maiBody, mailContent, otp, otpReturn, waitTime, waiting
otpReturn = 0
waiting = 0
waitTime = 20

dim fso: set fso = CreateObject("Scripting.FileSystemObject")
dim CurrentDirectory
CurrentDirectory = fso.GetAbsolutePathName(".")
dim notePad
notePad = CurrentDirectory + "\OTP.txt"

'************************************
'To access folder and read the emails
'************************************
For Each myFolder In MyFolders
	'MsgBox myFolder.Name
	If myFolder.Name = folderName Then
		Do			
			waiting	= waiting + 1
			WScript.Sleep 1000
			otpReturn = getOTP
			
			If  waiting = waitTime Then
				Exit Do
			End If
			
		Loop Until Len(otpReturn) = 5
		'****************************
		'To write OTP in Notepad
		'****************************
		Set objFileToWrite = CreateObject("Scripting.FileSystemObject").OpenTextFile(notePad,2,true)
		objFileToWrite.WriteLine(otpReturn)
		'MsgBox otpReturn
	Else
		Set objFileToWrite = CreateObject("Scripting.FileSystemObject").OpenTextFile(notePad,2,true)
    	objFileToWrite.WriteLine("eCorp Folder not found")
	End If
Next


objFileToWrite.Close
Set objFileToWrite = Nothing



'************************************************
'To search and read OTP emial from OutLook eMail
'************************************************

Function getOTP	
	For each mail In myFolder.Items
		If mail.unread Then
			mailSubject = mail.subject				
			If (InStr(mailSubject,"Important : OTP Email Validation")) <> 0 Then 
				maiBody = mail.body											
				mailContent = Split(maiBody, " and OTP Reference is ")				
				otp = Right(mailContent(0),(5))
				'mail.unread=false
				mail.Delete
			Else
				mail.Delete
			End If			
		Else
			mail.Delete
		End If
		'mail.Delete
	Next
	getOTP = otp
End Function