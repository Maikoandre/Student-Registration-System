package br.com.school.aplication;

import java.util.Scanner;
import br.com.school.dao.StudentDAO;
import br.com.school.model.Student;

public class Main {

	public static void main(String[] args) throws Exception {
		/*StudentDAO studentDAO = new StudentDAO();
		Student student = new Student();
		student.setName("Maria Heloiza");
		student.setEmail("maria1234@gmail.com");
		student.setCourse("Agronomia");
		//studentDAO.save(student);
		
		Student student2 = new Student();
		student2.setName("Heloiza");
		student2.setEmail("qwerty@gmail.com");
		student2.setCourse("ADS");
		student2.setId(2);
		studentDAO.update(student2);

		Student student3 = new Student();
		student3.setId(3);
		//studentDAO.delete(student3);

		studentDAO.listStudents(studentDAO);*/

		boolean end = false;
		Scanner scanner = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAO();
		do{
			System.out.println("Digte a opção desejada:");
			System.out.println("1. Cadastrar aluno");
			System.out.println("2. Listar alunos");
			System.out.println("3. Editar aluno");
			System.out.println("4. Excluir aluno");
			System.out.println("5. Sair");
			int option = scanner.nextInt();
			switch (option) {
				case 1:
					System.out.println("Informe os dados do aluno:");
					System.out.println("Nome: ");
					Student student = new Student();
					student.setName(scanner.nextLine());
					System.out.println("Email: ");
					student.setEmail(scanner.nextLine());
					System.out.println("Curso: ");
					student.setCourse(scanner.nextLine());
					studentDAO.save(student);
					System.out.println("Aluno cadastrado com sucesso!");
					break;
				case 2:
					System.out.println("Listando todos os alunos:");
					studentDAO.listStudents(studentDAO);
					break;
				case 3:
				System.out.println("Informe as informações do aluno:");
					Student student2 = new Student();
					System.out.println("Nome: ");
					student2.setName(scanner.nextLine());
					System.out.println("Email: ");
					student2.setEmail(scanner.nextLine());
					System.out.println("Curso: ");
					student2.setCourse(scanner.nextLine());
					System.out.println("Id: ");
					student2.setId(scanner.nextInt());
					studentDAO.update(student2);
					System.out.println("Aluno editado com sucesso!");
					break;
				case 4:
				System.out.println("Informe o id do aluno:");
					Student student3 = new Student();
					student3.setId(scanner.nextInt());
					studentDAO.delete(student3);
					System.out.println("Aluno excluído com sucesso!");
					break;
				case 5:
					end = true;
					System.out.println("Saiu do programa!");
					break;
				default:
					break;
			}
		}while(!end);
		scanner.close();
	}

	

}
