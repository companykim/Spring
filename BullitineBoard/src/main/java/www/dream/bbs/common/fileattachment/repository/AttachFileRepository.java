package www.dream.bbs.common.fileattachment.repository;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import www.dream.bbs.common.fileattachment.model.dto.AttachFileDTO;

public interface AttachFileRepository extends JpaRepository<AttachFileDTO, String>{
	/** list up */
	/** create */
	/** delete */
	/** delete all */
}
