package FrameWork.helpers;

import com.relevantcodes.extentreports.LogStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static FrameWork.helpers.ReportHelper.logReportStatus;
import static FrameWork.library.Util.waitFor;

import FrameWork.listeners.PreReq;


public class eMailOtpReader {
	public static void main(String args[]) throws Exception {
		readMail();
	}

	public static String readMail()  {
		String Path = "";
		String otpValue = "";
		int waitCount = 0;
		Path = PreReq.vbsFilePath;
//		Path = "F:\\TestFramework\\src\\main\\resources\\VBS\\";
		File dir = new File(Path);

		try {

			do {
				waitCount++;
				waitFor(5000);
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "RunVBS.bat");
				pb.directory(dir);
				Process p = pb.start();
				p.waitFor();

				File f = new File(Path + "OTP.txt");
				BufferedReader is = new BufferedReader(new FileReader(f));

				String line;
				//as long as there are lines in the file, print them
				while ((line = is.readLine()) != null) {
					otpValue = line;
				}
				is.close();
				f.delete();

				//Waits for 30 seconds with 5 secons interval
				if(waitCount==6){
					break;
				}

			} while (otpValue.length() != 5);

		} catch (Exception e) {
			logReportStatus(LogStatus.FATAL, "OTP not generated successfully: \n" + e.getMessage());
		}

		if (!(otpValue.equalsIgnoreCase("")) && otpValue.length() == 5) {
			logReportStatus(LogStatus.INFO, "OTP generated successfully: " + otpValue);
		} else {
			logReportStatus(LogStatus.FATAL, "OTP not generated successfully: " + otpValue);
		}

		System.out.println(otpValue);
		return otpValue;
	}

}
