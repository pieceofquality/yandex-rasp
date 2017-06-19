


package ru.yandex.rasp.selenium.tests;

import org.testng.annotations.Test;
import ru.yandex.rasp.selenium.model.RaspData;
import ru.yandex.rasp.selenium.model.TripData;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;

public class YandexRaspTests extends TestBase {


//  1. Открыть страницу yandex.ru.
//	2. Перейти на страницу сервиса «Расписания».
//  3. Найти электрички из Екатеринбурга в Каменск-Уральский на ближайшую субботу.
//  4. Проверить, что произведен поиск и название таблицы результатов соответствует параметрам поиска.
//  5. Сохранить данные о самом раннем рейсе, который отправляется не ранее 12:00 и билет на который стоит не более 200 р.
//	6. Вывести на консоль данные о рейсе, а именно:
//   · Время отправления
//	· Цена в рублях
//	· Цена в долларах
//    В случае отсутствия таких рейсов, вывести соответствующее сообщение.
//	7. Открыть страницу информации о рейсе.
//	8. Проверить, что данные о рейсе на странице информации соответствуют данным из пункта 5, а именно:
//            · Название таблицы
//	· Время и пункт отправления
//	· Время и пункт прибытия
//	· Время в пути

    @Test
    public void testYandexRasp(){
        RaspData raspData =  new RaspData("Екатеринбург", "Каменск-Уральский", app.getRaspHelper().nextDayOfWeek(SATURDAY), "Электричка");
        app.getNavigationHelper().goToRasp();
        app.getRaspHelper().selectDestinationsSearch(raspData);
        app.getRaspHelper().submitSearch();
        app.getTripHelper().getTripWithTime();
//        app.getTripHelper().сheckDestinations(raspData);
//        app.getRaspHelper().infoAboutTrip();
    }
}
