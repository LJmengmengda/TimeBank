package client.common.packages;

/**
 * 所有数据包类型的常量  直接在其他地方调用即可
 * @author Administrator
 *
 */
public class TypeConfig {
	public static final byte TYPE_LOGIN = 0x01;
	public static final byte TYPE_SIGNUP = 0x02;
	public static final byte TYPE_REQUEST_PUBLISH = 0x03;
	public static final byte TYPE_REQUEST_RECEIVE = 0x04;
	public static final byte TYPE_REFRESH = 0x05;
}
