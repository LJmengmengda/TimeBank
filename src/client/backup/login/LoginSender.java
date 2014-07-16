//package client.backup.login;
//
//import java.io.IOException;
//
//import client.common.ISender;
//import client.common.Package;
///**
// * 用来发送登录信息的类
// * @author pc
// *
// */
//public class LoginSender extends ISender{
//
//	@Override
//	public int send(Package p) {
//		//强制转型
//		LoginPackage lp = (LoginPackage)p;
//		try {
////			dous.writeInt(lp.getUserNameLength());
////			dous.writeInt(lp.getUserNameLength());
////			dous.write(lp.getUserName());
////			dous.write(lp.getPassWord());
//			//测试
//			dous.writeInt(1);
//			dous.writeInt(lp.getPassWordLength());
//			dous.write(lp.getPassWord());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return 0;
//	}
//	
//	
//	
//}
