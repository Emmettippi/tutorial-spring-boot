var city = null;
var cityList = null;
var loading = false;

newCity = () => {
    city = {
        id: null,
        name: "",
        population: null,
        countryId: null
    }
}

getCity = (id) => {
    city = null;
    loading = true;
    $.ajax({
        url: '/world/api/city/' + id,
        type: 'GET'
    }).done((data) => {
        loading = false;
        city = data;
    });
}

saveCity = () => {
    loading = true;
    $.ajax({
        url: '/world/api/city/save',
        type: 'POST'
    }).done((data) => {
        loading = false;
        city = data;
    });
}

deleteCity = () => {
    if (confirm('Sei sicuro di voler eliminare questa città?')) {
        loading = true;
        $.ajax({
            url: '/world/api/city/' + city.id,
            type: 'DELETE'
        }).done(() => {
            loading = false;
            getCityList();
        });
    }
}

getCityList = () => {
    cityList = null;
    loading = true;
    $.ajax({
        url: '/world/api/city/all',
        type: 'GET'
    }).done((data) => {
        loading = false;
        cityList = data;
    });
}

$(document).ready(() => {
    city = null;
    getCityList();
});