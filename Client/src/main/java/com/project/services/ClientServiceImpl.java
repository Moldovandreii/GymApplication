//package com.project.services;
//
//import com.project.entities.Attendance;
//import com.project.entities.Client;
//import com.project.entities.Trainer;
//import com.project.repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class ClientServiceImpl implements ClientService{
//    private ClientRepository clientRepository;
//
//    @Autowired
//    public ClientServiceImpl(ClientRepository clientRepository){
//        this.clientRepository = clientRepository;
//    }
//
//    @Override
//    public Client findById(int id) {
//        return clientRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void createClient(String name, String password, Trainer trainer) {
//        clientRepository.save(Client.builder().name(name).password(password).trainer(trainer).build());
//    }
//
//    @Override
//    public List<Client> findByTrainer(Trainer trainer) {
//        return clientRepository.findByTrainer(trainer);
//    }
//
//    @Override
//    public Client findByUsernameAndPassword(String name, String password) {
//        return clientRepository.findByNameAndPassword(name, password);
//    }
//
//    @Override
//    public Client findByTrainerAndName(Trainer trainer, String name) {
//        return clientRepository.findByTrainerAndName(trainer, name);
//    }
//
//    @Override
//    public void update(int id, String name, String password) {
//        Client client = clientRepository.findById(id).get();
//        Date date1;
//        Date date2 = new Date();
//        if(client.getAttendanceDate() != null){
//            date1 = client.getAttendanceDate().getLastLogin();
//            client.getAttendanceDate().setLastLogin(date2);
//            Calendar cal1 = Calendar.getInstance();
//            Calendar cal2 = Calendar.getInstance();
//            cal1.setTime(date1);
//            cal2.setTime(date2);
//            boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
//                    cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
//            if(!sameDay){
//                int att = client.getAttendanceDate().getAttendance();
//                att++;
//                client.getAttendanceDate().setAttendance(att);
//            }
//            clientRepository.save(client);
//        }else{
//            Attendance attendanceData = Attendance.builder().client(client).lastLogin(date2).attendance(1).build();
//            client.setAttendanceDate(attendanceData);
//            clientRepository.save(client);
//        }
//
//    }
//}
