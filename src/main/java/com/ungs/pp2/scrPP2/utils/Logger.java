package com.ungs.pp2.scrPP2.utils;

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
			outStream.write( "Logger iniciado\n".getBytes() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			outStream.write( "Logger Finalizado\n".getBytes() );
			outStream=null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void log(String msg) {
		try {
			outStream.write( msg.getBytes() );
			outStream.write( "\n".getBytes() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
