var country = null;
var countryList = null;
var loading = false;

newCountry = () => {
	country = {
			id: null,
			name: "",
			code: ""
	}
}

getCountry = (id) => {
	country = null;
	loading = true;
	$.ajax({
		url: '/world/api/country/' + id,
		type: 'GET'
	}).done((data) => {
		loading = false;
		country = data;
	});
}

saveCountry = () => {
	loading = true;
	$.ajax({
		url: '/world/api/country/save',
		type: 'POST',
		contentType: 'application/json',
		dataType: 'json',
		data: JSON.stringify(country)
	}).done((data) => {
		loading = false;
		country = data;
	});
}

deleteCountry = () => {
	if (confirm('Sei sicuro di voler eliminare questa nazione?')) {
		loading = true;
		$.ajax({
			url: '/world/api/country/' + country.id,
			type: 'DELETE'
		}).done(() => {
			loading = false;
			getCountryList();
		});
	}
}

getCountryList = () => {
	countryList = null;
	loading = true;
	$.ajax({
		url: '/world/api/country/all',
		type: 'GET'
	}).done((data) => {
		loading = false;
		countryList = data;
		console.log(countryList);
		var innerHtml = '<ul>';
		for (var i=0; i<countryList.length; i++) {
			innerHtml += '<li>';
			innerHtml += '<a href="#" onclick="getCountry(' + countryList[i].id + ')">' + countryList[i].name + '</a>';
			innerHtml += '</li>';
		}
		innerHtml += '</ul>';
		$("#countryListDiv").html(innerHtml);
	});
}

$(document).ready(() => {
	country = null;
	getCountryList();
});