package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;

        if (payload != null) {
            rpcmsg = new byte[payload.length + 1];
            rpcmsg[0] = rpcid;
            System.arraycopy(payload, 0, rpcmsg, 1, payload.length);
        } else {
            rpcmsg = new byte[0];
            rpcmsg[0] = rpcid;
        }
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {

        byte[] payload;
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		
		if (rpcmsg.length > 1) {
            payload = Arrays.copyOfRange(rpcmsg, 1, rpcmsg.length);
        } else {
            payload = new byte[0];
        }
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {

        if (str == null) {
            return new byte[0];
        }

        return str.getBytes();
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
        return new String(data);
	}
	
	public static byte[] marshallVoid() {

		return new byte[0];
		
	}
	
	public static void unmarshallVoid(byte[] data) {

    }

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		ByteBuffer buf = ByteBuffer.allocate(4);
        buf.putInt(x);
        return buf.array();
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		ByteBuffer buf = ByteBuffer.wrap(data);
        return buf.getInt();
		
	}
}
