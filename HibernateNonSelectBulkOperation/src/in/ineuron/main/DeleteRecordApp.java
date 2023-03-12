package in.ineuron.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class DeleteRecordApp {

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
			
			Query query = session.createQuery("DELETE FROM in.ineuron.Model.Employee  WHERE eno=:id");
	
			query.setParameter("id", 28);
			count = query.executeUpdate();
			flag = true;
			
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
			
		}finally {
			
			if(flag) {
				System.out.println("No of records deleted :: "+count);
			}else {
				System.out.println("Deletion failed...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
		
		
		
		

	}

}
