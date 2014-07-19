package com.beerworld.beer.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.beerworld.beer.dao.DistributionCenterDAO;
import com.beerworld.beer.model.DistributionCenter;

@Component
public class DistributionCenterServiceImpl implements DistributionCenterService {

	private DistributionCenterDAO distributionCenterDAO;
	
	@Inject
	public DistributionCenterServiceImpl(DistributionCenterDAO distributionCenterDAO){
		
		this.distributionCenterDAO = distributionCenterDAO;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public String saveDistributionCenter(DistributionCenter distributionCenter) {
		// TODO Auto-generated method stubo[]\
		distributionCenterDAO.save(distributionCenter);
		
		return null;
	}

	@Override
	public List<DistributionCenter> getAllDistributionCenters() {
		return 	distributionCenterDAO.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public void deleteDistributionCenter(Long id ) {
		distributionCenterDAO.delete(distributionCenterDAO.findByPrimaryKey((Long)id));		
	}

	
	@Override
	public DistributionCenter getDistributionCenterByID(Long id) {
		// TODO Auto-generated method stub
		return distributionCenterDAO.findByPrimaryKey(id);
	}
	
}


