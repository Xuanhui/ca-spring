package sa45.t6.sims.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa45.t6.sims.model.Partinfo;

public interface PartInfoRepository extends JpaRepository<Partinfo, Integer>{

	@Query("select d from Partinfo d where d.partnumber = :eid")
	ArrayList<Partinfo> SearchByPartNumber(@Param("eid") int eid);
	
	@Query("select d from Partinfo d where d.partnumber = :eid and d.status = 'Instock'")
	ArrayList<Partinfo> SearchByPartNumberInstock(@Param("eid") int eid);
	


}
