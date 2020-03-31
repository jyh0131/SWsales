package swsales.dao;

import java.util.List;

import swsales.model.Product;
import swsales.model.SupplierPurchase;



public interface SupplierPurchaseDao {
	SupplierPurchase selectSupplierPurchaseLastDate();
	
	List<SupplierPurchase> selectSupplierPurchaseByAll();
	
	int insertSupplierPurchase(SupplierPurchase sp);
	int updateSupplierPurchase(SupplierPurchase sp);
	int deleteSupplierPurchase(SupplierPurchase sp);

	int selectSupplierPurchasePno(Product sp);
}
