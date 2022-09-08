package ClientDemo;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.examples.win32.GDI32.RECT;
import com.sun.jna.examples.win32.W32API;
import com.sun.jna.examples.win32.W32API.HWND;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.NativeLongByReference;
import com.sun.jna.ptr.ShortByReference;

//Description de l’interface SDK, .dll HCNetSDK
public interface HCNetSDK extends StdCallLibrary {

    HCNetSDK INSTANCE = (HCNetSDK) Native.loadLibrary("HCNetSDK",HCNetSDK.class);
//constant
    public static final int MAX_NAMELEN = 16;	//Nom de connexion local DVR
    public static final int MAX_RIGHT = 32;	//Autorisations prises en charge par l’appareil (1-12 pour les autorisations locales, 13-32 pour les autorisations distantes)
    public static final int NAME_LEN = 32;  
    public static final int MIN_PASSWD_LEN=8;
    public static final int STREAM_PASSWD_LEN=12;
    public static final int MAX_PASSWD_LEN_EX=64;
    public static final int GUID_LEN=16;
    public static final int  DEV_TYPE_NAME_LEN=24;
    public static final int PASSWD_LEN = 16;  
    public static final int SERIALNO_LEN = 48;   //Longueur du numéro de série
    public static final int MACADDR_LEN = 6;      //Longueur de l’adresse Mac
    public static final int MAC_ADDRESS_NUM=48;
    public static final int MAX_ETHERNET = 2;   //L’appareil peut être équipé d’un réseau Ethernet
    public static final int MAX_SENCE_NUM=16;
    public static final int RULE_REGION_MAX=128;
    public static final int MAX_NETWORK_CARD=4;
    public static final int MAX_NETWORK_CARD_EX=12;
    public static final int PATHNAME_LEN = 128;   //Longueur du tracé
    public static final int MAX_TIMESEGMENT_V30 = 8;    //9000 Nombre maximal de périodes de temps de l’appareil
    public static final int MAX_TIMESEGMENT = 4;   //Période maximale de 8000 appareils
    public static final int MAX_SHELTERNUM = 4;   //8000 zones d’occlusion maximales pour l’équipement
    public static final int MAX_DAYS = 7;      
    public static final int PHONENUMBER_LEN = 32;   
    public static final int MAX_DISKNUM_V30 = 33;	/* /9000 Nombre maximal de disques durs/* Jusqu’à 33 disques durs (dont 16 disques durs SATA internes, 1 disque dur eSATA et 16 disques NFS) 
    */
    public static final int MAX_DISKNUM = 16;    
    public static final int MAX_WINDOW_V30 = 32; 
    public static final int MAX_WINDOW = 16;    
    public static final int MAX_VGA_V30 = 4;     
    public static final int MAX_VGA = 1;    
    public static final int MAX_USERNUM_V30 = 32;  
    public static final int MAX_USERNUM = 16;  
    public static final int MAX_EXCEPTIONNUM_V30 = 32; 
    public static final int MAX_EXCEPTIONNUM = 16;   
    public static final int MAX_LINK = 6;   
    public static final int MAX_DECPOOLNUM = 4;  
    public static final int MAX_DECNUM = 4;    
    public static final int MAX_TRANSPARENTNUM = 2;   
    public static final int MAX_CYCLE_CHAN = 16;  
    public static final int MAX_DIRNAME_LENGTH = 80;   
    public static final int MAX_STRINGNUM_V30 = 8;		
    public static final int MAX_STRINGNUM = 4;   
    public static final int MAX_STRINGNUM_EX = 8; 
    public static final int MAX_AUXOUT_V30 = 16;  
    public static final int MAX_AUXOUT = 4;     
    public static final int MAX_HD_GROUP = 16;   
    public static final int MAX_NFS_DISK = 8;    
    public static final int IW_ESSID_MAX_SIZE = 32;    
    public static final int IW_ENCODING_TOKEN_MAX = 32;   
    public static final int MAX_SERIAL_NUM = 64;   
    public static final int MAX_DDNS_NUMS = 10;   
    public static final int MAX_DOMAIN_NAME = 64;	

    public static final int MAX_EMAIL_ADDR_LEN = 48;  
    public static final int MAX_EMAIL_PWD_LEN = 32;     
    public static final int MAXPROGRESS = 100;  
    public static final int MAX_SERIALNUM = 2;    
    public static final int CARDNUM_LEN = 20;   
    public static final int MAX_VIDEOOUT_V30 = 4;     
    public static final int MAX_VIDEOOUT = 2;      
    public static final int MAX_PRESET_V30 = 256;	
    public static final int MAX_TRACK_V30 = 256;	
    public static final int MAX_CRUISE_V30 = 256;	
    public static final int MAX_PRESET = 128;	
    public static final int MAX_TRACK = 128;	
    public static final int MAX_CRUISE = 128;	
    public static final int CRUISE_MAX_PRESET_NUMS = 32;    
    public static final int MAX_SERIAL_PORT = 8;   
    public static final int MAX_PREVIEW_MODE = 8;    
    public static final int MAX_MATRIXOUT = 16; 
    public static final int LOG_INFO_LEN = 11840; 
    public static final int DESC_LEN = 16;  
    public static final int PTZ_PROTOCOL_NUM = 200;   
    public static final int MAX_AUDIO = 1;    
    public static final int MAX_AUDIO_V30 = 2;   
    public static final int MAX_CHANNUM = 16;   
    public static final int MAX_ALARMIN = 16;  
    public static final int MAX_ALARMOUT = 4;    
   // Accès IPC 9000
    public static final int MAX_ANALOG_CHANNUM = 32;   
    public static final int MAX_ANALOG_ALARMOUT = 32;    
    public static final int MAX_ANALOG_ALARMIN = 32;    
    public static final int MAX_IP_DEVICE = 32;    
    public static final int MAX_IP_CHANNEL = 32;  
    public static final int MAX_IP_ALARMIN = 128;   
    public static final int MAX_IP_ALARMOUT = 64; 
    /* Nombre maximal de canaux pris en charge Analogique maximum plus prise en charge IP maximale */
    public static final int MAX_CHANNUM_V30 = (MAX_ANALOG_CHANNUM + MAX_IP_CHANNEL);//64
    public static final int MAX_ALARMOUT_V30 = (MAX_ANALOG_ALARMOUT + MAX_IP_ALARMOUT);//96
    public static final int MAX_ALARMIN_V30 = (MAX_ANALOG_ALARMIN + MAX_IP_ALARMIN);//160

    /*******************Le code d’erreur global commence**********************/
    public static final int NET_DVR_NOERROR = 0;	
    public static final int NET_DVR_PASSWORD_ERROR = 1;	
    public static final int NET_DVR_NOENOUGHPRI = 2;
    public static final int NET_DVR_NOINIT = 3;
    public static final int NET_DVR_CHANNEL_ERROR = 4;	
    public static final int NET_DVR_OVER_MAXLINK = 5;	
    public static final int NET_DVR_VERSIONNOMATCH = 6;	
    public static final int NET_DVR_NETWORK_FAIL_CONNECT = 7;
    public static final int NET_DVR_NETWORK_SEND_ERROR = 8;	
    public static final int NET_DVR_NETWORK_RECV_ERROR = 9;	
    public static final int NET_DVR_NETWORK_RECV_TIMEOUT = 10;	
    public static final int NET_DVR_NETWORK_ERRORDATA = 11;	
    public static final int NET_DVR_ORDER_ERROR = 12;	
    public static final int NET_DVR_OPERNOPERMIT = 13;	
    public static final int NET_DVR_COMMANDTIMEOUT = 14;	
    public static final int NET_DVR_ERRORSERIALPORT = 15;
    public static final int NET_DVR_ERRORALARMPORT = 16;	
    public static final int NET_DVR_PARAMETER_ERROR = 17;
    public static final int NET_DVR_CHAN_EXCEPTION = 18;	
    public static final int NET_DVR_NODISK = 19;	
    public static final int NET_DVR_ERRORDISKNUM = 20;	
    public static final int NET_DVR_DISK_FULL = 21;	
    public static final int NET_DVR_DISK_ERROR = 22;
    public static final int NET_DVR_NOSUPPORT = 23;
    public static final int NET_DVR_BUSY = 24;
    public static final int NET_DVR_MODIFY_FAIL = 25;
    public static final int NET_DVR_PASSWORD_FORMAT_ERROR = 26;
    public static final int NET_DVR_DISK_FORMATING = 27;	
    public static final int NET_DVR_DVRNORESOURCE = 28;	
    public static final int NET_DVR_DVROPRATEFAILED = 29; 
    public static final int NET_DVR_OPENHOSTSOUND_FAIL = 30;
    public static final int NET_DVR_DVRVOICEOPENED = 31; 
    public static final int NET_DVR_TIMEINPUTERROR = 32; 
    public static final int NET_DVR_NOSPECFILE = 33;  
    public static final int NET_DVR_CREATEFILE_ERROR = 34;	
    public static final int NET_DVR_FILEOPENFAIL = 35; 
    public static final int NET_DVR_OPERNOTFINISH = 36; 
    public static final int NET_DVR_GETPLAYTIMEFAIL = 37; 
    public static final int NET_DVR_PLAYFAIL = 38; 
    public static final int NET_DVR_FILEFORMAT_ERROR = 39;
    public static final int NET_DVR_DIR_ERROR = 40;	
    public static final int NET_DVR_ALLOC_RESOURCE_ERROR = 41;
    public static final int NET_DVR_AUDIO_MODE_ERROR = 42;	
    public static final int NET_DVR_NOENOUGH_BUF = 43;	
    public static final int NET_DVR_CREATESOCKET_ERROR = 44;
    public static final int NET_DVR_SETSOCKET_ERROR = 45;
    public static final int NET_DVR_MAX_NUM = 46;	
    public static final int NET_DVR_USERNOTEXIST = 47;	
    public static final int NET_DVR_WRITEFLASHERROR = 48;
    public static final int NET_DVR_UPGRADEFAIL = 49;
    public static final int NET_DVR_CARDHAVEINIT = 50; 
    public static final int NET_DVR_PLAYERFAILED = 51;	
    public static final int NET_DVR_MAX_USERNUM = 52; 
    public static final int NET_DVR_GETLOCALIPANDMACFAIL = 53;
    public static final int NET_DVR_NOENCODEING = 54;	
    public static final int NET_DVR_IPMISMATCH = 55;	
    public static final int NET_DVR_MACMISMATCH = 56;
    public static final int NET_DVR_UPGRADELANGMISMATCH = 57;
    public static final int NET_DVR_MAX_PLAYERPORT = 58;
    public static final int NET_DVR_NOSPACEBACKUP = 59;
    public static final int NET_DVR_NODEVICEBACKUP = 60;	
    public static final int NET_DVR_PICTURE_BITS_ERROR = 61;	
    public static final int NET_DVR_PICTURE_DIMENSION_ERROR = 62;
    public static final int NET_DVR_PICTURE_SIZ_ERROR = 63;	
    public static final int NET_DVR_LOADPLAYERSDKFAILED = 64;	
    public static final int NET_DVR_LOADPLAYERSDKPROC_ERROR = 65;	
    public static final int NET_DVR_LOADDSSDKFAILED = 66;	
    public static final int NET_DVR_LOADDSSDKPROC_ERROR = 67;	
    public static final int NET_DVR_DSSDK_ERROR = 68;
    public static final int NET_DVR_VOICEMONOPOLIZE = 69;	
    public static final int NET_DVR_JOINMULTICASTFAILED = 70;	
    public static final int NET_DVR_CREATEDIR_ERROR = 71;	
    public static final int NET_DVR_BINDSOCKET_ERROR = 72;	
    public static final int NET_DVR_SOCKETCLOSE_ERROR = 73;	
    public static final int NET_DVR_USERID_ISUSING = 74;	
    public static final int NET_DVR_SOCKETLISTEN_ERROR = 75;	
    public static final int NET_DVR_PROGRAM_EXCEPTION = 76;	
    public static final int NET_DVR_WRITEFILE_FAILED = 77;
    public static final int NET_DVR_FORMAT_READONLY = 78;
    public static final int NET_DVR_WITHSAMEUSERNAME = 79;
    public static final int NET_DVR_DEVICETYPE_ERROR = 80; 
    public static final int NET_DVR_LANGUAGE_ERROR = 81; 
    public static final int NET_DVR_PARAVERSION_ERROR = 82;
    public static final int NET_DVR_IPCHAN_NOTALIVE = 83; 
    public static final int NET_DVR_RTSP_SDK_ERROR = 84;	
    public static final int NET_DVR_CONVERT_SDK_ERROR = 85;	
    public static final int NET_DVR_IPC_COUNT_OVERFLOW = 86; 
    public static final int NET_PLAYM4_NOERROR = 500;	
    public static final int NET_PLAYM4_PARA_OVER = 501;
    public static final int NET_PLAYM4_ORDER_ERROR = 502;//The order of the function to be called is error.
    public static final int NET_PLAYM4_TIMER_ERROR = 503;//Create multimedia clock failed;
    public static final int NET_PLAYM4_DEC_VIDEO_ERROR = 504;//Decode video data failed.
    public static final int NET_PLAYM4_DEC_AUDIO_ERROR = 505;//Decode audio data failed.
    public static final int NET_PLAYM4_ALLOC_MEMORY_ERROR = 506;	//Allocate memory failed.
    public static final int NET_PLAYM4_OPEN_FILE_ERROR = 507;	//Open the file failed.
    public static final int NET_PLAYM4_CREATE_OBJ_ERROR = 508;//Create thread or event failed
    public static final int NET_PLAYM4_CREATE_DDRAW_ERROR = 509;//Create DirectDraw object failed.
    public static final int NET_PLAYM4_CREATE_OFFSCREEN_ERROR = 510;//failed when creating off-screen surface.
    public static final int NET_PLAYM4_BUF_OVER = 511;	//buffer is overflow
    public static final int NET_PLAYM4_CREATE_SOUND_ERROR = 512;	//failed when creating audio device.
    public static final int NET_PLAYM4_SET_VOLUME_ERROR = 513;//Set volume failed
    public static final int NET_PLAYM4_SUPPORT_FILE_ONLY = 514;//The function only support play file.
    public static final int NET_PLAYM4_SUPPORT_STREAM_ONLY = 515;//The function only support play stream.
    public static final int NET_PLAYM4_SYS_NOT_SUPPORT = 516;//System not support.
    public static final int NET_PLAYM4_FILEHEADER_UNKNOWN = 517;	//No file header.
    public static final int NET_PLAYM4_VERSION_INCORRECT = 518;	//The version of decoder and encoder is not adapted.
    public static final int NET_PALYM4_INIT_DECODER_ERROR = 519;	//Initialize decoder failed.
    public static final int NET_PLAYM4_CHECK_FILE_ERROR = 520;	//The file data is unknown.
    public static final int NET_PLAYM4_INIT_TIMER_ERROR = 521;	//Initialize multimedia clock failed.
    public static final int NET_PLAYM4_BLT_ERROR = 522;//Blt failed.
    public static final int NET_PLAYM4_UPDATE_ERROR = 523;//Update failed.
    public static final int NET_PLAYM4_OPEN_FILE_ERROR_MULTI = 524; //openfile error, streamtype is multi
    public static final int NET_PLAYM4_OPEN_FILE_ERROR_VIDEO = 525; //openfile error, streamtype is video
    public static final int NET_PLAYM4_JPEG_COMPRESS_ERROR = 526; //JPEG compress error
    public static final int NET_PLAYM4_EXTRACT_NOT_SUPPORT = 527;	//Don't support the version of this file.
    public static final int NET_PLAYM4_EXTRACT_DATA_ERROR = 528;	//extract video data failed.
    /*************************************************
  	NET_DVR_IsSupport() renvoie la valeur 1-9 bits indiquent les informations suivantes (bits et TRUE) respectivement pour indiquer la prise en charge;
     **************************************************/
    public static final int NET_DVR_SUPPORT_DDRAW = 0x01;
    public static final int NET_DVR_SUPPORT_BLT = 0x02;
    public static final int NET_DVR_SUPPORT_BLTFOURCC = 0x04;
    public static final int NET_DVR_SUPPORT_BLTSHRINKX = 0x08;
    public static final int NET_DVR_SUPPORT_BLTSHRINKY = 0x10;
    public static final int NET_DVR_SUPPORT_BLTSTRETCHX = 0x20;
    public static final int NET_DVR_SUPPORT_BLTSTRETCHY = 0x40;
    public static final int NET_DVR_SUPPORT_SSE = 0x80;
    public static final int NET_DVR_SUPPORT_MMX = 0x100;
    /**********************La commande de contrôle de la station commence*************************/
    public static final int LIGHT_PWRON = 2;	
    public static final int WIPER_PWRON = 3;	
    public static final int FAN_PWRON = 4;	
    public static final int HEATER_PWRON = 5;	
    public static final int AUX_PWRON1 = 6;	
    public static final int AUX_PWRON2 = 7;	
    public static final int SET_PRESET = 8;	
    public static final int CLE_PRESET = 9;	
    public static final int ZOOM_IN = 11;	
    public static final int ZOOM_OUT = 12;	
    public static final int FOCUS_NEAR = 13; 
    public static final int FOCUS_FAR = 14; 
    public static final int IRIS_OPEN = 15; 
    public static final int IRIS_CLOSE = 16; 
    public static final int TILT_UP = 21;	
    public static final int TILT_DOWN = 22;	
    public static final int PAN_LEFT = 23;	
    public static final int PAN_RIGHT = 24;
    public static final int UP_LEFT = 25;	
    public static final int UP_RIGHT = 26;	
    public static final int DOWN_LEFT = 27;	
    public static final int DOWN_RIGHT = 28;	
    public static final int PAN_AUTO = 29;	
    public static final int FILL_PRE_SEQ = 30;	
    public static final int SET_SEQ_DWELL = 31;	
    public static final int SET_SEQ_SPEED = 32;	
    public static final int CLE_PRE_SEQ = 33;
    public static final int STA_MEM_CRUISE = 34;
    public static final int STO_MEM_CRUISE = 35;
    public static final int RUN_CRUISE = 36;	
    public static final int RUN_SEQ = 37;	
    public static final int STOP_SEQ = 38;	
    public static final int GOTO_PRESET = 39;	

