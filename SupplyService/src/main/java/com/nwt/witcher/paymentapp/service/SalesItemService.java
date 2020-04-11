package com.nwt.witcher.paymentapp.service;
import java.util.List;
import com.nwt.witcher.paymentapp.model.SalesItem;

public interface SalesItemService {
	
	List<SalesItem> get();
	SalesItem get(int id);
	void save(SalesItem proizvod);
	void delete(int id);
}
