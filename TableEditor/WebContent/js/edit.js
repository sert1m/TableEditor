
function send (param) {
	param ["id"] = document.getElementById("id").innerHTML;
	param ["firstName"] = document.getElementById("firstName").value;
	param ["lastName"] = document.getElementById("lastName").value;
	param ["sex"] = document.getElementById("sex").value;
	param ["date"] = document.getElementById("date").value;
	param ["job"] = document.getElementById("job").value;
	param ["salary"] = document.getElementById("salary").value;
	
	$$a({
		type: "get",
		url: "edit",
		data: param,
		response: "text",
		success: function(data) {
			document.location.href = "table.jsp";
		}
	})
}

function save() {

	var param = {};
	param ["type"] = "save";
	send(param);
}

function add() {

	var param = {};
	param ["type"] = "add";
	send(param);
}