    /*************************************************
   	Définitions de macro de commande de contrôle de lecture pendant la lecture
    NET_DVR_PlayBackControl
    NET_DVR_PlayControlLocDisplay
    Définition de macro pour le NET_DVR_DecPlayBackCtrl
    Plus précisément, vous pouvez afficher les descriptions de fonctions et le code
     **************************************************/
    public static final int NET_DVR_PLAYSTART = 1;//Démarrer la lecture
    public static final int NET_DVR_PLAYSTOP = 2;
    public static final int NET_DVR_PLAYPAUSE = 3;
    public static final int NET_DVR_PLAYRESTART = 4;
    public static final int NET_DVR_PLAYFAST = 5;
    public static final int NET_DVR_PLAYSLOW = 6;
    public static final int NET_DVR_PLAYNORMAL = 7;
    public static final int NET_DVR_PLAYFRAME = 8;
    public static final int NET_DVR_PLAYSTARTAUDIO = 9;
    public static final int NET_DVR_PLAYSTOPAUDIO = 10;
    public static final int NET_DVR_PLAYAUDIOVOLUME = 11;
    public static final int NET_DVR_PLAYSETPOS = 12;
    public static final int NET_DVR_PLAYGETPOS = 13;
    public static final int NET_DVR_PLAYGETTIME = 14;
    public static final int NET_DVR_PLAYGETFRAME = 15;
    public static final int NET_DVR_GETTOTALFRAMES = 16;
    public static final int NET_DVR_GETTOTALTIME = 17;
    public static final int NET_DVR_THROWBFRAME = 20;
    public static final int NET_DVR_SETSPEED = 24;
    public static final int NET_DVR_KEEPALIVE = 25;
    //Les clés distantes sont définies comme suit :
/* key value send to CONFIG program */
    public static final int KEY_CODE_1 = 1;
    public static final int KEY_CODE_2 = 2;
    public static final int KEY_CODE_3 = 3;
    public static final int KEY_CODE_4 = 4;
    public static final int KEY_CODE_5 = 5;
    public static final int KEY_CODE_6 = 6;
    public static final int KEY_CODE_7 = 7;
    public static final int KEY_CODE_8 = 8;
    public static final int KEY_CODE_9 = 9;
    public static final int KEY_CODE_0 = 10;
    public static final int KEY_CODE_POWER = 11;
    public static final int KEY_CODE_MENU = 12;
    public static final int KEY_CODE_ENTER = 13;
    public static final int KEY_CODE_CANCEL = 14;
    public static final int KEY_CODE_UP = 15;
    public static final int KEY_CODE_DOWN = 16;
    public static final int KEY_CODE_LEFT = 17;
    public static final int KEY_CODE_RIGHT = 18;
    public static final int KEY_CODE_EDIT = 19;
    public static final int KEY_CODE_ADD = 20;
    public static final int KEY_CODE_MINUS = 21;
    public static final int KEY_CODE_PLAY = 22;
    public static final int KEY_CODE_REC = 23;
    public static final int KEY_CODE_PAN = 24;
    public static final int KEY_CODE_M = 25;
    public static final int KEY_CODE_A = 26;
    public static final int KEY_CODE_F1 = 27;
    public static final int KEY_CODE_F2 = 28;

    /* for PTZ control */
    public static final int KEY_PTZ_UP_START = KEY_CODE_UP;
    public static final int KEY_PTZ_UP_STO = 32;
    public static final int KEY_PTZ_DOWN_START = KEY_CODE_DOWN;
    public static final int KEY_PTZ_DOWN_STOP = 33;
    public static final int KEY_PTZ_LEFT_START = KEY_CODE_LEFT;
    public static final int KEY_PTZ_LEFT_STOP = 34;
    public static final int KEY_PTZ_RIGHT_START = KEY_CODE_RIGHT;
    public static final int KEY_PTZ_RIGHT_STOP = 35;
    public static final int KEY_PTZ_AP1_START = KEY_CODE_EDIT;/*Ouverture + */
    public static final int KEY_PTZ_AP1_STOP = 36;
    public static final int KEY_PTZ_AP2_START = KEY_CODE_PAN;/* ouverture- */
    public static final int KEY_PTZ_AP2_STOP = 37;
    public static final int KEY_PTZ_FOCUS1_START = KEY_CODE_A;/*foyer+ */
    public static final int KEY_PTZ_FOCUS1_STOP = 38;
    public static final int KEY_PTZ_FOCUS2_START = KEY_CODE_M ;/* foyer- */
    public static final int KEY_PTZ_FOCUS2_STOP = 39;
    public static final int KEY_PTZ_B1_START = 40;/* Double+ */
    public static final int KEY_PTZ_B1_STOP = 41;
    public static final int KEY_PTZ_B2_START = 42;/*Double- */
    public static final int KEY_PTZ_B2_STOP = 43;
    public static final int KEY_CODE_11 = 44;
    public static final int KEY_CODE_12 = 45;
    public static final int KEY_CODE_13 = 46;
    public static final int KEY_CODE_14 = 47;
    public static final int KEY_CODE_15 = 48;
    public static final int KEY_CODE_16 = 49;
    /*************************Début de la commande de configuration des paramètres*******************************/
//Habitués à NET_DVR_SetDVRConfig et NET_DVR_GetDVRConfig, faites attention à leur structure de configuration correspondante
    public static final int NET_DVR_GET_DEVICECFG = 100;	//Obtient les paramètres de l’appareil
    public static final int NET_DVR_SET_DEVICECFG = 101;	//Définir les paramètres de l’appareil
    public static final int NET_DVR_GET_NETCFG = 102;	//Obtient les paramètres réseau
    public static final int NET_DVR_SET_NETCFG = 103;	//definir les paramètres réseau
    public static final int NET_DVR_GET_PICCFG = 104;	//Obtient les paramètres d’image
    public static final int NET_DVR_SET_PICCFG = 105;	//definir les paramètres d’image
    public static final int NET_DVR_GET_COMPRESSCFG = 106;	
    public static final int NET_DVR_SET_COMPRESSCFG = 107;	
    public static final int NET_DVR_GET_RECORDCFG = 108;	//Obtient le paramètre de temps d’enregistrement
    public static final int NET_DVR_SET_RECORDCFG = 109;	
    public static final int NET_DVR_GET_DECODERCFG = 110;	//Obtient les paramètres du décodeur
    public static final int NET_DVR_SET_DECODERCFG = 111;	
    public static final int NET_DVR_GET_RS232CFG = 112;	//Obtient les paramètres de port série 232
    public static final int NET_DVR_SET_RS232CFG = 113;	
    public static final int NET_DVR_GET_ALARMINCFG = 114;	
    public static final int NET_DVR_SET_ALARMINCFG = 115;	
    public static final int NET_DVR_GET_ALARMOUTCFG = 116;	
    public static final int NET_DVR_SET_ALARMOUTCFG = 117;	
    public static final int NET_DVR_GET_TIMECFG = 118;	
    public static final int NET_DVR_SET_TIMECFG = 119;		
    public static final int NET_DVR_GET_PREVIEWCFG = 120;	
    public static final int NET_DVR_SET_PREVIEWCFG = 121;	
    public static final int NET_DVR_GET_VIDEOOUTCFG = 122;	
    public static final int NET_DVR_SET_VIDEOOUTCFG = 123;	
    public static final int NET_DVR_GET_USERCFG = 124;	//Obtient les paramètres utilisateur
    public static final int NET_DVR_SET_USERCFG = 125;	
    public static final int NET_DVR_GET_EXCEPTIONCFG = 126;	
    public static final int NET_DVR_SET_EXCEPTIONCFG = 127;	
    public static final int NET_DVR_GET_ZONEANDDST = 128;	
    public static final int NET_DVR_SET_ZONEANDDST = 129;	
    public static final int NET_DVR_GET_SHOWSTRING = 130;	
    public static final int NET_DVR_SET_SHOWSTRING = 131;	
    public static final int NET_DVR_GET_EVENTCOMPCFG = 132;	
    public static final int NET_DVR_SET_EVENTCOMPCFG = 133;	
    public static final int NET_DVR_GET_AUXOUTCFG = 140;	
    public static final int NET_DVR_SET_AUXOUTCFG = 141;	
    public static final int NET_DVR_GET_PREVIEWCFG_AUX = 142;	
    public static final int NET_DVR_SET_PREVIEWCFG_AUX = 143;	
    public static final int NET_DVR_GET_PICCFG_EX = 200;	
    public static final int NET_DVR_SET_PICCFG_EX = 201;	
    public static final int NET_DVR_GET_USERCFG_EX = 202;	
    public static final int NET_DVR_SET_USERCFG_EX = 203;	
    public static final int NET_DVR_GET_COMPRESSCFG_EX = 204;	
    public static final int NET_DVR_SET_COMPRESSCFG_EX = 205;	
    public static final int NET_DVR_GET_NETAPPCFG = 222;	
    public static final int NET_DVR_SET_NETAPPCFG = 223;	
    public static final int NET_DVR_GET_NTPCFG = 224;	
    public static final int NET_DVR_SET_NTPCFG = 225;	
    public static final int NET_DVR_GET_DDNSCFG = 226;	
    public static final int NET_DVR_SET_DDNSCFG = 227;		

    public static final int NET_DVR_GET_EMAILCFG = 228;	
    public static final int NET_DVR_SET_EMAILCFG = 229;	
    public static final int NET_DVR_GET_NFSCFG = 230;	/* NFS disk config */
    public static final int NET_DVR_SET_NFSCFG = 231;	/* NFS disk config */
    public static final int NET_DVR_GET_SHOWSTRING_EX = 238;	
    public static final int NET_DVR_SET_SHOWSTRING_EX = 239;	
    public static final int NET_DVR_GET_NETCFG_OTHER = 244;	
    public static final int NET_DVR_SET_NETCFG_OTHER = 245;	
    public static final int NET_DVR_GET_EMAILPARACFG = 250;	//Get EMAIL parameters
    public static final int NET_DVR_SET_EMAILPARACFG = 251;	//Setup EMAIL parameters
    public static final int NET_DVR_GET_DDNSCFG_EX = 274;
    public static final int NET_DVR_SET_DDNSCFG_EX = 275;
    public static final int NET_DVR_SET_PTZPOS = 292;	
    public static final int NET_DVR_GET_PTZPOS = 293;		
    public static final int NET_DVR_GET_PTZSCOPE = 294;
    
    public static final int NET_DVR_GET_NETCFG_V30 = 1000;	
    public static final int NET_DVR_SET_NETCFG_V30 = 1001;	
    public static final int NET_DVR_GET_PICCFG_V30 = 1002;	
    public static final int NET_DVR_SET_PICCFG_V30 = 1003;	
    public static final int NET_DVR_GET_RECORDCFG_V30 = 1004;	
    public static final int NET_DVR_SET_RECORDCFG_V30 = 1005;	
    public static final int NET_DVR_GET_USERCFG_V30 = 1006;	
    public static final int NET_DVR_SET_USERCFG_V30 = 1007;	
    public static final int NET_DVR_GET_DDNSCFG_V30 = 1010;	
    public static final int NET_DVR_SET_DDNSCFG_V30 = 1011;	
    public static final int NET_DVR_GET_EMAILCFG_V30 = 1012;
    public static final int NET_DVR_SET_EMAILCFG_V30 = 1013;
    public static final int NET_DVR_GET_CRUISE = 1020;
    public static final int NET_DVR_SET_CRUISE = 1021;
    public static final int NET_DVR_GET_ALARMINCFG_V30 = 1024;
    public static final int NET_DVR_SET_ALARMINCFG_V30 = 1025;
    public static final int NET_DVR_GET_ALARMOUTCFG_V30 = 1026;
    public static final int NET_DVR_SET_ALARMOUTCFG_V30 = 1027;
    public static final int NET_DVR_GET_VIDEOOUTCFG_V30 = 1028;
    public static final int NET_DVR_SET_VIDEOOUTCFG_V30 = 1029;
    public static final int NET_DVR_GET_SHOWSTRING_V30 = 1030;
    public static final int NET_DVR_SET_SHOWSTRING_V30 = 1031;
    public static final int NET_DVR_GET_EXCEPTIONCFG_V30 = 1034;
    public static final int NET_DVR_SET_EXCEPTIONCFG_V30 = 1035;
    public static final int NET_DVR_GET_RS232CFG_V30 = 1036;
    public static final int NET_DVR_SET_RS232CFG_V30 = 1037;
    public static final int NET_DVR_GET_COMPRESSCFG_V30 = 1040;
    public static final int NET_DVR_SET_COMPRESSCFG_V30 = 1041;
    public static final int NET_DVR_GET_DECODERCFG_V30 = 1042;	
    public static final int NET_DVR_SET_DECODERCFG_V30 = 1043;	
    public static final int NET_DVR_GET_PREVIEWCFG_V30 = 1044;	
    public static final int NET_DVR_SET_PREVIEWCFG_V30 = 1045;	
    public static final int NET_DVR_GET_PREVIEWCFG_AUX_V30 = 1046;	
    public static final int NET_DVR_SET_PREVIEWCFG_AUX_V30 = 1047;	
    public static final int NET_DVR_GET_IPPARACFG = 1048;    
    public static final int NET_DVR_SET_IPPARACFG = 1049;    
    public static final int NET_DVR_GET_IPALARMINCFG = 1050;    
    public static final int NET_DVR_SET_IPALARMINCFG = 1051;  
    public static final int NET_DVR_GET_IPALARMOUTCFG = 1052;  
    public static final int NET_DVR_SET_IPALARMOUTCFG = 1053;  
    public static final int NET_DVR_GET_HDCFG = 1054;   
    public static final int NET_DVR_SET_HDCFG = 1055;    
    public static final int NET_DVR_GET_HDGROUP_CFG = 1056;    
    public static final int NET_DVR_SET_HDGROUP_CFG = 1057;   
    public static final int NET_DVR_GET_COMPRESSCFG_AUD = 1058;    
    public static final int NET_DVR_SET_COMPRESSCFG_AUD = 1059;     
    public static final int NET_DVR_FILE_SUCCESS = 1000;	
    public static final int NET_DVR_FILE_NOFIND = 1001;	
    public static final int NET_DVR_ISFINDING = 1002;
    public static final int NET_DVR_NOMOREFILE = 1003;
    public static final int NET_DVR_FILE_EXCEPTION = 1004;
    public static final int COMM_ALARM = 0x1100;	
    public static final int COMM_TRADEINFO = 0x1500; 
    public static final int COMM_ALARM_V30 = 0x4000;
    public static final int COMM_IPCCFG = 0x4001;
    public static final int EXCEPTION_EXCHANGE = 0x8000;
    public static final int EXCEPTION_AUDIOEXCHANGE = 0x8001;
    public static final int EXCEPTION_ALARM = 0x8002;
    public static final int EXCEPTION_PREVIEW = 0x8003;
    public static final int EXCEPTION_SERIAL = 0x8004;
    public static final int EXCEPTION_RECONNECT = 0x8005;	
    public static final int EXCEPTION_ALARMRECONNECT = 0x8006;
    public static final int EXCEPTION_SERIALRECONNECT = 0x8007;
    public static final int EXCEPTION_PLAYBACK = 0x8010;
    public static final int EXCEPTION_DISKFMT = 0x8011;
    public static final int NET_DVR_SYSHEAD = 1;
    public static final int NET_DVR_STREAMDATA = 2;
    public static final int NET_DVR_AUDIOSTREAMDATA = 3;
    public static final int NET_DVR_STD_VIDEODATA = 4;
    public static final int NET_DVR_STD_AUDIODATA = 5;
    public static final int NET_DVR_REALPLAYEXCEPTION = 111;
    public static final int NET_DVR_REALPLAYNETCLOSE = 112;
    public static final int NET_DVR_REALPLAY5SNODATA = 113;
    public static final int NET_DVR_REALPLAYRECONNECT = 114;
    public static final int NET_DVR_PLAYBACKOVER = 101;
    public static final int NET_DVR_PLAYBACKEXCEPTION = 102;
    public static final int NET_DVR_PLAYBACKNETCLOSE = 103;
    public static final int NET_DVR_PLAYBACK5SNODATA = 104;
    public static final int DVR = 1;		
    public static final int ATMDVR = 2;		/*atm dvr*/
    public static final int DVS = 3;			/*DVS*/
    public static final int DEC = 4;			/* 6001D */
    public static final int ENC_DEC = 5;			/* 6001F */
    public static final int DVR_HC = 6;			/*8000HC*/
    public static final int DVR_HT = 7;			/*8000HT*/
    public static final int DVR_HF = 8;			/*8000HF*/
    public static final int DVR_HS = 9;			/* 8000HS DVR(no audio) */
    public static final int DVR_HTS = 10;         /* 8016HTS DVR(no audio) */
    public static final int DVR_HB = 11;         /* HB DVR(SATA HD) */
    public static final int DVR_HCS = 12;         /* 8000HCS DVR */
    public static final int DVS_A = 13;       
    public static final int DVR_HC_S = 14;         /* 8000HC-S */
    public static final int DVR_HT_S = 15;         /* 8000HT-S */
    public static final int DVR_HF_S = 16;         /* 8000HF-S */
    public static final int DVR_HS_S = 17;         /* 8000HS-S */
    public static final int ATMDVR_S = 18;         /* ATM-S */
    public static final int LOWCOST_DVR = 19;			
    public static final int DEC_MAT = 20;        
    public static final int DVR_MOBILE = 21;			/* mobile DVR */
    public static final int DVR_HD_S = 22;        /* 8000HD-S */
    public static final int DVR_HD_SL = 23;			/* 8000HD-SL */
    public static final int DVR_HC_SL = 24;			/* 8000HC-SL */
    public static final int DVR_HS_ST = 25;			/* 8000HS_ST */
    public static final int DVS_HW = 26;         /* 6000HW */
    public static final int IPCAM = 30;			
    public static final int MEGA_IPCAM = 31;			
    public static final int IPCAM_X62MF = 32;			
    public static final int IPDOME = 40;			
    public static final int MEGA_IPDOME = 41;     
    public static final int IPMOD = 50;			
    public static final int DS71XX_H = 71;			/* DS71XXH_S */
    public static final int DS72XX_H_S = 72;			/* DS72XXH_S */
    public static final int DS73XX_H_S = 73;			/* DS73XXH_S */
    public static final int DS81XX_HS_S = 81;			/* DS81XX_HS_S */
    public static final int DS81XX_HL_S = 82;			/* DS81XX_HL_S */
    public static final int DS81XX_HC_S = 83;			/* DS81XX_HC_S */
    public static final int DS81XX_HD_S = 84;			/* DS81XX_HD_S */
    public static final int DS81XX_HE_S = 85;			/* DS81XX_HE_S */
    public static final int DS81XX_HF_S = 86;			/* DS81XX_HF_S */
    public static final int DS81XX_AH_S = 87;			/* DS81XX_AH_S */
    public static final int DS81XX_AHF_S = 88;			/* DS81XX_AHF_S */
    public static final int DS90XX_HF_S = 90;       /*DS90XX_HF_S*/
    public static final int DS91XX_HF_S = 91;             /*DS91XX_HF_S*/
    public static final int DS91XX_HD_S = 92;            /*91XXHD-S(MD)*/

  

    public static final int MAJOR_OPERATION = 0x3;

