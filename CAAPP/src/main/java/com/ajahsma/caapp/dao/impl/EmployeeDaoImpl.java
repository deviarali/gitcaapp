package com.ajahsma.caapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.ajahsma.caapp.dao.EmployeeDao;
import com.ajahsma.caapp.model.EmployeeModel;


@Repository
public class EmployeeDaoImpl extends DefaultDaoImpl implements EmployeeDao{

	@Override
	public EmployeeModel findByEmailOrMobile(String employeeEmail, String employeeMobile) {
		Criteria criteria = getSession().createCriteria(EmployeeModel.class, "employee");
		
		criteria.add(Restrictions.or(Restrictions.eq("employee.employeeEmail", employeeEmail).ignoreCase(), 
						Restrictions.eq("employee.employeeMobile", employeeMobile)));
		
		EmployeeModel  uniqueResult = (EmployeeModel ) criteria.uniqueResult();
		return uniqueResult;
	}

	@Override
	public Integer findEmployeeCountByEmailOrMobile(String employeeEmail, String employeeMobile) {
		Criteria criteria = getSession().createCriteria(EmployeeModel.class, "employee");
		criteria.add(Restrictions.or(Restrictions.eq("employee.employeeEmail", employeeEmail).ignoreCase(), Restrictions.eq("employee.employeeMobile", employeeMobile)));
		
		return criteria.list().size();
	}

	@Override
	public List<EmployeeModel> getAssigneeList() {
		Criteria criteria = getSession().createCriteria(EmployeeModel.class);
		List<EmployeeModel> assigneeList = criteria.list();
		return assigneeList;
	}

	@Override
	public List<EmployeeModel> findEmployees() {
		Criteria criteria = getSession().createCriteria(EmployeeModel.class);
		return criteria.list();
	}

	@Override
	public EmployeeModel getEmployee(Long id) {
		Criteria criteria = getSession().createCriteria(EmployeeModel.class);
		criteria.add(Restrictions.eq("id", id));
		return (EmployeeModel) criteria.uniqueResult();
	}

	@Override
	public Long getEmployeeFromApplicationUser(Long applicationUserId) {

		Query query = createQuery("select distinct e.id from Employee e inner join e.applicationUser au where au.id = :applicationUserId ");
		query.setParameter("applicationUserId", applicationUserId);

		List<Long> empIds = query.list();
		if (!CollectionUtils.isEmpty(empIds)) {
			return empIds.get(0);
		}
		return new Long(0);

	}

}
