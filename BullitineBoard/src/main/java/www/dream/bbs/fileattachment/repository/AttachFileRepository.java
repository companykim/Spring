package www.dream.bbs.fileattachment.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Embeddable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import www.dream.bbs.fileattachment.model.dto.AttachFileDTO;
import www.dream.bbs.iis.model.TagVO;

public interface AttachFileRepository extends JpaRepository<AttachFileDTO, String>{
	/** list up
	select *
	from t_attach
	where Owner_Type = #{ownerTypefgf}
	And Owner_Id = #{ownerIdff} */
	List<AttachFileDTO> findByOwnerTypeAndOwnerId(String ownerTypefgf, String ownerId);

	/** create 
	@Query(nativeQuery = true, 
			value="insert into t_attach(owner_type, owner_id, uuid, path, name, type_ordinal)"
					+ "values(:obj.ownerType, :obj.ownerId, :obj.uuid, :obj.uploadPath, :obj.originalFilePureName, :obj.typeOrdinal)")
	int saveAttachFileDTO(@Param("obj") AttachFileDTO obj);
*/
	
	/** delete */
	/** delete all */
}