    public static final int MINOR_START_DVR = 0x41; /*demarrer*/
    public static final int MINOR_STOP_DVR = 0x42;/* arrêter */
    public static final int MINOR_STOP_ABNORMAL = 0x43;/*anormal*/
    public static final int MINOR_REBOOT_DVR = 0x44;   /*redemarer*/
    public static final int MINOR_LOCAL_LOGIN = 0x50; /* connexion locale */
    public static final int MINOR_LOCAL_LOGOUT = 0x51; /*deconnexion locale */
    public static final int MINOR_LOCAL_CFG_PARM = 0x52; /* paramètres de configuration locaux
 */
    public static final int MINOR_LOCAL_PLAYBYFILE = 0x53; /* Lecture locale ou téléchargement par fichier */
    public static final int MINOR_LOCAL_PLAYBYTIME = 0x54; /*Lecture ou téléchargement local par heure*/
    public static final int MINOR_LOCAL_START_REC = 0x55; /* demarrer l'enregistrement local*/
    public static final int MINOR_LOCAL_STOP_REC = 0x56; /* Arrêter l'enregistrement local */
    public static final int MINOR_LOCAL_PTZCTRL = 0x57; 
    public static final int MINOR_LOCAL_PREVIEW = 0x58;/*apercu locale*/
    public static final int MINOR_LOCAL_MODIFY_TIME = 0x59;
    public static final int MINOR_LOCAL_UPGRADE = 0x5a;
    public static final int MINOR_LOCAL_RECFILE_OUTPUT = 0x5b; 
    public static final int MINOR_LOCAL_FORMAT_HDD = 0x5c; 
    public static final int MINOR_LOCAL_CFGFILE_OUTPUT = 0x5d; 
    public static final int MINOR_LOCAL_CFGFILE_INPUT = 0x5e;  
    public static final int MINOR_LOCAL_COPYFILE = 0x5f;  
    public static final int MINOR_LOCAL_LOCKFILE = 0x60;  
    public static final int MINOR_LOCAL_UNLOCKFILE = 0x61;  
    public static final int MINOR_LOCAL_DVR_ALARM = 0x62;  
    public static final int MINOR_IPC_ADD = 0x63; 
    public static final int MINOR_IPC_DEL = 0x64;  
    public static final int MINOR_IPC_SET = 0x65; 
    public static final int MINOR_LOCAL_START_BACKUP = 0x66;	
    public static final int MINOR_LOCAL_STOP_BACKUP = 0x67;
    public static final int MINOR_LOCAL_COPYFILE_START_TIME = 0x68;
    public static final int MINOR_LOCAL_COPYFILE_END_TIME = 0x69;	
    public static final int MINOR_REMOTE_LOGIN = 0x70;/*a distance*/
    public static final int MINOR_REMOTE_LOGOUT = 0x71;
    public static final int MINOR_REMOTE_START_REC = 0x72;
    public static final int MINOR_REMOTE_STOP_REC = 0x73;
    public static final int MINOR_START_TRANS_CHAN = 0x74;
    public static final int MINOR_STOP_TRANS_CHAN = 0x75; 
    public static final int MINOR_REMOTE_GET_PARM = 0x76;
    public static final int MINOR_REMOTE_CFG_PARM = 0x77;
    public static final int MINOR_REMOTE_GET_STATUS = 0x78;
    public static final int MINOR_REMOTE_ARM = 0x79; 
    public static final int MINOR_REMOTE_DISARM = 0x7a;
    public static final int MINOR_REMOTE_REBOOT = 0x7b; 
    public static final int MINOR_START_VT = 0x7c;
    public static final int MINOR_STOP_VT = 0x7d;
    public static final int MINOR_REMOTE_UPGRADE = 0x7e; 
    public static final int MINOR_REMOTE_PLAYBYFILE = 0x7f; 
    public static final int MINOR_REMOTE_PLAYBYTIME = 0x80; 
    public static final int MINOR_REMOTE_PTZCTRL = 0x81; 
    public static final int MINOR_REMOTE_FORMAT_HDD = 0x82;  
    public static final int MINOR_REMOTE_STOP = 0x83;  
    public static final int MINOR_REMOTE_LOCKFILE = 0x84;
    public static final int MINOR_REMOTE_UNLOCKFILE = 0x85;
    public static final int MINOR_REMOTE_CFGFILE_OUTPUT = 0x86;   
    public static final int MINOR_REMOTE_CFGFILE_INTPUT = 0x87;   
    public static final int MINOR_REMOTE_RECFILE_OUTPUT = 0x88;  
    public static final int MINOR_REMOTE_DVR_ALARM = 0x89;    
    public static final int MINOR_REMOTE_IPC_ADD = 0x8a;  
    public static final int MINOR_REMOTE_IPC_DEL = 0x8b;
    public static final int MINOR_REMOTE_IPC_SET = 0x8c; 
    public static final int MINOR_REBOOT_VCA_LIB = 0x8d;		

    public static final int MAJOR_INFORMATION = 0x4;   
    public static final int MINOR_HDD_INFO = 0xa1;
    public static final int MINOR_SMART_INFO = 0xa2;   
    public static final int MINOR_REC_START = 0xa3;   
    public static final int MINOR_REC_STOP = 0xa4;
    public static final int MINOR_REC_OVERDUE = 0xa5;
    public static final int MINOR_LINK_START = 0xa6; 
    public static final int MINOR_LINK_STOP = 0xa7;
    public static final int PARA_VIDEOOUT = 0x1;
    public static final int PARA_IMAGE = 0x2;
    public static final int PARA_ENCODE = 0x4;
    public static final int PARA_NETWORK = 0x8;
    public static final int PARA_ALARM = 0x10;
    public static final int PARA_EXCEPTION = 0x20;
    public static final int PARA_DECODER = 0x40; /*decodeur*/
    public static final int PARA_RS232 = 0x80;
    public static final int PARA_PREVIEW = 0x100;
    public static final int PARA_SECURITY = 0x200;
    public static final int PARA_DATETIME = 0x400;
    public static final int PARA_FRAMETYPE = 0x800;  
    public static final int PARA_VCA_RULE = 0x1000;    
    public static final int DS6001_HF_B = 60;
    public static final int DS6001_HF_P = 61;
    public static final int DS6002_HF_B = 62;
    public static final int DS6101_HF_B = 63;
    public static final int IVMS_2000 = 64;
    public static final int DS9000_IVS = 65;
    public static final int DS8004_AHL_A = 66;
    public static final int DS6101_HF_P = 67;
    public static final int VCA_DEV_ABILITY = 0x100;
    public static final int VCA_CHAN_ABILITY = 0x110;
    public static final int NET_DVR_SET_PLATECFG = 150 ;

    public static final int NET_DVR_GET_PLATECFG = 151;	//Définir les paramètres de reconnaissance de plaque d'immatriculation
    public static final int NET_DVR_SET_RULECFG = 152;	
    public static final int NET_DVR_GET_RULECFG = 153;
    public static final int NET_DVR_SET_LF_CFG = 160;
    public static final int NET_DVR_GET_LF_CFG = 161;
    public static final int NET_DVR_SET_IVMS_STREAMCFG = 162;	//Définir les paramètres de débit de l'analyseur intelligent
    public static final int NET_DVR_GET_IVMS_STREAMCFG = 163;	
    public static final int NET_DVR_SET_VCA_CTRLCFG = 164; 
    public static final int NET_DVR_GET_VCA_CTRLCFG = 165;	 
    public static final int NET_DVR_SET_VCA_MASK_REGION = 166;	 
    public static final int NET_DVR_GET_VCA_MASK_REGION = 167;	 
    public static final int NET_DVR_SET_VCA_ENTER_REGION = 168; //Définir les paramètres de la zone de masque
    public static final int NET_DVR_GET_VCA_ENTER_REGION = 169;	 
    public static final int NET_DVR_SET_VCA_LINE_SEGMENT = 170;	 
    public static final int NET_DVR_GET_VCA_LINE_SEGMENT = 171;	
    public static final int NET_DVR_SET_IVMS_MASK_REGION = 172;	
    public static final int NET_DVR_GET_IVMS_MASK_REGION = 173;	 
    public static final int NET_DVR_SET_IVMS_ENTER_REGION = 174; 
    public static final int NET_DVR_GET_IVMS_ENTER_REGION = 175; 
    public static final int NET_DVR_SET_IVMS_BEHAVIORCFG = 176;
    public static final int NET_DVR_GET_IVMS_BEHAVIORCFG = 177;	




//Paramètres de la structure du temps scolaire
    public static class NET_DVR_TIME extends Structure {
        public int dwYear;		
        public int dwMonth;		
        public int dwDay;		
        public int dwHour;		
        public int dwMinute;		
        public int dwSecond;		

      public String toString() {
            return "NET_DVR_TIME.dwYear: " + dwYear + "\n" + "NET_DVR_TIME.dwMonth: \n" + dwMonth + "\n" + "NET_DVR_TIME.dwDay: \n" + dwDay + "\n" + "NET_DVR_TIME.dwHour: \n" + dwHour + "\n" + "NET_DVR_TIME.dwMinute: \n" + dwMinute + "\n" + "NET_DVR_TIME.dwSecond: \n" + dwSecond;
        }

        public String toStringTime()
        {
            return  String.format("%02d/%02d/%02d%02d:%02d:%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
        }

        //Utilisé pour l’affichage dans une liste
         public String toStringTitle()
        {
            return  String.format("Time%02d%02d%02d%02d%02d%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
        }
    }

    public static class NET_DVR_SCHEDTIME extends Structure {
        public byte byStartHour;	//debut
        public byte byStartMin;
        public byte byStopHour;	        
        public byte byStopMin;
    }

  public static class NET_DVR_HANDLEEXCEPTION_V30 extends Structure {
	public int dwHandleType;	/*Mode de manipulation, méthode de traitement du résultat « ou » *//*0x00: Ne répond pas*//*0x01: Avertissement sur le moniteur*//*0x02: Avertissement sonore*//*0x04: Centre de téléchargement*//*0x08: Sortie d’alarme de déclenchement*//*0x20: Capture de déclenchement*///(Personnalisation JPEG)
	public byte[] byRelAlarmOut = new byte[MAX_ALARMOUT_V30];  //Le canal de sortie du déclencheur d’alarme, la sortie du déclencheur d’alarme, 1 indique que la sortie est déclenchée
}

//Structures de gestion des alarmes et des exceptions (sous-structures) (utilisées plusieurs fois)
  public static class NET_DVR_HANDLEEXCEPTION extends Structure {
	public int	dwHandleType;		
	public byte[]  byRelAlarmOut = new byte[MAX_ALARMOUT];
}

//Paramètres du périphérique DVR
  public static class NET_DVR_DEVICECFG extends Structure {
        public int dwSize;
        public byte[] sDVRName = new byte[NAME_LEN]; //Nom du DVR  
        public int dwDVRID;	// ID DVR pour télécommande		
        public int dwRecycleRecord;	//Que ce soit pour enregistrer en boucle, 0 : non ; 1 : oui	       
        //Les éléments suivants ne peuvent pas être modifiés
        public byte[] sSerialNumber = new byte[SERIALNO_LEN]; 
        public int dwSoftwareVersion;//Numéro de version du logiciel, les 16 bits supérieurs sont la version majeure et les 16 bits inférieurs sont la version mineure
        public int dwSoftwareBuildDate;			       
        public int dwDSPSoftwareVersion;		       
        public int dwDSPSoftwareBuildDate;		        
        public int dwPanelVersion;				
        public int dwHardwareVersion;// version materielle	       
        public byte byAlarmInPortNum;//Nombre d'entrées d'alarme DVR		
        public byte byAlarmOutPortNum;//Nombre de sorties d'alarme DVR		
        public byte byRS232Num;	//Nombre de ports série du DVR 232		
        public byte byRS485Num;			
        public byte byNetworkPortNum;//Nombre de ports réseau
	
        public byte byDiskCtrlNum;			
        public byte byDiskNum;				
        public byte byDVRType;				
        public byte byChanNum;				
        public byte byStartChan;			
        public byte byDecordChans;			
        public byte byVGANum;				
        public byte byUSBNum;				
        public byte byAuxoutNum;			
        public byte byAudioNum;			        
        public byte byIPChanNum;//Nombre maximal de canaux
			
    }

public static class NET_DVR_IPADDR extends Structure {
        public byte[] sIpV4 = new byte[16];
        public byte[] byRes = new byte[128];

        public String toString() {
            return "NET_DVR_IPADDR.sIpV4: " + new String(sIpV4) + "\n" + "NET_DVR_IPADDR.byRes: " + new String(byRes) + "\n";
        }
    }


//Structures de données réseau (sous-structures) (9000 extensions)
    public static class NET_DVR_ETHERNET_V30 extends Structure {
        public NET_DVR_IPADDR struDVRIP;
        public NET_DVR_IPADDR struDVRIPMask;
        public int dwNetInterface;
        public short wDVRPort;
        public short wMTU;
        public byte[] byMACAddr = new byte[6];

        public String toString() {
            return "NET_DVR_ETHERNET_V30.struDVRIP: \n" + struDVRIP + "\n" + "NET_DVR_ETHERNET_V30.struDVRIPMask: \n" + struDVRIPMask + "\n" + "NET_DVR_ETHERNET_V30.dwNetInterface: " + dwNetInterface + "\n" + "NET_DVR_ETHERNET_V30.wDVRPort: " + wDVRPort + "\n" + "NET_DVR_ETHERNET_V30.wMTU: " + wMTU + "\n" + "NET_DVR_ETHERNET_V30.byMACAddr: " + new String(byMACAddr) + "\n";
        }
    }

    public static class NET_DVR_ETHERNET extends Structure {
	public byte[]  sDVRIP = new byte[16]; //Adresse IP du DVR                   
	public byte[]  sDVRIPMask = new byte[16];               
	public int dwNetInterface;//Interface réseau 1-10MBase-T 2-10MBase-T duplex intégral 3-100MBase-TX 4-100M duplex intégral 5-10M/100M adaptatif               
	public short wDVRPort;	//Le numéro de port	                
	public byte[]  byMACAddr = new byte[MACADDR_LEN];	//mac adresse	
}

    public static class NET_DVR_PPPOECFG extends Structure {//PPPoe
        public int dwPPPoE;
        public byte[] sPPPoEUser = new byte[32];
        public byte[] sPPPoEPassword = new byte[16];
        public NET_DVR_IPADDR struPPPoEIP;
    }

 public static class NET_DVR_NETCFG_V30 extends Structure {
        public int dwSize;
        public NET_DVR_ETHERNET_V30[] struEtherNet = new NET_DVR_ETHERNET_V30[2];
        public NET_DVR_IPADDR[] struRes1 = new NET_DVR_IPADDR[2];
        public NET_DVR_IPADDR struAlarmHostIpAddr;
        public short[] wRes2 = new short[2];
        public short wAlarmHostIpPort;
        public byte byUseDhcp;
        public byte byRes3;
        public NET_DVR_IPADDR struDnsServer1IpAddr;
        public NET_DVR_IPADDR struDnsServer2IpAddr;
        public byte[] byIpResolver = new byte[64];
        public short wIpResolverPort;
        public short wHttpPortNo;
        public NET_DVR_IPADDR struMulticastIpAddr;
        public NET_DVR_IPADDR struGatewayIpAddr;
        public NET_DVR_PPPOECFG struPPPoE;
        public byte[] byRes = new byte[64];

        public String toString() {
            return "NET_DVR_NETCFG_V30.dwSize: " + dwSize + "\n" + "NET_DVR_NETCFG_V30.struEtherNet[0]: \n" + struEtherNet[0] + "\n" + "NET_DVR_NETCFG_V30.struAlarmHostIpAddr: \n" + struAlarmHostIpAddr + "\n" + "NET_DVR_NETCFG_V30.wAlarmHostIpPort: " + wAlarmHostIpPort + "\n" + "NET_DVR_NETCFG_V30.wHttpPortNo: " + wHttpPortNo + "\n" + "NET_DVR_NETCFG_V30.struGatewayIpAddr: \n" + struGatewayIpAddr + "\n";
        }
    }


 public static class NET_DVR_NETCFG extends Structure {//Structure de configuration du réseau
	public int dwSize;
	public NET_DVR_ETHERNET[] struEtherNet = new NET_DVR_ETHERNET[MAX_ETHERNET];	
	public byte[] sManageHostIP = new byte[16];	//Adresse de l’hôte de gestion à distance	    
	public short wManageHostPort;		    
	public byte[] sIPServerIP = new byte[16]; //Adresse du serveur IPServer          
	public byte[] sMultiCastIP = new byte[16];         
	public byte[] sGatewayIP = new byte[16];       	    
	public byte[] sNFSIP = new byte[16];			    
	public byte[] sNFSDirectory = new byte[PATHNAME_LEN];
	public int dwPPPOE;				    
	public byte[] sPPPoEUser = new byte[NAME_LEN];	    
	public byte[] sPPPoEPassword = new byte[PASSWD_LEN];
	public byte[] sPPPoEIP = new byte[16];			    
}

//Structure de l’image de canal
    public static class NET_DVR_SCHEDTIMEWEEK extends Structure {
        public NET_DVR_SCHEDTIME[] struAlarmTime = new NET_DVR_SCHEDTIME[8];
    }

     public static class byte96 extends Structure {
        public byte[] byMotionScope = new byte[96];
    }
     
  public static class NET_DVR_MOTION_V30 extends Structure {//Détection de mouvement (sous-structure) (9000 extensions)
        public byte96[] byMotionScope = new byte96[64];						
        public byte byMotionSensitive;							
        public byte byEnableHandleMotion;						
        public byte byPrecision;							
        public byte reservedData;
        public NET_DVR_HANDLEEXCEPTION_V30 struMotionHandleType;			
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS]; 
        public byte[] byRelRecordChan = new byte[64];					
    }

  public static class NET_DVR_MOTION extends Structure {
	byte[][] byMotionScope = new byte[18][22];	
	byte byMotionSensitive;		
	byte byEnableHandleMotion;	
        byte[]  reservedData = new byte[2];
        NET_DVR_HANDLEEXCEPTION strMotionHandleType;	
	byte[] byRelRecordChan = new byte[MAX_CHANNUM]; 
}

  public static class NET_DVR_HIDEALARM_V30 extends Structure {
        public int dwEnableHideAlarm;				
        public short wHideAlarmAreaTopLeftX;			
        public short wHideAlarmAreaTopLeftY;			
        public short wHideAlarmAreaWidth;				
        public short wHideAlarmAreaHeight;				
        public NET_DVR_HANDLEEXCEPTION_V30 strHideAlarmHandleType;	
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];
    }

  public static class NET_DVR_HIDEALARM extends Structure {
	public int dwEnableHideAlarm;				
	public short wHideAlarmAreaTopLeftX;			
	public short wHideAlarmAreaTopLeftY;			
	public short wHideAlarmAreaWidth;				
	public short wHideAlarmAreaHeight;				
	public NET_DVR_HANDLEEXCEPTION strHideAlarmHandleType;	
}

    public static class NET_DVR_VILOST_V30 extends Structure {    
        public byte byEnableHandleVILost;	                     
        public NET_DVR_HANDLEEXCEPTION_V30 strVILostHandleType;	    
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];
    }

