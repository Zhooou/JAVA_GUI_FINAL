/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Appointment.Appointment;
import Business.Appointment.StudyRoom;
import Business.Book.Book;
import Business.Book.BookDirectory;
import Business.Coffee.Coffee;
import Business.Enterprise.CafeEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LibraryEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.AdminRole;
import Business.Role.LibrarianRole;
import Business.Role.StudentRole;
import Business.Role.SystemAdminRole;
import Business.Role.TutorRole;
import Business.Role.WorkerRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AppointmentRequest;
import Business.WorkQueue.BookRequest;
import Business.WorkQueue.CoffeeRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author runyangzhou
 */
public class ConfigureASystem {
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        Person person = system.getPersonDirectory().createPerson("sysadmin");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
        
        testData(system);
        
        return system;
    }
    
    public static void testData(EcoSystem system){
        Network network = new Network();
        network.setName("Northeastern");
        system.getNetworkList().add(network);
        
        //Library Admin
        LibraryEnterprise libEnterprise = (LibraryEnterprise) network.getEnterpriseDirectory().createAndAddEnterprise("LibEnterprise", Enterprise.EnterpriseType.Library);
        Person admin1 = libEnterprise.getPersonDirectory().createPerson("libadmin");
        libEnterprise.getUserAccountDirectory().createUserAccount("libadmin", "libadmin", admin1, new AdminRole());
        
        //Cafe Admin
        CafeEnterprise cafeEnterprise = (CafeEnterprise) network.getEnterpriseDirectory().createAndAddEnterprise("Cafe", Enterprise.EnterpriseType.Cafe);
        Person admin2 = cafeEnterprise.getPersonDirectory().createPerson("cafeadmin");
        cafeEnterprise.getUserAccountDirectory().createUserAccount("cafeadmin", "cafeadmin", admin1, new AdminRole());
        
        ArrayList<Book> bookList = libEnterprise.getBookDirectory().getBookList();
        readBook(bookList);
        
        Organization libOrganization = libEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.Librarian);
        Person lib1 = libOrganization.getPersonDirectory().createPerson("Jessy Lib");
        UserAccount ua11 = libOrganization.getUserAccountDirectory().createUserAccount("lib1", "lib1", lib1, new LibrarianRole());
        
        Person lib2 = libOrganization.getPersonDirectory().createPerson("Tom Lib");
        UserAccount ua12 = libOrganization.getUserAccountDirectory().createUserAccount("lib2", "lib2", lib2, new LibrarianRole());
        
        Person lib3 = libOrganization.getPersonDirectory().createPerson("Annie Lib");
        UserAccount ua13 = libOrganization.getUserAccountDirectory().createUserAccount("lib3", "lib3", lib3, new LibrarianRole());
        
        Organization stuOrganization = libEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.Student);
        Person stu1 = stuOrganization.getPersonDirectory().createPerson("Lily Stu");
        UserAccount ua1 = stuOrganization.getUserAccountDirectory().createUserAccount("stu1", "stu1", stu1, new StudentRole());
        
        Person stu2 = stuOrganization.getPersonDirectory().createPerson("John Stu");
        UserAccount ua2 = stuOrganization.getUserAccountDirectory().createUserAccount("stu2", "stu2", stu2, new StudentRole());
        
        Person stu3 = stuOrganization.getPersonDirectory().createPerson("Bob Stu");
        UserAccount ua3 = stuOrganization.getUserAccountDirectory().createUserAccount("stu3", "stu3", stu3, new StudentRole());
        
        Person stu4 = stuOrganization.getPersonDirectory().createPerson("Bill Stu");
        stuOrganization.getUserAccountDirectory().createUserAccount("stu4", "stu4", stu4, new StudentRole());
        
        Person stu5 = stuOrganization.getPersonDirectory().createPerson("Kevin Stu");
        stuOrganization.getUserAccountDirectory().createUserAccount("stu5", "stu5", stu5, new StudentRole());
        
        Person stu6 = stuOrganization.getPersonDirectory().createPerson("Nina Stu");
        stuOrganization.getUserAccountDirectory().createUserAccount("stu6", "stu6", stu6, new StudentRole());
        
        Person stu7 = stuOrganization.getPersonDirectory().createPerson("Rachel Stu");
        stuOrganization.getUserAccountDirectory().createUserAccount("stu7", "stu7", stu7, new StudentRole());
        
        Organization tutorOrganization = libEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.Tutor);
        Person tutor1 = tutorOrganization.getPersonDirectory().createPerson("Jessica Tutor");
        UserAccount ua4 = tutorOrganization.getUserAccountDirectory().createUserAccount("tutor1", "tutor1", tutor1, new TutorRole());
        
        Person tutor2 = tutorOrganization.getPersonDirectory().createPerson("Will Tutor");
        UserAccount ua5 = tutorOrganization.getUserAccountDirectory().createUserAccount("tutor2", "tutor2", tutor2, new TutorRole());
        
        Person tutor3 = tutorOrganization.getPersonDirectory().createPerson("Dalton Tutor");
        UserAccount ua6 = tutorOrganization.getUserAccountDirectory().createUserAccount("tutor3", "tutor3", tutor3, new TutorRole());
        
        ArrayList<Coffee> coffeeList = cafeEnterprise.getCoffeeDirectory().getCoffeeList();
        
        readCoffee(coffeeList);
        
        Organization workerOrganization = cafeEnterprise.getOrganizationDirectory().createOrganization(Organization.Type.Worker);
        Person worker1 = workerOrganization.getPersonDirectory().createPerson("Urban Woker");
        UserAccount ua7 = workerOrganization.getUserAccountDirectory().createUserAccount("worker1", "worker1", worker1, new WorkerRole());
        
        Person worker2 = workerOrganization.getPersonDirectory().createPerson("Dorena Woker");
        UserAccount ua8 = workerOrganization.getUserAccountDirectory().createUserAccount("worker2", "worker2", worker2, new WorkerRole());
        
        Person worker3 = workerOrganization.getPersonDirectory().createPerson("Geri Woker");
        UserAccount ua9 = workerOrganization.getUserAccountDirectory().createUserAccount("worker3", "worker3", worker3, new WorkerRole());
