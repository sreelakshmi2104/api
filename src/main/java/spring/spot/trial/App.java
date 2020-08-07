package spring.spot.trial;

import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.EmployeeAwards;
import spring.spot.trial.util.VelToPdf;

public class App {
    public static void main(String[] args) {
        try {
            Employee employee = null;
            EmployeeAwards employeeAwards = null;
            CertGenerate certGenerator = new CertGenerate();
            String htmlData = certGenerator.certGenerate(employee,employeeAwards);
            VelToPdf.velocityToPdf(htmlData);
            // SendEmail.sendmail("btsignit99@gmail.com","yashu2020","btsignite99@gmail.com","anushajadhikar99@gmail.com", new File("Test.pdf"));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