public static class NET_DVR_VILOST extends Structure {    
	byte byEnableHandleVILost;	
	NET_DVR_HANDLEEXCEPTION strVILostHandleType;	
}

    public static class NET_DVR_SHELTER extends Structure {  
        public short wHideAreaTopLeftX;	
        public short wHideAreaTopLeftY;				
        public short wHideAreaWidth;				
        public short wHideAreaHeight;
    }

    public static class NET_DVR_COLOR extends Structure {
        public byte byBrightness;  	
        public byte byContrast;    	
        public byte bySaturation;  	
        public byte byHue;    
    }

    public static class NET_DVR_VICOLOR extends Structure {
        public NET_DVR_COLOR[] struColor = new NET_DVR_COLOR[MAX_TIMESEGMENT_V30];
        public NET_DVR_SCHEDTIME[] struHandleTime = new NET_DVR_SCHEDTIME[MAX_TIMESEGMENT_V30];
    };

    public static class NET_DVR_PICCFG_V30 extends Structure {
        public int dwSize;
        public byte[] sChanName = new byte[NAME_LEN];
        public int dwVideoFormat;	            
        public NET_DVR_VICOLOR struViColor;        
        public int dwShowChanName;               
        public short wShowNameTopLeftX;				
        public short wShowNameTopLeftY;				
        public NET_DVR_VILOST_V30 struVILost;      
        public NET_DVR_VILOST_V30 struAULost;	
        public NET_DVR_MOTION_V30 struMotion;      
        public NET_DVR_HIDEALARM_V30 struHideAlarm;
        public int dwEnableHide;		           
        public NET_DVR_SHELTER[] struShelter = new NET_DVR_SHELTER[4];
        public int dwShowOsd;               
        public short wOSDTopLeftX;				
        public short wOSDTopLeftY;				
        public byte byOSDType;					
        public byte byDispWeek;				
        public byte byOSDAttrib;				
        public byte byHourOSDType;				
        public byte[] byRes = new byte[64];
    }

    public static class NET_DVR_PICCFG_EX extends Structure {
	public int dwSize;
	 public byte[] sChanName = new byte[NAME_LEN];
	 public int dwVideoFormat;	
	 public byte byBrightness;  	
	 public byte byContrast;    	
	 public byte bySaturation;  	
	 public byte byHue;    			
	 public int dwShowChanName; 
	 public short wShowNameTopLeftX;				
	 public short wShowNameTopLeftY;				
	 public NET_DVR_VILOST struVILost;
	 public NET_DVR_MOTION struMotion;
	 public NET_DVR_HIDEALARM struHideAlarm;
	 public int dwEnableHide;		
	 public NET_DVR_SHELTER[] struShelter = new NET_DVR_SHELTER[MAX_SHELTERNUM];
	//OSD
	 public int dwShowOsd;
	 public short wOSDTopLeftX;				
	 public short wOSDTopLeftY;				
	 public byte byOSDType;					
	
	 public byte byDispWeek;				
	 public byte byOSDAttrib;				
	
	 public byte byHourOsdType;	
}


 public static class NET_DVR_PICCFG extends Structure { 
	 public int dwSize;
	 public byte[] sChanName = new byte[NAME_LEN];
	 public int dwVideoFormat;	
	 public byte byBrightness;  	
	 public byte byContrast;    	
	 public byte bySaturation;  	
	 public byte byHue;    			
	
	 public int dwShowChanName; 
	 public short wShowNameTopLeftX;				
	 public short wShowNameTopLeftY;				
	 public NET_DVR_VILOST struVILost;
	 public NET_DVR_MOTION struMotion;
	 public NET_DVR_HIDEALARM struHideAlarm;
	 public int dwEnableHide;		
	 public short wHideAreaTopLeftX;				
	 public short wHideAreaTopLeftY;				
	 public short wHideAreaWidth;				
	 public short wHideAreaHeight;				
	//OSD
	 public int dwShowOsd;
	 public short wOSDTopLeftX;				
	 public short wOSDTopLeftY;				
	 public byte byOSDType;					
	
	byte byDispWeek;				
	byte byOSDAttrib;				
	
	 public byte reservedData2;
}

    public static class NET_DVR_COMPRESSION_INFO_V30 extends Structure {
        public byte byStreamType;		
        public byte byResolution;  	
        public byte byBitrateType;		
        public byte byPicQuality;		
        public int dwVideoBitrate; 
        public int dwVideoFrameRate;	
        public short wIntervalFrameI; 
        public byte byIntervalBPFrame;
        public byte byENumber;       
        public byte byVideoEncType;
        public byte byAudioEncType;
        public byte[] byres = new byte[10];
    }

  //Paramètres de compression du canal (extension 9000)
    public static class NET_DVR_COMPRESSIONCFG_V30 extends Structure {
        public int dwSize;
        public NET_DVR_COMPRESSION_INFO_V30 struNormHighRecordPara;  
        public NET_DVR_COMPRESSION_INFO_V30 struRes;   //conserver la chaine String[28];
        public NET_DVR_COMPRESSION_INFO_V30 struEventRecordPara;//Paramètres de compression du déclencheur d'événement
        public NET_DVR_COMPRESSION_INFO_V30 struNetPara; //Transmission réseau (sous-flux)
    }


    public static class NET_DVR_COMPRESSION_INFO extends Structure {
	public byte byStreamType;		
	public byte byResolution;  
	public byte byBitrateType;		
	public byte  byPicQuality;		
	public int dwVideoBitrate; 					
	public int dwVideoFrameRate;	
}

    public static class NET_DVR_COMPRESSIONCFG extends Structure {
	public int dwSize;
	public NET_DVR_COMPRESSION_INFO struRecordPara; 
	public NET_DVR_COMPRESSION_INFO struNetPara;	
}


    public static class NET_DVR_COMPRESSION_INFO_EX extends Structure {
	public byte byStreamType;	
	public byte byResolution;  	
	public byte byBitrateType;		
	public byte  byPicQuality;		
	public int dwVideoBitrate; 	 
	public int dwVideoFrameRate;	
	public short  wIntervalFrameI;  
	public byte  byIntervalBPFrame;
	public byte  byENumber;
}

    public static class NET_DVR_COMPRESSIONCFG_EX extends Structure {
	public int dwSize;
	public NET_DVR_COMPRESSION_INFO_EX struRecordPara; 
	public NET_DVR_COMPRESSION_INFO_EX struNetPara;	
}

    public static class NET_DVR_RECCOMPRESSIONCFG_EX extends Structure {
	int dwSize;
	NET_DVR_COMPRESSION_INFO_EX[][]  struRecTimePara = new NET_DVR_COMPRESSION_INFO_EX[MAX_DAYS][MAX_TIMESEGMENT]; //période d'enregistrement 
}

    public static class NET_DVR_RECORDSCHED extends Structure
  //Configuration des paramètres d'enregistrement de la période de temps (sous-structure)
    {
        public  NET_DVR_SCHEDTIME struRecordTime = new NET_DVR_SCHEDTIME() ;
        public byte byRecordType;//0 : Enregistrement programmé, 1 : Détection de mouvement, 2 : Enregistrement d'alarme, 3 : Détection de mouvement|alarme, 4 : Détection de mouvement et alarme, 5 : Déclencheur de commande, 6 : Enregistrement intelligent
        public byte[] reservedData = new byte[3];
    }

    public static class NET_DVR_RECORDDAY extends Structure
    {
        public short wAllDayRecord;				
        public byte byRecordType;				
        public byte reservedData;
    }

    public static class NET_DVR_RECORDSCHEDWEEK extends Structure
    {
       public 	NET_DVR_RECORDSCHED[] struRecordSched = new NET_DVR_RECORDSCHED[MAX_TIMESEGMENT_V30];
    }

    public static class NET_DVR_RECORD_V30 extends Structure {
        public int dwSize;
        public int dwRecord;  						
        public NET_DVR_RECORDDAY[] struRecAllDay = new NET_DVR_RECORDDAY[MAX_DAYS];
        public NET_DVR_RECORDSCHEDWEEK[] struRecordSched = new NET_DVR_RECORDSCHEDWEEK[MAX_DAYS];
        public int dwRecordTime;					
        public int dwPreRecordTime;				
        public int dwRecorderDuration;				
        public byte byRedundancyRec;	
        public byte byAudioRec;		
        public byte[] byReserve = new byte[10];
    }

 public static class NET_DVR_RECORD extends Structure { 
	 public int dwSize;
	 public int dwRecord; 
	 public NET_DVR_RECORDDAY[]  struRecAllDay = new NET_DVR_RECORDDAY[MAX_DAYS];
         public NET_DVR_RECORDSCHEDWEEK[] struRecordSched = new NET_DVR_RECORDSCHEDWEEK[MAX_DAYS];
	 public int dwRecordTime;	
	 public int dwPreRecordTime;	
}

 public static class NET_DVR_PTZ_PROTOCOL extends Structure {
       public int dwType;               
       public byte[]  byDescribe = new byte[DESC_LEN]; 
}

 public static class NET_DVR_PTZCFG extends Structure {
       public  int   dwSize;
       public  NET_DVR_PTZ_PROTOCOL[] struPtz = new NET_DVR_PTZ_PROTOCOL[PTZ_PROTOCOL_NUM];
       public  int   dwPtzNum;          
       public  byte[]  byRes = new byte[8];
}
 public static class NET_DVR_DECODERCFG_V30 extends Structure {
	public int dwSize;
	public int dwBaudRate;      
	public byte byDataBit; 
	public byte byStopBit;         
	public byte byParity;          
	public byte byFlowcontrol;     
	public short wDecoderType;      
	public short wDecoderAddress;	
	public byte[] bySetPreset = new byte[MAX_PRESET_V30];		
	public byte[] bySetCruise = new byte[MAX_CRUISE_V30];		
	public byte[] bySetTrack = new byte[MAX_TRACK_V30];		    
}

 public static class NET_DVR_DECODERCFG extends Structure {
	public int dwSize;
	public int dwBaudRate;       
	public byte byDataBit;        
	public byte byStopBit;        
	public byte byParity;          
	public byte byFlowcontrol;     
	public short wDecoderType;     
	public short wDecoderAddress;	
	public byte[] bySetPreset = new byte[MAX_PRESET];		
	public byte[] bySetCruise = new byte[MAX_CRUISE];		
	public byte[] bySetTrack = new byte[MAX_TRACK];		    
}

public static class NET_DVR_PPPCFG_V30 extends Structure {
	public NET_DVR_IPADDR struRemoteIP;
	public NET_DVR_IPADDR struLocalIP;		
	public byte[] sLocalIPMask = new byte[16];			
	public byte[] sUsername = new byte[NAME_LEN];		
	public byte[] sPassword = new byte[PASSWD_LEN];		
	public byte byPPPMode;					
	public byte byRedial;					
	public byte byRedialMode;				
	public byte byDataEncrypt;				
	public int dwMTU;					
	public byte[] sTelephoneNumber = new byte[PHONENUMBER_LEN];   
}

public static class NET_DVR_PPPCFG extends Structure {
	public byte[] sRemoteIP = new byte[16];				
	public byte[] sLocalIP = new byte[16];				
	public byte[] sLocalIPMask = new byte[16];			
	public byte[] sUsername = new byte[NAME_LEN];		
	public byte[] sPassword = new byte[PASSWD_LEN];		
	public byte byPPPMode;					
	public byte byRedial;					
	public byte byRedialMode;				
	public byte byDataEncrypt;				
	public int dwMTU;					
	public byte[] sTelephoneNumber = new byte[PHONENUMBER_LEN];  
}


public static class NET_DVR_SINGLE_RS232 extends Structure {
       public int dwBaudRate;   
       public byte byDataBit;    
       public byte byStopBit;    
       public byte byParity;      
       public byte byFlowcontrol; 
       public int dwWorkMode; 
}

public static class NET_DVR_RS232CFG_V30 extends Structure {
	public int dwSize;
        public NET_DVR_SINGLE_RS232 struRs232;
	public byte[] byRes = new byte[84];
        public NET_DVR_PPPCFG_V30 struPPPConfig;
}

public static class NET_DVR_RS232CFG extends Structure {
	public int dwSize;
	public int dwBaudRate;
	public byte byDataBit;
	public byte byStopBit;
	public byte byParity;
	public byte byFlowcontrol;
	public int dwWorkMode;
	public NET_DVR_PPPCFG struPPPConfig;
}

public static class NET_DVR_ALARMINCFG_V30 extends Structure {
        public 	int dwSize;
        public 	byte[] sAlarmInName = new byte[NAME_LEN];	
        public 	byte byAlarmType;	           
        public 	byte byAlarmInHandle;	       
        public    byte[] reservedData = new byte[2];
	public NET_DVR_HANDLEEXCEPTION_V30 struAlarmHandleType;	
	public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];
	public byte[] byRelRecordChan = new byte[MAX_CHANNUM_V30]; 
	public byte[] byEnablePreset = new byte[MAX_CHANNUM_V30];		
	public byte[] byPresetNo = new byte[MAX_CHANNUM_V30];			
	public byte[] byEnablePresetRevert = new byte[MAX_CHANNUM_V30]; 
	public short[] wPresetRevertDelay = new short[MAX_CHANNUM_V30];	
	public byte[] byEnableCruise = new byte[MAX_CHANNUM_V30];		
	public byte[] byCruiseNo = new byte[MAX_CHANNUM_V30];			
	public byte[] byEnablePtzTrack = new byte[MAX_CHANNUM_V30];		
	public byte[] byPTZTrack = new byte[MAX_CHANNUM_V30];			
        public   byte[] byRes = new byte[16];
}

public static class NET_DVR_ALARMINCFG extends Structure {
	public int dwSize;
	public byte[] sAlarmInName = new byte[NAME_LEN];	
	public byte byAlarmType;	
	public byte byAlarmInHandle;	
	public NET_DVR_HANDLEEXCEPTION struAlarmHandleType;	
        public  NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];
	public byte[] byRelRecordChan = new byte[MAX_CHANNUM]; 
	public byte[] byEnablePreset = new byte[MAX_CHANNUM];		
	public byte[] byPresetNo = new byte[MAX_CHANNUM];			
	public byte[] byEnableCruise = new byte[MAX_CHANNUM];		
	public byte[] byCruiseNo = new byte[MAX_CHANNUM];			
	public byte[] byEnablePtzTrack = new byte[MAX_CHANNUM];		
	public byte[] byPTZTrack = new byte[MAX_CHANNUM];			
}

public static class NET_DVR_ADDIT_POSITION extends Structure {
	public byte[]	sDevName = new byte[32];		
	public int	dwSpeed;			
	public int	dwLongitude;		
	public int	dwLatitude;       
	public byte[]	direction = new byte[2];   
	public byte[]  res = new byte[2];             
}

public static class NET_DVR_ALARMINFO_V30 extends Structure {
	public int dwAlarmType;
	public int dwAlarmInputNumber;
	public byte[]  byAlarmOutputNumber = new byte[MAX_ALARMOUT_V30];
	public byte[]  byAlarmRelateChannel= new byte[MAX_CHANNUM_V30];
	public byte[]  byChannel= new byte[MAX_CHANNUM_V30];
	public byte[]  byDiskNumber= new byte[MAX_DISKNUM_V30];
}

public static class NET_DVR_ALARMINFO extends Structure {
	public int dwAlarmType;
	public int dwAlarmInputNumber;
	public int[] dwAlarmOutputNumber = new int[MAX_ALARMOUT];
	public int[] dwAlarmRelateChannel = new int[MAX_CHANNUM];
	public int[] dwChannel = new int[MAX_CHANNUM];
	public int[] dwDiskNumber = new int[MAX_DISKNUM];
}

public static class NET_DVR_ALARMINFO_EX extends Structure {
	public int dwAlarmType;
	public int dwAlarmInputNumber;
	public int[] dwAlarmOutputNumber = new int[MAX_ALARMOUT];
	public int[] dwAlarmRelateChannel = new int[MAX_CHANNUM];
	public int[] dwChannel = new int[MAX_CHANNUM];
	public int[] dwDiskNumber = new int[MAX_DISKNUM];
	public byte[] sSerialNumber = new byte[SERIALNO_LEN];  
	public byte[]  sRemoteAlarmIP = new byte[16];			
}

public static class NET_DVR_IPDEVINFO extends Structure {
       public   int dwEnable;				    
       public   byte[] sUserName = new byte[NAME_LEN];		
       public   byte[] sPassword = new byte[PASSWD_LEN];	   
       public   NET_DVR_IPADDR struIP = new NET_DVR_IPADDR();			
       public   short wDVRPort;			 	    
       public   byte[] byres = new byte[34];				
}

public static class NET_DVR_IPCHANINFO extends Structure {
       public   byte byEnable;					
       public  byte byIPID;					
       public  byte byChannel;					
       public   byte[] byres = new byte[33];				
}

public static class NET_DVR_IPPARACFG extends Structure {
       public  int dwSize;			                         
       public  NET_DVR_IPDEVINFO[]  struIPDevInfo = new NET_DVR_IPDEVINFO[MAX_IP_DEVICE]; 
       public   byte[] byAnalogChanEnable = new byte[MAX_ANALOG_CHANNUM];      
       public NET_DVR_IPCHANINFO[] struIPChanInfo = new NET_DVR_IPCHANINFO[MAX_IP_CHANNEL];	
}

public static class NET_DVR_IPALARMOUTINFO extends Structure {
       public  byte byIPID;					
       public  byte byAlarmOut;				
       public  byte[] byRes = new byte[18];					
}

public static class NET_DVR_IPALARMOUTCFG extends Structure {
       public  int dwSize;			                        
       public  NET_DVR_IPALARMOUTINFO[] struIPAlarmOutInfo = new NET_DVR_IPALARMOUTINFO[MAX_IP_ALARMOUT];
}

public static class NET_DVR_IPALARMININFO extends Structure {
       public  byte byIPID;					
       public  byte byAlarmIn;				
       public  byte[] byRes = new byte[18];					
}

public static class NET_DVR_IPALARMINCFG extends Structure {
       public  int dwSize;			                       
       public NET_DVR_IPALARMININFO[] struIPAlarmInInfo = new NET_DVR_IPALARMININFO[MAX_IP_ALARMIN];
}

public static class NET_DVR_IPALARMINFO extends Structure {
       public  NET_DVR_IPDEVINFO[]  struIPDevInfo = new NET_DVR_IPDEVINFO[MAX_IP_DEVICE]; 
       public  byte[] byAnalogChanEnable = new byte[MAX_ANALOG_CHANNUM];
       public  NET_DVR_IPCHANINFO[] struIPChanInfo = new NET_DVR_IPCHANINFO[MAX_IP_CHANNEL];
       public NET_DVR_IPALARMININFO[] struIPAlarmInInfo = new NET_DVR_IPALARMININFO[MAX_IP_ALARMIN]; 
       public NET_DVR_IPALARMOUTINFO[] struIPAlarmOutInfo = new NET_DVR_IPALARMOUTINFO[MAX_IP_ALARMOUT];
}

public static class NET_DVR_SINGLE_HD extends Structure {
       public int dwHDNo;         
       public int dwCapacity;     
       public int dwFreeSpace;    
       public int dwHdStatus;     
       public byte  byHDAttr;      
       public byte[]  byRes1 = new byte[3];
       public  int dwHdGroup;   
       public  byte[]  byRes2 = new byte[120];
}

public static class NET_DVR_HDCFG extends Structure {
       public  int dwSize;
       public  int dwHDCount;
       public  NET_DVR_SINGLE_HD[] struHDInfo = new NET_DVR_SINGLE_HD[MAX_DISKNUM_V30];
}

