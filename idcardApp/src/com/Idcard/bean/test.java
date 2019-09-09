package com.Idcard.bean;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;



public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String file = "./WebContent/resources/images/bg-01.jpg";
		resizeImage(file);

	}
public static void resizeImage(String image_path) throws Exception{
	
	
	
	
	File file = new File("./WebContent/resources/image/asdasd.jpg");
	System.out.println(file.toString());
	FileOutputStream fos;
	fos = new FileOutputStream(file);
	
	
		
		/*System.out.println("resizing image");
		
		System.out.println(System.getProperties());
		

		try{
			System.out.println("inside try");
        File input = new File(image_path);
        System.out.println("imput");
        BufferedImage image = ImageIO.read(input);
        System.out.println("after bufferedimage"+image.toString());

        File output = new File("./WebContent/resources/image/compressed.jpg");
        OutputStream out = new FileOutputStream(output);
 
        ImageWriter writer =  ImageIO.getImageWritersByFormatName("jpg").next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(out);
        writer.setOutput(ios);
        System.out.println("resizing ");

        ImageWriteParam param = writer.getDefaultWriteParam();
        if (param.canWriteCompressed()){
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.005f);
        }

        writer.write(null, new IIOImage(image, null, null), param);

        out.close();
        ios.close();
        writer.dispose();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
*/
		
	}


}
