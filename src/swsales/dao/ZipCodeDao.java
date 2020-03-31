package swsales.dao;

import java.util.List;

import swsales.model.ZipCode;



public interface ZipCodeDao {
	List<ZipCode> selectZipCodeSearch(ZipCode zipcode);	
	ZipCode selectAddressSearchNumAll(ZipCode zipSearch);
	ZipCode selectAddressSearchNumOne(ZipCode zipSearch);
}
