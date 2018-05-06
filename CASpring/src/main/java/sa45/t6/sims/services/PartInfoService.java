package sa45.t6.sims.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.Partinfo;
@Service
public interface PartInfoService {

	ArrayList<Partinfo> findAllPartInfo();

	Partinfo findpartInfo(int id);

	Partinfo createPartInfo(Partinfo partInfo);

	Partinfo changePartInfo(Partinfo partInfo);

	void removePartInfo(Partinfo partInfo);
	
	ArrayList<Partinfo> SearchPartBypn(int id);
	
	ArrayList<Partinfo> SearchPartBypnInstock(int id);



}