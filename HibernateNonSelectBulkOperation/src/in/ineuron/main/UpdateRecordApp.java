package in.ineuron.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class UpdateRecordApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Query query = session.createQuery("UPDATE in.ineuron.Model.Employee SET esalary=esalary+ :increment WHERE eno<=:id");
			
			query.setParameter("increment",10000);
			query.setParameter("id", 10);
			count = query.executeUpdate();
			flag = true;
			
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
			
		}finally {
			
			if(flag) {
				System.out.println("No of records updated :: "+count);
			}else {
				System.out.println("Updation failed...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
		
		
		
		

	}

}