public static class NET_DVR_SINGLE_HDGROUP extends Structure {
       public  int dwHDGroupNo;    
       public  byte[] byHDGroupChans = new byte[64]; 
       public  byte[] byRes = new byte[8];
}

public static class NET_DVR_HDGROUP_CFG extends Structure {
       public int dwSize;
       public  int dwHDGroupCount;
       public  NET_DVR_SINGLE_HDGROUP[] struHDGroupAttr = new NET_DVR_SINGLE_HDGROUP[MAX_HD_GROUP];
}

public static class NET_DVR_SCALECFG extends Structure {
       public  int dwSize;
       public  int dwMajorScale;  
       public  int dwMinorScale;  
       public  int[] dwRes = new int[2];
}

public static class NET_DVR_ALARMOUTCFG_V30 extends Structure {
	public int dwSize;
	public byte[] sAlarmOutName = new byte[NAME_LEN];	
	public int dwAlarmOutDelay;	
	public NET_DVR_SCHEDTIMEWEEK[] struAlarmOutTime= new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];
    public     byte[] byRes = new byte[16];
}

public static class NET_DVR_ALARMOUTCFG extends Structure {
	public int dwSize;
	public byte[] sAlarmOutName = new byte[NAME_LEN];	
	public int dwAlarmOutDelay;	

	public NET_DVR_SCHEDTIMEWEEK[] struAlarmOutTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];
}

public static class NET_DVR_PREVIEWCFG_V30 extends Structure {
       public  int dwSize;
       public  byte byPreviewNumber;
       public  byte byEnableAudio;
       public  short wSwitchTime;
       public  byte[][] bySwitchSeq = new byte[MAX_PREVIEW_MODE][MAX_WINDOW_V30];
       public  byte[] byRes = new byte[24];
}

public static class NET_DVR_PREVIEWCFG extends Structure {
	public int dwSize;
	public byte byPreviewNumber;
	public byte byEnableAudio;
	public short wSwitchTime;
	public byte[] bySwitchSeq = new byte[MAX_WINDOW];
}

public static class NET_DVR_VGAPARA extends Structure {
	public short wResolution;							
	public short wFreq;									
	public int dwBrightness;							
}


public static class NET_DVR_MATRIXPARA_V30 extends Structure {
	public short[]	wOrder = new short[MAX_ANALOG_CHANNUM];		
	public short	wSwitchTime;				   
	public byte[]	res = new byte[14];
}

public static class NET_DVR_MATRIXPARA extends Structure {
	public short wDisplayLogo;						
	public short wDisplayOsd;						
}

public static class NET_DVR_VOOUT extends Structure {
	public byte byVideoFormat;						
	public byte byMenuAlphaValue;					
	public short wScreenSaveTime;					
	public short wVOffset;							
	public short wBrightness;						
	public byte byStartMode;						
	public byte byEnableScaler;                    
}

public static class NET_DVR_VIDEOOUT_V30 extends Structure {
	public int dwSize;
	public NET_DVR_VOOUT[] struVOOut = new NET_DVR_VOOUT[MAX_VIDEOOUT_V30];
	public NET_DVR_VGAPARA[] struVGAPara = new NET_DVR_VGAPARA[MAX_VGA_V30];	
	public NET_DVR_MATRIXPARA_V30[] struMatrixPara = new NET_DVR_MATRIXPARA_V30[MAX_MATRIXOUT];		
        public   byte[] byRes = new byte[16];
}

public static class NET_DVR_VIDEOOUT extends Structure {
	public int dwSize;
	public NET_DVR_VOOUT[] struVOOut = new NET_DVR_VOOUT[MAX_VIDEOOUT];
	public NET_DVR_VGAPARA[] struVGAPara = new NET_DVR_VGAPARA[MAX_VGA];	
	public NET_DVR_MATRIXPARA struMatrixPara;		
}

public static class NET_DVR_USER_INFO_V30 extends Structure {
	public byte[] sUserName = new byte[NAME_LEN];		
	public byte[] sPassword = new byte[PASSWD_LEN];		
        public byte[] byLocalRight = new byte[MAX_RIGHT];	

	public byte[] byRemoteRight = new byte[MAX_RIGHT];

	public byte[] byNetPreviewRight = new byte[MAX_CHANNUM_V30];		
	public byte[] byLocalPlaybackRight = new byte[MAX_CHANNUM_V30];	    
	public byte[] byNetPlaybackRight = new byte[MAX_CHANNUM_V30];	    
	public byte[] byLocalRecordRight = new byte[MAX_CHANNUM_V30];		
	public byte[] byNetRecordRight = new byte[MAX_CHANNUM_V30];		    
	public byte[] byLocalPTZRight = new byte[MAX_CHANNUM_V30];		    
	public byte[] byNetPTZRight = new byte[MAX_CHANNUM_V30];			
	public byte[] byLocalBackupRight = new byte[MAX_CHANNUM_V30];		
	public NET_DVR_IPADDR struUserIP;		
	public byte[] byMACAddr = new byte[MACADDR_LEN];	
	public byte byPriority;				
                                 
	public byte[] byRes = new byte[17];
}

public static class NET_DVR_USER_INFO_EX extends Structure {
	public byte[] sUserName = new byte[NAME_LEN];		
	public byte[] sPassword = new byte[PASSWD_LEN];		
	public int[] dwLocalRight = new int[MAX_RIGHT];	

	public int dwLocalPlaybackRight;		
	public int[] dwRemoteRight = new int[MAX_RIGHT];	

	public int dwNetPreviewRight;		
	public int dwNetPlaybackRight;		
	public byte[] sUserIP = new byte[16];			
	public byte[] byMACAddr = new byte[MACADDR_LEN];	
}

public static class NET_DVR_USER_INFO extends Structure {
	public byte[] sUserName = new byte[NAME_LEN];		
	public byte[] sPassword = new byte[PASSWD_LEN];		
	public int[] dwLocalRight = new int[MAX_RIGHT];	

	public int[] dwRemoteRight = new int[MAX_RIGHT];

	public byte[] sUserIP = new byte[16];				
	public byte[] byMACAddr = new byte[MACADDR_LEN];	
}

public static class NET_DVR_USER_V30 extends Structure {
	public int dwSize;
	public NET_DVR_USER_INFO_V30[] struUser = new NET_DVR_USER_INFO_V30[MAX_USERNUM_V30];
}

public static class NET_DVR_USER_EX extends Structure {
	public int dwSize;
	public NET_DVR_USER_INFO_EX[] struUser = new NET_DVR_USER_INFO_EX[MAX_USERNUM];
}

public static class NET_DVR_USER extends Structure {
	public int dwSize;
	public NET_DVR_USER_INFO[] struUser = new NET_DVR_USER_INFO[MAX_USERNUM];
}

public static class NET_DVR_EXCEPTION_V30 extends Structure {
	public int dwSize;
	public NET_DVR_HANDLEEXCEPTION_V30[] struExceptionHandleType = new NET_DVR_HANDLEEXCEPTION_V30[MAX_EXCEPTIONNUM_V30];
	
}

public static class NET_DVR_EXCEPTION extends Structure {
	public int dwSize;
	public NET_DVR_HANDLEEXCEPTION[] struExceptionHandleType = new NET_DVR_HANDLEEXCEPTION[MAX_EXCEPTIONNUM];
}

public static class NET_DVR_CHANNELSTATE_V30 extends Structure {
	public byte byRecordStatic; 
	public byte bySignalStatic; 
	public byte byHardwareStatic;
	public byte reservedData;		
	public int dwBitRate;
	public int dwLinkNum;
	public NET_DVR_IPADDR[] struClientIP = new NET_DVR_IPADDR[MAX_LINK];
        public  int dwIPLinkNum;
        public  byte[] byRes = new byte[12];
}

public static class NET_DVR_CHANNELSTATE extends Structure {
	public byte byRecordStatic; 
	public byte bySignalStatic; 
	public byte byHardwareStatic;
	public byte reservedData;		
	public int dwBitRate;
	public int dwLinkNum;
	public int[] dwClientIP = new int[MAX_LINK];
}

public static class NET_DVR_DISKSTATE extends Structure {
	public int dwVolume;
	public int dwFreeSpace;
	public int dwHardDiskStatic; 
}

public static class NET_DVR_WORKSTATE_V30 extends Structure {
	public int dwDeviceStatic; 	
	public NET_DVR_DISKSTATE[]  struHardDiskStatic = new NET_DVR_DISKSTATE[MAX_DISKNUM_V30];
	public NET_DVR_CHANNELSTATE_V30[] struChanStatic = new NET_DVR_CHANNELSTATE_V30[MAX_CHANNUM_V30];
	public byte[]  byAlarmInStatic = new byte[MAX_ALARMIN_V30]; 
	public byte[]  byAlarmOutStatic = new byte[MAX_ALARMOUT_V30]; 
	public int  dwLocalDisplay;
        public  byte [] byAudioChanStatus = new byte[MAX_AUDIO_V30];
        public  byte[]  byRes = new byte[10];
}

public static class NET_DVR_WORKSTATE extends Structure {
	public int dwDeviceStatic; 	
	public NET_DVR_DISKSTATE[]  struHardDiskStatic = new NET_DVR_DISKSTATE[MAX_DISKNUM];
	public NET_DVR_CHANNELSTATE[] struChanStatic = new NET_DVR_CHANNELSTATE[MAX_CHANNUM];
	public byte[]  byAlarmInStatic = new byte[MAX_ALARMIN]; 
	public byte[]  byAlarmOutStatic = new byte[MAX_ALARMOUT]; 
	public int  dwLocalDisplay;
}

public static class NET_DVR_LOG_V30 extends Structure {
	public NET_DVR_TIME strLogTime;
	public int	dwMajorType;	
	public int	dwMinorType;
	public byte[]	sPanelUser = new byte[MAX_NAMELEN]; 
	public byte[]	sNetUser = new byte[MAX_NAMELEN];
	public NET_DVR_IPADDR	struRemoteHostAddr;
	public int	dwParaType;
	public int	dwChannel;
	public int	dwDiskNumber;
	public int	dwAlarmInPort;
	public int	dwAlarmOutPort;
       public  int     dwInfoLen;
       public  byte[]    sInfo = new byte[LOG_INFO_LEN];
}

public static class NET_DVR_LOG extends Structure {
	public NET_DVR_TIME strLogTime;
	public int	dwMajorType;	
	public int	dwMinorType;
	public byte[]	sPanelUser = new byte[MAX_NAMELEN]; 
	public byte[]	sNetUser = new byte[MAX_NAMELEN];
	public byte[]	sRemoteHostAddr = new byte[16];
	public int	dwParaType;
	public int	dwChannel;
	public int	dwDiskNumber;
	public int	dwAlarmInPort;
	public int	dwAlarmOutPort;
}

public static class NET_DVR_ALARMOUTSTATUS_V30 extends Structure {
	public byte[] Output = new byte[MAX_ALARMOUT_V30];
}

public static class NET_DVR_ALARMOUTSTATUS extends Structure {
	public byte[] Output = new byte[MAX_ALARMOUT];
}

public static class NET_DVR_TRADEINFO extends Structure {
	public short m_Year;
	public short m_Month;
	public short m_Day;
	public short m_Hour;
	public short m_Minute;
	public short m_Second;
	public byte[] DeviceName = new byte[24];	
	public int dwChannelNumer;	
	public byte[] CardNumber = new byte[32];	
	public byte[] cTradeType = new byte[12];	
	public int dwCash;			
}

public static class NET_DVR_FRAMETYPECODE extends Structure {
	public byte[] code = new byte[12];		
}

public static class NET_DVR_FRAMEFORMAT_V30 extends Structure {
	public int	dwSize;
	public NET_DVR_IPADDR	struATMIP;               	
	public int	dwATMType;							
	public int	dwInputMode;						
	public int	dwFrameSignBeginPos;				
	public int	dwFrameSignLength;					
	public byte[]	byFrameSignContent = new byte[12];				
	public int	dwCardLengthInfoBeginPos;			
	public int	dwCardLengthInfoLength;				
	public int	dwCardNumberInfoBeginPos;			
	public int	dwCardNumberInfoLength;				
	public int	dwBusinessTypeBeginPos;				
	public int	dwBusinessTypeLength;				
	public NET_DVR_FRAMETYPECODE[]	frameTypeCode = new NET_DVR_FRAMETYPECODE[10];	
	public short	wATMPort;							
	public short	wProtocolType;						
        public byte[]   byRes = new byte[24];
}

public static class NET_DVR_FRAMEFORMAT extends Structure {
	public int dwSize;
	public byte[] sATMIP = new byte[16];						
	public int dwATMType;						
	public int dwInputMode;						
	public int dwFrameSignBeginPos;              
	public int dwFrameSignLength;				
	public byte[]  byFrameSignContent = new byte[12];			
	public int dwCardLengthInfoBeginPos;			
	public int dwCardLengthInfoLength;			
	public int dwCardNumberInfoBeginPos;			
	public int dwCardNumberInfoLength;			
	public int dwBusinessTypeBeginPos;          
	public int dwBusinessTypeLength;				
	public NET_DVR_FRAMETYPECODE[] frameTypeCode = new NET_DVR_FRAMETYPECODE[10];
}

public static class NET_DVR_FTPTYPECODE extends Structure {
	public byte[] sFtpType = new byte[32];     
	public byte[] sFtpCode = new byte[8];      
}

public static class NET_DVR_FRAMEFORMAT_EX extends Structure {
	public int dwSize;
	public byte[] sATMIP = new byte[16];						
	public int dwATMType;						
	public int dwInputMode;						
	public int dwFrameSignBeginPos;              
	public int dwFrameSignLength;				
	public byte[]  byFrameSignContent = new byte[12];			
	public int dwCardLengthInfoBeginPos;			
	public int dwCardLengthInfoLength;			
	public int dwCardNumberInfoBeginPos;			
	public int dwCardNumberInfoLength;			
	public int dwBusinessTypeBeginPos;           
	public int dwBusinessTypeLength;				
	public NET_DVR_FRAMETYPECODE[] frameTypeCode = new NET_DVR_FRAMETYPECODE[10];
	public byte[] sFTPIP = new byte[16];						
	public byte[] byFtpUsername = new byte[NAME_LEN];			
	public byte[] byFtpPasswd = new byte[PASSWD_LEN];			
	public byte[] sDirName = new byte[NAME_LEN];				
	public int dwATMSrvType;						
	public int dwTimeSpace;						/*å�–å€¼ä¸º1.2.3.4.5.10*/
	public NET_DVR_FTPTYPECODE[] sFtpTypeCodeOp = new NET_DVR_FTPTYPECODE[300];    
	public int dwADPlay;   
	public int dwNewPort; 
}
/****************************ATM(end)***************************/

/*****************************DS-6001D/F(begin)***************************/
//DS-6001D Decoder
public static class NET_DVR_DECODERINFO extends Structure {
	public byte[] byEncoderIP = new byte[16];		
	public byte[] byEncoderUser = new byte[16];		
	public byte[] byEncoderPasswd = new byte[16];	
	public byte bySendMode;			
	public byte byEncoderChannel;		
	public short wEncoderPort;			
	public byte[] reservedData = new byte[4];		
}

public static class NET_DVR_DECODERSTATE extends Structure {
	public byte[] byEncoderIP = new byte[16];		
	public byte[] byEncoderUser = new byte[16];		
	public byte[] byEncoderPasswd = new byte[16];	
	public byte byEncoderChannel;		
	public byte bySendMode;			
	public short wEncoderPort;			
	public int dwConnectState;		
	public byte[] reservedData = new byte[4];		
}

public static class NET_DVR_DECCHANINFO extends Structure {
	public byte[] sDVRIP = new byte[16];				
	public short wDVRPort;			 		
	public byte[] sUserName = new byte[NAME_LEN];		
	public byte[] sPassword = new byte[PASSWD_LEN];		
	public byte byChannel;					
	public byte byLinkMode;				
	public byte byLinkType;				
}

public static class NET_DVR_DECINFO extends Structure {
	public byte	byPoolChans;			
	public NET_DVR_DECCHANINFO[] struchanConInfo = new NET_DVR_DECCHANINFO[MAX_DECPOOLNUM];
	public byte	byEnablePoll;			
	public byte	byPoolTime;				
}

public static class NET_DVR_DECCFG extends Structure {
	public int	dwSize;
	public int	dwDecChanNum; 		
	public NET_DVR_DECINFO[] struDecInfo = new NET_DVR_DECINFO[MAX_DECNUM];
}


public static class NET_DVR_PORTINFO extends Structure {
	public int dwEnableTransPort;	
	public byte[] sDecoderIP = new byte[16];		
	public short wDecoderPort;			
	public short wDVRTransPort;			
	public byte[] cReserve = new byte[4];
}

public static class NET_DVR_PORTCFG extends Structure {
	public int dwSize;
	public NET_DVR_PORTINFO[] struTransPortInfo = new NET_DVR_PORTINFO[MAX_TRANSPARENTNUM]; 
}

public static class NET_DVR_PLAYREMOTEFILE extends Structure {
	public int dwSize;
	public byte[] sDecoderIP = new byte[16];		
	public short wDecoderPort;			
	public short wLoadMode;				
        public   byte[] byFile = new byte[100];
        public static class mode_size extends Union
	{
		public byte[] byFile = new byte[100];		
		public static class bytime extends Structure
		{
			public int dwChannel;
			public byte[] sUserName = new byte[NAME_LEN];	
			public byte[] sPassword = new byte[PASSWD_LEN];	
			public NET_DVR_TIME struStartTime;	
			public NET_DVR_TIME struStopTime;	
		}
	}
}

public static class NET_DVR_DECCHANSTATUS extends Structure {
	public int dwWorkType;		
	public byte[] sDVRIP = new byte[16];		
	public short wDVRPort;			
	public byte byChannel;			
	public byte byLinkMode;		
	public int	dwLinkType;		
	public byte[] sUserName = new byte[NAME_LEN];	
	public byte[] sPassword = new byte[PASSWD_LEN];	
	public byte[] cReserve = new byte[52];
        public static class objectInfo extends Union
	{
		public static class userInfo extends Structure
		{
			public byte[] sUserName = new byte[NAME_LEN];	
			public byte[] sPassword = new byte[PASSWD_LEN];	
			public byte[] cReserve = new byte[52];
		}
		public static class fileInfo extends Structure
		{
			public byte[]  fileName = new byte[100];
		}
		public static class timeInfo extends Structure
		{
			public int	dwChannel;
			public byte[] sUserName = new byte[NAME_LEN];	
			public byte[] sPassword = new byte[PASSWD_LEN];	
			public NET_DVR_TIME struStartTime;		
			public NET_DVR_TIME struStopTime;		
		}
	}
}

public static class NET_DVR_DECSTATUS extends Structure {
	public int   dwSize;
	public NET_DVR_DECCHANSTATUS[] struDecState = new NET_DVR_DECCHANSTATUS[MAX_DECNUM];
}

public static class NET_DVR_SHOWSTRINGINFO extends Structure {
	public short wShowString;				
	public short wStringSize;				
	public short wShowStringTopLeftX;		
	public short wShowStringTopLeftY;		
	public byte[] sString = new byte[44];				
}

