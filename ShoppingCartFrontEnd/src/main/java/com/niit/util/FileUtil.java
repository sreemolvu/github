package com.niit.util;
import java.io.File;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component // will create singleton instance and the instance name is fileUtil
public class FileUtil {

	//private static final String imageDirectory = "ShoppingCartImages";
	//private static String rootPath = System.getProperty("catalina.home");
		private static String rootPath = "F:\\NIIT\\Shoppingcart\\ShoppingCartFrontEnd\\src\\main\\webapp\\resources\\images";

	public  boolean fileCopyNIO(MultipartFile file,String fileName) {
		System.out.println(rootPath);
		File dest = new File(rootPath+File.separator  + fileName);
	
		/*if (!dest.exists()) {
			dest.mkdir();
		}*/

		try {
			file.transferTo(dest);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
