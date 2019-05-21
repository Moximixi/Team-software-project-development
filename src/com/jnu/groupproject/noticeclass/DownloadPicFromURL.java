package com.jnu.groupproject.noticeclass;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadPicFromURL {
	DownloadPicFromURL(String urlList,String path)throws MalformedURLException, IOException{
		URL url = null;
		url = new URL(urlList);
		DataInputStream dataInputStream = new DataInputStream(url.openStream());
	    FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
	    int length;
	    while ((length = dataInputStream.read(buffer)) > 0) {
	         output.write(buffer, 0, length);
	    }
	    fileOutputStream.write(output.toByteArray());
	    dataInputStream.close();
	    fileOutputStream.close();
	}
}
