package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	ArrayList<Employee> employees = new ArrayList<Employee>();
	int lastSsn;

	Stage window;
	Scene scene;
	Label chooseType = new Label("Choose Employee Type");

	TextField firstName = new TextField();
	TextField lastName = new TextField();
	TextField ssn = new TextField();
	
	TextField searchUpdateSsn = new TextField();
	TextField grossSalas = new TextField();
	TextField commissionRate = new TextField();
	TextField baseSalary = new TextField();
	TextField weeklySalary = new TextField();
	TextField wage = new TextField();
	TextField hours = new TextField();

	Label firstNamel = new Label("First Name");
	Label lastNamel = new Label("Last Name");
	Label ssnl = new Label("SSN");
	Label searchUpdateSsnl = new Label("Search/Update SSN");
	Label salaryl = new Label("SALARY");
	Label salaryValue = new Label("");
	Label commissionRatel = new Label("Commision Rate");
	Label baseSalaryl = new Label("Base Salary");
	Label weeklySalaryl = new Label("Weekly Salary");
	Label wagel = new Label("Wage");
	Label hoursl = new Label("Hours");
	Label grossSalasl = new Label("Gross Sales");
	Label space = new Label("                  ");

	Button add = new Button("Add");
	Button search = new Button("Search by SSN");
	Button update = new Button("Update by SSN");
	Button clean = new Button("Clean textFields");

	public void function(Employee employee) {
		if (firstName.getText() != "") {
			employee.setFirstName(firstName.getText());
		}
		if (lastName.getText() != "") {
			employee.setLastName(lastName.getText());
		}
		if (ssn.getText() != "") {
			employee.setSocialSecurityNumber(ssn.getText());
		}
	}

	public int getLassn() throws IOException {
		File logFile = new File("text.txt");
		if (logFile.length() == 0) {
			return 0;
		} else {
			FileReader fr = new FileReader("text.txt");
			BufferedReader br = new BufferedReader(fr);
			String last = null, line;

			while ((line = br.readLine()) != null) {
				last = line;
			}
			String[] employee = last.split(",");
			return Integer.valueOf(employee[3]);
		}

	}

	public void start(Stage primaryStage) throws IOException {
		ssn.setDisable(true);
		lastSsn = getLassn();
		window = primaryStage;
		window.setTitle("EMPLOYEE SALARY CALCULATER");

		File f = new File("text.txt");
		if (!f.exists()) {
			f.createNewFile();
		} else {
			// read text.txt file and add employee in employees
			FileReader fr = new FileReader("text.txt");
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				String[] employee = br.readLine().split(",");
				if (employee[0].equals("Salaried Employee")) {
					SalariedEmployee employeeS = new SalariedEmployee(employee[1], employee[2], employee[3],
							Double.valueOf(employee[4]));
					employees.add(employeeS);
				} else if (employee[0].equals("Hourly Employee")) {
					HourlyEmployee employeeH = new HourlyEmployee(employee[1], employee[2], employee[3],
							Double.valueOf(employee[4]), Double.valueOf(employee[5]));
					employees.add(employeeH);
				} else if (employee[0].equals("Commission Rate Employee")) {
					CommissionEmployee employeeC = new CommissionEmployee(employee[1], employee[2], employee[3],
							Double.valueOf(employee[4]), Double.valueOf(employee[5]));
					employees.add(employeeC);
				} else if (employee[0].equals("Base Plus Commision Rate Employee")) {
					BasePlusCommissionEmployee employeeB = new BasePlusCommissionEmployee(employee[1], employee[2],
							employee[3], Double.valueOf(employee[4]), Double.valueOf(employee[5]),
							Double.valueOf(employee[6]));
					employees.add(employeeB);
				}

			}
		}

		// Drop down Menu
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("Salaried Employee", "Hourly Employee", "Commission Rate Employee",
				"Base Plus Commision Rate Employee", "None");

		// According to your selection, related text fields are enabled, unrelated text
		// fields are disabled
		choiceBox.setOnAction(e -> {
			if (choiceBox.getValue() == "Salaried Employee") {
				firstName.setDisable(false);
				lastName.setDisable(false);
				//ssn.setDisable(true);
				grossSalas.setDisable(true);
				commissionRate.setDisable(true);
				baseSalary.setDisable(true);
				weeklySalary.setDisable(false);
				wage.setDisable(true);
				hours.setDisable(true);

			} else if (choiceBox.getValue() == "Hourly Employee") {
				firstName.setDisable(false);
				lastName.setDisable(false);
				//ssn.setDisable(true);
				grossSalas.setDisable(true);
				commissionRate.setDisable(true);
				baseSalary.setDisable(true);
				weeklySalary.setDisable(true);
				wage.setDisable(false);
				hours.setDisable(false);

			} else if (choiceBox.getValue() == "Commission Rate Employee") {
				firstName.setDisable(false);
				lastName.setDisable(false);
				//ssn.setDisable(true);
				grossSalas.setDisable(false);
				commissionRate.setDisable(false);
				baseSalary.setDisable(true);
				weeklySalary.setDisable(true);
				wage.setDisable(true);
				hours.setDisable(true);

			} else if (choiceBox.getValue() == "Base Plus Commision Rate Employee") {
				firstName.setDisable(false);
				lastName.setDisable(false);
				//ssn.setDisable(true);
				grossSalas.setDisable(false);
				commissionRate.setDisable(false);
				baseSalary.setDisable(false);
				weeklySalary.setDisable(true);
				wage.setDisable(true);
				hours.setDisable(true);

			} else if (choiceBox.getValue() == "None") {
				firstName.setDisable(true);
				lastName.setDisable(true);
				//ssn.setDisable(true);
				grossSalas.setDisable(true);
				commissionRate.setDisable(true);
				baseSalary.setDisable(true);
				weeklySalary.setDisable(true);
				wage.setDisable(true);
				hours.setDisable(true);
			}

		});

		// menu
		GridPane middle = new GridPane();
		middle.setAlignment(Pos.CENTER);
		middle.setHgap(10);
		middle.setVgap(10);

		middle.add(firstNamel, 0, 0);
		middle.add(firstName, 1, 0);

		middle.add(lastNamel, 0, 1);
		middle.add(lastName, 1, 1);

		middle.add(ssnl, 0, 2);
		middle.add(ssn, 1, 2);

		middle.add(searchUpdateSsnl, 0, 3);
		middle.add(searchUpdateSsn, 1, 3);

		middle.add(salaryl, 0, 4);
		middle.add(salaryValue, 1, 4);

		middle.add(space, 2, 0);

		middle.add(grossSalasl, 3, 0);
		middle.add(grossSalas, 4, 0);

		middle.add(commissionRatel, 3, 1);
		middle.add(commissionRate, 4, 1);

		middle.add(baseSalaryl, 3, 2);
		middle.add(baseSalary, 4, 2);

		middle.add(weeklySalaryl, 3, 3);
		middle.add(weeklySalary, 4, 3);

		middle.add(wagel, 3, 4);
		middle.add(wage, 4, 4);

		middle.add(hoursl, 3, 5);
		middle.add(hours, 4, 5);

		HBox top = new HBox(10);
		top.getChildren().addAll(chooseType, choiceBox);
		top.setAlignment(Pos.CENTER);
		top.setPadding(new Insets(15, 0, 15, 0));

		HBox bottom = new HBox(10);
		bottom.getChildren().addAll(add, search, update, clean);
		bottom.setAlignment(Pos.CENTER);
		bottom.setPadding(new Insets(20, 0, 20, 0));

		VBox vBox = new VBox(top, middle, bottom);

		scene = new Scene(vBox, 670, 340);
		window.setScene(scene);
		window.show();

		// clean TexField
		clean.setOnAction(e -> {
			firstName.clear();
			lastName.clear();
			ssn.clear();
			searchUpdateSsn.clear();
			salaryValue.setText("");
			grossSalas.clear();
			commissionRate.clear();
			baseSalary.clear();
			weeklySalary.clear();
			wage.clear();
			hours.clear();
		});

		// search By SSN
		search.setOnAction(e -> {
			boolean display = true;
			for (Employee employee : employees) {
				if (employee.getSocialSecurityNumber().equals(searchUpdateSsn.getText())) {
					AlertBox.display("Employee İnformation", employee.toString() + "\n");
					display = false;
					break;
				}
			}
			if (display) {
				AlertBox.display("Employee İnformation", "There is no employee that SSN.");
			}
		});

		// Update By SSN
		update.setOnAction(e -> {
			if (searchUpdateSsn.getText() != "") {
				boolean askUser = true;
				// Fİnd employee to chance information
				for (Employee employee : employees) {
					if (employee.getSocialSecurityNumber().equals(searchUpdateSsn.getText())) {
						if (employee instanceof SalariedEmployee) {
							function(employee);
							if (weeklySalary.getText() != "") {
								try {
									((SalariedEmployee) employee).setWeekSalary(Double.valueOf(weeklySalary.getText()));
								} catch (IllegalArgumentException i) {
									if (i.getMessage().contains("weeklySalary")) {
										AlertBox.display("Employee Salary Calculater",
												"Weekly salary must be greater or equol to zero");
										askUser = false;
									}
								}
							}
							break;
						}
						if (employee instanceof HourlyEmployee) {
							function(employee);
							if (wage.getText() != "") {
								try {
									((HourlyEmployee) employee).setWage(Double.valueOf(wage.getText()));
								} catch (IllegalArgumentException i) {
									if (i.getMessage().contains("wage")) {
										AlertBox.display("Employee Salary Calculater",
												"Wage must be greater or equol to zero");
										askUser = false;
									}
								}

							}
							if (hours.getText() != "") {
								try {
									((HourlyEmployee) employee).setHours(Double.valueOf(hours.getText()));
								} catch (IllegalArgumentException i) {
									if (i.getMessage().contains("hours")) {
										AlertBox.display("Employee Salary Calculater",
												"Hours must  be 0<= hours < 168");
										askUser = false;
									}
								}

							}
							break;
						}
						if (employee instanceof CommissionEmployee
								&& !(employee instanceof BasePlusCommissionEmployee)) {
							function(employee);
							if (grossSalas.getText() != "") {
								try {
									((CommissionEmployee) employee).setGrossSales(Double.valueOf(grossSalas.getText()));
								} catch (IllegalArgumentException i) {
									if (i.getMessage().contains("grossSales")) {
										AlertBox.display("Employee Salary Calculater",
												"Gross Sales must be greater or equol to zero");
										askUser = false;
									}
								}

							}
							if (commissionRate.getText() != "") {
								try {
									((CommissionEmployee) employee)
											.setCommisionRate(Double.valueOf(commissionRate.getText()));
								} catch (IllegalArgumentException i) {
									if (i.getMessage().contains("commisionRate")) {
										AlertBox.display("Employee Salary Calculater",
												"Commision rate must be betwenn 0-1");
										askUser = false;
									}
								}

							}
							break;
						}
						if (employee instanceof BasePlusCommissionEmployee) {
							function(employee);
							if (grossSalas.getText() != "") {
								try {
									((BasePlusCommissionEmployee) employee)
											.setGrossSales(Double.valueOf(grossSalas.getText()));
								} catch (IllegalArgumentException i) {
									if (i.getMessage().contains("grossSales")) {
										AlertBox.display("Employee Salary Calculater",
												"Gross Sales must be greater or equol to zero");
										askUser = false;
									}
								}

							}
							if (commissionRate.getText() != "") {
								try {
									((BasePlusCommissionEmployee) employee)
											.setCommisionRate(Double.valueOf(commissionRate.getText()));
								} catch (IllegalArgumentException i) {
									if (i.getMessage().contains("commisionRate")) {
										AlertBox.display("Employee Salary Calculater",
												"Commision rate must be betwenn 0-1");
										askUser = false;
									}
								}

							}
							if (baseSalary.getText() != "") {
								try {

									((BasePlusCommissionEmployee) employee)
											.setBaseSalery(Double.valueOf(baseSalary.getText()));
								} catch (IllegalArgumentException i) {
									if (i.getMessage().contains("baseSalery")) {
										AlertBox.display("Employee Salary Calculater",
												"Base salary must be greater or equol to zero");
										askUser = false;
									}
								}

							}
							break;

						}

					}
				}

				boolean answer = false;

				if (askUser) {
					answer = ConfirmBox.display("Employee ", "Ara you sure?");
				}

				if (answer) {
					// Delete everything
					BufferedWriter writer;
					try {
						writer = Files.newBufferedWriter(Paths.get("text.txt"));
						writer.write("");
						writer.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					// Write text.txt file

					for (Employee employee : employees) {
						if (employee instanceof SalariedEmployee) {
							try {
								BufferedWriter x = new BufferedWriter(new FileWriter("text.txt", true));
								x.append("Salaried Employee" + "," + employee.getFirstName() + ","
										+ employee.getLastName() + "," + employee.getSocialSecurityNumber() + ","
										+ ((SalariedEmployee) employee).getWeekSalary() + "\n");
								x.close();
							} catch (IOException e1) {

							}
						}
						if (employee instanceof HourlyEmployee) {
							try {
								BufferedWriter x = new BufferedWriter(new FileWriter("text.txt", true));
								x.append("Hourly Employee" + "," + employee.getFirstName() + ","
										+ employee.getLastName() + "," + employee.getSocialSecurityNumber() + ","
										+ ((HourlyEmployee) employee).getWage() + ","
										+ ((HourlyEmployee) employee).getHours() + "\n");

								x.close();
							} catch (IOException e1) {

							}
						}
						if (employee instanceof CommissionEmployee
								&& !(employee instanceof BasePlusCommissionEmployee)) {
							try {
								BufferedWriter x = new BufferedWriter(new FileWriter("text.txt", true));
								x.append("Commission Rate Employee" + "," + employee.getFirstName() + ","
										+ employee.getLastName() + "," + employee.getSocialSecurityNumber() + ","
										+ ((CommissionEmployee) employee).getGrossSales() + ","
										+ ((CommissionEmployee) employee).getCommisionRate() + "\n");

								x.close();
							} catch (IOException e1) {

							}
						}
						if (employee instanceof BasePlusCommissionEmployee) {
							try {
								BufferedWriter x = new BufferedWriter(new FileWriter("text.txt", true));
								x.append("Base Plus Commision Rate Employee" + "," + employee.getFirstName() + ","
										+ employee.getLastName() + "," + employee.getSocialSecurityNumber() + ","
										+ ((BasePlusCommissionEmployee) employee).getGrossSales() + ","
										+ ((BasePlusCommissionEmployee) employee).getCommisionRate() + ","
										+ ((BasePlusCommissionEmployee) employee).getBaseSalery() + "\n");
								x.close();
							} catch (IOException e1) {

							}
						}
					}

				}
			}

		});

		// add employee into array list and text.txt
		add.setOnAction(e -> {
			if (choiceBox.getValue() == "Salaried Employee") {

				lastSsn++;
				if (firstName.getText() != "" && lastName.getText() != "" && weeklySalary.getText() != "") {
					try {

						SalariedEmployee employee = new SalariedEmployee(firstName.getText(), lastName.getText(),
								String.valueOf(lastSsn), Double.valueOf(weeklySalary.getText()));
						employees.add(employee);
						ssn.setText(employee.getSocialSecurityNumber());
						salaryValue.setText(String.valueOf(employee.getPaymentAmount()));
						try {
							BufferedWriter x = new BufferedWriter(new FileWriter("text.txt", true));
							x.append("Salaried Employee" + "," + firstName.getText() + "," + lastName.getText() + ","
									+ String.valueOf(lastSsn) + "," + weeklySalary.getText() + "\n");
							x.close();
						} catch (IOException e1) {

						}
					} catch (IllegalArgumentException i) {
						if (i.getMessage().contains("weeklySalary")) {
							AlertBox.display("Employee Salary Calculater",
									"Weekly salary must be greater or equol to zero");
						}

					}

				} else {
					AlertBox.display("Employee Salary Calculater", "Fill needed place");
				}
			} else if (choiceBox.getValue() == "Hourly Employee") {
				lastSsn++;
				if (firstName.getText() != "" && lastName.getText() != "" && wage.getText() != ""
						&& hours.getText() != "") {
					try {
						HourlyEmployee employee = new HourlyEmployee(firstName.getText(), lastName.getText(),
								String.valueOf(lastSsn), Double.valueOf(wage.getText()),
								Double.valueOf(hours.getText()));
						employees.add(employee);
						ssn.setText(employee.getSocialSecurityNumber());
						salaryValue.setText(String.valueOf(employee.getPaymentAmount()));
						try {
							BufferedWriter x = new BufferedWriter(new FileWriter("text.txt", true));
							x.append("Hourly Employee" + "," + firstName.getText() + "," + lastName.getText() + ","
									+ String.valueOf(lastSsn) + "," + wage.getText() + "," + hours.getText() + "\n");
							x.close();
						} catch (IOException e1) {

						}

					} catch (IllegalArgumentException i) {
						if (i.getMessage().contains("wage")) {
							AlertBox.display("Employee Salary Calculater", "Wage must be greater or equol to zero");
						} else if (i.getMessage().contains("hours")) {
							AlertBox.display("Employee Salary Calculater", "Hours must  be 0<= hours < 168");
						}
					}

				} else {
					AlertBox.display("Employee Salary Calculater", "Fill needed place");
				}

			} else if (choiceBox.getValue() == "Commission Rate Employee") {
				lastSsn++;
				if (firstName.getText() != "" && lastName.getText() != "" && grossSalas.getText() != ""
						&& commissionRate.getText() != "") {
					try {
						CommissionEmployee employee = new CommissionEmployee(firstName.getText(), lastName.getText(),
								String.valueOf(lastSsn), Double.valueOf(grossSalas.getText()),
								Double.valueOf(commissionRate.getText()));
						employees.add(employee);
						ssn.setText(employee.getSocialSecurityNumber());
						salaryValue.setText(String.valueOf(employee.getPaymentAmount()));
						try {
							BufferedWriter x = new BufferedWriter(new FileWriter("text.txt", true));
							x.append("Commission Rate Employee" + "," + firstName.getText() + "," + lastName.getText()
									+ "," + String.valueOf(lastSsn) + "," + grossSalas.getText() + ","
									+ commissionRate.getText() + "\n");
							x.close();
						} catch (IOException e1) {

						}

					} catch (IllegalArgumentException i) {
						if (i.getMessage().contains("commisionRate")) {
							AlertBox.display("Employee Salary Calculater", "Commision rate must be betwenn 0-1");
						} else if (i.getMessage().contains("grossSales")) {
							AlertBox.display("Employee Salary Calculater",
									"Gross sales must be greater or equol to zero");
						}

					}

				} else {
					AlertBox.display("Employee Salary Calculater", "Fill needed place");
				}

			} else if (choiceBox.getValue() == "Base Plus Commision Rate Employee") {
				lastSsn++;
				if (firstName.getText() != "" && lastName.getText() != "" && grossSalas.getText() != ""
						&& commissionRate.getText() != "" && baseSalary.getText() != "") {

					try {
						BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(firstName.getText(),
								lastName.getText(), String.valueOf(lastSsn), Double.valueOf(grossSalas.getText()),
								Double.valueOf(commissionRate.getText()), Double.valueOf(baseSalary.getText()));
						employees.add(employee);
						ssn.setText(employee.getSocialSecurityNumber());
						salaryValue.setText(String.valueOf(employee.getPaymentAmount()));
						try {
							BufferedWriter x = new BufferedWriter(new FileWriter("text.txt", true));
							x.append("Base Plus Commision Rate Employee" + "," + firstName.getText() + ","
									+ lastName.getText() + "," + String.valueOf(lastSsn) + "," + grossSalas.getText()
									+ "," + commissionRate.getText() + "," + baseSalary.getText() + "\n");
							x.close();
						} catch (IOException e1) {

						}
					} catch (IllegalArgumentException i) {
						if (i.getMessage().contains("commisionRate")) {
							AlertBox.display("Employee Salary Calculater", "Commision rate must be betwenn 0-1");
						} else if (i.getMessage().contains("grossSales")) {
							AlertBox.display("Employee Salary Calculater",
									"Gross sales must be greater or equol to zero");
						} else if (i.getMessage().contains("baseSalery")) {
							AlertBox.display("Employee Salary Calculater",
									"Base Salary must be greater or equol to zero");
						}

					}

				} else {
					AlertBox.display("Employee Salary Calculater", "Fill needed place");
				}
			}

		});

	}

}
