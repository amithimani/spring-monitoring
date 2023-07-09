# Spring Boot Monitoring Project

This project provides a simple example of a Spring Boot application with monitoring capabilities using Prometheus and Spring Actuator. The application includes a REST controller (`EmployeeController.java`) that exposes a GET endpoint (`/employee`) to retrieve the name of an employee based on the provided ID. The application also includes a service class (`EmployeeService.java`) that retrieves the employee name from a static map.

## Project Structure

The project follows a standard Maven directory structure and includes a single package `dev.knowledgecafe.spring-monitoring` containing the application code.

- `src/main/java`: Contains the Java source code files.
  - `dev.knowledgecafe.spring-monitoring`: Contains the main application class and controller/service classes.
- `src/main/resources`: Contains the application configuration files.
- `pom.xml`: Maven project configuration file.

## Dependencies

The project is built using Maven and includes the following dependencies:

- Spring Boot Starter Web: Provides the necessary dependencies for building a web application with Spring Boot.
- Spring Boot Actuator: Enables Spring Boot monitoring and exposes health data to Prometheus.
- Prometheus Client: Allows integration with Prometheus for collecting and exposing application metrics.

## Usage

1. Clone the repository:

   ```bash
   git clone <repository-url>
   ```

2. Build the project using Maven:

   ```bash
   cd spring-monitoring
   mvn clean install
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. Access the application's endpoint:

   Open a web browser or use tools like cURL or Postman to access the following endpoint:

   ```
   GET http://localhost:8080/employee?id=<employee-id>
   ```

   Replace `<employee-id>` with the ID of the employee you want to retrieve. The endpoint will return the name of the employee if found in the static map; otherwise, it will return the message "No Employee Found".

5. Access Prometheus metrics:

   Open a web browser and navigate to `http://localhost:8080/actuator/prometheus` to access the Prometheus metrics endpoint exposed by Spring Actuator.

## Monitoring with Prometheus and Grafana

To enable monitoring with Prometheus and Grafana, follow these steps:

1. Install Prometheus and Grafana on your system.

2. Configure Prometheus to scrape the metrics endpoint of this Spring Boot application. Add the following configuration to the `prometheus.yml` file:

   ```yaml
   scrape_configs:
     - job_name: 'spring-monitoring'
       metrics_path: '/actuator/prometheus'
       static_configs:
         - targets: ['localhost:8080']
   ```

3. Start Prometheus and Grafana.

4. Configure Grafana to connect to Prometheus and import pre-built dashboards or create custom ones to visualize the metrics collected by Prometheus.

With the monitoring stack set up, you can now explore and analyze the metrics collected from your Spring Boot application using Grafana's rich visualization capabilities.

## License

This project is licensed under the [Apache License](LICENSE).

Feel free to explore, modify, and use this project as a starting point for your own Spring Boot monitoring applications.

If you have any questions or need further assistance, please reach out to the project contributors.

Happy monitoring!
