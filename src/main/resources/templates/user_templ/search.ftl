<div id="search">
    <div id="tab-1" class="tab-content" style="display:block;">

        <form id="dir" method="post" action="/timetable/">
            <div class="clearfix" style="padding: 1%">
                <div class="form-row">
                    <div class="form-column column-to">
                        <input type="text" name="dir_where" id="dir_where" value="" class="place ui-autocomplete-input required" autocomplete="off" aria-autocomplete="list" aria-haspopup="true" placeholder="Куди" data-required="Введіть станцію">
                        <input type="hidden" name="st_where_id" value="0" id="st_where_id">
                    </div>

                </div>
            </div>

            <div class="advanced advanced1 clearfix" style="display: block;">
                <div class="advanced_column advanced_column1">
                    <p>Час відправлення:</p>
                    <p>Час відправлення
                        <input type="text" name="dir_time_from" id="dir_time_from" value="" class="time timepicker hasTimepicker" pattern="[0-9]{2}:[0-9]{2}" title="Формат: години:хвилини">
                        <label for="start" style="margin-left: 20px">Дата</label>
                        <input type="date" id="start" name="trip-start" value="today" min="today" max="2024-12-31" /></p>
                </div>
            </div>

            <div class="tab_bottom clearfix">
                <div class="submit_container">
                    <input type="submit" name="dir_submit" id="dir_submit" value="Знайти" class="submit_search">
                </div>
            </div>
        </form>
    </div>
</div>
