package swsales.dao;

import java.util.List;

import swsales.model.Product;



public interface ProductDao {
	Product selectProductLastData();
	
	List<Product> selectProductByAll();
	
	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(Product product);

	Product selectProductByName(Product overlapProduct);
	String selectSupplierByPName(Product product);

	List<Product> selectProductListByName(Product product);
	List<Product> selectProductListByCate(Product product);
	List<Product> selectProductListBySupp(Product product);

	int selectProductCost(Product product);
	int selectProductNo(Product product);

	byte[] selectProductPic(Product product);

	Product selectProductSummary(Product product);

	void subProductQty(Product subProduct, int sub);
}
