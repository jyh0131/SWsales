package swsales.dao;

import java.util.List;

import swsales.model.ClientDelivery;
import swsales.model.Order;



public interface ClientDeliveryDao {
	List<ClientDelivery> selectClientDeliveryByAll();
	
	ClientDelivery selectClientDeliveryLastNo();
	
	int insertClientDelivery(ClientDelivery cd);
	int updateClientDelivery(ClientDelivery cd);
	int deleteClientDelivery(ClientDelivery cd);

	ClientDelivery selectClientDeliveryByOno(Order order);

	void deleteClientDeliveryByOno(ClientDelivery cd);

}
