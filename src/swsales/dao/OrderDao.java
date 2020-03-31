package swsales.dao;

import java.util.List;

import swsales.model.Client;
import swsales.model.MajorClient;
import swsales.model.Order;
import swsales.model.OrderRanking;



public interface OrderDao {
	Order selectOrderLastDate();
	
	List<Order> selectOrderByAll();
	
	int insertOrder(Order order);
	int updateOrder(Order order);
	int deleteOrder(Order order);

	List<Order> selectClientOrderList(Client info);

	List<Order> selectOrderListByCal(String startDate, String endDate, Client info);

	Order selectOrderByNo(int i);

	void updateOrderDps1(Order order);

	void updateOrderDps0(Order order);

	int selectSalesMoney(String startDate, String endDate, int dept);

	List<OrderRanking> selectOrderMoney(String firstDate, String lastDate, Client info);

	int selectOrderTotalMoney(String firstDate, String lastDate, Client info);

	List<MajorClient> selectMajorClientList();
}
