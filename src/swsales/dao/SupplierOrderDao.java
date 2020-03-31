package swsales.dao;

import java.util.List;

import swsales.model.Product;
import swsales.model.SupplierOrder;



public interface SupplierOrderDao {
	SupplierOrder selectSupplierOrderLastDate();
	
	List<SupplierOrder> selectSupplierOrderByAll();
	
	int insertSupplierOrder(SupplierOrder so);
	int updateSupplierOrder(SupplierOrder so);
	int deleteSupplierOrder(SupplierOrder so);

	int selectSupplierOrderPno(Product so);
}
