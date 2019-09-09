package com.Idcard.services;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Idcard.bean.StudentBean;
import com.Idcard.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDAO dao;

	public String createStudent(StudentBean sb) {

		MultipartFile file = sb.getFile();
		System.out.println("File name " + file.toString());
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				String rootpath = System.getProperty("catalina.home");
				System.out.println("root path = " + rootpath);

				File dir = new File(rootpath + File.separator + "images");
				System.out.println("file directory" + dir.toString());

				if (!dir.exists()) {
					System.out.println("file directory creating");
					dir.mkdir();
					System.out.println("file directory created" + dir.mkdir());
				}

				String name = String.valueOf(new Date().getTime()) + ".jpg";
				sb.setFileName(name);
				File serverfile = new File(dir.getAbsolutePath() + File.separator + name);
				System.out.println("server filepath" + serverfile);
				// ----------------------------------------------

				// ------------------------------------------------
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverfile));
				System.out.println(" streams " + stream);
				stream.write(bytes);
				stream.close();
				// ------------------------------------------
				String path1 = serverfile.toString().replace("\\", "/");
				System.out.println(path1 + "-------------------------");
				// Compressing file and storing into image

				File inputFile = new File(path1);

				System.out.println("Length = " + inputFile.length());

				FileInputStream inputStream = new FileInputStream(inputFile);
				System.out.println("size input stream = " + inputStream.getChannel().size());

				byte[] fileBytes = new byte[(int) inputFile.length()];
				inputStream.read(fileBytes);
				inputStream.close();
				System.out.println("File name" + sb.getFileName());
				sb.setImage(fileBytes);
				sb.setFileName(name);
				sb.setFile(null);

				if (inputFile.length() > 3000000) {
					resizeImage(serverfile.toString(), sb.getFileName());

				}

				else {
					writeImage(sb);
				}

				System.out.println("File name" + sb.getFileName());

				System.out.println("Inside createStudent");
				System.out.println("array length" + fileBytes.length);

				System.out.println("------------------------butes array" + fileBytes.toString());

				return dao.saveStudent(sb);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "failed";

	}

	public String editStudent(StudentBean sb) {
		return dao.updateStudent(sb);
	}

	public String deleteStudent(Long sl) {
		return dao.deleteStudent(sl);
	}

	public StudentBean getStudent(Long sl) {
		return dao.getStudent(sl);
	}

	public List<StudentBean> getAllStudents() {
		return dao.getAllStudent();
	}

	public List<StudentBean> getAllStudentByName(String name) {
		return dao.getAllStudents(name);
	}

	public static void resizeImage(String image_path, String filename) {

		System.out.println("resizing image");
		System.out.println(image_path + "asdfgdsadfgfdsadfghfdsadf---------");

		try {
			File input = new File(image_path);
			BufferedImage image = ImageIO.read(input);

			File output = new File(
					"C:/Users/Adarsh J/Music/NewWorkspace/idcardApp/idcardApp/WebContent/resources/image/" + filename);
			OutputStream out = new FileOutputStream(output);

			ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
			ImageOutputStream ios = ImageIO.createImageOutputStream(out);
			writer.setOutput(ios);

			ImageWriteParam param = writer.getDefaultWriteParam();
			if (param.canWriteCompressed()) {
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				param.setCompressionQuality(0.05f);
			}

			writer.write(null, new IIOImage(image, null, null), param);

			out.close();
			ios.close();
			writer.dispose();
			System.out.println("file compressed-----------------------complete");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * public static void writeImage(StudentBean sb) {
	 * System.out.println(sb.getImage().toString());
	 * System.out.println(sb.getImage().length); File file = new
	 * File("./WebContent/resources/image/" + sb.getFileName());
	 * System.out.println(file); FileOutputStream fos; try { fos = new
	 * FileOutputStream(file); fos.write(sb.getImage()); fos.close(); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */

	public static void writeImage(StudentBean sb) {
		System.out.println(sb.getImage().toString());
		System.out.println(sb.getImage().length);
		File file = new File("C:/Users/Adarsh J/Music/NewWorkspace/idcardApp/idcardApp/WebContent/resources/image/"+sb.getFileName());
		System.out.println(file);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(sb.getImage());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