public static class NET_DVR_SHOWSTRING_V30 extends Structure {
	public int dwSize;
	public NET_DVR_SHOWSTRINGINFO[] struStringInfo = new NET_DVR_SHOWSTRINGINFO[MAX_STRINGNUM_V30];				
}

public static class NET_DVR_SHOWSTRING_EX extends Structure {
	public int dwSize;
	public NET_DVR_SHOWSTRINGINFO[] struStringInfo = new NET_DVR_SHOWSTRINGINFO[MAX_STRINGNUM_EX];				
}

public static class NET_DVR_SHOWSTRING extends Structure {
	public int dwSize;
	public NET_DVR_SHOWSTRINGINFO[] struStringInfo = new NET_DVR_SHOWSTRINGINFO[MAX_STRINGNUM];				
}


    public static class NET_DVR_SENDER extends Structure {
       public  byte[] sName = new byte[NAME_LEN];				
       public   byte[] sAddress = new byte[MAX_EMAIL_ADDR_LEN];		
    }
       public static class NET_DVRRECEIVER extends Structure {
       public  byte[]	sName = new byte[NAME_LEN];				
       public  byte[]	sAddress = new byte[MAX_EMAIL_ADDR_LEN];	
    }

    public static class NET_DVR_EMAILCFG_V30 extends Structure {
	public int		dwSize;
	public byte[]		sAccount = new byte[NAME_LEN];				
	public byte[]		sPassword = new byte[MAX_EMAIL_PWD_LEN];			
        public   NET_DVR_SENDER struSender;
	public byte[]		sSmtpServer  = new byte[MAX_EMAIL_ADDR_LEN];	/* smtp*/
	public byte[]		sPop3Server = new byte[MAX_EMAIL_ADDR_LEN];	/* pop3 */
	public NET_DVRRECEIVER[] struReceiver = new NET_DVRRECEIVER[3];							
	public byte		byAttachment;					
	public byte		bySmtpServerVerify;				
        public  byte        byMailInterval;                 /* mail interval */
        public  byte[]        res = new byte[77];
}

    public static class NET_DVR_CRUISE_PARA extends Structure {
	public int 	dwSize;
	public byte[]	byPresetNo = new byte[CRUISE_MAX_PRESET_NUMS];		
	public byte[] 	byCruiseSpeed = new byte[CRUISE_MAX_PRESET_NUMS];	
	public short[]	wDwellTime = new short[CRUISE_MAX_PRESET_NUMS];		
	public byte[]	byEnableThisCruise;						
	public byte[]	res = new byte[15];
}


    public static class NET_DVR_TIMEPOINT extends Structure {
	public int dwMonth;		
	public int dwWeekNo;		
	public int dwWeekDate;	
	public int dwHour;		
	public int dwMin;		
}

    public static class NET_DVR_ZONEANDDST extends Structure {
	public int dwSize;
	public byte[] byRes1 = new byte[16];			
	public int dwEnableDST;		
	public byte byDSTBias;	
	public byte[] byRes2 = new byte[3];
	public NET_DVR_TIMEPOINT struBeginPoint;	
	public NET_DVR_TIMEPOINT struEndPoint;	
}

    public static class NET_DVR_JPEGPARA extends Structure {
	public short	wPicSize;				
	public short	wPicQuality;			
    }

    public static class NET_DVR_AUXOUTCFG extends Structure {
	public int dwSize;
	public int dwAlarmOutChan;                       
	public int dwAlarmChanSwitchTime;               
	public int[] dwAuxSwitchTime = new int[MAX_AUXOUT];			
	public byte[][]  byAuxOrder = new byte[MAX_AUXOUT][MAX_WINDOW];	
}

    public static class NET_DVR_NTPPARA extends Structure {
	public byte[] sNTPServer = new byte[64];   /* Domain Name or IP addr of NTP server */
	public short wInterval;		 /* adjust time interval(hours) */
	public byte byEnableNTP;   
        public byte cTimeDifferenceH;
	public byte cTimeDifferenceM;
	public byte res1;
       public   short wNtpPort;         
       public   byte[] res2 = new byte[8];
}

//ddns
    public static class NET_DVR_DDNSPARA extends Structure {
	public byte[] sUsername = new byte[NAME_LEN];  
	public byte[] sPassword = new byte[PASSWD_LEN];
	public byte[] sDomainName = new byte[64];      
	public byte byEnableDDNS;			
	public byte[] res = new byte[15];
}

   public static class NET_DVR_DDNSPARA_EX extends Structure {
	public byte byHostIndex;					
	public byte byEnableDDNS;					
	public short wDDNSPort;						
	public byte[] sUsername = new byte[NAME_LEN];			
	public byte[] sPassword = new byte[PASSWD_LEN];			
	public byte[] sDomainName = new byte[MAX_DOMAIN_NAME];	
	public byte[] sServerName = new byte[MAX_DOMAIN_NAME];	
	public byte[] byRes = new byte[16];
}

   public static class NET_DVR_DDNS extends Structure {
       public  byte[] sUsername = new byte[NAME_LEN];			
       public  byte[] sPassword = new byte[PASSWD_LEN];			
       public  byte[] sDomainName = new byte[MAX_DOMAIN_NAME];	
       public  byte[] sServerName = new byte[MAX_DOMAIN_NAME];	
       public  short wDDNSPort;						
       public   byte[] byRes = new byte[10];
   }
public static class NET_DVR_DDNSPARA_V30 extends Structure {
  public   byte byEnableDDNS;
  public   byte byHostIndex;
  public  byte[] byRes1 = new byte[2];
  public   NET_DVR_DDNS[] struDDNS = new NET_DVR_DDNS[MAX_DDNS_NUMS];
  public   byte[] byRes2 = new byte[16];
}

//email
public static class NET_DVR_EMAILPARA extends Structure {
	public byte[] sUsername = new byte[64]; 
	public byte[] sPassword = new byte[64];
	public byte[] sSmtpServer = new byte[64];
	public byte[] sPop3Server = new byte[64];
	public byte[] sMailAddr = new byte[64];   /* email */
	public byte[] sEventMailAddr1 = new byte[64];  
	public byte[] sEventMailAddr2 = new byte[64];
	public byte[] res = new byte[16];
}

public static class NET_DVR_NETAPPCFG extends Structure {
	public int  dwSize;
	public byte[]  sDNSIp = new byte[16];               
	public NET_DVR_NTPPARA  struNtpClientParam;      
	public NET_DVR_DDNSPARA struDDNSClientParam;     
	//NET_DVR_EMAILPARA struEmailParam;       
	public byte[] res = new byte[464];			
}

public static class NET_DVR_SINGLE_NFS extends Structure {
    public byte[] sNfsHostIPAddr = new byte[16];
    public byte[] sNfsDirectory = new byte[PATHNAME_LEN];        // PATHNAME_LEN = 128
}

public static class NET_DVR_NFSCFG extends Structure {
	public int  dwSize;
        public NET_DVR_SINGLE_NFS[] struNfsDiskParam = new NET_DVR_SINGLE_NFS[MAX_NFS_DISK];
}

public static class NET_DVR_CRUISE_POINT extends Structure {
  public   byte	PresetNum;	
  public  byte	Dwell;		
  public   byte	Speed;		
  public   byte	Reserve;	
}

public static class NET_DVR_CRUISE_RET extends Structure {
	public NET_DVR_CRUISE_POINT[] struCruisePoint = new NET_DVR_CRUISE_POINT[32];			
}

public static class NET_DVR_NETCFG_OTHER extends Structure {
	public int	dwSize;
	public byte[]	sFirstDNSIP = new byte[16];
	public byte[]	sSecondDNSIP = new byte[16];
	public byte[]	sRes = new byte[32];
}

public static class NET_DVR_MATRIX_DECINFO extends Structure {
	public byte[] 	sDVRIP = new byte[16];				
	public short 	wDVRPort;			 	
	public byte 	byChannel;				
	public byte	byTransProtocol;			
	public byte	byTransMode;				
	public byte[]	byRes = new byte[3];
	public byte[]	sUserName = new byte[NAME_LEN];			
	public byte[]	sPassword = new byte[PASSWD_LEN];			
}

public static class NET_DVR_MATRIX_DYNAMIC_DEC extends Structure {
	public int	dwSize;
	public NET_DVR_MATRIX_DECINFO struDecChanInfo;		
}

public static class NET_DVR_MATRIX_DEC_CHAN_STATUS extends Structure {
   public  int   dwSize;
   public  int   dwIsLinked;         
   public  int   dwStreamCpRate;     /* Stream copy rate, X kbits/second */
   public  byte[]    cRes = new byte[64];		
}

public static class NET_DVR_MATRIX_DEC_CHAN_INFO extends Structure {
	public int	dwSize;
	public NET_DVR_MATRIX_DECINFO struDecChanInfo;		
	public int	dwDecState;	
	public NET_DVR_TIME StartTime;		
	public NET_DVR_TIME StopTime;		
	public byte[]    sFileName = new byte[128];		
}

public static class NET_DVR_MATRIX_DECCHANINFO extends Structure {
	public int dwEnable;					
	public NET_DVR_MATRIX_DECINFO struDecChanInfo;		
}

public static class NET_DVR_MATRIX_LOOP_DECINFO extends Structure {
	public int	dwSize;
	public int	dwPoolTime;			
	public NET_DVR_MATRIX_DECCHANINFO[] struchanConInfo = new NET_DVR_MATRIX_DECCHANINFO[MAX_CYCLE_CHAN];
}

public static class NET_DVR_MATRIX_ROW_ELEMENT extends Structure {
	public byte[]	sSurvChanName = new byte[128];			
	public int	dwRowNum;				
	public NET_DVR_MATRIX_DECINFO struDecChanInfo;		
}

public static class NET_DVR_MATRIX_ROW_INDEX extends Structure {
	public byte[]	sSurvChanName = new byte[128];			
	public int	dwRowNum;				
}

public static class NET_DVR_MATRIX_COLUMN_ELEMENT extends Structure {
	public int  dwLocalDispChanNum;	
	public int  dwGlobalDispChanNum;	
	public int  dwRes;			
}

public static class NET_DVR_MATRIX_GLOBAL_COLUMN_ELEMENT extends Structure {
	public int		dwConflictTag;		
	public int		dwConflictGloDispChan;	
	public NET_DVR_MATRIX_COLUMN_ELEMENT  struColumnInfo;
}

public static class NET_DVR_MATRIX_ROW_COLUMN_LINK extends Structure {
	public int	dwSize;
	public int	dwRowNum;			
	public byte[]	sSurvChanName = new byte[128];	
	public int	dwSurvNum;			
								
	public int	dwGlobalDispChanNum;			
	public int	dwLocalDispChanNum;
	public int	dwTimeSel;
	public NET_DVR_TIME StartTime;
	public NET_DVR_TIME StopTime;
	public byte[]	sFileName = new byte[128];
}

public static class NET_DVR_MATRIX_PREVIEW_DISP_CHAN extends Structure {
	public int		dwSize;
	public int		dwGlobalDispChanNum;		
	public int		dwLocalDispChanNum;		
}

public static class NET_DVR_MATRIX_LOOP_PLAY_SET extends Structure {
	public int	dwSize;
	
	public int	dwLocalDispChanNum;	
	public int	dwGlobalDispChanNum;  	
	public int	dwCycTimeInterval;	
}

public static class NET_DVR_MATRIX_LOCAL_HOST_INFO extends Structure {
	public int	dwSize;
	public int	dwLocalHostProperty;  	
	public int	dwIsIsolated;		
	public int	dwLocalMatrixHostPort;	
	public byte[]	byLocalMatrixHostUsrName = new byte[NAME_LEN];		
	public byte[]	byLocalMatrixHostPasswd = new byte[PASSWD_LEN];		
	public int	dwLocalMatrixCtrlMedia;				
	public byte[]	sMatrixCenterIP = new byte[16];		
	public int	dwMatrixCenterPort;	 	
	public byte[]	byMatrixCenterUsrName = new byte[NAME_LEN];	
	public byte[]	byMatrixCenterPasswd = new byte[PASSWD_LEN];	
}

public static class TTY_CONFIG extends Structure {
	public byte	baudrate; 	
	public byte	databits;		
	public byte	stopbits;		
	public byte	parity;		
	public byte	flowcontrol;	
	public byte[]	res = new byte[3];
}

public static class NET_DVR_MATRIX_TRAN_CHAN_INFO extends Structure {
	public byte byTranChanEnable;	
         /*
	 *	0 RS485
	 *	1 RS232 Console
	 */
	public byte	byLocalSerialDevice;			/* Local serial device */

	public byte	byRemoteSerialDevice;			/* Remote output serial device */
	public byte	res1;							
	public byte[]	sRemoteDevIP= new byte[16];				/* Remote Device IP */
	public short	wRemoteDevPort;				/* Remote Net Communication Port */
	public byte[]	res2= new byte[2];						
	public TTY_CONFIG RemoteSerialDevCfg;
}

public static class NET_DVR_MATRIX_TRAN_CHAN_CONFIG extends Structure {
        public 	int dwSize;
	public byte 	by232IsDualChan; 
	public byte	by485IsDualChan; 
	public byte[]	res = new byte[2];
	public NET_DVR_MATRIX_TRAN_CHAN_INFO[] struTranInfo = new NET_DVR_MATRIX_TRAN_CHAN_INFO[MAX_SERIAL_NUM];
}

public static class NET_DVR_MATRIX_DEC_REMOTE_PLAY extends Structure {
	public int	dwSize;
	public byte[]	sDVRIP = new byte[16];		/* Adresse IP DVR */
	public short	wDVRPort;			
	public byte	byChannel;			
	public byte 	byReserve;
	public byte[]	sUserName = new byte[NAME_LEN];		
	public byte[]	sPassword = new byte[PASSWD_LEN];		
	public int	dwPlayMode;   	/* 0 - par fichier 1 - par heure */
	public NET_DVR_TIME StartTime;
	public NET_DVR_TIME StopTime;
	public byte[]    sFileName = new byte[128];
}


public static class NET_DVR_MATRIX_DEC_REMOTE_PLAY_CONTROL extends Structure {
	public int	dwSize;
	public int	dwPlayCmd;		/* commande de lecture voir la commande de lecture de fichier */
	public int	dwCmdParam;		
}

public static class NET_DVR_MATRIX_DEC_REMOTE_PLAY_STATUS extends Structure {
	public int dwSize;
	public int dwCurMediaFileLen; /* La longueur du fichier multimédia en cours de lecture */
	public int dwCurMediaFilePosition; /* La position de lecture du fichier en cours de lecture */
	public int dwCurMediaFileDuration; 
	public int dwCurPlayTime; /* Temps écoulé en cours */
	public int dwCurMediaFIleFrames; /* Le nombre total d'images du fichier en cours de lecture */
	public int dwCurDataType; /* Le type de données actuellement transmis, en-tête de 19 fichiers, données de 20 flux, drapeau de fin de 21 lectures */
        public  byte[] res = new byte[72];
}

public static class NET_DVR_MATRIX_PASSIVEMODE extends Structure {
	public short	wTransProtol;		//0-TCP, 1-UDP, 2-MCAST
	public short	wPassivePort;		//TCP, UDP est TCP, le port UDP, MCAST est le port MCAST
	public byte[]	sMcastIP = new byte[16];		// Invalide pour TCP, UDP, adresse multidiffusion pour MCAST
	public byte[]	res = new byte[8];
}


public static class NET_DVR_EMAILCFG  extends Structure
{	/* 12 bytes */
	public int	dwSize;
	public byte[]	sUserName = new byte[32];
	public byte[]	sPassWord = new byte[32];
	public byte[] 	sFromName = new byte[32];			
	public byte[] 	sFromAddr = new byte[48];			/* Sender address */
	public byte[] 	sToName1 = new byte[32];			/* Receiver1 */
	public byte[] 	sToName2 = new byte[32];			/* Receiver2 */
	public byte[] 	sToAddr1 = new byte[48];			/* Receiver address1 */
	public byte[] 	sToAddr2 = new byte[48];			/* Receiver address2 */
	public byte[]	sEmailServer = new byte[32];		/* Email server address */
        public byte	byServerType;			/* Email server type: 0-SMTP, 1-POP, 2-IMTPâ€¦*/
	public byte	byUseAuthen;			/* Email server authentication method: 1-enable, 0-disable */
	public byte	byAttachment;			/* enable attachment */
	public byte	byMailinterval;			/* mail interval 0-2s, 1-3s, 2-4s. 3-5s*/
}

public static class NET_DVR_COMPRESSIONCFG_NEW extends Structure
{
	public int dwSize;
	public NET_DVR_COMPRESSION_INFO_EX  struLowCompression;	
	public NET_DVR_COMPRESSION_INFO_EX  struEventCompression;	
}

public static class NET_DVR_PTZPOS extends Structure
{
   public   short wAction;
   public  short wPanPos;
   public  short wTiltPos;
   public short wZoomPos;
}

//zoom position
public static class NET_DVR_PTZSCOPE extends Structure
{
   public  short wPanPosMin;
   public  short wPanPosMax;
   public  short wTiltPosMin;
   public  short wTiltPosMax;
   public   short wZoomPosMin;
   public   short wZoomPosMax;
}

public static class NET_DVR_RTSPCFG extends Structure
{
 public    int dwSize;         
 public    short  wPort;         
 public    byte[]  byReserve = new byte[54];  
}


//NET_DVR_Login()
public static class NET_DVR_DEVICEINFO extends Structure
{
	public byte[] sSerialNumber = new byte[SERIALNO_LEN];   
	public byte byAlarmInPortNum;		       
	public byte byAlarmOutPortNum;		        
	public byte byDiskNum;				        
	public byte byDVRType;				       
	public byte byChanNum;				        
	public byte byStartChan;			       
}

//NET_DVR_Login_V30()
public static class NET_DVR_DEVICEINFO_V30 extends Structure
{
   public  byte[] sSerialNumber = new byte[SERIALNO_LEN];  
   public  byte byAlarmInPortNum;		        
   public  byte byAlarmOutPortNum;		        
   public  byte byDiskNum;				    
   public  byte byDVRType;				   
   public  byte byChanNum;				    
   public  byte byStartChan;			        
   public  byte byAudioChanNum;               
   public  byte byIPChanNum;					
   public  byte[] byRes1 = new byte[24];					
}

 enum _SDK_NET_ENV
{
    LOCAL_AREA_NETWORK ,
    WIDE_AREA_NETWORK
}

 enum DISPLAY_MODE
{
	NORMALMODE ,
	OVERLAYMODE
}

 enum SEND_MODE
{
	PTOPTCPMODE,
	PTOPUDPMODE,
	MULTIMODE,
	RTPMODE,
	RESERVEDMODE
};

 enum CAPTURE_MODE
{
	BMP_MODE,		
	JPEG_MODE		
};

 enum REALSOUND_MODE
{
};

    public static class NET_DVR_CLIENTINFO extends Structure {
        public NativeLong lChannel;
        public NativeLong lLinkMode;
        public HWND hPlayWnd;
        public String sMultiCastIP;
    }

