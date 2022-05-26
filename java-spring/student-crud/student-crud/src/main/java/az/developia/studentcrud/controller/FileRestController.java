package az.developia.studentcrud.controller;

import java.io.File;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@GetMapping(path = "/download/{filename:.+}")
//filename:.+ file adinda noqte olur sora gelir

public ResponseEntity<Resource> download(@PathVariable String filename){
	try {
		Resource file= new UrlResource(Paths.get("C:/java1").resolve(filename).toUri());
		//file i goturduk java1 qovlugunnan parametrden gelen file ive geri qaytaririq
		return ResponseEntity.ok().header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"").body(file);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

}