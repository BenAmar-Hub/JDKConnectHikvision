package ClientDemo;

/*
 * public class Tester {
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * 
 * HCNetSDK.INSTANCE.NET_DVR_Init();// SDK initialization function
 * 
 * HCNetSDK.INSTANCE.NET_DVR_Login_V30("192.0.0.64", (short)8000, "admin",
 * "a1234b5678",null);
 * 
 * System.out.println(HCNetSDK.INSTANCE.NET_DVR_Cleanup());// Release SDK
 * resource function System.out.println(HCNetSDK.INSTANCE.NET_DVR_CloseSound());
 * 
 * //HCNetSDK.INSTANCE.NET_DVR_PTZControl(lRealHandle,
 * dwPTZCommand,dwStop);//Release SDK resource function
 * 
 * System.out.println("hello"); }
 * 
 * }
 */
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import ClientDemo.HCNetSDK.NET_DVR_DEVICEINFO_V30;
import ClientDemo.HCNetSDK.NET_DVR_IPPARACFG;
import ClientDemo.HCNetSDK.NET_DVR_WORKSTATE_V30;

public class Tester {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		HCNetSDK sdk = HCNetSDK.INSTANCE;
		if(!sdk.NET_DVR_Init()){
			System.out.println("SDK initialization failed");
			return;
		}
		NativeLong uid=new NativeLong(-1);
		NET_DVR_DEVICEINFO_V30 devinfo=new NET_DVR_DEVICEINFO_V30();//Device information
		String ip="192.0.0.64";
		short port=8000;
		uid=sdk.NET_DVR_Login_V30(ip,port,"admin","a1234b5678",devinfo);//Return a user number and write the device information into devinfo
		int Iuid=uid.intValue();
		if(Iuid<0){
			System.out.println("Device registration failed");
			return;
		}
		NET_DVR_WORKSTATE_V30 devwork=new NET_DVR_WORKSTATE_V30();
		if(!sdk.NET_DVR_GetDVRWorkState_V30(uid, devwork)){
			//Return a Boolean value to determine whether to obtain device capabilities
			System.out.println("Failed to return device status");
		}
		IntByReference ibrBytesReturned = new IntByReference(0);//Get IP access configuration parameters
		NET_DVR_IPPARACFG ipcfg=new NET_DVR_IPPARACFG();
		ipcfg.write();
		Pointer lpIpParaConfig =ipcfg.getPointer();
		sdk.NET_DVR_GetDVRConfig(uid,sdk.NET_DVR_GET_IPPARACFG,new NativeLong(0),lpIpParaConfig,ipcfg.size(),ibrBytesReturned);
		ipcfg.read();
		System.out.print("IP address:"+ip);
		System.out.println("|Device Status:"+devwork.dwDeviceStatic);//0 is normal, 1 CPU usage is too high, 2 hardware error, 3 unknown
		//Display analog channel
		for(int i=0;i< devinfo.byChanNum;i++){
			System.out.print("Camera"+i+1);//Analog channel number name
			System.out.print("|Whether to record:"+devwork.struChanStatic[i].byRecordStatic);//0 No recording, no recording
			System.out.print("|Signal status:"+devwork.struChanStatic[i].bySignalStatic);//0 is normal, 1 signal is lost
			System.out.println("|Hardware Status:"+devwork.struChanStatic[i].byHardwareStatic);//0 is normal, 1 is abnormal			
		}
		sdk.NET_DVR_Logout(uid);
		sdk.NET_DVR_Cleanup();		
	}

}