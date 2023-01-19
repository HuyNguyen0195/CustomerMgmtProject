package pkg.cogent.dao;

import java.util.Scanner;
import pkg.cogent.exception.MandatoryFieldExcpetion;
import pkg.cogent.model.Customer;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CustomerDAOImpl implements CustomerDAO {

	Customer customers[];
	Scanner sc=new Scanner(System.in);
	@Override
	public void create() {
		
		System.out.println("How many customer you want to store?");
		int size=sc.nextInt();
		customers=new Customer[size];
		for(int i=0;i<customers.length;i++)
		{
			Customer cust=new Customer();
			System.out.println("Please enter customer ID:");
			String cid=sc.next();		
			System.out.println("Please enter customer name:");
			String cname=sc.next();
			System.out.println("Please enter customer email ");
			String eMail=sc.next();
			System.out.println("Please enter customer Date of Birth ");
			String dob=sc.next();
			cust.setcId(cid);
			cust.setcName(cname);
			cust.setcEmail(eMail);
			cust.setcDob(dob);
			validateMandatoryField(cust);
			customers[i]=cust;
		}
	}
	
	public void validateMandatoryField(Customer customer)
	{
		if(customer==null)
		{
			throw new MandatoryFieldExcpetion("Customer object can not be left blank");
		}
		else if(customer.getcId()==null)
		{
			throw new MandatoryFieldExcpetion("Customer ID can not be left blank");
		}
	}

	@Override
	public void read() {
		for(int i=0;i<customers.length;i++)
		{
			System.out.println("Customer ID:"+customers[i].getcId());
			System.out.println("Customer  name:"+customers[i].getcName());
			System.out.println("Customer e-mail:"+customers[i].getcEmail());
			System.out.println("Customer Date of Birth: year-month-date"+customers[i].getcDob());

		}
	}

	@Override
	public void update(String customerId) {
		// TODO Auto-generated method stub
		for(int i=0; i<customers.length;i++) {
			if(customers[i] == null ) continue;
			if(customers[i].getcId() == customerId) {
				System.out.println("Found Customer");
				System.out.println("what you want to edit");
				System.out.println("1-name");
				System.out.println("2-email");
				System.out.println("3-date of birth");
				Scanner sc = new Scanner(System.in);
				int s= sc.nextInt();
				switch(s) {
					case 1:	{
						String data=sc.next();
						customers[i].setcName(data);
						break;
					}
					case 2:	{
						String data=sc.next();
						customers[i].setcEmail(data);
						break;
					}
					case 3:	{
						String data=sc.next();
						customers[i].setcDob(data);
						break;
					}
				}
				System.out.println("Customer ID: "+customers[i].getcId());
				System.out.println("Customer Name: "+customers[i].getcName());
				break;
			}
		}
	}

	@Override
	public void delete(String customerId) {
		// TODO Auto-generated method stub
		for(int i=0; i<customers.length;i++) {
			if(customers[i] == null ) continue;
			if(customers[i].getcId() == customerId) {
				System.out.println("Deleted Customer");
				System.out.println("Customer ID: "+customers[i].getcId());
				System.out.println("Customer Name: "+customers[i].getcName());
				customers[i]=null;
				break;
			}
		}
	}
	@Override
	public void findCustomerById(String cID) {
		// TODO Auto-generated method stub
		for(int i=0; i<customers.length;i++) {
			if(customers[i] == null ) continue;
			if(customers[i].getcId() == cID) {
				System.out.println("Found Customer");
				System.out.println("Customer ID: "+customers[i].getcId());
				System.out.println("Customer Name: "+customers[i].getcName());
				break;
			}
		}
	}
	
	@Override
	public void findYongestCustomer() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("mm-dd-yyyy");
		Date date= sdf.parse(customers[0].getcDob());
		int index=0;
		for(int i=1; i<customers.length;i++) {
			if(customers[i] == null ) continue;
			Date cDate = sdf.parse(customers[i].getcDob());
			if( date.compareTo(cDate) == 1  ) {
				date = cDate;
				index=i;
			}
		}
		System.out.println("Customer ID:"+customers[index].getcId());
		System.out.println("Customer  name:"+customers[index].getcName());
		System.out.println("Customer e-mail:"+customers[index].getcEmail());
		System.out.println("Customer Date of Birth: year-month-date"+customers[index].getcDob());

	}
	}

}
