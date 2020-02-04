var country = null;
var countryList = null;

loading = (_loading) => {
	if (_loading) {
		$("#countryDiv").html('Loading...');
	} else {
		$("#countryDiv").html('');
	}
	$("#newCountryBtn").attr("disabled", _loading);
	if ($("#deleteCountryBtn") && $("#deleteCountryBtn").length) {
		$("#deleteCountryBtn").attr("disabled", _loading);
	}
}

newCountry = () => {
	country = {
			id: null,
			name: "",
			code: ""
	}
}

onCountryCodeChange = () => {
	var countryCode = $("#countryCode").value;
	country.code = countryCode;
}

onCountryNameChange = () => {
	var countryName = $("#countryName").value;
	country.name = countryName;
}

populateCountryDiv = (empty) => {
	if (empty) {
		$("#countryDiv").html('');
	} else {
		var innerHtml = 'Codice: <input type="text" id="countryCode" value="' + country.code + '" /> <br>';
		innerHtml += 'Nome: <input type="text" id="countryName" value="' + country.name + '" /> <br>';
		innerHtml += '<button id="deleteCountryBtn" onclick="deleteCountry()">Cancella Nazione</button> <br>';
		$("#countryDiv").html(innerHtml);
		$("#countryCode").addEventListener("keyup", onCountryCodeChange);
		$("#countryName").addEventListener("keyup", onCountryNameChange);
	}
}

populateCountryListDiv = (empty) => {
	if (empty) {
		$("#countryListDiv").html('');
	} else {
		var innerHtml = '<ul>';
		for (var i=0; i<countryList.length; i++) {
			innerHtml += '<li>';
			innerHtml += '<a href="#" onclick="getCountry(' + countryList[i].id + ')">' + countryList[i].name + '</a>';
			innerHtml += '</li>';
		}
		innerHtml += '</ul>';
		$("#countryListDiv").html(innerHtml);
	}
}

getCountry = (id) => {
	country = null;
	loading(true);
	$.ajax({
		url: '/world/api/country/' + id,
		type: 'GET'
	}).done((data) => {
		loading(false);
		country = data;
		populateCountryDiv(false);
	}).fail((error) => {
		console.log(error);
		loading(false);
	});
}

saveCountry = () => {
	loading(true);
	$.ajax({
		url: '/world/api/country/save',
		type: 'POST',
		contentType: 'application/json',
		dataType: 'json',
		data: JSON.stringify(country)
	}).done((data) => {
		loading(false);
		country = data;
	}).fail((error) => {
		console.log(error);
		loading(false);
	});
}

deleteCountry = () => {
	if (confirm('Sei sicuro di voler eliminare la nazione' + country.name + '?')) {
		loading(true);
		$.ajax({
			url: '/world/api/country/' + country.id,
			type: 'DELETE'
		}).done(() => {
			loading(false);
			populateCountryDiv(true);
			getCountryList();
		}).fail((error) => {
			console.log(error);
			loading(false);
		});
	}
}

getCountryList = () => {
	countryList = null;
	loading(true);
	$.ajax({
		url: '/world/api/country/all',
		type: 'GET'
	}).done((data) => {
		loading(false);
		countryList = data;
		populateCountryListDiv(false);
	}).fail((error) => {
		console.log(error);
		loading(false);
	});
}

$(document).ready(() => {
	country = null;
	getCountryList();
});