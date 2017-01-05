package md.blibrary.app.beans;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class BaseImageDo {
	
	public static void responseProces(HttpServletResponse response, byte[] imgBytes) throws IOException {
		
		response.setContentType("image/jpeg");
	       
		OutputStream os = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        bos.write(imgBytes, 0, imgBytes.length);
        bos.close();
	}
}
