package pp2.scrum.utils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author yoshknight
 *
 */
public class Logger {
	private static OutputStream outStream=System.out;
	
	public static void setOutStream(OutputStream outStream) {
		Logger.outStream = outStream;
	}
	
	public static void init() {
		try {
			outStream.write( "Logger Iniciado\n".getBytes() );
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			outStream.write( "Logger Finalizado\n".getBytes() );
			outStream=System.out;
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
	
	public static void log(String msg) {
		try {
			outStream.write( msg.getBytes() );
			outStream.write( "\n".getBytes() );
		} catch (IOException e) {
//			e.printStackTrace();
		}
		
	}
	
}
