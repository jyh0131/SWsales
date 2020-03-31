package swsales.dao;

import java.util.List;

import swsales.model.InventoryQuantity;
import swsales.model.Product;



public interface IQDao {
	List<InventoryQuantity> selectInventoryQuantityByAll();
	
	int insertIQ(InventoryQuantity iq);
	int updateIQ(InventoryQuantity iq);
	int deleteIQ(InventoryQuantity iq);

	int selectIqQtyByPname(Product proSummary);
	
	void subIqQty(Product subProduct, int sub);

	InventoryQuantity selectIQLastDate();
}
