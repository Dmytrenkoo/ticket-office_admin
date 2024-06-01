<#import "user_templ/search_menu.ftl" as p>
<@p.pages>
    <style> td{  text-align: center;}</style>
    <h2 class="title" >Розклад</h2>
    <div class="row g-4 justify-content-center">
        <div class="col-10">
            <div class="table-bordered">
                <table role="presentation" class="table table-bordered border-primary tall-row" >
                    <thead>
                    <tr>
                        <th scope="col">№ потяга</th>
                        <th scope="col">Дата</th>
                        <th scope="col">Час посадки-прибуття</th>
                        <th scope="col">Маршрут</th>
                        <th scope="col">Тривалість подорожі</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <#if timetable??>
                    <#list timetable as thr1>
                    <tbody>
                    <tr>
                        <th scope="row"> ${thr1.trains.id} </th>
                        <td> ${thr1.arrivalDateTime?string("dd.MM.yyyy")} </td>
                        <td> ${thr1.departureTime} - ${thr1.arrivalDateTime?string("HH:mm")} </td>
                        <td> ${thr1.routes.departureStation} - ${thr1.routes.arrivalStation} </td>
                        <td> ${thr1.routes.travelTime} годин</td>
                        <td>
                            <a class="btn btn-primary" href="/timetable/${thr1.trains.id}" role="button">Квитки</a>
                        </td>
                    </tr>
                    </#list>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@p.pages>

