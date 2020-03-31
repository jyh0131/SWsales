package swsales.dao;

import java.util.List;

import swsales.model.Supplier;



public interface SupplierDao {
	Supplier selectSupplierByNo(Supplier supplier);
	Supplier selectSupplierByName(Supplier supplier);
	Supplier selectSuppplierLastData();
	
	
	List<Supplier> selectSupplierByAll();
	List<Supplier> selectSupplierListByName(Supplier selectSupplier);
	List<Supplier> selectSupplierListByBln(Supplier selectSupplier);
	List<Supplier> selectSupplierListByTel(Supplier selectSupplier);
	
	int insertSupplier(Supplier supplier);
	int updateSupplier(Supplier supplier);
	int deleteSupplier(Supplier supplier);
	
	
}