public static class NET_DVR_SDKSTATE extends Structure
{
    public int dwTotalLoginNum;		
    public int dwTotalRealPlayNum;	
    public int dwTotalPlayBackNum;	
    public int dwTotalAlarmChanNum;	
    public int dwTotalFormatNum;		
    public  int dwTotalFileSearchNum;	
    public int[] dwRes = new int[10];
}

public static class NET_DVR_SDKABL extends Structure
{
    public int dwMaxLoginNum;		
    public int dwMaxRealPlayNum;		
    public int dwMaxPlayBackNum;		
    public int dwMaxAlarmChanNum;	
    public int dwMaxFormatNum;		
    public int dwMaxFileSearchNum;	
    public int dwMaxLogSearchNum;	
    public int dwMaxSerialNum;	    
    public int dwMaxUpgradeNum;	    
    public int dwMaxVoiceComNum;		
    public int dwMaxBroadCastNum;	
    public int[] dwRes = new int[10];
}

public static class NET_DVR_ALARMER extends Structure
{
   public  byte byUserIDValid;                 
   public  byte bySerialValid;                
   public  byte byVersionValid;               
   public  byte byDeviceNameValid;             
   public byte byMacAddrValid;                
   public   byte byLinkPortValid;               
   public    byte byDeviceIPValid;               
   public   byte bySocketIPValid;              
   public   NativeLong lUserID;                      
   public   byte[] sSerialNumber = new byte[SERIALNO_LEN];	
   public  int dwDeviceVersion;			    
   public   byte[] sDeviceName = new byte[NAME_LEN];		    
   public    byte[] byMacAddr = new byte[MACADDR_LEN];		
   public   short wLinkPort;                    
   public   byte[] sDeviceIP = new byte[128];    			
   public   byte[] sSocketIP = new byte[128];    			
   public  byte byIpProtocol;                 
   public    byte[] byRes2 = new byte[11];
}

public static class NET_DVR_DISPLAY_PARA extends Structure
{
	public NativeLong bToScreen;
	public NativeLong bToVideoOut;
	public NativeLong nLeft;
	public NativeLong nTop;
	public NativeLong nWidth;
	public NativeLong nHeight;
	public NativeLong nReserved;
}

public static class NET_DVR_CARDINFO extends Structure
{
	public NativeLong lChannel;
	public NativeLong lLinkMode;
	public String sMultiCastIP;
	public NET_DVR_DISPLAY_PARA struDisplayPara;
}

public static class NET_DVR_FIND_DATA extends Structure
{
	public byte[] sFileName = new byte[100];
	public NET_DVR_TIME struStartTime;
	public NET_DVR_TIME struStopTime;
	public int dwFileSize;
}

  public static class NET_DVR_FINDDATA_V30 extends Structure {
        public byte[] sFileName = new byte[100];
        public NET_DVR_TIME struStartTime;
        public NET_DVR_TIME struStopTime;
        public int dwFileSize;
        public byte[] sCardNum = new byte[32];
        public byte byLocked;
        public byte[] byRes = new byte[3];
    }

public static class NET_DVR_FINDDATA_CARD extends Structure
{
	public byte[] sFileName = new byte[100];
	public NET_DVR_TIME struStartTime;
	public NET_DVR_TIME struStopTime;
	public int dwFileSize;
	public byte[] sCardNum = new byte[32];
}


 public static class NET_DVR_FILECOND extends Structure 
    {
        public NativeLong lChannel;
        public int dwFileType;
        public int dwIsLocked;
        public int dwUseCardNo;
        public byte[] sCardNumber = new byte[32];
        public NET_DVR_TIME struStartTime;
        public NET_DVR_TIME struStopTime;
    }

public static class NET_DVR_POINT_FRAME extends Structure
{
	public int xTop;     
	public int yTop;     
	public int xBottom;  
	public int yBottom;  
	public int bCounter; 
}

public static class NET_DVR_COMPRESSION_AUDIO extends Structure
{
	public byte  byAudioEncType;   
	public byte[] byres= new byte [7];
}

