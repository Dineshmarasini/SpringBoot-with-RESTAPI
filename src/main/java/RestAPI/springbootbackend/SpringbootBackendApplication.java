package RestAPI.springbootbackend;

import RestAPI.springbootbackend.model.Employee;
import RestAPI.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		Employee employee = new Employee();
		employee.setFirstName("dinesh");
		employee.setSecondName("marasini");
		employee.setEmailId("dinesh.marasini123@gmail.com");
		employeeRepository.save(employee);


		Employee employee1 = new Employee();
		employee1.setFirstName("kalyan");
		employee1.setSecondName("Sendang");
		employee1.setEmailId("Ks123@gmail.com");
		employeeRepository.save(employee1);

	}
}
