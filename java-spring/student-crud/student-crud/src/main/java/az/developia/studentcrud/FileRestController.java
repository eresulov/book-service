package az.developia.studentcrud;

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

@RestController
@RequestMapping(path = "/files")
@CrossOrigin(origins = "*")
public class FileRestController {
@PostMapping(path = "/upload")
public String uploadFile(@RequestParam(name="file",required=false) MultipartFile file) {
	//required=false fayl yuklemek mecbur deil file bos gelsede problem olmayacaq
	System.out.println(file.getOriginalFilename()); //file in adi 
	try {
		InputStream stream=file.getInputStream();
		File java1= new File("C:/java1");
		//qovluq eger varsa 
		if(java1.exists()) {
			
		}else {
			java1.mkdir();
			}
		UUID uuid =UUID.randomUUID();
		String randomName=uuid.toString();
		
		String format=file.getOriginalFilename()
				.substring(file.getOriginalFilename().lastIndexOf("."));

		randomName+=format; //sekil gedib random adnan save olunacaq
		Files.copy(stream, Paths.get("C:/java1/"+randomName),
				StandardCopyOption.REPLACE_EXISTING);
		//REPLACE_EXISTING islemek istediyimiz file artiq disk de varsa onu silib sonuncu gonderdiyimizi saxliyir
	} catch (Exception exc) {
		exc.printStackTrace();
	}
	return "";
}
}
