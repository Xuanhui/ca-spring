package sa45.t6.sims.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.Partinfo;
import sa45.t6.sims.repository.PartInfoRepository;

@Service
public class PartInfoServiceImpl implements PartInfoService{
	
	@Resource
	private PartInfoRepository partInfoRepository;
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.PartInfoService#findAllPartInfo()
	 */
	@Override
	public ArrayList<Partinfo> findAllPartInfo() {
		ArrayList<Partinfo> l = (ArrayList<Partinfo>) partInfoRepository.findAll();		
		return l;
	}
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.PartInfoService#findpartInfo(int)
	 */
	@Override
	@Transactional
	public Partinfo findpartInfo(int id)
	{
		return partInfoRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.PartInfoService#createPartInfo(sa45.t6.sims.model.PartInfo)
	 */
	@Override
	@Transactional
	public Partinfo createPartInfo(Partinfo partInfo) {
		return partInfoRepository.saveAndFlush(partInfo);
	}
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.PartInfoService#changePartInfo(sa45.t6.sims.model.PartInfo)
	 */
	@Override
	@Transactional
	public Partinfo changePartInfo(Partinfo partInfo)
	{
		return partInfoRepository.saveAndFlush(partInfo);
	}
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.PartInfoService#removePartInfo(sa45.t6.sims.model.PartInfo)
	 */
	@Override
	@Transactional
	public void removePartInfo(Partinfo partInfo)
	{
		partInfoRepository.delete(partInfo);
	}

	@Override
	public ArrayList<Partinfo> SearchPartBypn(int id) {
		ArrayList<Partinfo> plist = partInfoRepository.SearchByPartNumber(id);
		return plist;
	}

	@Override
	public ArrayList<Partinfo> SearchPartBypnInstock(int id) {
		ArrayList<Partinfo> plist = partInfoRepository.SearchByPartNumberInstock(id);
		return plist;
	}

	/*@Override
	public void ChangeStatus(int id) {
		partInfoRepository.UpdateStatus(id);
	}
*/
	

}