public static class RECV_ALARM extends Structure{
    public byte[] RecvBuffer = new byte[400];
}


   public static interface FRealDataCallBack_V30 extends StdCallCallback {
        public void invoke(NativeLong lRealHandle, int dwDataType,
                ByteByReference pBuffer, int dwBufSize, Pointer pUser);
    }

   public static interface FMSGCallBack extends StdCallCallback {
        public void invoke(NativeLong lCommand, NET_DVR_ALARMER pAlarmer, HCNetSDK.RECV_ALARM  pAlarmInfo, int dwBufLen,Pointer pUser);
    }

   public static interface FMessCallBack extends StdCallCallback {
        public boolean invoke(NativeLong lCommand,String sDVRIP,String pBuf,int dwBufLen);
    }

   public static interface FMessCallBack_EX extends StdCallCallback {
        public boolean invoke(NativeLong lCommand,NativeLong lUserID,String pBuf,int dwBufLen);
    }

   public static interface FMessCallBack_NEW extends StdCallCallback {
        public boolean invoke(NativeLong lCommand,String sDVRIP,String pBuf,int dwBufLen, short dwLinkDVRPort);
    }

   public static interface FMessageCallBack extends StdCallCallback {
        public boolean invoke(NativeLong lCommand,String sDVRIP,String pBuf,int dwBufLen, int dwUser);
    }

      public static interface FExceptionCallBack extends StdCallCallback {
        public void invoke(int dwType, NativeLong lUserID, NativeLong lHandle, Pointer pUser);
    }
      public static interface FDrawFun extends StdCallCallback {
        public void invoke(NativeLong lRealHandle,W32API.HDC hDc,int dwUser);
      }

    public static interface FStdDataCallBack extends StdCallCallback {
        public void invoke(NativeLong lRealHandle, int dwDataType, ByteByReference pBuffer,int dwBufSize,int dwUser);
      }

    public static interface FPlayDataCallBack extends StdCallCallback {
        public void invoke(NativeLong lPlayHandle, int dwDataType, ByteByReference pBuffer,int dwBufSize,int dwUser);
      }

    public static interface FVoiceDataCallBack extends StdCallCallback {
        public void invoke(NativeLong lVoiceComHandle, String pRecvDataBuffer, int dwBufSize, byte byAudioFlag, int dwUser);
      }

    public static interface FVoiceDataCallBack_V30 extends StdCallCallback {
        public void invoke(NativeLong lVoiceComHandle, String pRecvDataBuffer, int dwBufSize, byte byAudioFlag,Pointer pUser);
      }

    public static interface FVoiceDataCallBack_MR extends StdCallCallback {
        public void invoke(NativeLong lVoiceComHandle, String pRecvDataBuffer, int dwBufSize, byte byAudioFlag, int dwUser);
      }

    public static interface FVoiceDataCallBack_MR_V30 extends StdCallCallback {
        public void invoke(NativeLong lVoiceComHandle, String pRecvDataBuffer, int dwBufSize, byte byAudioFlag, String pUser);
      }

    public static interface FVoiceDataCallBack2 extends StdCallCallback {
        public void invoke(String pRecvDataBuffer, int dwBufSize, Pointer pUser);
      }

   public static interface FSerialDataCallBack extends StdCallCallback {
        public void invoke(NativeLong lSerialHandle,String pRecvDataBuffer,int dwBufSize,int dwUser);
      }

    public static interface FRowDataCallBack extends StdCallCallback {
        public void invoke(NativeLong lUserID,String  sIPAddr, NativeLong lRowAmout, String pRecvDataBuffer,int dwBufSize,int dwUser);
      }

    public static interface FColLocalDataCallBack extends StdCallCallback {
        public void invoke(NativeLong lUserID, String sIPAddr, NativeLong lColumnAmout, String pRecvDataBuffer,int dwBufSize,int dwUser);
      }

     public static interface FColGlobalDataCallBack extends StdCallCallback {
        public void invoke(NativeLong lUserID, String sIPAddr, NativeLong lColumnAmout, String pRecvDataBuffer,int dwBufSize,int dwUser);
      }

   public static interface FJpegdataCallBack extends StdCallCallback {
        public int invoke(NativeLong lCommand, NativeLong lUserID, String sDVRIP, String sJpegName, String pJpegBuf,int dwBufLen, int dwUser);
      }

    public static interface FPostMessageCallBack extends StdCallCallback {
        public int invoke(int dwType, NativeLong lIndex);
      }

 boolean  NET_DVR_Init();
 boolean  NET_DVR_Cleanup();
 boolean  NET_DVR_SetDVRMessage(int nMessage,int hWnd);
 boolean  NET_DVR_SetExceptionCallBack_V30(int nMessage, int hWnd, FExceptionCallBack fExceptionCallBack, Pointer pUser);

 boolean  NET_DVR_SetDVRMessCallBack(FMessCallBack fMessCallBack);
 boolean  NET_DVR_SetDVRMessCallBack_EX(FMessCallBack_EX fMessCallBack_EX);
 boolean  NET_DVR_SetDVRMessCallBack_NEW(FMessCallBack_NEW fMessCallBack_NEW);
 boolean  NET_DVR_SetDVRMessageCallBack(FMessageCallBack fMessageCallBack, int dwUser);

 boolean  NET_DVR_SetDVRMessageCallBack_V30(FMSGCallBack fMessageCallBack, Pointer pUser);

 boolean  NET_DVR_SetConnectTime(int dwWaitTime, int dwTryTimes );
 boolean  NET_DVR_SetReconnect(int dwInterval, boolean bEnableRecon );
 int  NET_DVR_GetSDKVersion();
 int  NET_DVR_GetSDKBuildVersion();
 int  NET_DVR_IsSupport();
 boolean  NET_DVR_StartListen(String sLocalIP,short wLocalPort);
 boolean  NET_DVR_StopListen();

 NativeLong  NET_DVR_StartListen_V30(String sLocalIP, short wLocalPort, FMSGCallBack DataCallback , Pointer pUserData );
 boolean  NET_DVR_StopListen_V30(NativeLong lListenHandle);
 NativeLong  NET_DVR_Login(String sDVRIP,short wDVRPort,String sUserName,String sPassword,NET_DVR_DEVICEINFO lpDeviceInfo);
 NativeLong  NET_DVR_Login_V30(String sDVRIP, short wDVRPort, String sUserName, String sPassword, NET_DVR_DEVICEINFO_V30 lpDeviceInfo);
 boolean  NET_DVR_Logout(NativeLong lUserID);
 boolean  NET_DVR_Logout_V30(NativeLong lUserID);
 int  NET_DVR_GetLastError();
 String   NET_DVR_GetErrorMsg(NativeLongByReference pErrorNo );
 boolean  NET_DVR_SetShowMode(int dwShowType,int colorKey);
 boolean  NET_DVR_GetDVRIPByResolveSvr(String sServerIP, short wServerPort, String sDVRName,short wDVRNameLen,String sDVRSerialNumber,short wDVRSerialLen,String sGetIP);
 boolean   NET_DVR_GetDVRIPByResolveSvr_EX(String sServerIP, short wServerPort,  String sDVRName, short wDVRNameLen, String sDVRSerialNumber, short wDVRSerialLen,String sGetIP, IntByReference dwPort);


 NativeLong  NET_DVR_RealPlay(NativeLong lUserID,NET_DVR_CLIENTINFO lpClientInfo);
 NativeLong  NET_DVR_RealPlay_V30(NativeLong lUserID, NET_DVR_CLIENTINFO lpClientInfo, FRealDataCallBack_V30 fRealDataCallBack_V30, Pointer pUser , boolean bBlocked );
 boolean  NET_DVR_StopRealPlay(NativeLong lRealHandle);
 boolean  NET_DVR_RigisterDrawFun(NativeLong lRealHandle,FDrawFun fDrawFun,int dwUser);
 boolean  NET_DVR_SetPlayerBufNumber(NativeLong lRealHandle,int dwBufNum);
 boolean  NET_DVR_ThrowBFrame(NativeLong lRealHandle,int dwNum);
 boolean  NET_DVR_SetAudioMode(int dwMode);
 boolean  NET_DVR_OpenSound(NativeLong lRealHandle);
 boolean  NET_DVR_CloseSound();
 boolean  NET_DVR_OpenSoundShare(NativeLong lRealHandle);
 boolean  NET_DVR_CloseSoundShare(NativeLong lRealHandle);
 boolean  NET_DVR_Volume(NativeLong lRealHandle,short wVolume);
 boolean  NET_DVR_SaveRealData(NativeLong lRealHandle,String sFileName);
 boolean  NET_DVR_StopSaveRealData(NativeLong lRealHandle);
 boolean  NET_DVR_SetRealDataCallBack(NativeLong lRealHandle,FRowDataCallBack fRealDataCallBack,int dwUser);
 boolean  NET_DVR_SetStandardDataCallBack(NativeLong lRealHandle,FStdDataCallBack fStdDataCallBack,int dwUser);
 boolean  NET_DVR_CapturePicture(NativeLong lRealHandle,String sPicFileName);


 boolean  NET_DVR_MakeKeyFrame(NativeLong lUserID, NativeLong lChannel);
 boolean  NET_DVR_MakeKeyFrameSub(NativeLong lUserID, NativeLong lChannel);


 boolean  NET_DVR_PTZControl(NativeLong lRealHandle,int dwPTZCommand,int dwStop);
 boolean  NET_DVR_PTZControl_Other(NativeLong lUserID,NativeLong lChannel,int dwPTZCommand,int dwStop);
 boolean  NET_DVR_TransPTZ(NativeLong lRealHandle,String pPTZCodeBuf,int dwBufSize);
 boolean  NET_DVR_TransPTZ_Other(NativeLong lUserID,NativeLong lChannel,String pPTZCodeBuf,int dwBufSize);
 boolean  NET_DVR_PTZPreset(NativeLong lRealHandle,int dwPTZPresetCmd,int dwPresetIndex);
 boolean  NET_DVR_PTZPreset_Other(NativeLong lUserID,NativeLong lChannel,int dwPTZPresetCmd,int dwPresetIndex);
 boolean  NET_DVR_TransPTZ_EX(NativeLong lRealHandle,String pPTZCodeBuf,int dwBufSize);
 boolean  NET_DVR_PTZControl_EX(NativeLong lRealHandle,int dwPTZCommand,int dwStop);
 boolean  NET_DVR_PTZPreset_EX(NativeLong lRealHandle,int dwPTZPresetCmd,int dwPresetIndex);
 boolean  NET_DVR_PTZCruise(NativeLong lRealHandle,int dwPTZCruiseCmd,byte byCruiseRoute, byte byCruisePoint, short wInput);
 boolean  NET_DVR_PTZCruise_Other(NativeLong lUserID,NativeLong lChannel,int dwPTZCruiseCmd,byte byCruiseRoute, byte byCruisePoint, short wInput);
 boolean  NET_DVR_PTZCruise_EX(NativeLong lRealHandle,int dwPTZCruiseCmd,byte byCruiseRoute, byte byCruisePoint, short wInput);
 boolean  NET_DVR_PTZTrack(NativeLong lRealHandle, int dwPTZTrackCmd);
 boolean  NET_DVR_PTZTrack_Other(NativeLong lUserID, NativeLong lChannel, int dwPTZTrackCmd);
 boolean  NET_DVR_PTZTrack_EX(NativeLong lRealHandle, int dwPTZTrackCmd);
 boolean  NET_DVR_PTZControlWithSpeed(NativeLong lRealHandle, int dwPTZCommand, int dwStop, int dwSpeed);
 boolean  NET_DVR_PTZControlWithSpeed_Other(NativeLong lUserID, NativeLong lChannel, int dwPTZCommand, int dwStop, int dwSpeed);
 boolean  NET_DVR_PTZControlWithSpeed_EX(NativeLong lRealHandle, int dwPTZCommand, int dwStop, int dwSpeed);
 boolean  NET_DVR_GetPTZCruise(NativeLong lUserID,NativeLong lChannel,NativeLong lCruiseRoute, NET_DVR_CRUISE_RET lpCruiseRet);
 boolean  NET_DVR_PTZMltTrack(NativeLong lRealHandle,int dwPTZTrackCmd, int dwTrackIndex);
 boolean  NET_DVR_PTZMltTrack_Other(NativeLong lUserID,NativeLong lChannel,int dwPTZTrackCmd, int dwTrackIndex);
 boolean  NET_DVR_PTZMltTrack_EX(NativeLong lRealHandle,int dwPTZTrackCmd, int dwTrackIndex);


 NativeLong  NET_DVR_FindFile(NativeLong lUserID,NativeLong lChannel,int dwFileType, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime);
 NativeLong  NET_DVR_FindNextFile(NativeLong lFindHandle,NET_DVR_FIND_DATA lpFindData);
 boolean  NET_DVR_FindClose(NativeLong lFindHandle);
 NativeLong  NET_DVR_FindNextFile_V30(NativeLong lFindHandle, NET_DVR_FINDDATA_V30 lpFindData);
 NativeLong  NET_DVR_FindFile_V30(NativeLong lUserID, NET_DVR_FILECOND pFindCond);
 boolean  NET_DVR_FindClose_V30(NativeLong lFindHandle);
 NativeLong  NET_DVR_FindNextFile_Card(NativeLong lFindHandle, NET_DVR_FINDDATA_CARD lpFindData);
 NativeLong  NET_DVR_FindFile_Card(NativeLong lUserID, NativeLong lChannel, int dwFileType, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime);
 boolean  NET_DVR_LockFileByName(NativeLong lUserID, String sLockFileName);
 boolean  NET_DVR_UnlockFileByName(NativeLong lUserID, String sUnlockFileName);
 NativeLong  NET_DVR_PlayBackByName(NativeLong lUserID,String sPlayBackFileName, HWND hWnd);
 NativeLong  NET_DVR_PlayBackByTime(NativeLong lUserID,NativeLong lChannel, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime, HWND hWnd);
 boolean  NET_DVR_PlayBackControl(NativeLong lPlayHandle,int dwControlCode,int dwInValue,IntByReference LPOutValue);
 boolean  NET_DVR_StopPlayBack(NativeLong lPlayHandle);
 boolean  NET_DVR_SetPlayDataCallBack(NativeLong lPlayHandle,FPlayDataCallBack fPlayDataCallBack,int dwUser);
 boolean  NET_DVR_PlayBackSaveData(NativeLong lPlayHandle,String sFileName);
 boolean  NET_DVR_StopPlayBackSave(NativeLong lPlayHandle);
 boolean  NET_DVR_GetPlayBackOsdTime(NativeLong lPlayHandle, NET_DVR_TIME lpOsdTime);
 boolean  NET_DVR_PlayBackCaptureFile(NativeLong lPlayHandle,String sFileName);
 NativeLong  NET_DVR_GetFileByName(NativeLong lUserID,String sDVRFileName,String sSavedFileName);
 NativeLong  NET_DVR_GetFileByTime(NativeLong lUserID,NativeLong lChannel, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime, String sSavedFileName);
 boolean  NET_DVR_StopGetFile(NativeLong lFileHandle);
 int  NET_DVR_GetDownloadPos(NativeLong lFileHandle);
 int	 NET_DVR_GetPlayBackPos(NativeLong lPlayHandle);

 NativeLong  NET_DVR_Upgrade(NativeLong lUserID, String sFileName);
 int  NET_DVR_GetUpgradeState(NativeLong lUpgradeHandle);
 int  NET_DVR_GetUpgradeProgress(NativeLong lUpgradeHandle);
 boolean  NET_DVR_CloseUpgradeHandle(NativeLong lUpgradeHandle);
 boolean  NET_DVR_SetNetworkEnvironment(int dwEnvironmentLevel);
 NativeLong  NET_DVR_FormatDisk(NativeLong lUserID,NativeLong lDiskNumber);
 boolean  NET_DVR_GetFormatProgress(NativeLong lFormatHandle, NativeLongByReference pCurrentFormatDisk,NativeLongByReference pCurrentDiskPos,NativeLongByReference pFormatStatic);
 boolean  NET_DVR_CloseFormatHandle(NativeLong lFormatHandle);
 NativeLong  NET_DVR_SetupAlarmChan(NativeLong lUserID);
 boolean  NET_DVR_CloseAlarmChan(NativeLong lAlarmHandle);
 NativeLong  NET_DVR_SetupAlarmChan_V30(NativeLong lUserID);
 boolean  NET_DVR_CloseAlarmChan_V30(NativeLong lAlarmHandle);
 NativeLong  NET_DVR_StartVoiceCom(NativeLong lUserID, FVoiceDataCallBack fVoiceDataCallBack, int dwUser);
 NativeLong  NET_DVR_StartVoiceCom_V30(NativeLong lUserID, int dwVoiceChan, boolean bNeedCBNoEncData, FVoiceDataCallBack_V30 fVoiceDataCallBack, Pointer pUser);
 boolean  NET_DVR_SetVoiceComClientVolume(NativeLong lVoiceComHandle, short wVolume);
 boolean  NET_DVR_StopVoiceCom(NativeLong lVoiceComHandle);
 NativeLong  NET_DVR_StartVoiceCom_MR(NativeLong lUserID, FVoiceDataCallBack_MR fVoiceDataCallBack, int dwUser);
 NativeLong  NET_DVR_StartVoiceCom_MR_V30(NativeLong lUserID, int dwVoiceChan, FVoiceDataCallBack_MR_V30 fVoiceDataCallBack, Pointer pUser);
 boolean  NET_DVR_VoiceComSendData(NativeLong lVoiceComHandle, String pSendBuf, int dwBufSize);

 boolean  NET_DVR_ClientAudioStart();
 boolean  NET_DVR_ClientAudioStart_V30(FVoiceDataCallBack2 fVoiceDataCallBack2, Pointer pUser);
 boolean  NET_DVR_ClientAudioStop();
 boolean  NET_DVR_AddDVR(NativeLong lUserID);
 NativeLong  NET_DVR_AddDVR_V30(NativeLong lUserID, int dwVoiceChan);
 boolean  NET_DVR_DelDVR(NativeLong lUserID);
 boolean  NET_DVR_DelDVR_V30(NativeLong lVoiceHandle);
 NativeLong  NET_DVR_SerialStart(NativeLong lUserID,NativeLong lSerialPort,FSerialDataCallBack fSerialDataCallBack,int dwUser);
 boolean  NET_DVR_SerialSend(NativeLong lSerialHandle, NativeLong lChannel, String pSendBuf,int dwBufSize);
 boolean  NET_DVR_SerialStop(NativeLong lSerialHandle);
 boolean  NET_DVR_SendTo232Port(NativeLong lUserID, String pSendBuf, int dwBufSize);
 boolean  NET_DVR_SendToSerialPort(NativeLong lUserID, int dwSerialPort, int dwSerialIndex, String pSendBuf, int dwBufSize);

 Pointer  NET_DVR_InitG722Decoder(int nBitrate);
 void  NET_DVR_ReleaseG722Decoder(Pointer pDecHandle);
 boolean  NET_DVR_DecodeG722Frame(Pointer pDecHandle, String pInBuffer, String pOutBuffer);
 Pointer  NET_DVR_InitG722Encoder();
 boolean  NET_DVR_EncodeG722Frame(Pointer pEncodeHandle,String pInBuff,String pOutBuffer);
 void  NET_DVR_ReleaseG722Encoder(Pointer pEncodeHandle);

 boolean  NET_DVR_ClickKey(NativeLong lUserID, NativeLong lKeyIndex);
 boolean  NET_DVR_StartDVRRecord(NativeLong lUserID,NativeLong lChannel,NativeLong lRecordType);
 boolean  NET_DVR_StopDVRRecord(NativeLong lUserID,NativeLong lChannel);
 boolean  NET_DVR_InitDevice_Card(NativeLongByReference pDeviceTotalChan);
 boolean  NET_DVR_ReleaseDevice_Card();
 boolean  NET_DVR_InitDDraw_Card(int hParent,int colorKey);
 boolean  NET_DVR_ReleaseDDraw_Card();
 NativeLong  NET_DVR_RealPlay_Card(NativeLong lUserID,NET_DVR_CARDINFO lpCardInfo,NativeLong lChannelNum);
 boolean  NET_DVR_ResetPara_Card(NativeLong lRealHandle,NET_DVR_DISPLAY_PARA lpDisplayPara);
 boolean  NET_DVR_RefreshSurface_Card();
 boolean  NET_DVR_ClearSurface_Card();
 boolean  NET_DVR_RestoreSurface_Card();
 boolean  NET_DVR_OpenSound_Card(NativeLong lRealHandle);
 boolean  NET_DVR_CloseSound_Card(NativeLong lRealHandle);
 boolean  NET_DVR_SetVolume_Card(NativeLong lRealHandle,short wVolume);
 boolean  NET_DVR_AudioPreview_Card(NativeLong lRealHandle,boolean bEnable);
 NativeLong  NET_DVR_GetCardLastError_Card();
 Pointer  NET_DVR_GetChanHandle_Card(NativeLong lRealHandle);
 boolean  NET_DVR_CapturePicture_Card(NativeLong lRealHandle, String sPicFileName);
 boolean  NET_DVR_GetSerialNum_Card(NativeLong lChannelNum,IntByReference pDeviceSerialNo);
 NativeLong  NET_DVR_FindDVRLog(NativeLong lUserID, NativeLong lSelectMode, int dwMajorType,int dwMinorType, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime);
 NativeLong  NET_DVR_FindNextLog(NativeLong lLogHandle, NET_DVR_LOG lpLogData);
 boolean  NET_DVR_FindLogClose(NativeLong lLogHandle);
 NativeLong  NET_DVR_FindDVRLog_V30(NativeLong lUserID, NativeLong lSelectMode, int dwMajorType,int dwMinorType, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime, boolean bOnlySmart );
 NativeLong  NET_DVR_FindNextLog_V30(NativeLong lLogHandle, NET_DVR_LOG_V30 lpLogData);
 boolean  NET_DVR_FindLogClose_V30(NativeLong lLogHandle);
 NativeLong  NET_DVR_FindFileByCard(NativeLong lUserID,NativeLong lChannel,int dwFileType, int nFindType, String sCardNumber, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime);

 boolean  NET_DVR_CaptureJPEGPicture(NativeLong lUserID, NativeLong lChannel, NET_DVR_JPEGPARA lpJpegPara, String sPicFileName);
 boolean  NET_DVR_CaptureJPEGPicture_NEW(NativeLong lUserID, NativeLong lChannel, NET_DVR_JPEGPARA lpJpegPara, String sJpegPicBuffer, int dwPicSize,  IntByReference lpSizeReturned);


 int  NET_DVR_GetRealPlayerIndex(NativeLong lRealHandle);
 int  NET_DVR_GetPlayBackPlayerIndex(NativeLong lPlayHandle);

 boolean  NET_DVR_SetScaleCFG(NativeLong lUserID, int dwScale);
 boolean  NET_DVR_GetScaleCFG(NativeLong lUserID, IntByReference lpOutScale);
 boolean  NET_DVR_SetScaleCFG_V30(NativeLong lUserID, NET_DVR_SCALECFG pScalecfg);
 boolean  NET_DVR_GetScaleCFG_V30(NativeLong lUserID, NET_DVR_SCALECFG pScalecfg);
 boolean  NET_DVR_SetATMPortCFG(NativeLong lUserID, short wATMPort);
 boolean  NET_DVR_GetATMPortCFG(NativeLong lUserID, ShortByReference LPOutATMPort);

 boolean  NET_DVR_InitDDrawDevice();
 boolean  NET_DVR_ReleaseDDrawDevice();
 NativeLong  NET_DVR_GetDDrawDeviceTotalNums();
 boolean  NET_DVR_SetDDrawDevice(NativeLong lPlayPort, int nDeviceNum);

 boolean  NET_DVR_PTZSelZoomIn(NativeLong lRealHandle, NET_DVR_POINT_FRAME pStruPointFrame);
 boolean  NET_DVR_PTZSelZoomIn_EX(NativeLong lUserID, NativeLong lChannel, NET_DVR_POINT_FRAME pStruPointFrame);

 boolean  NET_DVR_StartDecode(NativeLong lUserID, NativeLong lChannel, NET_DVR_DECODERINFO lpDecoderinfo);
 boolean  NET_DVR_StopDecode(NativeLong lUserID, NativeLong lChannel);
 boolean  NET_DVR_GetDecoderState(NativeLong lUserID, NativeLong lChannel, NET_DVR_DECODERSTATE lpDecoderState);
 boolean  NET_DVR_SetDecInfo(NativeLong lUserID, NativeLong lChannel, NET_DVR_DECCFG lpDecoderinfo);
 boolean  NET_DVR_GetDecInfo(NativeLong lUserID, NativeLong lChannel, NET_DVR_DECCFG lpDecoderinfo);
 boolean  NET_DVR_SetDecTransPort(NativeLong lUserID, NET_DVR_PORTCFG lpTransPort);
 boolean  NET_DVR_GetDecTransPort(NativeLong lUserID, NET_DVR_PORTCFG lpTransPort);
 boolean  NET_DVR_DecPlayBackCtrl(NativeLong lUserID, NativeLong lChannel, int dwControlCode, int dwInValue,IntByReference LPOutValue, NET_DVR_PLAYREMOTEFILE lpRemoteFileInfo);
 boolean  NET_DVR_StartDecSpecialCon(NativeLong lUserID, NativeLong lChannel, NET_DVR_DECCHANINFO lpDecChanInfo);
 boolean  NET_DVR_StopDecSpecialCon(NativeLong lUserID, NativeLong lChannel, NET_DVR_DECCHANINFO lpDecChanInfo);
 boolean  NET_DVR_DecCtrlDec(NativeLong lUserID, NativeLong lChannel, int dwControlCode);
 boolean  NET_DVR_DecCtrlScreen(NativeLong lUserID, NativeLong lChannel, int dwControl);
 boolean  NET_DVR_GetDecCurLinkStatus(NativeLong lUserID, NativeLong lChannel, NET_DVR_DECSTATUS lpDecStatus);

 boolean  NET_DVR_MatrixStartDynamic(NativeLong lUserID, int dwDecChanNum, NET_DVR_MATRIX_DYNAMIC_DEC lpDynamicInfo);
 boolean  NET_DVR_MatrixStopDynamic(NativeLong lUserID, int dwDecChanNum);
 boolean  NET_DVR_MatrixGetDecChanInfo(NativeLong lUserID, int dwDecChanNum, NET_DVR_MATRIX_DEC_CHAN_INFO lpInter);
 boolean  NET_DVR_MatrixSetLoopDecChanInfo(NativeLong lUserID, int dwDecChanNum, NET_DVR_MATRIX_LOOP_DECINFO lpInter);
 boolean  NET_DVR_MatrixGetLoopDecChanInfo(NativeLong lUserID, int dwDecChanNum, NET_DVR_MATRIX_LOOP_DECINFO lpInter);
 boolean  NET_DVR_MatrixSetLoopDecChanEnable(NativeLong lUserID, int dwDecChanNum, int dwEnable);
 boolean  NET_DVR_MatrixGetLoopDecChanEnable(NativeLong lUserID, int dwDecChanNum, IntByReference lpdwEnable);
 boolean  NET_DVR_MatrixGetLoopDecEnable(NativeLong lUserID, IntByReference lpdwEnable);
 boolean  NET_DVR_MatrixSetDecChanEnable(NativeLong lUserID, int dwDecChanNum, int dwEnable);
 boolean  NET_DVR_MatrixGetDecChanEnable(NativeLong lUserID, int dwDecChanNum, IntByReference lpdwEnable);
 boolean  NET_DVR_MatrixGetDecChanStatus(NativeLong lUserID, int dwDecChanNum, NET_DVR_MATRIX_DEC_CHAN_STATUS lpInter);
 boolean  NET_DVR_MatrixSetTranInfo(NativeLong lUserID, NET_DVR_MATRIX_TRAN_CHAN_CONFIG lpTranInfo);
 boolean  NET_DVR_MatrixGetTranInfo(NativeLong lUserID, NET_DVR_MATRIX_TRAN_CHAN_CONFIG lpTranInfo);
 boolean  NET_DVR_MatrixSetRemotePlay(NativeLong lUserID, int dwDecChanNum, NET_DVR_MATRIX_DEC_REMOTE_PLAY lpInter);
 boolean  NET_DVR_MatrixSetRemotePlayControl(NativeLong lUserID, int dwDecChanNum, int dwControlCode, int dwInValue, IntByReference LPOutValue);
 boolean  NET_DVR_MatrixGetRemotePlayStatus(NativeLong lUserID, int dwDecChanNum, NET_DVR_MATRIX_DEC_REMOTE_PLAY_STATUS lpOuter);
 boolean  NET_DVR_RefreshPlay(NativeLong lPlayHandle);
 boolean  NET_DVR_RestoreConfig(NativeLong lUserID);
 boolean  NET_DVR_SaveConfig(NativeLong lUserID);
 boolean  NET_DVR_RebootDVR(NativeLong lUserID);
 boolean  NET_DVR_ShutDownDVR(NativeLong lUserID);
 boolean  NET_DVR_GetDVRConfig(NativeLong lUserID, int dwCommand,NativeLong lChannel, Pointer lpOutBuffer, int dwOutBufferSize, IntByReference lpBytesReturned);
 boolean  NET_DVR_SetDVRConfig(NativeLong lUserID, int dwCommand,NativeLong lChannel, Pointer lpInBuffer, int dwInBufferSize);
 boolean  NET_DVR_GetDVRWorkState_V30(NativeLong lUserID, NET_DVR_WORKSTATE_V30 lpWorkState);
 boolean  NET_DVR_GetDVRWorkState(NativeLong lUserID, NET_DVR_WORKSTATE lpWorkState);
 boolean  NET_DVR_SetVideoEffect(NativeLong lUserID, NativeLong lChannel, int dwBrightValue, int dwContrastValue, int dwSaturationValue, int dwHueValue);
 boolean  NET_DVR_GetVideoEffect(NativeLong lUserID, NativeLong lChannel, IntByReference pBrightValue, IntByReference pContrastValue, IntByReference pSaturationValue, IntByReference pHueValue);
 boolean  NET_DVR_ClientGetframeformat(NativeLong lUserID, NET_DVR_FRAMEFORMAT lpFrameFormat);
 boolean  NET_DVR_ClientSetframeformat(NativeLong lUserID, NET_DVR_FRAMEFORMAT lpFrameFormat);
 boolean  NET_DVR_ClientGetframeformat_V30(NativeLong lUserID, NET_DVR_FRAMEFORMAT_V30 lpFrameFormat);
 boolean  NET_DVR_ClientSetframeformat_V30(NativeLong lUserID, NET_DVR_FRAMEFORMAT_V30 lpFrameFormat);
 boolean  NET_DVR_GetAlarmOut_V30(NativeLong lUserID, NET_DVR_ALARMOUTSTATUS_V30 lpAlarmOutState);
 boolean  NET_DVR_GetAlarmOut(NativeLong lUserID, NET_DVR_ALARMOUTSTATUS lpAlarmOutState);
 boolean  NET_DVR_SetAlarmOut(NativeLong lUserID, NativeLong lAlarmOutPort,NativeLong lAlarmOutStatic);

 boolean  NET_DVR_ClientSetVideoEffect(NativeLong lRealHandle,int dwBrightValue,int dwContrastValue, int dwSaturationValue,int dwHueValue);
 boolean  NET_DVR_ClientGetVideoEffect(NativeLong lRealHandle,IntByReference pBrightValue,IntByReference pContrastValue, IntByReference pSaturationValue,IntByReference pHueValue);

 boolean  NET_DVR_GetConfigFile(NativeLong lUserID, String sFileName);
 boolean  NET_DVR_SetConfigFile(NativeLong lUserID, String sFileName);
 boolean  NET_DVR_GetConfigFile_V30(NativeLong lUserID, String sOutBuffer, int dwOutSize, IntByReference pReturnSize);

 boolean  NET_DVR_GetConfigFile_EX(NativeLong lUserID, String sOutBuffer, int dwOutSize);
 boolean  NET_DVR_SetConfigFile_EX(NativeLong lUserID, String sInBuffer, int dwInSize);

 boolean  NET_DVR_SetLogToFile(boolean bLogEnable , String  strLogDir, boolean bAutoDel );
 boolean  NET_DVR_GetSDKState( NET_DVR_SDKSTATE pSDKState);
 boolean  NET_DVR_GetSDKAbility( NET_DVR_SDKABL pSDKAbl);
 boolean  NET_DVR_GetPTZProtocol(NativeLong lUserID, NET_DVR_PTZCFG  pPtzcfg);
 boolean  NET_DVR_LockPanel(NativeLong lUserID);
 boolean  NET_DVR_UnLockPanel(NativeLong lUserID);

 boolean  NET_DVR_SetRtspConfig(NativeLong lUserID, int dwCommand,  NET_DVR_RTSPCFG lpInBuffer, int dwInBufferSize);
 boolean  NET_DVR_GetRtspConfig(NativeLong lUserID, int dwCommand,  NET_DVR_RTSPCFG lpOutBuffer, int dwOutBufferSize);
}


interface PlayCtrl extends StdCallLibrary
{
    PlayCtrl INSTANCE = (PlayCtrl) Native.loadLibrary("PlayCtrl",
            PlayCtrl.class);

    public static final int STREAME_REALTIME = 0;
    public static final int STREAME_FILE = 1;

    boolean PlayM4_GetPort(NativeLongByReference nPort);
    boolean PlayM4_OpenStream(NativeLong nPort, ByteByReference pFileHeadBuf, int nSize, int nBufPoolSize);
    boolean PlayM4_InputData(NativeLong nPort, ByteByReference pBuf, int nSize);
    boolean PlayM4_CloseStream(NativeLong nPort);
    boolean PlayM4_SetStreamOpenMode(NativeLong nPort, int nMode);
    boolean PlayM4_Play(NativeLong nPort, HWND hWnd);
    boolean PlayM4_Stop(NativeLong nPort);
    boolean PlayM4_SetSecretKey(NativeLong nPort, NativeLong lKeyType, String pSecretKey, NativeLong lKeyLen);
}