//        addBookRequest(libEnterprise, ua1, ua2, ua3, ua11, ua12, ua13);
        readBookRequest(libEnterprise);
        readCoffeeRequest(libEnterprise, cafeEnterprise);
        readAppointmentRequest(libEnterprise);
    }
    
    public static void readBook(ArrayList<Book> bookList){
        File f=new File("Book.csv");
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(f));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            try {
                line = br.readLine(); //read header
                line = br.readLine();
                while (line != null) {
                    String[] bookData = line.split(",");
                    Book book = new Book(bookData[0]);
                    book.setStorage(Integer.parseInt(bookData[1]));
                    bookList.add(book);
                    line = br.readLine();
                }
            }catch (IOException ex) {
                Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readCoffee(ArrayList<Coffee> coffeeList){
        Coffee c1 = new Coffee("Americano", 10.0);
        Coffee c2 = new Coffee("Latte", 8);
        Coffee c3 = new Coffee("Mocha", 8.5);
        Coffee c4 = new Coffee("Indian", 9);
        Coffee c5 = new Coffee("Galao", 10);
        Coffee c6 = new Coffee("Cuben", 12.8);
        Coffee c7 = new Coffee("Cortado", 14.8);
        Coffee c8 = new Coffee("Creama", 6.2);
        Coffee c9 = new Coffee("Bicerin", 7.2);
        Coffee c10 = new Coffee("Espresso", 6.2);
        Coffee c11 = new Coffee("Flat White", 5);
        Coffee c12 = new Coffee("Frappuccino", 18);
        coffeeList.add(c1);
        coffeeList.add(c2);
        coffeeList.add(c3);
        coffeeList.add(c4);
        coffeeList.add(c5);
        coffeeList.add(c6);
        coffeeList.add(c7);
        coffeeList.add(c8);
        coffeeList.add(c9);
        coffeeList.add(c10);
        coffeeList.add(c11);
        coffeeList.add(c12);
    }
    
    public static void readBookRequest(LibraryEnterprise libEnterprise){
        File f=new File("BookRequest.csv");
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(f));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            try {
                line = br.readLine(); //read header
                line = br.readLine();
                while (line != null) {
                    String[] bookRequestData = line.split(",");
                    String bookName = bookRequestData[0];
                    Book b = null;
                    for(Book book : libEnterprise.getBookDirectory().getBookList())
                        if(book.getName().equals(bookName)){
                            b = book;
                            break;
                        }
                    ArrayList<Book> bookList = new ArrayList();
                    bookList.add(b);
                    UserAccount stu = null;
                    for(Organization organization : libEnterprise.getOrganizationDirectory().getOrganizationList())
                        for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList())
                            if(ua.getUsername().equals(bookRequestData[1])){
                                stu = ua;
                                break;
                            }
                    
                    UserAccount lib = null;
                    for(Organization organization : libEnterprise.getOrganizationDirectory().getOrganizationList())
                        for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList())
                            if(ua.getUsername().equals(bookRequestData[2])){
                                lib = ua;
                                break;
                            }            
                    
                    BookRequest bookRequest = new BookRequest();
                    bookRequest.setSender(stu);
                    bookRequest.setReceiver(lib);
                    bookRequest.setStatus(bookRequestData[3]);
                    bookRequest.setBookList(bookList);
                    
                    libEnterprise.getBookQueue().getBookRequestList().add(bookRequest);
                    stu.getBookQueue().getBookRequestList().add(bookRequest);
                    line = br.readLine();
                }
            }catch (IOException ex) {
                Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readCoffeeRequest(LibraryEnterprise libEnterprise, CafeEnterprise cafeEnterprise){
        File f=new File("CoffeeRequest.csv");
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(f));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            try {
                line = br.readLine(); //read header
                line = br.readLine();
                while (line != null) {
                    String[] coffeeRequestData = line.split(",");
                    String coffeeName = coffeeRequestData[0];
                    Coffee c = null;
                    for(Coffee coffee : cafeEnterprise.getCoffeeDirectory().getCoffeeList())
                        if(coffee.getName().equals(coffeeName)){
                            c = coffee;
                            break;
                        }
                    HashMap<Coffee, Integer> cart = new HashMap();
                    cart.put(c, Integer.parseInt(coffeeRequestData[1]));
                    UserAccount stu = null;
                    for(Organization organization : libEnterprise.getOrganizationDirectory().getOrganizationList())
                        for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList())
                            if(ua.getUsername().equals(coffeeRequestData[2])){
                                stu = ua;
                                break;
                            }
                    
                    UserAccount worker = null;
                    for(Organization organization : cafeEnterprise.getOrganizationDirectory().getOrganizationList())
                        for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList())
                            if(ua.getUsername().equals(coffeeRequestData[3])){
                                worker = ua;
                                break;
                            }            
                    
                    CoffeeRequest coffeeRequest = new CoffeeRequest();
                    coffeeRequest.setSender(stu);
                    coffeeRequest.setCoffeeOrder(cart);
                    coffeeRequest.setReceiver(worker);
                    coffeeRequest.setStatus(coffeeRequestData[4]);
                    cafeEnterprise.getCoffeeQueue().getCoffeeRequestList().add(coffeeRequest);
                    stu.getCoffeeQueue().getCoffeeRequestList().add(coffeeRequest);
            
                    line = br.readLine();
                }
            }catch (IOException ex) {
                Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readAppointmentRequest(LibraryEnterprise libEnterprise){
        File f=new File("AppointmentRequest.csv");
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(f));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            try {
                line = br.readLine(); //read header
                line = br.readLine();
                while (line != null) {
                    String[] appointmentRequestData = line.split(",");
                    int roomNumber;
                    
                    StudyRoom sr = null;
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    
                    Date date = null;
                    String session = appointmentRequestData[1];
                    try {
                        date = df.parse(appointmentRequestData[2]);
                    } catch (ParseException ex) {
                        Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    UserAccount stu = null;
                    for(Organization organization : libEnterprise.getOrganizationDirectory().getOrganizationList())
                        for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList())
                            if(ua.getUsername().equals(appointmentRequestData[3])){
                                stu = ua;
                                break;
                            }
                    
                    UserAccount tutor = null;
                    for(Organization organization : libEnterprise.getOrganizationDirectory().getOrganizationList())
                        for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList())
                            if(ua.getUsername().equals(appointmentRequestData[4])){
                                tutor = ua;
                                break;
                            }            
                    Appointment appointment = new Appointment(date, session);
                    AppointmentRequest appointmentRequest = new AppointmentRequest(appointment);
                    appointmentRequest.setSender(stu);
                    if(!appointmentRequestData[0].equals("")){
                        roomNumber = Integer.parseInt(appointmentRequestData[0]);
                        for(StudyRoom studyRoom : libEnterprise.getStudyRoomDirectory().getStudyRoomList()){
                            if(studyRoom.getNumber() == roomNumber){
                                sr = studyRoom;
                                appointment.setStudyRoom(sr);
                                break;
                            }
                        }
                    }
                    
                    appointmentRequest.setReceiver(tutor);
                    appointmentRequest.setStatus(appointmentRequestData[5]);
                    libEnterprise.getAppointmentQueue().getAppointmentRequestList().add(appointmentRequest);
                    stu.getAppointmentQueue().getAppointmentRequestList().add(appointmentRequest);
                    
                    
                    if(appointmentRequest.getStatus().equals("Cancelled"))
                        libEnterprise.getAppointmentQueue().getAppointmentRequestList().remove(appointmentRequest);
                    
                    line = br.readLine();
                }
            }catch (IOException ex) {
                Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
