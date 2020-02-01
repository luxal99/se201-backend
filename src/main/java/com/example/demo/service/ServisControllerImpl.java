package com.example.demo.service;

import com.example.demo.controller.SlobodniTermin;
import com.example.demo.dto.ServisDTO;
import com.example.demo.entity.*;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServisControllerImpl implements RegistrationService, KlijentInterface, ServiceInterface {

    private static Connection connection = null;
    private static String url = "jdbc:mysql://35.246.218.201:3306";
    private static String username = "luxal";
    private static String password = "Lukic.aleksa99";
    private static String databaseName = "car_service";

    public static void openConection() throws SQLException {
        connection = DriverManager.getConnection(url + "/" + databaseName, username, password);
    }

    @Override
    public Klijent saveClient(Klijent klijent) throws SQLException {
        Klijent returnedClient = new Klijent();

        try {
            openConection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into car_service.klijent(name, lastname, telephone) values (?,?,?)");
            preparedStatement.setString(1, klijent.getName());
            preparedStatement.setString(2, klijent.getLastname());
            preparedStatement.setString(3, klijent.getTelephone());
            preparedStatement.execute();

            PreparedStatement getSaveClient = connection.prepareStatement("select *\n" +
                    "from klijent where id_client = (select max(id_client) from  klijent)");

            ResultSet resultSet = getSaveClient.executeQuery();
            while (resultSet.next()) {
                returnedClient.setIdKlijent(resultSet.getLong(1));
                returnedClient.setName(resultSet.getString(2));
                returnedClient.setLastname(resultSet.getString(3));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return returnedClient;
    }

    @Override
    public String registerUser(Klijent klijent) throws SQLException {

        Klijent savedClient = saveClient(klijent);
        try {
            openConection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into car_service.korisnik(id_client, username, password) VALUES (?,?,?)");
            preparedStatement.setLong(1, savedClient.getIdKlijent());
            preparedStatement.setString(2, klijent.getUsername());
            preparedStatement.setString(3, klijent.getPassword());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Sacuvan";
    }


    @Override
    public String zakaziServis(Servis servis, Integer tip, String username, String password) throws SQLException {
        Klijent klijent = findClient(username, password);
        openConection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO car_service.servis(id_client, `date`, `time`, car, car_model) values (?,?,?,?,?) ");

        preparedStatement.setLong(1, klijent.getIdKlijent());
        preparedStatement.setString(2, servis.getDate());
        preparedStatement.setString(3, servis.getTime());
        preparedStatement.setString(4, servis.getCar());
        preparedStatement.setString(5, servis.getCarModel());

        preparedStatement.execute();

        PreparedStatement preparedStatement1 = connection.prepareStatement("select * from car_service.servis where id_service = (select MAX(id_service) from servis)");
        ResultSet resultSet = preparedStatement1.executeQuery();

        while (resultSet.next()) {
            if (tip == 1) {
                servis = new ServisKlime();
                servis.setIdService(resultSet.getLong(1));
                PreparedStatement preparedStatement2 = connection.prepareStatement("insert into car_service.servis_klime(id_service) value (?)");
                preparedStatement2.setLong(1, servis.getIdService());
                preparedStatement2.execute();
            } else if (tip == 2) {
                servis = new ServisUlja();
                servis.setIdService(resultSet.getLong(1));
                PreparedStatement preparedStatement2 = connection.prepareStatement("insert into car_service.servis_ulja(id_service) value (?)");
                preparedStatement2.setLong(1, servis.getIdService());
                preparedStatement2.execute();
            } else if (tip == 3) {
                servis = new MehanickiServis();
                servis.setIdService(resultSet.getLong(1));
                PreparedStatement preparedStatement2 = connection.prepareStatement("insert into car_service.mehanicki_servis(id_service) value (?)");
                preparedStatement2.setLong(1, servis.getIdService());
                preparedStatement2.execute();
            }
        }
        System.out.println(tip);
        return "Uspesno zakazan servis";
    }

    @Override
    public List<ServisDTO> getAllService(String username, String password) {
        List<ServisDTO> servisDTOList = new ArrayList<>();
        try {
            openConection();
            PreparedStatement preparedStatement = connection.prepareStatement("select date, time, car, car_model, sk.id_ac_service, ms.id_mehanic_service, su.id_oil_service\n" +
                    "from servis\n" +
                    "         left outer join klijent k on servis.id_client = k.id_client\n" +
                    "         left outer join servis_klime sk on servis.id_service = sk.id_service\n" +
                    "         left outer join mehanicki_servis ms on servis.id_service = ms.id_service\n" +
                    "         left outer join servis_ulja su on servis.id_service = su.id_service\n" +
                    "where k.id_client = (select k2.id_client\n" +
                    "                     from car_service.korisnik\n" +
                    "                              join klijent k2 on korisnik.id_client = k2.id_client\n" +
                    "                     where username = ?\n" +
                    "                       and password = ?);");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                ServisDTO servisDTO = new ServisDTO();
                servisDTO.setDate(resultSet.getString(1));
                servisDTO.setType(resultSet.getString(2));
                servisDTO.setCar(resultSet.getString(3));
                servisDTO.setCarModel(resultSet.getString(4));
                servisDTO.setIdServisKlime(resultSet.getLong(5));
                servisDTO.setIdMehanickiServis(resultSet.getLong(6));
                servisDTO.setIdServisUlja(resultSet.getLong(7));

                if (servisDTO.getIdServisUlja()!=0){
                    servisDTO.setType("Servis ulja");
                }else if(servisDTO.getIdServisKlime()!=0){
                    servisDTO.setType("Servis klime");
                }else if(servisDTO.getIdMehanickiServis()!=0){
                    servisDTO.setType("Mehanicki servis");
                }
                servisDTOList.add(servisDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servisDTOList;
    }

    @Override
    public Klijent findClient(String username, String password) throws SQLException {
        Klijent klijent = new Klijent();
        try {
            openConection();
            PreparedStatement preparedStatement = connection.prepareStatement("select k.id_client,k.name,k.lastname,k.telephone\n" +
                    "from korisnik\n" +
                    "         join klijent k on korisnik.id_client = k.id_client\n" +
                    "where username = ?\n" +
                    "  and password = ?");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                klijent.setIdKlijent(resultSet.getLong(1));
                ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return klijent;
    }

    @Override
    public List<SlobodniTermin> dosputniTermini() {
        List<SlobodniTermin> slobodniTerminList = new ArrayList<>();
        try {
            openConection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from car_service.available_service");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                SlobodniTermin slobodniTermin = new SlobodniTermin();
                slobodniTermin.setIdAvailableService(resultSet.getLong(1));
                slobodniTermin.setDate(resultSet.getString(2));
                slobodniTermin.setTime(resultSet.getString(3));

                slobodniTerminList.add(slobodniTermin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slobodniTerminList;
    }
}
