<div id="search">
    <div id="tab-1" class="tab-content" style="display:block;">

        <form class="d-flex" role="search" method="get" action="/search">
            <div class="clearfix" style="padding: 1%">
                <div class="form-row">
                    <div class="form-column column-to">
                        <p><input name="arrivalStation" type="search" placeholder="arrivalStation" aria-label="arrivalStation" data-required="Введіть станцію">
                            <label>З</label>
                            <input type="time" name="arrivalTime1" placeholder="arrivalTime" aria-label="arrivalTime" pattern="[0-9]{2}:[0-9]{2}" title="Формат: години:хвилини">
                            <label>По</label>
                            <input type="time" name="arrivalTime2" placeholder="arrivalTime" aria-label="arrivalTime" pattern="[0-9]{2}:[0-9]{2}" title="Формат: години:хвилини">
                            <label for="start" style="margin-left: 20px">Дата
                                <input type="date" id="start" name="arrivalDateTime" min="01.05.2024" max="31.12.2024">
                            </label>
                            <button class="btn btn-light" type="submit">Search</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
