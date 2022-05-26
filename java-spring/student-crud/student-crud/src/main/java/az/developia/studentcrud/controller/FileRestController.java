package az.developia.studentcrud.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import az.developia.studentcrud.model.FileModel;

@RestController
@RequestMapping(path = "/files")
@CrossOrigin(origins = "*")
public class FileRestController {
	@PostMapping(path = "/upload")
	public FileModel uploadFile(@RequestParam(name = "file", required = false) MultipartFile file) {
		// required=false fayl yuklemek mecbur deil file bos gelsede problem olmayacaq
		String fileName=file.getOriginalFilename();
		try {
			InputStream stream = file.getInputStream();
			File java1 = new File("C:/java1");
			
			if (java1.exists()) {

			} else {
				java1.mkdir();
			} //qovluq yoxdursa yaradiriq 26-32
			UUID uuid = UUID.randomUUID();
			String randomName = uuid.toString();

			String format = fileName.substring(fileName.lastIndexOf("."));
//original file in formatini tapiriq
			randomName += format; // sekil gedib random adnan save olunacaq
			fileName=randomName;
			Files.copy(stream, Paths.get("C:/java1/" + randomName), StandardCopyOption.REPLACE_EXISTING);
			// REPLACE_EXISTING islemek istediyimiz file artiq disk de varsa onu silib
			// sonuncu gonderdiyimizi saxliyir
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		FileModel model=new FileModel();
		model.setFileName(fileName);
		return model;
	}
}
