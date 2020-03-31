package swsales.dao;

import java.util.List;

import swsales.model.Client;


public interface ClientDao {
	Client selectClientByNo(Client client);
	Client selectClientByName(Client client);
	Client selectClientLastData();
	String selectClientsEmpName(Client client);
	int selectClientsEmpNo(String empName);
	
	List<Client> selectClientByAll();
	List<Client> selectClientListByName(Client selectClient);
	List<Client> selectClientListByCeo(Client selectClient);
	List<Client> selectClientListByTel(Client selectClient);
	List<Client> selectClientListBySalesman(Client selectClient);
	
	int insertClient(Client client);
	int updateClient(Client client);
	int deleteClient(Client client);
	int selectClientNo(Client client);
	int selectCsalesman(Client client);

		
	/************ (+) 추가 : 아름 ************/
	Client loginClient(Client client);
	String selectClientById(String idChk);
	Client selectClientByID2(Client client);
	Client selectClientByMail(Client client);
	int updateClientPassword(Client client);
}
