var country = null;
var countryList = null;

loading = (_loading) => {
	if (_loading) {
		$("#loadingDiv").html('Loading...');
	} else {
		$("#loadingDiv").html('');
	}
	$("#newCountryBtn").attr("disabled", _loading);
	if ($("#deleteCountryBtn") && $("#deleteCountryBtn").length) {
		$("#deleteCountryBtn").attr("disabled", _loading);
	}
	if ($("#saveCountryBtn") && $("#saveCountryBtn").length) {
		$("#saveCountryBtn").attr("disabled", _loading);
	}
}

newCountry = () => {
	country = {
			id: null,
			name: "",
			code: ""
	}
	populateCountryDiv(true);
}

onCountryCodeChange = () => {
	console.log($("#countryCode")[0]);
	var countryCode = $("#countryCode")[0].value;
	country.code = countryCode;
}

onCountryNameChange = () => {
	console.log($("#countryName")[0]);
	var countryName = $("#countryName")[0].value;
	country.name = countryName;
}

populateCountryDiv = (full) => {
	if (!full) {
		$("#countryDiv").html('');
	} else {
		var innerHtml = 'Codice: <input type="text" id="countryCode" value="' + country.code + '" /> <br>';
		innerHtml += 'Nome: <input type="text" id="countryName" value="' + country.name + '" /> <br>';
		innerHtml += '<button id="saveCountryBtn" onclick="saveCountry()">Salva</button> <br>';
		if (country.id) {
			innerHtml += '<button id="deleteCountryBtn" onclick="deleteCountry()">Cancella Nazione</button> <br>';
		}
		$("#countryDiv").html(innerHtml);
		$("#countryCode").keyup(onCountryCodeChange);
		$("#countryName").keyup(onCountryNameChange);
	}
}

populateCountryListDiv = (full) => {
	if (!full) {
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
		populateCountryDiv(true);
	}).fail((error) => {
		console.log(error);
		loading(false);
	});
}

saveCountry = () => {
	loading(true);
	$.ajax({
		url: '/world/api/country',
		type: 'POST',
		contentType: 'application/json',
		dataType: 'json',
		data: JSON.stringify(country)
	}).done((data) => {
		country = data;
		populateCountryDiv(true);
		getCountryList();
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
			populateCountryDiv(false);
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
		populateCountryListDiv(true);
	}).fail((error) => {
		console.log(error);
		loading(false);
	});
}

$(document).ready(() => {
	country = null;
	getCountryList();
});