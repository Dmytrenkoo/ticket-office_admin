package ua.com.kisit.ticketoffice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ua.com.kisit.ticketoffice.entity.TrainHasRoute;
import ua.com.kisit.ticketoffice.repository.TrainHasRouteRepository;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final TrainHasRouteRepository trainHasRouteRepository;

public List<TrainHasRoute> findAllTimetables(){
     return trainHasRouteRepository.findAll();
}

    public void saveCategory(TrainHasRoute trainHasRoute){
        trainHasRouteRepository.save(trainHasRoute); // insert
    }

    public void updateTimetable(TrainHasRoute trainHasRoute){
        trainHasRouteRepository.save(trainHasRoute); // update +id
    }

    public void  deleteTimetable(TrainHasRoute trainHasRoute){
        trainHasRouteRepository.delete(trainHasRoute);
    }

    public void deleteAllTimetable(){
        trainHasRouteRepository.deleteAll();
    }

    public long convertor(Date date){

// Використовуємо Calendar для об'єднання дати і часу
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
// Отримуємо об'єднаний Date об'єкт
        Date combinedDateTime = calendar.getTime();
// Виводимо результат
        return combinedDateTime.getTime();

    }


    public List<TrainHasRoute> searchRoutes(List<TrainHasRoute> trainHasRoutes,
                                            String arrivalStation,
                                            String arrivalTime1,
                                            String arrivalTime2,
                                            Date arrivalDateTime) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String formattedDate = formatter.format(arrivalDateTime);

        String dateMinString = formattedDate + " " + arrivalTime1;
        String dateMaxString = formattedDate + " " + arrivalTime2;
        System.out.println(dateMinString);
       /* String dateMinString  = "18.05.2024 10:00" ;
        String dateMaxString = "18.05.2024 16:50";*/
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date1 = new Date() ;
        Date date2 = new Date();

        try {
            date1 = sdf.parse(dateMinString);

            date2 = sdf.parse(dateMaxString);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        long dateMin = date1.getTime();
        long dateMax = date2.getTime();
        System.out.println(dateMin +" "+ dateMax);

        return trainHasRoutes
                .stream()
                .filter(thr1 -> thr1.getRoutes().getArrivalStation().equalsIgnoreCase(arrivalStation))
                .filter(thr1 -> (convertor(thr1.getArrivalDateTime()) >= dateMin &&
                        convertor(thr1.getArrivalDateTime()) <= dateMax))

                .collect(Collectors.toList());
    }
}


