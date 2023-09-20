package www.dream.bbs.common.fileattachment.model.dto;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import www.dream.bbs.common.fileattachment.service.PlaybleContentTypes;
import www.dream.bbs.framework.util.JsonUtil;

@Entity
@Table(name="t_attach")
@NoArgsConstructor
@Getter
@Setter
public class AttachFileDTO {
//			uuid         char(32),
//			path         varchar(2000),
//			name		 varchar(500),
//			ext			 varchar(255),
//			type		 varchar(50),
	
	public static final String THUMBNAIL_FILE_PREFIX = "thumb_";
	public static final String THUMBNAIL_FILE_POSTFIX = ".png";

	@Id
	@Expose(serialize = true)
	private String uuid;
	
	//서버에서 관리된 경로 정보
	@Column(name="path")
	@Expose(serialize = true)
	private String uploadPath;

	//원본 파일 이름. 화면에 출력 용도
	//c:\sss/bb/aaa.txt => aaa.txt
	@Column(name="name")
	@Expose(serialize = true)
	private String originalFilePureName;
	
	@Column(name="name")
	@Expose(serialize = true)
	private String fileExt;
	
	@Column(name="name")
	@Expose(serialize = true)
	private PlaybleContentTypes contentType;
	
	@Expose(serialize = true)
	private String jsonRepresentation;
	
	public AttachFileDTO(String path, String originalFilePureName, String fileExt, String uuid) {
		this.originalFilePureName = originalFilePureName;
		this.uploadPath = path;
		this.fileExt = fileExt;
		this.uuid = uuid;
	}
	
	public static AttachFileDTO deserialize(String jsonStr) {
		try {
			return (AttachFileDTO) JsonUtil.deserialize(jsonStr, AttachFileDTO.class);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String getJsonRepresentation() throws Exception {
		return JsonUtil.getJsonRepresentation(this);
	}

	public File findThumnailFile() {
		return new File(uploadPath + File.separator + buildThumnailFileName(uuid + originalFilePureName));
	}
	
	public File findUploadedFile() {
		return new File(uploadPath + File.separator + uuid + originalFilePureName);
	}

	public static String buildThumnailFileName(String uploadFilePureName) {
		return THUMBNAIL_FILE_PREFIX + uploadFilePureName + THUMBNAIL_FILE_POSTFIX;
	}

	public void setContentType(PlaybleContentTypes contentType) {
		this.contentType = contentType;
	}

	public void deleteUploadedFiles() {
		findUploadedFile().delete();
		findThumnailFile().delete();
	}
}
