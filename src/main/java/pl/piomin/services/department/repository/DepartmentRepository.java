package pl.piomin.services.department.repository;

import pl.piomin.services.department.model.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentRepository {

	private List<Department> departments = new ArrayList<>();
	
	public Department add(Department department) {
		department.setId((long) (departments.size()+1));
		departments.add(department);
		return department;
	}
	
	public Department findById(Long id) {
		return departments.stream()
				.filter(a -> a.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No class found"));
	}
	
	public List<Department> findAll() {
		return departments;
	}
	
	public List<Department> findByOrganization(Long organizationId) {
		return departments.stream()
				.filter(a -> a.getOrganizationId().equals(organizationId))
				.collect(Collectors.toList());
	}
	
}
