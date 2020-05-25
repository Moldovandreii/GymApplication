package com.project.services;

import com.project.dao.ClientDAO;
import com.project.entities.Attendance;
import com.project.entities.Client;
import com.project.entities.Diet;
import com.project.entities.Trainer;
import com.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void createClient(String name, String password, Trainer trainer, Diet diet) {
        clientRepository.save(Client.builder().name(name).password(password).trainer(trainer).diet(diet).build());
    }

    @Override
    public List<Client> findByTrainer(Trainer trainer) {
        return clientRepository.findByTrainer(trainer);
    }

    @Override
    public Client findByUsernameAndPassword(String name, String password) {
        return clientRepository.findByNameAndPassword(name, password);
    }

    @Override
    public Client findByTrainerAndName(Trainer trainer, String name) {
        return clientRepository.findByTrainerAndName(trainer, name);
    }

    @Override
    public void update(int id, String name, String password) {
        Client client = clientRepository.findById(id).get();
        Date date1;
        Date date2 = new Date();
        if(client.getAttendanceDate() != null){
            date1 = client.getAttendanceDate().getLastLogin();
            client.getAttendanceDate().setLastLogin(date2);
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(date1);
            cal2.setTime(date2);
            boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                    cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
            if(!sameDay){
                int att = client.getAttendanceDate().getAttendance();
                att++;
                client.getAttendanceDate().setAttendance(att);
            }
            clientRepository.save(client);
        }else{
            Attendance attendanceData = Attendance.builder().client(client).lastLogin(date2).attendance(1).build();
            client.setAttendanceDate(attendanceData);
            clientRepository.save(client);
        }
    }

    public List<ClientDAO> findByTrainerDAO(Trainer trainer){
        List<Client> clients = clientRepository.findByTrainer(trainer);
        List<ClientDAO> clientDAOS = new ArrayList<ClientDAO>();
        for(int i=0; i<clients.size(); i++){
            ClientDAO client = new ClientDAO();
            client.setClientId(clients.get(i).getClientId());
            client.setName(clients.get(i).getName());
            client.setPassword(clients.get(i).getPassword());
            clientDAOS.add(client);
        }
        return clientDAOS;
    }

    public void changeTrainer(int id, Trainer trainer){
        Client client = clientRepository.findByClientId(id);
        //attendanceRepository.deleteByClient(client);
        //clientRepository.deleteByClientId(id);
        clientRepository.save(Client.builder().clientId(id).name(client.getName()).password(client.getPassword()).trainer(trainer).diet(client.getDiet()).build());
    }

    public void changeDiet(int id, Diet diet){
        Client client = clientRepository.findByClientId(id);
        clientRepository.save(Client.builder().clientId(id).name(client.getName()).password(client.getPassword()).trainer(client.getTrainer()).diet(diet).build());
    }
}
