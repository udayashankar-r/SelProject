package seleniumworkout;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Day22_IPAddress {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		
		InetAddress IP = InetAddress.getLocalHost();
		System. out. println("IP address of my system is : "+IP.getHostAddress());

	}

}
