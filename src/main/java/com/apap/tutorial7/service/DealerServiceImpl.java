package com.apap.tutorial7.service;

import java.util.Optional;
import java.util.List;

import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.repository.DealerDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DealerServiceImpl implements DealerService {
	@Autowired
	private DealerDb dealerDb;

	@Override
	public Optional<DealerModel> getDealerDetailById(Long id) {
		// TODO Auto-generated method stub
		return dealerDb.findById(id);
	}

	@Override
	public DealerModel addDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		 
		 return dealerDb.save(dealer);
		
	}
	
	@Override
	public void deleteDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		dealerDb.delete(dealer);
		
	}
	
	@Override
	public List<DealerModel> allDealer() {
		// TODO Auto-generated method stub
		return dealerDb.findAll();
		
	}

	@Override
	public void updateDealer(long id, DealerModel dealer) {
		// TODO Auto-generated method stub
		DealerModel updated = dealerDb.getOne(id);
		updated.setAlamat(dealer.getAlamat());
		updated.setNoTelp(dealer.getNoTelp());
		dealerDb.save(updated);
	}

}
